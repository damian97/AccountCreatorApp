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




        JButton start = new JButton("Start");
        start.setBounds(200, 300, 100, 50);
        add(start);

        start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operations op = new Operations();
                op.setBackupEmail(backupEmail.getText());
                op.setBackupAddress(backupAddress.getText());
                op.start();
            }
        });

    }





    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,400);
    }

}
