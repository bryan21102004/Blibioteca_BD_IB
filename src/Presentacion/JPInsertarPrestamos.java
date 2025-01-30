package Presentacion;

import Conexion_BD.Conexion;
import Entidad.Prestamos;
import java.sql.Connection;
import Logic.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JPInsertarPrestamos extends javax.swing.JPanel {

    String nombreColumnas[] = {"IDPrestamo", "IDEstudiante", "IDEjemplar", "Fecha_Prestamo", "Fecha_Devolucion",
        "Estado"};

    DefaultTableModel model;

    public JPInsertarPrestamos() {
        initComponents();

        model = new DefaultTableModel(null, nombreColumnas) {
            @Override
            //Este pequeño metodo evita que la tabla sea editable
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(model);
        //llamamos el metodo para obtener todos los prestamos de la BD
        //y ya cargarlos en la tabla de la interfaz
        cargarTabla();
    }

    public void cargarTabla() {
        Conexion conector = new Conexion();
        Connection conexion = conector.conectar();

        String sql = "SELECT ID_Prestamo,ID_Estudiante,ID_Ejemplar,Fecha_Prestamo,Fecha_Devolucion, Estado FROM PRESTAMOS ";
        try (Statement stm = conexion.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("ID_Prestamo"),
                    rs.getInt("ID_Estudiante"),
                    rs.getInt("ID_Ejemplar"),
                    rs.getDate("Fecha_Prestamo"),
                    rs.getDate("Fecha_Devolucion"),
                    rs.getString("Estado")
                };
                model.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla " + e.getMessage());
        } finally {
            conector.desconectar();
        }
    }

    public void insertarPrestamo() {
        if (txtIDEjemplar.getText().trim().isEmpty() || txtIDEstudiante.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los datos");
        } else {

            try {
                int IDEstudiante = Integer.parseInt(txtIDEstudiante.getText());
                int IDEjemplar = Integer.parseInt(txtIDEjemplar.getText());

                Conexion conector = new Conexion();
                Connection conexion = conector.conectar();
                 
                //Se verifica si existe el id del estudiante
                String verificarEstudiante = "SELECT COUNT(*) FROM ESTUDIANTE WHERE ID_Estudiante=?";
                try (PreparedStatement psEstudiante = conexion.prepareStatement(verificarEstudiante)) {
                    psEstudiante.setInt(1, IDEstudiante);
                    ResultSet rsEstudiante = psEstudiante.executeQuery();
                    if (rsEstudiante.next() && rsEstudiante.getInt(1) == 0) {
                        JOptionPane.showMessageDialog(null, "ID del estudiante no encontrado");
                        conector.desconectar();
                        return;
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al verificar estudiante");
                    conector.desconectar();
                    return;
                }
                 //se verifica si existe el id del ejemplar
                String verificarEjemplar = "SELECT COUNT(*) FROM Ejemplares WHERE ID_Ejemplar=?";
                try (PreparedStatement psEjemplar = conexion.prepareStatement(verificarEjemplar)) {
                    psEjemplar.setInt(1, IDEjemplar);
                    ResultSet rsEjemplar = psEjemplar.executeQuery();
                    if (rsEjemplar.next() && rsEjemplar.getInt(1) == 0) {
                        JOptionPane.showMessageDialog(null, "ID del ejemplar no encontrado");
                        conector.desconectar();
                        return;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al verificar ejemplar");
                    conector.desconectar();
                    return;

                }
                Prestamos prestamo = new Prestamos();
                prestamo.setIdEstudiante(IDEstudiante);
                prestamo.setIdEjemplar(IDEjemplar);

                CRUD crud = new CRUD(conexion);
                boolean insercion = crud.insertarPrestamo(prestamo);
                if (insercion) {
                    JOptionPane.showMessageDialog(null, "Prestamo insertado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Prestamo insertado con éxito ");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico");
            }
        }
    }

    public void limpiarCampos() {
        txtIDEjemplar.setText("");
        txtIDEstudiante.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPInsertarP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIDEstudiante = new javax.swing.JTextField();
        txtIDEjemplar = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        JPInsertarP.setBackground(new java.awt.Color(204, 255, 204));
        JPInsertarP.setForeground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel1.setText("Insertar  prestamos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("IDEstudiante:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("IDEjemplar:");

        txtIDEstudiante.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIDEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDEstudianteActionPerformed(evt);
            }
        });

        txtIDEjemplar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIDEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDEjemplarActionPerformed(evt);
            }
        });

        btnInsertar.setBackground(new java.awt.Color(51, 153, 255));
        btnInsertar.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertar.setText("Insertar Prestamo");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout JPInsertarPLayout = new javax.swing.GroupLayout(JPInsertarP);
        JPInsertarP.setLayout(JPInsertarPLayout);
        JPInsertarPLayout.setHorizontalGroup(
            JPInsertarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInsertarPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPInsertarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIDEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(JPInsertarPLayout.createSequentialGroup()
                .addGroup(JPInsertarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInsertarPLayout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel1))
                    .addGroup(JPInsertarPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnInsertar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPInsertarPLayout.setVerticalGroup(
            JPInsertarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInsertarPLayout.createSequentialGroup()
                .addGroup(JPInsertarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInsertarPLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDEstudiante)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDEjemplar)
                        .addGap(111, 111, 111))
                    .addGroup(JPInsertarPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnInsertar)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPInsertarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPInsertarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEstudianteActionPerformed

    private void txtIDEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDEjemplarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEjemplarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        insertarPrestamo();
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_btnInsertarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPInsertarP;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtIDEjemplar;
    private javax.swing.JTextField txtIDEstudiante;
    // End of variables declaration//GEN-END:variables
}
