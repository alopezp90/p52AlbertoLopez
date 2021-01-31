package rentacar;

import java.awt.Color;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class Turismo extends Vehiculo {

    // Además de los atributos de Vehiculo, esta clase tiene los siguientes
    private int puertas;
    private boolean marchaAutomatica;

    @Override
    public String toString() {
        // Llamada al método toString() de la clase Vehiculo y
        // concateno los atributos de la superclase con los de la subclase
        return super.toString() + " Puertas: " + this.puertas
                + " Marcha automática: " + this.marchaAutomatica;
    }
    
    public Turismo(String matricula, String marca, String modelo, Color color,
            double tarifa, boolean disponible, int puertas, boolean marchaAutomatica) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.puertas = puertas;
        this.marchaAutomatica = marchaAutomatica;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public boolean isMarchaAutomatica() {
        return marchaAutomatica;
    }

    public void setMarchaAutomatica(boolean marchaAutomatica) {
        this.marchaAutomatica = marchaAutomatica;
    }
}
