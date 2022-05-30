package GarageHEPL_NathanFrancois;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Vector;

public class TakingOverJob extends JDialog {
    private JRadioButton RB_Pont;
    private JComboBox CB_Pont;
    private JRadioButton RB_Sol;
    private JButton B_OK;
    private JButton B_Cancel;
    private JPanel JP_TakingOverJob;
    private JTable JT_WaitingWork;

    private LinkedList<Vector<String>> _llWork = new LinkedList<>();
    public ApplicationGestion parentApplicationGestion;
    private LinkedList<Boolean> _locationFree = new LinkedList<>();

    public TakingOverJob(ApplicationGestion parent, boolean modal)
    {
        super(parent, modal);
        this.parentApplicationGestion = parent;
        _llWork= parentApplicationGestion.GetLlWork();
        Init(modal);


        String concatCarType = _llWork.get(0).get(0);
        concatCarType = concatCarType + " " + _llWork.get(0).get(1);
        System.out.println("TEUB ICI " + concatCarType);

        InsertData();
    }

    private void Init(boolean modal)
    {
        setTitle("Garage HEPL - Prise En Charge Travail");
        setContentPane(JP_TakingOverJob);
        setMinimumSize(new Dimension(500, 500));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        RB_Pont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pontIsSelected();
            }
        });

        RB_Sol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solIsSelected();
            }
        });

        B_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        B_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jobSelected();
            }
        });
    }


//    public void SetLlWork(LinkedList<Vector<String>> llWork)
//    {
//        _llWork = llWork;
//    }

    private void InsertData()
    {
        TakingOverJobTableModel takingOverJobTableModel = new TakingOverJobTableModel(_llWork);
        JT_WaitingWork.setModel(takingOverJobTableModel);
        JT_WaitingWork.setAutoCreateRowSorter(true);
    }

    public static class TakingOverJobTableModel extends AbstractTableModel{

        private final String[] COLUMNS = {"Type de voiture", "Immatriculation", "Propriétaire", "Travail", "Remarques"};
        private LinkedList<Vector<String>> llWork = new LinkedList<>();

        public TakingOverJobTableModel(LinkedList<Vector<String>> llWork) {
            this.llWork = llWork;
        }

        @Override
        public int getRowCount() {
            return llWork.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex)
            {
                case 0 :
                    String concatCarType = llWork.get(rowIndex).get(0);
                    concatCarType = concatCarType + " " + llWork.get(rowIndex).get(1);
                    return concatCarType;
                case 1:
                    return llWork.get(rowIndex).get(3);
                case 2:
                    return llWork.get(rowIndex).get(6);
                case 3:
                    return llWork.get(rowIndex).get(8);
                case 4:
                    return llWork.get(rowIndex).get(9);

                default: return "-";
            }
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }
    }

    private void pontIsSelected()
    {
        if(RB_Pont.isSelected())
            RB_Sol.setSelected(false);

        CB_Pont.removeAllItems();
        CB_Pont.addItem("1");
        CB_Pont.addItem("2");
        CB_Pont.addItem("3");
    }

    private void solIsSelected()
    {
        if(RB_Sol.isSelected())
            RB_Pont.setSelected(false);

        CB_Pont.removeAllItems();
    }

    private void jobSelected()
    {
        int rowSelected = JT_WaitingWork.getSelectedRow();
        Vector<String> jobTaken = new Vector<>();
        int jobLocation = 0;
        _locationFree = parentApplicationGestion.GetLocationFree();
        Boolean flagSomethingFree = false;

        jobTaken.add(_llWork.get(rowSelected).get(0));
        jobTaken.add(_llWork.get(rowSelected).get(1));
        jobTaken.add(_llWork.get(rowSelected).get(3));
        jobTaken.add(_llWork.get(rowSelected).get(6));

        for(int i = 0; i < 4; i++)
        {
            if(_locationFree.get(i))
                flagSomethingFree = true;
        }

        if(!flagSomethingFree)
        {
            JOptionPane.showMessageDialog(this, "Aucun emplacement disponible", "Réessayer", JOptionPane.ERROR_MESSAGE);
            dispose();
        }

        if(RB_Sol.isSelected())
        {
            if(_locationFree.get(3))
                jobLocation = 3;
            else
            {
                JOptionPane.showMessageDialog(this, "Le sol est un emplacement occupé", "Réessayer", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else if(RB_Pont.isSelected())
        {
            jobLocation = CB_Pont.getSelectedIndex();

            if(!_locationFree.get(jobLocation))
            {
                JOptionPane.showMessageDialog(this, "L'emplacement de ce pont est occupé", "Réessayer", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        parentApplicationGestion.SetJobLocation(jobLocation);
        parentApplicationGestion.SetJobTaken(jobTaken);
        dispose();
    }

}