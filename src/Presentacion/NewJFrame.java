/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author Junio
 */
public class NewJFrame extends javax.swing.JFrame {

    ArrayList<String> meses;
    int añoActual;
    int añoSeleccionado;
    int mesSeleccionado;

    public NewJFrame() {
        meses = new ArrayList(Arrays.asList("Mes", "Enero", "Febrero", "Marzo",
                "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
                "Noviembre", "Diciembre"));
        añoActual = Calendar.getInstance().get(Calendar.YEAR);
        initComponents();
        llenarCombo();
        llenarComboAño();
//        seleccionDia();
        seleccionAño();
        seleccionMes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mesCbx = new javax.swing.JComboBox<>();
        diaCbx = new javax.swing.JComboBox<>();
        añoCbx = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mesCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mesCbx.setEnabled(false);

        diaCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        diaCbx.setEnabled(false);

        añoCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(diaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(añoCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(añoCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    public void llenarCombo() { //jComboBox1 = Meses
        mesCbx.removeAllItems();
        for (int i = 0; i < meses.size(); i++) {
            mesCbx.addItem(meses.get(i));
        }
    }

    private void llenarComboAño() { //jComboBox3 = Año
        añoCbx.removeAllItems();
        añoCbx.addItem("Año");
        for (int i = añoActual; i >= 1900; i--) {
            añoCbx.addItem(i + "");
        }
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

    private void crearCBXDia(int ultimoDia) {
        diaCbx.addItem("Dia");
        for (int i = 1; i <= ultimoDia; i++) {
            diaCbx.addItem(i + "");
        }
    }

    private void llenarComboDia(int mesSeleccionado, int añoSeleccionado) {
        diaCbx.removeAllItems();
        if (mesSeleccionado>0 && añoSeleccionado>0) {
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
    private javax.swing.JComboBox<String> diaCbx;
    private javax.swing.JComboBox<String> mesCbx;
    // End of variables declaration//GEN-END:variables
}
