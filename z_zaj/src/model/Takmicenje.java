/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Takmicenje implements Serializable{
    private int id;
    private String naz;
    private Vrsta v;
    private String opis;
    private Date dat;

    public Takmicenje() {
    }

    public Takmicenje(int id, String naz, Vrsta v, String opis, Date dat) {
        this.id = id;
        this.naz = naz;
        this.v = v;
        this.opis = opis;
        this.dat = dat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaz() {
        return naz;
    }

    public void setNaz(String naz) {
        this.naz = naz;
    }

    public Vrsta getV() {
        return v;
    }

    public void setV(Vrsta v) {
        this.v = v;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    @Override
    public String toString() {
        return naz;}
    
}
