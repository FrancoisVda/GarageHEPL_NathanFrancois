package GarageHEPL_NathanFrancois;

import People.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.Vector;

public class NewWork extends JDialog {
    private JPanel newWorkPanel;
    private JTextField TF_CarType;
    private JCheckBox CB_BelgianPlate;
    private JCheckBox CB_New;
    private JComboBox<String> CB_Owner;
    private JRadioButton RB_Maintenance;
    private JRadioButton RB_Repair;
    private JComboBox<String> CB_WorkType;
    private JTextField TF_Instruction;
    private JButton B_OK;
    private JButton B_Cancel;
    private JTextField TF_Registration;

    private Vector<String> _allInformations = new Vector<>();

    public NewWork(JFrame parent, boolean modal)
    {
        // INIT //
        super(parent, modal);
        setTitle("Garage HEPL - Nouveau travail pour l'atelier");
        setContentPane(newWorkPanel);
        setMinimumSize(new Dimension(550, 500));
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

        CB_Owner.addItem(Jean.toString());
        CB_Owner.addItem(Marc.toString());
        CB_Owner.addItem(Mounawar.toString());
        CB_Owner.addItem(Luc.toString());
        CB_Owner.addItem(Herman.toString());
        CB_Owner.addItem(Claude.toString());
        CB_Owner.addItem(Francois.toString());
        // INSERT DATA //


        B_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewWork();
            }
        });

        B_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        RB_Maintenance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maitenanceIsSelected();
            }
        });

        RB_Repair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repairIsSelected();
            }
        });

        CB_New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustommer();
            }
        });

    }

    private void addNewWork()
    {
        String carType = TF_CarType.getText();
        String registration = TF_Registration.getText();
        String instruction = TF_Instruction.getText();
        Boolean belgianRegistration = CB_BelgianPlate.isSelected();
        Boolean newCustommer = CB_New.isSelected();
        String owner = (String)CB_Owner.getSelectedItem();
        Boolean maitenance = RB_Maintenance.isSelected();
        Boolean repair = RB_Maintenance.isSelected();
        String workType = (String)CB_WorkType.getSelectedItem();

        String code;

        if(registration.isEmpty() || carType.isEmpty() || owner.isEmpty() || workType.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Information manquante", "Réessayer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringTokenizer st = new StringTokenizer(((String)TF_CarType.getText()));
        String brand = st.nextToken("-");
        String type = st.nextToken("-");
        String door = st.nextToken("-");

        System.out.println("[" + brand + ", " + type + ", " + door + "]");
        System.out.println("PLAQUE BELGE : " + belgianRegistration.toString());


        //TODO CREATE VECTOR TO RETURN TO APPLICATIONGESTION
        _allInformations.add(brand);
        _allInformations.add(type);
        _allInformations.add(door);
        _allInformations.add(registration);
        _allInformations.add(belgianRegistration.toString());
        _allInformations.add(newCustommer.toString());
        _allInformations.add(owner);
        _allInformations.add(maitenance.toString());         // Use to know if it's maitenance or repair
        _allInformations.add(workType);
        _allInformations.add(instruction);

    }

    private void addCustommer()
    {
        if(CB_New.isSelected() == true)
        {
            CB_Owner.setEditable(true);
            CB_Owner.setSelectedItem("");
        }
        else
        {
            CB_Owner.setEditable(false);
        }
    }

    private void maitenanceIsSelected()
    {
        if(RB_Repair.isSelected() == true)
            RB_Repair.setSelected(false);

        CB_WorkType.removeAllItems();
        CB_WorkType.addItem("Gros entretien");
        CB_WorkType.addItem("Moyen entretien");
        CB_WorkType.addItem("Petit entretien");
        CB_WorkType.addItem("Enorme entretien");
        CB_WorkType.addItem("Minuscule entretien");
    }

    private void repairIsSelected()
    {
        if(RB_Maintenance.isSelected() == true)
            RB_Maintenance.setSelected(false);

        CB_WorkType.removeAllItems();
        CB_WorkType.addItem("Problème moteur");
        CB_WorkType.addItem("Fuite");
        CB_WorkType.addItem("Flanc gauche");
        CB_WorkType.addItem("Flanc droit");
        CB_WorkType.addItem("Frein");
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