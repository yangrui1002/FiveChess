package chess;

/**
 * Created by YR on 2018/12/23.
 */
import java.awt.*;

public class FIRPointBlack extends Canvas {
    fivechess padBelonged; // 黑棋所属的棋盘

    public FIRPointBlack(fivechess padBelonged)
    {
        setSize(20, 20); // 设置棋子大小
        this.padBelonged = padBelonged;
    }

    public void paint(Graphics g)
    { // 画棋子
        g.setColor(Color.black);
        g.fillOval(0, 0, 14, 14);
    }
}

