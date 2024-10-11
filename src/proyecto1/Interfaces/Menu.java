/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.Interfaces;
import java.io.IOException;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import proyecto1.so.ConfiguracionTXT;
import proyecto1.so.Empresa;
import proyecto1.so.Almacen;
/**
 *
 * @author casti
 */
public class Menu extends javax.swing.JFrame {
    private Empresa dell;
    private Empresa msi;
    public ConfiguracionTXT configuracion;
    /**
     * Creates new form Menu
     */
    public Menu() throws IOException {
        configuracion = new ConfiguracionTXT("parametros.txt");
        try {
            configuracion.verificarYCrearArchivo();
            int[] parametros = configuracion.leerParametros();
            
            // Los parámetros del archivo:
            // [0] - Duración en segundos de un día dentro de la simulación
            // [1] - Cantidad de días entre las entregas de las computadoras
            // [2] - Productores de placa base
            // [3] - Productores de CPU
            // [4] - Productores de RAM
            // [5] - Productores de fuente
            // [6] - Productores de gráfica
            // [7] - Ensambladores

            msi = new Empresa("MSI", 15, parametros[2], parametros[3], parametros[4], parametros[5], parametros[6], parametros[7], parametros[0]*1000);
            dell = new Empresa("Dell", 12, parametros[2], parametros[3], parametros[4], parametros[5], parametros[6], parametros[7], parametros[0]*1000);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(configuracion);
        initComponents();
        
        int[] parametros = configuracion.leerParametros();
        SpinnerNumberModel modelDPlaca = new SpinnerNumberModel(parametros[2], 1, dell.getMaximoTrabajadores(), 1);
        DPlaca.setModel(modelDPlaca);
        DPlaca.addChangeListener(e -> actualizarMaximosDell());
        DPlaca.addChangeListener(e -> actualizarSpinnerDell(DPlaca, 1));
        
        SpinnerNumberModel modelDCPU = new SpinnerNumberModel(parametros[3], 1, dell.getMaximoTrabajadores(), 1);
        DCPU.setModel(modelDCPU);
        DCPU.addChangeListener(e -> actualizarMaximosDell());
        DCPU.addChangeListener(e -> actualizarSpinnerDell(DCPU, 2));

        SpinnerNumberModel modelDRAM = new SpinnerNumberModel(parametros[4], 1, dell.getMaximoTrabajadores(), 1);
        DRAM.setModel(modelDRAM);
        DRAM.addChangeListener(e -> actualizarMaximosDell());
        DRAM.addChangeListener(e -> actualizarSpinnerDell(DRAM, 3));

        SpinnerNumberModel modelDFuente = new SpinnerNumberModel(parametros[5], 1, dell.getMaximoTrabajadores(), 1);
        DFuente.setModel(modelDFuente);
        DFuente.addChangeListener(e -> actualizarMaximosDell());
        DFuente.addChangeListener(e -> actualizarSpinnerDell(DFuente, 4));

        SpinnerNumberModel modelDGrafica = new SpinnerNumberModel(parametros[6], 1, dell.getMaximoTrabajadores(), 1);
        DGrafica.setModel(modelDGrafica);
        DGrafica.addChangeListener(e -> actualizarMaximosDell());
        DGrafica.addChangeListener(e -> actualizarSpinnerDell(DGrafica, 5));

        SpinnerNumberModel modelDEnsamblador = new SpinnerNumberModel(parametros[7], 1, dell.getMaximoTrabajadores(), 1);
        DEnsamblador.setModel(modelDEnsamblador);
        DEnsamblador.addChangeListener(e -> actualizarMaximosDell());
        DEnsamblador.addChangeListener(e -> actualizarSpinnerDell(DEnsamblador, 6));
        
        SpinnerNumberModel modelMPlaca = new SpinnerNumberModel(parametros[2], 1, msi.getMaximoTrabajadores(), 1);
        MPlaca.setModel(modelMPlaca);
        MPlaca.addChangeListener(e -> actualizarMaximosMSI());
        MPlaca.addChangeListener(e -> actualizarSpinnerMsi(MPlaca, 1));
        
        SpinnerNumberModel modelMCPU = new SpinnerNumberModel(parametros[3], 1, msi.getMaximoTrabajadores(), 1);
        MCPU.setModel(modelMCPU);
        MCPU.addChangeListener(e -> actualizarMaximosMSI());
        MCPU.addChangeListener(e -> actualizarSpinnerMsi(MCPU, 2));

        SpinnerNumberModel modelMRAM = new SpinnerNumberModel(parametros[4], 1, msi.getMaximoTrabajadores(), 1);
        MRAM.setModel(modelMRAM);
        MRAM.addChangeListener(e -> actualizarMaximosMSI());
        MRAM.addChangeListener(e -> actualizarSpinnerMsi(MRAM, 3));

        SpinnerNumberModel modelMFuente = new SpinnerNumberModel(parametros[5], 1, msi.getMaximoTrabajadores(), 1);
        MFuente.setModel(modelMFuente);
        MFuente.addChangeListener(e -> actualizarMaximosMSI());
        MFuente.addChangeListener(e -> actualizarSpinnerMsi(MFuente, 4));

        SpinnerNumberModel modelMGrafica = new SpinnerNumberModel(parametros[6], 1, msi.getMaximoTrabajadores(), 1);
        MGrafica.setModel(modelMGrafica);
        MGrafica.addChangeListener(e -> actualizarMaximosMSI());
        MGrafica.addChangeListener(e -> actualizarSpinnerMsi(MGrafica, 5));

        SpinnerNumberModel modelMEnsamblador = new SpinnerNumberModel(parametros[7], 1, msi.getMaximoTrabajadores(), 1);
        MEnsamblador.setModel(modelMEnsamblador);
        MEnsamblador.addChangeListener(e -> actualizarMaximosMSI());
        MEnsamblador.addChangeListener(e -> actualizarSpinnerMsi(MEnsamblador, 6));          
     
//        SpinnerNumberModel Dp = new SpinnerNumberModel();
 //       Dp.setMinimum(1);
//        Dp.setValue(1);
 //       DPlaca.setModel(Dp);
        
//        SpinnerNumberModel Dc = new SpinnerNumberModel();
//        Dc.setMinimum(1);
//        Dc.setValue(1);
 //       DCPU.setModel(Dc);
        
 //       SpinnerNumberModel Dr = new SpinnerNumberModel();
 //       Dr.setMinimum(1);
//        Dr.setValue(1);
//        DRAM.setModel(Dr);
        
 //       SpinnerNumberModel Df = new SpinnerNumberModel();
//        Df.setMinimum(1);
//        Df.setValue(1);
//        DFuente.setModel(Df);
        
 //       SpinnerNumberModel Dg = new SpinnerNumberModel();
//        Dg.setMinimum(1);
//        Dg.setValue(1);
 //       DGrafica.setModel(Dg);
        
 //       SpinnerNumberModel De = new SpinnerNumberModel();
 //       De.setMinimum(1);
 //       De.setValue(1);
 //       DEnsamblador.setModel(Dg);

        
//        SpinnerNumberModel Mp = new SpinnerNumberModel();
//        Mp.setMinimum(1);
//        Mp.setValue(1);
//        MPlaca.setModel(Mp);
        
 //       SpinnerNumberModel Mc = new SpinnerNumberModel();
//        Mc.setMinimum(1);
//        Mc.setValue(1);
 //       MCPU.setModel(Mc);
        
//        SpinnerNumberModel Mr = new SpinnerNumberModel();
//        Mr.setMinimum(1);
//        Mr.setValue(1);
//        MRAM.setModel(Mr);
        
//        SpinnerNumberModel Mf = new SpinnerNumberModel();
//        Mf.setMinimum(1);
//        Mf.setValue(1);
//        MFuente.setModel(Mf);
        
//        SpinnerNumberModel Mg = new SpinnerNumberModel();
//        Mg.setMinimum(1);
//       Mg.setValue(1);
//        MGrafica.setModel(Mg);
        
//       SpinnerNumberModel Me = new SpinnerNumberModel();
//        Me.setMinimum(1);
//        Me.setValue(1);
//        MEnsamblador.setModel(Me);
       
        
//        int limit1 = (int)DPlaca.getValue() + (int)DCPU.getValue() + (int)DRAM.getValue() + (int)DFuente.getValue() + (int)DGrafica.getValue();
//        while (limit1 >= 12){
//            nm.setMaximum(0);
//        }
        
    }
    
    private void actualizarSpinnerDell(JSpinner spinner, int tipo) {
        int cantidad = (int) spinner.getValue();
        dell.actualizarCantidadProductores(tipo, cantidad);
        actualizarMaximosDell();
    }
    
    private void actualizarSpinnerMsi(JSpinner spinner, int tipo) {
        int cantidad = (int) spinner.getValue();
        msi.actualizarCantidadProductores(tipo, cantidad);
        actualizarMaximosMSI();
    }
    
    private void actualizarMaximosDell() {
        int totalDell = (int) DPlaca.getValue() + (int) DCPU.getValue() + (int) DRAM.getValue() + (int) DFuente.getValue() + (int) DGrafica.getValue() + (int) DEnsamblador.getValue();

        int maximoDell = dell.getMaximoTrabajadores();

        if (totalDell >= maximoDell) {
            ajustarLimitesSpinnersDell(maximoDell, totalDell);
        } else {
            actualizarLimitesSpinnersDell();
        }
    }

    private void actualizarMaximosMSI() {
        int totalMsi = (int) MPlaca.getValue() + (int) MCPU.getValue() + (int) MRAM.getValue() + (int) MFuente.getValue() + (int) MGrafica.getValue() + (int) MEnsamblador.getValue();

        int maximoMsi = msi.getMaximoTrabajadores();

        if (totalMsi >= maximoMsi) {
            ajustarLimitesSpinnersMSI(maximoMsi, totalMsi);
        } else {
            actualizarLimitesSpinnersMsi();
        }
    }
    
    private void ajustarLimitesSpinnersDell(int maximoDell, int totalDell) {
        int maxRestante = maximoDell - totalDell;
        DPlaca.setModel(new SpinnerNumberModel((int) DPlaca.getValue(), 1, maxRestante + (int) DPlaca.getValue(), 1));
        DCPU.setModel(new SpinnerNumberModel((int) DCPU.getValue(), 1, maxRestante + (int) DCPU.getValue(), 1));
        DRAM.setModel(new SpinnerNumberModel((int) DRAM.getValue(), 1, maxRestante + (int) DRAM.getValue(), 1));
        DFuente.setModel(new SpinnerNumberModel((int) DFuente.getValue(), 1, maxRestante + (int) DFuente.getValue(), 1));
        DGrafica.setModel(new SpinnerNumberModel((int) DGrafica.getValue(), 1, maxRestante + (int) DGrafica.getValue(), 1));
        DEnsamblador.setModel(new SpinnerNumberModel((int) DEnsamblador.getValue(), 1, maxRestante + (int) DEnsamblador.getValue(), 1));
    }

    private void ajustarLimitesSpinnersMSI(int maximoMsi, int totalMsi) {
        int maxRestante = maximoMsi - totalMsi;
        MPlaca.setModel(new SpinnerNumberModel((int) MPlaca.getValue(), 1, maxRestante + (int) MPlaca.getValue(), 1));
        MCPU.setModel(new SpinnerNumberModel((int) MCPU.getValue(), 1, maxRestante + (int) MCPU.getValue(), 1));
        MRAM.setModel(new SpinnerNumberModel((int) MRAM.getValue(), 1, maxRestante + (int) MRAM.getValue(), 1));
        MFuente.setModel(new SpinnerNumberModel((int) MFuente.getValue(), 1, maxRestante + (int) MFuente.getValue(), 1));
        MGrafica.setModel(new SpinnerNumberModel((int) MGrafica.getValue(), 1, maxRestante + (int) MGrafica.getValue(), 1));
        MEnsamblador.setModel(new SpinnerNumberModel((int) MEnsamblador.getValue(), 1, maxRestante + (int) MEnsamblador.getValue(), 1));
    }

    private void actualizarLimitesSpinnersDell() {
        int totalDell = (int) DPlaca.getValue() + (int) DCPU.getValue() + (int) DRAM.getValue() + (int) DFuente.getValue() + (int) DGrafica.getValue() + (int) DEnsamblador.getValue();

        DPlaca.setModel(new SpinnerNumberModel((int) DPlaca.getValue(), 1, dell.getMaximoTrabajadores() - totalDell + (int) DPlaca.getValue(), 1));
        DCPU.setModel(new SpinnerNumberModel((int) DCPU.getValue(), 1, dell.getMaximoTrabajadores() - totalDell + (int) DCPU.getValue(), 1));
        DRAM.setModel(new SpinnerNumberModel((int) DRAM.getValue(), 1, dell.getMaximoTrabajadores() - totalDell + (int) DRAM.getValue(), 1));
        DFuente.setModel(new SpinnerNumberModel((int) DFuente.getValue(), 1, dell.getMaximoTrabajadores() - totalDell + (int) DFuente.getValue(), 1));
        DGrafica.setModel(new SpinnerNumberModel((int) DGrafica.getValue(), 1, dell.getMaximoTrabajadores() - totalDell + (int) DGrafica.getValue(), 1));
        DEnsamblador.setModel(new SpinnerNumberModel((int) DEnsamblador.getValue(), 1, dell.getMaximoTrabajadores() - totalDell + (int) DEnsamblador.getValue(), 1));
    }

    private void actualizarLimitesSpinnersMsi() {
        int totalMSI = (int) MPlaca.getValue() + (int) MCPU.getValue() + (int) MRAM.getValue() + (int) MFuente.getValue() + (int) MGrafica.getValue() + (int) MEnsamblador.getValue();

        MPlaca.setModel(new SpinnerNumberModel((int) MPlaca.getValue(), 1, msi.getMaximoTrabajadores() - totalMSI + (int) MPlaca.getValue(), 1));
        MCPU.setModel(new SpinnerNumberModel((int) MCPU.getValue(), 1, msi.getMaximoTrabajadores() - totalMSI + (int) MCPU.getValue(), 1));
        MRAM.setModel(new SpinnerNumberModel((int) MRAM.getValue(), 1, msi.getMaximoTrabajadores() - totalMSI + (int) MRAM.getValue(), 1));
        MFuente.setModel(new SpinnerNumberModel((int) MFuente.getValue(), 1, msi.getMaximoTrabajadores() - totalMSI + (int) MFuente.getValue(), 1));
        MGrafica.setModel(new SpinnerNumberModel((int) MGrafica.getValue(), 1, msi.getMaximoTrabajadores() - totalMSI + (int) MGrafica.getValue(), 1));
        MEnsamblador.setModel(new SpinnerNumberModel((int) MEnsamblador.getValue(), 1, msi.getMaximoTrabajadores() - totalMSI + (int) MEnsamblador.getValue(), 1));
    }
    
    private void cargarConfiguracion() {
        try {
            int[] parametros = configuracion.leerParametros();
            txtDuracion.setText(String.valueOf(parametros[0]));
            txtDiasEntrega.setText(String.valueOf(parametros[1]));
            txtPlacaBase.setText(String.valueOf(parametros[2]));
            txtCPU.setText(String.valueOf(parametros[3]));
            txtRAM.setText(String.valueOf(parametros[4]));
            txtFuente.setText(String.valueOf(parametros[5]));
            txtGrafica.setText(String.valueOf(parametros[6]));
            txtEnsamblador.setText(String.valueOf(parametros[7]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private boolean configurar() {
        System.out.println(this.configuracion);
        try {
            int duracion = validarNumero(txtDuracion, "Duración del día");
            int diasEntrega = validarNumero(txtDiasEntrega, "Días entre entregas");
            int placaBase = validarNumero(txtPlacaBase, "Productores Placa Base");
            int cpu = validarNumero(txtCPU, "Productores CPU");
            int ram = validarNumero(txtRAM, "Productores RAM");
            int fuente = validarNumero(txtFuente, "Productores Fuente de Poder");
            int grafica = validarNumero(txtGrafica, "Productores Gráfica");
            int ensamblador = validarNumero(txtEnsamblador, "Ensambladores");

            int totalTrabajadores = placaBase + cpu + ram + fuente + grafica + ensamblador;
            if (totalTrabajadores > dell.getMaximoTrabajadores()) {
                JOptionPane.showMessageDialog(this, "La suma de los trabajadores no puede exceder el máximo permitido.", "Error", JOptionPane.ERROR_MESSAGE);
                return true;
            }
            System.out.println(configuracion);
            configuracion.guardarParametros(duracion, diasEntrega, placaBase, cpu, ram, fuente, grafica, ensamblador);
            JOptionPane.showMessageDialog(this, "Parámetros guardados correctamente.");
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar parámetros: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private int validarNumero(JTextField campo, String nombreCampo) throws NumberFormatException {
        int valor = Integer.parseInt(campo.getText());
        if (valor <= 0) {
            throw new NumberFormatException(nombreCampo + " debe ser un número positivo.");
        }
        return valor;
        }
    
    private void utilidad(){
        int cont = 7;
        try {
            sleep(1000);  
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        int utilidadDell = 0;
        int utilidadMsi = 0;
        while (true) {
            if (cont == 0){
                cont = 7;
                /*utilidadDell = -(dell.getContplacasD()*480)-(dell.getContcpuD()*624)-(dell.getContramD()*800)-(dell.getContfuenteD()*384)-(dell.getContgraficaD()*816)-(dell.getContensambladorD()*960)-960-1440;
                utilidadMsi = -(msi.getContplacasM()*480)-(msi.getContcpuM()*624)-(msi.getContramM()*800)-(msi.getContfuenteM()*384)-(msi.getContgraficaM()*816)-(msi.getContensambladorM()*960)-960-1440;
                jLabel32.setText(Integer.toString(cont));*/
                utilidadDell = (dell.almacen.getCantidadcomputadorasnormales()*80000)+((dell.almacen.getCantidadcomputadorascongrafica()*120000)-(dell.getContplacasD()*480)-(dell.getContcpuD()*624)-(dell.getContramD()*800)-(dell.getContfuenteD()*384)-(dell.getContgraficaD()*816)-(dell.getContensambladorD()*960)-960-1440)*7;
                utilidadMsi = (msi.almacen.getCantidadcomputadorasnormales()*180000)+((msi.almacen.getCantidadcomputadorascongrafica()*250000)-(msi.getContplacasM()*480)-(msi.getContcpuM()*624)-(msi.getContramM()*800)-(msi.getContfuenteM()*384)-(msi.getContgraficaM()*816)-(msi.getContensambladorM()*960)-960-1440)*7;
                dell.almacen.setCantidadcomputadorasnormales(0);
                dell.almacen.setCantidadcomputadorascongrafica(0);
                msi.almacen.setCantidadcomputadorasnormales(0);
                msi.almacen.setCantidadcomputadorascongrafica(0);
            } else{
                
                cont =- 1;
            }
        }
    }
    
    private boolean ciclo(){
        int cont = 7;
        try {
            sleep(1000);  
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        while (true){
            if (cont > 0){
                cont--;
            }else{
                return true;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jSpinner6 = new javax.swing.JSpinner();
        jSpinner11 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel1 = new java.awt.Panel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        DCPU = new javax.swing.JSpinner();
        MPlaca = new javax.swing.JSpinner();
        DFuente = new javax.swing.JSpinner();
        DPlaca = new javax.swing.JSpinner();
        DRAM = new javax.swing.JSpinner();
        DGrafica = new javax.swing.JSpinner();
        MEnsamblador = new javax.swing.JSpinner();
        DEnsamblador = new javax.swing.JSpinner();
        MCPU = new javax.swing.JSpinner();
        MRAM = new javax.swing.JSpinner();
        MGrafica = new javax.swing.JSpinner();
        MFuente = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        txtDiasEntrega = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPlacaBase = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtCPU = new javax.swing.JTextField();
        txtRAM = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtFuente = new javax.swing.JTextField();
        txtGrafica = new javax.swing.JTextField();
        txtEnsamblador = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnConfigurar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setLabelFor(jLabel1);
        jLabel8.setText("Trabajadores Dell: 12");
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 192, 30));

        jLabel9.setText("Productores CPU");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 130, -1));

        jLabel10.setText("CPU");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        jLabel11.setText("Memoria RAM");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel12.setText("Fuente de alimentación");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jLabel13.setText("Ensambladores");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel1.setLabelFor(jLabel1);
        jLabel1.setText("Configuración");
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 252, 72));

        jLabel2.setText("Placa Base");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        jLabel3.setText("CPU");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel4.setText("Memoria RAM");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        jLabel5.setText("Fuente de alimentación");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));

        jLabel6.setText("Tarjeta Gráfica");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setLabelFor(jLabel1);
        jLabel7.setText("Modificar parametros iniciales:");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 250, 30));

        jLabel14.setText("Placa Base");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel15.setText("Tarjeta Gráfica");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel16.setText("Ensambladores");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));
        jPanel2.add(DCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));
        jPanel2.add(MPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));
        jPanel2.add(DFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));
        jPanel2.add(DPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));
        jPanel2.add(DRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));
        jPanel2.add(DGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));
        jPanel2.add(MEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));
        jPanel2.add(DEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, -1, -1));
        jPanel2.add(MCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));
        jPanel2.add(MRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));
        jPanel2.add(MGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, 20));
        jPanel2.add(MFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setLabelFor(jLabel1);
        jLabel17.setText("Trabajadores MSI: 15");
        jLabel17.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 190, 30));

        txtDiasEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiasEntregaActionPerformed(evt);
            }
        });
        jPanel2.add(txtDiasEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 70, -1));

        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });
        jPanel2.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 70, -1));

        jLabel18.setText("Ensambladores");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 150, -1));

        txtPlacaBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaBaseActionPerformed(evt);
            }
        });
        jPanel2.add(txtPlacaBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 70, -1));

        jLabel19.setText("Dias entre entregas");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 130, -1));

        txtCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPUActionPerformed(evt);
            }
        });
        jPanel2.add(txtCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 70, 20));

        txtRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRAMActionPerformed(evt);
            }
        });
        jPanel2.add(txtRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 70, -1));

        jLabel20.setText("Productores placa base");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 160, -1));

        jLabel21.setText("Duracion de dias");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 120, -1));

        txtFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuenteActionPerformed(evt);
            }
        });
        jPanel2.add(txtFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 70, -1));

        txtGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGraficaActionPerformed(evt);
            }
        });
        jPanel2.add(txtGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 70, -1));

        txtEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnsambladorActionPerformed(evt);
            }
        });
        jPanel2.add(txtEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 70, -1));

        jLabel22.setText("Productores RAM");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 130, -1));

        jLabel23.setText("Productores Fuentes");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 140, -1));

        jLabel24.setText("Productores Graficas");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 150, -1));

        btnConfigurar.setText("Actualizar");
        btnConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarActionPerformed(evt);
            }
        });
        jPanel2.add(btnConfigurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, -1, -1));

        jTabbedPane2.addTab("Configuracion", jPanel2);

        jLabel62.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel62.setText("Dell");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Cantidad de componentes producidos:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Placas Base:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("CPU:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("RAM:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Fuentes de Alimentación:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Tarjetas Gráficas:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Computadoras Normales:");

        jLabel33.setText("0");
        jLabel33.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel33AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel34.setText("0");
        jLabel34.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel34AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel35.setText("0");
        jLabel35.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel35AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel36.setText("0");
        jLabel36.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel36AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel37.setText("0");
        jLabel37.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel37AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel38.setText("0");
        jLabel38.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel38AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Computadoras con Gráfica:");

        jLabel40.setText("0");
        jLabel40.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel40AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setText("7 días");
        jLabel32.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel32AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel55.setText("Pago cada:");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel56.setText("Utilidad:");

        jLabel57.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel57.setText("valor");
        jLabel57.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel57AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(142, 142, 142)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel29))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1242, Short.MAX_VALUE)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jLabel55)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel25)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel36)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dell", jPanel3);

        jLabel63.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel63.setText("MSI");

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel64.setText("Cantidad de componentes producidos:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Computadoras con Gráfica:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Computadoras Normales:");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Tarjetas Gráficas:");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Fuentes de Alimentación:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("RAM:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("CPU:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Placas Base:");

        jLabel48.setText("0");
        jLabel48.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel48AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel49.setText("0");
        jLabel49.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel49AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel50.setText("0");
        jLabel50.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel50AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel51.setText("0");
        jLabel51.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel51AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel52.setText("0");
        jLabel52.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel52AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel53.setText("0");
        jLabel53.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel53AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel54.setText("0");
        jLabel54.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel54AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel58.setText("Utilidad:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel59.setText("valor");
        jLabel59.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel59AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel60.setText("Pago cada:");

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel61.setText("7 días");
        jLabel61.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel61AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel46))
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel43))
                        .addGap(56, 56, 56)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1114, Short.MAX_VALUE)
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel50)
                            .addComponent(jLabel54)
                            .addComponent(jLabel53))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel64)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel60)
                .addGap(18, 18, 18)
                .addComponent(jLabel61)
                .addGap(197, 197, 197))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel64))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel63)
                        .addGap(43, 43, 43)))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel49)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(jLabel58))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel50))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel51))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel53))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel54))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Msi", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiasEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiasEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiasEntregaActionPerformed

    private void txtDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionActionPerformed

    private void txtPlacaBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaBaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaBaseActionPerformed

    private void txtCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPUActionPerformed

    private void txtRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRAMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRAMActionPerformed

    private void txtFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFuenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuenteActionPerformed

    private void txtGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGraficaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGraficaActionPerformed

    private void txtEnsambladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnsambladorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnsambladorActionPerformed

    private void btnConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarActionPerformed
        // TODO add your handling code here:
        configurar();
    }//GEN-LAST:event_btnConfigurarActionPerformed
    private void jLabel33AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel33AncestorAdded
        //int valor = Almacen.getCantidadplacabase();
        jLabel33.setText(Integer.toString(dell.almacen.getCantidadplacabase()));
    }//GEN-LAST:event_jLabel33AncestorAdded

    private void jLabel34AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel34AncestorAdded
        // TODO add your handling code here:
        jLabel34.setText(Integer.toString(dell.almacen.getCantidadcpu()));
    }//GEN-LAST:event_jLabel34AncestorAdded

    private void jLabel35AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel35AncestorAdded
        // TODO add your handling code here:
        jLabel35.setText(Integer.toString(dell.almacen.getCantidadram()));
    }//GEN-LAST:event_jLabel35AncestorAdded

    private void jLabel36AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel36AncestorAdded
        // TODO add your handling code here:
        jLabel36.setText(Integer.toString(dell.almacen.getCantidadfuente()));
    }//GEN-LAST:event_jLabel36AncestorAdded

    private void jLabel37AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel37AncestorAdded
        // TODO add your handling code here:
        jLabel37.setText(Integer.toString(dell.almacen.getCantidadgrafica()));
    }//GEN-LAST:event_jLabel37AncestorAdded

    private void jLabel38AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel38AncestorAdded
        // TODO add your handling code here:
        jLabel38.setText(Integer.toString(dell.almacen.getCantidadcomputadorasnormales()));
    }//GEN-LAST:event_jLabel38AncestorAdded

    private void jLabel40AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel40AncestorAdded
        // TODO add your handling code here:
        jLabel40.setText(Integer.toString(dell.almacen.getCantidadcomputadorascongrafica()));
    }//GEN-LAST:event_jLabel40AncestorAdded

    private void jLabel48AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel48AncestorAdded
        // TODO add your handling code here:
        jLabel48.setText(Integer.toString(msi.almacen.getCantidadplacabase()));
    }//GEN-LAST:event_jLabel48AncestorAdded

    private void jLabel49AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel49AncestorAdded
        // TODO add your handling code here:
        jLabel49.setText(Integer.toString(msi.almacen.getCantidadcpu()));
    }//GEN-LAST:event_jLabel49AncestorAdded

    private void jLabel50AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel50AncestorAdded
        // TODO add your handling code here:
        jLabel50.setText(Integer.toString(msi.almacen.getCantidadram()));
    }//GEN-LAST:event_jLabel50AncestorAdded

    private void jLabel51AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel51AncestorAdded
        // TODO add your handling code here:
        jLabel51.setText(Integer.toString(msi.almacen.getCantidadfuente()));
    }//GEN-LAST:event_jLabel51AncestorAdded

    private void jLabel52AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel52AncestorAdded
        // TODO add your handling code here:
        jLabel52.setText(Integer.toString(msi.almacen.getCantidadgrafica()));
    }//GEN-LAST:event_jLabel52AncestorAdded

    private void jLabel53AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel53AncestorAdded
        // TODO add your handling code here:
        jLabel53.setText(Integer.toString(msi.almacen.getCantidadcomputadorasnormales()));
    }//GEN-LAST:event_jLabel53AncestorAdded

    private void jLabel54AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel54AncestorAdded
        // TODO add your handling code here:
        jLabel54.setText(Integer.toString(msi.almacen.getCantidadcomputadorascongrafica()));
    }//GEN-LAST:event_jLabel54AncestorAdded

    private void jLabel32AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel32AncestorAdded
        // TODO add your handling code here:
        
                
        /*while (true) {
            jLabel32.setText(Integer.toString(cont));
            if (cont == 0){
                cont = 7;
                /*utilidadDell = -(dell.getContplacasD()*480)-(dell.getContcpuD()*624)-(dell.getContramD()*800)-(dell.getContfuenteD()*384)-(dell.getContgraficaD()*816)-(dell.getContensambladorD()*960)-960-1440;
                utilidadMsi = -(msi.getContplacasM()*480)-(msi.getContcpuM()*624)-(msi.getContramM()*800)-(msi.getContfuenteM()*384)-(msi.getContgraficaM()*816)-(msi.getContensambladorM()*960)-960-1440;
                jLabel32.setText(Integer.toString(cont));
                jLabel57.setText(Integer.toString(utilidadDell));*/
                /*utilidadDell = (dell.almacen.getCantidadcomputadorasnormales()*80000)+((dell.almacen.getCantidadcomputadorascongrafica()*120000)-(dell.getContplacasD()*480)-(dell.getContcpuD()*624)-(dell.getContramD()*800)-(dell.getContfuenteD()*384)-(dell.getContgraficaD()*816)-(dell.getContensambladorD()*960)-960-1440)*7;
                utilidadMsi = (msi.almacen.getCantidadcomputadorasnormales()*180000)+((msi.almacen.getCantidadcomputadorascongrafica()*250000)-(msi.getContplacasM()*480)-(msi.getContcpuM()*624)-(msi.getContramM()*800)-(msi.getContfuenteM()*384)-(msi.getContgraficaM()*816)-(msi.getContensambladorM()*960)-960-1440)*7;
                dell.almacen.setCantidadcomputadorasnormales(0);
                dell.almacen.setCantidadcomputadorascongrafica(0);
                msi.almacen.setCantidadcomputadorasnormales(0);
                msi.almacen.setCantidadcomputadorascongrafica(0);*/
            /*} else{
                
                cont =- 1;
            }/*
        }*/
    }//GEN-LAST:event_jLabel32AncestorAdded

    private void jLabel57AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel57AncestorAdded
        // TODO add your handling code here:
        int utilidadDell = 0;
        if(ciclo() == true){
            utilidadDell = (dell.almacen.getCantidadcomputadorasnormales()*80000)+((dell.almacen.getCantidadcomputadorascongrafica()*120000)-(dell.getContplacasD()*480)-(dell.getContcpuD()*624)-(dell.getContramD()*800)-(dell.getContfuenteD()*384)-(dell.getContgraficaD()*816)-(dell.getContensambladorD()*960)-960-1440)*7;
            jLabel57.setText(Integer.toString(utilidadDell));
            dell.almacen.setCantidadcomputadorasnormales(0);
            dell.almacen.setCantidadcomputadorascongrafica(0);
        }
    }//GEN-LAST:event_jLabel57AncestorAdded

    private void jLabel59AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel59AncestorAdded
        // TODO add your handling code here:
        int utilidadMsi = 0;
        if(ciclo() == true){
            utilidadMsi = (msi.almacen.getCantidadcomputadorasnormales()*180000)+((msi.almacen.getCantidadcomputadorascongrafica()*250000)-(msi.getContplacasM()*480)-(msi.getContcpuM()*624)-(msi.getContramM()*800)-(msi.getContfuenteM()*384)-(msi.getContgraficaM()*816)-(msi.getContensambladorM()*960)-960-1440)*7;
            jLabel59.setText(Integer.toString(utilidadMsi));
            msi.almacen.setCantidadcomputadorasnormales(0);
            msi.almacen.setCantidadcomputadorascongrafica(0);
        }
    }//GEN-LAST:event_jLabel59AncestorAdded

    private void jLabel61AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel61AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel61AncestorAdded

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Menu().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }          
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner DCPU;
    private javax.swing.JSpinner DEnsamblador;
    private javax.swing.JSpinner DFuente;
    private javax.swing.JSpinner DGrafica;
    private javax.swing.JSpinner DPlaca;
    private javax.swing.JSpinner DRAM;
    private javax.swing.JSpinner MCPU;
    private javax.swing.JSpinner MEnsamblador;
    private javax.swing.JSpinner MFuente;
    private javax.swing.JSpinner MGrafica;
    private javax.swing.JSpinner MPlaca;
    private javax.swing.JSpinner MRAM;
    private javax.swing.JButton btnConfigurar;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.Panel panel1;
    private javax.swing.JTextField txtCPU;
    private javax.swing.JTextField txtDiasEntrega;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtEnsamblador;
    private javax.swing.JTextField txtFuente;
    private javax.swing.JTextField txtGrafica;
    private javax.swing.JTextField txtPlacaBase;
    private javax.swing.JTextField txtRAM;
    // End of variables declaration//GEN-END:variables
}
