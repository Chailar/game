import java.awt.*;

public class FreshThread extends Thread {
    private Robot robot;
    private int miles;

    public FreshThread(int miles) {
        try {
            this.robot = new Robot();
            this.miles = miles;
        } catch (AWTException error) {
        }
    }

    @Override
    public void run() {
        while (true) {
            Mouse.pressJ(robot, 1, miles);
            Mouse.pressL(robot, miles);
        }
    }
}
