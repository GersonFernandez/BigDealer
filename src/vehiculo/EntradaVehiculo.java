package vehiculo;


import Utiliti.Lib;
import Utiliti.Valida;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sammy
 */
public class EntradaVehiculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vehiculos
     */
    public EntradaVehiculo() {
        initComponents();
        //comboMarca();
        //comboModelo();
        comboBoxCargar();
        cargar("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_buscar = new javax.swing.JButton();
        btn_mostrar_todo = new javax.swing.JButton();
        cb_filtro = new javax.swing.JComboBox<>();
        txt_buscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_marca = new javax.swing.JLabel();
        lbl_modelo = new javax.swing.JLabel();
        lbl_combustible = new javax.swing.JLabel();
        lbl_transmision = new javax.swing.JLabel();
        lbl_year = new javax.swing.JLabel();
        lbl_color = new javax.swing.JLabel();
        lbl_carroceria = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_limpiar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblFecha1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_veh_dato = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txt_chasis = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_proveedor = new javax.swing.JComboBox<>();
        txt_kilometraje = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_precio_compra = new javax.swing.JTextField();
        txt_porciento_venta = new javax.swing.JTextField();
        txt_precio_venta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cb_estado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_veh_almacen = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1107, 788));

        jScrollPane3.setPreferredSize(new java.awt.Dimension(1107, 788));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar dato vehiculo"));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_mostrar_todo.setText("Mostrar todo");
        btn_mostrar_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrar_todoActionPerformed(evt);
            }
        });

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_mostrar_todo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_buscar)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar)
                    .addComponent(btn_mostrar_todo)
                    .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del vehiculo"));

        jLabel13.setText("ID:");

        lbl_id.setText("...");
        lbl_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setText("Marca:");

        jLabel15.setText("Modelo:");

        jLabel16.setText("Transmision:");

        jLabel17.setText("Color:");

        jLabel18.setText("Combustible:");

        jLabel19.setText("Carroceria:");

        jLabel20.setText("Year:");

        lbl_marca.setText("...");
        lbl_marca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_modelo.setText("...");
        lbl_modelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_combustible.setText("...");
        lbl_combustible.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_transmision.setText("...");
        lbl_transmision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_year.setText("...");
        lbl_year.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_color.setText("...");
        lbl_color.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_carroceria.setText("...");
        lbl_carroceria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_color, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_carroceria, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel20)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_transmision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_combustible, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_year, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(369, 369, 369))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(lbl_carroceria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lbl_color, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_transmision, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(lbl_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(lbl_combustible, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_year, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addGap(40, 40, 40)
                .addComponent(jLabel4))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Accion"));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear-icon.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/update-icon.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trash-icon.png"))); // NOI18N
        btn_eliminar.setText("Eiminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Log-Out-icon.png"))); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save-icon.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_guardar)
                .addGap(47, 47, 47)
                .addComponent(btn_limpiar)
                .addGap(47, 47, 47)
                .addComponent(btn_actualizar)
                .addGap(52, 52, 52)
                .addComponent(btn_eliminar)
                .addGap(67, 67, 67)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btn_guardar)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_salir))
                .addContainerGap(1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 102, 51));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel21.setText("ENTRADA VEHICULOS ALMACEN");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Fecha:");

        lblFecha1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblFecha1.setText("00/00/0000");
        lblFecha1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblFecha1))
                .addGap(20, 20, 20))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_veh_dato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marca", "Modelo", "Color", "Carroceria", "Transmision", "Combustible", "Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_veh_dato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_veh_datoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_veh_dato);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_chasis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chasisActionPerformed(evt);
            }
        });

        jLabel1.setText("Chasis: ");

        jLabel2.setText("Estado:");

        jLabel3.setText("Kilometraje:");

        jLabel5.setText("Precio Compra:");

        jLabel6.setText("Porciento Venta:");

        jLabel7.setText("Precio Venta:");

        txt_precio_compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_precio_compraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precio_compraKeyTyped(evt);
            }
        });

        txt_porciento_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_porciento_ventaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_porciento_ventaKeyTyped(evt);
            }
        });

        txt_precio_venta.setEditable(false);

        jLabel8.setText("Proveedor:");

        jLabel9.setText("%");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_chasis, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_porciento_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_chasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_porciento_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_veh_almacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Chasis", "Marca", "Modelo", "Color", "Precio Compra", "Porciento Venta", "Year", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_veh_almacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_veh_almacenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_veh_almacen);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 349, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        cargar(txt_buscar.getText());
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_mostrar_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrar_todoActionPerformed
        cargar("");
        limpiar();

    }//GEN-LAST:event_btn_mostrar_todoActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void tbl_veh_datoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_veh_datoMouseClicked
        selecionarDato();
    }//GEN-LAST:event_tbl_veh_datoMouseClicked

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed

        actualizarVehiculo();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        eliminarVehiculo();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        //int mensaje = JOptionPane.showConfirmDialog(this, "Salir?");

        //if(mensaje == JOptionPane.YES_NO_OPTION) {
            dispose();
            //}
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        agregarVehiculo();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_chasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chasisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chasisActionPerformed

    private void tbl_veh_almacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_veh_almacenMouseClicked
        selecionarVehiculo();
    }//GEN-LAST:event_tbl_veh_almacenMouseClicked

    private void txt_porciento_ventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_porciento_ventaKeyTyped
        int key = (char)evt.getKeyChar();
        if (!Valida.validaNum(key)) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);

        }
    }//GEN-LAST:event_txt_porciento_ventaKeyTyped

    private void txt_precio_compraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precio_compraKeyTyped
        int key = (char)evt.getKeyChar();
        if (!Valida.validaNum(key)) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);

        }
    }//GEN-LAST:event_txt_precio_compraKeyTyped

    private void txt_precio_compraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precio_compraKeyReleased
        if(!txt_porciento_venta.getText().isEmpty() && !txt_porciento_venta.getText().isEmpty()){
                Double precio = Double.valueOf(txt_precio_compra.getText())+((Double.valueOf(txt_precio_compra.getText())*Double.valueOf(txt_porciento_venta.getText())) / 100);
                txt_precio_venta.setText(precio.toString());
        }else{
            txt_precio_venta.setText("");
        }
    }//GEN-LAST:event_txt_precio_compraKeyReleased

    private void txt_porciento_ventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_porciento_ventaKeyReleased
        if(!txt_porciento_venta.getText().isEmpty() && !txt_porciento_venta.getText().isEmpty()){
                Double precio = Double.valueOf(txt_precio_compra.getText())+((Double.valueOf(txt_precio_compra.getText())*Double.valueOf(txt_porciento_venta.getText())) / 100);
                txt_precio_venta.setText(precio.toString());
        }else{
            txt_precio_venta.setText("");
        }
    }//GEN-LAST:event_txt_porciento_ventaKeyReleased

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        int key = (char)evt.getKeyCode();
        if(KeyEvent.VK_ENTER == key){
            cargar(txt_buscar.getText());
        }                // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_mostrar_todo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> cb_estado;
    private javax.swing.JComboBox<String> cb_filtro;
    private javax.swing.JComboBox<String> cb_proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFecha1;
    private javax.swing.JLabel lbl_carroceria;
    private javax.swing.JLabel lbl_color;
    private javax.swing.JLabel lbl_combustible;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_marca;
    private javax.swing.JLabel lbl_modelo;
    private javax.swing.JLabel lbl_transmision;
    private javax.swing.JLabel lbl_year;
    private javax.swing.JTable tbl_veh_almacen;
    private javax.swing.JTable tbl_veh_dato;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_chasis;
    private javax.swing.JTextField txt_kilometraje;
    private javax.swing.JTextField txt_porciento_venta;
    private javax.swing.JTextField txt_precio_compra;
    private javax.swing.JTextField txt_precio_venta;
    // End of variables declaration//GEN-END:variables

    private Map mp_cb_filtro;
    private Map mp_cb_estado;
    private Map mp_cb_proveedor;
    private List  lista_id_veh_agregados = new ArrayList();
    private String id_almacen = "";

    private void cargar(String filtro){

        String col_name = " da.id_veh_dato as ID ,ma.descripcion as Marca,mo.descripcion as Modelo, " +
                          " co.descripcion as Color,ca.descripcion as Carroceria, " +
                          " tr.descripcion as Transmision,com.descripcion as Combustible,da.veh_year as 'Year'";
        String tbl_name = " veh_dato da " +
                          " LEFT JOIN veh_modelo mo ON da.id_veh_modelo = mo.id_veh_modelo " +
                          " LEFT JOIN veh_marca ma ON ma.id_veh_marca = mo.id_veh_marca  " +
                          " LEFT JOIN veh_color co ON co.id_veh_color = da.id_veh_color " +
                          " LEFT JOIN veh_tipo_carroceria ca ON ca.id_veh_tipo_carroceria = da.id_veh_tipo_carroceria " +
                          " LEFT JOIN veh_transmision tr ON tr.id_veh_transmision = da.id_veh_transmision " +
                          " LEFT JOIN veh_combustible com ON com.id_veh_combustible = da.id_veh_combustible ";
        String orden =    " da.id_veh_dato ";

        tbl_veh_dato = Lib.limpiarTabla(tbl_veh_dato);
        if(filtro.trim().equals("")){

            tbl_veh_dato.setModel(Lib.tblCargarDatosVehiculos((DefaultTableModel)tbl_veh_dato.getModel(),Lib.queryArray(col_name, tbl_name,orden)));

        }else {

            tbl_veh_dato.setModel(Lib.tblCargarDatosVehiculos((DefaultTableModel)tbl_veh_dato.getModel(),Lib.queryArrayW(col_name, tbl_name," UPPER( "+mp_cb_filtro.get(cb_filtro.getSelectedItem())+ " ) LIKE UPPER('"+ filtro + "%') ORDER BY "+orden)));

        }

    }
    private void limpiar(){

        lbl_id.setText("...");
        lbl_carroceria.setText("...");
        lbl_color.setText("...");
        lbl_combustible.setText("...");
        lbl_marca.setText("...");
        lbl_modelo.setText("...");
        lbl_transmision.setText("...");
        lbl_year.setText("...");
        cb_filtro.setSelectedIndex(0);
        txt_buscar.setText("");
        txt_chasis.setText("");
        txt_kilometraje.setText("");
        txt_porciento_venta.setText("");
        txt_precio_compra.setText("");
        txt_precio_venta.setText("");
        id_almacen ="";

    }
    private void selecionarDato(){

        int fila =  tbl_veh_dato.getSelectedRow();

        if(fila ==-1) {
            JOptionPane.showMessageDialog(this,"Debes Seleccionar una Registro.");
        } else{

            lbl_id.setText(tbl_veh_dato.getValueAt(fila, 0).toString());
            lbl_marca.setText(tbl_veh_dato.getValueAt(fila, 1).toString());
            lbl_modelo.setText(tbl_veh_dato.getValueAt(fila, 2).toString());
            lbl_color.setText(tbl_veh_dato.getValueAt(fila, 3).toString());
            lbl_carroceria.setText(tbl_veh_dato.getValueAt(fila, 4).toString());
            lbl_transmision.setText(tbl_veh_dato.getValueAt(fila, 5).toString());
            lbl_combustible.setText(tbl_veh_dato.getValueAt(fila, 6).toString());
            lbl_year.setText(tbl_veh_dato.getValueAt(fila, 7).toString());

            //txt_carroceria.setText(tbl_veh_dato.getValueAt(fila, 1).toString());

      }

    }
    private void comboBoxCargar() {

//        //cargar marca
//        mp_cb_marca = Lib.mapCargar("veh_marca","descripcion");
//        cb_marca = Lib.cbCargar(cb_marca, mp_cb_marca);
//        //cargar modelo
//        mp_cb_modelo = Lib.mapCargar(" id_veh_modelo,descripcion "," veh_modelo "," descripcion ");
//
//        //cargar color
//        mp_cb_color = Lib.mapCargar("veh_color","descripcion");
//        cb_color = Lib.cbCargar(cb_color, mp_cb_color);
//        //cargar carroceria
//        mp_cb_carroceria = Lib.mapCargar("veh_tipo_carroceria","descripcion");
//        cb_carroceria = Lib.cbCargar(cb_carroceria, mp_cb_carroceria);
//        //cargar transmision
//        mp_cb_transmision = Lib.mapCargar("veh_transmision","descripcion");
//        cb_transmision = Lib.cbCargar(cb_transmision, mp_cb_transmision);
//        //cargar combustible
//        mp_cb_combustible = Lib.mapCargar("veh_combustible","descripcion");
//        cb_combustible = Lib.cbCargar(cb_combustible, mp_cb_combustible);
//        //cargar filtro

        mp_cb_filtro = new HashMap<>();
        mp_cb_filtro.put("ID", "da.id_veh_dato");
        mp_cb_filtro.put("Marca", "ma.descripcion");
        mp_cb_filtro.put("Modelo", "mo.descripcion");
        mp_cb_filtro.put("Color", "co.descripcion");
        mp_cb_filtro.put("Carroceria", "ca.descripcion");
        mp_cb_filtro.put("Transmision", "tr.descripcion");
        mp_cb_filtro.put("Combustible", "com.descripcion");
        mp_cb_filtro.put("Year", "da.veh_year");
        cb_filtro = Lib.cbCargar(cb_filtro, mp_cb_filtro);

        //cargar estado
        mp_cb_estado = Lib.mapCargar("veh_estado","descripcion");
        cb_estado = Lib.cbCargar(cb_estado, mp_cb_estado);
        mp_cb_proveedor = Lib.mapCargar(" id_proveedor , nombre "," proveedor "," id_proveedor ");
        cb_proveedor = Lib.cbCargar(cb_proveedor, mp_cb_proveedor);


    }
    private void agregarVehiculo(){
        //String mod_name = txt_modelo.getText();
        //String id_marca = mp_cb_marca.get(cb_marca.getSelectedItem()).toString();
        if( Lib.validaString(lbl_id.getText())){
            if( Lib.validaString(new String[] {txt_chasis.getText(),txt_kilometraje.getText(),txt_porciento_venta.getText(),txt_precio_compra.getText()})){

                if(Lib.existeRegistro("*", " veh_dato ", " id_veh_dato =  "+lbl_id.getText()) == 1){

                    String id_dato = lbl_id.getText();
                    String matricula = txt_chasis.getText();
                    String kilometraje = txt_kilometraje.getText();
                    String precio_compra = txt_precio_compra.getText();
                    String porciento_venta = txt_porciento_venta.getText();
                    String id_estado = mp_cb_estado.get(cb_estado.getSelectedItem()).toString();
                    String id_proveedor = mp_cb_proveedor.get(cb_proveedor.getSelectedItem()).toString();


                    if(Lib.existeRegistro("*"," veh_almacen "," UPPER(veh_chasis) = UPPER( '"+matricula+"' ) ") == 0){
                        int id_ins_vehiculo = Lib.queryInsert(  new String[]{"id_veh_dato" , "id_veh_estado","veh_chasis","veh_kilometraje","veh_disponible","id_proveedor"}
                                                           , new String[]{id_dato,id_estado,matricula,kilometraje,"1",id_proveedor},"veh_almacen");

                        if (id_ins_vehiculo == 0){
                            JOptionPane.showMessageDialog(this,"No se Inserto ningun registro","Error no se guardaron datos",JOptionPane.ERROR_MESSAGE);
                            System.err.println("No se insertaron registro");

                        }else{
                            lista_id_veh_agregados.add(id_ins_vehiculo);
                            int id_ins_veh_precio = Lib.queryInsert(  new String[]{"id_veh_almacen" , "veh_precio_compra","veh_porciento_ganar"}
                                                           , new String[]{String.valueOf(id_ins_vehiculo),precio_compra,porciento_venta},"veh_precio");
                            if(id_ins_veh_precio == 0){
                                Lib.queryDelete("veh_almacen","id_veh_almacen",String.valueOf(id_ins_vehiculo));
                                JOptionPane.showMessageDialog(this,"No se Inserto el precio","Error no se guardaron datos",JOptionPane.ERROR_MESSAGE);
                                System.err.println("No se insertaron registro");
                            }else{
                                cargarVehiculo();
                                limpiar();
                            }

                        }
                    }else{
                        JOptionPane.showMessageDialog(this,"El Vehiculo ya se encuentra registrado","Dato duplicado",JOptionPane.ERROR_MESSAGE);
                        System.err.println("El vehiculo ya existe");
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"Los datos del vehiculo no existe!!! ","Dato no existe",JOptionPane.ERROR_MESSAGE);
                    System.err.println("Datos invalidos");
                }

            }else{

                JOptionPane.showMessageDialog(this,"Los datos suministrado no son valido o no a selecionado ningun valor","Dato duplicado",JOptionPane.ERROR_MESSAGE);
                System.err.println("Datos invalidos");
            }
        }

        }
    private void actualizarVehiculo(){

        if (Lib.validaString(lbl_id.getText()) && !lbl_id.getText().equals("...") && Lib.validaString(id_almacen)) {

            if (Lib.validaString(new String[]{txt_chasis.getText(), txt_kilometraje.getText(), txt_porciento_venta.getText(), txt_precio_compra.getText()})) {
                //id_almacen = tbl_veh_almacen.getValueAt(tbl_veh_almacen.getSelectedRow(), 0).toString();

                if (Lib.existeRegistro("*", " veh_almacen ", " UPPER(veh_chasis) = UPPER('" + txt_chasis.getText() + "') AND id_veh_almacen = '" + id_almacen + "' ") == 1
                        || Lib.existeRegistro("*", " veh_almacen ", " UPPER(veh_chasis) = UPPER('" + txt_chasis.getText() + "')") == 0) {

                    int ok = JOptionPane.showConfirmDialog(this, "Se actualizara el registro con el id: " + id_almacen, "Actualizar registro", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (ok == JOptionPane.YES_OPTION) {
                        String id_dato = lbl_id.getText();
                        String matricula = txt_chasis.getText();
                        String kilometraje = txt_kilometraje.getText();
                        String precio_compra = txt_precio_compra.getText();
                        String porciento_venta = txt_porciento_venta.getText();
                        String id_estado = mp_cb_estado.get(cb_estado.getSelectedItem()).toString();
                        String id_proveedor = mp_cb_proveedor.get(cb_proveedor.getSelectedItem()).toString();

                        int id_ins_almacen = Lib.queryUpdate(new String[]{"id_veh_dato", "id_veh_estado", "veh_chasis", "veh_kilometraje", "veh_disponible", "id_proveedor"},
                                 new String[]{id_dato, id_estado, matricula, kilometraje, "1", id_proveedor}, "veh_almacen",
                                 "id_veh_almacen = '" + id_almacen + "'");
                        if (id_ins_almacen != 0) {
                            int id_ins_veh_precio = Lib.queryUpdate(new String[]{"id_veh_almacen", "veh_precio_compra", "veh_porciento_ganar"},
                                     new String[]{id_almacen, precio_compra, porciento_venta}, "veh_precio",
                                     "id_veh_almacen = '" + id_almacen + "'");
                            if (id_ins_veh_precio != 0) {

                                cargarVehiculo();
                                limpiar();

                            } else {
                                JOptionPane.showMessageDialog(this, "No se Inserto el precio", "Error no se guardaron datos", JOptionPane.ERROR_MESSAGE);
                                System.err.println("No se insertaron registro");
                            }

                        } else {

                            JOptionPane.showMessageDialog(this, "No se actualizo ningun registro", "Error no se guardaron datos", JOptionPane.ERROR_MESSAGE);
                            System.err.println("No se actualizo registro");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El vehiculo ya se encuentra registrado", "Dato duplicado", JOptionPane.ERROR_MESSAGE);
                    System.err.println("El Nombre del vehiculo existe");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Los datos suministrado no son valido o no a selecionado ningun valor", "Dato duplicado", JOptionPane.ERROR_MESSAGE);
                System.err.println("Datos invalidos");
            }
        }else{
            JOptionPane.showMessageDialog(this,"No a selecionado ningun registro","Dato invalido",JOptionPane.ERROR_MESSAGE);
            System.err.println("No a selecionado ningun registro");
        }

    }

    private void eliminarVehiculo(){

            if(Lib.validaString(lbl_id.getText()) && !lbl_id.getText().equals("...") &&  Lib.validaString(id_almacen)){
                //id_almacen = tbl_veh_almacen.getValueAt(tbl_veh_almacen.getSelectedRow(), 0).toString();
                int ok = JOptionPane.showConfirmDialog(this, "Se eliminara el registro con el id: "+id_almacen,"Eliminar registro",JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
                if(ok == JOptionPane.YES_OPTION){
                    int id_del_veh_precio = Lib.queryDelete("veh_precio","id_veh_almacen",id_almacen);
                    if (id_del_veh_precio != 0){

                        int id_del_veh_almacen = Lib.queryDelete("veh_almacen","id_veh_almacen",id_almacen);
                        if(id_del_veh_almacen != 0){

                            cargarVehiculo();
                            limpiar();

                        }else{
                            JOptionPane.showMessageDialog(this,"No se elimino ningun registro del vehiculo","Error",JOptionPane.ERROR_MESSAGE);
                            System.err.println("No se elimino ningun registro");
                        }

                    }else{
                        JOptionPane.showMessageDialog(this,"No se elimino ningun registro","Error",JOptionPane.ERROR_MESSAGE);
                        System.err.println("No se elimino ningun registro");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this,"Selecione un registro  a borrar","Error",JOptionPane.ERROR_MESSAGE);
                System.err.println("No se a selecionado ningun registro");
            }


    }
    private void cargarVehiculo(){
        if(!lista_id_veh_agregados.isEmpty()){

            String col_name = " val.id_veh_almacen AS 'ID',val.veh_chasis AS 'Chasis',vma.descripcion AS 'Marca',"
                            + " vmo.descripcion AS 'Modelo',vco.descripcion AS 'Color',"
                            + " vpr.veh_precio_compra AS 'Precio Compra',vpr.veh_porciento_ganar AS 'Porciento Venta',"
                            + " vda.veh_year AS 'Year',pro.nombre AS 'Proveedor' ";
            String tbl_name = " veh_almacen val "
                            + " LEFT JOIN veh_dato vda   ON val.id_veh_dato = vda.id_veh_dato"
                            + " LEFT JOIN veh_precio vpr ON val.id_veh_almacen =  vpr.id_veh_almacen "
                            + " LEFT JOIN veh_modelo vmo ON vmo.id_veh_modelo = vda.id_veh_modelo"
                            + " LEFT JOIN veh_marca  vma ON vma.id_veh_marca = vmo.id_veh_marca"
                            + " LEFT JOIN veh_color vco  ON vco.id_veh_color = vda.id_veh_color"
                            + " LEFT JOIN proveedor pro	 ON pro.id_proveedor = val.id_proveedor ";
            String orden =    " val.id_veh_almacen ";

            tbl_veh_almacen = Lib.limpiarTabla(tbl_veh_almacen);
            if(!lista_id_veh_agregados.isEmpty()){
                String id;
                for(Object obj:lista_id_veh_agregados ){
                    id = obj.toString();
                    tbl_veh_almacen.setModel(Lib.tblCargarDatosVehiculos((DefaultTableModel)tbl_veh_almacen.getModel(),
                                                                      Lib.queryArrayW(col_name, tbl_name," val.id_veh_almacen = '" + id +"' ORDER BY "+orden)));
                }

            }
        }
    }
    private void selecionarVehiculo(){

        int fila = tbl_veh_almacen.getSelectedRow();
        List<String> lst;
        if(fila == -1){
            JOptionPane.showMessageDialog(this,"Debes Seleccionar una Registro.");
        }else {

            id_almacen = tbl_veh_almacen.getValueAt(fila, 0).toString();
            System.out.println("id_almacen = "+id_almacen);
            String select =   " va.veh_chasis as chasis,va.veh_kilometraje as kilometraje, "
                            + " ves.descripcion as estado,vp.veh_precio_compra as 'precio compra',"
                            + " vp.veh_porciento_ganar as porciento,pr.nombre as 'proveedor',"
                            + " va.id_veh_dato as id_dato ,ma.descripcion as Marca,mo.descripcion as Modelo,"
                            + " co.descripcion as Color,ca.descripcion as Carroceria,"
                            + " tr.descripcion as Transmision,com.descripcion as Combustible,veh_year as 'year' ";

            String from =     " veh_almacen va "
                            + " LEFT JOIN veh_precio vp ON va.id_veh_almacen = vp.id_veh_almacen "
                            + " LEFT JOIN veh_dato da   ON va.id_veh_dato = da.id_veh_dato "
                            + " LEFT JOIN veh_modelo mo ON da.id_veh_modelo = mo.id_veh_modelo "
                            + " LEFT JOIN veh_marca ma  ON mo.id_veh_marca = ma.id_veh_marca "
                            + " LEFT JOIN veh_color co  ON co.id_veh_color = da.id_veh_color "
                            + " LEFT JOIN veh_tipo_carroceria ca ON ca.id_veh_tipo_carroceria = da.id_veh_tipo_carroceria "
                            + " LEFT JOIN veh_transmision tr ON tr.id_veh_transmision = da.id_veh_transmision "
                            + " LEFT JOIN veh_combustible com ON com.id_veh_combustible = da.id_veh_combustible "
                            + " LEFT JOIN veh_estado ves      ON ves.id_veh_estado = va.id_veh_estado "
                            + " LEFT JOIN proveedor pr		  ON pr.id_proveedor = va.id_proveedor ";

            String where = " va.id_veh_almacen =  '"+id_almacen+ "'";


            lst = Lib.listSingleFila(select,from,where);
            if(!lst.isEmpty()){

                txt_chasis.setText(lst.get(0));
                txt_kilometraje.setText(lst.get(1));
                cb_estado.setSelectedItem(lst.get(2));
                txt_precio_compra.setText(lst.get(3));
                txt_porciento_venta.setText(lst.get(4));
                cb_proveedor.setSelectedItem(lst.get(5));
                lbl_id.setText(lst.get(6));
                lbl_marca.setText(lst.get(7));
                lbl_modelo.setText(lst.get(8));
                lbl_color.setText(lst.get(9));
                lbl_carroceria.setText(lst.get(10));
                lbl_transmision.setText(lst.get(11));
                lbl_combustible.setText(lst.get(12));
                lbl_year.setText(lst.get(13).substring(0, 4));


            }
        }

    }
}
