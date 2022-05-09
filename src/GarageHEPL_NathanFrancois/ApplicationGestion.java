package GarageHEPL_NathanFrancois;

import People.Customer;
import Vehicle.Car;
import Vehicle.CarType;
import jdk.nashorn.internal.objects.Global;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Hashtable;


import java.awt.*;


//extends javax.swing.JFrame
public class ApplicationGestion extends JFrame {
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
    private JPanel JP_ApplicationGestion;
    private JTextField TF_Date;
    private JMenuBar MenuBar;

    private static ApplicationGestion applicationGestion = new ApplicationGestion();


    public ApplicationGestion()
    {
        Init();
        MenuBar();
        TimeDisplay();
        InsertData();
    }

    private void Init()
    {
        setTitle("Garage HEPL - Authentification d'un utilisateur");
        setContentPane(JP_ApplicationGestion);
        setMinimumSize(new Dimension(700, 370));
        setLocationRelativeTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        JMenuItem MI_CentralePieces = new JMenuItem("Centrale Pieces");
        JMenuItem MI_CentralePneus = new JMenuItem("Centrale Pneus");
        JMenuItem MI_CentraleLubrifiants = new JMenuItem("Centrale Lubrifiants");
        JMenuItem MI_Infos = new JMenuItem("Infos Système");
        JMenuItem MI_Debuter = new JMenuItem("Pour Débuter");
        JMenuItem MI_APropos = new JMenuItem("A Propos");

        MI_Prevoir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                NewWork newWork = new NewWork(applicationGestion,true);
                newWork.setVisible(true);
            }
        });

        MI_PriseCharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                PriseEnChargeTravail PriseEnChargeTravail = new PriseEnChargeTravail(applicationGestion,true);
                PriseEnChargeTravail.setVisible(true);
            }
        });

        MI_APropos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                About About = new About(applicationGestion,true);
                About.setVisible(true);

            }
        });

        MI_CentralePieces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                ApplicationCentrale ApplicationCentrale = new ApplicationCentrale(applicationGestion,true);
                ApplicationCentrale.setVisible(true);
                ApplicationCentrale.setTitle("Centrale Achat - Pieces");
                //Choix = "Pieces";
            }
        });

        MI_CentralePneus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                ApplicationCentrale ApplicationCentrale = new ApplicationCentrale(applicationGestion,true);
                ApplicationCentrale.setVisible(true);
                ApplicationCentrale.setTitle("Centrale Achat - Pneus");
                //Choix = "Pneus";

            }
        });

        MI_CentraleLubrifiants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                ApplicationCentrale ApplicationCentrale = new ApplicationCentrale(applicationGestion,true);
                ApplicationCentrale.setVisible(true);
                ApplicationCentrale.setTitle("Centrale Achat - Lubrifiants");
                //Choix = "Lubrifiants";

            }
        });

        M_Atelier.add(MI_Prevoir);
        M_Atelier.add(MI_PriseCharge);
        M_Atelier.add(MI_Termine);
        M_Atelier.addSeparator();
        M_Atelier.add(MI_Listes);

        M_Materiel.add(MI_CentralePieces);
        M_Materiel.add(MI_CentralePneus);
        M_Materiel.add(MI_CentraleLubrifiants);

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

    // Use for display solo
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Authentification authentification = new Authentification(applicationGestion,true);
                authentification.setVisible(true);

//                ApplicationGestion dialog = new ApplicationGestion(, true);
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


    }

}