/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.so;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1.so.Director; 
/**
 *
 * @author casti
 */
public class ProjectManager extends Thread{
    private int salario;           
    private float salarioAcumulado;  
    private long duracionDiaMs;               
    private float contadorProduccion;  
    private Empresa empresa;
    private String modo;

    public ProjectManager( long duracionDiaMs, Empresa empresa) {
        this.salario = 960;
        this.salarioAcumulado = 0;
        this.duracionDiaMs = duracionDiaMs;
        this.contadorProduccion = 0;
        this.empresa = empresa;
        this.modo = modo;
    }

    public String getModo() {
        return modo;
    }

    public void pagarSalario() {
        this.salarioAcumulado += this.salario;
    }
    
    public void verAnime(){
        try {
            sleep(21);  
            } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i == 31; i++){
            if (this.modo == "viendo anime"){
                this.modo = "trabajando";
            } else {
                this.modo = "viendo anime";
            }

            }
        try {
            sleep(250);  
            } catch (InterruptedException ex) {
            ex.printStackTrace();
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
