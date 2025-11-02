package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import java.beans.PropertyChangeEvent;

public class CompteARebours implements TimerChangeListener {

    private String name;
    private int valeur;
    private TimerService timerService;

    public CompteARebours(String name, int valeurInitiale, TimerService timerService) {
        this.name = name;
        this.valeur = valeurInitiale;
        this.timerService = timerService;

        timerService.addTimeChangeListener(this);
        System.out.println("Compte à rebours " + name + " démarré à " + valeurInitiale + "s");
    }


    public void propertyChange(PropertyChangeEvent evt) {
        // On déclenche la mise à jour toutes les secondes (dixième = 0)
        if (timerService.getDixiemeDeSeconde() == 0 && valeur > 0) {
            valeur--;
            System.out.println(name + " → " + valeur + "s restantes");
            if (valeur == 0) {
                System.out.println(name + " terminé !");
                timerService.removeTimeChangeListener(this);
            }
        }
    }


    /*@Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {

    }*/
}
