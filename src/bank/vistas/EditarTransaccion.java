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

public class EditarTransaccion extends javax.swing.JDialog {

    private ClienteJpaController daoCliente;
    private CuentaAhorrosJpaController daoCuentaAhorros;
    private TransaccionJpaController daoTransaccion;
    private Transaccion transaccion;
    private Cliente cliente;
    private CuentaAhorros cuenta_ahorros;

    public EditarTransaccion(java.awt.Frame parent, boolean modal,
            Transaccion transaccion,
            Cliente cliente,
            CuentaAhorros cuenta_ahorros) {
        super(parent, modal);
        this.transaccion = transaccion;
        this.cliente = cliente;
        this.cuenta_ahorros = cuenta_ahorros;
        initComponents();
        cargarDatos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtNroCuenta = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spnMonto = new javax.swing.JSpinner();
        lblCliente = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        lblCliente1 = new javax.swing.JLabel();
        txtResponsable = new javax.swing.JTextField();
        txtSolicitante = new javax.swing.JTextField();
        lblCliente2 = new javax.swing.JLabel();
        pnlPie = new javax.swing.JPanel();
        btnRealizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Transacción");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos Transacción"));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Tipo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Monto:   $");

        spnMonto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spnMonto.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 1.0d));

        lblCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCliente.setText("Fecha:");

        txtFecha.setEditable(false);

        txtTipo.setEditable(false);

        lblCliente1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCliente1.setText("Responsable:");

        txtResponsable.setEditable(false);

        lblCliente2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCliente2.setText("Solicitante:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnMonto)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCliente1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtResponsable))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCliente2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente1)
                    .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(spnMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCenterLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPrincipal.add(pnlCenter, java.awt.BorderLayout.CENTER);

        btnRealizar.setText("Guardar");
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
            try {
                daoTransaccion = new TransaccionJpaController(Inicio.factory);
                daoCuentaAhorros = new CuentaAhorrosJpaController(Inicio.factory);

                String solicitante = txtSolicitante.getText();
                double montoNuevo = Double.parseDouble(spnMonto.getValue().toString());
                double saldoActual = cuenta_ahorros.getSaldo();

                if (transaccion.getTipo().equals("Depósito")) {

                    saldoActual -= transaccion.getMonto(); //Quito el valor que está erróneo al Saldo del cliente

                    cuenta_ahorros.setSaldo(saldoActual + montoNuevo);//Al saldo bruto le sumo el nuevo valor
                    transaccion.setMonto(montoNuevo);//Edito el monto de la transacción
                    transaccion.setSaldo(cuenta_ahorros.getSaldo()); //Edito el saldo de la cuenta en esa transacción
                    transaccion.setTransaccionDe(solicitante);

                    daoCuentaAhorros.edit(cuenta_ahorros);
                    daoTransaccion.edit(transaccion);

                    JOptionPane.showMessageDialog(this, "Los cambios se guardaron correctamente.\nPresione 'Aceptar' para imprimir su comprobante.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    imprimirComprobante(transaccion);
                } else if (transaccion.getTipo().equals("Retiro")) {
                    saldoActual += transaccion.getMonto(); //Devuelvo el dinero retirado en esta transacción

                    cuenta_ahorros.setSaldo(saldoActual - montoNuevo); //Al saldo bruto le resto el nuevo valor
                    transaccion.setMonto(montoNuevo); //Edito el monto de la transacción
                    transaccion.setSaldo(cuenta_ahorros.getSaldo()); //Edito el saldo de la cuenta en esa transacción
                    transaccion.setTransaccionDe(solicitante);

                    daoCuentaAhorros.edit(cuenta_ahorros);
                    daoTransaccion.edit(transaccion);

                    JOptionPane.showMessageDialog(this, "Los cambios se guardaron correctamente.\nPresione 'Aceptar' para imprimir su comprobante.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    imprimirComprobante(transaccion);
                } else {
                    JOptionPane.showMessageDialog(this, "No se puede editar esta Transacción.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                btnCancelarActionPerformed(null); //Cerrar la ventana - Botón Cancelar
            } catch (Exception ex) {
                Logger.getLogger(EditarTransaccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

//        if (camposLlenos()) {
//            if (clienteSeleccionado.isEstado()) { // Si el cliente esta activo
//
//                Transaccion trans = new Transaccion();
//                daoCuentaAhorros = new CuentaAhorrosJpaController(Inicio.factory);
//                daoTransaccion = new TransaccionJpaController(Inicio.factory);
//
//                double monto = Double.parseDouble(spnMonto.getValue().toString());
//                CuentaAhorros cuentaAhorros = clienteSeleccionado.getCuenta_ahorros();
//                double saldoActual = cuentaAhorros.getSaldo();
//                int tipoMovimiento = cbxTipo.getSelectedIndex();
//                String transDe = txtTransDe.getText();
//
//                try {
//                    switch (tipoMovimiento) {
//                        case 0: //Si es retiro
//                            if (saldoActual > monto) {
//                                Inicio.manager.getTransaction().begin();
//
//                                cuentaAhorros.setSaldo(saldoActual - monto);
//
//                                daoCuentaAhorros.edit(cuentaAhorros);
//
//                                trans = new Transaccion();
//                                trans.setCliente(clienteSeleccionado);
//                                trans.setFecha(new Date());
//                                trans.setMonto(monto);
//                                trans.setSaldo(cuentaAhorros.getSaldo());
//                                trans.setTipo(cbxTipo.getSelectedItem().toString());
//                                trans.setUsuarioResponsable(Inicio.cuentaLogin.getUsuario());
//                                trans.setTransaccionDe(transDe);
//                                daoTransaccion.create(trans);
//
//                                JOptionPane.showMessageDialog(this, "El retiro se ha realizado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
//                            } else {
//                                JOptionPane.showMessageDialog(this, "Actualmente no cuenta con saldo suficiente para realizar esta transacción.", "Error", JOptionPane.ERROR_MESSAGE);
//                                return;
//                            }
//                            break;
//                        case 1:  //Si es depósito
//                            Inicio.manager.getTransaction().begin();
//
//                            cuentaAhorros.setSaldo(saldoActual + monto);
//                            daoCuentaAhorros.edit(cuentaAhorros);
//
//                            trans = new Transaccion();
//                            trans.setCliente(clienteSeleccionado);
//                            trans.setFecha(new Date());
//                            trans.setMonto(monto);
//                            trans.setSaldo(cuentaAhorros.getSaldo());
//                            trans.setTipo(cbxTipo.getSelectedItem().toString());
//                            trans.setUsuarioResponsable(Inicio.cuentaLogin.getUsuario());
//                            trans.setTransaccionDe(transDe);
//                            daoTransaccion.create(trans);
//
//                            JOptionPane.showMessageDialog(this, "El depósito se ha realizado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
//                    }
//
//                    // Hecho el movimiento se imprime el comprobante
//                    imprimirComprobante(trans);
//                    //Limpiar componentes
//                    limpiarCampos();
//
//
//                } catch (Exception ex) {
//                    Logger.getLogger(EditarTransaccion.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                Inicio.manager.getTransaction().commit();
//            } else {
//                JOptionPane.showMessageDialog(this, "Actualmente el cliente no puede acceder a nuestros servicios.", "ERROR", JOptionPane.ERROR_MESSAGE);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
//        }

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

    private void cargarDatos() {
        txtNroCuenta.setText(cliente.getCuenta_ahorros().getNro_cuenta());
        txtCedula.setText(cliente.getCedula());
        txtApellidos.setText(cliente.getApellidos());
        txtNombres.setText(cliente.getNombres());
        spnMonto.setValue(transaccion.getMonto());
        txtTipo.setText(transaccion.getTipo());

        txtResponsable.setText(
                new CuentaJpaController(Inicio.factory).findCuenta(
                        transaccion.getUsuarioResponsable().getId()
                ).getUsername()
        );
        txtSolicitante.setText(transaccion.getTransaccionDe());
        txtFecha.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm aaa").format(transaccion.getFecha()));
    }

    public boolean camposLlenos() {
        return !txtSolicitante.getText().isEmpty() && spnMonto.getValue() != null;
    }

    public void limpiarCampos() {
        txtCedula.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtNroCuenta.setText("");

        spnMonto.setValue(1);
        txtFecha.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRealizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCliente1;
    private javax.swing.JLabel lblCliente2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlPie;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JSpinner spnMonto;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JTextField txtSolicitante;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
