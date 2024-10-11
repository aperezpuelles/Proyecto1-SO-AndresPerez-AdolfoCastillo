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
public class Ensamblador extends Thread{ 
    private int duracionDiaSeg;
    private float salario;
    private float salarioAcumulado;
    private int computadorasNormalesMinimas;
    private int contadorComputadorasSinGrafica;
    private Empresa empresa;
    private int placasBaseNecesarias;
    private int cpuNecesarias;
    private int ramNecesarias;
    private int fuentesNecesarias;
    private int graficasNecesarias;
    private int contadorDias;

    public Ensamblador(int duracionDiaSeg, Empresa empresa) {
        this.duracionDiaSeg = duracionDiaSeg;
        this.salario = 50;
        this.salarioAcumulado = 0;
        this.empresa = empresa;
        if (empresa.getNombre().equals("Dell")) {
            this.placasBaseNecesarias = 1;
            this.cpuNecesarias = 5;
            this.ramNecesarias = 6;
            this.fuentesNecesarias = 5;
            this.graficasNecesarias = 1;
            this.computadorasNormalesMinimas = 3;
        } else if (empresa.getNombre().equals("MSI")) {
            this.placasBaseNecesarias = 2;
            this.cpuNecesarias = 3;
            this.ramNecesarias = 4;
            this.fuentesNecesarias = 6;
            this.graficasNecesarias = 5;
            this.computadorasNormalesMinimas = 6;
        }
        this.contadorComputadorasSinGrafica = 0;
    }
    
    public void pagarSalario() {
        this.salarioAcumulado += this.salario;
    }
    
    private void ensamblarComputadoraNormal() {
        try {
            empresa.mutex.acquire(); 
            if (empresa.almacen.hayPartes(placasBaseNecesarias, cpuNecesarias, ramNecesarias, fuentesNecesarias)) {
                empresa.almacen.restarPartes(placasBaseNecesarias, cpuNecesarias, ramNecesarias, fuentesNecesarias);
                contadorComputadorasSinGrafica++;
                empresa.almacen.agregarComputadoraEnsamblada();
                empresa.mutex.release();
            } else {
                empresa.mutex.release();
                System.out.println("No hay suficientes partes para ensamblar una computadora.");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    private void ensamblarComputadoraGrafica() {
        try {
            contadorComputadorasSinGrafica = 0;
            empresa.mutex.acquire(); 
            if (empresa.almacen.hayPartesGrafica(placasBaseNecesarias, cpuNecesarias, ramNecesarias, fuentesNecesarias, graficasNecesarias)) {
                empresa.almacen.restarPartesGrafica(placasBaseNecesarias, cpuNecesarias, ramNecesarias, fuentesNecesarias, graficasNecesarias);
                empresa.almacen.agregarComputadoraEnsambladaGrafica();
                empresa.mutex.release();
            } else {
                empresa.mutex.release();
                System.out.println("No hay suficientes partes para ensamblar una computadora con gráfica.");
            }
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
                contadorDias++;
                System.out.println("Sin grafica" + empresa.getNombre() + contadorComputadorasSinGrafica);
                System.out.println("Dia: " + contadorDias);
                if (contadorDias >= 2) {
                    if (computadorasNormalesMinimas <= contadorComputadorasSinGrafica){
                        ensamblarComputadoraGrafica();
                        contadorDias = 0;                     
                    }else{
                        ensamblarComputadoraNormal();
                        contadorDias = 0;                     
                    }
                }
                sleep(this.duracionDiaSeg);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
