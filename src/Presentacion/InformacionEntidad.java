/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.awt.Font;
import java.lang.reflect.Field;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class InformacionEntidad extends javax.swing.JFrame {

    private int cantidadTexto;
    private Object entidad;
    private String[] atributosEntidad;
    
    public InformacionEntidad() {
        entidad=null;
        cantidadTexto=10;
        initComponents();
        setLocationRelativeTo(this);
    }
    
    public void agregarEntidad(Object entidad){
        this.entidad=entidad;
        cantidadTexto=contarAtributos(entidad);
        agregarTextos();
    }
   
    public int contarAtributos(Object entidad){
        atributosEntidad=entidad.toString().split(",");
        return atributosEntidad.length;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(cantidadTexto, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEntidad().setVisible(true);
            }
        });
    }
    
    public void agregarTextos(){
        for (int i = 0; i < cantidadTexto; i++) {
            JLabel label = new JLabel(atributosEntidad[i]);
            label.setSize(100,100);
            label.setOpaque(false);
            label.setFont(new java.awt.Font("Segoe UI", 1, 14));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            jPanel1.add(label);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
