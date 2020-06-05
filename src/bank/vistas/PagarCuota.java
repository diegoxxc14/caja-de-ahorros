package bank.vistas;

import bank.controladores.AmortizacionJpaController;
import bank.controladores.CreditoJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.TransaccionJpaController;
import bank.modelos.Amortizacion;
import bank.modelos.Cliente;
import bank.modelos.Constantes;
import bank.modelos.Credito;
import bank.modelos.CuentaAhorros;
import bank.modelos.Transaccion;
import static bank.vistas.AdminCreditos.tablaCreditos;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PagarCuota extends javax.swing.JDialog {

    private Amortizacion cuotaAPagar;
    private AmortizacionJpaController daoAmortizacion;
    private CuentaAhorrosJpaController daoCuentaAhorro;
    private CreditoJpaController daoCredito;

    public PagarCuota(java.awt.Frame parent, boolean modal, Amortizacion amortizacion) {
        super(parent, modal);
        this.cuotaAPagar = amortizacion;
        initComponents();
        cargarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNroCuota = new javax.swing.JTextField();
        txtCuotaPagar = new javax.swing.JTextField();
        fechaFechaPago = new com.toedter.calendar.JDateChooser();
        txtTotalMora = new javax.swing.JTextField();
        txtDiasMora = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalAPagar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagar cuota");
        setResizable(false);

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Cuota"));

        txtNroCuota.setEditable(false);

        txtCuotaPagar.setEditable(false);

        fechaFechaPago.setEnabled(false);

        txtTotalMora.setEditable(false);

        txtDiasMora.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nro. de Cuota:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cuota a pagar:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Fecha de pago:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Días mora:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Total mora:");

        txtTotalAPagar.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Total a pagar:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNroCuota, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCuotaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiasMora, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(txtTotalMora, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtTotalAPagar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNroCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCuotaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fechaFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiasMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        try {
            // Editar la amortización
            daoAmortizacion = new AmortizacionJpaController(Inicio.factory);
            cuotaAPagar.setDiasMora(Integer.parseInt(txtDiasMora.getText()));
            cuotaAPagar.setTotalMora(Double.parseDouble(txtTotalMora.getText()));
            cuotaAPagar.setPagada(true);
            daoAmortizacion.edit(cuotaAPagar);

            //Aumentar la cuenta del banco
            daoCuentaAhorro = new CuentaAhorrosJpaController(Inicio.factory);
//            Inicio.cuentaBanco = daoCuentaAhorro.findCuentaAhorros(Constantes.ID_CUENTA_BANCO);
            double totalCuotaPagar = cuotaAPagar.getTotalMora() + cuotaAPagar.getPagoSemanal();
            double saldoBanco = Math.round((Inicio.cuentaBanco.getSaldo() + totalCuotaPagar) * 100d) / 100d;
            
            // Registrar la transacción del cobro del crédito
            registrarTransaccion(Inicio.banco, totalCuotaPagar, saldoBanco, "Cuota crédito (+)", cuotaAPagar.getCredito().getCliente().toString());

            Inicio.cuentaBanco.setSaldo(saldoBanco);
            daoCuentaAhorro.edit(Inicio.cuentaBanco);

            JOptionPane.showMessageDialog(rootPane, "Cobro de cuota registrado con éxito.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            actualizarTablaCuotas();

            // Comprobar si todas las cuotas ya están pagadas
            if (!AdminCuotas.listaAmortizacionPagadas.contains(false)) {
                AdminCuotas.chcPagado.setSelected(true);
                AdminCuotas.btnPagarCuota.setEnabled(false);
                daoCredito = new CreditoJpaController(Inicio.factory);
                Credito cre = cuotaAPagar.getCredito();
                cre.setPagado(true);
                daoCredito.edit(cre);
                actualizarTablaCreditos();
            }

            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Hubo un problema al intentar registrar este cobro.", "ERROR", JOptionPane.ERROR_MESSAGE);
//            Logger.getLogger(PagarCuota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void registrarTransaccion(Cliente cliente, double monto, double saldo, String tipo, String transDe) {
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void actualizarTablaCuotas() {
        Object[][] registros = AdminCuotas.convertirLista(daoAmortizacion.findAmortizacionByIdCredito(cuotaAPagar.getCredito().getId()));
        AdminCuotas.cargarAmortizacion(registros);
    }

    private void actualizarTablaCreditos() {
        List<Credito> creditos = daoCredito.findCreditosByCliente(cuotaAPagar.getCredito().getCliente().getId());
        Object[][] registros = AdminCreditos.convertirLista(creditos);
        DefaultTableModel modelo = new DefaultTableModel(registros, AdminCreditos.columnas);
        tablaCreditos.setModel(modelo);
    }

    private void cargarCampos() {
        txtCuotaPagar.setText(String.valueOf(cuotaAPagar.getPagoSemanal()));
        txtNroCuota.setText(String.valueOf(cuotaAPagar.getNumeroCuota()));
        fechaFechaPago.setDate(cuotaAPagar.getFechaPago());

        // Calcular Mora
        Calendar calHoy = Calendar.getInstance();
        Calendar calFechaPago = Calendar.getInstance();
        calHoy.setTime(new Date());
        calFechaPago.setTime(cuotaAPagar.getFechaPago());
        int diasMora = calHoy.get(Calendar.DAY_OF_YEAR) - calFechaPago.get(Calendar.DAY_OF_YEAR);

        if (diasMora >= 0) { //En caso de pagar durante o después de la fecha establecida
            txtDiasMora.setText(String.valueOf(diasMora));
            txtTotalMora.setText(String.valueOf(calcularMora(diasMora)));
        } else {// En caso de pagar antes del fecha de pago establecida
            txtDiasMora.setText("0");
            txtTotalMora.setText("0");
        }

        txtTotalAPagar.setText(String.valueOf(Double.parseDouble(txtCuotaPagar.getText()) + Double.parseDouble(txtTotalMora.getText())));
    }

    private double calcularMora(int diasMora) {
        int mul = diasMora / 2;
        return mul * 0.25;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private com.toedter.calendar.JDateChooser fechaFechaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCuotaPagar;
    private javax.swing.JTextField txtDiasMora;
    private javax.swing.JTextField txtNroCuota;
    private javax.swing.JTextField txtTotalAPagar;
    private javax.swing.JTextField txtTotalMora;
    // End of variables declaration//GEN-END:variables
}
