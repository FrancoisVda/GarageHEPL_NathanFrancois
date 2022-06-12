package GarageHEPL_NathanFrancois;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JDialog {
    private JRadioButton RB_Aime;
    private JRadioButton RB_Bof;
    private JRadioButton RB_Deteste;
    private JButton B_OK;
    private JPanel JP_About;

    public About(JFrame parent, boolean modal)
    {
        super(parent, modal);
        setTitle("A Propos");
        setContentPane(JP_About);
        setMinimumSize(new Dimension(700, 400));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        B_OK.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
    }
}

