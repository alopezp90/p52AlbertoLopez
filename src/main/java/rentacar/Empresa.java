package rentacar;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class Empresa {

    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<VehiculoAlquilado> alquileresActivos;
    private ArrayList<VehiculoAlquilado> alquileresFinalizados;
    private String cif;
    private String nombre;
    private String paginaWeb;

    public Empresa(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.alquileresActivos = new ArrayList<>();
        this.alquileresFinalizados = new ArrayList<>();
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

    public ArrayList<VehiculoAlquilado> getAlquileresActivos() {
        return alquileresActivos;
    }

    public void setAlquileresActivos(ArrayList<VehiculoAlquilado> alquileresActivos) {
        this.alquileresActivos = alquileresActivos;
    }

    public ArrayList<VehiculoAlquilado> getAlquileresFinalizados() {
        return alquileresFinalizados;
    }

    public void setAlquileresFinalizados(ArrayList<VehiculoAlquilado> alquileresFinalizados) {
        this.alquileresFinalizados = alquileresFinalizados;
    }

    //te dice el cuantos clientes y vehículos hay
    public int totalClientes() {
        return clientes.size();
    }

    public int totalvehiculos() {
        return vehiculos.size();
    }

    public int totalalquilados() {
        return alquileresActivos.size();
    }

    public void registrarCliente(Cliente nuevo) {
        clientes.add(nuevo);
    }

    public void registrarVehiculo(Vehiculo nuevo) {
        vehiculos.add(nuevo);
    }

    public void registrarAlquiler(String nif, String matricula, LocalDate fechaAlquiler, int dias) {
        ordenaPorNif();
        ordenaPorMatricula();
        if (buscarPorNif(nif) >= 0 && buscarPorMatricula(matricula) >= 0) {
            alquileresActivos.add(new VehiculoAlquilado(clientes.get(buscarPorNif(nif)),
                    vehiculos.get(buscarPorMatricula(matricula)),
                    fechaAlquiler,
                    dias));
        }
        vehiculos.get(buscarPorMatricula(matricula)).setDisponible(false);
    }

    public void finalizarAlquiler(VehiculoAlquilado alquiler) {
        alquileresFinalizados.add(alquiler);
        alquileresActivos.remove(alquiler);
        ordenaPorMatricula();
        vehiculos.get(buscarPorMatricula(alquiler.getVehiculo().getMatricula())).setDisponible(true);
        alquileresFinalizados.get(alquileresFinalizados.indexOf(alquiler)).setTotalDiasAlquiler((int) ChronoUnit.DAYS.between(
                alquileresFinalizados.get(alquileresFinalizados.indexOf(alquiler)).getFechaAlquiler(), LocalDate.now()));
    }

    public void retornoVehiculo(String matricula) {
        ordenaAlquilerActivoPorMatricula();
        alquileresFinalizados.add(alquileresActivos.remove(buscarPorMatricula(matricula)));
        vehiculos.get(buscarPorMatricula(matricula)).setDisponible(true);
    }

    public void ordenaPorNif() {
        Collections.sort(clientes, (c1, c2) -> c1.getNif().compareTo(c2.getNif()));
    }

    public void ordenaPorNombre() {
        Collections.sort(clientes, (c1, c2) -> c1.getNombre().compareTo(c2.getNombre()));
    }

    public int buscarPorNif(String nif) {
        Cliente c = new Cliente(nif, "", "");
        int posicion = Collections.binarySearch(clientes, c, (c1, c2) -> c1.getNif().compareTo(c2.getNif()));
        return posicion;
    }

    public void imprimirClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    public void ordenaAlquilerActivoPorMatricula() {
        Collections.sort(alquileresActivos, (c1, c2) -> c1.getVehiculo().getMatricula().compareTo(c2.getVehiculo().getMatricula()));
    }

    public void ordenaAlquilerActivoPorNif() {
        Collections.sort(alquileresActivos, (c1, c2) -> c1.getCliente().getNif().compareTo(c2.getCliente().getNif()));
    }

    public void ordenaAlquilerActivoPorFecha() {
        Collections.sort(alquileresActivos, (c1, c2) -> c1.getFechaAlquiler().compareTo(c2.getFechaAlquiler()));
    }

    public int buscarAlquilerActivoPorMatricula(String matricula) {
        VehiculoAlquilado c = new VehiculoAlquilado(new Cliente("", "", ""), new Vehiculo(matricula, "", "", Color.BLACK, 0, true), LocalDate.now(), 0);
        int posicion = Collections.binarySearch(alquileresActivos, c, (c1, c2) -> c1.getVehiculo().getMatricula().compareTo(c2.getVehiculo().getMatricula()));
        return posicion;
    }

    public void ordenaPorMatricula() {
        Collections.sort(vehiculos, (c1, c2) -> c1.getMatricula().compareTo(c2.getMatricula()));
    }

    public void ordenaPorTarifa() {
        Collections.sort(vehiculos, (c1, c2) -> (int)(c1.getTarifa() - c2.getTarifa()));
    }

    public int buscarPorMatricula(String matricula) {
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
        for (VehiculoAlquilado alquiler : alquileresActivos) {
            System.out.println(alquiler.toString());
        }
    }

    public void imprimeDevoluciones() {
        if (alquileresActivos.isEmpty()) {
            System.out.println("No hay alquileres pendientes.");
        } else {
            for (VehiculoAlquilado alquiler : alquileresActivos) {
                System.out.println("Matricula: " + alquiler.getVehiculo().getMatricula() + "\tFecha devolucion: " + alquiler.fechaRetorno());
            }
        }
    }

    public ArrayList<VehiculoAlquilado> alquileresCliente(String nif) {
        ArrayList<VehiculoAlquilado> tmp = new ArrayList<>();

        for (VehiculoAlquilado alquiler : alquileresActivos) {
            if (alquiler.getCliente().getNif().equals(nif)) {
                tmp.add(alquiler);
            }
        }
        return tmp;
    }

    public void imprimeGanancias() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (VehiculoAlquilado alquiler : alquileresFinalizados) {
            System.out.println(alquiler.getCliente().getNif() + " ** " + alquiler.getVehiculo().getMatricula()
                    + " ** Desde " + alquiler.getFechaAlquiler().format(formato) + " hasta "
                    + alquiler.getFechaAlquiler().plusDays((long) alquiler.getTotalDiasAlquiler()).format(formato)
                    + " ** Ganancia: " + alquiler.getVehiculo().getTarifa() * alquiler.getTotalDiasAlquiler() + " euros.");
        }
    }
}
