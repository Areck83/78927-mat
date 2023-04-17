package com.equipo3.proyecto1.salones;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;

@Entity
public class Salones {
    @Id
    private String idSalon;
    private String ubicacion;
    public String getIdSalon() {
        return idSalon;
    }
    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
