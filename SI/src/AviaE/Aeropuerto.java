package AviaE;
import java.util.ArrayList;
import java.util.List;

public class Aeropuerto {
    private final String nombre;
    private final String ciudad;
    private final String pais;
    private final List<Compania> companias;

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.companias = new ArrayList<>();
    }
    public void agregarCompania(Compania compania) {
        companias.add(compania);
    }
    public String getNombre() {
        return nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getPais() {
        return pais;
    }
    public List<Compania> getCompanias() {
        return companias;
    }
    public void MostrarDatos() {
        System.out.println("AEROPUERTO: " + nombre);
        System.out.println("Compañias:");
        System.out.println("   ");
        System.out.println("VUELOS PUBLICOS:");
        for (int i = 0; i < companias.size(); i++) {
            Compania c = companias.get(i);
            if (c.esPublica()) {
                c.MostrarDatos2(this);
            }
        }
        System.out.println("  ");
        System.out.println("VUELOS PRIVADOS:");
        for (int i = 0; i < companias.size(); i++) {
            Compania c = companias.get(i);
            if (c.esPublica() == false) {
                c.MostrarDatos2(this);
            }
        }
        System.out.println();
    }
}