/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.Interfaces;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import proyecto1.so.ConfiguracionTXT;
import proyecto1.so.Empresa;
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
        jPanel4 = new javax.swing.JPanel();

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("MSI", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Dell", jPanel4);

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
