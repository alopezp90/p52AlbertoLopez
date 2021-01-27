package rentacar;

import java.awt.Color;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class RentACar {

    public static void main(String[] args) {
        Empresa easydrive = new Empresa("12345678B", "EasyDrive", "easydrive.com");

        //registro de los clientes de la empresa
        easydrive.registrarCliente(new Cliente("X5618927C", "Juan", "González López"));
        easydrive.registrarCliente(new Cliente("Z7568991Y", "Luis", "Fernández Gómez"));

        //registro de los vehículos de la empresa 
        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda", "Fabia", Color.WHITE, 90.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang", Color.RED, 150.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", Color.BLUE, 110.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza", Color.WHITE, 90.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato", Color.BLUE, 80.0, false));
                
        System.out.println("------------------Clientes-----------------------");
        easydrive.ordenaPorNif();
        //imprime clientes ordenados
        easydrive.imprimirClientes();
        System.out.println("-------------------------------------------------");
        
        easydrive.ordenaPorMatricula();
        //imprime vehiculos ordenados
        easydrive.imprimirVehiculos();
        System.out.println("-------------------------------------------------");
        
        //registra alquileres
        easydrive.registrarAlquiler("X5618927C", "4060 TUR", 5);
        easydrive.registrarAlquiler("Z7568991Y", "4070 DEP", 2);
        
        //imprime alquileres
        easydrive.imprimirAlquileres();
        
        //devuelve uno de los coches
        easydrive.retornoVehiculo("4060 TUR");
        
        //imprime devoluciones pendientes
        easydrive.imprimeDevoluciones();
    }

}
