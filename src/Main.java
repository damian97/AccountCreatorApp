import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        JFrame mainFraim = new JFrame("Account Creator App");

        MyGUI gui = new MyGUI();

        mainFraim.add(gui);

        mainFraim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFraim.setLocationRelativeTo(null);
        mainFraim.setVisible(true);
        mainFraim.pack();


    }
}




class Operations{


    String urlO2 = "https://poczta.o2.pl/rejestracja";
    String urlO2Login = "https://poczta.o2.pl/login/login.html";
    String urlTibia = "https://www.tibia.com/mmorpg/free-multiplayer-online-role-playing-game.php";

    String backupEmail, backupAddress;
    String charName;
    int delay = 50;

    public void start() {

        User user = new User();
        user.printUser();
        Control control = new Control(urlO2, true);
        control.setAutoDelay(delay);
        control.sleep(5000);

        //step 1/4
        control.enterKey(KeyNames.Tab, 3);
        control.enterString(user.getfName());
        control.enterKey(KeyNames.Tab, 1);
        control.enterString(user.getsName());
        control.enterKey(KeyNames.Tab, 1);
        control.enterString(user.getNickName());
        control.enterKey(KeyNames.Tab, 1);
        control.enterOptionPane(user.getGender());
        control.enterKey(KeyNames.Tab, 1);
        control.enterString(user.getDay());
        control.enterKey(KeyNames.Tab, 1);
        control.enterOptionPane(user.getMonth());
        control.enterKey(KeyNames.Tab, 1);
        control.enterString(user.getYear());
        control.sleep(2000);
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(1000);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(2000);

        //step 2/4
        for (int i = 0; i < 2; i++) {
            control.enterKey(KeyNames.Tab, 1);
            control.enterString(user.getPass());
            control.sleep(500);
        }
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(2000);

        //step 3/4
        control.enterKey(KeyNames.Tab, 1);
        control.enterString(backupEmail);
        control.enterKey(KeyNames.At, 1);
        control.enterString(backupAddress);
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(2000);

        //step 4/4
        control.enterKey(KeyNames.Tab, 2);
        control.enterKey(KeyNames.Space, 1);

        control.enterKey(KeyNames.Tab, 20);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(2000);




        // Tibia

        control = new Control(urlTibia, true);
        control.setAutoDelay(delay);
        control.sleep(2000);

        control.enterKey(KeyNames.Tab, 1);
        control.enterString(user.getNickName());
        control.enterKey(KeyNames.At, 1);
        control.enterString("o2.pl");
        control.enterKey(KeyNames.Tab, 1);
        control.enterString(user.getPass());
        control.enterKey(KeyNames.Tab, 1);
        control.copyText();
        setCharName(copyClipboar());
        control.enterKey(KeyNames.Tab, 12);
        control.enterKey(KeyNames.Enter,1);


    }


    public void startTibia() {


        User user = new User();
        user.printUser();
        Control control = new Control(urlTibia, true);
        control.setAutoDelay(delay);
        control.sleep(5000);

        control.enterKey(KeyNames.Tab, 1);
        control.enterString(user.getNickName());
        control.enterKey(KeyNames.At, 1);
        control.enterString("o2.pl");
        control.enterKey(KeyNames.Tab, 1);
        control.enterString(user.getPass());
        control.enterKey(KeyNames.Tab, 1);
        control.copyText();
        setCharName(copyClipboar());
        control.enterKey(KeyNames.Tab, 12);
        control.enterKey(KeyNames.Enter,1);






    }



    public void startLogin() {


        Control control = new Control(urlO2Login, true);
        control.setAutoDelay(delay);
        control.sleep(2000);
        control.enterKey(KeyNames.Tab, 3);
        control.enterString("grzegorz.wojcik399");
        control.enterKey(KeyNames.Tab, 1);
        control.enterString("Wojcik55CA7i");
        control.enterKey(KeyNames.Tab, 1);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(3000);   // dodac metode na znajdowanie wiadomosci

        control.copyAll();

        //wyluskac link





    }



    public void setBackupEmail(String backupEmail) {
        this.backupEmail = backupEmail;
    }

    public void setBackupAddress(String backupAddress) {
        this.backupAddress = backupAddress;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharName() {
        return charName;
    }


            // do poprawy, pierwszy email losuj albo pobieraj z pola
            // nastepny email zapisz jako nowo utworzony i wykorzystaj itd.
    public String randomBackupMail() {
        String[] usernames = {"darodjak", "rharper419", "jlopez352", "amcdonald885", "esmith797",
                "nphillips436", "jgonzalez152", "lramirez719", "jreed468", "kgomez367"};

        Random rand = new Random();
        String email = usernames[rand.nextInt(usernames.length)];
        return email;
    }

    public String randomBackupAddress() {
        String[] userAddress = {"o2.pl", "onet.pl", "interia.pl", "wp.pl", "opoczta.pl"};

        Random rand = new Random();
        String address = userAddress[rand.nextInt(userAddress.length)];
        return address;
    }


    public String copyClipboar() {
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
        return result;
    }

}