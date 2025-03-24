import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        List<Vehiculo> vehiculos = new ArrayList<>();
        List<cliente> clientes = new ArrayList<>();
        int opcion;

        do {
            System.out.println("--- Menú Concesionario ---");
            System.out.println("1. Registrar Auto");
            System.out.println("2. Registrar Camioneta");
            System.out.println("3. Registrar Cliente");
            System.out.println("4. Mostrar Vehículos");
            System.out.println("5. Mostrar Clientes");
            System.out.println("6. Alquilar Vehículo");
            System.out.println("7. Devolver Vehículo");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese la marca del auto: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el año: ");
                    int año = scanner.nextInt();
                    System.out.print("Ingrese el precio por día: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese el número de puertas: ");
                    int puertas = scanner.nextInt();
                    scanner.nextLine();

                    boolean disponible = true;
                    vehiculos.add(new Auto(marca, modelo, año, precio, true, puertas));

                    System.out.println("Auto registrado correctamente!");
                }
                case 2 -> {
                    System.out.print("Ingrese la marca de la camioneta: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el año: ");
                    int año = scanner.nextInt();
                    System.out.print("Ingrese el precio por día: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese la capacidad de carga : ");
                    int carga = scanner.nextInt();
                    scanner.nextLine();

                    boolean disponible = true   ;
                    vehiculos.add(new Camioneta(marca, modelo, año, precio, true, carga));
                    System.out.println("Camioneta registrada correctamente!");

                }
                case 3 -> {
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la cédula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Ingrese la licencia de conducir: ");
                    String licencia = scanner.nextLine();

                    clientes.add(new cliente(nombre, cedula, licencia));
                    System.out.println("Cliente registrado correctamente!");
                }
                case 4 -> {
                    if (vehiculos.isEmpty()) {
                        System.out.println("No hay vehículos registrados.");
                    } else {
                        System.out.println("Lista de vehículos disponibles:");
                        for (Vehiculo v : vehiculos) {
                            v.mostrarInfo();

                        }
                    }
                }

                case 5 ->{
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        System.out.println("Lista de clientes:");
                        for (cliente c : clientes) {
                            c.mostrarInfo();
                        }
                    }
                }
                case 6 ->{
                    System.out.println("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    cliente cliente = clientes.stream()
                            .filter(c -> c.getNombre().equalsIgnoreCase(nombreCliente))
                            .findFirst()
                            .orElse(null);

                    if (cliente == null) {
                        System.out.println("Cliente no encontrado.");
                        return;
                    }

                    System.out.println("Vehículos disponibles:");
                    vehiculos.stream().filter(Vehiculo::isDisponible).forEach(Vehiculo::mostrarInfo);

                    System.out.print("Ingrese el modelo del vehículo a alquilar: ");
                    String modelo = scanner.nextLine();

                    Vehiculo vehiculo = vehiculos.stream()
                            .filter(v -> v.isDisponible() && v.modelo.equalsIgnoreCase(modelo))
                            .findFirst()
                            .orElse(null);

                    if (vehiculo == null) {
                        System.out.println("Vehículo no disponible.");
                        return;
                    }

                    System.out.print("Ingrese la cantidad de días: ");
                    int dias = scanner.nextInt();
                    scanner.nextLine();

                    double costo = vehiculo.calcularCosto(dias);
                    vehiculo.setDisponible(false);
                    System.out.println("Vehículo alquilado con éxito! Costo total: $" + costo);
                }
                case 7 ->{
                    System.out.print("Ingrese el modelo del vehículo a devolver: ");
                    String modelo = scanner.nextLine();

                    Vehiculo vehiculo = vehiculos.stream()
                            .filter(v -> !v.isDisponible() && v.modelo.equalsIgnoreCase(modelo))
                            .findFirst()
                            .orElse(null);

                    if (vehiculo == null) {
                        System.out.println("No se encontró el vehículo en alquiler.");
                        return;
                    }

                    vehiculo.setDisponible(true);
                    System.out.println("Vehículo devuelto con éxito!");
                }


            }
        }while (opcion!= 8);
        scanner.close();



    }
}