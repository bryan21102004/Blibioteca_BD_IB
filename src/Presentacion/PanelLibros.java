package Presentacion;

import Conexion_BD.Conexion;
import Entidad.Libros;
import Logic.CRUD;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PanelLibros extends javax.swing.JPanel {

    public Conexion conexion;
    public CRUD crud;
    public ArrayList<Libros> libros;
    public ArrayList<LibroJP> listaDePanelesLibro;
    public LibroJP libroSeleccionado;
    public int cantidadLibros;
    public boolean editable;

    public PanelLibros() {
        
        conexion = new Conexion();
        crud = new CRUD(conexion.conectar());
        libros = crud.consultarLibros();
        listaDePanelesLibro = new ArrayList();
        libroSeleccionado = null;
        initComponents();
        btVer.setVisible(false);
        btEliminar.setVisible(false);
        cargarLibros();

    }

    //Metodo que carga los libros en el inicio
    private void cargarLibros() {
        JLabel labelLibro = new JLabel();
        cantidadLibros = libros.size();
        for (int i = 0; i < libros.size(); i++) {
            LibroJP libroJP = new LibroJP(libros.get(i)); //lista de libros
            listaDePanelesLibro.add(libroJP);
            libroJP.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    tocarLibro(e);
                }
            });
            libroJP.setSize(100, 100);
            jPanel1.add(libroJP);
        }
    }

    //Este metodo bloquea las opciones de clickear más de un panel
    private void bloquearPanelesLibro(LibroJP libroJP, boolean editable) {
        for (int i = 0; i < listaDePanelesLibro.size(); i++) {
            if (listaDePanelesLibro.get(i) != libroJP) {
                listaDePanelesLibro.get(i).setEnabled(!editable);
            }
        }
    }

    private void refrescar() {
        jPanel1.removeAll();
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscarPorNombretxt = new javax.swing.JTextField();
        buscarPorIDTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btVer = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel1.setLayout(new java.awt.GridLayout(cantidadLibros, 4, 2, 2));
        jScrollPane1.setViewportView(jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Buscar por nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Buscar por ID");

        buscarPorIDTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarPorIDTxtKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Ver todos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btAgregar.setBackground(new java.awt.Color(51, 255, 51));
        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        btEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btModificar.setBackground(new java.awt.Color(102, 102, 255));
        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        btVer.setText("Ver");
        btVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buscarPorIDTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarPorNombretxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addContainerGap(16, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(btAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btVer, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscarPorNombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscarPorIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAgregar)
                            .addComponent(btVer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btModificar)
                        .addGap(27, 27, 27)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!buscarPorNombretxt.getText().equals("")) {
            Libros libro = crud.consultarLibroPorNombre(buscarPorNombretxt.getText());
            if (libro != null) {
                refrescar();
                LibroJP libroJP = new LibroJP(libro); //Panel de libros
                libroJP.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        tocarLibro(e);
                    }
                });
                libroJP.setSize(100, 100);
                jPanel1.add(libroJP);
                buscarPorNombretxt.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del libro");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tocarLibro(MouseEvent e) {
        LibroJP libroJP = (LibroJP) e.getComponent();
        if (libroSeleccionado == null) {
            libroSeleccionado = libroJP;
            libroJP.setBackground(Color.CYAN);
            editable = true;
            bloquearPanelesLibro(libroJP, editable);
            btVer.setVisible(true);
            verificarLibroEnPrestamo();
        } else if (libroSeleccionado == libroJP) {
            libroSeleccionado = null;
            libroJP.setBackground(Color.WHITE);
            editable = false;
            bloquearPanelesLibro(libroJP, editable);
            btVer.setVisible(false);
            btEliminar.setVisible(false);
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!buscarPorIDTxt.getText().equals("") && verificarParseo(buscarPorIDTxt.getText())) {
            Libros libro = crud.consultarLibroPorID(Integer.parseInt(buscarPorIDTxt.getText().trim()));
            if (libro != null) {
                refrescar();
                LibroJP libroJP = new LibroJP(libro); //Panel de libros
                libroJP.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        tocarLibro(e);
                    }
                });
                libroJP.setSize(100, 100);
                jPanel1.add(libroJP);
                buscarPorIDTxt.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el ID del libro");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        refrescar();
        cargarLibros();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        if (editable && libroSeleccionado != null) {//Si hay un libro seleccionado
            cargarModificarLibroJP();
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        if (editable && libroSeleccionado != null) {//Si hay un libros seleccionado
            crud.eliminarLibro(libroSeleccionado.libro.getIdLibro());
            refrescar();
            libroSeleccionado=null;
            libros = new ArrayList<>();
            libros = crud.consultarLibros();
            cargarLibros();
            jPanel1.revalidate();
            btEliminar.setVisible(false);
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        cargarAgregarLibroJP();
    }//GEN-LAST:event_btAgregarActionPerformed

    private void buscarPorIDTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarPorIDTxtKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_buscarPorIDTxtKeyTyped

    private void btVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerActionPerformed
        InformacionEntidad infoEnti = new InformacionEntidad();
        Libros libro = libroSeleccionado.libro;
        infoEnti.agregarEntidad(libro);
        infoEnti.setVisible(true);
    }//GEN-LAST:event_btVerActionPerformed
    private void cargarModificarLibroJP() {
        ModificarLibroJP panelModificar = new ModificarLibroJP(libroSeleccionado);
        panelModificar.setSize(800, 500);
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(panelModificar);
    }

    private void cargarAgregarLibroJP() {
        AgregarLibroJP agregarLibroJP = new AgregarLibroJP();
        agregarLibroJP.setSize(800, 500);
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(agregarLibroJP);
    }

    //Verifica si puedo parsear el numero o si es una letra
    private boolean verificarParseo(String texto) {
        boolean parseoValido = true;
        try {
            int id = Integer.parseInt(texto);
        } catch (Exception e) {
            parseoValido = false;
        }
        return parseoValido;
    }
    
    private void verificarLibroEnPrestamo(){
        int cantidadPrestamo=crud.verificarPrestamo(libroSeleccionado.libro.getIdLibro());
        if (cantidadPrestamo<=0) {
          btEliminar.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btVer;
    private javax.swing.JTextField buscarPorIDTxt;
    private javax.swing.JTextField buscarPorNombretxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
