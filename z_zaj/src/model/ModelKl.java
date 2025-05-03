/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelKl extends AbstractTableModel {

    private List<Ucesce> l;
    private String[] kol = new String[]{"Takmičenje", "Takmičar", "Vrsta trke", "Datum i vreme početka", "Datum i vreme završetka"};

    public ModelKl(List<Ucesce> l) {
        this.l = l;
    }

    @Override
    public int getRowCount() {
        return l.size();
    }

    @Override
    public int getColumnCount() {
        return kol.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ucesce s=l.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getTakm().getNaz();
            case 1:
                return s.getT().getIme()+" "+s.getT().getPrez();
            case 2:
                return s.getV()+"";
            case 3:
                return new SimpleDateFormat("dd.MM.yyyy. HH:mm").format(s.getDvp());
            case 4:
                return new SimpleDateFormat("dd.MM.yyyy. HH:mm").format(s.getDvz());
             default:
                throw new AssertionError();
        }
    }

    public List<Ucesce> getL() {
        return l;
    }

    @Override
    public String getColumnName(int column) {
        return kol[column];
    }

}
