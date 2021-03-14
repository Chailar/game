import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document;

import java.io.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener, DocumentListener {
    private JTextField text[];
    private JButton button[];
    private static String str[] = { "现有的数量", "总共需要量" };
    private JPanel panel[];
    private JLabel label;
    private JComboBox<String> box;
    public static String strings[] = { "幻象之魂", "雪花", "杀戮之气", "混乱之源", "混沌牙齿", "饕餮脊骨", "攻击珠", "命中珠", "暴击珠" };
    public static String number[] = { "30", "90", "160", "80", "300", "150", "25", "325", "185" };
    public int num[];

    public MainFrame() {
        super("材料计算器");
        Dimension dim = this.getToolkit().getScreenSize();
        this.setBounds((int) dim.getWidth() / 2 - 100, (int) dim.getHeight() / 2 - 175, 300, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));
        this.panel = new JPanel[4];
        for (int i = 0; i < 4; i++) {
            panel[i] = new JPanel();
            this.add(panel[i]);
        }
        this.text = new JTextField[2];
        panel[0].setLayout(new GridLayout(1, 2));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2));
        this.panel[0].add(jPanel);
        for (int i = 0; i < 2; i++) {
            jPanel.add(new JLabel(str[i]));
            jPanel.add(text[i] = new JTextField("0", 4));
        }
        Document dt = this.text[0].getDocument();
        dt.addDocumentListener(this);
        text[1].setText(number[0]);
        num = new int[strings.length];
        try {
            FileInputStream in = new FileInputStream(FirstFrame.path);
            DataInputStream fileIn = new DataInputStream(in);
            for (int i = 0; i < strings.length; i++)
                num[i] = fileIn.readInt();
        } catch (FileNotFoundException exception) {
            FirstFrame frame = new FirstFrame();
            if (frame.m == -1)
                return;
        } catch (Exception e) {
            // System.out.println(e.getMessage());
        }
        this.panel[0].add(label = new JLabel("状态:未完成"));
        this.panel[1].add(new JLabel("正在搜集的资源是:"));
        this.box = new JComboBox<String>();
        for (int i = 0; i < strings.length; i++)
            this.box.addItem(strings[i]);
        this.box.addActionListener(this);
        this.panel[1].add(this.box);
        this.panel[2].add(new JLabel("本次获得的资源数为"));
        this.panel[3].setLayout(new GridLayout(1, 5));
        this.button = new JButton[5];
        for (int i = 1; i < 6; i++) {
            this.button[i - 1] = new JButton(Integer.toString(i));
            this.button[i - 1].addActionListener(this);
            this.panel[3].add(button[i - 1]);
        }
        this.text[0].setText(num[0] + "");
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    FileOutputStream out = new FileOutputStream(new File(FirstFrame.path));
                    DataOutputStream fileOut = new DataOutputStream(out);
                    for (int i = 0; i < strings.length; i++)
                        fileOut.writeInt(num[i]);
                    fileOut.close();
                    out.close();
                } catch (IOException exception) {
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }
        });
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.box) {
            this.text[0].setText(num[this.box.getSelectedIndex()] + "");
            this.text[1].setText(number[this.box.getSelectedIndex()]);
        }

        if (e.getSource() == this.button[0]) {
            this.text[0].setText(Integer
                    .toString(Integer.parseInt(this.text[0].getText()) + Integer.parseInt(this.button[0].getText())));
            num[this.box.getSelectedIndex()] += Integer.parseInt(this.button[0].getText());
        }
        if (e.getSource() == this.button[1]) {
            this.text[0].setText(Integer
                    .toString(Integer.parseInt(this.text[0].getText()) + Integer.parseInt(this.button[1].getText())));
            num[this.box.getSelectedIndex()] += Integer.parseInt(this.button[1].getText());
        }
        if (e.getSource() == this.button[2]) {
            this.text[0].setText(Integer
                    .toString(Integer.parseInt(this.text[0].getText()) + Integer.parseInt(this.button[2].getText())));
            num[this.box.getSelectedIndex()] += Integer.parseInt(this.button[2].getText());
        }
        if (e.getSource() == this.button[3]) {
            this.text[0].setText(Integer
                    .toString(Integer.parseInt(this.text[0].getText()) + Integer.parseInt(this.button[3].getText())));
            num[this.box.getSelectedIndex()] += Integer.parseInt(this.button[3].getText());
        }
        if (e.getSource() == this.button[4]) {
            this.text[0].setText(Integer
                    .toString(Integer.parseInt(this.text[0].getText()) + Integer.parseInt(this.button[4].getText())));
            num[this.box.getSelectedIndex()] += Integer.parseInt(this.button[4].getText());
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (Integer.parseInt(text[0].getText()) >= Integer.parseInt(text[1].getText()))
            label.setText("状态:已完成");
        else
            label.setText("状态:未完成");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (text[0].getText().length() != 0) {
            if (Integer.parseInt(text[0].getText()) >= Integer.parseInt(text[1].getText()))
                label.setText("状态:已完成");
            else
                label.setText("状态:未完成");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // if (Integer.parseInt(text[0].getText()) >=
        // Integer.parseInt(text[1].getText()))
        // label.setText("状态:已完成");
        // else
        // label.setText("状态:未完成");
    }
}
