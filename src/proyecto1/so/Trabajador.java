/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.so;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ignacio
 */
public class Trabajador extends Thread {
    private float produccionPorDia;  
    private float salario;           
    private float salarioAcumulado;  
    private int duracionDiaSeg;      
    private int tipo;             
    private float contadorProduccion;  
    private Empresa empresa;
    private int diastotal; 

    public Trabajador(float produccionPorDia, float salario, int duracionDiaSeg, int tipo, Empresa empresa) {
        this.produccionPorDia = produccionPorDia;
        this.salario = salario;
        this.salarioAcumulado = 0;
        this.duracionDiaSeg = duracionDiaSeg;
        this.tipo = tipo; // 1. placabase, 2. cpu, 3. ram, 4. fuente, 5. graficas
        this.contadorProduccion = 0;
        this.empresa = empresa;
    }

    public void pagarSalario() {
        this.salarioAcumulado += this.salario;
    }

    public void producirPorDia() {
        this.contadorProduccion += this.produccionPorDia;
      
        if (this.contadorProduccion >= 1) {
            try {
                empresa.mutex.acquire();  
                empresa.almacen.produccionAlmacen(this.tipo, (int) this.contadorProduccion);
                empresa.mutex.release();
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
                diastotal++;
                System.out.println("Dias: " + diastotal);
                pagarSalario();
                producirPorDia();
                sleep(this.duracionDiaSeg);  
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
