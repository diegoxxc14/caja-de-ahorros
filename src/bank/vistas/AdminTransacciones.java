package bank.vistas;

import bank.controladores.ClienteJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.CuentaJpaController;
import bank.controladores.TransaccionJpaController;
import bank.modelos.Cliente;
import bank.modelos.CuentaAhorros;
import bank.modelos.Transaccion;
import static bank.vistas.AdminCuotas.chcPagado;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class AdminTransacciones extends javax.swing.JDialog {

    private ClienteJpaController daoCliente;
    private TransaccionJpaController daoTransaccion;
    private Cliente clienteSeleccionado;
    private final Object[] columnas = {"Nro.", "Fecha", "Tipo", "Monto", "Saldo", "Cajero(a)", "Solicitante"};
    private long idsTrans[];

    public AdminTransacciones(java.awt.Frame parent, boolean modal) {
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
        jPanel2 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTransacciones = new javax.swing.JTable(){
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Transacciones");
        setPreferredSize(new java.awt.Dimension(625, 630));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar cliente"));

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

        btnImprimir.setText("Imprimir Comprobante");
        btnImprimir.setEnabled(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir);

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        pnlPrincipal.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Transacciones"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        tablaTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro.", "Fecha", "Tipo", "Monto", "Saldo", "Responsable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTransacciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaTransacciones.setRowHeight(25);
        tablaTransacciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaTransacciones.getTableHeader().setReorderingAllowed(false);
        tablaTransacciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTransaccionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTransacciones);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNroCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtNombres))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtApellidos))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        pnlPrincipal.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaTransaccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTransaccionesMouseClicked
        btnImprimir.setEnabled(true);
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_tablaTransaccionesMouseClicked

    private void cbxCriterioBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCriterioBusquedaItemStateChanged
        txtTextoBuscar.setText("");
        txtTextoBuscar.grabFocus();
        limpiarCampos();
    }//GEN-LAST:event_cbxCriterioBusquedaItemStateChanged

    private void txtTextoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextoBuscarKeyReleased

        daoCliente = new ClienteJpaController(Inicio.factory);
        daoTransaccion = new TransaccionJpaController(Inicio.factory);

        String textoBusqueda = txtTextoBuscar.getText();
        if (!textoBusqueda.isEmpty()) {
            int criterioBusqueda = cbxCriterioBusqueda.getSelectedIndex();
            List<Cliente> clientes = (criterioBusqueda == 0) ? daoCliente.findAllByCed(textoBusqueda) : daoCliente.findAllByNumCuenta(textoBusqueda);

            if (!clientes.isEmpty()) { //Si la lista de cliente no está vacía
                clienteSeleccionado = clientes.get(0); //Selecciono el 1er cliente
                txtCedula.setText(clienteSeleccionado.getCedula());
                txtNroCuenta.setText(clienteSeleccionado.getCuenta_ahorros().toString());
                txtNombres.setText(clienteSeleccionado.getNombres());
                txtApellidos.setText(clienteSeleccionado.getApellidos());

                Object[][] registros = convertirLista(daoTransaccion.findByIdCliente(clienteSeleccionado.getId()));
                DefaultTableModel modelo = new DefaultTableModel(registros, columnas);
                tablaTransacciones.setModel(modelo);
                redimencionarTabla();
            } else {
                limpiarCampos();
            }
        } else {
            limpiarCampos();
        }
        btnEditar.setEnabled(false);
        btnImprimir.setEnabled(false);
    }//GEN-LAST:event_txtTextoBuscarKeyReleased

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            int filaSel = tablaTransacciones.getSelectedRow();
//        {"Nro.", "Fecha", "Tipo", "Monto", "Saldo", "Cajero(a)", "Solicita"};
            String fecha = tablaTransacciones.getValueAt(filaSel, 1).toString();
            String tipoTransaccion = tablaTransacciones.getValueAt(filaSel, 2).toString();
            String monto = tablaTransacciones.getValueAt(filaSel, 3).toString();
            String cajeroa = tablaTransacciones.getValueAt(filaSel, 5).toString();
            String solicitante = tablaTransacciones.getValueAt(filaSel, 6).toString();

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/bank/reportes/comprobanteTrans.jasper"));
            Map parametros = new HashMap();
            parametros.put("nroCuenta", txtNroCuenta.getText());
            parametros.put("cedula", txtCedula.getText());
            parametros.put("cliente", txtNombres.getText() + " " + txtApellidos.getText());
            parametros.put("monto", monto);
            parametros.put("fecha", fecha);
            parametros.put("cajero", cajeroa);
            parametros.put("solicitante", solicitante);
            parametros.put("tipoTransaccion", tipoTransaccion);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setSize(new Dimension(500, 700));
            jv.setZoomRatio(0.75f);
            jv.setTitle("Comprobante de Transacción - " + txtNroCuenta.getText());
            jv.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al intentar generar el comprobante.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        /*finally {
            btnImprimir.setEnabled(false);
            btnEditar.setEnabled(false);
        }*/
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        long idTrans = idsTrans[tablaTransacciones.getSelectedRow()];
        Transaccion trans = new TransaccionJpaController(Inicio.factory).findTransaccion(idTrans);
        Cliente cli = new ClienteJpaController(Inicio.factory).findCliente(trans.getCliente().getId());
        CuentaAhorros cue_aho = new CuentaAhorrosJpaController(Inicio.factory).findCuentaAhorros(cli.getCuenta_ahorros().getId());
        EditarTransaccion et = new EditarTransaccion(null, true, trans, cli, cue_aho);
        et.setLocationRelativeTo(null);
        et.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        txtTextoBuscarKeyReleased(null); //Actualizar la tabla según el texto de búsqueda
    }//GEN-LAST:event_formWindowGainedFocus

    public void limpiarCampos() {
        txtCedula.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtNroCuenta.setText("");
        btnImprimir.setEnabled(false);
        btnEditar.setEnabled(false);
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tablaTransacciones.setModel(modelo);
    }

    private Object[][] convertirLista(List<Transaccion> transacciones) {
        CuentaJpaController daoCuenta = new CuentaJpaController(Inicio.factory);
        Object[][] objetos = {};
        if (transacciones != null) {
            objetos = new Object[transacciones.size()][columnas.length];
            idsTrans = new long[transacciones.size()];
            for (int i = 0; i < transacciones.size(); i++) {
                objetos[i][0] = i + 1;
                objetos[i][1] = new SimpleDateFormat("dd-MM-yyyy hh:mm aaa").format(transacciones.get(i).getFecha());
                objetos[i][2] = transacciones.get(i).getTipo();
                objetos[i][3] = transacciones.get(i).getMonto();
                objetos[i][4] = transacciones.get(i).getSaldo();
                objetos[i][5] = daoCuenta.findByIdUsuario(transacciones.get(i).getUsuarioResponsable().getId()).getUsername();
                objetos[i][6] = transacciones.get(i).getTransaccionDe();
                idsTrans[i] = transacciones.get(i).getId(); //Almaceno los ids de las transacciones
            }
        }
        return objetos;
    }

    private void redimencionarTabla() {
        TableColumnModel colMol = tablaTransacciones.getColumnModel();
        colMol.getColumn(0).setPreferredWidth(15); //Nro.
        colMol.getColumn(1).setPreferredWidth(55); //Fecha
        colMol.getColumn(2).setPreferredWidth(40); //Tipo
        colMol.getColumn(3).setPreferredWidth(40); //Monto
        colMol.getColumn(4).setPreferredWidth(50); //Saldo
        colMol.getColumn(5).setPreferredWidth(45); //Cajero(a)
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cbxCriterioBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTable tablaTransacciones;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtTextoBuscar;
    // End of variables declaration//GEN-END:variables
}
