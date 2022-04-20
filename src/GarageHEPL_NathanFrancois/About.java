package GarageHEPL_NathanFrancois;

import javax.swing.*;
import java.awt.*;

public class About extends JDialog {
    private JRadioButton RB_Aime;
    private JRadioButton RB_Bof;
    private JRadioButton RB_Deteste;
    private JButton B_OK;
    private JPanel JP_About;


    private boolean _visibility = false;

    public void setVisibility(boolean visible) {
        _visibility = visible;
    }

    public boolean getVisibility() {
        return _visibility;
    }

    public About(JFrame parent, boolean modal) {
        // ---------- //
        super(parent, modal);
        setTitle("A Propos");
        setContentPane(JP_About);
        setMinimumSize(new Dimension(700, 400));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // ---------- //
    }
}
