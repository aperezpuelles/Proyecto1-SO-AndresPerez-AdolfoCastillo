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
    private String nombre;
    private int maximoTrabajadores;
    private int cantidadProductoresPlacaBase;
    private int cantidadProductoresCPU;
    private int cantidadProductoresRAM;
    private int cantidadProductoresFuente;
    private int cantidadProductoresGrafica;
    private int cantidadEnsamblador;
    private Trabajador[] productoresPlacaBase;
    private Trabajador[] productoresCPU;
    private Trabajador[] productoresRAM;
    private Trabajador[] productoresFuente;
    private Trabajador[] productoresGrafica;
    private Ensamblador[] ensamblador;
    public Almacen almacen;
    private long duracionDiaMs;
    public Semaphore mutex;

    public Empresa(String nombre, int maximoTrabajadores, long duracionDiaMs) {
        this.nombre = nombre;
        this.maximoTrabajadores = maximoTrabajadores;
        this.cantidadProductoresPlacaBase = 1;
        this.cantidadProductoresCPU = 1;
        this.cantidadProductoresRAM = 1;
        this.cantidadProductoresFuente = 1;
        this.cantidadProductoresGrafica = 1;
        this.cantidadEnsamblador = 1;
        this.productoresPlacaBase = new Trabajador[maximoTrabajadores];
        this.productoresCPU = new Trabajador[maximoTrabajadores];
        this.productoresRAM = new Trabajador[maximoTrabajadores];
        this.productoresFuente = new Trabajador[maximoTrabajadores];
        this.productoresGrafica = new Trabajador[maximoTrabajadores];
        this.ensamblador = new Ensamblador[maximoTrabajadores];
        this.almacen = new Almacen(25, 20, 55, 35, 10); 
        this.duracionDiaMs = duracionDiaMs;
        this.mutex = new Semaphore(1);

        inicializarTrabajadores();
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    private void inicializarTrabajadores() {
        int totalTrabajadores = cantidadProductoresPlacaBase + cantidadProductoresCPU + cantidadProductoresRAM + cantidadProductoresFuente + cantidadProductoresGrafica + cantidadEnsamblador;

        if (totalTrabajadores > maximoTrabajadores) {
            System.out.println("Se excede el máximo de trabajadores permitidos (" + maximoTrabajadores + ").");
            return;
        }

        if (nombre.equals("MSI")) {
            for (int i = 0; i < cantidadProductoresPlacaBase; i++) {
                productoresPlacaBase[i] = new Trabajador(1.0f/3.0f, 20, this.duracionDiaMs, 1, this);
                productoresPlacaBase[i].start();
            }

            for (int i = 0; i < cantidadProductoresCPU; i++) {
                productoresCPU[i] = new Trabajador(1.0f/3.0f, 26, this.duracionDiaMs, 2, this);
                productoresCPU[i].start();
            }

            for (int i = 0; i < cantidadProductoresRAM; i++) {
                productoresRAM[i] = new Trabajador(2, 40, this.duracionDiaMs, 3, this);
                productoresRAM[i].start();
            }

            for (int i = 0; i < cantidadProductoresFuente; i++) {
                productoresFuente[i] = new Trabajador(3, 16, this.duracionDiaMs, 4, this);
                productoresFuente[i].start();
            }

            for (int i = 0; i < cantidadProductoresGrafica; i++) {
                productoresGrafica[i] = new Trabajador(1.0f/3.0f, 34, this.duracionDiaMs, 5, this);
                productoresGrafica[i].start();
            }  
            
            for (int i = 0; i < cantidadEnsamblador; i++) {
                ensamblador[i] = new Ensamblador(this.duracionDiaMs,this);
                ensamblador[i].start();
            }  

        } else if (nombre.equals("Dell")) {
            for (int i = 0; i < cantidadProductoresPlacaBase; i++) {
                productoresPlacaBase[i] = new Trabajador(0.5f, 20, this.duracionDiaMs, 1, this);
                productoresPlacaBase[i].start();
            }

            for (int i = 0; i < cantidadProductoresCPU; i++) {
                productoresCPU[i] = new Trabajador(0.5f, 26, this.duracionDiaMs, 2, this);
                productoresCPU[i].start();
            }

            for (int i = 0; i < cantidadProductoresRAM; i++) {
                productoresRAM[i] = new Trabajador(3, 40, this.duracionDiaMs, 3, this);
                productoresRAM[i].start();
            }

            for (int i = 0; i < cantidadProductoresFuente; i++) {
                productoresFuente[i] = new Trabajador(3, 16, this.duracionDiaMs, 4, this);
                productoresFuente[i].start();
            }

            for (int i = 0; i < cantidadProductoresGrafica; i++) {
                productoresGrafica[i] = new Trabajador(1.0f/3.0f, 34, this.duracionDiaMs, 5, this);
                productoresGrafica[i].start();
            }
            
            for (int i = 0; i < cantidadEnsamblador; i++) {
                ensamblador[i] = new Ensamblador(this.duracionDiaMs,this);
                ensamblador[i].start();
            }  
        }        
    }
}
