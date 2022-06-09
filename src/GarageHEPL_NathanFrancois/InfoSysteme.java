package GarageHEPL_NathanFrancois;

import javax.swing.*;
import java.awt.*;

public class InfoSysteme extends JDialog {
    private JPanel JP_InfoSysteme;
    private JLabel JL_UserName;
    private JLabel JL_OSName;
    private JLabel JL_OSVersion;
    private JLabel JL_JavaVersion;

    public InfoSysteme(JFrame parent, boolean modal)
    {
        super(parent, modal);
        setTitle("Information Système");
        setContentPane(JP_InfoSysteme);
        setMinimumSize(new Dimension(700, 400));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JL_UserName.setText("Nom D'Utilisateur : " + System.getProperty("user.name"));
        JL_OSName.setText("Nom Du Système D'Exploitation : " + System.getProperty("os.name"));
        JL_OSVersion.setText("Version Du Système D'Exploitation : " + System.getProperty("os.version"));
        JL_JavaVersion.setText("Version De Java : " + System.getProperty("java.version"));
    }
}
