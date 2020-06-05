package bank.vistas;

import bank.controladores.ClienteJpaController;
import bank.controladores.CreditoJpaController;
import bank.controladores.CuentaAhorrosJpaController;
import bank.controladores.PolizaJpaController;
import bank.modelos.Cliente;
import bank.modelos.Credito;
import bank.modelos.CuentaAhorros;
import bank.modelos.Poliza;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AdminPolizas extends javax.swing.JDialog {

    private ClienteJpaController daoCliente;
    private CuentaAhorrosJpaController daoCuentaAhorro;
    private PolizaJpaController daoPoliza;
    private static ArrayList<Long> listaIdsPolizas;
    private Cliente clienteSeleccionado;
    public static final Object[] columnas = {"Nro.", "Emisión", "Vencimiento", "Monto", "Tasa", "Interés", "Vigente"};

    public AdminPolizas(java.awt.Frame parent, boolean modal) {
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
        btnFinPoliza = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPolizas = new javax.swing.JTable(){
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
        setTitle("Administrar Pólizas");
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

        btnFinPoliza.setText("Finalizar Póliza");
        btnFinPoliza.setEnabled(false);
        btnFinPoliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinPolizaActionPerformed(evt);
            }
        });
        jPanel2.add(btnFinPoliza);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        pnlPrincipal.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Información de cliente"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pólizas"));

        tablaPolizas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nro.", "Emisión", "Vencimiento", "Monto", "Tasa", "Interés", "Vigente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPolizas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaPolizas.setRowHeight(25);
        tablaPolizas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaPolizas.getTableHeader().setReorderingAllowed(false);
        tablaPolizas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPolizasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPolizas);

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
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(txtNroCuenta))
                .addGap(18, 18, 18)
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
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        pnlPrincipal.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPolizasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPolizasMouseClicked
        btnFinPoliza.setEnabled(true);
    }//GEN-LAST:event_tablaPolizasMouseClicked

    private void cbxCriterioBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCriterioBusquedaItemStateChanged
        txtTextoBuscar.setText("");
        txtTextoBuscar.grabFocus();
        limpiarCampos();
    }//GEN-LAST:event_cbxCriterioBusquedaItemStateChanged

    private void txtTextoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextoBuscarKeyReleased

        daoCliente = new ClienteJpaController(Inicio.factory);
        daoPoliza = new PolizaJpaController(Inicio.factory);

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

                List<Poliza> polizas = daoPoliza.findPolizasByCliente(clienteSeleccionado.getId());

                Object[][] registros = convertirLista(polizas);
                DefaultTableModel modelo = new DefaultTableModel(registros, columnas);
                tablaPolizas.setModel(modelo);
                redimencionarTabla();
            } else {
                limpiarCampos();
            }
        } else {
            limpiarCampos();
        }
    }//GEN-LAST:event_txtTextoBuscarKeyReleased

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnFinPolizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinPolizaActionPerformed
        long idPolizaSeleccionada = listaIdsPolizas.get(tablaPolizas.getSelectedRow());
        Poliza polizaSeleccionada = daoPoliza.findPoliza(idPolizaSeleccionada);

        Inicio.manager.getTransaction().begin();

        daoCuentaAhorro = new CuentaAhorrosJpaController(Inicio.factory);
        CuentaAhorros cuentaBanco = daoCuentaAhorro.findCuentaAhorros(new Long(1));
        CuentaAhorros cuentaCliente = clienteSeleccionado.getCuenta_ahorros();

        if (polizaSeleccionada.getFechaVencimiento().compareTo(new Date()) <= 0) { //-1=antes  0=igual  1=después
            if (polizaSeleccionada.isVigente()) {
                try {
                    polizaSeleccionada.setVigente(false);
                    daoPoliza.edit(polizaSeleccionada);

                    //Actualizar el saldo de la cuenta del banco (-)
                    cuentaBanco.setSaldo(Math.round((cuentaBanco.getSaldo() - (polizaSeleccionada.getMonto() + polizaSeleccionada.getTotalInteres())) * 100d) / 100d);
                    daoCuentaAhorro.edit(cuentaBanco);

                    //Actualizar la cuenta de ahorros del cliente (+)
                    cuentaCliente.setSaldo(Math.round((cuentaCliente.getSaldo() + (polizaSeleccionada.getMonto() + polizaSeleccionada.getTotalInteres())) * 100d) / 100d);
                    daoCuentaAhorro.edit(cuentaCliente);

                    JOptionPane.showMessageDialog(rootPane, "La póliza se ha finalizado con éxito.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Hubo un problema al intentar finalizar esta póliza.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AdminPolizas.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "La póliza no se encuentra vigente.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "No se puede finalizar, la fecha de vencimiento no se ha cumplido.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        Inicio.manager.getTransaction().commit();
//        AdminCuotas ac = new AdminCuotas(null, rootPaneCheckingEnabled, polizaSeleccionada);
//        ac.setLocationRelativeTo(null);
//        ac.setVisible(true);
    }//GEN-LAST:event_btnFinPolizaActionPerformed

    public void limpiarCampos() {
        txtCedula.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtNroCuenta.setText("");
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tablaPolizas.setModel(modelo);
        btnFinPoliza.setEnabled(false);
    }

    public static Object[][] convertirLista(List<Poliza> polizas) {
        listaIdsPolizas = new ArrayList<>();
        Object[][] objetos = {};
        if (polizas != null) {
            objetos = new Object[polizas.size()][columnas.length];
            for (int i = 0; i < polizas.size(); i++) {
                listaIdsPolizas.add(polizas.get(i).getId());
                objetos[i][0] = i + 1;
                objetos[i][1] = new SimpleDateFormat("dd-MM-yyyy").format(polizas.get(i).getFechaEmision());
                objetos[i][2] = new SimpleDateFormat("dd-MM-yyyy").format(polizas.get(i).getFechaVencimiento());
                objetos[i][3] = polizas.get(i).getMonto();
                objetos[i][4] = polizas.get(i).getTasaInteres();
                objetos[i][5] = polizas.get(i).getTotalInteres();
                objetos[i][6] = (polizas.get(i).isVigente()) ? "Si" : "No";
            }
        }
        return objetos;
    }

    private void redimencionarTabla() {
        TableColumnModel colMol = tablaPolizas.getColumnModel();
        colMol.getColumn(0).setPreferredWidth(20); //Nro.
        colMol.getColumn(1).setPreferredWidth(50); //Fecha Emisión
        colMol.getColumn(2).setPreferredWidth(50); //Fecha Vencimiento
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnFinPoliza;
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
    public static javax.swing.JTable tablaPolizas;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtTextoBuscar;
    // End of variables declaration//GEN-END:variables
}
