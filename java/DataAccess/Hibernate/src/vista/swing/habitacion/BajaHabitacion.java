/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.swing.habitacion;

import controlador.datos.Facade;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Mario Codes Sánchez
 * @since 09/11/2016
 */
public class BajaHabitacion extends javax.swing.JFrame {
    /**
     * Creates new form VentanaBajaAlojamiento
     */
    public BajaHabitacion() {
        initComponents();
        
        this.setTitle("Dar Habitación de Baja");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelID = new javax.swing.JLabel();
        inputID = new javax.swing.JTextField();
        checkBoxBooleanConfirmacion = new javax.swing.JCheckBox();
        jLabelConfirmacion = new javax.swing.JLabel();
        botonBorrar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabelID.setText("# ID: ");

        inputID.setToolTipText("ID identificativo del alojamiento en la BDD");

        checkBoxBooleanConfirmacion.setText("Sí");
        checkBoxBooleanConfirmacion.setToolTipText("¿De verdad?");

        jLabelConfirmacion.setText("¿Estás Seguro/a?");

        botonBorrar.setText("Borrar");
        botonBorrar.setMaximumSize(new java.awt.Dimension(75, 23));
        botonBorrar.setMinimumSize(new java.awt.Dimension(75, 23));
        botonBorrar.setPreferredSize(new java.awt.Dimension(90, 23));
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTitulo.setText("Dar Habitación de Baja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabelConfirmacion)
                            .addGap(27, 27, 27)
                            .addComponent(checkBoxBooleanConfirmacion)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelID)
                            .addGap(29, 29, 29)
                            .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelTitulo)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxBooleanConfirmacion)
                    .addComponent(jLabelConfirmacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    /**
     * Check de que los campos de inputs esten rellenados y no vacios.
     * @return True si no esta vacio.
     */
    private boolean checkInputLleno() {
        return !(this.inputID.getText().isEmpty());
    }
    
    private void reseteoCampos() {
        this.inputID.setText(null);
        this.checkBoxBooleanConfirmacion.setSelected(false);
    }
    
    /**
     * 
     * @param evt 
     */
    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        boolean checkBox;
        int id;
        
        if(checkInputLleno()) {
            try {
                id = Integer.parseInt(this.inputID.getText());
                checkBox = this.checkBoxBooleanConfirmacion.isSelected();

                if(checkBox) {
                    Session s = Facade.abrirSessionHibernate();
                    Query q = s.createQuery("delete Habitacion "
                                                + "where ID_HABITACION = :idHab");
                    q.setParameter("idHab", id);
                    int resultado = q.executeUpdate();

                    if(resultado == 0) {
                        JOptionPane.showMessageDialog(this, "Ninguna Habitación con esos datos.");
                    } else {
                        if(Facade.cerrarSessionHibernate(s)) { //todo: comprobar que funcione bien los mensajes de output en baja de habitacion.
                            JOptionPane.showMessageDialog(this, resultado +" fila modificada.");
                            reseteoCampos();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Por Favor, marque la casilla como que está \nconforme con borrar esta entrada.");
                }
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ERROR. La ID debe ser un # entero");
            }
        } else {
            JOptionPane.showMessageDialog(this, "ERROR. El ID no puede estar vacio.");
        }
        
    }//GEN-LAST:event_botonBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JCheckBox checkBoxBooleanConfirmacion;
    private javax.swing.JTextField inputID;
    private javax.swing.JLabel jLabelConfirmacion;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
