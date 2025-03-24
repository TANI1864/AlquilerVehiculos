public class  cliente implements Persona {
    private String nombre;
    private String cedula;
    private String licencia;

    public cliente() {
    }

    public cliente(String nombre, String cedula, String licencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.licencia = licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", licencia='" + licencia + '\'' +
                '}';
    }
    @Override
    public void mostrarInfo() {
        System.out.println(" Cliente:");
        System.out.println("\tNombre:        " + nombre);
        System.out.println("\tCédula:        " + cedula);
        System.out.println("\tLicencia:      " + licencia);
        System.out.println("------------------------------------");
    }

}
