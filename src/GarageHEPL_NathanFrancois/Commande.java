package GarageHEPL_NathanFrancois;

import network.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Commande extends JDialog {
    private JTextField TF_Libelle;
    private JTextField TF_Type;
    private JTextField TF_Quantite;
    private JButton B_Envoyer;
    private JButton B_Annuler;
    private JRadioButton RB_Urgent;
    private JRadioButton RB_Normal;
    private JRadioButton RB_NonPrioritaire;
    private JPanel JP_Commande;
    private JTable table1;

    String _CommandeEnvoye;
    String _Priorite;
    private final NetworkBasicClient NBC;
    private int PORT_SERVICE = 50000;

    public ApplicationGestion parentApplicationGestion;

    public Commande(JFrame parent, boolean modal)
    {
        super(parent, false);
        //this.parentApplicationGestion = parent;
        setTitle("Commande");
        setContentPane(JP_Commande);
        setMinimumSize(new Dimension(700, 400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ButtonEnvoyer();

        NBC = new NetworkBasicClient("localhost",PORT_SERVICE);

        RB_Urgent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RB_Normal.setSelected(false);
                RB_NonPrioritaire.setSelected(false);
            }
        });

        RB_Normal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RB_Urgent.setSelected(false);
                RB_NonPrioritaire.setSelected(false);
            }
        });

        RB_NonPrioritaire.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RB_Urgent.setSelected(false);
                RB_Normal.setSelected(false);
            }
        });
    }

    private void ButtonEnvoyer ()
    {
        B_Envoyer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(RB_Urgent.isSelected()){_Priorite = "Urgent";}
                if(RB_Normal.isSelected()){_Priorite = "Normal";}
                if(RB_NonPrioritaire.isSelected()){_Priorite = "NonPriortaire";}

                _CommandeEnvoye = (TF_Libelle.getText() + "-" + TF_Type.getText() + "-" + TF_Quantite.getText() + "-" + _Priorite);
                NBC.sendStringWithoutWaiting(_CommandeEnvoye);
            }
        });

        B_Annuler.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
    }
}