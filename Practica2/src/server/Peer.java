/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.time.*;

/**
 *
 * @author pol
 */
public class Peer implements Runnable {

    private HashMap<String, Suscriptor> suscriptores;

    Peer() {
        this.suscriptores = new HashMap<>();
    }

    void suscribirse(String host, int segundos) {
        Suscriptor sub = new Suscriptor(segundos);
        suscriptores.put(host, sub); // si ya existe se remplaza por el nuevo valor
    }

    void cancelarSuscripcion(String host) {
        if (suscriptores.containsKey(host)) {
            suscriptores.remove(host); // lo borro de la lista
        }
    }

    public void enviarNumeros(float aleatorio) {
        Iterator it = suscriptores.entrySet().iterator();
        while (it.hasNext()) {
            Instant ahora = Instant.now(); // Ahora

            Map.Entry actual = (Map.Entry) it.next(); // suscriptor
            String host = (String) actual.getKey();
            Suscriptor sub = (Suscriptor) actual.getValue();

            if (ahora.isBefore(sub.getFechaFin())) { // Si todavia esta suscrito
                System.out.println("Enviar " + aleatorio + " a " + host);
            } else { // si se ha agotado el tiempo de suscripcion
                System.out.println("Agotado el tiempo para " + host);
                suscriptores.remove(host); // lo elimino si caducó la suscripcion
            }
        }
    }

    public void escuchar() {
        (new Thread(new Peer())).start(); // nuevo hilo
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
