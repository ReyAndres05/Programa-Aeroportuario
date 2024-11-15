package AviaE;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vuelo {
    private final String id;
    private final String origen;
    private final String destino;
    private final int precio;
    private final List<Pasajero> pasajeros;
    private int asientos;
    private final int pasajerosMaximos;
    private final String financiamiento;
    private final String patrocinador;
    private final boolean [] asientosOcupados;
    
    public Vuelo(String id, String origen, String destino, int precio, String financiamiento, boolean esPublico) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.pasajeros = new ArrayList<>();
        if (esPublico) {
            this.pasajerosMaximos = 180;
            this.financiamiento = financiamiento;
            this.patrocinador = null;
        } else {
            this.pasajerosMaximos = 12;
            this.financiamiento = null;
            this.patrocinador = financiamiento;
        }
        this.asientosOcupados = new boolean [this.pasajerosMaximos];
        this.asientos = 0;
    }
    public int getMaxPasajeros() {
        return pasajerosMaximos;
    }
    public void agregarPasajero(Pasajero pasajero) {
        if (asientos < pasajerosMaximos) {
            pasajeros.add(pasajero);
            asientos = asientos + 1;
        } else {
            System.out.println("No hay asientos disponibles.");
        }
    }
    public String getId() {
        return id;
    }
    public String getCiudadOrigen() {
        return origen;
    }
    public String getCiudadDestino() {
        return destino;
    }
    public int getPrecio() {
        return precio;
    }
    
    public boolean reservarAsiento(Pasajero pasajero, int numeroAsiento){
        Scanner scanner = new Scanner (System.in);
        
        if (numeroAsiento < 0 || numeroAsiento >= pasajerosMaximos){
            System.out.println("Número de asiento no valido");
            return false;
        }
 int estadoAsiento = asientosOcupados[numeroAsiento] ? 1 : 0; // 1 si el asiento está ocupado, 0 si está libre
    
    switch (estadoAsiento) {
        case 1: // Si el asiento está ocupado
            // Solicitar nuevo número de asiento
            System.out.println("El asiento " + numeroAsiento + " ya está ocupado, por favor seleccione otro.");
            boolean asientoValido = false;

            // Mientras el asiento esté ocupado, seguir pidiendo un nuevo número de asiento
            do {
                System.out.print("Ingrese otro número de asiento: ");
                numeroAsiento = scanner.nextInt();

                // Verificar si el nuevo asiento es válido
                switch (numeroAsiento < 0 || numeroAsiento >= pasajerosMaximos ? 1 : 0) {
                    case 1: // Si el número de asiento es inválido
                        System.out.println("Número de asiento no válido. Debe estar entre 0 y " + (pasajerosMaximos - 1));
                        break;
                    case 0: // Si el número de asiento es válido
                        // Verificar si está ocupado
                        estadoAsiento = asientosOcupados[numeroAsiento] ? 1 : 0;
                        switch (estadoAsiento) {
                            case 1:
                                System.out.println("El asiento " + numeroAsiento + " ya está ocupado.");
                                break;
                            case 0:
                                asientoValido = true; // Asiento disponible
                                break;
                        }
                        break;
                }
            } while (!asientoValido); // Continuar hasta que se seleccione un asiento válido

            // Si el asiento es válido, lo reservamos
            break;
        case 0: // Si el asiento está disponible
            // Reservar el asiento directamente
            break;
    }

    // Reservamos el asiento
    asientosOcupados[numeroAsiento] = true;
    System.out.println("Asiento " + numeroAsiento + " reservado para " + pasajero.getNombre());
    return true;
    }
    public void mostrarDatos(Aeropuerto aeropuerto) {
        System.out.println("    - ID: " + id + " (" + origen + " a " + destino + " - Precio: " + precio + ")");
        if (financiamiento == null) {
        } else {
            System.out.println("      Financiamiento: " + financiamiento + " ($100.000.000)");
        }
        if (patrocinador == null) {
        }
            System.out.println("      Patrocinadores: " + patrocinador);
        
        System.out.println("      Asientos disponibles: " + (pasajerosMaximos - asientos));
    }
    public boolean hayAsientosDisponibles() {
        return asientos < pasajerosMaximos;
    }
    public void elegirAsiento(Pasajero pasajero, int numeroAsiento) {
        if (hayAsientosDisponibles()) {
            if (reservarAsiento(pasajero, numeroAsiento)){
            System.out.println("Asiento " + numeroAsiento + " reservado para " + pasajero.getNombre());
            }
        } else {
            System.out.println("No hay asientos disponibles.");
        }
    }
    public static Vuelo buscarVuelo(String idVuelo, List<Aeropuerto> aeropuertos) {
        for (int i = 0; i < aeropuertos.size(); i = i + 1) {
            Aeropuerto a = aeropuertos.get(i);
            for (int j = 0; j < a.getCompanias().size(); j = j + 1) {
                Compania c = a.getCompanias().get(j);
                for (int k = 0; k < c.getVuelos().size(); k = k + 1) {
                    Vuelo v = c.getVuelos().get(k);
                    if (v.getId().equalsIgnoreCase(idVuelo)) {
                        return v;
                    }
                }
            }
        }
        return null;
    }
}