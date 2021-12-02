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
    } //Listo

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria getCategories(@PathParam("id") int id){
        return new DaoCategoria().findById(id);
    } //Listo

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public String createCategory(MultivaluedMap<String, String> formParams){
        if(new DaoCategoria().insertCategory(true,getParams(0,formParams),0)){
            return "Succesful";
        }
        return null;

    }

    @POST
    @Path("/save/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Categoria updateCategory(MultivaluedMap<String, String> formParams, @PathParam("id") int id){
        if(new DaoCategoria().insertCategory(false,getParams(id,formParams),id)){
            return new DaoCategoria().findById(id);
        }
        return null;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){
        return new DaoCategoria().delete(id);
    }

    private Categoria getParams(int id, MultivaluedMap<String, String> formParams){
        Categoria categoria = new Categoria(id,formParams.get("nombre").get(0));
        return categoria;
    }
}
