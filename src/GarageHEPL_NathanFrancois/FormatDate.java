package GarageHEPL_NathanFrancois;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormatDate extends JDialog {

    private JPanel JP_FormatDate;
    private JComboBox<String> CB_Pays;
    private JComboBox<String> CB_FormatDate;
    private JComboBox<String> CB_FormatTemps;
    private JButton B_OK;

    public ApplicationGestion parentApplicationGestion;
    String _Pays;
    String _FormatDate;
    String _FormatTemps;

    public FormatDate(ApplicationGestion parent, boolean modal)
    {
        super(parent, modal);
        this.parentApplicationGestion = parent;
        setTitle("Format Date");
        setContentPane(JP_FormatDate);
        setMinimumSize(new Dimension(700, 400));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        InsertData();
        ActionButton();
    }
    private void InsertData()
    {
        CB_Pays.addItem("France");
        CB_Pays.addItem("Royaume Uni");
        CB_Pays.addItem("Allemagne");
        CB_Pays.addItem("Italie");
        CB_Pays.addItem("USA");
        CB_Pays.setSelectedItem("France");

        CB_FormatDate.addItem("SHORT");
        CB_FormatDate.addItem("MEDIUM");
        CB_FormatDate.addItem("LONG");
        CB_FormatDate.addItem("FULL");
        CB_FormatDate.setSelectedItem("FULL");

        CB_FormatTemps.addItem("SHORT");
        CB_FormatTemps.addItem("MEDIUM");
        CB_FormatTemps.addItem("LONG");
        CB_FormatTemps.addItem("FULL");
        CB_FormatTemps.setSelectedItem("FULL");
    }
    private void ActionButton()
    {
        B_OK.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(CB_Pays.getSelectedItem() == "France") {_Pays = "fr-FR";}
                if(CB_Pays.getSelectedItem() == "Royaume Uni") {_Pays = "en-GB";}
                if(CB_Pays.getSelectedItem() == "Allemagne") {_Pays = "de";}
                if(CB_Pays.getSelectedItem() == "Italie") {_Pays = "it";}
                if(CB_Pays.getSelectedItem() == "USA") {_Pays = "en-US";}

                if(CB_FormatDate.getSelectedItem() == "SHORT") {_FormatDate = "3";}
                if(CB_FormatDate.getSelectedItem() == "MEDIUM") {_FormatDate = "2";}
                if(CB_FormatDate.getSelectedItem() == "LONG") {_FormatDate = "1";}
                if(CB_FormatDate.getSelectedItem() == "FULL") {_FormatDate = "0";}

                if(CB_FormatTemps.getSelectedItem() == "SHORT") {_FormatTemps = "3";}
                if(CB_FormatTemps.getSelectedItem() == "MEDIUM") {_FormatTemps = "2";}
                if(CB_FormatTemps.getSelectedItem() == "LONG") {_FormatTemps = "1";}
                if(CB_FormatTemps.getSelectedItem() == "FULL") {_FormatTemps = "0";}

                parentApplicationGestion.SetTimeDisplay(_Pays, _FormatDate, _FormatTemps);
                dispose();
            }
        });
    }
}