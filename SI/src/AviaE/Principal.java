package AviaE;
import java.util.Scanner;
import java.util.List;

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Gestion gestion = new Gestion();

    public static void main(String[] args) {
        mostrarMenu();
    }
    private static void mostrarMenu() {
        while (true) {
            System.out.println("--- MENU DE GESTION AEROPORTUARIA ---");
            System.out.println("1. Mostrar Aeropuertos.");
            System.out.println("2. Comprar boleto.");
            System.out.print("Elija una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> mostrarDatosAeropuerto();
                case 2 -> comprarBoleto();
                case 3 -> {
                }
                default -> System.out.println("Intentelo de nuevo.");
            }
        }
    }
    private static void mostrarDatosAeropuerto() { 
        List<Aeropuerto> aeropuertos = gestion.getAeropuertos(); 
        for (int i = 0; i < aeropuertos.size(); i = i + 1) { 
            aeropuertos.get(i).MostrarDatos(); 
        } 
    }
    private static void comprarBoleto() {
        System.out.print("ID del vuelo: ");
        String idVuelo = scanner.nextLine();
        Vuelo vueloEncontrado = Vuelo.buscarVuelo(idVuelo, gestion.getAeropuertos());
        if (vueloEncontrado == null) {
            System.out.println("ID de vuelo no encontrado.");
            return;
        }
        vueloEncontrado.mostrarDatos(null);
        System.out.print("Ingresa tu nombre completo: ");
        String nombrePasajero = scanner.nextLine();
        System.out.print("Ingresa tu numero de pasaporte: ");
        String numeroPasaporte = scanner.nextLine();
        System.out.print("Ingresa tu nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        int numeroAsiento = 0;
        boolean asientoValido = false;
        
        while (asientoValido  == false) {
            System.out.print("Ingrese el numero de asiento (1-" + vueloEncontrado.getMaxPasajeros() + "): ");
            numeroAsiento = scanner.nextInt();
            if (numeroAsiento < 1) {
            } else if (numeroAsiento > vueloEncontrado.getMaxPasajeros()) {
            } else {
                asientoValido = true;
            }
        }
        Pasajero nuevoPasajero = new Pasajero(nombrePasajero, numeroPasaporte, nacionalidad, numeroAsiento);
        vueloEncontrado.elegirAsiento(nuevoPasajero, numeroAsiento);
    }
}