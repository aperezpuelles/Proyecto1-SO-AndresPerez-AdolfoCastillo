/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.Interfaces;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import proyecto1.so.Empresa;
/**
 *
 * @author casti
 */
public class Menu extends javax.swing.JFrame {
    private Empresa dell;
    private Empresa msi;
    /**
     * Creates new form Menu
     */
    public Menu() {
        msi = new Empresa("MSI", 15, 3000L);
        dell = new Empresa("Dell", 12, 3000L);
        initComponents();
        
        SpinnerNumberModel modelDPlaca = new SpinnerNumberModel(1, 1, dell.getMaximoTrabajadores(), 1);
        DPlaca.setModel(modelDPlaca);
        DPlaca.addChangeListener(e -> actualizarMaximosDell());
        DPlaca.addChangeListener(e -> actualizarSpinnerDell(DPlaca, 1));
        
        SpinnerNumberModel modelDCPU = new SpinnerNumberModel(1, 1, dell.getMaximoTrabajadores(), 1);
        DCPU.setModel(modelDCPU);
        DCPU.addChangeListener(e -> actualizarMaximosDell());
        DCPU.addChangeListener(e -> actualizarSpinnerDell(DCPU, 2));

        SpinnerNumberModel modelDRAM = new SpinnerNumberModel(1, 1, dell.getMaximoTrabajadores(), 1);
        DRAM.setModel(modelDRAM);
        DRAM.addChangeListener(e -> actualizarMaximosDell());
        DRAM.addChangeListener(e -> actualizarSpinnerDell(DRAM, 3));

        SpinnerNumberModel modelDFuente = new SpinnerNumberModel(1, 1, dell.getMaximoTrabajadores(), 1);
        DFuente.setModel(modelDFuente);
        DFuente.addChangeListener(e -> actualizarMaximosDell());
        DFuente.addChangeListener(e -> actualizarSpinnerDell(DFuente, 4));

        SpinnerNumberModel modelDGrafica = new SpinnerNumberModel(1, 1, dell.getMaximoTrabajadores(), 1);
        DGrafica.setModel(modelDGrafica);
        DGrafica.addChangeListener(e -> actualizarMaximosDell());
        DGrafica.addChangeListener(e -> actualizarSpinnerDell(DGrafica, 5));

        SpinnerNumberModel modelDEnsamblador = new SpinnerNumberModel(1, 1, dell.getMaximoTrabajadores(), 1);
        DEnsamblador.setModel(modelDEnsamblador);
        DEnsamblador.addChangeListener(e -> actualizarMaximosDell());
        DEnsamblador.addChangeListener(e -> actualizarSpinnerDell(DEnsamblador, 6));
        
        SpinnerNumberModel modelMPlaca = new SpinnerNumberModel(1, 1, msi.getMaximoTrabajadores(), 1);
        MPlaca.setModel(modelMPlaca);
        MPlaca.addChangeListener(e -> actualizarMaximosMSI());
        MPlaca.addChangeListener(e -> actualizarSpinnerMsi(MPlaca, 1));
        
        SpinnerNumberModel modelMCPU = new SpinnerNumberModel(1, 1, msi.getMaximoTrabajadores(), 1);
        MCPU.setModel(modelMCPU);
        MCPU.addChangeListener(e -> actualizarMaximosMSI());
        MCPU.addChangeListener(e -> actualizarSpinnerMsi(MCPU, 2));

        SpinnerNumberModel modelMRAM = new SpinnerNumberModel(1, 1, msi.getMaximoTrabajadores(), 1);
        MRAM.setModel(modelMRAM);
        MRAM.addChangeListener(e -> actualizarMaximosMSI());
        MRAM.addChangeListener(e -> actualizarSpinnerMsi(MRAM, 3));

        SpinnerNumberModel modelMFuente = new SpinnerNumberModel(1, 1, msi.getMaximoTrabajadores(), 1);
        MFuente.setModel(modelMFuente);
        MFuente.addChangeListener(e -> actualizarMaximosMSI());
        MFuente.addChangeListener(e -> actualizarSpinnerMsi(MFuente, 4));

        SpinnerNumberModel modelMGrafica = new SpinnerNumberModel(1, 1, msi.getMaximoTrabajadores(), 1);
        MGrafica.setModel(modelMGrafica);
        MGrafica.addChangeListener(e -> actualizarMaximosMSI());
        MGrafica.addChangeListener(e -> actualizarSpinnerMsi(MGrafica, 5));

        SpinnerNumberModel modelMEnsamblador = new SpinnerNumberModel(1, 1, msi.getMaximoTrabajadores(), 1);
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
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setLabelFor(jLabel1);
        jLabel8.setText("Trabajadores Dell: 12");
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 14));

        jLabel9.setText("Placa Base");

        jLabel10.setText("CPU");

        jLabel11.setText("Memoria RAM");

        jLabel12.setText("Fuente de alimentación");

        jLabel13.setText("Ensambladores");

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel1.setLabelFor(jLabel1);
        jLabel1.setText("Configuración");
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 14));

        jLabel2.setText("Placa Base");

        jLabel3.setText("CPU");

        jLabel4.setText("Memoria RAM");

        jLabel5.setText("Fuente de alimentación");

        jLabel6.setText("Tarjeta Gráfica");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setLabelFor(jLabel1);
        jLabel7.setText("Trabajadores MSI: 15");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 14));

        jLabel14.setText("Placa Base");

        jLabel15.setText("Tarjeta Gráfica");

        jLabel16.setText("Ensambladores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addGap(89, 89, 89)
                        .addComponent(MPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel2)
                        .addGap(89, 89, 89)
                        .addComponent(DPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3)
                        .addGap(120, 120, 120)
                        .addComponent(MCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel10)
                        .addGap(120, 120, 120)
                        .addComponent(DCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel11)
                        .addGap(75, 75, 75)
                        .addComponent(MRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel4)
                        .addGap(75, 75, 75)
                        .addComponent(DRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel12)
                        .addGap(29, 29, 29)
                        .addComponent(MFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addComponent(DFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel15)
                        .addGap(68, 68, 68)
                        .addComponent(MGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel6)
                        .addGap(68, 68, 68)
                        .addComponent(DGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel16)
                        .addGap(68, 68, 68)
                        .addComponent(MEnsamblador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel13)
                        .addGap(68, 68, 68)
                        .addComponent(DEnsamblador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(168, 168, 168))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(MPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(DPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(MCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(DCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(MRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(DRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(MFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(DFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(MGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(DGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(MEnsamblador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(DEnsamblador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane2.addTab("Configuracion", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Dell", jPanel4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("MSI", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
                new Menu().setVisible(true);
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
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    // End of variables declaration//GEN-END:variables
}
