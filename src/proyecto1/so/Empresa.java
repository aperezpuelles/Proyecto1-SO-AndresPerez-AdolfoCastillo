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

    public int getMaximoTrabajadores() {
        return maximoTrabajadores;
    }

    public void setMaximoTrabajadores(int maximoTrabajadores) {
        this.maximoTrabajadores = maximoTrabajadores;
    }

    public int getCantidadProductoresPlacaBase() {
        return cantidadProductoresPlacaBase;
    }

    public void setCantidadProductoresPlacaBase(int cantidadProductoresPlacaBase) {
        this.cantidadProductoresPlacaBase = cantidadProductoresPlacaBase;
    }

    public int getCantidadProductoresCPU() {
        return cantidadProductoresCPU;
    }

    public void setCantidadProductoresCPU(int cantidadProductoresCPU) {
        this.cantidadProductoresCPU = cantidadProductoresCPU;
    }

    public int getCantidadProductoresRAM() {
        return cantidadProductoresRAM;
    }

    public void setCantidadProductoresRAM(int cantidadProductoresRAM) {
        this.cantidadProductoresRAM = cantidadProductoresRAM;
    }

    public int getCantidadProductoresFuente() {
        return cantidadProductoresFuente;
    }

    public void setCantidadProductoresFuente(int cantidadProductoresFuente) {
        this.cantidadProductoresFuente = cantidadProductoresFuente;
    }

    public int getCantidadProductoresGrafica() {
        return cantidadProductoresGrafica;
    }

    public void setCantidadProductoresGrafica(int cantidadProductoresGrafica) {
        this.cantidadProductoresGrafica = cantidadProductoresGrafica;
    }

    public int getCantidadEnsamblador() {
        return cantidadEnsamblador;
    }

    public void setCantidadEnsamblador(int cantidadEnsamblador) {
        this.cantidadEnsamblador = cantidadEnsamblador;
    }

    public Trabajador[] getProductoresPlacaBase() {
        return productoresPlacaBase;
    }

    public void setProductoresPlacaBase(Trabajador[] productoresPlacaBase) {
        this.productoresPlacaBase = productoresPlacaBase;
    }

    public Trabajador[] getProductoresCPU() {
        return productoresCPU;
    }

    public void setProductoresCPU(Trabajador[] productoresCPU) {
        this.productoresCPU = productoresCPU;
    }

    public Trabajador[] getProductoresRAM() {
        return productoresRAM;
    }

    public void setProductoresRAM(Trabajador[] productoresRAM) {
        this.productoresRAM = productoresRAM;
    }

    public Trabajador[] getProductoresFuente() {
        return productoresFuente;
    }

    public void setProductoresFuente(Trabajador[] productoresFuente) {
        this.productoresFuente = productoresFuente;
    }

    public Trabajador[] getProductoresGrafica() {
        return productoresGrafica;
    }

    public void setProductoresGrafica(Trabajador[] productoresGrafica) {
        this.productoresGrafica = productoresGrafica;
    }

    public Ensamblador[] getEnsamblador() {
        return ensamblador;
    }

    public void setEnsamblador(Ensamblador[] ensamblador) {
        this.ensamblador = ensamblador;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public long getDuracionDiaMs() {
        return duracionDiaMs;
    }

    public void setDuracionDiaMs(long duracionDiaMs) {
        this.duracionDiaMs = duracionDiaMs;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
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

    public void actualizarCantidadProductores(int tipo, int cantidad) {
        switch (tipo) {
            case 1: // Placa Base
                setCantidadProductoresPlacaBase(cantidad);
                break;
            case 2: // CPU
                setCantidadProductoresCPU(cantidad);
                break;
            case 3: // RAM
                setCantidadProductoresRAM(cantidad);
                break;
            case 4: // Fuente
                setCantidadProductoresFuente(cantidad);
                break;
            case 5: // Gráfica
                setCantidadProductoresGrafica(cantidad);
                break;
            case 6: // Ensamblador
                setCantidadEnsamblador(cantidad);
                break;
        }
        System.out.println("Cantidad de Productores:");
        System.out.println("Placa Base: " + cantidadProductoresPlacaBase);
        System.out.println("CPU: " + cantidadProductoresCPU);
        System.out.println("RAM: " + cantidadProductoresRAM);
        System.out.println("Fuente: " + cantidadProductoresFuente);
        System.out.println("Gráfica: " + cantidadProductoresGrafica);
        System.out.println("Ensamblador: " + cantidadEnsamblador);
        inicializarTrabajadores();
    }
}
