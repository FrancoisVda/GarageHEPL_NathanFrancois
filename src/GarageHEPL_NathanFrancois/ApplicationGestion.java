package GarageHEPL_NathanFrancois;

import People.Customer;
import Vehicle.Car;
import Vehicle.CarType;

import javax.swing.*;
import java.util.Hashtable;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import People.*;


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

    static Authentification AuthentificationWindow;
    private boolean _visibility = false;
    public void setVisibility(boolean visible)
    {
        _visibility = visible;
    }
    public boolean getVisibility()
    {
        return _visibility;
    }
    private String _user;
    public void setUser(String user)
    {
        _user= user;
        this.setTitle("Restaurant \"Le gourmet audacieux \" : "+ user);
    }

    public String getUser()
    {
        return _user;
    }

    Hashtable listCar;


    public ApplicationGestion(JFrame parent, boolean modal)
    {
        // ---------- //
        super(parent, modal);
        setTitle("Garage HEPL - Authentification d'un utilisateur");
        setContentPane(applicationGestionPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // ---------- //

        // TODO : afficher la date java.time.LocalTime.now();

        listCar = new Hashtable();

        CarType carType;
        Customer priorityCustomer;

        carType = new CarType("Ford", "Fiesta", 5);
        priorityCustomer = new Customer("Jean", "045655", 1);
        Car FordFiesta = new Car("FF",carType, priorityCustomer);

        carType = new CarType("Nissan", "Quashqai", 5);
        priorityCustomer = new Customer("Mich", "044255", 2);
        Car NissanQuashqai = new Car("NQ", carType, priorityCustomer);

        listCar.put(FordFiesta.getId(), FordFiesta);
        listCar.put(NissanQuashqai.getId(), NissanQuashqai);

    }

    public ApplicationGestion()
    {
        listCar = new Hashtable();

        CarType carType;
        Customer priorityCustomer;

        carType = new CarType("Ford", "Fiesta", 5);
        priorityCustomer = new Customer("Jean", "04555", 1);
        Car FordFiesta = new Car("FF",carType, priorityCustomer);

        carType = new CarType("Nissan", "Quashqai", 5);
        priorityCustomer = new Customer("Mich", "04555", 2);
        Car NissanQuashqai = new Car("NQ", carType, priorityCustomer);

        listCar.put(FordFiesta.getId(), FordFiesta);
        listCar.put(NissanQuashqai.getId(), NissanQuashqai);

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
//        });
//
//    }


    // Use for display solo
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationGestion dialog = new ApplicationGestion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                ApplicationGestion MainWindow = new ApplicationGestion();

//                AuthentificationWindow = new Authentification(MainWindow,true);
//                AuthentificationWindow.setVisible(true);
            }
        });
        ApplicationGestion applicationGestion = new ApplicationGestion(null, true);

    }

}
