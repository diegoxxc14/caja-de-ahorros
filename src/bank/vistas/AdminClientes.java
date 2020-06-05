package bank.vistas;

import bank.controladores.ClienteJpaController;
import bank.controladores.CreditoJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.CuentaJpaController;
import bank.controladores.PolizaJpaController;
import bank.controladores.RolJpaController;
import bank.controladores.SocioJpaController;
import bank.controladores.TransaccionJpaController;
import bank.controladores.UsuarioJpaController;
import bank.modelos.Cliente;
import bank.modelos.Credito;
import bank.modelos.Cuenta;
import bank.modelos.CuentaAhorros;
import bank.modelos.Poliza;
import bank.modelos.Rol;
import bank.modelos.Socio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AdminClientes extends javax.swing.JDialog {

    private UsuarioJpaController daoUsuario;
    private RolJpaController daoRol;
    private CuentaAhorrosJpaController daoCuentaAhorros;
    private ClienteJpaController daoCliente;
    private SocioJpaController daoSocio;

    private Cliente clienteSeleccionado;
    private Socio socioSeleccionado;
    private final Object[] columnas = {"Nro.", "Cédula", "Nro. cuenta", "Nombres y apellidos", "Carrera"};

    public AdminClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarClientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        panelNorth = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbxCriterioBusqueda3 = new javax.swing.JComboBox<>();
        txtTextoBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable(){
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
        jLabel11 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCarrera = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        spnCiclo = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        cbxSeccion = new javax.swing.JComboBox<>();
        txtNroCuenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        chxSocio = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        chxCliente = new javax.swing.JCheckBox();
        panelSouth = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Clientes");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        panelNorth.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes registrados"));
        panelNorth.setLayout(new java.awt.BorderLayout());

        cbxCriterioBusqueda3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCriterioBusqueda3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula", "Nro. de Cuenta" }));
        cbxCriterioBusqueda3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCriterioBusqueda3ItemStateChanged(evt);
            }
        });
        jPanel1.add(cbxCriterioBusqueda3);

        txtTextoBuscar.setColumns(15);
        txtTextoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTextoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTextoBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtTextoBuscar);

        panelNorth.add(jPanel1, java.awt.BorderLayout.NORTH);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(462, 150));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Nro.", "Cédula", "Nro. cuenta", "Nombres y apellidos", "Carrera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaClientes.setRowHeight(25);
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        panelNorth.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(panelNorth, java.awt.BorderLayout.NORTH);

        panelCenter.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Cliente"));

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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Correo:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Carrera:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Ciclo:");

        spnCiclo.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Sección:");

        cbxSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutina", "Vespertina", "Nocturna" }));

        txtNroCuenta.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Nro. de cuenta:");

        chxSocio.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chxSocio.setText("Socio");
        chxSocio.setEnabled(false);
        chxSocio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chxSocioItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Saldo:     $");

        txtSaldo.setEditable(false);
        txtSaldo.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        chxCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chxCliente.setText("Cliente activo");
        chxCliente.setEnabled(false);
        chxCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chxClienteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelCenterLayout = new javax.swing.GroupLayout(panelCenter);
        panelCenter.setLayout(panelCenterLayout);
        panelCenterLayout.setHorizontalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCenterLayout.createSequentialGroup()
                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCenterLayout.createSequentialGroup()
                                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(txtApellidos)))
                            .addGroup(panelCenterLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDireccion))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCenterLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCenterLayout.createSequentialGroup()
                                .addComponent(chxCliente)
                                .addGap(18, 18, 18)
                                .addComponent(chxSocio)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelCenterLayout.createSequentialGroup()
                                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCenterLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNroCuenta))
                                    .addGroup(panelCenterLayout.createSequentialGroup()
                                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel14))
                                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelCenterLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                                    .addComponent(txtCorreo)))
                                            .addGroup(panelCenterLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(cbxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(panelCenterLayout.createSequentialGroup()
                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCenterLayout.createSequentialGroup()
                                .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        panelCenterLayout.setVerticalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(spnCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cbxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chxSocio)
                    .addComponent(chxCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        daoCliente = new ClienteJpaController(Inicio.factory);
        daoSocio = new SocioJpaController(Inicio.factory);
        daoCuentaAhorros = new CuentaAhorrosJpaController(Inicio.factory);

        String cedula = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1).toString();
        clienteSeleccionado = daoCliente.findByCed(cedula);

        txtCedula.setText(clienteSeleccionado.getCedula());
        txtApellidos.setText(clienteSeleccionado.getApellidos());
        txtNombres.setText(clienteSeleccionado.getNombres());
        txtDireccion.setText(clienteSeleccionado.getDireccion());
        txtTelefono.setText(clienteSeleccionado.getTelefono());
        txtCorreo.setText(clienteSeleccionado.getCorreo());
        txtCarrera.setText(clienteSeleccionado.getCarrera());
        spnCiclo.setValue(clienteSeleccionado.getCiclo());
        cbxSeccion.setSelectedItem(clienteSeleccionado.getSeccion());
        chxCliente.setSelected(clienteSeleccionado.isEstado());

        txtNroCuenta.setText(clienteSeleccionado.getCuenta_ahorros().getNro_cuenta());
        txtSaldo.setText(String.valueOf(clienteSeleccionado.getCuenta_ahorros().getSaldo()));

        try {
            socioSeleccionado = daoSocio.findByIdCliente(clienteSeleccionado);
            chxSocio.setSelected(socioSeleccionado.isEstado());
            chxSocio.setEnabled(true);
        } catch (NoResultException e) {
            System.err.println("Ningún resultado obtenido");
        } finally {
            btnEditar.setEnabled(true);
            if (clienteSeleccionado.getCuenta_ahorros().getId() == 1) { //Si es la cuenta de banco
                btnCambiarEstado.setEnabled(false); //No se permite activar/desactivar al cliente
            } else {
                btnCambiarEstado.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

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

                daoCuentaAhorros = new CuentaAhorrosJpaController(Inicio.factory);
                daoUsuario = new UsuarioJpaController(Inicio.factory);
                daoCliente = new ClienteJpaController(Inicio.factory);
                daoSocio = new SocioJpaController(Inicio.factory);

                clienteSeleccionado.setTelefono(txtTelefono.getText());
                clienteSeleccionado.setApellidos(txtApellidos.getText());
                clienteSeleccionado.setNombres(txtNombres.getText());
                clienteSeleccionado.setDireccion(txtDireccion.getText());
                clienteSeleccionado.setCorreo(txtCorreo.getText());
                clienteSeleccionado.setCarrera(txtCarrera.getText());
                clienteSeleccionado.setCiclo(Integer.parseInt(spnCiclo.getValue().toString()));
                clienteSeleccionado.setSeccion(cbxSeccion.getSelectedItem().toString());

                if (chxSocio.isEnabled()) { //Si esta activo es porque se encontró un socio
                    socioSeleccionado.setEstado(chxSocio.isSelected());
                    daoSocio.edit(socioSeleccionado);
                }

                daoCliente.edit(clienteSeleccionado);

                limpiarCampos();
                cargarClientes();
                JOptionPane.showMessageDialog(rootPane, "Cliente editado con éxito.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                Inicio.manager.getTransaction().commit();
            } catch (Exception ex) {
                Logger.getLogger(AdminClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cbxCriterioBusqueda3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCriterioBusqueda3ItemStateChanged
        txtTextoBuscar.setText("");
        txtTextoBuscar.grabFocus();
        limpiarCampos();
    }//GEN-LAST:event_cbxCriterioBusqueda3ItemStateChanged

    private void txtTextoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextoBuscarKeyReleased
        daoCliente = new ClienteJpaController(Inicio.factory);

        String textoBusqueda = txtTextoBuscar.getText();
        if (!textoBusqueda.isEmpty()) {
            int criterioBusqueda = cbxCriterioBusqueda3.getSelectedIndex();
            List<Cliente> clientes = (criterioBusqueda == 0) ? daoCliente.findAllByCed(textoBusqueda) : daoCliente.findAllByNumCuenta(textoBusqueda);

            if (!clientes.isEmpty()) { //Si la lista de cliente no está vacía
                Object[][] registros = convertirLista(clientes);
                DefaultTableModel modelo = new DefaultTableModel(registros, columnas);
                tablaClientes.setModel(modelo);
                redimencionarTabla();
            } else {
                DefaultTableModel modelo = new DefaultTableModel(null, columnas);
                tablaClientes.setModel(modelo);
            }
        } else {
            cargarClientes();
        }
    }//GEN-LAST:event_txtTextoBuscarKeyReleased

    private void chxSocioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chxSocioItemStateChanged

    }//GEN-LAST:event_chxSocioItemStateChanged

    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed
        int opcion; // 0 - SI   1 - NO
        boolean estado = clienteSeleccionado.isEstado();
        if (estado) {
            opcion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de dar de baja al cliente \n\"" + clienteSeleccionado.getNombres() + " " + clienteSeleccionado.getApellidos() + "\"?", "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        } else {
            opcion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro reactivar la cuenta del cliente \n\"" + clienteSeleccionado.getNombres() + " " + clienteSeleccionado.getApellidos() + "\"?", "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }

        if (opcion == 0) { //Si se selecciona SI
            boolean noCreditosAct = true; // No tiene créditos activos
            boolean noPolizasVig = true; // No tiene pólizas activas
            Inicio.manager.getTransaction().begin();

            //Verificar que no tenga créditos ni pólizas pendientes
            CreditoJpaController daoCredito = new CreditoJpaController(Inicio.factory);
            List<Credito> listaCreditos = daoCredito.findCreditosByCliente(clienteSeleccionado.getId());
            PolizaJpaController daoPoliza = new PolizaJpaController(Inicio.factory);
            List<Poliza> listaPolizas = daoPoliza.findPolizasByCliente(clienteSeleccionado.getId());

            if (listaCreditos.size() > 0 || listaPolizas.size() > 0) { //Si tiene créditos o pólizas
                for (Credito c : listaCreditos) {
                    if (!c.isPagado()) { // Si encuentra un crédito sin pagar
                        noCreditosAct = false;
                        break; // Se finaliza la búsqueda
                    }
                }
                for (Poliza p : listaPolizas) {
                    if (p.isVigente()) { // Si encuentra una póliza vigente
                        noPolizasVig = false;
                        break; // Se finaliza la búsqueda
                    }
                }
            }

            if (noCreditosAct && noPolizasVig) { // Si finalmente no tiene nada pendiente
                daoCliente = new ClienteJpaController(Inicio.factory);
                clienteSeleccionado.setEstado(!estado);
                try {
                    daoCliente.edit(clienteSeleccionado);
                    cargarClientes();
                    chxCliente.setSelected(!estado);
                    JOptionPane.showMessageDialog(rootPane, "Acción realizada con éxito.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Hubo un problema al intentar ejecutar la petición.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se puede dar de baja al cliente ya que tiene\n"
                        + "servicios bancarios pendientes.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            Inicio.manager.getTransaction().commit();
        }
    }//GEN-LAST:event_btnCambiarEstadoActionPerformed

    private void chxClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chxClienteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_chxClienteItemStateChanged

    public boolean camposLlenos() {
        return !txtTelefono.getText().isEmpty() && !txtApellidos.getText().isEmpty()
                && !txtNombres.getText().isEmpty() && !txtDireccion.getText().isEmpty()
                && !txtCorreo.getText().isEmpty() && !txtCarrera.getText().isEmpty();
    }

    public void limpiarCampos() {
        txtCedula.setText("");
        txtNroCuenta.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtCarrera.setText("");
        spnCiclo.setValue(1);
        cbxSeccion.setSelectedIndex(0);
        txtSaldo.setText("");
        chxSocio.setSelected(false);
        chxCliente.setSelected(false);

        btnEditar.setEnabled(false);
        chxSocio.setEnabled(false);
        chxCliente.setEnabled(false);
        cargarClientes();
    }

    private void cargarClientes() {
        daoCliente = new ClienteJpaController(Inicio.factory);
        Object[][] registros = convertirLista(daoCliente.findClienteEntities());
        DefaultTableModel modelo = new DefaultTableModel(registros, columnas);
        tablaClientes.setModel(modelo);
        redimencionarTabla();
    }

    private Object[][] convertirLista(List<Cliente> clientes) {
        Object[][] objetos = {};
        if (clientes != null) {
            objetos = new Object[clientes.size()][columnas.length];
            for (int i = 0; i < clientes.size(); i++) {
                objetos[i][0] = i + 1;
                objetos[i][1] = clientes.get(i).getCedula();
                objetos[i][2] = clientes.get(i).getCuenta_ahorros().getNro_cuenta();
                objetos[i][3] = clientes.get(i).getNombres() + " " + clientes.get(i).getApellidos();
                objetos[i][4] = clientes.get(i).getCarrera();
            }
        }
        return objetos;
    }

    private void redimencionarTabla() {
        TableColumnModel colMol = tablaClientes.getColumnModel();
        colMol.getColumn(0).setPreferredWidth(15); //Nro.
        colMol.getColumn(1).setPreferredWidth(45); //Cédula
        colMol.getColumn(2).setPreferredWidth(45); //Nro. Cuenta
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbxCriterioBusqueda3;
    private javax.swing.JComboBox<String> cbxSeccion;
    private javax.swing.JCheckBox chxCliente;
    private javax.swing.JCheckBox chxSocio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JSpinner spnCiclo;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTextoBuscar;
    // End of variables declaration//GEN-END:variables
}
