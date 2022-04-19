package GarageHEPL_NathanFrancois;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import People.*;

public class Authentification extends JDialog{
    private JPanel authentificationPanel;
    private JTextField userTextField;
    private JRadioButton membreDuPersonnelRadioButton;
    private JRadioButton exterieurHabiliteRadioButton;
    private JButton OKButton;
    private JButton annulerButton;
    private JTextField passwordTextField;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    Hashtable listPeople;
    //ApplicationGestion MainWindow;

    public Authentification(JFrame parent, boolean modal)
    {
        super(parent, modal);
        setTitle("Garage HEPL - Authentification d'un utilisateur");
        setContentPane(authentificationPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(modal);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //MainWindow = (ApplicationGestion)parent;
        //MainWindow.setVisible(true);

        listPeople = new Hashtable();

        Mechanic Francois = new Mechanic("Francois", "0493545984", "1", "test");
        Mechanic Nathan = new Mechanic("Nathan","0455", "2", "test");

        listPeople.put(Francois.getFirstName(), Francois);
        listPeople.put(Nathan.getFirstName(), Nathan);


        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authentificationUser();
            }
        });

        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //setVisible(true);
    }

    private void authentificationUser()
    {
        String user = userTextField.getText();
        String password = passwordTextField.getText();

        if(user.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Information manquante", "Réessayer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //listPeople.contains(user);

        if(listPeople.containsKey(user))
        {
            System.out.println("L'utilisateur existe !");

            if(password.equals(((GarageStaff)listPeople.get(user)).getPassword()))
            {
                System.out.println("Tu es connecté");

                this.setVisible(false);
//                MainWindow.setVisible(true);
//                MainWindow.setVisibility(true);
                //MainWindow.setUser(user); //TODO
            // TODO verify if member of staff or extern
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Mot de passe érroné !", "Réessayer", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (!listPeople.containsKey(user))
        {
            JOptionPane.showMessageDialog(this, "L'utilisateur n'existe pas !", "Réessayer", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Authentification dialog = new Authentification(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        Authentification authentification = new Authentification(null, true);

    }

}