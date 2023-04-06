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


    String browserPath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; //ścieżka do przeglądarki, zmień ją na odpowiednią dla swojego systemu

    String urlO2 = "https://poczta.o2.pl/rejestracja";
    String urlO2Login = "https://poczta.o2.pl/login/login.html";
    String urlTibia = "https://www.tibia.com/mmorpg/free-multiplayer-online-role-playing-game.php";
    String activationLink;

    String rKey;

    String backupEmail, backupAddress;
    String charName;
    int delay = 50;

    int blueColorNumber = -16740865;
    int linkActivationNumber = -16746753;
    int greyColorNumber = -1710619;

    Color[] blueButton = {
            new Color(0, 141, 255), // my PC
            new Color(61, 139, 247)  // my Laptop
    };

    Color[] emailsSeparator = {
            new Color(229, 229, 229), // my PC
            new Color(242, 242, 242) // my Laptop
    };

    Color[] linkUnderline = {
            new Color(50, 116, 246), // my Laptop
            new Color(153, 186, 251), // laptop screen robot
            new Color(0, 118, 255) // my PC
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

//        control.getUrlIncognito(urlO2Login, browserPath);


        control = new Control(urlO2Login, true);
        control.sleep(4000);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(2000);
        control.reverseTab(8);
//        control.enterKey(KeyNames.Tab, 8);
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


        // o2 Login
        /*
        control = new Control(urlO2Login, true);
        control.setAutoDelay(delay);
        control.sleep(5000);
        control.enterKey(KeyNames.Tab, 2);
        control.enterString(user.getNickName());
        control.enterKey(KeyNames.Tab, 1);
        control.enterString(user.getPass());
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(6000);
        */

        // sprawdzenie czy wyskoczylo okno

        System.out.println("Sprawdzam okno");


        // mozliwe ze wyskoczylo okno wiec zamykam i sprawdzam czy jest o2 is focused

        System.out.println("A window appeared?");           // to trzeba jeszcze dopiescic
        control.reverseTab(1);
        control.sleep(1000);
        control.enterKey(KeyNames.Enter, 1);
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
//        control.enterKey(KeyNames.Tab, 3);
//        control.sleep(3000);
//        control.enterString("");
//        control.sleep(3000);
//        control.enterKey(KeyNames.Enter, 1);
//        control.sleep(3000);
//        control.printScreen();
        //metoda na znajdowanie maila

        control.openMessage(emailsSeparator, 5);

//        if (!control.searchMessage(blueColorNumber, greyColorNumber)) {
//            System.out.println("Nie znalazlem wiadomosci");
//            System.out.println("");
//            control.sleep(2000);
//
//        }

        //////////////////////////////


        control.sleep(2000);
        control.copyAll();
        control.sleep(1000);
        setActivationLink(control.getActivationLinkFromContent());

//        control.newPage();
//        control.sleep(1500);
//        control.copyToClipboard(getActivationLink());


        Control rKey = new Control(urlO2, true);
        control.sleep(2000);
        control.newPage();
        control.sleep(1500);
//        control.copyToClipboard(getActivationLink());
        control.sleep(1500);
//        control.pasteText();
        control.enterString(getActivationLink());
        control.sleep(1500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(3000);


//        control.pasteText();
//        control.sleep(500);
//        control.enterKey(KeyNames.Enter, 1);
//        control.sleep(2000);



        ///////////////////////////
//        control.sleep(4000);
//
//
//        control.printScreen();
//        System.out.println("Znajdz link");
//
//        control.openMessage(linkUnderline, -5);


        rKey.sleep(4000);

//        String zawartosc = control.clipboardToString();
//        System.out.println(zawartosc);

        rKey.copyAll();
        rKey.sleep(1000);

        String klucz = rKey.getRKeyFromContent();
//        setrKey(control.getRKeyFromContent());
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


    public void startTibia() {


        Control control = new Control(urlO2Login, true);
        control.sleep(4000);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(2000);
        control.reverseTab(8);
//        control.enterKey(KeyNames.Tab, 8);
        control.sleep(1000);
//        control.enterString(user.getNickName());
        control.enterString("iga.pawlowski341");
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(1000);
//        control.enterString(user.getPass());
        control.enterString("Pawlowski15MG8k");
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(6000);


        if (!control.isO2OnScreen(blueButton)) {
            System.out.println("A window appeared");
            control.reverseTab(1);
            control.sleep(1000);
            control.enterKey(KeyNames.Enter, 1);
            control.sleep(500);
            control.closePage();
            control.sleep(1000);
        }

        if (!control.isO2OnScreen(blueButton)) {
            System.err.println("Mail not displayed");
            throw new RuntimeException();
        }


        // o2 get Confrimation Link
        //to mozna dodac jesli nie znajdzie bez wyszukiwania
        control.sleep(1000);
//        control.enterKey(KeyNames.Tab, 3);
//        control.sleep(3000);
//        control.enterString("");
//        control.sleep(3000);
//        control.enterKey(KeyNames.Enter, 1);
//        control.sleep(3000);
//        control.printScreen();
        //metoda na znajdowanie maila

        control.openMessage(emailsSeparator, 5);

//        if (!control.searchMessage(blueColorNumber, greyColorNumber)) {
//            System.out.println("Nie znalazlem wiadomosci");
//            System.out.println("");
//            control.sleep(2000);
//
//        }

        //////////////////////////////


        control.sleep(2000);
        control.copyAll();
        control.sleep(1000);
        setActivationLink(control.getActivationLinkFromContent());

        System.out.println(getActivationLink());

        control.sleep(2000);
        control.newPage();
        control.sleep(1500);
        control.copyToClipboard(getActivationLink());
        control.sleep(1500);
        control.pasteText();
        control.sleep(1500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(3000);


        control.sleep(4000);

        control.cleanClipboard();

        control.getKeyTest();

    }



    public void startLogin() {


        Control control = new Control(urlO2Login, false);
        control.sleep(4000);

//        String zawartosc = control.clipboardToString();
//        System.out.println(zawartosc);

        control.copyAll();
        control.sleep(2000);


        // zapis do pliku

        File file = new File("plik.txt");

        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(control.clipboardToString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }










        // zapis do pliku



        control.sleep(1000);

        String klucz = control.getRKeyFromContent();
//        setrKey(control.getRKeyFromContent());
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
        control.enterRKey(getrKey());
        control.sleep(500);
        control.enterKey(KeyNames.Tab, 1);
        control.sleep(500);
        control.enterKey(KeyNames.Enter, 1);
        control.sleep(1000);


    }


    public void searchMessage() {


        Control control = new Control("", false);

//        control.isO2OnScreen(blueButton);

        Color[] test = {new Color(153, 186, 251)};



        control.openMessage(test, -5);





//        Color test = new Color(50, 116, 246);
//
//        int numer = test.getRGB();
//
//        try {
//            Robot bot = new Robot();
//
//
//            for (int i = 0; i < 1000; i++) {
//                Color tmp = bot.getPixelColor(700, i);
//                int col = tmp.getRGB();
//                bot.mouseMove(700, i);
//
//                if (col == numer) {
//                    System.out.println("Znalazlem");
//                    bot.mouseMove(700, i);
//                    break;
//                }
//            }
//
//
//
//
//        } catch (AWTException e) {
//            throw new RuntimeException(e);
//        }
//




//        control.sleep(5000);
//        control.enterKey(KeyNames.Tab, 3);
//        control.sleep(1000);
//        control.enterString("tibia");
//        control.sleep(1000);
//        control.enterKey(KeyNames.Enter, 1);
//        control.sleep(1000);
//        control.printScreen();
//        control.searchMessage(blueColorNumber, greyColorNumber);
//        control.sleep(2000);
//        control.copyAll();
//        control.sleep(1000);
//        setActivationLink(control.getActivationLinkFromContent());
//
//        control.sleep(1000);
//        control.newPage();
//        control.copyToClipboard(getActivationLink());
//        control.pasteText();
//        control.enterKey(KeyNames.Enter, 1);
//        control.sleep(2000);
//        control.copyAll();
//        control.sleep(500);
//        setrKey(control.getRKeyFromContent());
//        System.out.println(getrKey());
//        control.enterKey(KeyNames.Tab, 11);
//        control.sleep(500);
//        control.enterKey(KeyNames.Enter, 1);
//        control.sleep(1000);
//        control.enterKey(KeyNames.Tab, 11);
//        control.sleep(500);
//        control.enterRKey(getrKey());
//        control.sleep(500);
//        control.enterKey(KeyNames.Tab, 1);
//        control.sleep(500);
//        control.enterKey(KeyNames.Enter, 1);
//        control.sleep(1000);


    }




    public void saveData() {

        User user = new User();
        System.out.println(user);
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("Login_Data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        zapis.println(getCharName());
        zapis.println();
        zapis.println(user.getNickName() + "@o2.pl");
        zapis.println(user.getPass());
        zapis.close();

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