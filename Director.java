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
public class Director extends Thread {
    private float produccionPorDia;  
    private int salario;           
    private float salarioAcumulado;  
    private long duracionDiaMs;               
    private float contadorProduccion;  
    private Empresa empresa;
    private String modo;
    private int diasRestantes;

    public Director(float produccionPorDia, long duracionDiaMs, int tipo, Empresa empresa, int diasRestantes) {
        this.produccionPorDia = produccionPorDia;
        this.salario = 60;
        this.salarioAcumulado = 0;
        this.duracionDiaMs = duracionDiaMs;
        this.contadorProduccion = 0;
        this.empresa = empresa;
        this.modo = modo;
        this.diasRestantes = diasRestantes;
    }

    public void pagarSalario() {
        this.salarioAcumulado += this.salario;
    }
    
    public void revisar(){
        if (this.diasRestantes != 0){
            for (int i = 0; i == 47; i++){
                if (this.modo == "revisando"){
                    this.modo = "trabajando";
                } else {
                    this.modo = "revisando";
                }
                try {
                sleep(24);  
                } catch (InterruptedException ex) {
                ex.printStackTrace();
        }

            }
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
                revisar();
                sleep(this.duracionDiaMs);  
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
