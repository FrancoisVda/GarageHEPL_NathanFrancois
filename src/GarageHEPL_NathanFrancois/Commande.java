package GarageHEPL_NathanFrancois;

import network.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;

public class Commande extends JDialog {
    private JTextField TF_Libelle;
    private JTextField TF_Type;
    private JTextField TF_Quantite;
    private JButton B_Envoyer;
    private JButton B_Annuler;
    private JRadioButton RB_Urgent;
    private JRadioButton RB_Normal;
    private JRadioButton RB_NonPrioritaire;
    private JPanel JP_Commande;
    private JTable JT_Command;

    String _CommandeEnvoye;
    String _Priorite;
    private final NetworkBasicClient NBC;
    private int PORT_SERVICE = 50000;
    public LinkedList<String> _allCommands = new LinkedList<>();

    public ApplicationGestion parentApplicationGestion;

    public Commande(JFrame parent, boolean modal)
    {
        super(parent, false);
        //this.parentApplicationGestion = parent;
        setTitle("Commande");
        setContentPane(JP_Commande);
        setMinimumSize(new Dimension(700, 400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ButtonEnvoyer();

        NBC = new NetworkBasicClient("localhost",PORT_SERVICE);

        RB_Urgent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RB_Normal.setSelected(false);
                RB_NonPrioritaire.setSelected(false);
            }
        });

        RB_Normal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RB_Urgent.setSelected(false);
                RB_NonPrioritaire.setSelected(false);
            }
        });

        RB_NonPrioritaire.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RB_Urgent.setSelected(false);
                RB_Normal.setSelected(false);
            }
        });
    }

    private void ButtonEnvoyer ()
    {
        B_Envoyer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(RB_Urgent.isSelected()){_Priorite = "Urgent";}
                if(RB_Normal.isSelected()){_Priorite = "Normal";}
                if(RB_NonPrioritaire.isSelected()){_Priorite = "NonPriortaire";}

                _CommandeEnvoye = (TF_Libelle.getText() + "-" + TF_Type.getText() + "-" + TF_Quantite.getText() +"-" + _Priorite);
                _allCommands.add(_CommandeEnvoye);

                Commande.CommandTableModel commandTableModel = new Commande.CommandTableModel(_allCommands);
                JT_Command.setModel(commandTableModel);
                JT_Command.setAutoCreateRowSorter(true);

                NBC.sendStringWithoutWaiting(_CommandeEnvoye);
            }
        });

        B_Annuler.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
    }

    public static class CommandTableModel extends AbstractTableModel {

        private final String[] COLUMNS = {"Libellé", "Type", "Quantié", "Priorité"};
        private LinkedList<String> allCommands = new LinkedList<>();

        public CommandTableModel(LinkedList<String> allCommands) {
            this.allCommands = allCommands;
        }

        @Override
        public int getRowCount() {
            return allCommands.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            StringTokenizer st = new StringTokenizer(allCommands.get(rowIndex));
            String libelle = st.nextToken("-");
            String type = st.nextToken("-");
            String quantite = st.nextToken("-");
            String priorite = st.nextToken("-");

            switch (columnIndex)
            {
                case 0:
                    return libelle;
                case 1:
                    return type;
                case 2:
                    return quantite;
                case 3:
                    return priorite;
                default: return "-";
            }
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }
    }

}