package GarageHEPL_NathanFrancois;

import Business.Repair;
import People.Customer;
import People.GarageStaff;
import People.Mechanic;
import Vehicle.Car;
import Vehicle.CarType;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class NewWork extends JDialog {
    private JPanel newWorkPanel;
    private JTextField TF_TypeVoiture;
    private JCheckBox CB_PlaqueBelge;
    private JCheckBox CB_New;
    private JComboBox<String> CB_Proprietaire;
    private JRadioButton RB_Entretien;
    private JRadioButton RB_Reparation;
    private JComboBox<String> CB_TypeTravail;
    private JTextField TF_Instruction;
    private JButton B_OK;
    private JButton B_Annuler;
    private JTextField TF_Immatriculation;

    public NewWork(JFrame parent, boolean modal)
    {
        // INIT //
        super(parent, modal);
        setTitle("Garage HEPL - Nouveau travail pour l'atelier");
        setContentPane(newWorkPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // INIT //

        // INSERT DATA //
        Customer Jean = new Customer("Jean", "049556", 1);
        Customer Marc = new Customer("Marc", "044641", 2);
        Customer Mounawar = new Customer("Mounawar", "045988", 3);
        Customer Luc = new Customer("Luc", "045632", 4);
        Customer Herman = new Customer("Herman", "042333", 5);
        Customer Claude = new Customer("Claude", "04495", 6);
        Customer Francois = new Customer("Francois", "041197", 7);

        //CB_Proprietaire = new JComboBox();

        CB_Proprietaire.addItem(Jean.toString());       // TODO :: WHY DOESNT DISPLAY IT ?
        CB_Proprietaire.addItem(Marc.toString());

        // INSERT DATA //


        B_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewWork();
            }
        });

        RB_Entretien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maitenanceIsSelected();
            }
        });

        RB_Reparation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repairIsSelected();
            }
        });

    }

    private void addNewWork()
    {
        String registration = TF_Immatriculation.getText();
        String instruction = TF_Instruction.getText();
        String carType = TF_TypeVoiture.getText();
        Boolean maitenance = RB_Entretien.isSelected();
        Boolean repair = RB_Entretien.isSelected();
        Boolean belgianRegistration = CB_PlaqueBelge.isSelected();
        Boolean newCustommer = CB_New.isSelected();

        //Repair IssueMotor = new Repair(Mechanic mechanicResponsible, Car carTreated, String area, String note)

        if(registration.isEmpty() || carType.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Information manquante", "Réessayer", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private void maitenanceIsSelected()
    {
        //RB_Entretien.doClick();
        //TODO if RB_Entretien selected : RB_Reparation = false
    }

    private void repairIsSelected()
    {
        //RB_Entretien.doClick();
        //TODO if RB_Reparation selected : RB_Entretien = false
    }


    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewWork dialog = new NewWork(new javax.swing.JFrame(), true);
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
