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
public class ProjectManager extends Thread {
    private float produccionPorDia;  
    private int salario;           
    private float salarioAcumulado;  
    private long duracionDiaMs;               
    private float contadorProduccion;  
    private Empresa empresa;
    private String modo;

    public ProjectManager(float produccionPorDia, long duracionDiaMs, int tipo, Empresa empresa) {
        this.produccionPorDia = produccionPorDia;
        this.salario = 40;
        this.salarioAcumulado = 0;
        this.duracionDiaMs = duracionDiaMs;
        this.contadorProduccion = 0;
        this.empresa = empresa;
        this.modo = modo;
    }

    public void pagarSalario() {
        this.salarioAcumulado += this.salario;
    }
    
    public void verAnime(){
        for (int i = 0; i == 31; i++){
            if (this.modo == "viendo anime"){
                this.modo = "trabajando";
            } else {
                this.modo = "viendo anime";
            }
            try {
            sleep(21);  
            } catch (InterruptedException ex) {
            ex.printStackTrace();
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
                verAnime();
                sleep(this.duracionDiaMs);  
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
