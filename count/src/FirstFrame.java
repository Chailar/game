import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class FirstFrame extends JFrame implements ActionListener {
    private JTextField text[];
    private JButton button;
    public int m;
    public static String path = ".\\1.txt";

    public FirstFrame() {
        super("请输入初始材料数");
        this.m = -1;
        Dimension dim = this.getToolkit().getScreenSize();
        this.setBounds((int) dim.getWidth() / 2 - 150, (int) dim.getHeight() / 2 - 300, 300, 600);
        this.setLayout(new GridLayout(MainFrame.strings.length + 1, 2));
        text = new JTextField[MainFrame.strings.length];
        for (int i = 0; i < MainFrame.strings.length; i++) {
            this.add(new JLabel(MainFrame.strings[i] + " :"));
            text[i] = new JTextField("0", 5);
            this.add(text[i]);
        }
        this.add(button = new JButton("提交"));
        button.addActionListener(this);
        this.add(new JLabel());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            FileOutputStream out = new FileOutputStream(new File(path));
            DataOutputStream fileOut = new DataOutputStream(out);
            for (int i = 0; i < MainFrame.strings.length; i++) {
                try {
                    int j = Integer.parseInt(text[i].getText());
                    fileOut.writeInt(j);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(this, (String) text[i].getText() + "不是整数，请修改");
                    break;
                }
                fileOut.close();
                out.close();
            }
        } catch (IOException exception) {
        }
        this.m = 1;
        dispose();
    }

    public static void main(String[] args) {
        new FirstFrame();
    }
}
