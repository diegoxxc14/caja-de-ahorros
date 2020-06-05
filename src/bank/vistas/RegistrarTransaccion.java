package bank.vistas;

import bank.controladores.ClienteJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.CuentaJpaController;
import bank.controladores.TransaccionJpaController;
import bank.modelos.Cliente;
import bank.modelos.CuentaAhorros;
import bank.modelos.Transaccion;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RegistrarTransaccion extends javax.swing.JDialog {

    private ClienteJpaController daoCliente;
    private CuentaAhorrosJpaController daoCuentaAhorros;
    private TransaccionJpaController daoTransaccion;
    private Cliente clienteSeleccionado;

    public RegistrarTransaccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtTextoBuscar.grabFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbxCriterioBusqueda = new javax.swing.JComboBox<>();
        txtTextoBuscar = new javax.swing.JTextField();
        pnlCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtNroCuenta = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spnSaldoDisponible = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        spnMonto = new javax.swing.JSpinner();
        lblCliente = new javax.swing.JLabel();
        txtTransDe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        pnlPie = new javax.swing.JPanel();
        btnRealizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Transacción");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Cliente"));

        cbxCriterioBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCriterioBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula", "Nro. de Cuenta" }));
        cbxCriterioBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCriterioBusquedaItemStateChanged(evt);
            }
        });
        jPanel1.add(cbxCriterioBusqueda);

        txtTextoBuscar.setColumns(15);
        txtTextoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTextoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTextoBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtTextoBuscar);

        pnlPrincipal.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pnlCenter.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Cédula:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("<html> <body> Nro. de <br> cuenta: </body> </html>");

        txtCedula.setEditable(false);

        txtApellidos.setEditable(false);

        txtNroCuenta.setEditable(false);

        txtNombres.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("<html>\n<body>\nSaldo<br>\ndisponible:\n</body>\n</html>");

        spnSaldoDisponible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spnSaldoDisponible.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.01d));
        spnSaldoDisponible.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos Transacción"));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Tipo:");

        cbxTipo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Retiro", "Depósito" }));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Monto:   $");

        spnMonto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spnMonto.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 1.0d));

        lblCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCliente.setText("Cliente:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTransDe, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(spnMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTransDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Teléfono:");

        txtTelefono.setEditable(false);

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlCenterLayout.createSequentialGroup()
                                        .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39))
                                    .addGroup(pnlCenterLayout.createSequentialGroup()
                                        .addComponent(txtApellidos)
                                        .addGap(13, 13, 13)))
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCenterLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(spnSaldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCenterLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spnSaldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlPrincipal.add(pnlCenter, java.awt.BorderLayout.CENTER);

        btnRealizar.setText("Realizar");
        btnRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarActionPerformed(evt);
            }
        });
        pnlPie.add(btnRealizar);

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

    private void btnRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarActionPerformed
        if (camposLlenos()) {
            if (clienteSeleccionado.isEstado()) { // Si el cliente esta activo

                Transaccion trans = new Transaccion();
                daoCuentaAhorros = new CuentaAhorrosJpaController(Inicio.factory);
                daoTransaccion = new TransaccionJpaController(Inicio.factory);

                double monto = Double.parseDouble(spnMonto.getValue().toString());
                CuentaAhorros cuentaAhorros = clienteSeleccionado.getCuenta_ahorros();
                double saldoActual = cuentaAhorros.getSaldo();
                int tipoMovimiento = cbxTipo.getSelectedIndex();
                String transDe = txtTransDe.getText();

                try {
                    switch (tipoMovimiento) {
                        case 0: //Si es retiro
                            if (saldoActual > monto) {
                                Inicio.manager.getTransaction().begin();

                                cuentaAhorros.setSaldo(saldoActual - monto);

                                daoCuentaAhorros.edit(cuentaAhorros);

                                trans = new Transaccion();
                                trans.setCliente(clienteSeleccionado);
                                trans.setFecha(new Date());
                                trans.setMonto(monto);
                                trans.setSaldo(cuentaAhorros.getSaldo());
                                trans.setTipo(cbxTipo.getSelectedItem().toString());
                                trans.setUsuarioResponsable(Inicio.cuentaLogin.getUsuario());
                                trans.setTransaccionDe(transDe);
                                daoTransaccion.create(trans);

                                JOptionPane.showMessageDialog(this, "El retiro se ha realizado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "Actualmente no cuenta con saldo suficiente para realizar esta transacción.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            break;
                        case 1:  //Si es depósito
                            Inicio.manager.getTransaction().begin();

                            cuentaAhorros.setSaldo(saldoActual + monto);
                            daoCuentaAhorros.edit(cuentaAhorros);

                            trans = new Transaccion();
                            trans.setCliente(clienteSeleccionado);
                            trans.setFecha(new Date());
                            trans.setMonto(monto);
                            trans.setSaldo(cuentaAhorros.getSaldo());
                            trans.setTipo(cbxTipo.getSelectedItem().toString());
                            trans.setUsuarioResponsable(Inicio.cuentaLogin.getUsuario());
                            trans.setTransaccionDe(transDe);
                            daoTransaccion.create(trans);

                            JOptionPane.showMessageDialog(this, "El depósito se ha realizado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }

                    // Hecho el movimiento se imprime el comprobante
                    imprimirComprobante(trans);
                    //Limpiar componentes
                    limpiarCampos();
                    cbxCriterioBusquedaItemStateChanged(null);// limpiar componentes de búsqueda

                } catch (Exception ex) {
                    Logger.getLogger(RegistrarTransaccion.class.getName()).log(Level.SEVERE, null, ex);
                }

                Inicio.manager.getTransaction().commit();
            } else {
                JOptionPane.showMessageDialog(this, "Actualmente el cliente no puede acceder a nuestros servicios.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRealizarActionPerformed

    private void imprimirComprobante(Transaccion trans) {
        CuentaJpaController daoCuenta = new CuentaJpaController(Inicio.factory);
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/bank/reportes/comprobanteTrans.jasper"));
            Map parametros = new HashMap();
            parametros.put("nroCuenta", trans.getCliente().getCuenta_ahorros().getNro_cuenta());
            parametros.put("cedula", trans.getCliente().getCedula());
            parametros.put("cliente", trans.getCliente().toString());
            parametros.put("monto", String.valueOf(trans.getMonto()));
            parametros.put("fecha", new SimpleDateFormat("dd-MM-yyyy hh:mm aaa").format(trans.getFecha()));
            parametros.put("cajero", daoCuenta.findByIdUsuario(trans.getUsuarioResponsable().getId()).getUsername());
            parametros.put("solicitante", trans.getTransaccionDe());
            parametros.put("tipoTransaccion", trans.getTipo());
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setSize(new Dimension(500, 700));
            jv.setZoomRatio(0.75f);
            jv.setTitle("Comprobante de Transacción - " + trans.getCliente().getCuenta_ahorros().getNro_cuenta());
            jv.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al intentar generar el comprobante.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxCriterioBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCriterioBusquedaItemStateChanged
        txtTextoBuscar.setText("");
        txtTextoBuscar.grabFocus();
    }//GEN-LAST:event_cbxCriterioBusquedaItemStateChanged

    private void txtTextoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextoBuscarKeyReleased
        String textoBusqueda = txtTextoBuscar.getText();

        if (!textoBusqueda.isEmpty()) { // Si hay texto    
            daoCliente = new ClienteJpaController(Inicio.factory);
            int criterioBusqueda = cbxCriterioBusqueda.getSelectedIndex();
            List<Cliente> clientes = (criterioBusqueda == 0) ? daoCliente.findAllByCed(textoBusqueda) : daoCliente.findAllByNumCuenta(textoBusqueda);

            if (!clientes.isEmpty()) { //Si encuentra el cliente
                clienteSeleccionado = clientes.get(0); //Selecciono el 1er cliente
                txtCedula.setText(clienteSeleccionado.getCedula());
                txtNroCuenta.setText(clienteSeleccionado.getCuenta_ahorros().toString());
                txtNombres.setText(clienteSeleccionado.getNombres());
                txtApellidos.setText(clienteSeleccionado.getApellidos());
                spnSaldoDisponible.setValue(clienteSeleccionado.getCuenta_ahorros().getSaldo());
                txtTelefono.setText(clienteSeleccionado.getTelefono());
                if (cbxTipo.getSelectedIndex() == 0) { // Si está seleccionado Retiro
                    txtTransDe.setText(clienteSeleccionado.toString());
                }
            } else { // Si no encuentra el cliente
                limpiarCampos();
            }
        } else { // Si el campo de búsqueda está vacío
            limpiarCampos();
        }
    }//GEN-LAST:event_txtTextoBuscarKeyReleased

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        if (clienteSeleccionado != null) { // Si el cliente ya es seleccionado
            if (cbxTipo.getSelectedIndex() == 1) { // Si es un deposito
                lblCliente.setText("Depositante:");
                txtTransDe.setText("");
                txtTransDe.grabFocus();
            } else { // Si es un retiro
                lblCliente.setText("Cliente:");
                txtTransDe.setText(clienteSeleccionado.toString());
            }
        }

    }//GEN-LAST:event_cbxTipoItemStateChanged

    public void reiniciarBusqueda() {
        txtTextoBuscar.setText("");
        cbxCriterioBusqueda.setSelectedIndex(0);
    }

    public boolean camposLlenos() {
        return !txtCedula.getText().isEmpty() && !txtNroCuenta.getText().isEmpty()
                && !txtApellidos.getText().isEmpty() && !txtNombres.getText().isEmpty()
                && !txtTransDe.getText().isEmpty();
    }

    public void limpiarCampos() {
        txtCedula.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtNroCuenta.setText("");
        cbxTipo.setSelectedIndex(0);
        spnMonto.setValue(1);
        spnSaldoDisponible.setValue(0);
        txtTelefono.setText("");
        txtTransDe.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRealizar;
    private javax.swing.JComboBox<String> cbxCriterioBusqueda;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlPie;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JSpinner spnMonto;
    private javax.swing.JSpinner spnSaldoDisponible;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTextoBuscar;
    private javax.swing.JTextField txtTransDe;
    // End of variables declaration//GEN-END:variables
}
