/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Takmicar implements Serializable{
    private int id;
    private String ime, prez, pol, kont;

    public Takmicar() {
    }

    public Takmicar(int id, String ime, String prez, String pol, String kont) {
        this.id = id;
        this.ime = ime;
        this.prez = prez;
        this.pol = pol;
        this.kont = kont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrez() {
        return prez;
    }

    public void setPrez(String prez) {
        this.prez = prez;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getKont() {
        return kont;
    }

    public void setKont(String kont) {
        this.kont = kont;
    }

    @Override
    public String toString() {
        return ime+" "+prez;
    }
    
}
