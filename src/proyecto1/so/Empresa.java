/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.so;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Ignacio
 */
public class Empresa {
   private String nombre;                 // Nombre de la empresa
    private int maximoTrabajadores;        // Número máximo de trabajadores
    private Trabajador[] trabajadores;     // Array de trabajadores
    private long duracionDiaMs;            // Duración del día en milisegundos
    public Almacen almacen;                // Almacén de la empresa
    public Semaphore mutex;                // Semáforo para controlar el acceso al almacén

    // Constructor de la clase Empresa
    public Empresa(String nombre, int maximoTrabajadores, long duracionDia, int cantidadplacabasemax, int cantidadcpumax, int cantidadrammax, int cantidadfuentemax, int cantidadgraficasmax) {
        this.nombre = nombre;
        this.maximoTrabajadores = maximoTrabajadores;
        this.duracionDiaMs = duracionDia;
        this.trabajadores = new Trabajador[maximoTrabajadores];
        this.almacen = new Almacen(cantidadplacabasemax, cantidadcpumax, cantidadrammax, cantidadfuentemax, cantidadgraficasmax);
        this.mutex = new Semaphore(1); // Inicializa el semáforo
        inicializarTrabajadores();       // Inicializa los trabajadores
    }
    
}
