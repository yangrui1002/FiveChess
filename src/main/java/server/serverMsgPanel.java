package server;

/**
 * Created by YR on 2018/12/23.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JLabel;

/**
 * Created by Administrator on 2016/11/21.
 */
public class serverMsgPanel extends Panel {
    public TextArea msgTextArea = new TextArea("", 22, 50,
            TextArea.SCROLLBARS_VERTICAL_ONLY);
    public JLabel statusLabel = new JLabel("当前连接数:", Label.LEFT);
    public Panel msgPanel = new Panel();
    public Panel statusPanel = new Panel();
    public serverMsgPanel()
    {
        setSize(350, 300);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        msgPanel.setLayout(new FlowLayout());
        msgPanel.setSize(210, 210);
        statusPanel.setLayout(new BorderLayout());
        statusPanel.setSize(210, 50);
        msgPanel.add(msgTextArea);
        statusPanel.add(statusLabel, BorderLayout.WEST);
        add(msgPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.NORTH);
    }

}

