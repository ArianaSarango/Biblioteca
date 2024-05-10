import java.time.LocalDate;

class MaterialBibliografico {
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private String ubicacion;
    private boolean prestarLibro;
    private int nroPagina;
    private String editorial;

    public MaterialBibliografico(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isPrestarLibro() {
        return prestarLibro;
    }

    public void setPrestarLibro(boolean prestarLibro) {
        this.prestarLibro = prestarLibro;
    }

    public int getNroPagina() {
        return nroPagina;
    }

    public void setNroPagina(int nroPagina) {
        this.nroPagina = nroPagina;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int conseguirNumeroMateriales() {
        return 0;
    }

    public String obtenerInformacion() {
        return "";
    }

    public boolean reservas() {
        return false;
    }
}
