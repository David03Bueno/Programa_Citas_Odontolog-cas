/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login;

import Login.login;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Choice;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author paula
 */
public class mantenimientocitas extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    /**
     * Creates new form mantenimientocitas
     */
    // AQUI INSTANCIAMOS LAS CLASES A UTILIZAR
    ConexionMysql con = new ConexionMysql();
    Connection cn = con.conectar();

    //CREAMOS UNAS VARIABLES GLOBALES
    private String data;
    private String data2;
    private String data3;

    public mantenimientocitas() {
        initComponents();
        //CREAMOS Y INICIALIZAMOS LA TABLA DE CONTENIDO
        String[] titulo = new String[]{"Id cita:", "Id usuario:", "Doctor:", "Fecha:", "Horario:", "Motivo:"};
        dtm.setColumnIdentifiers(titulo);
        tblDatos.setModel(dtm);

        choices();
        iniciacializarMenu();
        btnAgendar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnModificar.setEnabled(false);
    }

    public void iniciacializarMenu() {
        //EN ESTA FUNCION INSTANCIAMOS LA CLASE JMENUITEM
        //PARA DE ESO MODO ULTIZAR SU EVENTO PARA ELIMINAR 
        //REGISTRO CON EL CLICK DERECHO DE EL MOUSE
        JMenuItem delete = new JMenuItem("Eliminar");
        jPopupMenu1.add(delete);

        tblDatos.setComponentPopupMenu(jPopupMenu1);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(rootPane, "Se eliminara el registro, desea continuar?", "Eliminar Registro",
                        JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        String Borrar = "DELETE FROM Citas WHERE IdCitas='" + txtIDCita.getText() + "'";
                        PreparedStatement ps;
                        ps = (PreparedStatement) cn.prepareStatement(Borrar);
                        int respuesta = ps.executeUpdate();
                        if (respuesta > 0) {
                            JOptionPane.showMessageDialog(null, "Registro eliminado con exito!");
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "No ha seleccionado la fila a ser borrada.");
                            limpiarCampos();
                        }
                    } catch (SQLException exception) {
                        System.err.println("Error al eliminar...." + exception);
                        JOptionPane.showMessageDialog(null, "Error al eliminar!");
                    }

                } else {
                    mostrarDatos(txtIDusuario.getText());
                    limpiarCampos();
                    btnModificar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnAgendar.setEnabled(true);
                }
            }
        });
    }

    private void Fecha() {
        // Formato de fecha esperado para la entrada del usuario
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        //Lo siguiente recibe la accion del boton enter
        txtfecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto ingresado en el campo de texto
                String fechaTexto = txtfecha.getText();
                try {
                    // Intentar convertir el texto a una fecha
                    Date fecha = formatoFecha.parse(fechaTexto);
                    // Si la conversión es exitosa, mostrar un mensaje con la fecha en el formato correcto
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame, "Fecha ingresada: " + formatoFecha.format(fecha));
                } catch (ParseException ex) {
                    Component frame = null;
                    // Mostrar un mensaje de error si el formato no es válido
                    JOptionPane.showMessageDialog(frame, "Formato de fecha incorrecto. Utiliza el formato dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ch = new java.awt.Choice();
        jTextField1 = new javax.swing.JTextField();
        txtIDCita = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        choice2 = new java.awt.Choice();
        btnAgendar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtIDusuario = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("AGENDAR CITA");

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("ID cita:");

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("ID Usuario");

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Motivo de consulta:");

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Elija el área en que se consultará:");

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Doctor asignado:");

        ch.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ch.setForeground(new java.awt.Color(102, 102, 102));
        ch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chMouseClicked(evt);
            }
        });
        ch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chItemStateChanged(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        txtIDCita.setEditable(false);
        txtIDCita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDCita.setForeground(new java.awt.Color(102, 102, 102));

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Horarios disponibles:");

        jLabel11.setBackground(new java.awt.Color(102, 102, 102));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Buscar Por ID Usuario :");

        choice2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        choice2.setForeground(new java.awt.Color(102, 102, 102));

        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgendar.setForeground(new java.awt.Color(0, 51, 102));
        btnAgendar.setText("AGENDAR");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 51, 102));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 51, 102));
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Citas Pendientes:");

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 102));
        jButton4.setText("Volver al menú principal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtIDusuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDusuario.setForeground(new java.awt.Color(102, 102, 102));
        txtIDusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtIDusuarioMouseEntered(evt);
            }
        });
        txtIDusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDusuarioKeyPressed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 51, 102));

        jLabel14.setBackground(new java.awt.Color(102, 102, 102));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Fecha:");

        txtfecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtfecha.setForeground(new java.awt.Color(102, 102, 102));
        txtfecha.setText("dd/MM/yyyy");
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });

        txtMotivo.setColumns(20);
        txtMotivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMotivo.setForeground(new java.awt.Color(102, 102, 102));
        txtMotivo.setLineWrap(true);
        txtMotivo.setRows(5);
        txtMotivo.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtMotivo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ch, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIDCita, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(choice2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(135, 135, 135)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtIDCita, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtIDusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(choice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        insertar();
        
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //Se crea una instancia para llamar la otra pestaña
        menu MenuFrame = new menu();
        MenuFrame.setVisible(true);
        MenuFrame.pack();
        MenuFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed

        Fecha();
    }//GEN-LAST:event_txtfechaActionPerformed

    private void chItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chItemStateChanged

        accionar();


    }//GEN-LAST:event_chItemStateChanged

    private void chMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chMouseClicked

    private void txtIDusuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDusuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDusuarioMouseEntered

    private void txtIDusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDusuarioKeyPressed

    }//GEN-LAST:event_txtIDusuarioKeyPressed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        //CON DAR ENTER MUESTRA LOS DATOS A BUSCAR

        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            dtm.setRowCount(0);
            if ("".equals(txtBuscar.getText())) {
                JOptionPane.showMessageDialog(null, "Favor digite un ID", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                mostrarDatos(txtBuscar.getText());
                limpiarCampos();
            }
        }

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        //CON ESTE CODIGO HACEMOS CLICK IZQUIERDO SOBRE LA TABLA 
        //PARA PODER ELIMINAR ALGUNA FILA
        btnAgendar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnModificar.setEnabled(true);
        int fila = this.tblDatos.getSelectedRow();
        txtIDCita.setText(this.tblDatos.getValueAt(fila, 0).toString());
        txtIDusuario.setText(this.tblDatos.getValueAt(fila, 1).toString());
        jTextField1.setText(this.tblDatos.getValueAt(fila, 2).toString());
        txtfecha.setText(this.tblDatos.getValueAt(fila, 3).toString());
        txtMotivo.setText(this.tblDatos.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_tblDatosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
        dtm.setRowCount(0);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnAgendar.setEnabled(true);
        txtBuscar.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarDatos();
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(mantenimientocitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mantenimientocitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mantenimientocitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mantenimientocitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mantenimientocitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private java.awt.Choice ch;
    private java.awt.Choice choice2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIDCita;
    private javax.swing.JTextField txtIDusuario;
    private javax.swing.JTextArea txtMotivo;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables

    private void choices() {
        //Choice ch = new Choice();
        //Se insertan datos en los choice
        ch.addItem("Elige una opción");
        ch.addItem("Odontología General");
        ch.addItem("Ortodoncia");
        ch.addItem("Endodoncia");
        ch.addItem("Odontopediatría");
        ch.addItem("Implantología Dental");
        ch.addItem("Cirugía Oral y Maxilofacial");

        choice2.addItem("Elige una opción");
        choice2.addItem("09:30 am");
        choice2.addItem("10:45 am");
        choice2.addItem("12:00 pm");
        choice2.addItem("02:00 pm");
        choice2.addItem("03:15 pm");
        choice2.addItem("04:30 pm");

    }

    private void accionar() {
        //EN ESTA FUNCION BUSCAMOS LOS DATOS EN LA TABLA Doctor

        int i = ch.getSelectedIndex(); // AQUI OBTENEMOS EL INDICE DEL CHOICE DE ESPECIALIDADES

        String consultaSQL = "SELECT Doctor.Nombre, Doctor.Apellido, Doctor.IdDoctor FROM Doctor inner join Especialidad ON Especialidad.IdEspecialidad = Doctor.IdEspecialidad WHERE Especialidad.IdEspecialidad =" + i;

//        String data;
//        String data2;
        Statement st;

        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);
            while (rs.next()) {
                data = rs.getString(1);
                data2 = rs.getString(2);
                data3 = rs.getString(3);
                jTextField1.setText(data + " " + data2);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la consulta SQL: " + ex);

            Logger.getLogger(mantenimientocitas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void insertar() {
        //EN ESTA FUNCION INSERTAMOS LOS DATOS A LA TABLA INSERTAR

        //AQUI BUSCAMOS EL ID USUARIOS DE LA TABLA USUARIO
        String ID = txtIDusuario.getText();
        String consulaNombre = "SELECT IdUsuario FROM Usuarios WHERE IdUsuario =" + ID;

        String IDusuario = null;
        Statement st;

        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consulaNombre);
            while (rs.next()) {
                IDusuario = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la consulta SQL: " + ex);
            Logger.getLogger(mantenimientocitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        int i = choice2.getSelectedIndex(); // AQUI OBTENEMOS EL INDICE DEL CHOICE DE ESPECIALIDADES
        //AQUI BUSCAMOS EL ID HORARIO DE LA TABLA HARARIOS
        String consultaHorario = "SELECT IdHoraios FROM Horarios WHERE IdHoraios=" + i;

        String IDHorarios = null;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consultaHorario);
            while (rs.next()) {
                IDHorarios = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la consulta SQL: " + ex);
            Logger.getLogger(mantenimientocitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        //LUEGO DE BUSCAR LOS ELEMENTOS, LO INCERTAMOS EN LA TABLA CITAS
        String insertarSQL = "INSERT INTO Citas(IdUsuario, IdHoraios, IdDoctor, MotivoCita, Fecha) VALUES (?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) cn.prepareStatement(insertarSQL);
            ps.setString(1, IDusuario);
            ps.setString(2, IDHorarios);
            ps.setString(3, data3);
            ps.setString(4, txtMotivo.getText());
            ps.setString(5, txtfecha.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Registro realizado con exito.");
            btnAgendar.setEnabled(true);
            btnCancelar.setEnabled(false);
            btnModificar.setEnabled(true);
            mostrarDatos(txtIDusuario.getText());
            //enviarCorreo(txtIDusuario.getText());
            limpiarCampos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al tratar de insertar los datos: " + ex);
        }
    }

    private void mostrarDatos(String valorBuscar) {
        //AQUI BUSCAMOS TODOS LOS DATOS PARA MOSTRAR DE LA TABLA CITAS ATRAVES DE EL VALOR A BUSCAR.
        //UTILIZAMOS UN INNER JOIN PARA UNIR LA TABLA CITAS, DOCTOR,HORARIOS Y USUARIOS
        String consultSQL = "SELECT Citas.IdCitas, Citas.IdUsuario, Doctor.Nombre, Citas.Fecha, Horarios.Horas, Citas.MotivoCita FROM Citas "
                + "inner join Usuarios ON Usuarios.IdUsuario = Citas.IdUsuario "
                + "INNER JOIN Doctor ON Doctor.IdDoctor = Citas.IdDoctor "
                + "INNER JOIN Horarios ON Horarios.IdHoraios = Citas.IdHoraios WHERE Usuarios.IdUsuario=" + valorBuscar;

        String data5[] = new String[6];
        Statement st;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consultSQL);
            while (rs.next()) {
                data5[0] = rs.getString(1);
                data5[1] = rs.getString(2);
                data5[2] = rs.getString(3);
                data5[3] = rs.getString(4);
                data5[4] = rs.getString(5);
                data5[5] = rs.getString(6);
                dtm.addRow(data5);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la consulta SQL: " + ex);
        }
    }

    private void limpiarCampos() {
        txtIDCita.setText("");
        txtIDusuario.setText("");
        jTextField1.setText("");
        txtMotivo.setText("");
        txtfecha.setText("");
        txtBuscar.setText("");
    }

    private void modificarDatos() {
        int i = choice2.getSelectedIndex(); // AQUI OBTENEMOS EL INDICE DEL CHOICE DE ESPECIALIDADES
        //AQUI BUSCAMOS EL ID HORARIO DE LA TABLA HARARIOS
        String consultaHorario = "SELECT IdHoraios FROM Horarios WHERE IdHoraios=" + i;
        Statement st;
        String IDHorarios = null;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consultaHorario);
            while (rs.next()) {
                IDHorarios = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la consulta SQL: " + ex);
            Logger.getLogger(mantenimientocitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        String actualizarSQL = "UPDATE Citas SET MotivoCita='" + txtMotivo.getText()
                + "', Fecha='" + txtfecha.getText()
                + "', IdHoraios='" + IDHorarios
                + "' WHERE IdCitas=" + txtIDCita.getText();
        try {
            PreparedStatement ps;
            ps = (PreparedStatement) cn.prepareStatement(actualizarSQL);
            int indice = ps.executeUpdate();
            if (indice > 0) {
                JOptionPane.showMessageDialog(rootPane, "Datos actualizados correctamente.");
                btnModificar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnAgendar.setEnabled(true);
                dtm.setRowCount(0);
                mostrarDatos(txtIDusuario.getText());
                limpiarCampos();
                txtBuscar.setText("");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al actualizar datos: " + ex);
        }

    }

    private void enviarCorreo(String buscar) {
        String consultarSQL = "SELECT Correo FROM Usuarios WHERE IdUsuario="+buscar;
        String correo = null;
        Statement st;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consultarSQL);
            while (rs.next()) {
                correo = rs.getString(1);
            }
            //System.out.println(correo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la consulta SQL: " + ex);
            Logger.getLogger(mantenimientocitas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
