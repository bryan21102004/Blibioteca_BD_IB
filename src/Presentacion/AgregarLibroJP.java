/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import Conexion_BD.Conexion;
import Logic.CRUD;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class AgregarLibroJP extends javax.swing.JPanel {

    private ArrayList<String> meses;
    private int añoActual;
    private int añoSeleccionado;
    private int mesSeleccionado;
    private int diaSeleccionado;
    private Conexion conexion;
    private CRUD crud;
    private String fechaFinal;
    public AgregarLibroJP() {
        meses = new ArrayList(Arrays.asList("Mes", "Enero", "Febrero", "Marzo",
                "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
                "Noviembre", "Diciembre"));
        añoActual = Calendar.getInstance().get(Calendar.YEAR);
        conexion=new Conexion();
        crud=new CRUD(conexion.conectar());
        initComponents();
        llenarCombo();
        llenarComboAño();
        seleccionDia();
        seleccionMes();
        seleccionAño();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tituloTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        isbnTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cantidadPaginasTxt = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        editorialTxt = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        diaCbx = new javax.swing.JComboBox<>();
        añoCbx = new javax.swing.JComboBox<>();
        mesCbx = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Titulo libro");

        tituloTxt.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ISBN");

        isbnTxt.setBorder(null);

        jSeparator2.setForeground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad de paginas");

        cantidadPaginasTxt.setBorder(null);
        cantidadPaginasTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadPaginasTxtKeyTyped(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(153, 204, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Editorial");

        editorialTxt.setBorder(null);

        jSeparator4.setForeground(new java.awt.Color(153, 204, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Fecha de publicación");

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ucr.png"))); // NOI18N

        diaCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));
        diaCbx.setEnabled(false);

        añoCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        mesCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mesCbx.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(diaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mesCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(añoCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1)
                                    .addComponent(tituloTxt)
                                    .addComponent(isbnTxt)
                                    .addComponent(cantidadPaginasTxt)
                                    .addComponent(editorialTxt)
                                    .addComponent(jSeparator2)
                                    .addComponent(jSeparator3)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton3)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tituloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(isbnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantidadPaginasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(editorialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(diaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(añoCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        retroceder();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!cantidadPaginasTxt.getText().equals("")
                && !tituloTxt.getText().equals("") && !isbnTxt.getText().equals("")
                && !editorialTxt.getText().equals("") && diaCbx.getSelectedIndex() > 0
                && mesCbx.getSelectedIndex() > 0 && añoCbx.getSelectedIndex() > 0) {
            if (verificarParseo(cantidadPaginasTxt.getText())) {
                //permite agregar 
                fechaFinal=añoSeleccionado+"-"+mesSeleccionado+"-"+diaSeleccionado;
                crud.insertarLibro(tituloTxt.getText(),isbnTxt.getText(), fechaFinal,
                        editorialTxt.getText(), Integer.parseInt(cantidadPaginasTxt.getText()));
                vaciarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Debe colocar un numéro válido en la cantidad de paginas");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cantidadPaginasTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadPaginasTxtKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidadPaginasTxtKeyTyped
    //Retrocede al panel de libros
    private void retroceder() {
        PanelLibros panelLibros = new PanelLibros();
        this.removeAll();
        this.revalidate();
        this.repaint();
        panelLibros.setSize(800, 500);
        this.add(panelLibros);
    }

    //Verifica que el texto pueda parsearse
    private boolean verificarParseo(String texto) {
        boolean parseoValido = true;
        try {
            int id = Integer.parseInt(texto);
        } catch (Exception e) {
            parseoValido = false;
        }
        return parseoValido;
    }
    
    private void vaciarCampos(){
        tituloTxt.setText("");
        isbnTxt.setText("");
        editorialTxt.setText("");
        cantidadPaginasTxt.setText("");
        diaCbx.setSelectedIndex(0);
        mesCbx.setSelectedIndex(0);
        añoCbx.setSelectedIndex(0);
    }

    //Llena el comboBox de los meses
    public void llenarCombo() {
        mesCbx.removeAllItems();
        for (int i = 0; i < meses.size(); i++) {
            mesCbx.addItem(meses.get(i));
        }
    }

    //Llena el comboBox de los años
    private void llenarComboAño() {
        añoCbx.removeAllItems();
        añoCbx.addItem("Año");
        for (int i = añoActual; i >= 1900; i--) {
            añoCbx.addItem(i + "");
        }
    }

    private void seleccionDia() {
        diaCbx.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (diaCbx.getSelectedIndex() > 0 && verificarParseo(e.getItem() + "")) {
                    diaSeleccionado = Integer.parseInt(e.getItem() + "");
                }
            }
        });
    }

    private void seleccionAño() {
        añoCbx.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (añoCbx.getSelectedIndex() > 0) {
                    añoSeleccionado = Integer.parseInt(añoCbx.getSelectedItem() + "");
                    mesCbx.setEnabled(true);
                    if (mesCbx.getSelectedIndex() > 0) {
                        llenarComboDia(mesSeleccionado, añoSeleccionado);
                    }
                } else {
                    mesCbx.setEnabled(false);
                    diaCbx.setEnabled(false);
                }
            }
        });
    }

    //Prepara los dias  luego de establecer el mes y año evitando la posicion 0
    private void seleccionMes() {
        mesCbx.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                mesSeleccionado = mesCbx.getSelectedIndex();
                if (mesSeleccionado > 0 && añoCbx.getSelectedIndex() > 0) {
                    llenarComboDia(mesSeleccionado, añoSeleccionado);
                    diaCbx.setEnabled(true);
                } else {
                    diaCbx.setEnabled(false);
                }
            }
        });
    }

    //Crea el comboBox dia
    private void crearCBXDia(int ultimoDia) {
        diaCbx.addItem("Dia");
        for (int i = 1; i <= ultimoDia; i++) {
            diaCbx.addItem(i + "");
        }
    }

    //Llena el comboBox dia
    private void llenarComboDia(int mesSeleccionado, int añoSeleccionado) {
        diaCbx.removeAllItems();
        if (mesSeleccionado > 0 && añoSeleccionado > 0) {
            if (mesSeleccionado == 7 || mesSeleccionado == 8) {//Ambos tienen 31 dias
                crearCBXDia(31);
            } else if (mesSeleccionado == 2 && Year.isLeap(añoSeleccionado)) {
                crearCBXDia(29);
            } else if (mesSeleccionado == 2) {
                crearCBXDia(28);
            } else if (mesSeleccionado % 2 == 1 && mesSeleccionado <= 8) {//Los impares y antes de agosto
                crearCBXDia(31);
            } else if (mesSeleccionado % 2 == 1 && mesSeleccionado > 8) {//Los impares y después de agosto
                crearCBXDia(30);
            } else if (mesSeleccionado % 2 == 0 && mesSeleccionado <= 8) {//Los pares y antes de agosto
                crearCBXDia(30);
            } else if (mesSeleccionado % 2 == 0 && mesSeleccionado > 8) {//los pares y después de agosto
                crearCBXDia(31);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> añoCbx;
    private javax.swing.JTextField cantidadPaginasTxt;
    private javax.swing.JComboBox<String> diaCbx;
    private javax.swing.JTextField editorialTxt;
    private javax.swing.JTextField isbnTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox<String> mesCbx;
    private javax.swing.JTextField tituloTxt;
    // End of variables declaration//GEN-END:variables
}
