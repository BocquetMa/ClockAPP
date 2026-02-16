package appli;

import model.Alarme;
import exception.ExceptionMauvaiseHeure;
import exception.ExceptionMauvaiseMinute;

public class Essai {

    public static void main(String[] args){
        try {
            Alarme a = new Alarme(10, 40);
            System.out.println(a);
            try {
                a.changeHeure(9);
                System.out.println(a);
            } catch (ExceptionMauvaiseHeure emh){
                System.err.println(emh);
            }
            try {
                a.changeMinute(40);
                System.out.println(a);
            } catch (ExceptionMauvaiseMinute emm){
                System.err.println(emm);
            }
        } catch (ExceptionMauvaiseHeure | ExceptionMauvaiseMinute e) {
            System.err.println(e);
        }
    }
}
