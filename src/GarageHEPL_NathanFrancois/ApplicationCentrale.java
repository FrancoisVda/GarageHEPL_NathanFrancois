package GarageHEPL_NathanFrancois;

import com.sun.javafx.binding.StringFormatter;
import network.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationCentrale extends JDialog {
    private JCheckBox CB_MessageEntrant;
    private JButton B_Lire;
    private JComboBox CB_Commande;
    private JTextPane TP_Commande;
    private JTextField TF_ApercuCommande;
    private JTextArea TA_DetailsCommande;
    private JButton B_VerificationDispo;
    private JRadioButton RB_Disponible;
    private JRadioButton RB_NonDisponible;
    private JButton B_Reponse;
    private JLabel Detaille;
    private JPanel JP_ApplicationCentrale;

    private final NetworkBasicServer NBS;
    private int PORT_ECOUTE = 50000;
    public ApplicationGestion parentApplicationGestion;

    public ApplicationCentrale(JFrame parent, boolean modal)
    {
        super(parent, false);
        //this.parentApplicationGestion = parent;
        setContentPane(JP_ApplicationCentrale);
        setMinimumSize(new Dimension(700, 370));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        NBS = new NetworkBasicServer(PORT_ECOUTE,CB_MessageEntrant);
        LireMessage();

//        switch(ChoixCentrale){
//
//            case "Centrale Achat - Pieces":
//                System.out.println("Centrale Achat - Pieces");
//                setTitle("Centrale Achat - Pieces");
//                CentralePieces();
//
//                break;
//
//            case "Centrale Achat - Pneus":
//                System.out.println("Centrale Achat - Pneus");
//                setTitle("Centrale Achat - Pneus");
//                CentralePneus();
//
//                break;
//
//            case "Centrale Achat - Lubrifiants":
//                System.out.println("Centrale Achat - Lubrifiants");
//                setTitle("Centrale Achat - Lubrifiants");
//                CentraleLubrifiants();
//                break;
//        }
    }

    private void CentralePieces() {

    }
    private void CentralePneus() {

    }
    private void CentraleLubrifiants() {

    }

    private void LireMessage()
    {
        B_Lire.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String message = NBS.getMessage();

                System.out.println(message);
                TF_ApercuCommande.setText(message);

                String[] lines = message.split("-");
                System.out.println("Lines0 : "+ lines[0]);
                System.out.println("Lines1 : "+ lines[1]);
                System.out.println("Lines2 : "+ lines[2]);
                System.out.println("Lines3 : "+ lines[3]);




                CB_Commande.addItem(lines[0] + " (" + lines[1]);



            }
        });
    }
}




