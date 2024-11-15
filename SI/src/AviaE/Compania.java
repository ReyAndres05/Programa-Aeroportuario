package AviaE;
import java.util.ArrayList;
import java.util.List;

public class Compania {
    private final String nombre;
    private final List<Vuelo> vuelos;
    private final boolean esPublica;

    public Compania(String nombre, boolean esPublica) {
        this.nombre = nombre;
        this.vuelos = new ArrayList<>();
        this.esPublica = esPublica;
    }
    public String getNombre() {
        return nombre;
    }
    public boolean esPublica() {
        return esPublica;
    }
    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }
    public List<Vuelo> getVuelos() {
        return vuelos;
    }
    public void MostrarDatos2(Aeropuerto aeropuerto) {
        System.out.println("  Compañia: " + nombre);
        System.out.println("  Vuelos de " + nombre + ":");
        for (Vuelo v : vuelos) {
            v.mostrarDatos(aeropuerto);
        }
    }
}