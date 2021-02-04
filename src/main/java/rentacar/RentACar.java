package rentacar;

import java.awt.Color;
import java.time.LocalDate;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class RentACar {

    public static void main(String[] args) {
        Empresa easydrive = new Empresa("12345678B", "EasyDrive", "easydrive.com");

        //registro de los clientes de la empresa
        easydrive.registrarCliente(new Cliente("5618927C", "Juan", "González López"));
        easydrive.registrarCliente(new Cliente("7568991Y", "Luis", "Fernández Gómez"));
        easydrive.registrarCliente(new Cliente("2342343T", "Paco", "Gutierrez Sastre"));
        easydrive.registrarCliente(new Cliente("3214324G", "Felisa", "Martinez Padial"));
        easydrive.registrarCliente(new Cliente("3434343J", "Carla", "Diaz Fernandez"));

        //registro de los vehículos de la empresa 
        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda", "Fabia", Color.WHITE, 90.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang", Color.RED, 150.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", Color.BLUE, 110.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza", Color.WHITE, 90.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato", Color.BLUE, 80.0, true));

        //registra alquileres
        easydrive.registrarAlquiler("5618927C", "4060 TUR", LocalDate.of(2021, 2, 3), 3);
        easydrive.registrarAlquiler("7568991Y", "4070 DEP", LocalDate.of(2021, 2, 2), 5);
        easydrive.registrarAlquiler("2342343T", "4080 TUR", LocalDate.of(2021, 2, 1), 7);
        easydrive.registrarAlquiler("3214324G", "4090 TUR", LocalDate.of(2021, 1, 31), 10);
        easydrive.registrarAlquiler("3434343J", "4100 FUR", LocalDate.of(2021, 1, 30), 1);

        //imprime alquileres activos
        System.out.println("----------------Alquileres Activos-----------------");
        easydrive.imprimirAlquileres();
        System.out.println("---------------------------------------------------");
        
        //ordena vehiculos por tarifa
        System.out.println("---------------Vehiculos por Tarifa----------------");
        easydrive.ordenaPorTarifa();
        easydrive.imprimirVehiculos();
        System.out.println("---------------------------------------------------");
        
        //ordena alquileres por fecha
        System.out.println("----------------Alquileres por Fecha---------------");
        easydrive.ordenaAlquilerActivoPorFecha();
        easydrive.imprimirAlquileres();
        System.out.println("---------------------------------------------------");
        
        //alquileres de un cliente (activos y finilizados)
        System.out.println("---------------Alquileres de Felisa----------------");
        for(VehiculoAlquilado alquiler : easydrive.alquileresCliente("3214324G")) {
            System.out.println(alquiler.toString());
        }
        System.out.println("---------------------------------------------------");
        
        //finaliza alquileres
        easydrive.finalizarAlquiler(easydrive.getAlquileresActivos().get(0));
        easydrive.finalizarAlquiler(easydrive.getAlquileresActivos().get(1));
        easydrive.finalizarAlquiler(easydrive.getAlquileresActivos().get(2));
        
        //imprime ganancias
        easydrive.imprimeGanancias();
    }
}
