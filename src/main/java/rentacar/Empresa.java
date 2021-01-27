package rentacar;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class Empresa {

    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<VehiculoAlquilado> alquilados;
    private String cif;
    private String nombre;
    private String paginaWeb;

    public Empresa(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.alquilados = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<VehiculoAlquilado> getAlquilados() {
        return alquilados;
    }

    public void setAlquilados(ArrayList<VehiculoAlquilado> alquilados) {
        this.alquilados = alquilados;
    }

    //te dice el cuantos clientes y vehículos hay
    public int totalClientes() {
        return clientes.size();
    }

    public int totalvehiculos() {
        return vehiculos.size();
    }

    public int totalalquilados() {
        return alquilados.size();
    }

    public void registrarCliente(Cliente nuevo) {
        clientes.add(nuevo);
    }

    public void registrarVehiculo(Vehiculo nuevo) {
        vehiculos.add(nuevo);
    }

    public void registrarAlquiler(String nif, String matricula, int dias) {
        if (buscarPorNif(nif) >= 0 && buscarPorMatricula(matricula) >= 0) {
            alquilados.add(new VehiculoAlquilado(clientes.get(buscarPorNif(nif)),
                    vehiculos.get(buscarPorMatricula(matricula)),
                    LocalDate.now(),
                    dias));
        }
        vehiculos.get(buscarPorMatricula(matricula)).setDisponible(false);
    }

    public void retornoVehiculo(String matricula) {
        alquilados.remove(buscarPorMatricula(matricula));
        vehiculos.get(buscarPorMatricula(matricula)).setDisponible(true);
    }

    public void ordenaPorNif() {
        Collections.sort(clientes, (c1, c2) -> c1.getNif().compareTo(c2.getNif()));
    }

    public int buscarPorNif(String nif) {
        ordenaPorNif();
        Cliente c = new Cliente(nif, "", "");
        int posicion = Collections.binarySearch(clientes, c, (c1, c2) -> c1.getNif().compareTo(c2.getNif()));
        return posicion;
    }

    public void imprimirClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    public void ordenaPorMatricula() {
        Collections.sort(vehiculos, (c1, c2) -> c1.getMatricula().compareTo(c2.getMatricula()));
    }

    public int buscarPorMatricula(String matricula) {
        ordenaPorMatricula();
        Vehiculo c = new Vehiculo(matricula, "", "", Color.BLACK, 0, true);
        int posicion = Collections.binarySearch(vehiculos, c, (c1, c2) -> c1.getMatricula().compareTo(c2.getMatricula()));
        return posicion;
    }

    public void imprimirVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }
    }

    public void imprimirAlquileres() {
        for (VehiculoAlquilado alquiler : alquilados) {
            System.out.println(alquiler.toString());
        }
    }

    public void imprimeDevoluciones() {
        if (alquilados.isEmpty()) {
            System.out.println("No hay alquileres pendientes.");
        } else {
            for (VehiculoAlquilado alquiler : alquilados) {
                System.out.println("Matricula: " + alquiler.getVehiculo().getMatricula() + "\tFecha devolucion: " + alquiler.fechaRetorno());
            }
        }
    }
}
