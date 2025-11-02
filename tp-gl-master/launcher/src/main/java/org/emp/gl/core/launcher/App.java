package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.clients.CompteARebours;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        TimerService timerService = new DummyTimeServiceImpl();

        new Horloge("H1", timerService);
        new Horloge("H2", timerService);
        new Horloge("H3", timerService);

        // 🔹 Tester d’abord un compte à rebours simple de 5 secondes
        new CompteARebours("C1", 5, timerService);

        // 🔹 Ajouter quelques horloges pour voir la synchro
        /*new Horloge("H1", timerService);
        new Horloge("H2", timerService);*/

        // 🔹 Créer plusieurs comptes à rebours (10) avec des valeurs aléatoires
        Random rand = new Random();
        for (int i = 1; i <= 10; i++) {
            int valeurInitiale = 10 + rand.nextInt(11); // entre 10 et 20
            new CompteARebours("C" + (i + 1), valeurInitiale, timerService);
        }

    }
}
