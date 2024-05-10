class Docente extends Persona {
    public Docente(int idUsuario, String apellido, String nombre, String direccion, String celular, String correoElectronico) {
        super(idUsuario, apellido, nombre, direccion, celular, correoElectronico);
    }

    public void llevarMaterial(MaterialBibliografico material) {
        System.out.println("Llevando material: " + material.getTitulo());
    }

    public void dejarMaterial(MaterialBibliografico material) {
        System.out.println("Devolviendo material: " + material.getTitulo());
    }
}
