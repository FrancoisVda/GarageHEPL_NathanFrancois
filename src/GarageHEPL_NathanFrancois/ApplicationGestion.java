package GarageHEPL_NathanFrancois;

import People.Customer;
import Vehicle.Car;
import Vehicle.CarType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.*;
import java.awt.*;

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

    private Vector<String> _allInformationsNewWork = new Vector<>();
    LinkedList<Vector<String>> _llWork = new LinkedList<>();
    private Vector<String> _jobTaken = new Vector<>();
    private Vector<String> _currentJobPont1 = new Vector<>();
    private Vector<String> _currentJobPont2 = new Vector<>();
    private Vector<String> _currentJobPont3 = new Vector<>();
    private Vector<String> _currentJobSol = new Vector<>();
    private int _jobLocation = 0;
    LinkedList<Boolean> _locationFree = new LinkedList<Boolean>();

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
                NewWork newWork = new NewWork(ApplicationGestion.this,true);
                newWork.setVisible(true);

                //// VERIFY IF RECEIVE WORKS
                Enumeration enu = _allInformationsNewWork.elements();
                System.out.println("APPLI GESTION :: The enumeration of values are:");

                // Displaying the Enumeration
                while (enu.hasMoreElements()) {
                    System.out.println("ELEMENT : " + enu.nextElement());
                }
                //// END

                String concatCarType = _llWork.get(0).get(0);
                concatCarType = concatCarType + " " + _llWork.get(0).get(1);
                System.out.println("TEUB ICI " + concatCarType);
            }
        });

        MI_PriseCharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TakingOverJob takingOverJob = new TakingOverJob(ApplicationGestion.this,true);
                takingOverJob.setVisible(true);
            }
        });

        MI_APropos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                About About = new About(ApplicationGestion.this,true);
                About.setVisible(true);
            }
        });

        MI_CentralePieces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                ApplicationCentrale ApplicationCentrale = new ApplicationCentrale(ApplicationGestion.this,true);
                ApplicationCentrale.setVisible(true);
                ApplicationCentrale.setTitle("Centrale Achat - Pieces");
                //Choix = "Pieces";
            }
        });

        MI_CentralePneus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                ApplicationCentrale ApplicationCentrale = new ApplicationCentrale(ApplicationGestion.this,true);
                ApplicationCentrale.setVisible(true);
                ApplicationCentrale.setTitle("Centrale Achat - Pneus");
                //Choix = "Pneus";

            }
        });

        MI_CentraleLubrifiants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                ApplicationCentrale ApplicationCentrale = new ApplicationCentrale(ApplicationGestion.this,true);
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

    public void SetAllInformationNewWork(Vector<String> allInformationsNewWork)
    {
        _allInformationsNewWork = allInformationsNewWork;
        _llWork.add(_allInformationsNewWork);
    }

    public void SetJobTaken(Vector<String> jobTaken)
    {
        _jobTaken = jobTaken;
        //TODO DISPLAY in textflied adequat
        switch(_jobLocation)
        {
            case 0:
                TF_Pont1.setText(_jobTaken.get(0) + " " + _jobTaken.get(1) + " " +_jobTaken.get(2) + " (" + _jobTaken.get(3) + ")");
                _currentJobPont1 = _jobTaken;
                break;
            case 1:
                TF_Pont2.setText(_jobTaken.get(0) + " " + _jobTaken.get(1) + " " +_jobTaken.get(2) + " (" + _jobTaken.get(3) + ")");
                _currentJobPont2 = _jobTaken;
                break;
            case 2 :
                TF_Pont3.setText(_jobTaken.get(0) + " " + _jobTaken.get(1) + " " +_jobTaken.get(2) + " (" + _jobTaken.get(3) + ")");
                _currentJobPont3 = _jobTaken;
                break;
            case 3 :
                TF_Sol.setText(_jobTaken.get(0) + " " + _jobTaken.get(1) + " " +_jobTaken.get(2) + " (" + _jobTaken.get(3) + ")");
                _currentJobSol = _jobTaken;
                break;
        }
    }

    public void SetJobLocation(int jobLocation)
    {
        _jobLocation = jobLocation;
    }

    public LinkedList<Vector<String>> GetLlWork()
    {
        return _llWork;
    }

    public LinkedList<Boolean> GetLocationFree()
    {
        _locationFree.clear();

        System.out.println("TF PONT 1 : " + TF_Pont1.getText());

        if(TF_Pont1.getText().equals("-- libre --"))
        {
            _locationFree.add(true);
        }
        else
        {
            _locationFree.add(false);
        }

        System.out.println("TF PONT 2 : " + TF_Pont2.getText());
        if(TF_Pont2.getText().equals("-- libre --"))
        {
            _locationFree.add(true);
        }
        else
        {
            _locationFree.add(false);
        }

        if(TF_Pont3.getText().equals("-- libre --"))
        {
            _locationFree.add(true);
        }
        else
        {
            _locationFree.add(false);
        }

        if(TF_Sol.getText().equals("-- libre --"))
        {
            _locationFree.add(true);
        }
        else
        {
            _locationFree.add(false);
        }

        return _locationFree;
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Authentification authentification = new Authentification(new ApplicationGestion(),true);
                authentification.setVisible(true);
            }
        });
    }
}