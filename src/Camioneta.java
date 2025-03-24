class Camioneta extends Vehiculo {
    private int capacidadCarga;

    public Camioneta() {
    }

    public Camioneta(String marca, String modelo, int año, double precioPorDia, boolean disponible, int capacidadCarga) {
        super(marca, modelo, año, precioPorDia, disponible);
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return super.toString() +
                "capacidadCarga=" + capacidadCarga +
                '}';
    }

    @Override
    public void mostrarInfo() {
        System.out.println(" Camioneta");
        System.out.println("\tMarca:         " + marca);
        System.out.println("\tModelo:        " + modelo);
        System.out.println("\tAño:           " + año);
        System.out.println("\tCap. Carga:    " + capacidadCarga + " kg");
        System.out.println("\tPrecio/Día:    $" + precioPorDia);
        System.out.println("\tEstado:        " + (disponible ? " Disponible" : " No disponible"));
        System.out.println("------------------------------------");
    }


}
