package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import java.beans.PropertyChangeEvent;

public class Horloge implements TimerChangeListener {

    private String name;
    private TimerService timerService;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;

        timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialisée !");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        afficherHeure();
    }

    public void afficherHeure() {
        System.out.println(name + " affiche " +
                String.format("%02d:%02d:%02d.%d",
                        timerService.getHeures(),
                        timerService.getMinutes(),
                        timerService.getSecondes(),
                        timerService.getDixiemeDeSeconde()));
    }

    /*@Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {

    }*/
}
