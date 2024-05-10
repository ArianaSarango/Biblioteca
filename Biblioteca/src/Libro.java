class Libro {
    private String titulo;
    private String autor;
    private boolean disponible = true;
    private Persona personaReserva;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Persona getPersonaReserva() {
        return personaReserva;
    }

    public void setPersonaReserva(Persona personaReserva) {
        this.personaReserva = personaReserva;
    }
}