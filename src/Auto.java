public class Auto extends Vehiculo {

        private int numeroPuertas;

    public Auto() {
    }

    public Auto(String marca, String modelo, int año, double precioPorDia, boolean disponible, int numeroPuertas) {
        super(marca, modelo, año, precioPorDia, disponible);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "numeroPuertas=" + numeroPuertas +
                '}';
    }
    @Override
    public void mostrarInfo() {
        System.out.println(" Auto");
        System.out.println("\tMarca:      " + marca);
        System.out.println("\tModelo:     " + modelo);
        System.out.println("\tAño:        " + año);
        System.out.println("\tN° Puertas: " + numeroPuertas);
        System.out.println("\tPrecio/Día: $" + precioPorDia);
        System.out.println("\tEstado:     " + (disponible ? "Disponible" : "No disponible"));
        System.out.println("------------------------------------");
    }


}
