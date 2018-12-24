package client;

/**
 * Created by YR on 2018/12/23.
 */
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 * Created by Administrator on 2016/11/21.
 */
public class FIRClientThread extends Thread{
    public FIRClient firClient;

    public FIRClientThread(FIRClient firClient)
    {
        this.firClient = firClient;
    }

    public void dealWithMsg(String msgReceived)
    {
        if (msgReceived.startsWith("/yourname "))
        { // 收到的信息为用户本名时
            firClient.chessClientName = msgReceived.substring(10); // 取得用户本名
            firClient.setTitle("Java 五子棋客户端 " + "用户名:"
                    + firClient.chessClientName); // 设置程序Frame的标题
        }
        else if (msgReceived.equals("/reject"))
        { // 收到的信息为拒绝用户时
            try
            {
                firClient.firPad.statusText.setText("不能加入游戏!");
                firClient.userControlPad.cancelButton.setEnabled(false);
                firClient.userControlPad.joinButton.setEnabled(true);
                firClient.userControlPad.createButton.setEnabled(true);
            }
            catch (Exception ef)
            {

            }
            firClient.userControlPad.joinButton.setEnabled(true);
        }
        else if (msgReceived.startsWith("/peer"))
        { // 收到信息为游戏中的等待时
            firClient.firPad.chessPeerName = msgReceived.substring(6);
            if (firClient.isCreator)
            { // 若用户为游戏建立者
                firClient.firPad.chessColor = 1; // 设定其为黑棋先行
                firClient.firPad.isMouseEnabled = true;
                firClient.firPad.statusText.setText("黑方下...");
            }
            else if (firClient.isParticipant)
            { // 若用户为游戏加入者
                firClient.firPad.chessColor = -1; // 设定其为白棋后性
                firClient.firPad.statusText.setText("游戏加入，等待对手.");
            }
        }
        else if (msgReceived.equals("/youwin"))
        { // 收到信息为胜利信息
            firClient.isOnChess = false;
            firClient.firPad.setVicStatus(firClient.firPad.chessColor);
            firClient.firPad.statusText.setText("对手退出");
            firClient.firPad.isMouseEnabled = false;
        }
        else if (msgReceived.equals("/OK"))
        { // 收到信息为成功创建游戏
            firClient.firPad.statusText.setText("游戏创建等待对手");
        }

    }

    public void run()
    {
        String message = "";
        try
        {
            while (true)
            {
                // 等待聊天信息，进入wait状态
                message = firClient.inputStream.readUTF();
                dealWithMsg(message);
            }
        }
        catch (IOException es){}
    }
}