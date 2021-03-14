import java.awt.*;
import java.awt.event.KeyEvent;

public class Mouse {

    public static void pressJ(Robot robot, int i, int delay) {
        for (int j = 0; j < i; j++) {
            robot.keyPress(KeyEvent.VK_J);
            robot.delay(80);
            robot.keyRelease(KeyEvent.VK_J);
            robot.delay(delay);
        }
    }

    public static void pressU(Robot robot, int delay) {
        robot.keyPress(KeyEvent.VK_U);
        robot.delay(80);
        robot.keyRelease(KeyEvent.VK_U);
        robot.delay(delay);
    }

    public static void pressI(Robot robot, int delay) {
        robot.keyPress(KeyEvent.VK_I);
        robot.delay(80);
        robot.keyRelease(KeyEvent.VK_I);
        robot.delay(delay);
    }

    public static void pressO(Robot robot, int delay) {
        robot.keyPress(KeyEvent.VK_O);
        robot.delay(80);
        robot.keyRelease(KeyEvent.VK_O);
        robot.delay(delay);
    }

    public static void pressL(Robot robot, int delay) {
        robot.keyPress(KeyEvent.VK_L);
        robot.delay(80);
        robot.keyRelease(KeyEvent.VK_L);
        robot.delay(delay);
    }
}
