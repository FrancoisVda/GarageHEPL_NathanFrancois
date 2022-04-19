package GarageHEPL_NathanFrancois;

import People.Customer;
import Vehicle.Car;
import Vehicle.CarType;

import javax.swing.*;
import java.util.Hashtable;

public class ApplicationGestion extends javax.swing.JFrame {
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


    public ApplicationGestion()
    {
        // TODO : afficher la date java.time.LocalTime.now();

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

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationGestion dialog = new ApplicationGestion();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });

    }
}
