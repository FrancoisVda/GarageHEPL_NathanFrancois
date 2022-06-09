package GarageHEPL_NathanFrancois;

import People.Customer;
import Vehicle.Car;
import Vehicle.CarType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.util.*;

public class ApplicationGestion extends JFrame {
    private JTextField TF_Pont1;
    private JTextField TF_Pont2;
    private JTextField TF_Pont3;
    private JTextField TF_Sol;
    private JTextField TF_Divers;
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

    private JLabel L_Image;

    private Vector<String> _allInformationsNewWork = new Vector<>();
    LinkedList<Vector<String>> _llWork = new LinkedList<>();
    private Vector<String> _jobTaken = new Vector<>();
    Vector<Vector<String>> _currentWorks = new Vector<>();
    LinkedList<Vector<String>> _finishedWorks = new LinkedList<>();

    private int _jobLocation = 0;
    LinkedList<Boolean> _locationFree = new LinkedList<Boolean>();
    private int _jobIndexToRemove = 0;
    private int _workFinishedIndex = 0;


    public ApplicationGestion() {
        Init();
        MenuBar();
        TimeDisplay();
        InsertData();
    }

    private void Init()
    {
        setContentPane(JP_ApplicationGestion);
        setMinimumSize(new Dimension(700, 370));
        setLocationRelativeTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        for(int i = 0; i < 4 ; i++)
            _currentWorks.add(new Vector<String>());

        DeserializeLlWorks();
        DeserializeCurrentWorks();
    }

    private void MenuBar()
    {
        JMenu M_Atelier = new JMenu("Atelier");
        JMenu M_Materiel = new JMenu("Materiel");
        JMenu M_Clients = new JMenu("Clients");
        JMenu M_Factures = new JMenu("Factures");
        JMenu M_Parametres = new JMenu("Paramètres");
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
            }
        });

        MI_PriseCharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(_llWork.isEmpty())
                {
                    JOptionPane.showMessageDialog(ApplicationGestion.this, "Aucun travail à prévoir", "Réessayer", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    TakingOverJob takingOverJob = new TakingOverJob(ApplicationGestion.this,true);
                    takingOverJob.setVisible(true);
                }
            }
        });

        MI_Termine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Boolean isEmpty = true;

                for(int i = 0; i < _currentWorks.size(); i++)
                {
                    if(!_currentWorks.get(i).isEmpty())
                        isEmpty = false;
                }

                if(isEmpty)
                {
                    JOptionPane.showMessageDialog(ApplicationGestion.this, "Aucun travail en cours", "Réessayer", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    FinishWork finishWork = new FinishWork(ApplicationGestion.this, true);
                    finishWork.setVisible(true);
                }

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
            {
                if(ApplicationGestion.this.getTitle() == "Garage HEPL - Méchanicien")
                {
                    ApplicationCentrale ApplicationCentrale = new ApplicationCentrale(ApplicationGestion.this, true);
                    ApplicationCentrale.setVisible(true);
                    ApplicationCentrale.setTitle("Centrale Achat - Pieces");
                }
                else
                {
                    JOptionPane.showMessageDialog(ApplicationGestion.this, "Habilitation Incorrecte", "Accès Refusé", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        MI_CentralePneus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                if(ApplicationGestion.this.getTitle() == "Garage HEPL - Méchanicien")
                {
                    ApplicationCentrale ApplicationCentrale = new ApplicationCentrale(ApplicationGestion.this, true);
                    ApplicationCentrale.setVisible(true);
                    ApplicationCentrale.setTitle("Centrale Achat - Pneus");
                }
                else
                {
                    JOptionPane.showMessageDialog(ApplicationGestion.this, "Habilitation Incorrecte", "Accès Refusé", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        MI_CentraleLubrifiants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {;
                if(ApplicationGestion.this.getTitle() == "Garage HEPL - Méchanicien")
                {
                    ApplicationCentrale ApplicationCentrale = new ApplicationCentrale(ApplicationGestion.this, true);
                    ApplicationCentrale.setVisible(true);
                    ApplicationCentrale.setTitle("Centrale Achat - Lubrifiants");
                }
                else
                {
                    JOptionPane.showMessageDialog(ApplicationGestion.this, "Habilitation Incorrecte", "Accès Refusé", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        MI_Infos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                InfoSysteme InfoSysteme = new InfoSysteme(ApplicationGestion.this, true);
                InfoSysteme.setVisible(true);
            }
        });

        MI_Debuter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ForStart ForStart = new ForStart(ApplicationGestion.this, true);
                ForStart.setVisible(true);
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

        M_Parametres.add(MI_Infos);

        M_Aide.add(MI_Debuter);
        M_Aide.add(MI_APropos);

        MenuBar.add(M_Atelier);
        MenuBar.add(M_Materiel);
        MenuBar.add(M_Clients);
        MenuBar.add(M_Factures);
        MenuBar.add(Box.createHorizontalGlue());
        MenuBar.add(M_Parametres);
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
        SerializeLlWork();
    }

    public void SerializeLlWork()
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\GarageHEPL_NathanFrancois\\data_allWorks.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            System.out.println("SerializeLlWork :: NORMALY SERIALIZE DATA");

            for(int i =0; i < _llWork.size() ; i++)
            {
                System.out.println("SERIALAZING DATA Nb : " + i);
                objectOutputStream.writeObject(_llWork.get(i));
                objectOutputStream.flush();
            }

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur ! Fichier non trouvé [" + e + "]");
        }
        catch (IOException e)
        {
            System.err.println("Erreur ! ? [" + e + "]");
        }
    }

    public void SerializeCurrentWorks()
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\GarageHEPL_NathanFrancois\\data_currentWorks.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            System.out.println("SerializeCurrentWorks :: NORMALY SERIALIZE DATA");

            for(int i =0; i < _currentWorks.size() ; i++)
            {
                System.out.println("SERIALAZING DATA Nb : " + i);
                objectOutputStream.writeObject(_currentWorks.get(i));
                objectOutputStream.flush();
            }

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur ! Fichier non trouvé [" + e + "]");
        }
        catch (IOException e)
        {
            System.err.println("Erreur ! ? [" + e + "]");
        }
    }

    public void DeserializeLlWorks()
    {
        try
        {
            System.out.println("Lecture du fichier");
            FileInputStream fileInputStream = new FileInputStream("src\\GarageHEPL_NathanFrancois\\data_allWorks.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Vector<String> newWork = new Vector<>();

            while (fileInputStream.available() > 0) {
                newWork = (Vector<String>) objectInputStream.readObject();
                _llWork.add(newWork);
            }
            fileInputStream.close();
            objectInputStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur (INIT - APP GESTION) ! Fichier non trouvé [" + e + "]");
        }
        catch (IOException e)
        {
            System.err.println("Erreur ! ? [" + e + "]");
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Erreur ! Classe non trouvée [" + e + "]");
        }
    }

    public void DeserializeCurrentWorks()
    {
        try
        {
            System.out.println("Lecture du fichier");
            FileInputStream fileInputStream = new FileInputStream("src\\GarageHEPL_NathanFrancois\\data_currentWorks.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Vector<String> newCurrentWork = new Vector<>();

            int i = 0;
            while (fileInputStream.available() > 0) {
                newCurrentWork = (Vector<String>) objectInputStream.readObject();
                _currentWorks.setElementAt(newCurrentWork, i);
                i++;
            }
            fileInputStream.close();
            objectInputStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur (INIT - APP GESTION) ! Fichier non trouvé [" + e + "]");
        }
        catch (IOException e)
        {
            System.err.println("Erreur ! ? [" + e + "]");
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Erreur ! Classe non trouvée [" + e + "]");
        }

        if(!_currentWorks.get(0).isEmpty())
        {
            TF_Pont1.setText(_currentWorks.get(0).get(0) + " " + _currentWorks.get(0).get(1) + " " + _currentWorks.get(0).get(2) + " (" + _currentWorks.get(0).get(3) + ")");
        }

        if(!_currentWorks.get(1).isEmpty())
        {
            TF_Pont2.setText(_currentWorks.get(1).get(0) + " " + _currentWorks.get(1).get(1) + " " + _currentWorks.get(1).get(2) + " (" + _currentWorks.get(1).get(3) + ")");
        }

        if(!_currentWorks.get(2).isEmpty())
        {
            TF_Pont3.setText(_currentWorks.get(2).get(0) + " " + _currentWorks.get(2).get(1) + " " + _currentWorks.get(2).get(2) + " (" + _currentWorks.get(2).get(3) + ")");
        }

        if(!_currentWorks.get(3).isEmpty())
        {
            TF_Sol.setText(_currentWorks.get(3).get(0) + " " + _currentWorks.get(3).get(1) + " " + _currentWorks.get(3).get(2) + " (" + _currentWorks.get(3).get(3) + ")");
        }
    }

    public void SetJobTaken(Vector<String> jobTaken)
    {
        _jobTaken = jobTaken;
        _llWork.remove(_jobIndexToRemove);
        SerializeLlWork();

        System.out.println("SetJobTaken :: _workFinishedIndex " + _workFinishedIndex);

        switch(_jobLocation)
        {
            case 0:
                TF_Pont1.setText(_jobTaken.get(0) + " " + _jobTaken.get(1) + " " +_jobTaken.get(2) + " (" + _jobTaken.get(3) + ")");

                _currentWorks.setElementAt(_jobTaken, 0);
                break;

            case 1:
                TF_Pont2.setText(_jobTaken.get(0) + " " + _jobTaken.get(1) + " " +_jobTaken.get(2) + " (" + _jobTaken.get(3) + ")");

                _currentWorks.setElementAt(_jobTaken, 1);
                break;

            case 2 :
                TF_Pont3.setText(_jobTaken.get(0) + " " + _jobTaken.get(1) + " " +_jobTaken.get(2) + " (" + _jobTaken.get(3) + ")");

                _currentWorks.setElementAt(_jobTaken, 2);
                break;

            case 3 :
                TF_Sol.setText(_jobTaken.get(0) + " " + _jobTaken.get(1) + " " +_jobTaken.get(2) + " (" + _jobTaken.get(3) + ")");

                _currentWorks.setElementAt(_jobTaken, 3);
                break;
        }
        SerializeCurrentWorks();

    }

    public void SetJobLocation(int jobLocation)
    {
        _jobLocation = jobLocation;
        System.out.println("SetJobLocation :: jobLocation " + _jobLocation);
    }

    public void SetJobIndexToRemove(int jobIndexToRemove)
    {
        _jobIndexToRemove = jobIndexToRemove;
        System.out.println("SetJobIndexToRemove :: jobIndexToRemove " + _jobIndexToRemove);
    }

    public LinkedList<Vector<String>> GetLlWork()
    {
        return _llWork;
    }

    public Vector<Vector<String>> GetCurrentWorks()
    {
        Enumeration enu = _currentWorks.elements();
        System.out.println("GetCurrentWorks::AppliGestion::  Before sending :");

        // Displaying the Enumeration
        while (enu.hasMoreElements()) {
            System.out.println("ELEMENT : " + enu.nextElement());
        }
        return _currentWorks;
    }

    public void SetWorkFinishedIndex(int workFinishedIndex)
    {
        _workFinishedIndex = workFinishedIndex;

        _finishedWorks.add(_currentWorks.get(_workFinishedIndex));
        _currentWorks.get(_workFinishedIndex).clear();
        SerializeCurrentWorks();

        System.out.println("INDEX TO REMOVE FINISHED WORK " + _workFinishedIndex);
        switch (_workFinishedIndex)
        {
            case 0:
                TF_Pont1.setText("-- libre --");
                break;
            case 1:
                TF_Pont2.setText("-- libre --");
                break;
            case 2:
                TF_Pont3.setText("-- libre --");
                break;
            case 3:
                TF_Sol.setText("-- libre --");
                break;
        }
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