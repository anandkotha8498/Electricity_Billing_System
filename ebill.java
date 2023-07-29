import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ebill
{
    private JTextField txtcid;
    private JTextField txtcname;
    private JTextField txtunit;
    private JButton culculateBillButton;
    private JTextArea JPanel;
    private JButton printButton;
    private JPanel billPanel;
    private JTextArea txtprint;
    

    String cid;
    double charge,gramount;
    int count;

    JFrame frame = new JFrame();

    public ebill() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(billPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        culculateBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cid = txtcid.getText();
                count = Integer.parseInt(txtunit.getText());

                if (count < 500) {
                    charge = 1.00;
                } else if (count > 500 && count < 600) {
                    charge = 1.80;
                } else if (count > 600 && count < 800) {
                    charge = 2.80;
                } else {
                    charge = 3.00;
                }
                gramount = charge * count;

            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JPanel.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(ebill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
        public void print()
        {
            String cid = txtcid.getText();
            String cname = txtcname.getText();
            String unit = txtunit.getText();

            JPanel.setText(JPanel.getText() + "\n");
            JPanel.setText(JPanel.getText() + "Electricity Billing System" + "\n");
            JPanel.setText(JPanel.getText() + "\n");
            JPanel.setText(JPanel.getText() + "Customer ID : " + cid + "\n");
            JPanel.setText(JPanel.getText() + "Customer Name : " + cname + "\n");
            JPanel.setText(JPanel.getText() + "Unit : " + unit + "\n");
            JPanel.setText(JPanel.getText() + "Amount : " + gramount + "\n");
            JPanel.setText(JPanel.getText() + "Thank You Come Again");
        }
}
