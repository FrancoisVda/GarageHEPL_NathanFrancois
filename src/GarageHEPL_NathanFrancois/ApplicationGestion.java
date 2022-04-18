package GarageHEPL_NathanFrancois;

import Vehicle.Car;

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

         //Car FordFiesta = new Car()
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ApplicationGestion MainWindow = new ApplicationGestion();

                AuthentificationWindow = new Authentification(MainWindow,true);
                AuthentificationWindow.setVisible(true);
            }
        });

    }
}
