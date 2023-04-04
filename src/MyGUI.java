import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGUI extends JPanel {

    public MyGUI() {

        setLayout(null);

        JLabel backupEmailL = new JLabel("Backup email address");
        backupEmailL.setBounds(10,10,200,30);
        add(backupEmailL);

        JTextField backupEmail = new JTextField();
        backupEmail.setBounds(10, 40, 125, 30);
        add(backupEmail);

        JLabel at = new JLabel("@");
        at.setBounds(140,40,30,30);
        add(at);

        JTextField backupAddress = new JTextField();
        backupAddress.setBounds(160, 40, 80, 30);
        add(backupAddress);




        JButton start = new JButton("Start");
        start.setBounds(50, 250, 150, 100);
        add(start);

        start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operations op = new Operations();
                if (backupEmail.getText().equals("")) {
                    backupEmail.setText(op.randomBackupMail());
                }
                if (backupAddress.getText().equals("")) {
                    backupAddress.setText(op.randomBackupAddress());
                }
                op.setBackupEmail(backupEmail.getText());
                op.setBackupAddress(backupAddress.getText());
                op.start();
            }
        });



        JButton tibia = new JButton("Tibia");
        tibia.setBounds(320, 300, 80, 30);
        add(tibia);

        tibia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Operations tibia = new Operations();
                tibia.startTibia();

            }
        });

        JButton login = new JButton("Login");
        login.setBounds(350, 350, 80, 30);
        add(login);


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Operations login = new Operations();
                login.startLogin();

            }
        });


        JButton lokalizuj = new JButton("Lokalizuj");
        lokalizuj.setBounds(320, 350, 150, 30);
        add(lokalizuj);

        lokalizuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {



            }
        });

        JButton potwierdz = new JButton("test");
        potwierdz.setBounds(150, 150, 80, 30);
        add(potwierdz);

        potwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Operations test = new Operations();
                test.searchMessage();


//                Control con = new Control("", false);
//                Color niebieski = new Color(0, 141, 255);
//                Color szary = new Color(229, 229, 229);
//
//                con.printScreen();
//                con.searchMessage(niebieski);
//                con.enterKey(KeyNames.Tab, 3);
//                con.sleep(1000);
//                con.searchMessage(niebieski);
//                con.sleep(1000);
//                con.searchMessage(szary);

            }
        });


        JButton save = new JButton("Save data to file");
        save.setBounds(250, 200, 150, 30);
        add(save);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println("Zapisałem dane do pliku");
                Operations save = new Operations();
                save.saveData();


            }
        });


        JButton schowek = new JButton("Schowek");
        schowek.setBounds(300, 50, 100, 50);
        add(schowek);

        schowek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println("schowek");


//                String textToCopy = "Tekst do skopiowania do schowka";
//                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//                clipboard.setContents(new StringSelection(textToCopy), null);





                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable contents = clipboard.getContents(null);
                if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    try {
                        String textFromClipboard = (String) contents.getTransferData(DataFlavor.stringFlavor);
                        System.out.println("Tekst ze schowka: " + textFromClipboard);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }


            }
        });


    }








    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,400);
    }

}
