package mx.edu.utez.controller;

import mx.edu.utez.model.Categoria;
import mx.edu.utez.model.DaoCategoria;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

@Path("/categoria")
public class ServiceCategoria {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> getCategories(){
        return new DaoCategoria().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria getCategories(@PathParam("id") String id){
        return new DaoCategoria().findById(id);
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Categoria save(MultivaluedMap<String, String> formParams){
        String id = formParams.get("id").get(0);
        if(new DaoCategoria().insertCategory(getParams(id, formParams), true))
            return new DaoCategoria().findById(id);
        return null;
    }

    @POST
    @Path("/save/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Categoria save(@PathParam("id") String id, MultivaluedMap<String, String> formParams){
        if(new DaoCategoria().insertCategory(getParams(id, formParams), false))
            return new DaoCategoria().findById(id);
        return null;
    }

    @POST
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") String id){
        return new DaoCategoria().delete(id);
    }

    private Categoria getParams(String id, MultivaluedMap<String, String> formParams) {
        String nombre = formParams.get("nombre").get(0);


        Categoria categoria = new Categoria(id,nombre);
        System.out.println(categoria);
        return categoria;
    }
}
