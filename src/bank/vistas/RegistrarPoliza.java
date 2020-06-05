package bank.vistas;

import bank.controladores.ClienteJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.PolizaJpaController;
import bank.controladores.TransaccionJpaController;
import bank.modelos.Cliente;
import bank.modelos.Constantes;
import bank.modelos.CuentaAhorros;
import bank.modelos.Poliza;
import bank.modelos.Transaccion;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegistrarPoliza extends javax.swing.JDialog {

    private ClienteJpaController daoCliente;
    private CuentaAhorrosJpaController daoCuentaAhorro;
    private PolizaJpaController daoPoliza;

    private Cliente clienteSeleccionado;
    private Poliza poliza;

    public RegistrarPoliza(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNroCuenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        spnMonto = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        spnInteres = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        fechaEmision = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        fechaVencimiento = new com.toedter.calendar.JDateChooser();
        txtDiasPlazo = new javax.swing.JTextField();
        txtTotalInteres = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        spnPlazo = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        spnSaldoDisponible = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        chxCliente = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnEmitir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cbxCriterioBusqueda = new javax.swing.JComboBox<>();
        txtTextoBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Póliza");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Cliente"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Apellidos:");

        txtNombres.setEditable(false);
        txtNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtApellidos.setEditable(false);
        txtApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("<html> <body> Nro. de <br> cuenta: </body> </html>");

        txtNroCuenta.setEditable(false);
        txtNroCuenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Cédula:");

        txtCedula.setEditable(false);
        txtCedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos de la Póliza"));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Monto:");

        spnMonto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spnMonto.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 0.01d));
        spnMonto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnMontoStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tasa de interés:");

        spnInteres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spnInteres.setModel(new javax.swing.SpinnerNumberModel(0.1d, 0.01d, null, 0.01d));
        spnInteres.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnInteresStateChanged(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("%");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Fecha emisión:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Días plazo:");

        fechaEmision.setDate(new Date());
        fechaEmision.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fechaEmisionPropertyChange(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Fecha vencimiento:");

        fechaVencimiento.setDate(new Date());
        fechaVencimiento.setEnabled(false);

        txtDiasPlazo.setEditable(false);
        txtDiasPlazo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtTotalInteres.setEditable(false);
        txtTotalInteres.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Total interés:");

        spnPlazo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spnPlazo.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnPlazo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPlazoStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("<html> <body> Duración <br> (semanas): </body> </html>");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(spnInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txtTotalInteres)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18)
                            .addComponent(spnPlazo))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(fechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(txtDiasPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jLabel21))
                            .addComponent(jLabel13))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiasPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(fechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spnSaldoDisponible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spnSaldoDisponible.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.01d));
        spnSaldoDisponible.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("<html>\n<body>\nSaldo<br>\ndisponible:\n</body>\n</html>");

        chxCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chxCliente.setText("Cliente activo");
        chxCliente.setEnabled(false);
        chxCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chxClienteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                            .addComponent(txtNroCuenta, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(spnSaldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(chxCliente))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addComponent(spnSaldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chxCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        btnEmitir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmitir.setText("Emitir");
        btnEmitir.setEnabled(false);
        btnEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirActionPerformed(evt);
            }
        });
        jPanel2.add(btnEmitir);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        cbxCriterioBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCriterioBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula", "Nro. de Cuenta" }));
        cbxCriterioBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCriterioBusquedaItemStateChanged(evt);
            }
        });
        jPanel4.add(cbxCriterioBusqueda);

        txtTextoBuscar.setColumns(15);
        txtTextoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTextoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTextoBuscarKeyReleased(evt);
            }
        });
        jPanel4.add(txtTextoBuscar);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirActionPerformed
        String cedula = txtCedula.getText();
        if (!cedula.isEmpty()) {
            if (clienteSeleccionado.isEstado()) { // Si el cliente está activo

                Inicio.manager.getTransaction().begin();

                daoCuentaAhorro = new CuentaAhorrosJpaController(Inicio.factory);
                CuentaAhorros cuentaCliente = clienteSeleccionado.getCuenta_ahorros();
//                Inicio.cuentaBanco = daoCuentaAhorro.findCuentaAhorros(Constantes.ID_CUENTA_BANCO);

                // Si el cliente tiene en la cuenta el monto de la póliza
                if (cuentaCliente.getSaldo() >= poliza.getMonto()) {
                    try {
                        daoPoliza = new PolizaJpaController(Inicio.factory);
                        poliza.setCliente(clienteSeleccionado);
                        poliza.setVigente(true);
                        poliza.setUsuarioResponsable(Inicio.cuentaLogin.getUsuario());
                        daoPoliza.create(poliza);

                        // Registrar la transacción
                        String transaccionDe = clienteSeleccionado.toString();
                        double monto = poliza.getMonto();
                        double saldoCliente = Math.round((cuentaCliente.getSaldo() - monto) * 100d) / 100d;
                        registrarTransaccionPoliza(clienteSeleccionado, monto, saldoCliente, "Póliza (-)", transaccionDe);
                        //Actualizar la cuenta de ahorros del cliente (-)
                        cuentaCliente.setSaldo(saldoCliente);
                        daoCuentaAhorro.edit(cuentaCliente);

                        // Registrar la transacción
//                        Inicio.banco = daoCliente.findByNumCuenta(Inicio.cuentaBanco.getNro_cuenta());
                        double saldoBanco = Math.round((Inicio.cuentaBanco.getSaldo() + monto) * 100d) / 100d;
                        registrarTransaccionPoliza(Inicio.banco, monto, saldoBanco, "Póliza (+)", transaccionDe);
                        //Actualizar el saldo de la cuenta del banco (+)
                        Inicio.cuentaBanco.setSaldo(saldoBanco);
                        daoCuentaAhorro.edit(Inicio.cuentaBanco);

                        limpiarCampos();
                        txtTextoBuscar.setText("");
                        JOptionPane.showMessageDialog(this, "La póliza se ha realizado con éxito.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, "Hubo un problema al intentar registrar esta póliza.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(RegistrarPoliza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Saldo insuficiente.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                Inicio.manager.getTransaction().commit();
            } else {//Caso contrario cuando el cliente no está activo
                JOptionPane.showMessageDialog(this, "Actualmente el cliente no puede acceder a nuestros servicios.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para continuar.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEmitirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxCriterioBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCriterioBusquedaItemStateChanged
        limpiarCampos();
        txtTextoBuscar.grabFocus();
    }//GEN-LAST:event_cbxCriterioBusquedaItemStateChanged


    private void txtTextoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextoBuscarKeyReleased
        daoCliente = new ClienteJpaController(Inicio.factory);

        String textoBusqueda = txtTextoBuscar.getText();
        if (!textoBusqueda.isEmpty()) {
            int criterioBusqueda = cbxCriterioBusqueda.getSelectedIndex();
            List<Cliente> clientes = (criterioBusqueda == 0) ? daoCliente.findAllByCed(textoBusqueda) : daoCliente.findAllByNumCuenta(textoBusqueda);

            if (!clientes.isEmpty()) { //Si encuentra el cliente
                clienteSeleccionado = clientes.get(0);
                txtCedula.setText(clienteSeleccionado.getCedula());
                txtNroCuenta.setText(clienteSeleccionado.getCuenta_ahorros().getNro_cuenta());
                txtNombres.setText(clienteSeleccionado.getNombres());
                txtApellidos.setText(clienteSeleccionado.getApellidos());
                chxCliente.setSelected(clienteSeleccionado.isEstado());
                spnSaldoDisponible.setValue(clienteSeleccionado.getCuenta_ahorros().getSaldo());
                btnEmitir.setEnabled(true);
            } else {
                limpiarCampos();
            }
        } else {
            limpiarCampos();
        }

    }//GEN-LAST:event_txtTextoBuscarKeyReleased

    private void spnMontoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnMontoStateChanged
        calcularPoliza();
    }//GEN-LAST:event_spnMontoStateChanged

    private void spnInteresStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnInteresStateChanged
        calcularPoliza();
    }//GEN-LAST:event_spnInteresStateChanged

    private void fechaEmisionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaEmisionPropertyChange
        calcularPoliza();
    }//GEN-LAST:event_fechaEmisionPropertyChange

    private void spnPlazoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPlazoStateChanged
        calcularPoliza();
    }//GEN-LAST:event_spnPlazoStateChanged

    private void chxClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chxClienteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_chxClienteItemStateChanged

    private void calcularPoliza() {
        poliza = new Poliza();
        poliza.setMonto(Double.parseDouble(spnMonto.getValue().toString()));
        poliza.setTasaInteres(Double.parseDouble(spnInteres.getValue().toString()));
        poliza.setPlazo(Integer.parseInt(spnPlazo.getValue().toString()));

        Calendar calEmision = Calendar.getInstance();
        calEmision.setTime(fechaEmision.getDate());
        poliza.setFechaEmision(calEmision.getTime());

        Calendar calVencimiento = Calendar.getInstance();
        calVencimiento.setTime(fechaEmision.getDate());
        //calVencimiento.add(Calendar.MONTH, poliza.getPlazo());
        calVencimiento.add(Calendar.WEEK_OF_MONTH, poliza.getPlazo());
        poliza.setFechaVencimiento(calVencimiento.getTime());
        fechaVencimiento.setDate(poliza.getFechaVencimiento());

        poliza.setTotalInteres(Math.round(poliza.getMonto() * poliza.getTasaInteres() * poliza.getPlazo() * 100d) / 100d);
        txtTotalInteres.setText(String.valueOf(poliza.getTotalInteres()));

        txtDiasPlazo.setText(String.valueOf(calVencimiento.get(Calendar.DAY_OF_YEAR) - calEmision.get(Calendar.DAY_OF_YEAR)));
    }

    private void registrarTransaccionPoliza(Cliente cliente, double monto, double saldo, String tipo, String transDe) {
        TransaccionJpaController daoTransaccion = new TransaccionJpaController(Inicio.factory);
        Transaccion trans = new Transaccion();
        trans.setCliente(cliente);
        trans.setFecha(new Date());
        trans.setMonto(monto);
        trans.setSaldo(saldo);
        trans.setTipo(tipo);
        trans.setUsuarioResponsable(Inicio.cuentaLogin.getUsuario());
        trans.setTransaccionDe(transDe);
        daoTransaccion.create(trans);
    }

    private void limpiarCampos() {
        btnEmitir.setEnabled(false);
        txtCedula.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtNroCuenta.setText("");
        spnSaldoDisponible.setValue(0);
        spnMonto.setValue(1);
        spnInteres.setValue(0.1);
        spnPlazo.setValue(1);
        txtTotalInteres.setText("");
        fechaEmision.setDate(new Date());
        chxCliente.setSelected(false);
        calcularPoliza();
        btnEmitir.setEnabled(false);
    }

    public static String generarCodigo() {
        String cod = String.valueOf((int) (Math.random() * 1000000));//Aleatorios de 0000 a 9999
        if (cod.length() <= 6) {
            while (cod.length() < 6) {
                cod = "0" + cod;
            }
        }
        return cod;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEmitir;
    private javax.swing.JComboBox<String> cbxCriterioBusqueda;
    private javax.swing.JCheckBox chxCliente;
    private com.toedter.calendar.JDateChooser fechaEmision;
    private com.toedter.calendar.JDateChooser fechaVencimiento;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSpinner spnInteres;
    private javax.swing.JSpinner spnMonto;
    private javax.swing.JSpinner spnPlazo;
    private javax.swing.JSpinner spnSaldoDisponible;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDiasPlazo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtTextoBuscar;
    private javax.swing.JTextField txtTotalInteres;
    // End of variables declaration//GEN-END:variables
}
