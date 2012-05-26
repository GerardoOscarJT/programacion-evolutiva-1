/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import ag.AlgoritmoGenetico;
import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaHormiga;
import ag.cruce.*;
import ag.mutacion.*;
import ag.seleccion.*;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.math.plot.Plot2DPanel;
import java.io.*;
import javax.swing.JFrame;
import practica3.*;

/**
 *
 * @author Alberto
 */
public class PantallaPrincipal extends javax.swing.JFrame {


    private static File archivo = null;
    private static int alumGrupo=0;
    private JFrame ventana = null;
    
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
        tamanoElite = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        seleccionados = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tipoCruce = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        tipoMutacion = new javax.swing.JComboBox();
        botonArchivo = new java.awt.Button();
        profundidadMaxima = new javax.swing.JTextField();
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
        tipoSeleccion.setSelectedIndex(1);

        jLabel7.setText("Selección");

        elitismo.setSelected(true);
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

        tamanoElite.setText("3");
        tamanoElite.setName(""); // NOI18N

        jLabel15.setText("Seleccionados (%)");

        seleccionados.setText("0.6");
        seleccionados.setName(""); // NOI18N

        jLabel1.setText("Cruce");

        tipoCruce.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cruce Hormiga" }));

        jLabel6.setText("Mutación");

        tipoMutacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Terminal", "Función", "Inicialización" }));
        tipoMutacion.setSelectedIndex(2);

        botonArchivo.setLabel("Archivo");
        botonArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonArchivoMouseClicked(evt);
            }
        });

        profundidadMaxima.setText("6");
        profundidadMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profundidadMaximaActionPerformed(evt);
            }
        });

        jLabel8.setText("Profundidad max");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPrincipalLayout.createSequentialGroup()
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(elitismo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tamanoElite, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(seleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tipoMutacion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tipoCruce, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tipoSeleccion, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                        .addComponent(probMutacion, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(probCruce, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numGen, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(poblacion, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(profundidadMaxima, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                        .addComponent(botonArchivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(125, 125, 125))
                    .addComponent(jLabel8)))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(profundidadMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(30, 30, 30)
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
                .addGap(22, 22, 22)
                .addComponent(botonArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tamanoElite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elitismo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel9)
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );

        frameGrafica.setEnabled(false);
        frameGrafica.setVisible(true);

        javax.swing.GroupLayout frameGraficaLayout = new javax.swing.GroupLayout(frameGrafica.getContentPane());
        frameGrafica.getContentPane().setLayout(frameGraficaLayout);
        frameGraficaLayout.setHorizontalGroup(
            frameGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        frameGraficaLayout.setVerticalGroup(
            frameGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
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
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addComponent(frameGrafica, javax.swing.GroupLayout.Alignment.LEADING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(frameGrafica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
        Cromosoma c = new CromosomaHormiga();
        Seleccion s = null;
        Cruce cr = null;
        Mutacion m = null;
        Boolean valido=true;
        if (ventana!=null){ventana.setVisible(false);}
        ventana = new JFrame();
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
            case 0: cr = new CruceHormiga();break;

        }
        //Escogemos el algoritmo de mutación
        switch(tipoMutacion.getSelectedIndex()){
            case 0 : m = new MutacionTerminal(); break;
            case 1 : m = new MutacionNoTerminal(); break;
            case 2 : m = new MutacionInicializar(); break;
        }

        // Asignamos el archivo
        if (archivo==null)
           try {
            CromosomaHormiga.leer(archivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Creamos un algoritmo genético nuevo
        AlgoritmoGenetico ag = new AlgoritmoGenetico(c, s, cr, m);

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

        if (!numGen.getText().isEmpty())
            try{ag.num_generaciones=Integer.parseInt(numGen.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Numero de generaciones incorrecto.\n Debe ser un número entero.");
                valido=false;}

        if (!profundidadMaxima.getText().isEmpty())
            try{CromosomaHormiga.profundidad_maxima=Integer.valueOf(profundidadMaxima.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Profundidad máxima incorrecta.\n Debe ser un número entero.");
                valido=false;}

        if (!probMutacion.getText().isEmpty())
            try{ag.prob_mutacion=Double.valueOf(probMutacion.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Probabilidad de mutación incorrecta.\n Debe ser un número real.");
                valido=false;}

        
        
        if (!poblacion.getText().isEmpty())
            try{ag.tamano=Integer.parseInt(poblacion.getText());}
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Tamaño de población incorrecto.\n Debe ser un número entero.");
                valido=false;}
        
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

            resultados.setText("Fenotipo="+mejor.fenotipo()+"\nEvaluacion="+
                    mejor.evaluacion()+"\n Profundidad: "+
                    ((CromosomaHormiga) mejor).programa.getDeep()+
                    ", Nodos: "+((CromosomaHormiga) mejor).programa.getNumNodes()+
                    "\n Maximo "+mejor.toString()+ "\n");
            resultados.append(((CromosomaHormiga) mejor).toHTML());

            resultados.select(1, 1);

            
            scrollResultados.setVisible(true);
                
        }
    }//GEN-LAST:event_calcularActionPerformed

    private void poblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poblacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_poblacionActionPerformed

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
                CromosomaHormiga.leer(archivo);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{fc.setVisible(false);}
    }//GEN-LAST:event_botonArchivoMouseClicked

    private void profundidadMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profundidadMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profundidadMaximaActionPerformed

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
    private java.awt.Button botonArchivo;
    private javax.swing.JButton calcular;
    private javax.swing.JCheckBox elitismo;
    private javax.swing.JInternalFrame frameGrafica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTextField probCruce;
    private javax.swing.JTextField probMutacion;
    private javax.swing.JTextField profundidadMaxima;
    private javax.swing.JTextArea resultados;
    private javax.swing.JScrollPane scrollResultados;
    private javax.swing.JTextField seleccionados;
    private javax.swing.JTextField tamanoElite;
    private javax.swing.JComboBox tipoCruce;
    private javax.swing.JComboBox tipoMutacion;
    private javax.swing.JComboBox tipoSeleccion;
    // End of variables declaration//GEN-END:variables
}
