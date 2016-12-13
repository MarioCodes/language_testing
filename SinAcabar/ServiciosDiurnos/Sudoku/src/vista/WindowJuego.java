/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import aplicacion.facade.Facade;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mario
 */
public class WindowJuego extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public WindowJuego() {
        initComponents();
        
        this.setTitle("¡Sudoku!");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        creacionLineasTablero();
        
        Facade fachada = new Facade();
        fachada.rellenoTablaConNumeros(this.jTableContenidoJuego); //fixme: cambiarlo a cuando le de al boton de comenzar juego.
        
        centrarTextoCells();
    }

    /**
     * Centrado de las labels de las cells.
     */
    private void centrarTextoCells() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int i = 0; i < this.jTableContenidoJuego.getColumnCount(); i++) {
            this.jTableContenidoJuego.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
    }
    
    /**
     * Metemos a mano las lineas adicionales del tablero.
     */
    private void creacionLineasTablero() {
        int[][] parametrosLineasGraficas = new int[][] {{130, 0, 5, 400}, //Mapeado a mano, si se modifica la pantalla por cualquier cosa, habra que remapear.
                                                            {259, 0, 5, 400}, 
                                                            {0, 95, 400, 5},
                                                            {0, 195, 400, 5}};
        
        this.jTableContenidoJuego.add(new LineaGraficaCuadrado(parametrosLineasGraficas[0][0], parametrosLineasGraficas[0][1], parametrosLineasGraficas[0][2], parametrosLineasGraficas[0][3]));
        this.jTableContenidoJuego.add(new LineaGraficaCuadrado(parametrosLineasGraficas[1][0], parametrosLineasGraficas[1][1], parametrosLineasGraficas[1][2], parametrosLineasGraficas[1][3]));
        this.jTableContenidoJuego.add(new LineaGraficaCuadrado(parametrosLineasGraficas[2][0], parametrosLineasGraficas[2][1], parametrosLineasGraficas[2][2], parametrosLineasGraficas[2][3]));
        this.jTableContenidoJuego.add(new LineaGraficaCuadrado(parametrosLineasGraficas[3][0], parametrosLineasGraficas[3][1], parametrosLineasGraficas[3][2], parametrosLineasGraficas[3][3]));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPanePrinc = new javax.swing.JTabbedPane();
        jPanelMenuOpcionesJuego = new javax.swing.JPanel();
        jPanelJuego = new javax.swing.JPanel();
        jTableContenidoJuego = new javax.swing.JTable();
        jButtonComprobar = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuOpciones = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelMenuOpcionesJuegoLayout = new javax.swing.GroupLayout(jPanelMenuOpcionesJuego);
        jPanelMenuOpcionesJuego.setLayout(jPanelMenuOpcionesJuegoLayout);
        jPanelMenuOpcionesJuegoLayout.setHorizontalGroup(
            jPanelMenuOpcionesJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanelMenuOpcionesJuegoLayout.setVerticalGroup(
            jPanelMenuOpcionesJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        jTabbedPanePrinc.addTab("Menu Principal", jPanelMenuOpcionesJuego);

        jTableContenidoJuego.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jTableContenidoJuego.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableContenidoJuego.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableContenidoJuego.setRowHeight(33);

        jButtonComprobar.setText("Comprobar");

        javax.swing.GroupLayout jPanelJuegoLayout = new javax.swing.GroupLayout(jPanelJuego);
        jPanelJuego.setLayout(jPanelJuegoLayout);
        jPanelJuegoLayout.setHorizontalGroup(
            jPanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJuegoLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jTableContenidoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanelJuegoLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jButtonComprobar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelJuegoLayout.setVerticalGroup(
            jPanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJuegoLayout.createSequentialGroup()
                .addComponent(jTableContenidoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonComprobar)
                .addContainerGap())
        );

        jTabbedPanePrinc.addTab("Juego", jPanelJuego);

        jMenuOpciones.setText("Opciones");

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuOpciones.add(jMenuItemSalir);

        jMenuBar.add(jMenuOpciones);

        jMenuAcercaDe.setText("Acerca De...");
        jMenuBar.add(jMenuAcercaDe);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanePrinc)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanePrinc)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonComprobar;
    private javax.swing.JMenu jMenuAcercaDe;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenu jMenuOpciones;
    private javax.swing.JPanel jPanelJuego;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelMenuOpcionesJuego;
    private javax.swing.JTabbedPane jTabbedPanePrinc;
    private javax.swing.JTabbedPane jTabbedPanePrincipal;
    private javax.swing.JTable jTableContenidoJuego;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Inner Class hecha unicamente como representacion de las lineas graficas.
     */
    private class LineaGraficaCuadrado extends JPanel {        
        /**
         * Constructor por defecto.
         * @param ejeX Coordenadas del eje x.
         * @param ejeY Coordenadas del eje y.
         * @param ancho Ancho que ocupara la linea.
         * @param alto Alto de la linea.
         */
        public LineaGraficaCuadrado(int ejeX, int ejeY, int ancho, int alto) {
            setBackground(Color.black);
            this.setBounds(ejeX, ejeY, ancho, alto);
        }
    }

}