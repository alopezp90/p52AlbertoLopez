package rentacar;

import java.awt.Color;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class Deportivo extends Vehiculo {

    // Además de los atributos de Vehiculo, esta clase tiene los siguientes
    private int cilindrada;

    @Override
    public String toString() {
        // Llamada al método toString() de la clase Vehiculo y
        // concateno los atributos de la superclase con los de la subclase
        return super.toString() + " Cilindrada (cm3): " + this.cilindrada;
    }

    public Deportivo(String matricula, String marca, String modelo, Color color,
            double tarifa, boolean disponible, int puertas, boolean marchaAutomatica) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
