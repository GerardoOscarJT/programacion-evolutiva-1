/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import ag.AlgoritmoGenetico;
import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaAlumnos;
import ag.cruce.*;
import ag.mutacion.*;
import ag.seleccion.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author Alberto
 */
public class PantallaPrincipal extends javax.swing.JFrame {


    private static File archivo = null;
    public PantallaPrincipal() {
        modelotabla = new DefaultTableModel();        
        initComponents();
        frameGrafica.setVisible(false);
        scrollResultados.setVisible(false);
      }
    

     public boolean esEntero(String cad){
        for(int i = 0; i<cad.length(); i++){
             if(!Character.isDigit(cad.charAt(i)))  return false;
                 }
        return true;
 }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Error = new javax.swing.JDialog();
        PanelPrincipal = new javax.swing.JPanel();
        numGen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        poblacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        probCruce = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        probMutacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tipoSeleccion = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        elitismo = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        calcular = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        precision = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        variable = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cotaInf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cotaSup = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        intervalo = new javax.swing.JTextField();
        tamanoElite = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        seleccionados = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        alpha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tipoCruce = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        tipoMutacion = new javax.swing.JComboBox();
        botonArchivo = new java.awt.Button();
        alumPorGrupo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        frameGrafica = new javax.swing.JInternalFrame();
        scrollResultados = new javax.swing.JScrollPane();
        resultados = new javax.swing.JTextArea();

        javax.swing.GroupLayout ErrorLayout = new javax.swing.GroupLayout(Error.getContentPane());
        Error.getContentPane().setLayout(ErrorLayout);
        ErrorLayout.setHorizontalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        ErrorLayout.setVerticalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        numGen.setText("100");

        jLabel2.setText("Num. generaciones");

        poblacion.setText("100");
        poblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poblacionActionPerformed(evt);
            }
        });

        jLabel3.setText("Tam. población");

        probCruce.setText("0.8");

        jLabel4.setText("Prob. cruce");

        probMutacion.setText("0.1");

        jLabel5.setText("Prob. mutación");

        tipoSeleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ruleta", "Torneo aleatorio", "Torneo determinista", "Ranking", "Método propio" }));

        jLabel7.setText("Selección");

        elitismo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                elitismoStateChanged(evt);
            }
        });

        jLabel9.setText("Elitismo");

        calcular.setText("Calcular");
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });

        jLabel10.setText("Precisión");

        precision.setText("0.0001");
        precision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precisionActionPerformed(evt);
            }
        });

        jLabel11.setText("Estudio sobre variable");

        variable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ninguno", "Población", "Generaciones", "Prob. cruce", "Prob. mutacion", "Tamaño de élite", "Precisión", "Seleccionados (%)" }));
        variable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                variableItemStateChanged(evt);
            }
        });

        jLabel13.setText("Min");
        jLabel13.setEnabled(false);

        cotaInf.setEnabled(false);
        cotaInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cotaInfActionPerformed(evt);
            }
        });

        jLabel12.setText("Max");
        jLabel12.setEnabled(false);

        cotaSup.setEnabled(false);

        jLabel14.setText("Intervalo");
        jLabel14.setEnabled(false);

        intervalo.setEnabled(false);
        intervalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intervaloActionPerformed(evt);
            }
        });

        tamanoElite.setText("3");
        tamanoElite.setName(""); // NOI18N

        jLabel15.setText("Seleccionados (%)");

        seleccionados.setText("0.6");
        seleccionados.setName(""); // NOI18N

        jLabel16.setText("Factor alpha");

        alpha.setText("0.3");

        jLabel1.setText("Cruce");

        tipoCruce.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PMX", "OX", "Variante OX", "Ordinal", "Método propio" }));

        jLabel6.setText("Mutación");

        tipoMutacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inserción", "Intercambio", "Inversión", "Heurística" }));

        botonArchivo.setLabel("Archivo");
        botonArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonArchivoMouseClicked(evt);
            }
        });

        alumPorGrupo.setText("2");
        alumPorGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumPorGrupoActionPerformed(evt);
            }
        });

        jLabel8.setText("Alumnos/Grupo");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel1)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPrincipalLayout.createSequentialGroup()
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(elitismo)
                                        .addGap(18, 18, 18)
                                        .addComponent(tamanoElite, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(botonArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tipoSeleccion, 0, 334, Short.MAX_VALUE)
                                    .addComponent(alpha)
                                    .addComponent(probMutacion)
                                    .addComponent(probCruce)
                                    .addComponent(numGen)
                                    .addComponent(poblacion)
                                    .addComponent(tipoCruce, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tipoMutacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(alumPorGrupo)
                                    .addComponent(precision)
                                    .addComponent(seleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                            .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cotaInf, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(cotaSup, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(intervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(poblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(probCruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(probMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tipoSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tipoCruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tipoMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(alumPorGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(precision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(elitismo)
                                .addComponent(tamanoElite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(34, 34, 34)))
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cotaInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(cotaSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(intervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        frameGrafica.setEnabled(false);
        frameGrafica.setVisible(true);

        javax.swing.GroupLayout frameGraficaLayout = new javax.swing.GroupLayout(frameGrafica.getContentPane());
        frameGrafica.getContentPane().setLayout(frameGraficaLayout);
        frameGraficaLayout.setHorizontalGroup(
            frameGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        frameGraficaLayout.setVerticalGroup(
            frameGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        scrollResultados.setEnabled(false);

        resultados.setColumns(20);
        resultados.setRows(5);
        scrollResultados.setViewportView(resultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(frameGrafica)
                    .addComponent(scrollResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollResultados)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
        try{
        Cromosoma c = new CromosomaAlumnos();
        Seleccion s = null;
        Cruce cr = null;
        Mutacion m = null;
        Boolean valido=true;
        // Escogemos el algoritmo de selección
        switch(tipoSeleccion.getSelectedIndex()){
            case 0 : s = new SeleccionRuleta(); break;
            case 1 : s = new SeleccionTorneoAleatorio(); break;
            case 2 : s = new SeleccionTorneoDeterminista(); break;
            case 3 : s = new SeleccionRanking(); break;
            case 4 : s = new SeleccionMetodoPropio(); break;
        }
        //Escogemos el algoritmo de cruce
        switch(tipoCruce.getSelectedIndex()){
            case 0 : cr = new CrucePMX(); break;
            case 1 : cr = new CruceOX(); break;
            case 2 : cr = new CruceVarianteOX(); break;
            case 3 : cr = new CruceOrdinal(); break;
            case 4 : cr = new CruceMetodoPropio(); break;
        }
        //Escogemos el algoritmo de mutación
        switch(tipoMutacion.getSelectedIndex()){
            case 0 : m = new MutacionInsercion(); break;
            case 1 : m = new MutacionIntercambio(); break;
            case 2 : m = new MutacionInversion(); break;
            case 3 : m = new MutacionHeuristica(); break;
        }
        // Creamos un algoritmo genético nuevo
        AlgoritmoGenetico ag = new AlgoritmoGenetico(c, s, cr, m,archivo);

        // Configuramos las variables del algoritmo desde la GUI
        if (!poblacion.getText().isEmpty())
            try{ag.tamano=Integer.parseInt(poblacion.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Tamaño de población incorrecto.\n Debe ser un número entero.");
                valido=false;}
        
        if (!numGen.getText().isEmpty()) 
            try{ag.num_generaciones=Integer.parseInt(numGen.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Numero de generaciones incorrecto.\n Debe ser un número entero.");
                valido=false;}
        
        if (!probCruce.getText().isEmpty())
            try{ag.prob_cruce=Double.valueOf(probCruce.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Probabilidad de cruce incorrecta.\n Debe ser un número real.");
                valido=false;}

        if (!probMutacion.getText().isEmpty())
            try{ag.prob_mutacion=Double.valueOf(probMutacion.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Probabilidad de mutación incorrecta.\n Debe ser un número real.");
                valido=false;}

        if (!alpha.getText().isEmpty())
            try{ag.alpha=Double.valueOf(alpha.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Factor alpha incorrecto.\n Debe ser un número real.");
                valido=false;}
        
        if (!alumPorGrupo.getText().isEmpty())
            try{ag.tamGrupos=Integer.parseInt(alumPorGrupo.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Tamaño de población incorrecto.\n Debe ser un número entero.");
                valido=false;}
        
        if (!poblacion.getText().isEmpty())
            try{ag.tamano=Integer.parseInt(poblacion.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Tamaño de población incorrecto.\n Debe ser un número entero.");
                valido=false;}
        
        if (!precision.getText().isEmpty())
            try {
                ag.precision = Double.valueOf(precision.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Precision, debe ser un número entre 0 y 1");
                valido=false;
            }

        ag.elitismo = elitismo.isSelected();

        if (!tamanoElite.getText().isEmpty())
            try {ag.tamano_elite = Integer.valueOf(tamanoElite.getText());}
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "El tamaño de la elite debe ser un número entero.");
                valido=false;
            }
        
        if (!seleccionados.getText().isEmpty())
            try{ag.porcentaje_seleccionados=Double.valueOf(seleccionados.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Porcentaje seleccionados incorrecto.\n Debe ser un número entero.");
                valido=false;}
        
        if (valido){
            
            CromosomaAlumnos.completa(ag.tamGrupos);
        
        
            if (variable.getSelectedIndex()==0){
                ag.inicializa();
                double[] regla = new double[ag.mejor_generacion.size()];
                double[] mejorGeneracion = new double[ag.mejor_generacion.size()];
                double[] mejorAbsoluto = new double[ag.mejor_absoluto.size()];
                double[] mediaGeneracion = new double[ag.media_generacion.size()];
                for (int i=0;i<ag.mejor_generacion.size();i++){
                    regla[i]=(double)i;
                    mejorGeneracion[i]=ag.mejor_generacion.get(i);
                    mejorAbsoluto[i]=ag.mejor_absoluto.get(i);
                    mediaGeneracion[i]=ag.media_generacion.get(i);
                }

                // create your PlotPanel (you can use it as a JPanel)
                Plot2DPanel plot = new Plot2DPanel();

                // define the legend position
                plot.addLegend("SOUTH");
                plot.getAxis(0).setLabelText("Generación");
                plot.getAxis(1).setLabelText("Evaluación");


                // add a line plot to the PlotPanel
                plot.addLinePlot("Mejor Generacion",Color.RED, regla, mejorGeneracion);
                plot.addLinePlot("Mejor Absoluto", Color.GREEN,regla, mejorAbsoluto);
                plot.addLinePlot("Media Generacion", Color.ORANGE, regla, mediaGeneracion);

                // put the PlotPanel in a JFrame like a JPanel
                frameGrafica.setContentPane(plot);
                frameGrafica.setVisible(true);

                Cromosoma mejor = ag.getMejor();

                //resultados.setText("Maximo "+mejor.Fitness()+" "+mejor.Fenotipo());
                scrollResultados.setVisible(true);

            } else {
                double min=Double.valueOf(cotaInf.getText());
                double max=Double.valueOf(cotaSup.getText());
                double paso=Double.valueOf(intervalo.getText());
                int indice=0;
                int n=(int)Math.floor((double)(max-min)/paso)+1;
                double[] ejex = new double[n];
                double[] maximoAbsolutoVarias = new double[n];
                double[] minimoAbsolutoVarias = new double[n];
                //ArrayList<Double> mediaVarias = new ArrayList <Double>();
                for (double i=min;i<=max;i+=paso){

                    this.setTitle("Completado "+(100*indice/n)+"%");

                    switch (variable.getSelectedIndex()){
                        //poblacion
                        case 1:
                            ag.tamano=(int)i;
                            break;
                        case 2:
                            ag.num_generaciones=(int)i;
                            break;
                        case 3:
                            ag.prob_cruce=i;
                            break;
                        case 4:
                            ag.prob_mutacion=i;
                            break;
                        case 5:
                            ag.elitismo = true;
                            ag.tamano_elite=(int) i;
                            break;
                        case 7:
                            ag.porcentaje_seleccionados = i;
                            break;


                    }
                Cromosoma mejor = ag.getMejor();
                if (indice<n) {
                    ejex[indice]=i;
                    maximoAbsolutoVarias[indice]=mejor.evaluacion();
                }
                indice++;
                //TODO: Calcular media para la gráfica
            }

            this.setTitle("Completado :D");

            if (indice<n) {
                ejex[indice]=ejex[indice-1];
                maximoAbsolutoVarias[indice]=maximoAbsolutoVarias[indice-1];
            }

            Plot2DPanel plot = new Plot2DPanel();

            // define the legend position
            plot.addLegend("SOUTH");
            plot.getAxis(0).setLabelText(variable.getSelectedItem().toString());
            plot.getAxis(1).setLabelText("Evaluación");


            // add a line plot to the PlotPanel
            plot.addLinePlot("Mejor", Color.GREEN,ejex, maximoAbsolutoVarias);

            frameGrafica.setContentPane(plot);
            frameGrafica.setVisible(true);
        }
    }
        }catch(Exception ex){System.out.println("Error al leer fichero.");}
    }//GEN-LAST:event_calcularActionPerformed

    private void poblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poblacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_poblacionActionPerformed

    private void variableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_variableItemStateChanged
        // TODO add your handling code here:
        boolean activo = (variable.getSelectedIndex() != 0);
        jLabel12.setEnabled(activo);
        jLabel13.setEnabled(activo);
        jLabel14.setEnabled(activo);
        cotaSup.setEnabled(activo);
        cotaInf.setEnabled(activo);
        intervalo.setEnabled(activo);
    }//GEN-LAST:event_variableItemStateChanged

    private void cotaInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cotaInfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cotaInfActionPerformed

    private void intervaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intervaloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intervaloActionPerformed

    private void elitismoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_elitismoStateChanged
        tamanoElite.setEditable(elitismo.isSelected());
    }//GEN-LAST:event_elitismoStateChanged

    private void botonArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonArchivoMouseClicked
        //CogerArchivo pantallaArchivo = new CogerArchivo();
        //pantallaArchivo.setVisible(true);
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            archivo = fc.getSelectedFile();
            try {
                CromosomaAlumnos.leer(archivo);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{fc.setVisible(false);}
    }//GEN-LAST:event_botonArchivoMouseClicked

    private void precisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precisionActionPerformed

    private void alumPorGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumPorGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumPorGrupoActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }


 

    private DefaultTableModel modelotabla;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Error;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JTextField alpha;
    private javax.swing.JTextField alumPorGrupo;
    private java.awt.Button botonArchivo;
    private javax.swing.JButton calcular;
    private javax.swing.JTextField cotaInf;
    private javax.swing.JTextField cotaSup;
    private javax.swing.JCheckBox elitismo;
    private javax.swing.JInternalFrame frameGrafica;
    private javax.swing.JTextField intervalo;
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
    private javax.swing.JTextField numGen;
    private javax.swing.JTextField poblacion;
    private javax.swing.JTextField precision;
    private javax.swing.JTextField probCruce;
    private javax.swing.JTextField probMutacion;
    private javax.swing.JTextArea resultados;
    private javax.swing.JScrollPane scrollResultados;
    private javax.swing.JTextField seleccionados;
    private javax.swing.JTextField tamanoElite;
    private javax.swing.JComboBox tipoCruce;
    private javax.swing.JComboBox tipoMutacion;
    private javax.swing.JComboBox tipoSeleccion;
    private javax.swing.JComboBox variable;
    // End of variables declaration//GEN-END:variables
}
