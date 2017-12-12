
import Clases.Usuario;
import Connection.conectar;
import Utiliti.Valida;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sammy
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login2
     */
    public Login() {
        initComponents();
        punteros();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        p_cambio_pass.setVisible(false);
    }

    public void punteros() {
        btn_cambio_enter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }

    public void entrar() {
        String Usuario = txt_user.getText();
        String password = new String(txt_master_password.getPassword());

        if (!Usuario.trim().equals("") || !password.trim().equals("")) {
            Connection conn = new conectar().conexion();
            //Atrapamos el contenido de las cajas de texto y las guardamos en dos variables String

            try {
                // Hacemos una consulta a la base de datos para obetner el usuario y la password
                String sql = "SELECT * FROM usuario WHERE cedula = ?  AND contrasenia = MD5(?)";

                PreparedStatement prepare_st;
                prepare_st = conn.prepareStatement(sql);
                prepare_st.setString(1, Usuario);
                prepare_st.setString(2, password);
                
                //prepare_st.executeQuery();
                ResultSet rs = prepare_st.executeQuery();

                //Creamos una condicion si los campos estan vacios devuelve un alert diciendo Usuario Incorrecto / Invalido
                // Usamos un if para ir recorriendo los campos de la tabla
                if (rs.next()) {
                    if (rs.getString("cedula").equals(Usuario)) {
                        String user = rs.getString("cedula");
                        
                        
                        if (!checkCambio.isSelected()) {
                            //Aqui ya sabes que el usuario existe
                            //entonces lo guardas en una variable
                            Usuario u = new Usuario();
                            u.Usuario = Usuario;
                            String cap1 = rs.getString("tipo_usuario");

                            if (cap1.equals("Administrador")) {

                                JOptionPane.showMessageDialog(this, "Bienvenid@: " + Usuario);
                                MantenimientoADMIN pa = new MantenimientoADMIN();
                                pa.setVisible(true);
                                dispose();

                            } else if (cap1.equals("Usuario")) {

                                JOptionPane.showMessageDialog(this, "Bienvenid@: " + Usuario);
                                MantenimientoUsuario mu = new MantenimientoUsuario();
                                mu.setVisible(true);
                                dispose();

                            }
                        }else{
                            limpiar();
                            lbl_usuario.setText(user);
                            paneles(p_cambio_pass, p_iniciar_session);
                                                      
                        }   

                    } else {
                        JOptionPane.showMessageDialog(this, "El usuario no existe","Dato incorrecto",JOptionPane.INFORMATION_MESSAGE);
                    }

                }else{
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecto","Dato incorrecto",JOptionPane.INFORMATION_MESSAGE);
                }
                    
            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "Error de Conecxion con el servidor \nPor favor contactar con el encargado de mantenimiento");
                System.err.println("ERROR:"+e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Los datos suministrado no son validos!!","Dato invalido",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cambiarContraseña() {

        String usuario = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost/BigDealer";
        Connection conn = null;
        //Atrapamos el contenido de las cajas de texto y las guardamos en dos variables String
        String Usuario = txt_user.getText();
        String password = new String(txt_master_password.getPassword());

        try {
            // Hacemos una consulta a la base de datos para obetner el usuario y la password
            String sql = ("SELECT * FROM usuario WHERE nombre = '" + Usuario + "'  && contrasenia = '" + password + "'");

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, usuario, pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (Usuario.equals("") || password.equals("")) {

                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");

            } else {
                // Usamos un if para ir recorriendo los campos de la tabla
                if (rs.next()) {

                    String validarUsuario = rs.getString("nombre");
                    String validarPass = rs.getString("contrasenia");

                    if (!checkCambio.isSelected() && !txt_user.equals(validarUsuario) && !txt_master_password.equals(validarPass)) {

                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta!");

                    } else {
                        CambioContrasenia cc = new CambioContrasenia();
                        cc.lblUsuario2.setText(txt_user.getText());
                        cc.setVisible(true);
                        dispose();

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");

                    Login l = new Login();
                    l.setVisible(true);
                    dispose();
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_iniciar_session = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_master_password = new javax.swing.JPasswordField();
        checkCambio = new javax.swing.JCheckBox();
        btnSalir = new javax.swing.JButton();
        btn_master_enter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        p_cambio_pass = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cambio_pass_2 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        btn_cambio_enter = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_cambio_pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        p_iniciar_session.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        p_iniciar_session.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setText("Usuario:");

        txt_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_userKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 51));
        jLabel2.setText("Contraseña: ");

        txt_master_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_master_passwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_master_passwordKeyTyped(evt);
            }
        });

        checkCambio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        checkCambio.setForeground(new java.awt.Color(255, 255, 255));
        checkCambio.setText("Cambiar contraseña");
        checkCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCambioActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 102, 51));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/canc_norm.png"))); // NOI18N
        btnSalir.setToolTipText("");
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusPainted(false);
        btnSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/canc_press.png"))); // NOI18N
        btnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/canc_roll.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btn_master_enter.setBackground(new java.awt.Color(255, 102, 51));
        btn_master_enter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_master_enter.setForeground(new java.awt.Color(255, 102, 51));
        btn_master_enter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/acep_norm.png"))); // NOI18N
        btn_master_enter.setBorderPainted(false);
        btn_master_enter.setContentAreaFilled(false);
        btn_master_enter.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/acep_press.png"))); // NOI18N
        btn_master_enter.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/acep_roll.png"))); // NOI18N
        btn_master_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_master_enterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_iniciar_sessionLayout = new javax.swing.GroupLayout(p_iniciar_session);
        p_iniciar_session.setLayout(p_iniciar_sessionLayout);
        p_iniciar_sessionLayout.setHorizontalGroup(
            p_iniciar_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_iniciar_sessionLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(p_iniciar_sessionLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(txt_master_password, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(p_iniciar_sessionLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(checkCambio))
            .addGroup(p_iniciar_sessionLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(btn_master_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        p_iniciar_sessionLayout.setVerticalGroup(
            p_iniciar_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_iniciar_sessionLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(p_iniciar_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_iniciar_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_master_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(checkCambio)
                .addGap(4, 4, 4)
                .addGroup(p_iniciar_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_master_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iniciar Session");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        p_cambio_pass.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        p_cambio_pass.setEnabled(false);
        p_cambio_pass.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 51));
        jLabel5.setText("Contraseña:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 51));
        jLabel6.setText("Repita Contraseña: ");

        txt_cambio_pass_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cambio_pass_2KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("Usuario:");

        btn_cambio_enter.setBackground(new java.awt.Color(255, 102, 51));
        btn_cambio_enter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cambio_enter.setForeground(new java.awt.Color(255, 102, 51));
        btn_cambio_enter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/acep_norm.png"))); // NOI18N
        btn_cambio_enter.setBorderPainted(false);
        btn_cambio_enter.setContentAreaFilled(false);
        btn_cambio_enter.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/acep_press.png"))); // NOI18N
        btn_cambio_enter.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/acep_roll.png"))); // NOI18N
        btn_cambio_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambio_enterActionPerformed(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(255, 102, 51));
        btn_cancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/canc_norm.png"))); // NOI18N
        btn_cancelar.setToolTipText("");
        btn_cancelar.setBorderPainted(false);
        btn_cancelar.setContentAreaFilled(false);
        btn_cancelar.setFocusPainted(false);
        btn_cancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/canc_press.png"))); // NOI18N
        btn_cancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/canc_roll.png"))); // NOI18N
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        txt_cambio_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cambio_passKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout p_cambio_passLayout = new javax.swing.GroupLayout(p_cambio_pass);
        p_cambio_pass.setLayout(p_cambio_passLayout);
        p_cambio_passLayout.setHorizontalGroup(
            p_cambio_passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_cambio_passLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel7)
                .addGap(31, 31, 31)
                .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(p_cambio_passLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(btn_cambio_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(p_cambio_passLayout.createSequentialGroup()
                .addGroup(p_cambio_passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_cambio_passLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5))
                    .addGroup(p_cambio_passLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_cambio_passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_cambio_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(txt_cambio_pass_2)))
        );
        p_cambio_passLayout.setVerticalGroup(
            p_cambio_passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_cambio_passLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(p_cambio_passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(p_cambio_passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_cambio_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(p_cambio_passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_cambio_pass_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(p_cambio_passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cambio_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoLogin.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p_cambio_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_iniciar_session, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(78, 78, 78))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(p_iniciar_session, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_cambio_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cambio_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambio_enterActionPerformed
        cambioPass();
    }//GEN-LAST:event_btn_cambio_enterActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpiar();
        paneles(p_iniciar_session, p_cambio_pass);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void checkCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCambioActionPerformed
        //cambiarContraseña();


    }//GEN-LAST:event_checkCambioActionPerformed

    private void btn_master_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_master_enterActionPerformed
       entrar();
    }//GEN-LAST:event_btn_master_enterActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txt_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userKeyTyped
        int key = (char)evt.getKeyChar();
        if (!Valida.validaNum(key) || txt_user.getText().length() >= 11) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);

        }
    }//GEN-LAST:event_txt_userKeyTyped

    private void txt_master_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_master_passwordKeyTyped
        int key = (char)evt.getKeyChar();
        if (!Valida.validaNum(key) && !Valida.validaStr(key) || new String(txt_master_password.getPassword()).length() > 50) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_txt_master_passwordKeyTyped

    private void txt_cambio_passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cambio_passKeyTyped
        int key = (char)evt.getKeyChar();
        if (!Valida.validaNum(key) && !Valida.validaStr(key) || new String(txt_cambio_pass.getPassword()).length() > 50) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cambio_passKeyTyped

    private void txt_cambio_pass_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cambio_pass_2KeyTyped
        int key = (char)evt.getKeyChar();
        if (!Valida.validaNum(key) && !Valida.validaStr(key) || new String(txt_cambio_pass_2.getPassword()).length() > 50) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cambio_pass_2KeyTyped

    private void txt_master_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_master_passwordKeyReleased
                int key = (char)evt.getKeyCode();
        if(KeyEvent.VK_ENTER == key){
            entrar();
        }
    }//GEN-LAST:event_txt_master_passwordKeyReleased

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btn_cambio_enter;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_master_enter;
    private javax.swing.JCheckBox checkCambio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPanel p_cambio_pass;
    private javax.swing.JPanel p_iniciar_session;
    private javax.swing.JPasswordField txt_cambio_pass;
    private javax.swing.JPasswordField txt_cambio_pass_2;
    private javax.swing.JPasswordField txt_master_password;
    public static javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
    
    private void limpiar(){
        txt_user.setText("");
        txt_cambio_pass.setText("");
        txt_cambio_pass_2.setText("");
        txt_master_password.setText("");
        lbl_usuario.setText("");
    }
    
    private void paneles(javax.swing.JPanel habilitar, javax.swing.JPanel deshabilitar) {
//    p_iniciar_session.setVisible(false);
//    p_cambio_pass.setVisible(true);
        Point p_deshabi = deshabilitar.getLocation();
        Point p_habi = habilitar.getLocation();
        habilitar.setLocation(p_deshabi);
        deshabilitar.setLocation(p_habi);
        deshabilitar.setVisible(false);
        habilitar.setVisible(true);

    }
    
    private void cambioPass(){
        String pass1 = new String(txt_cambio_pass.getPassword());
        String pass2 = new String(txt_cambio_pass_2.getPassword());
        if(!pass1.trim().equals("") && !pass1.trim().isEmpty() &&
           !pass2.trim().equals("") && !pass2.trim().isEmpty() ){
            
            if(pass1.compareTo(pass2) == 0){
                
                try {
                    String user = lbl_usuario.getText();
                    
                    Connection conn = new conectar().conexion();
                    String sql = "UPDATE usuario SET contrasenia = MD5(?) WHERE cedula = ?";
                    
                    PreparedStatement prepare_st = conn.prepareStatement(sql);
                    prepare_st.setString(1, pass1);
                    prepare_st.setString(2, user);
                    int filas = prepare_st.executeUpdate();
                    if(filas > 0 ){
                        limpiar();
                        checkCambio.setSelected(false);
                        paneles(p_iniciar_session, p_cambio_pass);
                    }else{
                       JOptionPane.showMessageDialog(this, "No se pudo cambiar la contraseña","Error al cambiar",JOptionPane.ERROR_MESSAGE);                        ;
                       
                    }    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error de Conecxion con el servidor \nPor favor contactar con el encargado de mantenimiento");
                    System.err.println("ERROR:"+ex.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(this, "Las contraseña no coinciden","Error al cambiar la contraseña",JOptionPane.ERROR_MESSAGE); 
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Los Datos suministrados no son invalidos","Datos invalidos",JOptionPane.INFORMATION_MESSAGE); 
        }
    }
    
}
