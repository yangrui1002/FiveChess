package User;

import javax.swing.*;
import java.awt.*;
/**
 * Created by YR on 2018/12/23.
 */
public class index extends JPanel{
    public JLabel ipLabel = new JLabel("IP",JLabel.LEFT);
    public JTextField ipInputted = new JTextField("localhost",10);
    public JButton connectButton = new JButton("连接到服务器");
    public JButton createButton = new JButton("创建游戏");
    public JButton joinButton = new JButton("加入游戏");
    public JButton cancelButton = new JButton("放弃游戏");
    public JButton exitButton = new JButton("退出游戏");

    public index(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.LIGHT_GRAY);
        add(ipLabel);
        add(ipInputted);
        add(connectButton);
        add(createButton);
        add(joinButton);
        add(cancelButton);
        add(exitButton);
    }

}
