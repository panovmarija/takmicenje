/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Organizator;
import model.Ucesce;
import transfer.KlijentZahtev;
import transfer.ServerOdg;

/**
 *
 * @author USER
 */
public class Obrada extends Thread{
    private Socket s;

    public Obrada(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        KlijentZahtev kz;
        while((kz=procitaj())!=null)
        {
            ServerOdg so=new ServerOdg();
            switch (kz.getOp()) {
                case operazz.operacija.vratiTakm:
                    so.setOdg(kontroler.Kontroler.getInstance().vratiTakm());
                    posalji(so);
                    break;
                case operazz.operacija.vratiTakmicar:
                    so.setOdg(kontroler.Kontroler.getInstance().vratiTakmicar());
                    posalji(so);
                    break;
                case operazz.operacija.login:
                    so.setOdg(kontroler.Kontroler.getInstance().login((Organizator)kz.getPar()));
                    posalji(so);
                    break;
                case operazz.operacija.sacuvaj:
                    so.setOdg(kontroler.Kontroler.getInstance().sacuvaj((List<Ucesce>)kz.getPar()));
                    posalji(so);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        ugasiS();
    }
    
    
    public KlijentZahtev procitaj()
    {
        try {
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            return (KlijentZahtev) ois.readObject();
        } catch (IOException ex) {
            System.out.println("odvezan klijent/pad forme/ mreze");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void posalji(ServerOdg so)
    {
        try {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ugasiS()
    {
        if(s!=null&&!s.isClosed())
        {
            try {
                s.close();
                System.out.println(s.isClosed());
            } catch (IOException ex) {
                Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
