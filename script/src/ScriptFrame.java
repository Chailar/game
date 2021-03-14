import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScriptFrame extends JFrame implements ActionListener {
    private JButton[] button;
    private String str[] = { "普通刷", "不用u", "刷行酒令", "停止" };
    private Thread thread;
    private JPanel panelIn;
    private JTextField text;

    // 普通刷 jjjlujjjijjjo
    // 不用u jjjijjjlo
    // 停止 jl
    public ScriptFrame() {
        super("神将世界脚本");
        Dimension dim = this.getToolkit().getScreenSize();
        this.setBounds((int) dim.getWidth() / 2 - 200, (int) dim.getHeight() / 2 - 150, 400, 280);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        button = new JButton[str.length];
        for (int i = 0; i < str.length; i++) {
            button[i] = new JButton(str[i]);
            button[i].addActionListener(this);
        }
        this.setLayout(new GridLayout(1, 2, 100, 50));
        JPanel panel = new JPanel();
        panelIn = new JPanel();
        panelIn.setLayout(new GridLayout(1, 2));
        panel.setLayout(new GridLayout(4, 1, 0, 10));
        this.getContentPane().add(panel);
        panel.add(panelIn);
        panelIn.add(new JLabel("延时数/毫秒"));
        panelIn.add(text = new JTextField("500"));
        text.addActionListener(this);
        panel.add(button[0]);
        panel.add(button[1]);
        panel.add(button[2]);
        this.getContentPane().add(button[3]);
        button[3].setEnabled(false);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "普通刷") {
            button[3].setEnabled(true);
            text.setEditable(false);
            for (int i = 0; i < 3; i++)
                button[i].setEnabled(false);
            thread = new CommonThread(Integer.parseInt(text.getText()));
            thread.start();
        }
        if (e.getActionCommand() == "停止") {
            thread.stop();
            button[3].setEnabled(false);
            text.setEditable(true);
            for (int i = 0; i < 3; i++)
                button[i].setEnabled(true);
        }
        if (e.getActionCommand() == "刷行酒令") {
            button[3].setEnabled(true);
            text.setEditable(false);
            for (int i = 0; i < 3; i++)
                button[i].setEnabled(false);
            thread = new FreshThread(Integer.parseInt(text.getText()));
            thread.start();
        }
        if (e.getActionCommand() == "不用u") {
            button[3].setEnabled(true);
            text.setEditable(false);
            for (int i = 0; i < 3; i++)
                button[i].setEnabled(false);
            thread = new SpecialThread(Integer.parseInt(text.getText()));
            thread.start();
        }
    }

    public static void main(String[] args) {
        new ScriptFrame();
    }
}
