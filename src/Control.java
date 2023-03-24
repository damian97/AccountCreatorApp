import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Control {

    private String urlAddress;
    private Robot robot;

    private int autoDelay;
    private int delayBetweenPressRelease;

    /**
     * @param urlAddress enter the address to open
     * @param openBrowser set true if you want to open browser
     */

    public Control(String urlAddress, boolean openBrowser) {

        setUrlAddress(urlAddress);

        if (openBrowser) {
            getUrl(this.urlAddress);
        }

        try {
            robot = new Robot();
            autoDelay = 50;
            delayBetweenPressRelease = 250;
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }


    public void setDelayBetweenPressRelease(int delayBetweenPressRelease) {
        this.delayBetweenPressRelease = delayBetweenPressRelease;
    }


    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public void setAutoDelay(int delay) {
        this.autoDelay = delay;
        robot.setAutoDelay(delay);
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void getUrl(String urlAddress) {

        try {
            Desktop.getDesktop().browse(new URI(urlAddress));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }


    public void enterKey(KeyNames keyNames, int numberClicks) {

        for (int i = 0; i < numberClicks; i++) {
            switch (keyNames) {
                case Tab:
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.delay(delayBetweenPressRelease);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    break;
                case Enter:
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.delay(delayBetweenPressRelease);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    break;
                case At:
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    break;
                case Space:
                    robot.keyPress(KeyEvent.VK_SPACE);
                    robot.delay(delayBetweenPressRelease);
                    robot.keyRelease(KeyEvent.VK_SPACE);
                    break;
            }
        }

        sleep(500);
    }

    public void enterString(String string) {

        for (int i = 0; i < string.length(); i++) {
            char tmpChar = string.charAt(i);
            if (tmpChar >= 65 && tmpChar <= 90) {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(tmpChar));
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(tmpChar));
            } else {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(tmpChar));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(tmpChar));
            }
        }

    }

    public void enterOptionPane(int value) {
        for (int i = 0; i < value; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.delay(100);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.delay(250);
        }
    }

    public void copyText() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
    }


}
