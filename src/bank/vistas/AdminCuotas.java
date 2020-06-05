package bank.vistas;

import bank.controladores.AmortizacionJpaController;
import bank.controladores.ClienteJpaController;
import bank.controladores.CreditoJpaController;
import bank.modelos.Amortizacion;
import bank.modelos.Credito;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class AdminCuotas extends javax.swing.JDialog {

    private ClienteJpaController daoCliente;
    private CreditoJpaController daoCredito;
    private AmortizacionJpaController daoAmortizacion;
    private static ArrayList<Long> listaIdsAmortizacion;
    public static ArrayList<Boolean> listaAmortizacionPagadas;
    private Credito creditoSeleccionado;
    private static List<Amortizacion> listaAmortizacion;
    private static final Object[] columnas = {"Nro.", "Fecha", "Couta", "Abono", "Interés", "Saldo", "Pagado"};

    public AdminCuotas(java.awt.Frame parent, boolean modal, Credito credito) {
        super(parent, modal);
        this.creditoSeleccionado = credito;
        initComponents();
        cargarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnPagarCuota = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAmortizacion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNroCuenta = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        chcPagado = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        txtInteres = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNroCuotas = new javax.swing.JTextField();
        fechaAprobado = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtTipoAmortizacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Cuotas");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        btnPagarCuota.setText("Pagar Cuota");
        btnPagarCuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarCuotaActionPerformed(evt);
            }
        });
        jPanel2.add(btnPagarCuota);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir);

        btnCerrar.setText("Cancelar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        pnlPrincipal.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Coutas semanales"));

        tablaAmortizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nro.", "Fecha", "Couta", "Abono", "Interés", "Saldo", "Pagado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAmortizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaAmortizacion.setRowHeight(25);
        tablaAmortizacion.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablaAmortizacion.getTableHeader().setReorderingAllowed(false);
        tablaAmortizacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAmortizacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAmortizacion);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de crédito"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nro. de Cuenta:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cédula:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Apellidos:");

        txtNroCuenta.setEditable(false);
        txtNroCuenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNombres.setEditable(false);
        txtNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtCedula.setEditable(false);
        txtCedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtApellidos.setEditable(false);
        txtApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        chcPagado.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chcPagado.setText("Pagado");
        chcPagado.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Interés:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Monto:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Número de Cuotas:");

        txtMonto.setEditable(false);

        txtInteres.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("%");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("$");

        txtNroCuotas.setEditable(false);

        fechaAprobado.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Fecha emisión:");

        txtTipoAmortizacion.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tipo Amortización:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(txtNroCuenta)
                        .addComponent(jLabel6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(chcPagado))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtNroCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTipoAmortizacion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(fechaAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chcPagado))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipoAmortizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNroCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pnlPrincipal.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaAmortizacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAmortizacionMouseClicked
        //
    }//GEN-LAST:event_tablaAmortizacionMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnPagarCuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarCuotaActionPerformed
        long idCuotaSeleccionada = -1;
        for (int i = 0; i < listaAmortizacionPagadas.size(); i++) {
            if (!listaAmortizacionPagadas.get(i)) {
                idCuotaSeleccionada = listaIdsAmortizacion.get(i);
                break;
            }
        }

        if (idCuotaSeleccionada != -1) {//Si hay cuotas sin pagar
            daoAmortizacion = new AmortizacionJpaController(Inicio.factory);
            Amortizacion cuotaAPagar = daoAmortizacion.findAmortizacion(idCuotaSeleccionada);

            PagarCuota pc = new PagarCuota(null, rootPaneCheckingEnabled, cuotaAPagar);
            pc.setLocationRelativeTo(null);
            pc.setVisible(true);
        }
    }//GEN-LAST:event_btnPagarCuotaActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        try {
            JasperReport jr;
            Map parametros = new HashMap();
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/bank/reportes/cuotasCredito.jasper"));
            JRBeanCollectionDataSource dataset = new JRBeanCollectionDataSource(listaAmortizacion);
            parametros.put("nroCuenta", txtNroCuenta.getText());
            parametros.put("cedula", txtCedula.getText());
            parametros.put("cliente", txtNombres.getText() + " " + txtApellidos.getText());
            parametros.put("monto", txtMonto.getText());
            parametros.put("fechaEmision", fechaAprobado.getDate());
            parametros.put("interes", txtInteres.getText());
            parametros.put("nroCuotas", txtNroCuotas.getText());
            parametros.put("pagado", (chcPagado.isSelected()) ? "Si" : "No");
            parametros.put("tipoAmortizacion", txtTipoAmortizacion.getText());
            parametros.put("listaAmortizacion", dataset);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setSize(new Dimension(850, 725));
            jv.setZoomRatio(0.75f);
            jv.setTitle("Tabla de Amortización - " + txtNroCuenta.getText());
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(AdminCuotas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    public void limpiarCampos() {
        txtCedula.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtNroCuenta.setText("");
        txtMonto.setText("");
        txtInteres.setText("");
        txtNroCuotas.setText("");
        fechaAprobado.setDate(null);
        chcPagado.setSelected(false);
        cargarAmortizacion(null); //Tabla vacía
    }

    public static void cargarAmortizacion(Object[][] datos) {
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tablaAmortizacion.setModel(modelo);
    }

    public static Object[][] convertirLista(List<Amortizacion> amortizacion) {
        listaIdsAmortizacion = new ArrayList();
        listaAmortizacionPagadas = new ArrayList();
        listaAmortizacion = new ArrayList();
        Object[][] objetos = {};
        if (amortizacion != null) {
            objetos = new Object[amortizacion.size()][columnas.length];
            for (int i = 0; i < amortizacion.size(); i++) {
                listaAmortizacion.add(amortizacion.get(i));//Para el reporte
                listaIdsAmortizacion.add(amortizacion.get(i).getId());
                listaAmortizacionPagadas.add(amortizacion.get(i).isPagada());
                objetos[i][0] = amortizacion.get(i).getNumeroCuota();
                objetos[i][1] = new SimpleDateFormat("dd-MM-yyyy").format(amortizacion.get(i).getFechaPago());
                objetos[i][2] = amortizacion.get(i).getPagoSemanal();
                objetos[i][3] = amortizacion.get(i).getAbono();
                objetos[i][4] = amortizacion.get(i).getInteres();
                objetos[i][5] = amortizacion.get(i).getSaldo();
                objetos[i][6] = (amortizacion.get(i).isPagada()) ? "Si" : "No";
            }
        }
        return objetos;
    }

    private void cargarCampos() {
        txtNroCuenta.setText(creditoSeleccionado.getCliente().getCuenta_ahorros().getNro_cuenta());
        txtCedula.setText(creditoSeleccionado.getCliente().getCedula());
        txtNombres.setText(creditoSeleccionado.getCliente().getNombres());
        txtApellidos.setText(creditoSeleccionado.getCliente().getApellidos());
        txtMonto.setText(String.valueOf(creditoSeleccionado.getMonto()));
        txtInteres.setText(String.valueOf(creditoSeleccionado.getTasaInteres()));
        txtNroCuotas.setText(String.valueOf(creditoSeleccionado.getNumeroCuotas()));
        txtTipoAmortizacion.setText(creditoSeleccionado.getTipoAmortizacion());
        fechaAprobado.setDate(creditoSeleccionado.getFechaEmision());
        chcPagado.setSelected(creditoSeleccionado.isPagado());

        daoAmortizacion = new AmortizacionJpaController(Inicio.factory);
        Object[][] registros = convertirLista(daoAmortizacion.findAmortizacionByIdCredito(creditoSeleccionado.getId()));
        cargarAmortizacion(registros);

        btnPagarCuota.setEnabled(!creditoSeleccionado.isPagado());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnImprimir;
    public static javax.swing.JButton btnPagarCuota;
    public static javax.swing.JCheckBox chcPagado;
    private com.toedter.calendar.JDateChooser fechaAprobado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPrincipal;
    public static javax.swing.JTable tablaAmortizacion;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtInteres;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtNroCuotas;
    private javax.swing.JTextField txtTipoAmortizacion;
    // End of variables declaration//GEN-END:variables
}
