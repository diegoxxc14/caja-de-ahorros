package bank.vistas;

import bank.controladores.ClienteJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.SocioJpaController;
import bank.controladores.TransaccionJpaController;
import bank.modelos.Cliente;
import bank.modelos.Constantes;
import bank.modelos.CuentaAhorros;
import bank.modelos.Socio;
import bank.modelos.Transaccion;
import java.util.Date;
import javax.swing.JOptionPane;

public class RegistrarCliente extends javax.swing.JDialog {

    private ClienteJpaController daoCliente;
    private CuentaAhorrosJpaController daoCuentaAhorros;
    private SocioJpaController daoSocio;

    public RegistrarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtNroCuenta.setText(generarCodigo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCarrera = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        spnCiclo = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        cbxSeccion = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNroCuenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        spnMonto = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        chxSocio = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spnAporteInicial = new javax.swing.JSpinner();
        spnInteres = new javax.swing.JSpinner();
        pnlPie = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Cliente");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Cédula:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Dirección:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Teléfono:");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txtCedula))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono))))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(21, 21, 21)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addComponent(spnCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(cbxSeccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtCarrera, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCorreo))))
                .addContainerGap())
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(cbxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPrincipal.add(pnlCenter, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuenta de Ahorros"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Nro. de cuenta:");

        txtNroCuenta.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Monto:");

        spnMonto.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 1.0d));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(txtNroCuenta)
                    .addComponent(spnMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Socio"));

        chxSocio.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chxSocio.setText("Registrar Socio");
        chxSocio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chxSocioItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Aporte Inicial:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Interés:");

        spnAporteInicial.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 1.0d));
        spnAporteInicial.setEnabled(false);

        spnInteres.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 1.0d));
        spnInteres.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel9))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(chxSocio))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spnInteres, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnAporteInicial, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(chxSocio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnAporteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spnInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);

        pnlPrincipal.add(jPanel1, java.awt.BorderLayout.CENTER);

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

            daoCliente = new ClienteJpaController(Inicio.factory);
            daoCuentaAhorros = new CuentaAhorrosJpaController(Inicio.factory);
            daoSocio = new SocioJpaController(Inicio.factory);

            // Monto que va a depositar
            double montoInicial = Double.parseDouble(spnMonto.getValue().toString());
            // Monto una vez se cobra los gastos administrativos
            double montoFinal = montoInicial - Constantes.GASTOS_ADMIN;

            CuentaAhorros cuenta = new CuentaAhorros();
            cuenta.setFecha_apertura(new Date());
            cuenta.setNro_cuenta(txtNroCuenta.getText());
            cuenta.setSaldo(montoFinal);

            Cliente cli = new Cliente();
            cli.setCedula(txtCedula.getText());
            cli.setApellidos(txtApellidos.getText());
            cli.setNombres(txtNombres.getText());
            cli.setTelefono(txtTelefono.getText());
            cli.setDireccion(txtDireccion.getText());
            cli.setCorreo(txtCorreo.getText());
            cli.setCarrera(txtCarrera.getText());
            cli.setCiclo((int) spnCiclo.getValue());
            cli.setSeccion(cbxSeccion.getSelectedItem().toString());
            cli.setEstado(true);
            cli.setCuenta_ahorros(cuenta);

            daoCuentaAhorros.create(cuenta);
            daoCliente.create(cli);

            // Registrar 1ra transacción inicial (Depósito)
            registrarTransaccion(cli, montoInicial, montoInicial, "Depósito", cli.toString());

            // Registrar 2da transacción final (Cobro Gastos Administrativos)
            registrarTransaccion(cli, Constantes.GASTOS_ADMIN, montoFinal, "Gasto administrativo (-)", Inicio.banco.toString());

            try {
                // Aumentamos el cobro administrativo a la cuenta del banco
                double montoBanco = Math.round((Inicio.cuentaBanco.getSaldo() + Constantes.GASTOS_ADMIN) * 100d) / 100d;
                // Registrar la transacción de cobro en el banco
                registrarTransaccion(Inicio.banco, Constantes.GASTOS_ADMIN, montoBanco, "Cobro administrativo (+)", cli.toString());

                Inicio.cuentaBanco.setSaldo(montoBanco);
                daoCuentaAhorros.edit(Inicio.cuentaBanco);

                // Si se guarda como socio
                if (chxSocio.isSelected()) {
                    Socio socio = new Socio();
                    socio.setEstado(true);
                    socio.setFecha_inicio(new Date());
                    socio.setAporte_inicial((double) spnAporteInicial.getValue());
                    socio.setInteres((double) spnInteres.getValue());
                    socio.setCliente(cli);
                    daoSocio.create(socio);

                    // Aumentar el saldo de la cuenta del banco (+)
                    double aporteSocio = Math.round((Inicio.cuentaBanco.getSaldo() + socio.getAporte_inicial()) * 100d) / 100d;
                    // Registrar transacción
                    registrarTransaccion(Inicio.banco, socio.getAporte_inicial(), aporteSocio, "Aporte Socio", socio.toString());

                    Inicio.cuentaBanco.setSaldo(aporteSocio);
                    daoCuentaAhorros.edit(Inicio.cuentaBanco);
                }

                limpiarCampos();
                JOptionPane.showMessageDialog(rootPane, "Registrado correctamente.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Hubo un problema al intentar ejecutar la petición.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } finally {
                Inicio.manager.getTransaction().commit();
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char tecla = evt.getKeyChar();
        if ((tecla < 48 || tecla > 57) || (txtCedula.getText().length() > 9)) {
            evt.consume();
        }
//        if(txtCedula.getText().length() == 10){
//            boolean isValida = validarCedula(txtCedula.getText());
//            
//        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void chxSocioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chxSocioItemStateChanged
        if (chxSocio.isSelected()) {
            spnAporteInicial.setEnabled(true);
            spnInteres.setEnabled(true);
        } else {
            spnAporteInicial.setEnabled(false);
            spnInteres.setEnabled(false);
        }
    }//GEN-LAST:event_chxSocioItemStateChanged

    public boolean camposLlenos() {
        return !txtCedula.getText().isEmpty() && !txtTelefono.getText().isEmpty()
                && !txtApellidos.getText().isEmpty() && !txtNombres.getText().isEmpty()
                && !txtDireccion.getText().isEmpty() && !txtCarrera.getText().isEmpty()
                && !txtNroCuenta.getText().isEmpty();
    }

    private void registrarTransaccion(Cliente cliente, double monto, double saldo, String tipo, String transDe) {
        Transaccion trans = new Transaccion();
        trans.setCliente(cliente);
        trans.setFecha(new Date());
        trans.setMonto(monto);
        trans.setSaldo(saldo);
        trans.setTipo(tipo);
        trans.setUsuarioResponsable(Inicio.cuentaLogin.getUsuario());
        trans.setTransaccionDe(transDe);
        new TransaccionJpaController(Inicio.factory).create(trans);
    }

    public void limpiarCampos() {
        txtCedula.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtNroCuenta.setText(generarCodigo());
        txtCorreo.setText("");
        txtCarrera.setText("");
        spnCiclo.setValue(1);
        spnMonto.setValue(1);
        spnAporteInicial.setValue(1);
        spnInteres.setValue(1);
        cbxSeccion.setSelectedIndex(0);
        chxSocio.setSelected(false);
        chxSocioItemStateChanged(null);
    }

    //Nro. de cuenta seguido, no aleatoria
    public static String generarCodigo() {
        int numClientes = new ClienteJpaController(Inicio.factory).getClienteCount();
        String cod = String.valueOf(numClientes+1);//Aleatorios de 8 dígitos
        if (cod.length() <= 10) { //Completa con 0's para tener 10 dígitos
            while (cod.length() < 10) {
                cod = "0" + cod;
            }
        }
        return cod;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxSeccion;
    private javax.swing.JCheckBox chxSocio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlPie;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JSpinner spnAporteInicial;
    private javax.swing.JSpinner spnCiclo;
    private javax.swing.JSpinner spnInteres;
    private javax.swing.JSpinner spnMonto;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
