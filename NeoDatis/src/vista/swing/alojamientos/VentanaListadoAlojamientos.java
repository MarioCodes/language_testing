/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.swing.alojamientos;

import controlador.datos.NeoDatis;
import controlador.dto.Alojamiento;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.neodatis.odb.Objects;

/**
 * Ventana con la estructura para mostrar resultados de Alojamientos. Segun el constructor ejecutara unos metodos u otros.
 * @author Mario Codes Sánchez
 * @since 22/02/2016
 */
public class VentanaListadoAlojamientos extends javax.swing.JFrame {    
    private DefaultTableModel model;
    private Objects<Alojamiento> coleccionResultados;
    
    /**
     * Constructor de la version sin filtrar. Muestra todos los Alojamientos Existentes.
     */
    public VentanaListadoAlojamientos() {
        initComponents(); //Ini necesario de los componentes intrinsecos de la ventana.

        this.setTitle("Listado de Alojamiento Existentes");
        this.setVisible(true); //Mejor que la padre no se haga invisible, no me acordare de los ID de memoria. Si vuelvo a cambiar esto, cambiar tambien los vp.setvisible a true del windowListener on close.
        this.setResizable(false);
        
        creacionTabla();
    }
    
    /**
     * Constructor de la version en la cual le metemos directamente la Coleccion a mostrar. Ahora mismo, muestra solo los existentes localizados en la provincia seleccionada en la ventana anterior.
     */
    public VentanaListadoAlojamientos(Objects coleccion) {
        initComponents(); //Ini necesario de los componentes intrinsecos de la ventana.
        this.coleccionResultados = coleccion;
        
        this.setTitle("Listado de Alojamientos por Valoracion Minima");
        this.labelTitulo.setText("Lista de Alojamiento por Valoracion Minima");
        this.setVisible(true); //Mejor que la padre no se haga invisible, no me acordare de los ID de memoria. Si vuelvo a cambiar esto, cambiar tambien los vp.setvisible a true del windowListener on close.
        this.setResizable(false);
        
        rellenoTablaDatos(coleccionResultados);
    }
    
    /**
     * Get de todos los resultados de la BDD. Para la version de mostrar todos; la filtrada se la salta.
     */
    private void creacionTabla() {
        Objects o = NeoDatis.getAlojamientos();
        rellenoTablaDatos(o);
    }
    
    /**
     * Una vez rellenada la Coleccion con los datos que queremos (filtrados o no), introducimos estos en la tabla.
     */
    private void rellenoTablaDatos(Objects col) {
        model = (DefaultTableModel) tabla.getModel(); //Hacemos un get del DefaultModel con el que creamos la tabla desde Swing.

        try {
            while(col.hasNext()) {
                Alojamiento alDTO = (Alojamiento) col.next();
                Object[] row = new Object[9]; //Creamos un objeto 'fila' con tantas columnas como tenga nuestra tabla (10 en este caso).
                row[0] = alDTO.getNombre();
                row[1] = alDTO.getDireccionSocial();
                row[2] = alDTO.getRazonSocial();
                row[3] = alDTO.getTelefonoContacto();
                row[4] = alDTO.getDescripcion();
                row[5] = alDTO.getValoracion();
                row[6] = alDTO.getFechaApertura();
                row[7] = alDTO.getNumHabitaciones();
                row[8] = alDTO.getProvincia();
                model.addRow(row); //Añade la fila ya rellena al modelo de la tabla.
            }
        }catch(NullPointerException ex) {
            System.out.println("Error especifico: " +ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(this, "ERROR. NullPointerException.");
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

        labelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonCerrar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 0));

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setText("Lista de Alojamientos");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dir_Social", "Razon_Social", "Telefono", "Descripcion", "Valoracion", "Fecha_Apertura", "Num_Habitaciones", "Provincia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(18);
        tabla.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tabla);

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        botonActualizar.setText("Actualizar");
        botonActualizar.setToolTipText("Refresca el contenido de la tabla");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonActualizar)
                        .addGap(81, 81, 81)
                        .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(labelTitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    /**
     * Recarga la Coleccion a partir de la cual mostrara la informacion al darle a actualizar.
     */
    private void recargarFiltrado() {
//        Facade fachada = new Facade();
//        String provincia = coleccionResultados.iterator().next().getProvincia();
//
//        if(DBBConexion.checkConexionDBBExiste()) {
//            coleccionResultados = fachada.listadoAlojamientosBDD(provincia);
//        }else {
//            coleccionResultados = fachada.listadoAlojamientosJSON(provincia);
//        }
//
//        rellenoTablaDatos(coleccionResultados);
    }
    
    /*
        Hace un borrado de la informacion que haya en la tabla anteriormente y la vuelve a crear y rellenar.
            Vuelve a ejecutar la consulta desde DataBase para obtener los datos actuales que haya en la BDD.
    */
    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        model.setRowCount(0); //Hace un vaciado de la tabla. Despúes de ejecutar esto, se debera volver a rellenar o quedara vacia.
        
        if(coleccionResultados == null) { //En funcion de que version de la ventana se haya invocado, se debera ejecutar una u otra version del metodo sobrecargado.
            creacionTabla();
        } else {
            recargarFiltrado();
        }
        
        JOptionPane.showMessageDialog(this, "Lista Actualizada");
    }//GEN-LAST:event_botonActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
