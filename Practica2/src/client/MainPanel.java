/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import javafx.scene.layout.Border;

/**
 *
 * @author pol
 */
public class MainPanel extends javax.swing.JPanel {

    Peer cliente; // para los metodos del cliente

    private final Color Verde = new Color(51, 255, 153);
    private final Color Rojo = new Color(255, 51, 51);
    private final Color Naranja = new Color(255, 153, 51);

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {

        initComponents();

        cliente = new Peer(); // instancia del cliente

        // Componentes
        CancelarButton.setVisible(false); // invisible de momento
        CancelarButton.setOpaque(true);         // Para ver el fondo
        CancelarButton.setBorderPainted(false); // *
        CancelarButton.setBackground(Rojo);
        SuscribirseButton.setOpaque(true);         // Para ver el fondo
        SuscribirseButton.setBorderPainted(false); // *
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SuscribirseButton = new javax.swing.JButton();
        segundosSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datosArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        CancelarButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(30, 30, 30));

        SuscribirseButton.setBackground(new java.awt.Color(51, 255, 153));
        SuscribirseButton.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        SuscribirseButton.setText("Suscribirse");
        SuscribirseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuscribirseButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(200, 200, 200));
        jLabel1.setText("Segundos");

        datosArea.setBackground(new java.awt.Color(30, 30, 30));
        datosArea.setColumns(20);
        datosArea.setRows(5);
        datosArea.setBorder(null);
        jScrollPane1.setViewportView(datosArea);

        jLabel2.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 153));
        jLabel2.setText("Datos recibidos");

        CancelarButton.setBackground(new java.awt.Color(255, 102, 102));
        CancelarButton.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        CancelarButton.setText("Cancelar");
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(segundosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SuscribirseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(CancelarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(segundosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(CancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SuscribirseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SuscribirseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuscribirseButtonActionPerformed
        // TODO add your handling code here:

        int segundos = Integer.parseInt(segundosSpinner.getValue().toString());

        suscribirse(segundos); // para el servidor suscribirse y renovar es lo mismo
        CancelarButton.setVisible(true); // visible

        if (SuscribirseButton.getText().equals("Suscribirse")) {
            // cambio la Label del boton
            SuscribirseButton.setText("Renovar");
            SuscribirseButton.setBackground(Naranja);
        }
    }//GEN-LAST:event_SuscribirseButtonActionPerformed

    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        // TODO add your handling code here:
        cancelarSuscripcion();
        CancelarButton.setVisible(false);
        SuscribirseButton.setText("Suscribirse");
        SuscribirseButton.setBackground(Verde);
    }//GEN-LAST:event_CancelarButtonActionPerformed

    private void cancelarSuscripcion() {
        cliente.cancelarSuscripcion();
    }

    private void suscribirse(int segundos) { // Para el servidor renovar y suscribirse es lo mismo
        cliente.pedirSuscripcion(segundos);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarButton;
    private javax.swing.JButton SuscribirseButton;
    private javax.swing.JTextArea datosArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner segundosSpinner;
    // End of variables declaration//GEN-END:variables
}
