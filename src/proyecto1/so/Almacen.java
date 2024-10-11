/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.so;

/**
 *
 * @author Ignacio
 */
public class Almacen {
    private int cantidadplacabase;
    private int cantidadplacabasemax;
    private int cantidadcpu;
    private int cantidadcpumax;
    private int cantidadram;
    private int cantidadrammax;
    private int cantidadfuente;
    private int cantidadfuentemax;
    private int cantidadgrafica;
    private int cantidadgraficasmax;
    private int cantidadcomputadorasnormales;
    private int cantidadcomputadorascongrafica;

    public Almacen(int cantidadplacabasemax, int cantidadcpumax, int cantidadrammax, int cantidadfuentemax, int cantidadgraficasmax) {
        this.cantidadplacabase = 0;
        this.cantidadplacabasemax = cantidadplacabasemax;
        this.cantidadcpu = 0;
        this.cantidadcpumax = cantidadcpumax;
        this.cantidadram = 0;
        this.cantidadrammax = cantidadrammax;
        this.cantidadfuente = 0;
        this.cantidadfuentemax = cantidadfuentemax;
        this.cantidadgrafica = 0;
        this.cantidadgraficasmax = cantidadgraficasmax;
        this.cantidadcomputadorasnormales = 0;
        this.cantidadcomputadorascongrafica = 0;
    }

    public void produccionAlmacen(int tipo, int contadorProduccion) {
        switch (tipo) {
            case 1: // Placa Base
                if (this.cantidadplacabase + contadorProduccion <= this.cantidadplacabasemax) {
                    this.cantidadplacabase += contadorProduccion;
                    System.out.println("Placas base actuales: " + this.cantidadplacabase);
                } else {
                    System.out.println("Capacidad máxima de placas base alcanzada.");
                }
                break;

            case 2: // CPU
                if (this.cantidadcpu + contadorProduccion <= this.cantidadcpumax) {
                    this.cantidadcpu += contadorProduccion;
                    System.out.println("CPUs actuales: " + this.cantidadcpu);
                } else {
                    System.out.println("Capacidad máxima de CPUs alcanzada.");
                }
                break;

            case 3: // Memoria RAM
                if (this.cantidadram + contadorProduccion <= this.cantidadrammax) {
                    this.cantidadram += contadorProduccion;
                    System.out.println("Memorias RAM actuales: " + this.cantidadram);
                } else {
                    System.out.println("Capacidad máxima de memorias RAM alcanzada.");
                }
                break;

            case 4: // Fuente de Alimentación
                if (this.cantidadfuente + contadorProduccion <= this.cantidadfuentemax) {
                    this.cantidadfuente += contadorProduccion;
                    System.out.println("Fuentes de alimentación actuales: " + this.cantidadfuente);
                } else {
                    System.out.println("Capacidad máxima de fuentes de alimentación alcanzada.");
                }
                break;

            case 5: // Tarjeta Gráfica
                if (this.cantidadgrafica + contadorProduccion <= this.cantidadgraficasmax) {
                    this.cantidadgrafica += contadorProduccion;
                    System.out.println("Tarjetas gráficas actuales: " + this.cantidadgrafica);
                } else {
                    System.out.println("Capacidad máxima de tarjetas gráficas alcanzada.");
                }
                break;

            default:
                System.out.println("Tipo de componente desconocido.");
                break;
        }
    }
    
    public boolean hayPartes(int placasBaseNecesarias, int cpuNecesarias, int ramNecesarias, int fuentesNecesarias) {
        return this.cantidadplacabase >= placasBaseNecesarias &&
               this.cantidadcpu >= cpuNecesarias &&
               this.cantidadram >= ramNecesarias &&
               this.cantidadfuente >= fuentesNecesarias;
    }
    
    public boolean hayPartesGrafica(int placasBaseNecesarias, int cpuNecesarias, int ramNecesarias, int fuentesNecesarias, int graficasNecesarias) {
        return this.cantidadplacabase >= placasBaseNecesarias &&
               this.cantidadcpu >= cpuNecesarias &&
               this.cantidadram >= ramNecesarias &&
               this.cantidadfuente >= fuentesNecesarias &&
               this.cantidadgrafica >= graficasNecesarias;
    }
    
    public void restarPartes(int placasBaseNecesarias, int cpuNecesarias, int ramNecesarias, int fuentesNecesarias) {
        this.cantidadplacabase -= placasBaseNecesarias;
        this.cantidadcpu -= cpuNecesarias;
        this.cantidadram -= ramNecesarias;
        this.cantidadfuente -= fuentesNecesarias;
    }    

    public void restarPartesGrafica(int placasBaseNecesarias, int cpuNecesarias, int ramNecesarias, int fuentesNecesarias, int graficasNecesarias) {
        this.cantidadplacabase -= placasBaseNecesarias;
        this.cantidadcpu -= cpuNecesarias;
        this.cantidadram -= ramNecesarias;
        this.cantidadfuente -= fuentesNecesarias;
        this.cantidadgrafica -= graficasNecesarias;
    } 
    
    public void agregarComputadoraEnsamblada() {
        this.cantidadcomputadorasnormales++;
        System.out.println(cantidadcomputadorasnormales);
    }
    
    public void agregarComputadoraEnsambladaGrafica() {
        this.cantidadcomputadorascongrafica++;
        System.out.println(cantidadcomputadorascongrafica);
    }
    
}    

