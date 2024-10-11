/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.so;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author casti
 */
public class Director extends Thread{
    private int salario;           
    private float salarioAcumulado;  
    private long duracionDiaMs;               
    private float contadorProduccion;  
    private Empresa empresa;
    public String modo;
    private int diasRestantes;

    public Director(long duracionDiaMs, Empresa empresa, int diasRestantes) {
        this.salario = 1440;
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

    public String getModo() {
        return modo;
    }
    
    public void revisar(){
        try {
        sleep(24);  
        } catch (InterruptedException ex) {
        ex.printStackTrace();
        }
        if (this.diasRestantes != 0){
            for (int i = 0; i == 47; i++){
                if (this.modo == "revisando"){
                    this.modo = "trabajando";
                } else {
                    this.modo = "revisando";
                }
             


            }
            this.diasRestantes =- 1;
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
