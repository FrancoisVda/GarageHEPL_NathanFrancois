package GarageHEPL_NathanFrancois;

import MyVariousUtils.FileLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Vector;

public class FinishWork extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox CB_WorkToFinish;
    private FileLog fileLog = new FileLog("garageHepl.log");

    public ApplicationGestion parentApplicationGestion;
    Vector<Vector<String>> _currentWorks = new Vector<>();

    public FinishWork(ApplicationGestion parent, boolean modal) {

        super(parent, modal);
        this.parentApplicationGestion = parent;
        Init(modal);
        InsertData();
    }

    private void Init(boolean modal) {
        setTitle("Garage HEPL - Terminer un travail");
        setContentPane(contentPane);
        setMinimumSize(new Dimension(550, 500));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
    }

    private void InsertData()
    {
        _currentWorks = parentApplicationGestion.GetCurrentWorks();

        if(_currentWorks.get(0).isEmpty())
        {
            CB_WorkToFinish.addItem("Pont 1 : LIBRE");
        }
        else
        {
            CB_WorkToFinish.addItem("Pont 1 : " + _currentWorks.get(0).get(0) + " " + _currentWorks.get(0).get(1) + " " + _currentWorks.get(0).get(2) + " (" + _currentWorks.get(0).get(3) + ")");
        }

        if(_currentWorks.get(1).isEmpty())
        {
            CB_WorkToFinish.addItem("Pont 2 : LIBRE");
        }
        else
        {
            CB_WorkToFinish.addItem("Pont 2 : " + _currentWorks.get(1).get(0) + " " + _currentWorks.get(1).get(1) + " " + _currentWorks.get(1).get(2) + " (" + _currentWorks.get(1).get(3) + ")");
        }

        if(_currentWorks.get(2).isEmpty())
        {
            CB_WorkToFinish.addItem("Pont 3 : LIBRE");
        }
        else
        {
            CB_WorkToFinish.addItem("Pont 3 : " + _currentWorks.get(2).get(0) + " " + _currentWorks.get(2).get(1) + " " + _currentWorks.get(2).get(2) + " (" + _currentWorks.get(2).get(3) + ")");
        }

        if(_currentWorks.get(3).isEmpty())
        {
            CB_WorkToFinish.addItem("Sol : LIBRE");
        }
        else
        {
            CB_WorkToFinish.addItem("Sol : " + _currentWorks.get(3).get(0) + " " + _currentWorks.get(3).get(1) + " " + _currentWorks.get(3).get(2) + " (" + _currentWorks.get(3).get(3) + ")");
        }


    }


    private void onOK() {

        if(_currentWorks.get(CB_WorkToFinish.getSelectedIndex()).isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Cet emplacement est libre", "Réessayer", JOptionPane.ERROR_MESSAGE);
            fileLog.writeLine("[FinishWork] - onOK", "Emplacement libre");
            return;
        }

        parentApplicationGestion.SetWorkFinishedIndex(CB_WorkToFinish.getSelectedIndex());
        dispose();
    }

    private void onCancel() {
        dispose();
    }

}
