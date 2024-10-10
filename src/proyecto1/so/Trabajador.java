/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.so;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Ignacio
 */
public class Trabajador extends Thread {
    private float produccionPorDia;  
    private float salario;           
    private float salarioAcumulado;  
    private long duracionDiaMs;      
    private int tipo;             
    private float contadorProduccion;  
    private Almacen almacen;
    private Semaphore mutex;

    public Trabajador(float produccionPorDia, float salario, long duracionDiaMs, int tipo, Almacen almacen, Semaphore mutex) {
        this.produccionPorDia = produccionPorDia;
        this.salario = salario;
        this.salarioAcumulado = 0;
        this.duracionDiaMs = duracionDiaMs;
        this.tipo = tipo; // 1. placabase, 2. cpu, 3. ram, 4. fuente, 5. graficas
        this.contadorProduccion = 0;
        this.almacen = almacen;
        this.mutex = mutex;
    }

    public void pagarSalario() {
        this.salarioAcumulado += this.salario;
    }

    public void producirPorDia() {
        this.contadorProduccion += this.produccionPorDia;

      
        if (this.contadorProduccion >= 1) {
            try {
                mutex.acquire();  
                almacen.actualizarAlmacen(this.tipo, (int) this.contadorProduccion);
                mutex.release();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            this.contadorProduccion = 0;
        }
    }    
    
    public void run() {
        try {
            sleep(1000);  
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        while (true) {
            try {
                pagarSalario();
                producirPorDia();
                sleep(this.duracionDiaMs);  
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
