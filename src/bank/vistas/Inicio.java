package bank.vistas;

import bank.controladores.ClienteJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.CuentaJpaController;
import bank.controladores.RolJpaController;
import bank.controladores.TransaccionJpaController;
import bank.controladores.UsuarioJpaController;
import bank.modelos.Cliente;
import bank.modelos.Cuenta;
import bank.modelos.CuentaAhorros;
import bank.modelos.Rol;
import bank.modelos.Transaccion;
import bank.modelos.Usuario;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

    public static EntityManagerFactory factory;
    public static EntityManager manager;
    private RolJpaController daoRol;
    public static Cuenta cuentaLogin;
    public static CuentaAhorros cuentaBanco;
    public static Cliente banco;

    public Inicio() {
        initComponents();
        factory = Persistence.createEntityManagerFactory("CajaAhorrosPU");
        manager = factory.createEntityManager();
        desplegarInicio();
        //Ejecutar solo la 1ra vez del sistema 
//        crearCuentaBanco();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorioPrincipal = new javax.swing.JDesktopPane(){
            private Image imagen = new ImageIcon(getClass().getResource("/bank/imagenes/logo.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagen, 0, 100, getWidth(), getHeight()-200, this);
            }
        };
        lblTexto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuarios = new javax.swing.JMenu();
        menuItemNewRol = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuItemNewUser = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menuItemUsuarios = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        menuItemCerrarSesion = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuItemSalir = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenu();
        menuItemNewCliente = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuItemClientes = new javax.swing.JMenuItem();
        menuServicios = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        menuItemNewTransaccion = new javax.swing.JMenuItem();
        menuItemTransacciones = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        menuItemNewCredito = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        menuItemNewPoliza = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caja de Ahorro y Crédito - Unión Estudiantil");
        setIconImage(new ImageIcon(getClass().getResource("/bank/imagenes/icon.png")).getImage());
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        escritorioPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        escritorioPrincipal.setPreferredSize(new java.awt.Dimension(1000, 650));

        lblTexto.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        escritorioPrincipal.setLayer(lblTexto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioPrincipalLayout = new javax.swing.GroupLayout(escritorioPrincipal);
        escritorioPrincipal.setLayout(escritorioPrincipalLayout);
        escritorioPrincipalLayout.setHorizontalGroup(
            escritorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        escritorioPrincipalLayout.setVerticalGroup(
            escritorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(387, Short.MAX_VALUE))
        );

        getContentPane().add(escritorioPrincipal);

        menuUsuarios.setText("Usuarios");
        menuUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        menuItemNewRol.setText("Registrar Rol");
        menuItemNewRol.setEnabled(false);
        menuItemNewRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewRolActionPerformed(evt);
            }
        });
        menuUsuarios.add(menuItemNewRol);
        menuUsuarios.add(jSeparator5);

        menuItemNewUser.setText("Registrar Usuario");
        menuItemNewUser.setEnabled(false);
        menuItemNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewUserActionPerformed(evt);
            }
        });
        menuUsuarios.add(menuItemNewUser);
        menuUsuarios.add(jSeparator6);

        menuItemUsuarios.setText("Administrar Usuarios");
        menuItemUsuarios.setEnabled(false);
        menuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUsuariosActionPerformed(evt);
            }
        });
        menuUsuarios.add(menuItemUsuarios);
        menuUsuarios.add(jSeparator7);

        menuItemCerrarSesion.setText("Cerrar sesión");
        menuItemCerrarSesion.setEnabled(false);
        menuItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCerrarSesionActionPerformed(evt);
            }
        });
        menuUsuarios.add(menuItemCerrarSesion);
        menuUsuarios.add(jSeparator8);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuUsuarios.add(menuItemSalir);

        jMenuBar1.add(menuUsuarios);

        menuClientes.setText("Clientes");
        menuClientes.setEnabled(false);
        menuClientes.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        menuItemNewCliente.setText("Registrar Cliente");
        menuItemNewCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuItemNewCliente);
        menuClientes.add(jSeparator4);

        menuItemClientes.setText("Administrar Clientes");
        menuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClientesActionPerformed(evt);
            }
        });
        menuClientes.add(menuItemClientes);

        jMenuBar1.add(menuClientes);

        menuServicios.setText("Servicios");
        menuServicios.setEnabled(false);
        menuServicios.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenu1.setText("Transacciones");

        menuItemNewTransaccion.setText("Realizar Transacción");
        menuItemNewTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewTransaccionActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemNewTransaccion);

        menuItemTransacciones.setText("Administrar Transacciones");
        menuItemTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTransaccionesActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemTransacciones);

        menuServicios.add(jMenu1);
        menuServicios.add(jSeparator1);

        jMenu2.setText("Créditos");

        menuItemNewCredito.setText("Realizar Crédito");
        menuItemNewCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewCreditoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemNewCredito);

        jMenuItem1.setText("Administrar Créditos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        menuServicios.add(jMenu2);
        menuServicios.add(jSeparator2);

        jMenu3.setText("Pólizas");

        menuItemNewPoliza.setText("Realizar Póliza");
        menuItemNewPoliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewPolizaActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemNewPoliza);

        jMenuItem2.setText("Administrar Pólizas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        menuServicios.add(jMenu3);

        jMenuBar1.add(menuServicios);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewUserActionPerformed
        daoRol = new RolJpaController(factory);
        if (daoRol.getRolCount() > 0) {
            RegistrarUsuario ru = new RegistrarUsuario(this, rootPaneCheckingEnabled);
            ru.setLocationRelativeTo(null);
            ru.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No existen roles registrados. Diríjase al\nmenú 'Usuarios->Registrar Rol'", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_menuItemNewUserActionPerformed

    private void menuItemNewRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewRolActionPerformed
        RegistrarRol ro = new RegistrarRol(this, rootPaneCheckingEnabled);
        ro.setLocationRelativeTo(null);
        ro.setVisible(true);
    }//GEN-LAST:event_menuItemNewRolActionPerformed

    private void menuItemNewClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewClienteActionPerformed
        RegistrarCliente rc = new RegistrarCliente(this, rootPaneCheckingEnabled);
        rc.setLocationRelativeTo(null);
        rc.setVisible(true);
    }//GEN-LAST:event_menuItemNewClienteActionPerformed

    private void menuItemNewTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewTransaccionActionPerformed
        RegistrarTransaccion rt = new RegistrarTransaccion(this, false);
        rt.setLocationRelativeTo(null);
        rt.setVisible(true);
    }//GEN-LAST:event_menuItemNewTransaccionActionPerformed

    private void menuItemTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTransaccionesActionPerformed
        AdminTransacciones at = new AdminTransacciones(this, false);
        at.setLocationRelativeTo(null);
        at.setVisible(true);
    }//GEN-LAST:event_menuItemTransaccionesActionPerformed

    private void menuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUsuariosActionPerformed
        AdminUsuarios au = new AdminUsuarios(this, rootPaneCheckingEnabled);
        au.setLocationRelativeTo(null);
        au.setVisible(true);
    }//GEN-LAST:event_menuItemUsuariosActionPerformed

    private void menuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClientesActionPerformed
        AdminClientes ac = new AdminClientes(this, rootPaneCheckingEnabled);
        ac.setLocationRelativeTo(null);
        ac.setVisible(true);
    }//GEN-LAST:event_menuItemClientesActionPerformed

    private void menuItemNewCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewCreditoActionPerformed
        RegistrarCredito rc = new RegistrarCredito(this, rootPaneCheckingEnabled);
        rc.setLocationRelativeTo(null);
        rc.setVisible(true);
    }//GEN-LAST:event_menuItemNewCreditoActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        System.exit(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void menuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCerrarSesionActionPerformed
        estadoMenuAdmin(false);
        textoEtiqueta("");
        desplegarInicio();
    }//GEN-LAST:event_menuItemCerrarSesionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AdminCreditos ac = new AdminCreditos(this, false);
        ac.setLocationRelativeTo(null);
        ac.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuItemNewPolizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewPolizaActionPerformed
        RegistrarPoliza rp = new RegistrarPoliza(this, rootPaneCheckingEnabled);
        rp.setLocationRelativeTo(null);
        rp.setVisible(true);
    }//GEN-LAST:event_menuItemNewPolizaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AdminPolizas ap = new AdminPolizas(this, rootPaneCheckingEnabled);
        ap.setLocationRelativeTo(null);
        ap.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void estadoMenuAdmin(boolean estado) {
        menuClientes.setEnabled(estado);
        menuServicios.setEnabled(estado);
        menuItemCerrarSesion.setEnabled(estado);
        menuItemNewRol.setEnabled(estado);
        menuItemNewUser.setEnabled(estado);
        menuItemUsuarios.setEnabled(estado);
    }

    public static void estadoMenuUser(boolean estado) {
        menuClientes.setEnabled(estado);
        menuServicios.setEnabled(estado);
        menuItemCerrarSesion.setEnabled(estado);
    }

    public static void textoEtiqueta(String texto) {
        lblTexto.setText(texto);
    }

    private void desplegarInicio() {
        Login login = new Login();
        Dimension desktopSize = escritorioPrincipal.getSize();//Tamaño del escritorio
        Dimension frameSize = login.getSize();//Tamaño de la nueva ventana
        login.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);//Ubicar la ventana en el centro
        escritorioPrincipal.add(login);
        login.setVisible(true);
    }

    // Crear la cuenta del Banco la primera vez (Ejecutar solo una vez)
    private void crearCuentaBanco() {
        Usuario usuario = crearAdministrador();

        Inicio.manager.getTransaction().begin();

        ClienteJpaController daoCliente = new ClienteJpaController(factory);
        CuentaAhorrosJpaController daoCuentaAhorros = new CuentaAhorrosJpaController(factory);
        TransaccionJpaController daoTransaccion = new TransaccionJpaController(factory);

        CuentaAhorros cuenta = new CuentaAhorros();
        cuenta.setFecha_apertura(new Date());
        cuenta.setNro_cuenta("0000000001");
        cuenta.setSaldo(30000);

        Cliente cli = new Cliente();
        cli.setCedula("0000000001");
        cli.setApellidos("Caja de Ahorro y Crédito");
        cli.setNombres("Unión Estudiantil");
        cli.setTelefono("2570407");
        cli.setDireccion("Miguel Riofrío 14-55, Loja");
        cli.setCorreo("info@unionestudiantil.fin.ec");
        cli.setCarrera("Banca y Finanzas");
        cli.setCiclo(0);
        cli.setSeccion("--");
        cli.setEstado(true);
        cli.setCuenta_ahorros(cuenta);

        daoCuentaAhorros.create(cuenta);
        daoCliente.create(cli);

        Transaccion trans = new Transaccion();
        trans.setCliente(cli);
        trans.setFecha(new Date());
        trans.setMonto(cuenta.getSaldo());
        trans.setSaldo(cuenta.getSaldo());
        trans.setTipo("Depósito");
        trans.setTransaccionDe(cli.toString());
        trans.setUsuarioResponsable(usuario);

        daoTransaccion.create(trans);
        
        Inicio.manager.getTransaction().commit();
    }

    // Crear un usuario administrador inicial (Ejecutar solo una vez)
    private Usuario crearAdministrador() {
        Inicio.manager.getTransaction().begin();

        RolJpaController daoRol_ = new RolJpaController(Inicio.factory);
        CuentaJpaController daoCuenta_ = new CuentaJpaController(Inicio.factory);
        UsuarioJpaController daoUsuario_ = new UsuarioJpaController(Inicio.factory);

        Rol rol = new Rol();
        rol.setNombre("Admin");
        rol.setDescripcion("Administrador total del Sistema");
        daoRol_.create(rol);

        Usuario user = new Usuario();
        user.setCedula("1900787910");
        user.setApellidos("Jiménez");
        user.setNombres("Jeancarlos");
        user.setTelefono("2930123");
        user.setDireccion("La Tebaida");
        user.setEstado(true);

        Cuenta cuenta = new Cuenta();
        cuenta.setUsername("admin");
        cuenta.setPassword("admin");
        cuenta.setRol(rol);
        cuenta.setUsuario(user);

        daoUsuario_.create(user);
        daoCuenta_.create(cuenta);

        Inicio.manager.getTransaction().commit();

        return user;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inicio init = new Inicio();
                init.setLocationRelativeTo(null);
                init.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorioPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    public static javax.swing.JLabel lblTexto;
    public static javax.swing.JMenu menuClientes;
    public static javax.swing.JMenuItem menuItemCerrarSesion;
    private javax.swing.JMenuItem menuItemClientes;
    private javax.swing.JMenuItem menuItemNewCliente;
    private javax.swing.JMenuItem menuItemNewCredito;
    private javax.swing.JMenuItem menuItemNewPoliza;
    public static javax.swing.JMenuItem menuItemNewRol;
    private javax.swing.JMenuItem menuItemNewTransaccion;
    public static javax.swing.JMenuItem menuItemNewUser;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenuItem menuItemTransacciones;
    public static javax.swing.JMenuItem menuItemUsuarios;
    public static javax.swing.JMenu menuServicios;
    private javax.swing.JMenu menuUsuarios;
    // End of variables declaration//GEN-END:variables
}
