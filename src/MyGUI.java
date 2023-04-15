import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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


        JSpinner manyAcc = new JSpinner();
        manyAcc.setBounds(350, 40, 40, 30);
        add(manyAcc);




        JCheckBox deleteInstalators = new JCheckBox();
        deleteInstalators.setBounds(10, 80, 20, 30);
        add(deleteInstalators);

        JLabel instalators = new JLabel("Delete Tibia Setup File?");
        instalators.setBounds(35, 80, 300, 30);
        add(instalators);


//        JLabel downloadPath = new JLabel("Downloads folder");
//        downloadPath.setBounds(10,110,200,30);
//        add(downloadPath);
//
//        JTextField downloadsPath = new JTextField();
//        downloadsPath.setBounds(10, 130, 125, 30);
//        add(downloadsPath);





        JButton start = new JButton("Start");
        start.setBounds(50, 180, 100, 50);
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





    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400,300);
    }

}
