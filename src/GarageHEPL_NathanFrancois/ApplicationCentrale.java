package GarageHEPL_NathanFrancois;

import javax.swing.*;
import java.awt.*;

public class ApplicationCentrale extends JDialog {
    private JCheckBox CB_MessageEntrant;
    private JButton B_Lire;
    private JComboBox CB_Commande;
    private JTextPane TP_Commande;
    private JTextField TF_JSP;
    private JTextArea TA_DetailsCommande;
    private JButton B_VerificationDispo;
    private JRadioButton RB_Disponible;
    private JRadioButton RB_NonDisponible;
    private JButton B_Reponse;
    private JLabel Detaille;
    private JPanel JP_ApplicationCentrale;

    public ApplicationCentrale(ApplicationGestion applicationGestion, boolean b)
    {
        Init();

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

    private void Init() {
        setContentPane(JP_ApplicationCentrale);
        setMinimumSize(new Dimension(700, 370));
        setLocationRelativeTo(this);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void CentralePieces() {

    }
    private void CentralePneus() {

    }
    private void CentraleLubrifiants() {

    }

}




