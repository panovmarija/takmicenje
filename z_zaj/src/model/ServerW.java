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
public class ServerW implements Serializable{
    private int id;
    private String ip, takm;
    private Date dvp,dvz;

    public ServerW() {
    }

    public ServerW(int id, String ip, String takm, Date dvp, Date dvz) {
        this.id = id;
        this.ip = ip;
        this.takm = takm;
        this.dvp = dvp;
        this.dvz = dvz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTakm() {
        return takm;
    }

    public void setTakm(String takm) {
        this.takm = takm;
    }

    public Date getDvp() {
        return dvp;
    }

    public void setDvp(Date dvp) {
        this.dvp = dvp;
    }

    public Date getDvz() {
        return dvz;
    }

    public void setDvz(Date dvz) {
        this.dvz = dvz;
    }

    
}
