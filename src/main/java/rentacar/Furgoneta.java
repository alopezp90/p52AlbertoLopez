package rentacar;

import java.awt.Color;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class Furgoneta extends Vehiculo {
    // Atributos específicos
    private int carga;
    private int volumen;

    public Furgoneta(Long bastidor, String matricula, String marca, String modelo,
            Color color, double tarifa, boolean disponible, int carga, int volumen) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.carga = carga;
        this.volumen = volumen;
    }
    
    // métodos ‘get’ de la subclase Furgoneta. Se omiten setters
    public int getCarga() {
        return this.carga;
    }

    public int getVolumen() {
        return this.volumen;
    }

    @Override
    public String toString() {
        return super.toString() + " Carga (kg): " + this.carga
                + " Volumen (m3): " + this.volumen;
    }
}
