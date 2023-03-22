import javax.swing.*;

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
    String urlTibia = "https://www.tibia.com/account/?subtopic=createaccount";

    String backupEmail, backupAddress;
    int delay = 50;

    public void start() {

        User user = new User();
        user.printUser();
        Control control = new Control(urlO2, true);
        control.setAutoDelay(delay);
        control.sleep(2000);
            control.setAutoDelay(20);
            control.setDelayBetweenPressRelease(20);
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

    }



    public void setBackupEmail(String backupEmail) {
        this.backupEmail = backupEmail;
    }

    public void setBackupAddress(String backupAddress) {
        this.backupAddress = backupAddress;
    }

}