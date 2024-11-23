package igu;

import bo.Camion;
import bo.Servicios;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventana extends javax.swing.JFrame {

    public Ventana() throws ExecutionException {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Refaccionaria");
        iniciarServicios();
    }
    private Servicios servicios;

    private void iniciarServicios() throws ExecutionException {
        servicios = new Servicios();
    }

    private void filtrarPorNombre() {
        String nombre = jTextFieldNombre.getText();
        if (!nombre.isBlank()) {
            List<Camion> lista = servicios.obtenerListaPorNombre(nombre);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
            } else {
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                            "Id", "Nombre", "Placas", "Tonelaje", "Marca"
                        }
                ));
                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                for (Camion c : lista) {
                    Object[] fila = {
                        c.getIdCamion(),
                        c.getNombre(),
                        c.getPlacas(),
                        c.getTotalAlmacenaje(),
                        c.getMarca()
                    };
                    modelo.addRow(fila);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo vacio");
        }
    }

    private void filtrarPorPlacas() {
        String placa = jTextFieldPlacas.getText();
        if (!placa.isBlank()) {
            List<Camion> lista = servicios.obtenerListaPorPlacas(placa);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
            } else {
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                            "Id", "Nombre", "Placas", "Tonelaje", "Marca"
                        }
                ));
                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                for (Camion c : lista) {
                    Object[] fila = {
                        c.getIdCamion(),
                        c.getNombre(),
                        c.getPlacas(),
                        c.getTotalAlmacenaje(),
                        c.getMarca()
                    };
                    modelo.addRow(fila);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo vacio");
        }
    }

    private void filtrarPorMarca() {
        String marca = jTextFieldMarca.getText();
        if (!marca.isBlank()) {
            List<Camion> lista = servicios.obtenerListaPorMarca(marca);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
            } else {
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                            "Id", "Nombre", "Placas", "Tonelaje", "Marca"
                        }
                ));
                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                for (Camion c : lista) {
                    Object[] fila = {
                        c.getIdCamion(),
                        c.getNombre(),
                        c.getPlacas(),
                        c.getTotalAlmacenaje(),
                        c.getMarca()
                    };
                    modelo.addRow(fila);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo vacio");
        }
    }

    private void filtrarPorTonelaje() {
        String min = jTextFieldMinimo.getText();
        String max = jTextFieldMaximo.getText();
        double minDouble;
        double maxDouble;

        if (!min.isBlank() && !max.isBlank()) {
            try {
                minDouble = Double.parseDouble(min);
                maxDouble = Double.parseDouble(max);

                List<Camion> lista = servicios.obtenerListaPorTonelaje(minDouble, maxDouble);
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                } else {
                    jTable1.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{},
                            new String[]{
                                "Id", "Nombre", "Placas", "Tonelaje", "Marca"
                            }
                    ));
                    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                    for (Camion c : lista) {
                        Object[] fila = {
                            c.getIdCamion(),
                            c.getNombre(),
                            c.getPlacas(),
                            c.getTotalAlmacenaje(),
                            c.getMarca()
                        };
                        modelo.addRow(fila);
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error \n" + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Campo vacio");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonNombre = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonPlacas = new javax.swing.JButton();
        jTextFieldPlacas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMinimo = new javax.swing.JTextField();
        jButtonTonelaje = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jButtonMarca = new javax.swing.JButton();
        jTextFieldMaximo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Id", "Nombre", "Placas", "Tonelaje", "Marca"
            }

        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonNombre.setText("Filtrar");
        jButtonNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jButtonPlacas.setText("Filtrar");
        jButtonPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlacasActionPerformed(evt);
            }
        });

        jLabel2.setText("Placas");

        jLabel3.setText("Tonelaje");

        jButtonTonelaje.setText("Filtrar");
        jButtonTonelaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTonelajeActionPerformed(evt);
            }
        });

        jLabel4.setText("Marca");

        jButtonMarca.setText("Filtrar");
        jButtonMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarcaActionPerformed(evt);
            }
        });

        jLabel5.setText("Minimo");

        jLabel6.setText("Máximo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jTextFieldPlacas)
                    .addComponent(jTextFieldMinimo)
                    .addComponent(jTextFieldMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonPlacas, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jButtonMarca)
                    .addComponent(jButtonTonelaje))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNombre)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPlacas)
                    .addComponent(jTextFieldPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonTonelaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonMarca))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNombreActionPerformed
        filtrarPorNombre();
    }//GEN-LAST:event_jButtonNombreActionPerformed

    private void jButtonPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlacasActionPerformed
        filtrarPorPlacas();
    }//GEN-LAST:event_jButtonPlacasActionPerformed

    private void jButtonMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarcaActionPerformed
        filtrarPorMarca();
    }//GEN-LAST:event_jButtonMarcaActionPerformed

    private void jButtonTonelajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTonelajeActionPerformed
        filtrarPorTonelaje();
    }//GEN-LAST:event_jButtonTonelajeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMarca;
    private javax.swing.JButton jButtonNombre;
    private javax.swing.JButton jButtonPlacas;
    private javax.swing.JButton jButtonTonelaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldMaximo;
    private javax.swing.JTextField jTextFieldMinimo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPlacas;
    // End of variables declaration//GEN-END:variables
}
