package GarageHEPL_NathanFrancois;

import javax.swing.*;
import java.awt.*;

public class ForStart extends JDialog {

    private JPanel JP_ForStart;
    private JTextArea TA_Fonctionnalite;

    public ForStart(JFrame parent, boolean modal)
    {
        super(parent, modal);
        setTitle("Pour Débuter");
        setContentPane(JP_ForStart);
        setMinimumSize(new Dimension(700, 300));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        TA_Fonctionnalite.setText(" " + '\n' + '\r' + "          - Authentification Du Programme" + '\n' + '\r' + "          - Application De Gestion Générale" + '\n' + '\r' + "          - Application Centrale Pièce, Pneus, Lubrifiant" + '\n' + '\r' + "          - Prévoir Un Travaille" + '\n' + '\r' + "          - Prise En Charge D'Un Travaille" + '\n' + '\r' + "          - Terminer Un Travaille" + '\n' + '\r');
    }
}