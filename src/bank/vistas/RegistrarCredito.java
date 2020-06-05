package bank.vistas;

import bank.controladores.AmortizacionJpaController;
import bank.controladores.ClienteJpaController;
import bank.controladores.CreditoJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.TransaccionJpaController;
import bank.modelos.Amortizacion;
import bank.modelos.Cliente;
import bank.modelos.Constantes;
import bank.modelos.Credito;
import bank.modelos.CuentaAhorros;
import bank.modelos.Transaccion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class RegistrarCredito extends javax.swing.JDialog {

    private ClienteJpaController daoCliente;
    private CuentaAhorrosJpaController daoCuentaAhorro;
    private CreditoJpaController daoCredito;
    private AmortizacionJpaController daoAmortizacion;

    private final Object[] columnas = {"Nro.", "Fecha Pago", "Cuota", "Abono", "Interés", "Saldo"};
    private Cliente clienteSeleccionado;
    private Credito credito;

    public RegistrarCredito(java.awt.Frame parent, boolean modal) {
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
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        spnCuotas = new javax.swing.JSpinner();
        fechaCuota1 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAmortizacion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        pnlTipoAmoritzacion = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        cbxTipoAmortizacion = new javax.swing.JComboBox<>();
        btnGenerar = new javax.swing.JButton();
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
        setTitle("Realizar Crédito");
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos del Crédito"));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Monto:");

        spnMonto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spnMonto.setModel(new javax.swing.SpinnerNumberModel(5.0d, 5.0d, null, 0.01d));
        spnMonto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnMontoStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tasa de interés:");

        spnInteres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spnInteres.setModel(new javax.swing.SpinnerNumberModel(0.25d, 0.01d, null, 0.01d));
        spnInteres.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnInteresStateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Fecha 1ra cuota:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Cuotas:");

        spnCuotas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spnCuotas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnCuotas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCuotasStateChanged(evt);
            }
        });

        fechaCuota1.setDate(new Date());
        fechaCuota1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fechaCuota1PropertyChange(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("%");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tabla de Amortización"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        tablaAmortizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nro.", "Fecha Pago", "Cuota", "Abono", "Interés", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAmortizacion.setRowHeight(25);
        tablaAmortizacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaAmortizacion);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlTipoAmoritzacion.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("<html>\n<body>\nTipo de sistema <br> de amortización:\n</body>\n</html>");
        pnlTipoAmoritzacion.add(jLabel22);

        cbxTipoAmortizacion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbxTipoAmortizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Francés", "Alemán" }));
        cbxTipoAmortizacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoAmortizacionItemStateChanged(evt);
            }
        });
        pnlTipoAmoritzacion.add(cbxTipoAmortizacion);

        btnGenerar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerar.setText("<html> <body> <div style=\"text-align:center;\"> Generar <br> Amortización </div> </body> </html>");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        pnlTipoAmoritzacion.add(btnGenerar);

        jPanel5.add(pnlTipoAmoritzacion, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(spnCuotas))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(spnInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19))
                            .addComponent(fechaCuota1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(spnMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(spnInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(spnCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(fechaCuota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spnSaldoDisponible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spnSaldoDisponible.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.01d));
        spnSaldoDisponible.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("<html> <body> Saldo<br> disponible: </body> </html>");

        chxCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chxCliente.setText("Cliente activo");
        chxCliente.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(chxCliente))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(spnSaldoDisponible)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSaldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chxCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            if (clienteSeleccionado.isEstado()) { //Si el cliente está activo

                Inicio.manager.getTransaction().begin();

                daoCuentaAhorro = new CuentaAhorrosJpaController(Inicio.factory);
//                CuentaAhorros cuentaBanco = daoCuentaAhorro.findCuentaAhorros(Constantes.ID_CUENTA_BANCO);
                CuentaAhorros cuentaCliente = clienteSeleccionado.getCuenta_ahorros();
                // Consultar si hay dinero en la cuenta del Banco
                if (Inicio.cuentaBanco.getSaldo() > credito.getMonto()) {
                    try {
                        daoAmortizacion = new AmortizacionJpaController(Inicio.factory);
                        daoCredito = new CreditoJpaController(Inicio.factory);
                        daoCredito.create(credito);

                        // Guardar la Amortización
                        if (cbxTipoAmortizacion.getSelectedIndex() == 0) { // Es francesa
                            guardarAmortizacionFrancesa(credito);// Amortización Francesa
                        } else { //Es Alemana
                            guardarAmortizacionAlemana(credito);// Amortización Alemana
                        }

                        // Registrar la transacción en el Banco
//                        Cliente clienteBanco = daoCliente.findByNumCuenta(Inicio.cuentaBanco.getNro_cuenta());
                        String transaccionDe = clienteSeleccionado.toString();
                        double saldoBanco = Math.round((Inicio.cuentaBanco.getSaldo() - credito.getMonto()) * 100d) / 100d;
                        double montoTrans = credito.getMonto();
                        registrarTransaccionCredito(Inicio.banco, montoTrans, saldoBanco, "Crédito (-)", transaccionDe);
                        //Actualizar el saldo de la cuenta del banco (-)
                        Inicio.cuentaBanco.setSaldo(saldoBanco);
                        daoCuentaAhorro.edit(Inicio.cuentaBanco);

                        // Registrar la transacción al cliente
                        double saldoCliente = Math.round((cuentaCliente.getSaldo() + credito.getMonto()) * 100d) / 100d;
                        registrarTransaccionCredito(clienteSeleccionado, montoTrans, saldoCliente, "Crédito (+)", transaccionDe);
                        //Actualizar la cuenta de ahorros del cliente (+)
                        cuentaCliente.setSaldo(saldoCliente);
                        daoCuentaAhorro.edit(cuentaCliente);

                        limpiarCampos();
                        JOptionPane.showMessageDialog(this, "El crédito se ha realizado con éxito.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, "Hubo un problema al intentar registrar este crédito.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(RegistrarCredito.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Lo sentimos, actualmente no se puede otorgar dicho monto.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                Inicio.manager.getTransaction().commit();
            } else { //Caso contrario cuando el cliente no está activo
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

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (Double.parseDouble(spnMonto.getValue().toString()) >= 5) {

            daoCredito = new CreditoJpaController(Inicio.factory);

            // Creo el crédito a nivel global
            credito = new Credito();
            credito.setFechaEmision(new Date());
            credito.setFechaCuota1(fechaCuota1.getDate());
            credito.setTasaInteres(Double.parseDouble(spnInteres.getValue().toString()));
            credito.setMonto(Double.parseDouble(spnMonto.getValue().toString()));
            credito.setNumeroCuotas(Integer.parseInt(spnCuotas.getValue().toString()));
            credito.setTipoAmortizacion(cbxTipoAmortizacion.getSelectedItem().toString());
            credito.setCliente(clienteSeleccionado);
            credito.setPagado(false);
            credito.setUsuarioResponsable(Inicio.cuentaLogin.getUsuario());

            if (cbxTipoAmortizacion.getSelectedIndex() == 0) { // Es francesa
                generarAmortizacionFrancesa(credito);// Amortización Francesa
            } else { //Es Alemana
                generarAmortizacionAlemana(credito);// Amortización Alemana
            }

            redimencionarTabla();
            btnEmitir.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "El monto del préstamo debe ser mayor o igual a $5.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

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
            } else {
                limpiarCampos();
            }
        } else {
            limpiarCampos();
        }
    }//GEN-LAST:event_txtTextoBuscarKeyReleased

    private void spnMontoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnMontoStateChanged
        limpiarTablaAmortizacion();
    }//GEN-LAST:event_spnMontoStateChanged

    private void spnInteresStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnInteresStateChanged
        limpiarTablaAmortizacion();
    }//GEN-LAST:event_spnInteresStateChanged

    private void spnCuotasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCuotasStateChanged
        limpiarTablaAmortizacion();
    }//GEN-LAST:event_spnCuotasStateChanged

    private void fechaCuota1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaCuota1PropertyChange
        limpiarTablaAmortizacion();
    }//GEN-LAST:event_fechaCuota1PropertyChange

    private void cbxTipoAmortizacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoAmortizacionItemStateChanged
        limpiarTablaAmortizacion();
    }//GEN-LAST:event_cbxTipoAmortizacionItemStateChanged

    private void generarAmortizacionFrancesa(Credito preCredito) {
        double monto = preCredito.getMonto();
        int nroCuotas = preCredito.getNumeroCuotas();
        double cuotaSemanal = preCredito.getCuotaSemanal();
        double intereses, abono = 0;

        Date fechaPago = preCredito.getFechaCuota1();
        Object[][] objetos = new Object[nroCuotas + 1][columnas.length];

        objetos = rellenar1raFila(objetos, monto);

        for (int i = 1; i < nroCuotas + 1; i++) {
            intereses = monto * (credito.getTasaInteres() / 100);
            abono = cuotaSemanal - intereses;
            monto -= abono;
            objetos[i][0] = i;
            objetos[i][1] = new SimpleDateFormat("dd-MM-yyyy").format(fechaPago);
            objetos[i][2] = Math.round(cuotaSemanal * 100d) / 100d;
            objetos[i][3] = Math.round(abono * 100d) / 100d;
            objetos[i][4] = Math.round(intereses * 100d) / 100d;
            objetos[i][5] = Math.round(monto * 100d) / 100d;
            fechaPago = daoCredito.sumarSemanas(fechaPago, 1);
        }

        DefaultTableModel modelo = new DefaultTableModel(objetos, columnas);
        tablaAmortizacion.setModel(modelo);
    }

    private void generarAmortizacionAlemana(Credito preCredito) {
        double monto = preCredito.getMonto();
        int nroCuotas = preCredito.getNumeroCuotas();
        double cuotaAmortizacion = preCredito.getCuotaAmortizacion();
        double intereses, cuotaSemanal = 0;

        Date fechaPago = preCredito.getFechaCuota1();
        Object[][] objetos = new Object[nroCuotas + 1][columnas.length];

        objetos = rellenar1raFila(objetos, monto);

        for (int i = 1; i < nroCuotas + 1; i++) {
            intereses = monto * (credito.getTasaInteres() / 100);
            cuotaSemanal = cuotaAmortizacion + intereses;
            monto -= cuotaAmortizacion;
            objetos[i][0] = i;
            objetos[i][1] = new SimpleDateFormat("dd-MM-yyyy").format(fechaPago);
            objetos[i][2] = Math.round(cuotaSemanal * 100d) / 100d;
            objetos[i][3] = Math.round(cuotaAmortizacion * 100d) / 100d;
            objetos[i][4] = Math.round(intereses * 100d) / 100d;
            objetos[i][5] = Math.round(monto * 100d) / 100d;
            fechaPago = daoCredito.sumarSemanas(fechaPago, 1);
        }

        DefaultTableModel modelo = new DefaultTableModel(objetos, columnas);
        tablaAmortizacion.setModel(modelo);
    }

    private void guardarAmortizacionFrancesa(Credito creditoOk) {
        double monto = creditoOk.getMonto();
        Date fechaPago = creditoOk.getFechaCuota1();
        double intereses, abono = 0;
        Amortizacion amortizacion;

        for (int i = 0; i < creditoOk.getNumeroCuotas(); i++) {
            intereses = monto * (creditoOk.getTasaInteres() / 100);
            abono = creditoOk.getCuotaSemanal() - intereses;
            monto -= abono;

            amortizacion = new Amortizacion();
            amortizacion.setNumeroCuota(i + 1);
            amortizacion.setCredito(creditoOk);
            amortizacion.setPagada(false);
            amortizacion.setFechaPago(fechaPago);
            fechaPago = daoCredito.sumarSemanas(fechaPago, 1);
            amortizacion.setPagoSemanal(Math.round(creditoOk.getCuotaSemanal() * 100d) / 100d);
            amortizacion.setAbono(Math.round(abono * 100d) / 100d);
            amortizacion.setInteres(Math.round(intereses * 100d) / 100d);
            amortizacion.setSaldo(Math.round(monto * 100d) / 100d);

            daoAmortizacion.create(amortizacion);
        }
    }

    private void guardarAmortizacionAlemana(Credito creditoOk) {
        double monto = creditoOk.getMonto();
        Date fechaPago = creditoOk.getFechaCuota1();
        double intereses, cuotaSemanal = 0;
        Amortizacion amortizacion;

        for (int i = 0; i < creditoOk.getNumeroCuotas(); i++) {
            intereses = monto * (creditoOk.getTasaInteres() / 100);
            cuotaSemanal = creditoOk.getCuotaAmortizacion() + intereses;
            monto -= creditoOk.getCuotaAmortizacion();

            amortizacion = new Amortizacion();
            amortizacion.setNumeroCuota(i + 1);
            amortizacion.setCredito(creditoOk);
            amortizacion.setPagada(false);
            amortizacion.setFechaPago(fechaPago);
            fechaPago = daoCredito.sumarSemanas(fechaPago, 1);
            amortizacion.setPagoSemanal(Math.round(cuotaSemanal * 100d) / 100d);
            amortizacion.setAbono(Math.round(creditoOk.getCuotaAmortizacion() * 100d) / 100d);
            amortizacion.setInteres(Math.round(intereses * 100d) / 100d);
            amortizacion.setSaldo(Math.round(monto * 100d) / 100d);

            daoAmortizacion.create(amortizacion);
        }
    }

    private Object[][] rellenar1raFila(Object[][] objetos, double monto) {
        objetos[0][0] = 0;
        objetos[0][1] = "-";
        objetos[0][2] = "-";
        objetos[0][3] = "-";
        objetos[0][4] = "-";
        objetos[0][5] = monto;
        return objetos;
    }

    private void limpiarTablaAmortizacion() {
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tablaAmortizacion.setModel(modelo);
        btnEmitir.setEnabled(false);
    }

    private void limpiarCampos() {
        btnEmitir.setEnabled(false);
        txtCedula.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtNroCuenta.setText("");
        spnSaldoDisponible.setValue(0);
        spnMonto.setValue(5);
        spnCuotas.setValue(1);
        spnInteres.setValue(0);
        chxCliente.setSelected(false);
        limpiarTablaAmortizacion();
    }

    private void registrarTransaccionCredito(Cliente cliente, double monto, double saldo, String tipo, String transDe) {
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

    private void redimencionarTabla() {
        TableColumnModel colMol = tablaAmortizacion.getColumnModel();
        colMol.getColumn(0).setPreferredWidth(30); //Nro.
        colMol.getColumn(1).setPreferredWidth(70); //Fecha
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEmitir;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> cbxCriterioBusqueda;
    private javax.swing.JComboBox<String> cbxTipoAmortizacion;
    private javax.swing.JCheckBox chxCliente;
    private com.toedter.calendar.JDateChooser fechaCuota1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlTipoAmoritzacion;
    private javax.swing.JSpinner spnCuotas;
    private javax.swing.JSpinner spnInteres;
    private javax.swing.JSpinner spnMonto;
    private javax.swing.JSpinner spnSaldoDisponible;
    private javax.swing.JTable tablaAmortizacion;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtTextoBuscar;
    // End of variables declaration//GEN-END:variables
}
