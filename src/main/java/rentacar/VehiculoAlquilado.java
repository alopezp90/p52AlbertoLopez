package rentacar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class VehiculoAlquilado {

    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaAlquiler;
    private int totalDiasAlquiler;

    public VehiculoAlquilado(Cliente cliente, Vehiculo vehiculo, LocalDate fechaAlquiler, int totalDiasAlquiler) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaAlquiler = fechaAlquiler;
        this.totalDiasAlquiler = totalDiasAlquiler;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public int getTotalDiasAlquiler() {
        return totalDiasAlquiler;
    }

    public void setTotalDiasAlquiler(int totalDiasAlquiler) {
        this.totalDiasAlquiler = totalDiasAlquiler;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.cliente);
        hash = 29 * hash + Objects.hashCode(this.vehiculo);
        hash = 29 * hash + Objects.hashCode(this.fechaAlquiler);
        hash = 29 * hash + this.totalDiasAlquiler;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehiculoAlquilado other = (VehiculoAlquilado) obj;
        if (this.totalDiasAlquiler != other.totalDiasAlquiler) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.vehiculo, other.vehiculo)) {
            return false;
        }
        if (!Objects.equals(this.fechaAlquiler, other.fechaAlquiler)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VehiculoAlquilado: cliente=" + cliente + "\tvehiculo=" + vehiculo + "\tfechaAlquiler=" + fechaAlquiler + "\ttotalDiasAlquiler=" + totalDiasAlquiler;
    }
    
    public LocalDate fechaRetorno(){
        return this.fechaAlquiler.plus(this.getTotalDiasAlquiler(), ChronoUnit.DAYS);
    }
}
