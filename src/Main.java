
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
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

    final String urlO2 = "https://poczta.o2.pl/rejestracja";
    final String urlO2Login = "https://poczta.o2.pl/login/login.html";
    final String urlTibia = "https://www.tibia.com/mmorpg/free-multiplayer-online-role-playing-game.php";
    private String activationLink;

    private String rKey;

    private String backupEmail, backupAddress;
    private String charName;
    int delay = 50;


    Color[] blueButton = {
            new Color(0, 141, 255), // my PC
            new Color(61, 139, 247)  // my Laptop
    };

    Color[] emailsSeparator = {
            new Color(229, 229, 229), // my PC
            new Color(242, 242, 242), // my Laptop
            new Color(239, 239, 239) // Sebka Laptop
    };

    public void start() {

        User user = new User();
        user.printUser();
        Control control = new Control(urlO2, true);
        control.setAutoDelay(delay);
        control.sleep(8000);



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
        control.sleep(1000);



        // o2 Login incognito


        control = new Control(urlO2Login, true);
        control.sleep(4000);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(2000);
        control.reverseTab(8);
        control.sleep(1000);
        control.enterString(user.getNickName());
//        control.enterString("iga.pawlowski341");
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(1000);
        control.enterString(user.getPass());
//        control.enterString("Pawlowski15MG8k");
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(6000);


        // sprawdzenie czy wyskoczylo okno

        System.out.println("Sprawdzam okno");

        // mozliwe ze wyskoczylo okno wiec zamykam i sprawdzam czy jest o2 is focused

        System.out.println("A window appeared?");           // to trzeba jeszcze dopiescic
        control.reverseTab(1);
        control.sleep(1000);
        control.enterKey(KeyNames.Enter, 2);
        control.sleep(1000);

        if (!control.isO2OnScreen(blueButton)) {
            control.sleep(500);
            control.closePage();
        }

        control.sleep(1000);

        if (!control.isO2OnScreen(blueButton)) {
            System.err.println("Mail not displayed");
            throw new RuntimeException();
        }


        // o2 get Confrimation Link
                     //to mozna dodac jesli nie znajdzie bez wyszukiwania
        control.sleep(1000);

        //metoda na znajdowanie maila

        control.openMessage(emailsSeparator, 5);


        //////////////////////////////

        control.sleep(2000);
        control.copyAll();
        control.sleep(1000);
        setActivationLink(control.getActivationLinkFromContent());


        Control rKey = new Control(urlO2, true);    // true do zmiany ?? test czy dziala
        control.sleep(2000);
        control.newPage();
        control.sleep(1500);
        control.enterString(getActivationLink());
        control.sleep(1500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(3000);



        rKey.sleep(4000);


        rKey.copyAll();
        rKey.sleep(1000);

        String klucz = rKey.getRKeyFromContent();

        System.out.println("dupa");
        System.out.println(klucz);
        setrKey(klucz);
        System.out.println("dupa");
        control.enterKey(KeyNames.Tab, 11);
        control.sleep(500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(1000);
        control.enterKey(KeyNames.Tab, 11);
        control.sleep(500);
        rKey.enterRKey(getrKey());
        control.sleep(500);
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(1000);



        // save data to file

        try {
            FileWriter fileWriter = new FileWriter("Login_Data.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write(getCharName());
            bufferedWriter.newLine();
            bufferedWriter.write(user.getNickName() + "@o2.pl");
            bufferedWriter.newLine();
            bufferedWriter.write(user.getPass());

            bufferedWriter.close();
            fileWriter.close();
        } catch(IOException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }


    }




    public void setrKey(String rKey) {
        this.rKey = rKey;
    }

    public String getrKey() {
        return rKey;
    }

    public String getActivationLink() {
        return activationLink;
    }

    public void setActivationLink(String activationLink) {
        this.activationLink = activationLink;
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
        String[] usernames = {"AnetaD", "TomaszC", "AnnaS34", "Damians"};

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