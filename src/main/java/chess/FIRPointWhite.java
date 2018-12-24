package chess;

/**
 * Created by YR on 2018/12/23.
 */
import java.awt.*;

public class FIRPointWhite extends Canvas{
    fivechess padBelonged; // 白棋所属的棋盘

    public FIRPointWhite(fivechess padBelonged)
    {
        setSize(20, 20);
        this.padBelonged = padBelonged;
    }

    public void paint(Graphics g)
    { // 画棋子
        g.setColor(Color.white);
        g.fillOval(0, 0, 14, 14);
    }
}
