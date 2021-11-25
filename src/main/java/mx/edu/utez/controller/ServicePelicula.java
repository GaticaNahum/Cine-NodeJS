package mx.edu.utez.controller;


import mx.edu.utez.model.Categoria;
import mx.edu.utez.model.DaoCategoria;
import mx.edu.utez.model.DaoPelicula;
import mx.edu.utez.model.Pelicula;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

@Path("/pelicula")
public class ServicePelicula {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pelicula> getPeliculas(){
        return new DaoPelicula().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pelicula getPeliculas(@PathParam("id") String id){
        return new DaoPelicula().findById(id);
    }



}
