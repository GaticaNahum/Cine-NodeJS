package mx.edu.utez.controller;


import mx.edu.utez.model.Categoria;
import mx.edu.utez.model.DaoCategoria;
import mx.edu.utez.model.DaoPelicula;
import mx.edu.utez.model.Pelicula;

import javax.ws.rs.*;
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

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Pelicula save(MultivaluedMap<String, String> formParams){
        String id = formParams.get("id").get(0);
        if(new DaoPelicula().insertPeli(getParams(id, formParams), true))
            return new DaoPelicula().findById(id);
        return null;
    }

    @POST
    @Path("/save/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Pelicula save(@PathParam("id") String id, MultivaluedMap<String, String> formParams){
        if(new DaoPelicula().insertPeli(getParams(id, formParams), false))
            return new DaoPelicula().findById(id);
        return null;
    }

    private Pelicula getParams(String id, MultivaluedMap<String, String> formParams) {
        String titulo = formParams.get("titulo").get(0);
        String descripcion = formParams.get("descripcion").get(0);
        String sinopsis = formParams.get("sinopsis").get(0);
        String rating = formParams.get("rating").get(0);
        String categoria = formParams.get("categoria").get(0);

        Pelicula pelicula = new Pelicula(id,titulo,descripcion, sinopsis, rating, categoria);
        System.out.println(pelicula);
        return pelicula;
    }

}
