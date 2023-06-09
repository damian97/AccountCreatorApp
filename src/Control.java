import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
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


    public void getUrlIncognito(String urlAddress, String pathToBrowser) {

        ProcessBuilder processBuilder = new ProcessBuilder(pathToBrowser, "--incognito", urlAddress);
        try {
            processBuilder.start();

        } catch (IOException e) {
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


    public void reverseTab(int numberClicks) {

        for (int i = 0; i < numberClicks; i++) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.delay(delayBetweenPressRelease);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

    }


    public void enterString(String string) {

        for (int i = 0; i < string.length(); i++) {
            char tmpChar = string.charAt(i);
            if (tmpChar >= 65 && tmpChar <= 90) {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(tmpChar));
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(tmpChar));
            } else if (tmpChar == ':') {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            } else if (tmpChar == '?') {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            } else if (tmpChar == '&') {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_7);
                robot.keyRelease(KeyEvent.VK_7);
                robot.keyRelease(KeyEvent.VK_SHIFT);
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

    public void pasteText() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
    }

    public void copyAll() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        robot.delay(500);
        copyText();
    }

    public void newPage() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        robot.delay(500);
    }

    public void closePage() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.delay(500);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_W);
        robot.delay(500);
    }


    public void mouseMovie(int x, int y) {
        robot.mouseMove(x, y);
    }

    public void mousePress(MouseButton mouseButton) {

        switch (mouseButton) {
            case Left:
                robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                robot.delay(delayBetweenPressRelease);
                robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                break;
            case Right:
                robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
                robot.delay(delayBetweenPressRelease);
                robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
                break;
            case Scroll:
                robot.mousePress(MouseEvent.BUTTON2_DOWN_MASK);
                robot.delay(delayBetweenPressRelease);
                robot.mouseRelease(MouseEvent.BUTTON2_DOWN_MASK);
                break;
        }


    }

    public void printScreen() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);

        BufferedImage screen = robot.createScreenCapture(rectangle);
        try {
            ImageIO.write(screen, "png", new File("screenshot.png"));
        } catch (IOException e) {
            System.err.println("Błąd zapisu obrazu");
            e.printStackTrace();
        }
    }



    public void openMessage(Color[] colors, int correct) {
        if (isMessage(colors, correct)) {
            mousePress(MouseButton.Left);
            robot.delay(500);
        } else {
            System.out.println("Message not found! Another test");
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            robot.delay(500);


            if (isMessage(colors, correct)) {
                mousePress(MouseButton.Left);
                robot.delay(500);
            } else {
                System.out.println("Message not found!");
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                robot.delay(500);

                throw new RuntimeException();

            }

        }



    }

    public boolean isMessage(Color[] colors, int correct) {

        printScreen();

        try {
            BufferedImage screen = ImageIO.read(new File("screenshot.png"));
            int width = screen.getWidth() / 2;
            int height = screen.getHeight();

            for (int y = 0; y < height-1; y++) {

                int tmpColor = screen.getRGB(width, y);
                for (int z = 0; z < colors.length; z++) {
                    int pixelColor = colors[z].getRGB();
                    if (tmpColor == pixelColor) {
                        mouseMovie(width, y+correct);
                        return true;
                    }


                }

            }




        } catch (IOException e) {
            System.err.println("File doesn't exist");
            throw new RuntimeException(e);
        }


        return false;
    }



    public boolean isO2OnScreen(Color[] colors) {

        printScreen();

        try {
            BufferedImage screen = ImageIO.read(new File("screenshot.png"));
            int width = screen.getWidth();
            int height = screen.getHeight();

            for (int y = 0; y < height-1; y++) {
                for (int x = 0; x < width-1; x++) {

                    int tmpColor = screen.getRGB(x, y);
                    for (int z = 0; z < colors.length; z++) {
                        int pixelColor = colors[z].getRGB();
                        if (tmpColor == pixelColor) {
                            return true;
                        }
                    }


                }
            }

        } catch (IOException e) {
            System.err.println("File doesn't exist");
            throw new RuntimeException(e);
        }


        return false;
    }



    public String getActivationLinkFromContent() {
        String activationLink = "https://www.tibia.com/account/";
        String contentMessage = null;
        boolean addChar = false;

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            contentMessage = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int lenght = contentMessage.length();
        char[] urlCharArray = activationLink.toCharArray();

        for (int i = 0, j = 0; i < lenght; i++) {
            char tmpChar = contentMessage.charAt(i);
            if (tmpChar == urlCharArray[j] && !addChar) {
                if (j >= urlCharArray.length-1) {
                    addChar = true;
                    tmpChar = contentMessage.charAt(++i);
                } else {
                    j++;
                }
            } else {
                j = 0;
            }

            if (addChar) {
                activationLink = activationLink + tmpChar;
                if (tmpChar == '\n') {
                    break;
                }
            }

        }



        return activationLink;
    }


    public void refresh() {
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_F5);
        robot.keyRelease(KeyEvent.VK_F5);

        robot.delay(1000);
    }

    public String getRKeyFromContent() {
        String rKey = " ";

        Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable data = board.getContents(null);

        if (data != null && data.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            String clipboardContents = null;
            try {
                clipboardContents = (String) data.getTransferData(DataFlavor.stringFlavor);

                String[] lines = clipboardContents.split("\n");

                for (String line : lines) {
                    System.out.println(line);
                    if (line.contains("-")) {
                        rKey = line;
                    }
                }



            } catch (UnsupportedFlavorException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Clipboard does not contain a string");
        }

        return rKey;
    }




    public void enterRKey(String rKey) {

        for (int i = 0; i < rKey.length(); i++) {
            if (rKey.charAt(i) == '-') {
                enterKey(KeyNames.Tab,1);
            } else {
                enterString(String.valueOf(rKey.charAt(i)));
            }
        }

    }


    public void copyToClipboard(String string) {

        StringSelection activationLink = new StringSelection(string);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(activationLink, null);

    }

    public void cleanClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(""), null);

    }


    public String clipboardToString() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();

        String result = null;
        try {
            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("String from Clipboard: " + result);
        return result;
    }


}
