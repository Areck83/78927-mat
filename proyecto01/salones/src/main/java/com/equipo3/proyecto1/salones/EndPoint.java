package com.equipo3.proyecto1.salones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_proyecto1_equipo3.salones.BuscarSalonRequest;
import https.t4is_proyecto1_equipo3.salones.BuscarSalonResponse;
import https.t4is_proyecto1_equipo3.salones.EditarSalonRequest;
import https.t4is_proyecto1_equipo3.salones.EditarSalonResponse;
import https.t4is_proyecto1_equipo3.salones.EliminarSalonRequest;
import https.t4is_proyecto1_equipo3.salones.EliminarSalonResponse;
import https.t4is_proyecto1_equipo3.salones.ListarSalonesResponse;
import https.t4is_proyecto1_equipo3.salones.RegistrarSalonRequest;
import https.t4is_proyecto1_equipo3.salones.RegistrarSalonResponse;

@Endpoint
public class EndPoint {
    @Autowired
    private ISalones iSalones;

    @PayloadRoot(localPart = "RegistrarSalonRequest", namespace = "https://t4is.proyecto1.equipo3/salones")

    @ResponsePayload
    public RegistrarSalonResponse Registrar(@RequestPayload RegistrarSalonRequest peticion){
        RegistrarSalonResponse i = new RegistrarSalonResponse();
        i.setRespuesta("Se ha registrado el salon "+peticion.getIdSalon());
        Salones salones = new Salones();
        salones.setIdSalon(peticion.getIdSalon());
        salones.setUbicacion(peticion.getUbicacion());
        iSalones.save(salones);
        return i;
    }

    @PayloadRoot(localPart = "BuscarSalonRequest", namespace = "https://t4is.proyecto1.equipo3/salones")
    @ResponsePayload
    public BuscarSalonResponse BuscarSalon(@RequestPayload BuscarSalonRequest peticion){
        BuscarSalonResponse s = new BuscarSalonResponse();
        Salones salones = iSalones.findById(peticion.getSalonABuscar()).get();
        s.setRespuesta(salones.getIdSalon());
        return s;
    }

    @PayloadRoot(localPart = "EditarSalonRequest", namespace = "https://t4is.proyecto1.equipo3/salones")
    @ResponsePayload
    public EditarSalonResponse EditarSalon(@RequestPayload EditarSalonRequest peticion){
        EditarSalonResponse a = new EditarSalonResponse();
        Salones salones = new Salones();
        salones.setIdSalon(peticion.getSalonAEditar());
        salones.setUbicacion(peticion.getUbicacionAEditar());
        iSalones.save(salones);
        a.setAviso("Salon actualizado");
        return a;
    }

    @PayloadRoot(localPart = "EliminarSalonRequest", namespace = "https://t4is.proyecto1.equipo3/salones")
    @ResponsePayload
    public EliminarSalonResponse EliminarSalon(@RequestPayload EliminarSalonRequest peticion){
        EliminarSalonResponse c = new EliminarSalonResponse();
        iSalones.deleteById(peticion.getIdSalon());
        c.setRespuesta("Se ha eliminado el salon");
        return c;
    }

    @PayloadRoot(localPart = "ListarSalonesRequest", namespace = "https://t4is.proyecto1.equipo3/salones")
    @ResponsePayload
    public ListarSalonesResponse ListarSalones(){
        ListarSalonesResponse x = new ListarSalonesResponse();
        Iterable<Salones> lista = iSalones.findAll();
        String msj = "";
        for (Salones s:lista){
            msj += "Id: "+s.getIdSalon()+", Ubicacion: " + s.getUbicacion() + "."; 
        }
        x.setRespuesta(msj);
        return x;
    }
}
