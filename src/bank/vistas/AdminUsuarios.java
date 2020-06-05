package bank.vistas;

import bank.controladores.CuentaJpaController;
import bank.controladores.RolJpaController;
import bank.controladores.UsuarioJpaController;
import bank.modelos.Cuenta;
import bank.modelos.Rol;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminUsuarios extends javax.swing.JDialog {

    private UsuarioJpaController daoUsuario;
    private RolJpaController daoRol;
    private CuentaJpaController daoCuenta;
    private Cuenta cuentaSeleccionada;
    private final Object[] columnas = {"Nro.", "Cédula", "Nombres y apellidos", "Usuario", "Estado"};

    public AdminUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarRoles();
        cargarCuentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        panelNorth = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbxCriterioBusqueda3 = new javax.swing.JComboBox<>();
        txtTextoBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        panelCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxRoles = new javax.swing.JComboBox<>();
        chxEstado = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        txtClaveConfir = new javax.swing.JPasswordField();
        chxClave = new javax.swing.JCheckBox();
        panelSouth = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Usuarios");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        panelNorth.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios registrados"));
        panelNorth.setLayout(new java.awt.BorderLayout());

        cbxCriterioBusqueda3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCriterioBusqueda3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula", "Username" }));
        cbxCriterioBusqueda3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCriterioBusqueda3ItemStateChanged(evt);
            }
        });
        jPanel2.add(cbxCriterioBusqueda3);

        txtTextoBuscar.setColumns(15);
        txtTextoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTextoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTextoBuscarKeyReleased(evt);
            }
        });
        jPanel2.add(txtTextoBuscar);

        panelNorth.add(jPanel2, java.awt.BorderLayout.NORTH);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(462, 150));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Nro.", "Cédula", "Nombres y apellidos", "Usuario", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaUsuarios.setRowHeight(25);
        tablaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        panelNorth.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(panelNorth, java.awt.BorderLayout.NORTH);

        panelCenter.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Usuario"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Cédula:");

        txtCedula.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Dirección:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Usuario:");

        txtUsuario.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Rol:");

        cbxRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chxEstado.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chxEstado.setText("Activo");
        chxEstado.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Nueva Contraseña:");

        txtClave.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Confirmar Contraseña:");

        txtClaveConfir.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClaveConfir))
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClaveConfir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        chxClave.setText("Editar contraseña");
        chxClave.setEnabled(false);
        chxClave.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chxClaveStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelCenterLayout = new javax.swing.GroupLayout(panelCenter);
        panelCenter.setLayout(panelCenterLayout);
        panelCenterLayout.setHorizontalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCenterLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(cbxRoles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCenterLayout.createSequentialGroup()
                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedula)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCenterLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombres))
                            .addGroup(panelCenterLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCenterLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCenterLayout.createSequentialGroup()
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(chxEstado))))
                    .addComponent(chxClave))
                .addContainerGap())
        );
        panelCenterLayout.setVerticalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chxEstado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chxClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlPrincipal.add(panelCenter, java.awt.BorderLayout.CENTER);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panelSouth.add(btnLimpiar);

        btnCambiarEstado.setText("Activar/Desactivar");
        btnCambiarEstado.setEnabled(false);
        btnCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstadoActionPerformed(evt);
            }
        });
        panelSouth.add(btnCambiarEstado);

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelSouth.add(btnEditar);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        panelSouth.add(btnCerrar);

        pnlPrincipal.add(panelSouth, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        if (evt.getClickCount() == 2) {
            String usuario = tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 3).toString();
            cuentaSeleccionada = daoCuenta.findByUser(usuario);
            txtCedula.setText(cuentaSeleccionada.getUsuario().getCedula());
            txtApellidos.setText(cuentaSeleccionada.getUsuario().getApellidos());
            txtNombres.setText(cuentaSeleccionada.getUsuario().getNombres());
            txtDireccion.setText(cuentaSeleccionada.getUsuario().getDireccion());
            txtTelefono.setText(cuentaSeleccionada.getUsuario().getTelefono());
            txtUsuario.setText(cuentaSeleccionada.getUsername());
            chxEstado.setSelected(cuentaSeleccionada.getUsuario().isEstado());
            cbxRoles.setSelectedItem(cuentaSeleccionada.getRol().getNombre());

            //Activo-Desactivo Funcionalidades
            if (cuentaSeleccionada.getUsuario().getCedula().equals(Inicio.cuentaLogin.getUsuario().getCedula())) {//Si es el usuario logeado no puede cambiar su rol
                cbxRoles.setEnabled(false);
                btnCambiarEstado.setEnabled(false);
            } else {
                cbxRoles.setEnabled(true);
                btnCambiarEstado.setEnabled(true);
            }
            btnEditar.setEnabled(true);
            chxClave.setEnabled(true);
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (camposLlenos()) {
            try {
                Inicio.manager.getTransaction().begin();
                daoRol = new RolJpaController(Inicio.factory);
                daoCuenta = new CuentaJpaController(Inicio.factory);
                daoUsuario = new UsuarioJpaController(Inicio.factory);

                cuentaSeleccionada.getUsuario().setTelefono(txtTelefono.getText());
                cuentaSeleccionada.getUsuario().setApellidos(txtApellidos.getText());
                cuentaSeleccionada.getUsuario().setNombres(txtNombres.getText());
                cuentaSeleccionada.getUsuario().setDireccion(txtDireccion.getText());

                Rol rol = daoRol.findByNombre(cbxRoles.getSelectedItem().toString());
                cuentaSeleccionada.setRol(rol);

                if (chxClave.isSelected()) { // Si se requiere cambiar la contraseña
                    if (confirmarClave()) {
                        cuentaSeleccionada.setPassword(txtClave.getText());
                    } else {
                        limpiarClaves();
                        JOptionPane.showMessageDialog(rootPane, "Contraseñas no coinciden. Vuelva a intentarlo.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                daoUsuario.edit(cuentaSeleccionada.getUsuario());
                daoCuenta.edit(cuentaSeleccionada);

                limpiarCampos();
                cargarCuentas();
                JOptionPane.showMessageDialog(rootPane, "Usuario editado con éxito.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Hubo un problema al intentar editar la cuenta.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } finally {
                Inicio.manager.getTransaction().commit();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void chxClaveStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chxClaveStateChanged
        if (chxClave.isSelected()) {
            txtClave.setEditable(true);
            txtClaveConfir.setEditable(true);
        } else {
            txtClave.setEditable(false);
            txtClaveConfir.setEditable(false);
        }
    }//GEN-LAST:event_chxClaveStateChanged

    private void cbxCriterioBusqueda3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCriterioBusqueda3ItemStateChanged
        txtTextoBuscar.setText("");
        txtTextoBuscar.grabFocus();
        limpiarCampos();
    }//GEN-LAST:event_cbxCriterioBusqueda3ItemStateChanged

    private void txtTextoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextoBuscarKeyReleased
        daoCuenta = new CuentaJpaController(Inicio.factory);

        String textoBusqueda = txtTextoBuscar.getText();
        if (!textoBusqueda.isEmpty()) {
            int criterioBusqueda = cbxCriterioBusqueda3.getSelectedIndex();
            List<Cuenta> cuentas = (criterioBusqueda == 0) ? daoCuenta.findAllByCed(textoBusqueda) : daoCuenta.findAllByUsername(textoBusqueda);

            if (!cuentas.isEmpty()) { //Si la lista de cliente no está vacía
                Object[][] registros = convertirLista(cuentas);
                DefaultTableModel modelo = new DefaultTableModel(registros, columnas);
                tablaUsuarios.setModel(modelo);
            } else {
                DefaultTableModel modelo = new DefaultTableModel(null, columnas);
                tablaUsuarios.setModel(modelo);
            }
        } else {
            cargarCuentas();
        }
    }//GEN-LAST:event_txtTextoBuscarKeyReleased

    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed
        int opcion; // 0 - SI   1 - NO
        boolean estado = cuentaSeleccionada.getUsuario().isEstado();
        if (estado) {
            opcion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de deshabilitar el acceso al usuario \n\"" + cuentaSeleccionada.getUsuario().getNombres() + " " + cuentaSeleccionada.getUsuario().getApellidos() + "\"?", "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        } else {
            opcion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de habilitar el acceso al usuario \n\"" + cuentaSeleccionada.getUsuario().getNombres() + " " + cuentaSeleccionada.getUsuario().getApellidos() + "\"?", "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        //Una vez obtenida la opción seleccionada
        if (opcion == 0) {
            Inicio.manager.getTransaction().begin();
            daoUsuario = new UsuarioJpaController(Inicio.factory);
            cuentaSeleccionada.getUsuario().setEstado(!estado);
            try {
                daoUsuario.edit(cuentaSeleccionada.getUsuario());
                cargarCuentas();
                chxEstado.setSelected(!estado);
                JOptionPane.showMessageDialog(rootPane, "Acción realizada con éxito.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Hubo un problema al intentar ejecutar la petición.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } finally {
                Inicio.manager.getTransaction().commit();
            }
        }
    }//GEN-LAST:event_btnCambiarEstadoActionPerformed

    public void limpiarClaves() {
        txtClave.setText("");
        txtClaveConfir.setText("");
    }

    public boolean camposLlenos() {
        return !txtTelefono.getText().isEmpty() && !txtApellidos.getText().isEmpty()
                && !txtNombres.getText().isEmpty() && !txtDireccion.getText().isEmpty();
    }

    public boolean confirmarClave() {
        return txtClave.getText().equals(txtClaveConfir.getText());
    }

    public void limpiarCampos() {
        txtCedula.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtUsuario.setText("");
        txtClave.setText("");
        txtClaveConfir.setText("");
        cbxRoles.setSelectedIndex(0);
        cargarCuentas();
        btnEditar.setEnabled(false);
        btnCambiarEstado.setEnabled(false);
        chxClave.setEnabled(false);
    }

    private void cargarRoles() {
        RolJpaController rjapc = new RolJpaController(Inicio.factory);
        List<Rol> listaRol = rjapc.findRolEntities();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
        for (Rol r : listaRol) {
            model.addElement(r.getNombre());
        }
        cbxRoles.setModel(model);
    }

    private void cargarCuentas() {
        daoCuenta = new CuentaJpaController(Inicio.factory);
        Object[][] registros = convertirLista(daoCuenta.findCuentaEntities());
        DefaultTableModel modelo = new DefaultTableModel(registros, columnas);
        tablaUsuarios.setModel(modelo);
    }

    private Object[][] convertirLista(List<Cuenta> cuentas) {
        Object[][] objetos = {};
        if (cuentas != null) {
            objetos = new Object[cuentas.size()][columnas.length];
            for (int i = 0; i < cuentas.size(); i++) {
                objetos[i][0] = i + 1;
                objetos[i][1] = cuentas.get(i).getUsuario().getCedula();
                objetos[i][2] = cuentas.get(i).getUsuario().getNombres() + " " + cuentas.get(i).getUsuario().getApellidos();
                objetos[i][3] = cuentas.get(i).getUsername();
                objetos[i][4] = (cuentas.get(i).getUsuario().isEstado()) ? "Activo" : "Inactivo";
            }
        }
        return objetos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbxCriterioBusqueda3;
    private javax.swing.JComboBox<String> cbxRoles;
    private javax.swing.JCheckBox chxClave;
    private javax.swing.JCheckBox chxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtClaveConfir;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTextoBuscar;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
