/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.time.*;

/**
 *
 * @author pol
 */
public class Suscriptor {
    private String IP;
    private int segundos; // segundos pedidos
    private Instant fechaInicio;
    private Instant fechaFin;
    
    Suscriptor (int seg) {
        segundos = seg;
        fechaInicio = Instant.now();
        fechaFin = fechaInicio.plusSeconds(seg);
    }

    public void setSegundos(int seg) {
        segundos = seg;
        fechaInicio = Instant.now();
        fechaFin = fechaInicio.plusSeconds(seg);
    }

    public int getSegundos() {
        return segundos;
    }

    public Instant getFechaInicio() {
        return fechaInicio;
    }

    public Instant getFechaFin() {
        return fechaFin;
    }
    
}
