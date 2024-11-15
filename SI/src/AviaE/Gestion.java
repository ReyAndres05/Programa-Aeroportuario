package AviaE;
import java.util.ArrayList;
import java.util.List;

public class Gestion {
    private final List<Aeropuerto> aeropuertos;
    private final String[] patrocinadores = {
        "Gobernacion de Quindio",
        "Alcaldia de Armenia",
        "Camara de Comercio de Armenia",
        "Ecopetrol",
        "Bancolombia"
    };
    private final String[] companiasPublicas = {
        "Avianca",
        "LATAM Colombia",
        "EasyFly",
        "SATENA"
    };
    private final String[] companiasPrivadas = {
        "Aerolineas Ejecutivas",
        "Colombia Jet",
        "Private Fly",
        "Avianca Executive",
        "LATAM Executive"
    };
    public Gestion() {
        this.aeropuertos = new ArrayList<>();
        ZAeropuertos();
    }
    private void ZAeropuertos() {
        Aeropuerto aeropuertoElEden = new Aeropuerto("Aeropuerto Internacional El Edén", "Armenia", "Colombia");
        for (String compania : companiasPublicas) {
            switch (compania) {
                case "Avianca" -> VueloPublico(aeropuertoElEden, "AV154", "Armenia", "Bogota", 150000, compania);
                case "LATAM Colombia" -> VueloPublico(aeropuertoElEden, "LA1", "Armenia", "Cali", 130000, compania);
                case "EasyFly" -> VueloPublico(aeropuertoElEden, "EF176", "Armenia", "Medellin", 120000, compania);
                case "SATENA" -> VueloPublico(aeropuertoElEden, "SA123", "Armenia", "Cartagena", 200000, compania);
            }
        }
        for (String compania : companiasPrivadas) {
            switch (compania) {
                case "Aerolineas Ejecutivas" -> VueloPrivado(aeropuertoElEden, "AE154", "Armenia", "Charter", 500000, patrocinadores[0]);
                case "Colombia Jet" -> VueloPrivado(aeropuertoElEden, "CJ154", "Armenia", "Bogotá", 600000, patrocinadores[1]);
                case "Private Fly" -> VueloPrivado(aeropuertoElEden, "PF132", "Armenia", "Cali", 700000, patrocinadores[2]);
                case "Avianca Executive" -> VueloPrivado(aeropuertoElEden, "AE257", "Armenia", "Medellin", 800000, patrocinadores[3]);
                case "LATAM Executive" -> VueloPrivado(aeropuertoElEden, "LE157", "Armenia", "Cartagena", 900000, patrocinadores[4]);
            }
        }
        aeropuertos.add(aeropuertoElEden);
    }
    private void VueloPublico(Aeropuerto aeropuerto, String id, String origen, String destino, int precio, String compania) {
        Compania nuevaCompania = new Compania(compania, true);
        nuevaCompania.agregarVuelo(new Vuelo(id, origen, destino, precio, "Gobierno Nacional", true));
        aeropuerto.agregarCompania(nuevaCompania);
    }
    private void VueloPrivado(Aeropuerto aeropuerto, String id, String origen, String destino, int precio, String patrocinador) {
        Compania nuevaCompania = new Compania(patrocinador, false);
        nuevaCompania.agregarVuelo(new Vuelo(id, origen, destino, precio, patrocinador, false));
        aeropuerto.agregarCompania(nuevaCompania);
    }
    public List<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }
}