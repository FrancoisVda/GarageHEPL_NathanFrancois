package GarageHEPL_NathanFrancois;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;

import People.*;

public class Authentification extends JDialog{
    private JPanel JP_Authentification;
    private JTextField TF_User;
    private JRadioButton RB_MembreDuPersonnel;
    private JRadioButton RB_ExterieurHabilite;
    private JButton B_OK;
    private JButton B_Annuler;
    private JPasswordField PF_Password;

    private Boolean _jobChoiceAuthentification;

    public ApplicationGestion parentApplicationGestion;
    Hashtable listPeople;

    public Authentification(ApplicationGestion parent, boolean modal)
    {
        super(parent, modal);
        this.parentApplicationGestion = parent;
        Init(parent, modal);
        InsertData();
    }

    private void Init(JFrame parent, boolean modal)
    {
        setTitle("Garage HEPL - Authentification d'un utilisateur");
        setContentPane(JP_Authentification);
        setMinimumSize(new Dimension(450, 474));
        setModal(modal);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        RB_MembreDuPersonnel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RB_ExterieurHabilite.setSelected(false);
            }
        });
        RB_ExterieurHabilite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RB_MembreDuPersonnel.setSelected(false);
            }
        });
        B_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authentificationUser();
            }
        });

        B_Annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void InsertData()
    {
        listPeople = new Hashtable();

        try (InputStream input = new FileInputStream("src\\GarageHEPL_NathanFrancois\\users.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            Iterator it = prop.keySet().iterator();

            int i =0;
            while (it.hasNext()) {
                StringTokenizer st = new StringTokenizer(prop.getProperty("users" + i));

                String userType = st.nextToken(",");

                switch (userType)
                {
                    case "Mechanic":
                        Mechanic newMechanic = new Mechanic(st.nextToken(","), st.nextToken(","), st.nextToken(","), st.nextToken(","), st.nextToken(","), st.nextToken(","), st.nextToken(","));
                        listPeople.put(newMechanic.getFirstName(), newMechanic);
                        System.out.println("New mechanic : " + newMechanic.getFirstName());
                        break;
                    case "Employee":
                        Employee newEmployee = new Employee(st.nextToken(","),st.nextToken(","), st.nextToken(","), st.nextToken(","), st.nextToken(","), st.nextToken(","));
                        listPeople.put(newEmployee.getFirstName(), newEmployee);
                        System.out.println("New Employee : " + newEmployee.getFirstName());
                        break;
                    case "ExternalTechnician":
                        ExternalTechnician newExternalTechnician = new ExternalTechnician(st.nextToken(","),st.nextToken(","), st.nextToken(","), st.nextToken(","));
                        listPeople.put(newExternalTechnician.getFirstName(), newExternalTechnician);
                        System.out.println("New ExternalTechnician : " + newExternalTechnician.getFirstName());
                        break;
                }
                i++;
                it.next();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void authentificationUser()
    {
        String user = TF_User.getText();
        String password = String.valueOf(PF_Password.getPassword());

        if(listPeople.containsKey(user))
        {
            System.out.println("L'utilisateur existe !");

            if(listPeople.get(user).getClass() == ExternalTechnician.class || ((GarageStaff)listPeople.get(user)).isValid(password))
            {
                if(RB_MembreDuPersonnel.isSelected() && listPeople.get(user).getClass() == Mechanic.class)
                {
                    System.out.println("Mechanicien");
                    parentApplicationGestion.SetJobChoiceAuthentification(true);
                    this.dispose();
                    ApplicationGestion applicationGestion = new ApplicationGestion();
                    applicationGestion.setVisible(true);
                }
                else if(RB_MembreDuPersonnel.isSelected() && listPeople.get(user).getClass() == Employee.class)
                {
                    System.out.println("Employe");
                    _jobChoiceAuthentification = false;
                    parentApplicationGestion.SetJobChoiceAuthentification(_jobChoiceAuthentification);
                    this.dispose();
                    ApplicationGestion applicationGestion = new ApplicationGestion();
                    applicationGestion.setVisible(true);
                }
                else if(RB_ExterieurHabilite.isSelected() && listPeople.get(user).getClass() == ExternalTechnician.class)
                {
                    System.out.println("Exterieur Habilite");
                    parentApplicationGestion.SetJobChoiceAuthentification(false);
                    this.dispose();
                    ApplicationGestion applicationGestion = new ApplicationGestion();
                    applicationGestion.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Poste Incorrecte", "Réessayer", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Mot de passe érroné !", "Réessayer", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (user.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Information manquante", "Réessayer", JOptionPane.ERROR_MESSAGE);
        }
        else
        {

            JOptionPane.showMessageDialog(this, "L'utilisateur n'existe pas !", "Réessayer", JOptionPane.ERROR_MESSAGE);
        }
    }
}