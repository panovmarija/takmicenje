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
public class Ucesce implements Serializable{
  private int id;
  private Vrsta v;
  private Date dvp, dvz;
  private Takmicenje takm;
  private Takmicar t;
  private Organizator o;

    public Ucesce() {
    }

    public Ucesce(int id, Vrsta v, Date dvp, Date dvz, Takmicenje takm, Takmicar t, Organizator o) {
        this.id = id;
        this.v = v;
        this.dvp = dvp;
        this.dvz = dvz;
        this.takm = takm;
        this.t = t;
        this.o = o;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setV(Vrsta v) {
        this.v = v;
    }

    public void setDvp(Date dvp) {
        this.dvp = dvp;
    }

    public void setDvz(Date dvz) {
        this.dvz = dvz;
    }

    public void setTakm(Takmicenje takm) {
        this.takm = takm;
    }

    public void setT(Takmicar t) {
        this.t = t;
    }

    public void setO(Organizator o) {
        this.o = o;
    }

    public int getId() {
        return id;
    }

    public Vrsta getV() {
        return v;
    }

    public Date getDvp() {
        return dvp;
    }

    public Date getDvz() {
        return dvz;
    }

    public Takmicenje getTakm() {
        return takm;
    }

    public Takmicar getT() {
        return t;
    }

    public Organizator getO() {
        return o;
    }
  
}
