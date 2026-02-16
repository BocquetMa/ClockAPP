package model;

import exception.ExceptionMauvaiseHeure;
import exception.ExceptionMauvaiseMinute;

public class Alarme {

    /**
     * Nombre de minutes écoulées depuis minuit entre 0 et 1439
     */
    short valeur;

    public Alarme(int heure, int minute) throws ExceptionMauvaiseMinute, ExceptionMauvaiseHeure {
        change(heure, minute);
    }

    public byte heure(){
        return (byte)(valeur / 60);
    }

    public byte minute(){
        return (byte)(valeur % 60);
    }

    public String toString(){
        String texte = "";
        byte h = heure();
        if(h < 10) texte += "0";
        texte += h;
        texte += ":";
        byte m = minute();
        if(m < 10) texte += "0";
        texte += m;
        return texte;
    }

    public void changeHeure(int heure) throws ExceptionMauvaiseHeure{
        if (heure < 0 || heure > 23) throw new ExceptionMauvaiseHeure(heure);
        valeur = (short) (heure * 60 + minute());
    }

    public void changeMinute(int minute) throws ExceptionMauvaiseMinute{
        if (minute < 0 || minute > 59) throw new ExceptionMauvaiseMinute(minute);
        valeur = (short) (heure() * 60 + minute);
    }

    public void change(int heure, int minute) throws ExceptionMauvaiseHeure, ExceptionMauvaiseMinute{
        if (heure < 0 || heure > 23) throw new ExceptionMauvaiseHeure(heure);
        if (minute < 0 || minute > 59) throw new ExceptionMauvaiseMinute(minute);
        valeur = (short)(heure * 60 + minute);
    }

    public void moins1Minute(){
        if (valeur > 0) valeur --;
        else valeur = 1439;
    }

    public void moins1Heure(){
        valeur -= 60;
        if (valeur < 0 ) valeur += 1440;
    }

    public void plus1Minute(){
        if (valeur < 1440) valeur ++;
        else valeur = 0;
    }

    public void plus1Heure(){
        valeur += 60;
        if (valeur > 1440) valeur += 1440;
    }
}
