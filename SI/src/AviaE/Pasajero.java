package AviaE;

public class Pasajero {
    private final String nombre;
    private final String pasaporte;
    private final String nacionalidad;
    private final int asiento;

    public Pasajero(String nombre, String pasaporte, String nacionalidad, int asiento) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
        this.asiento = asiento;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPasaporte() {
        return pasaporte;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public int getAsiento() {
        return asiento;
    }
    @Override
    public String toString() {
        return nombre; 
    }
}