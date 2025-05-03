/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import baza.DBB;
import java.util.List;
import model.Organizator;
import model.ServerW;
import model.Takmicar;
import model.Takmicenje;
import model.Ucesce;

/**
 *
 * @author USER
 */
public class Kontroler {
    private static Kontroler instance;
    private DBB dbb;
    private Kontroler() {
        dbb=new DBB();
    }

    public static Kontroler getInstance() {
    if(instance==null)
        instance=new Kontroler();
        return instance;
    }

    public List<ServerW> vratiUcesca() {
        return dbb.vratiUcesca();
    }

    public List<Takmicenje> vratiTakm() {
        return dbb.vratiTakm();
    }

    public List<Takmicar>  vratiTakmicar() {
        return dbb.vratiTakmicar();
    }

    public Organizator login(Organizator organizator) {
        return dbb.login(organizator);
    }

    public boolean sacuvaj(List<Ucesce> list) {
        return dbb.sacuvaj(list);
    }
    
}
