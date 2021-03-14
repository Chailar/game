import java.awt.*;

public class SpecialThread extends Thread {
    private Robot robot;
    private int miles;

    public SpecialThread(int miles) {
        try {
            this.robot = new Robot();
            this.miles = miles;
        } catch (AWTException error) {
        }
    }

    @Override
    public void run() {
        while (true) {
            Mouse.pressJ(robot, 3, miles);
            Mouse.pressI(robot, miles);
            Mouse.pressJ(robot, 3, miles);
            Mouse.pressL(robot, miles);
            Mouse.pressO(robot, miles);
        }
    }
}
