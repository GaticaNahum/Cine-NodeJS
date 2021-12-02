package mx.edu.utez.controller;

import mx.edu.utez.model.DaoPelicula;
import mx.edu.utez.model.Pelicula;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.time.LocalDateTime;
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
    public Pelicula getPeliculas(@PathParam("id") int id){
        return new DaoPelicula().findById(id);
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public String createMovie(MultivaluedMap<String, String> formParams){
        if(new DaoPelicula().insertPeli(true,getParams(0,formParams),0)){
            return "Succesful";
        }
        return null;
    }

    @POST
    @Path("/save/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Pelicula updateMovie(MultivaluedMap<String, String> formParams, @PathParam("id") int id){
        if(new DaoPelicula().insertPeli(false,getParams(id,formParams),id)){
            return new DaoPelicula().findById(id);
        }
        return null;
    }

    @POST
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pelicula> deleteMovie(@PathParam("id") int id){
        if(new DaoPelicula().deletePeli(id)){
            return new DaoPelicula().findAll();
        }
        return null;
    }

    private Pelicula getParams(int id, MultivaluedMap<String, String> formParams){
        int rating = Integer.parseInt(formParams.get("rating").get(0));
        int state = Integer.parseInt(formParams.get("estado").get(0));
        int categoria = Integer.parseInt(formParams.get("categoria").get(0));
        String fechaRegistro = String.valueOf(LocalDateTime.now());
        String fechaUpdate = String.valueOf(LocalDateTime.now());
        Pelicula movie = new Pelicula(id,formParams.get("titulo").get(0),formParams.get("descripcion").get(0),formParams.get("sinopsis").get(0),rating,fechaRegistro,fechaUpdate,state,categoria);
        return movie;
    }




}
