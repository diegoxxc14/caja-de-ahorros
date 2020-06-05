package bank.vistas;

import bank.controladores.ClienteJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.CuentaJpaController;
import bank.modelos.Cliente;
import bank.modelos.Constantes;
import bank.modelos.CuentaAhorros;
import static bank.vistas.Inicio.factory;
import static bank.vistas.Inicio.cuentaLogin;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JInternalFrame {

    public Login() {
        initComponents();
        txtUsuario.grabFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentral = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        pnlSouth = new javax.swing.JPanel();
        btnIniciarSesion = new javax.swing.JButton();

        setTitle("Caja de Ahorros");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Usuario:");

        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClaveKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlCentralLayout = new javax.swing.GroupLayout(pnlCentral);
        pnlCentral.setLayout(pnlCentralLayout);
        pnlCentralLayout.setHorizontalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(txtClave))
                .addContainerGap())
        );
        pnlCentralLayout.setVerticalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCentral, java.awt.BorderLayout.CENTER);

        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        pnlSouth.add(btnIniciarSesion);

        getContentPane().add(pnlSouth, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        String usuario = txtUsuario.getText();
        String clave = txtClave.getText();
        if (!usuario.isEmpty() && !clave.isEmpty()) {
            cuentaLogin = new CuentaJpaController(factory).findByUser(usuario);
            if (cuentaLogin != null) {
                if (cuentaLogin.getUsuario().isEstado()) {// Si está activo
                    if (cuentaLogin.getPassword().equals(clave)) { // Si la clave es correcta
                        if (cuentaLogin.getRol().getNombre().equalsIgnoreCase("admin")
                                || cuentaLogin.getRol().getNombre().equalsIgnoreCase("administrador")) { // Si es administrador
                            Inicio.estadoMenuAdmin(true);
                        } else { // Si es otro tipo de usuario
                            Inicio.estadoMenuUser(true);
                        }
                        JOptionPane.showMessageDialog(rootPane, "Acceso correcto, bienvenido " + cuentaLogin.getUsername() + ".", "Información", JOptionPane.INFORMATION_MESSAGE);
                        Inicio.textoEtiqueta(cuentaLogin.getRol().getNombre() + ": " + cuentaLogin.getUsuario().getNombres() + " " + cuentaLogin.getUsuario().getApellidos());
                        
                        Inicio.cuentaBanco = new CuentaAhorrosJpaController(factory).findCuentaAhorros(Constantes.ID_CUENTA_BANCO);
                        Inicio.banco = new ClienteJpaController(factory).findByNumCuenta(Inicio.cuentaBanco.getNro_cuenta());
                        
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Credenciales incorrectas, intente otra vez.", "Error", JOptionPane.ERROR_MESSAGE);
                        txtUsuario.grabFocus();
                        txtClave.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "El usuario no existe, consulte con el administrador.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtUsuario.grabFocus();
                    txtClave.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "El usuario no existe, consulte con el administrador.", "Error", JOptionPane.ERROR_MESSAGE);
                txtUsuario.grabFocus();
                txtClave.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Existen campos vacíos, vuélvalo a intentar.", "Error", JOptionPane.ERROR_MESSAGE);
            txtUsuario.grabFocus();
        }

    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtClaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIniciarSesionActionPerformed(null);
        }
    }//GEN-LAST:event_txtClaveKeyReleased

    public void limpiarCampos() {
        txtUsuario.setText("");
        txtClave.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlSouth;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
