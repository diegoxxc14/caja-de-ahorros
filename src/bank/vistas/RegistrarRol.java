package bank.vistas;

import bank.controladores.RolJpaController;
import bank.modelos.Rol;
import javax.swing.JOptionPane;

public class RegistrarRol extends javax.swing.JDialog {

    public RegistrarRol(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        pnlPie = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Rol");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Descripción:");

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPrincipal.add(pnlCenter, java.awt.BorderLayout.NORTH);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlPie.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlPie.add(btnCancelar);

        pnlPrincipal.add(pnlPie, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (camposLlenos()) {
            
            Inicio.manager.getTransaction().begin();
            
            RolJpaController rjapc = new RolJpaController(Inicio.factory);
            Rol rol = new Rol();
            rol.setNombre(txtNombre.getText());
            rol.setDescripcion(txtDescripcion.getText());
            rjapc.create(rol);
            
            Inicio.manager.getTransaction().commit();
            
            limpiarCampos();
            JOptionPane.showMessageDialog(rootPane, "Resgistrado correctamente.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(rootPane, "Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public boolean camposLlenos() {
        return !txtNombre.getText().isEmpty() && !txtDescripcion.getText().isEmpty();
    }

    public void limpiarCampos(){
        txtNombre.setText("");
        txtDescripcion.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlPie;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
