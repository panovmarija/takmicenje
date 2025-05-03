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
public class ModelSer extends AbstractTableModel {

    private List<ServerW> l;
    private String[] kol = new String[]{"TakmičarID", "Ime i prezime", "Takmičenje", "Datum i vreme početka", "Datum i vreme završetka", "Vreme takmičara"};

    public ModelSer(List<ServerW> l) {
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
        ServerW s=l.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getId();
            case 1:
                return s.getIp();
            case 2:
                return s.getTakm();
            case 3:
                return new SimpleDateFormat("dd.MM.yyyy. HH:mm").format(s.getDvp());
            case 4:
                return new SimpleDateFormat("dd.MM.yyyy. HH:mm").format(s.getDvz());
            case 5:
                int h=(int) (((s.getDvz().getTime()-s.getDvp().getTime()))/1000/60/60);
                int m=(int) (((s.getDvz().getTime()-s.getDvp().getTime())/1000/60)%60);
                
                return ((h<10?"0"+h:h)+":"+ (m<10?"0"+m:m));
            default:
                throw new AssertionError();
        }
    }

    public List<ServerW> getL() {
        return l;
    }

    @Override
    public String getColumnName(int column) {
        return kol[column];
    }

}
