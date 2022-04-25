package GarageHEPL_NathanFrancois;

import People.Customer;
import Vehicle.Car;
import Vehicle.CarType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Hashtable;


import java.awt.*;


//extends javax.swing.JFrame
public class ApplicationGestion extends JDialog {
    private JTextField TF_Pont1;
    private JTextField TF_Pont2;
    private JTextField TF_Pont3;
    private JTextField TF_Sol;
    private JTextField TF_Divers;
    private JTextPane TP_Image;
    private JTextField TF_BureauClient;
    private JTextField TF_BureauCompta;
    private JCheckBox CB_Patron;
    private JRadioButton RB_Absent;
    private JCheckBox CB_Pause;
    private JRadioButton RB_Present;
    private JLabel Atelier;
    private JPanel applicationGestionPanel;
    private JTextField TF_Date;
    private JMenuBar MenuBar;


    public ApplicationGestion(JFrame parent, boolean modal)
    {
        // ---------- //
        super(parent, modal);
        Init(modal);
        // ---------- //

        MenuBar();
        TimeDisplay();
        InsertData();
    }

    private void Init(boolean modal)
    {
        setTitle("Garage HEPL - Authentification d'un utilisateur");
        setContentPane(applicationGestionPanel);
        setMinimumSize(new Dimension(700, 370));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void MenuBar()
    {
        JMenu M_Atelier = new JMenu("Atelier");
        JMenu M_Materiel = new JMenu("Materiel");
        JMenu M_Clients = new JMenu("Clients");
        JMenu M_Factures = new JMenu("Factures");
        JMenu M_Paramètres = new JMenu("Paramètres");
        JMenu M_Aide = new JMenu("Aide");

        JMenuItem MI_Prevoir = new JMenuItem("Prévoir");
        JMenuItem MI_PriseCharge = new JMenuItem("Prise En Charge");
        JMenuItem MI_Termine = new JMenuItem("Terminé");
        JMenuItem MI_Listes = new JMenuItem("Listes");
        JMenuItem MI_Infos = new JMenuItem("Infos Système");
        JMenuItem MI_Debuter = new JMenuItem("Pour Débuter");
        JMenuItem MI_APropos = new JMenuItem("A Propos");

        MI_Prevoir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new NewWork(null,true).show();
            }
        });

        MI_PriseCharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new PriseEnChargeTravail(null,true).show();
            }
        });

        MI_APropos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                new About(null,true).show();
            }
        });

        M_Atelier.add(MI_Prevoir);
        M_Atelier.add(MI_PriseCharge);
        M_Atelier.add(MI_Termine);
        M_Atelier.addSeparator();
        M_Atelier.add(MI_Listes);

        M_Paramètres.add(MI_Infos);

        M_Aide.add(MI_Debuter);
        M_Aide.add(MI_APropos);

        MenuBar.add(M_Atelier);
        MenuBar.add(M_Materiel);
        MenuBar.add(M_Clients);
        MenuBar.add(M_Factures);
        MenuBar.add(Box.createHorizontalGlue());
        MenuBar.add(M_Paramètres);
        MenuBar.add(M_Aide);
    }

    private void InsertData()
    {
        Hashtable listCar;
        listCar = new Hashtable();

        CarType carType;
        Customer priorityCustomer;

        carType = new CarType("Ford", "Fiesta", 5);
        priorityCustomer = new Customer("Jean", "045655", 1);
        Car FordFiesta = new Car("FF", true, carType, priorityCustomer);

        carType = new CarType("Nissan", "Quashqai", 5);
        priorityCustomer = new Customer("Mich", "044255", 2);
        Car NissanQuashqai = new Car("NQ", false,  carType, priorityCustomer);

        listCar.put(FordFiesta.getRegistration(), FordFiesta);
        listCar.put(NissanQuashqai.getRegistration(), NissanQuashqai);
    }

    private void TimeDisplay()
    {
        Date today = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);
        TF_Date.setText(shortDateFormat.format(today));
    }


    // USE WITH extends javax.swing.JFrame
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable()
//        {
//            public void run()
//            {
//                ApplicationGestion MainWindow = new ApplicationGestion();
//
//                AuthentificationWindow = new Authentification(MainWindow,true);
//                AuthentificationWindow.setVisible(true);
//            }
//        };
//
//    }


    // Use for display solo
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentification(null,true).show();

//                ApplicationGestion dialog = new ApplicationGestion(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//                ApplicationGestion MainWindow = new ApplicationGestion();
            }
        });
        ApplicationGestion applicationGestion = new ApplicationGestion(null, true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
