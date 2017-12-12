
import Connection.conectar;
import Utiliti.Lib;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sammy
 */
public class Facturas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Facturas2
     */
    public Facturas() {
        initComponents();
        cargar("");
        nextID();
        this.updateUI();
        cargarCombobox();

    }

    private void cargar(String filtro) {

        String col_name = " val.id_veh_almacen as 'id almacen',val.veh_chasis as chasis,vma.descripcion as Marca,vmo.descripcion as Modelo,"
                + " vda.veh_year AS 'year',vco.descripcion as 'Color',ves.descripcion as Estado,"
                + " FORMAT(vpr.veh_precio_compra+((vpr.veh_precio_compra * vpr.veh_porciento_ganar) / 100),2) AS 'Precio Venta',"
                + " val.fecha AS 'Fecha Entrada',IF(val.veh_disponible = 1,'SI','NO') AS Disponible";
        String tbl_name = " veh_almacen val "
                + " LEFT JOIN veh_dato vda ON val.id_veh_dato = vda.id_veh_dato "
                + " LEFT JOIN veh_modelo vmo ON vmo.id_veh_modelo = vda.id_veh_modelo "
                + " LEFT JOIN veh_marca vma ON vma.id_veh_marca = vmo.id_veh_marca "
                + " LEFT JOIN veh_color vco ON vco.id_veh_color = vda.id_veh_color "
                + " LEFT JOIN veh_estado ves ON ves.id_veh_estado = val.id_veh_estado "
                + " LEFT JOIN veh_precio vpr ON vpr.id_veh_almacen = val.id_veh_almacen";
        String orden = " val.id_veh_almacen ";

        tbl_veh_dato = Lib.limpiarTabla(tbl_veh_dato);
        if (filtro.trim().equals("")) {

            tbl_veh_dato.setModel(Lib.tblCargarInventarioVehiculos((DefaultTableModel) tbl_veh_dato.getModel(), Lib.queryArray(col_name, tbl_name + " WHERE val.veh_disponible = '1' ", orden)));

        } else {
            tbl_veh_dato.setModel(Lib.tblCargarInventarioVehiculos((DefaultTableModel) tbl_veh_dato.getModel(), Lib.queryArrayW(col_name, tbl_name, " UPPER( " + mp_cb_filtro.get(cb_filtro.getSelectedItem()) + " ) LIKE UPPER('" + filtro + "%') AND val.veh_disponible = '1' ORDER BY " + orden)));
        }

    }

    public void nextID() {

        try {

            conectar conect = new conectar();
            Connection cn = conect.conexion();

            String sql = " Select MAX(id_factura)+1 as id FROM factura ";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                lblNoFactura.setText(rs.getString("id"));

            } else {

                JOptionPane.showMessageDialog(this, "El Usuario no esta Registrado");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    public void AgregarFactura() {
//
//        String id = lblNoFactura.getText();
//        System.out.print(id);
//        String cliente = txtNombreCliente.getText();
//        String marca = txt_marca.getText();
//        String modelo = txt_modelo.getText();
//        String color = comboColor.getSelectedItem().toString();
//        String anio = txt_year.getText();
//        String matricula = txt_chasis.getText();
//        String vendedor = txtVendedor.getText();
//        String fecha = txtFecha.getText();
//        fecha = convertirFecha(fecha);
//        String precioTotal = txt_precio.getText();
//
//        // hacemos una conexion a la base de datos y creamos un objeto de esa conexion para Insertar los datos en la base de datos.`  
//        try {
//            conectar conect = new conectar();
//            Connection conn = conect.conexion();
//            Statement st = conn.createStatement();
//            Statement st2 = conn.createStatement();
//
//            int mostrar = JOptionPane.showConfirmDialog(null, "Desea Guardar esta Factura?");
//
//            if (mostrar == JOptionPane.YES_NO_OPTION) {
//
//                st.executeUpdate("INSERT INTO factura (clientes, marca, modelo, anio, color, oficial_ventas, fecha, precioTotal) VALUES('" + cliente + "','" + marca + "','" + modelo + "','" + anio + "','" + color + "','" + vendedor + "','" + fecha + "','" + precioTotal + "')");
//                st2.executeUpdate("INSERT INTO detalle_factura (id_matricula, id_factura) VALUES('" + matricula + "','" + id + "')");
//                st.close();
//                JOptionPane.showMessageDialog(null, "Factura registrada con exito!");
//
//                System.out.print(st);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, e.toString());
//        }
//
//    }

    public void imprimir() {
        String cedula_cliente = txtNombreCliente.getText();
        String id_almacen = txt_id_almacen.getText();
        if (!cedula_cliente.trim().isEmpty() && !id_almacen.trim().isEmpty()) {

            int ok = JOptionPane.showConfirmDialog(this, "Se le procedera a cobrar el vehiculo con un moto de:  " + txt_precio.getText(), "Pagar factura", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (ok == JOptionPane.YES_OPTION) {
                List id_cliente = Lib.listSingleFila("id_cliente", "cliente", "cedula = " + cedula_cliente);

                int id_ins_factura = Lib.queryInsert(new String[]{"id_cliente", "id_veh_almacen"},
                        new String[]{id_cliente.get(0).toString(), id_almacen}, "factura_2");
                if (id_ins_factura > 0) {

                    int filas = Lib.queryUpdate(new String[]{" veh_disponible "}, new String[]{"0"}, "veh_almacen", " id_veh_almacen = " + id_almacen);

                    if (filas > 0) {

                        JDialog viewer = new JDialog(new JFrame(), "Factura", true);
                        conectar conect = new conectar();
                        Connection cn = conect.conexion();
                        String archivo = "C:\\Users\\user\\Documents\\NetBeansProjects\\BigDealer\\src\\Reportes\\imprimir.jasper";
                        //System.out.println("Archivo cargado desde: "+archivo);
                        try {
                            Map parameter = new HashMap();
                            parameter.put("filtro", id_ins_factura);
                            //JasperReport reporte = JasperCompileManager.compileReport(archivo);
                            //JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(archivo);
                            JasperPrint jasperprint = JasperFillManager.fillReport(archivo, parameter, cn);

                            viewer.setSize(1000, 700);
                            viewer.setLocationRelativeTo(null);
                            JRViewer jrv = new JRViewer(jasperprint);
                            viewer.getContentPane().add(jrv);
                            viewer.setVisible(true);
                            
                            dispose();
                            
                            
                        } catch (JRException e) {

                            JOptionPane.showMessageDialog(this,"Error al imprimir la factura.","Error al imprimir",JOptionPane.ERROR_MESSAGE);
                            System.err.println("Error: "+e.getMessage());
                            
                        }
                    } else {
                        Lib.queryDelete("factura_2", "id_factura",String.valueOf(id_ins_factura));
                        JOptionPane.showMessageDialog(this,"No se puedo a dar salida del inventario","ERROR DE DATOS",JOptionPane.ERROR_MESSAGE);
                        System.err.println("ERROR en el almacen");
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(this,"Error al facturar el vehiculo","ERROR",JOptionPane.ERROR_MESSAGE);
                    System.err.println("ERROR al facturar");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,"Selecione un vehiculo a facturar y un cliente","Dato incorrecto",JOptionPane.ERROR_MESSAGE);
            System.err.println("Dato incorrecto");
        }
    }

    public String convertirFecha(String fecha) {
        return fecha.substring(6, 10) + "/" + fecha.substring(3, 5) + "/" + fecha.substring(0, 2);
    }

    public static String fecha() {

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);

    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_year = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_chasis = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JFormattedTextField();
        txt_color = new javax.swing.JTextField();
        txt_id_almacen = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblNoFactura = new javax.swing.JLabel();
        btnMotrarTodo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_veh_dato = new javax.swing.JTable();
        cb_filtro = new javax.swing.JComboBox<>();
        txt_filtro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Cliente Cedula:");

        txtNombreCliente.setEditable(false);

        jLabel3.setText("Marca:");

        txt_marca.setEditable(false);

        jLabel4.setText("Modelo:");

        txt_modelo.setEditable(false);

        jLabel5.setText("Color:");

        jLabel6.setText("Año:");

        txt_year.setEditable(false);

        jLabel11.setText("Chasis:");

        txt_chasis.setEditable(false);

        btnBuscarCliente.setText("Buscar cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Precio:");

        txt_precio.setEditable(false);

        txt_color.setEditable(false);

        txt_id_almacen.setEditable(false);

        jLabel12.setText("ID Almacen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_chasis, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCliente)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(277, 277, 277)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_year, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_color, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id_almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarCliente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_chasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txt_id_almacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "No.Factura", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("No.");

        lblNoFactura.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNoFactura.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNoFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNoFactura)
                    .addComponent(jLabel7))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        btnMotrarTodo.setText("MostrarTodo");
        btnMotrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotrarTodoActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Acccion"));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnImprimir.setText("Facturar");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setBackground(new java.awt.Color(255, 51, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Facturas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbl_veh_dato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Almacen", "Chasis", "Marca", "Modelo", "Año", "Color", "Estado", "Precio Venta", "Fecha Entrada", "Disponible"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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

        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_filtroKeyPressed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMotrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMotrarTodo)
                    .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed

        datosClientes d = new datosClientes();
        Dimension desktopSize = MantenimientoADMIN.jDesktopPane.getSize();
        Dimension FrameSize = d.getSize();
        d.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        MantenimientoADMIN.jDesktopPane.add(d);
        d.toFront();
        d.show();

        dispose();

        /* datosClientes dc = new datosClientes();
        dc.setVisible(true);*/

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(this, "Salir?");

        if (mensaje == JOptionPane.YES_NO_OPTION) {

            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txt_filtroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyPressed
        int key = (char) evt.getKeyCode();
        if (KeyEvent.VK_ENTER == key) {
            cargar(txt_filtro.getText());
        }
    }//GEN-LAST:event_txt_filtroKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cargar(txt_filtro.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnMotrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotrarTodoActionPerformed
        cargar("");
    }//GEN-LAST:event_btnMotrarTodoActionPerformed

    private void tbl_veh_datoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_veh_datoMouseClicked

        selecionarDato();
    }//GEN-LAST:event_tbl_veh_datoMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMotrarTodo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cb_filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNoFactura;
    private javax.swing.JTable tbl_veh_dato;
    public static javax.swing.JTextField txtNombreCliente;
    public javax.swing.JTextField txt_chasis;
    public javax.swing.JTextField txt_color;
    private javax.swing.JTextField txt_filtro;
    public javax.swing.JTextField txt_id_almacen;
    public static javax.swing.JTextField txt_marca;
    public javax.swing.JTextField txt_modelo;
    public javax.swing.JFormattedTextField txt_precio;
    public javax.swing.JFormattedTextField txt_year;
    // End of variables declaration//GEN-END:variables
    private Map mp_cb_filtro;

    private void cargarCombobox() {
        mp_cb_filtro = new LinkedHashMap<>();
        mp_cb_filtro.put("ID", "val.id_veh_almacen");
        mp_cb_filtro.put("Chasis", "val.veh_chasis");
        mp_cb_filtro.put("Marca", "vma.descripcion");
        mp_cb_filtro.put("Modelo", "vmo.descripcion");
        mp_cb_filtro.put("Year", "vda.veh_year");
        mp_cb_filtro.put("Color", "vco.descripcion");
        mp_cb_filtro.put("Estado", "vco.descripcion");

        cb_filtro = Lib.cbCargar(cb_filtro, mp_cb_filtro);
    }

    private void selecionarDato() {

        int fila = tbl_veh_dato.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debes Seleccionar una Registro.");
        } else {
            txt_id_almacen.setText(tbl_veh_dato.getValueAt(fila, 0).toString());
            txt_chasis.setText(tbl_veh_dato.getValueAt(fila, 1).toString());
            txt_marca.setText(tbl_veh_dato.getValueAt(fila, 2).toString());
            txt_modelo.setText(tbl_veh_dato.getValueAt(fila, 3).toString());
            txt_year.setText(tbl_veh_dato.getValueAt(fila, 4).toString());
            txt_color.setText(tbl_veh_dato.getValueAt(fila, 5).toString());
            txt_precio.setText(tbl_veh_dato.getValueAt(fila, 7).toString());

            //txt_carroceria.setText(tbl_veh_dato.getValueAt(fila, 1).toString());
        }

    }
    
    
    private void limpiar(){
        txt_id_almacen.setText("");
        txt_chasis.setText("");
        txt_marca.setText("");
        txt_modelo.setText("");
        txt_year.setText("");
        txt_color.setText("");
        txt_precio.setText("");
        txtNombreCliente.setText("");
    }

}
