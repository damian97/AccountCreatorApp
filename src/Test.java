import java.awt.*;
import java.awt.event.KeyEvent;

public class Test {


    public static void main(String[] args) {


        String link = "https://www.tibia.com/account/?subtopic=createaccount&step=confirmaccount&email=ZGFyaXVzei5zemV3Y3p5azMwN0BvMi5wbA==&confirmationkey=g6zvhd3abvzwymns1wov";


        try {
            Robot bot = new Robot();

            bot.delay(2000);


            for (int i = 0; i < link.length(); i++) {

                char znak = link.charAt(i);

                if (znak == ':') {
                    bot.keyPress(KeyEvent.VK_SHIFT);
                    bot.keyPress(KeyEvent.VK_SEMICOLON);
                    bot.keyRelease(KeyEvent.VK_SEMICOLON);
                    bot.keyRelease(KeyEvent.VK_SHIFT);
                } else if (znak == '?') {
                    bot.keyPress(KeyEvent.VK_SHIFT);
                    bot.keyPress(KeyEvent.VK_SLASH);
                    bot.keyRelease(KeyEvent.VK_SLASH);
                    bot.keyRelease(KeyEvent.VK_SHIFT);
                } else if (znak == '&') {

                    bot.keyPress(KeyEvent.VK_SHIFT);
                    bot.keyPress(KeyEvent.VK_7);
                    bot.keyRelease(KeyEvent.VK_7);
                    bot.keyRelease(KeyEvent.VK_SHIFT);

                } else {

                    bot.keyPress(KeyEvent.getExtendedKeyCodeForChar(znak));
                    bot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(znak));

                }
            }

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


    }
}
