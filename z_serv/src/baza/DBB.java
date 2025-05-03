/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Organizator;
import model.ServerW;
import model.Takmicar;
import model.Takmicenje;
import model.Ucesce;
import model.Vrsta;

/**
 *
 * @author USER
 */
public class DBB {

    public List<ServerW> vratiUcesca() {
        List<ServerW> l = new LinkedList<>();
        try {
            String u = "select *\n"
                    + "from ucesce u join takmicar t on(t.takmicarid=u.takmicarid) "
                    + "join takmicenje ta on(ta.takmicenjeid=u.takmicenjeid)";
            Statement s = Konekcija.getInstance().getConn().createStatement();
            ResultSet rs = s.executeQuery(u);
            while (rs.next()) {
                ServerW t = new ServerW(rs.getInt("t.takmicarid"), rs.getString("t.ime")+" "+rs.getString("t.prezime"), rs.getString("ta.nazivtakmicenja"), new Date(rs.getTimestamp("datumvremepocetka").getTime()),  new Date(rs.getTimestamp("datumvremezavrsetka").getTime()));
                l.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Takmicenje> vratiTakm() {
        List<Takmicenje> l = new LinkedList<>();
        try {
            String u = "select * from takmicenje";
            Statement s = Konekcija.getInstance().getConn().createStatement();
            ResultSet rs = s.executeQuery(u);
            while (rs.next()) {
                Takmicenje t = new Takmicenje(rs.getInt("takmicenjeid"), rs.getString("nazivtakmicenja"), Vrsta.valueOf(rs.getString("vrstatrke")), rs.getString("opis"), new Date(rs.getTimestamp("datum").getTime()));
                l.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Takmicar> vratiTakmicar() {
        List<Takmicar> l = new LinkedList<>();
        try {
            String u = "select * from takmicar";
            Statement s = Konekcija.getInstance().getConn().createStatement();
            ResultSet rs = s.executeQuery(u);
            while (rs.next()) {
                Takmicar t = new Takmicar(rs.getInt("takmicarid"), rs.getString("ime"), rs.getString("prezime"), rs.getString("pol"), rs.getString("kontakt"));
                l.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public Organizator login(Organizator organizator) {
        try {
            String u="select * from organizator";
            Statement s = Konekcija.getInstance().getConn().createStatement();
            ResultSet rs = s.executeQuery(u);
            while (rs.next()) {
               Organizator o=new Organizator(rs.getInt("organizatorid"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoime"), rs.getString("lozinka"));
               if(o.equals(organizator))return o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return organizator;
     }

    public boolean sacuvaj(List<Ucesce> list) {
        try {
            String up="insert into ucesce (vrstatrke, datumvremepocetka, datumvremezavrsetka, takmicenjeid, takmicarid, organizatorid) values(?,?,?,?,?,?)";
            PreparedStatement ps = Konekcija.getInstance().getConn().prepareStatement(up);
            for(Ucesce u: list)
            {
             ps.setString(1, u.getV()+"");
             ps.setTimestamp(2, new Timestamp(u.getDvp().getTime()));
             ps.setTimestamp(3, new Timestamp(u.getDvz().getTime()));
             ps.setInt(4,u.getTakm().getId());
             ps.setInt(5,u.getT().getId());
             ps.setInt(6,u.getO().getId());
             ps.addBatch();
            }
            ps.executeBatch();
            Konekcija.getInstance().getConn().commit();
        } catch (SQLException ex) {
            try {
                Konekcija.getInstance().getConn().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}
