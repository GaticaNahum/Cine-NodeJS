package mx.edu.utez.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Pelicula")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pelicula {
    @XmlElement
    private String id;
    @XmlElement
    private String titulo;
    @XmlElement
    private String descripcion;
    @XmlElement
    private String sinopsis;
    @XmlElement
    private int rating;
    @XmlElement
    private String fechaRegistro;
    @XmlElement
    private String fechaUpdate;
    @XmlElement
    private int estado;
    @XmlElement
    private int categoria;

    public Pelicula() {
    }

    public Pelicula(String id, String titulo, String descripcion, String sinopsis, int rating, String fechaRegistro, String fechaUpdate, int estado, int categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.sinopsis = sinopsis;
        this.rating = rating;
        this.fechaRegistro = fechaRegistro;
        this.fechaUpdate = fechaUpdate;
        this.estado = estado;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(String fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", rating=" + rating +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", fechaUpdate='" + fechaUpdate + '\'' +
                ", estado=" + estado +
                ", categoria=" + categoria +
                '}';
    }
}

