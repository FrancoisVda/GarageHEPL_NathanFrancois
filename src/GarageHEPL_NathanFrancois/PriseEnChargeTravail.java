package GarageHEPL_NathanFrancois;

import javax.swing.*;
import java.awt.*;

public class PriseEnChargeTravail extends JDialog {
    private JList L_TravauxEnAttente;
    private JRadioButton RB_Pont;
    private JComboBox CB_Pont;
    private JRadioButton RB_Sol;
    private JButton B_OK;
    private JButton B_Annuler;
    private JPanel JP_PriseChargeTravail;

    public PriseEnChargeTravail(JFrame parent, boolean modal) {
        // ---------- //
        super(parent, modal);
        setTitle("Prise En Charge Travail");
        setContentPane(JP_PriseChargeTravail);
        setMinimumSize(new Dimension(700, 400));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // ---------- //
    }
}