/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiliti;

import Connection.conectar;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gfernandez
 */
public class Lib {
    
    /**
     *
     * @param model
     * @param qry
     * @return DefaultTableModel
     */
    public static JTable limpiarTabla(JTable tbl){

            if(tbl.getRowCount() > 0){
                DefaultTableModel model = (DefaultTableModel)tbl.getModel();

                int fila = model.getRowCount();

                for(int i=0;i < fila;i++ ){

                    model.removeRow(0);
                }

                tbl.setModel(model);

            }

            return tbl;
    }
    public static DefaultTableModel tblCargar(DefaultTableModel model,String qry){
         
         
         try {
             
            conectar co = new conectar();
            Connection conn = co.conexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qry);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int cant_colum = rsmd.getColumnCount();
            /*
            for(int i = 1;i < cant_colum;i++){
                model.addColumn(rsmd.getColumnLabel(i));
            }
            */    
            while(rs.next()){
                String[] fila = new String[cant_colum];
                for(int i = 0;i < cant_colum; i++){
                    fila[i] = rs.getString(i+1);
                }
                
                model.addRow(fila);
            }
            rs.close();
            st.close();
            conn.close();
            
         }catch(SQLException esql){
            System.err.print(esql);
         }
         
         return model;
     }    
    public static DefaultTableModel tblCargar(DefaultTableModel model,ResultSet rs){

        try {
            if(rs.next()){
                try {
                    
                    rs.beforeFirst();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int cant_colum = rsmd.getColumnCount();
                    /*
                    for(int i = 1;i < cant_colum;i++){
                    model.addColumn(rsmd.getColumnLabel(i));
                    }
                    */
                    while(rs.next()){
                        String[] fila = new String[cant_colum];
                        for(int i = 0;i < cant_colum; i++){
                            fila[i] = rs.getString(i+1);
                            //System.out.println("dato rs: " + rs.getString(i+1));
                            //System.out.println("dato fi: " + fila[i]);
                        }
                        model.addRow(fila);
                    }
                    rs.close();
                    
                }catch(SQLException esql){
                    System.err.print("Error SQL: "+esql.getMessage());
                }
            }
            
        } catch (SQLException ex) {
            System.err.print("Error SQL: "+ex.getMessage());;
        }
        return model;
     }    
    public static DefaultTableModel tblCargarDatosVehiculos(DefaultTableModel model,ResultSet rs){

        try {
            if(rs.next()){
                try {
                    
                    rs.beforeFirst();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int cant_colum = rsmd.getColumnCount();
                    /*
                    for(int i = 1;i < cant_colum;i++){
                    model.addColumn(rsmd.getColumnLabel(i));
                    }
                    */
                    while(rs.next()){
                        String[] fila = new String[cant_colum];
                        for(int i = 0;i < cant_colum; i++){
                            
                            if(i == 7){
                                fila[i] = rs.getString(i+1).substring(0, 4);
                            }else{
                                fila[i] = rs.getString(i+1);
                            }
                        }
                        model.addRow(fila);
                    }
                    rs.close();
                    
                }catch(SQLException esql){
                    System.err.print("Error SQL: "+esql.getMessage());
                }
            }
            
        } catch (SQLException ex) {
            System.err.print("Error SQL: "+ex.getMessage());;
        }
        return model;
     }    
    public static DefaultTableModel tblCargarAlmacenVehiculos(DefaultTableModel model,ResultSet rs){

        try {
            if(rs.next()){
                try {
                    
                    rs.beforeFirst();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int cant_colum = rsmd.getColumnCount();
                    /*
                    for(int i = 1;i < cant_colum;i++){
                    model.addColumn(rsmd.getColumnLabel(i));
                    }
                    */
                    while(rs.next()){
                        String[] fila = new String[cant_colum];
                        for(int i = 0;i < cant_colum; i++){
                            
                            if(i == 4){
                                fila[i] = rs.getString(i+1).substring(0, 4);
                            }else{
                                fila[i] = rs.getString(i+1);
                            }
                        }
                        model.addRow(fila);
                    }
                    rs.close();
                    
                }catch(SQLException esql){
                    System.err.print("Error SQL: "+esql.getMessage());
                }
            }
            
        } catch (SQLException ex) {
            System.err.print("Error SQL: "+ex.getMessage());;
        }
        return model;
     }    
    public static DefaultTableModel tblCargarInventarioVehiculos(DefaultTableModel model,ResultSet rs){

        try {
            if(rs.next()){
                try {
                    
                    rs.beforeFirst();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int cant_colum = rsmd.getColumnCount();
                    /*
                    for(int i = 1;i < cant_colum;i++){
                    model.addColumn(rsmd.getColumnLabel(i));
                    }
                    */
                    while(rs.next()){
                        String[] fila = new String[cant_colum];
                        for(int i = 0;i < cant_colum; i++){
                            
                            if(i == 4){
                                fila[i] = rs.getString(i+1).substring(0, 4);
                            }else{
                                fila[i] = rs.getString(i+1);
                            }
                        }
                        model.addRow(fila);
                    }
                    rs.close();
                    
                }catch(SQLException esql){
                    System.err.print("Error SQL: "+esql.getMessage());
                }
            }
            
        } catch (SQLException ex) {
            System.err.print("Error SQL: "+ex.getMessage());;
        }
        return model;
     }    
    public static ResultSet queryArray(String select,String from){
     ResultSet rs = null;
        try {

            conectar co = new conectar();
            Connection conn = co.conexion();
            Statement st = conn.createStatement();
            rs = st.executeQuery("SELECT "+ select +" FROM "+ from );
            //System.out.println("SELECT "+ select +" FROM "+ from);

        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }     
    public static ResultSet queryArray(String select,String from,String orden){
     ResultSet rs = null;
        try {

            conectar co = new conectar();
            Connection conn = co.conexion();
            Statement st = conn.createStatement();
            rs = st.executeQuery("SELECT "+ select +" FROM "+ from + " ORDER BY "+orden);
            System.out.println("SELECT "+ select +" FROM "+ from);


        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }     
    public static ResultSet queryArrayW(String select,String from,String where){
     ResultSet rs = null;
        try {

            
            Connection conn = new conectar().conexion();
            Statement st = conn.createStatement();
            String qry = "SELECT "+ select +" FROM "+ from + " WHERE "+where;
            rs = st.executeQuery(qry);
            //System.out.println(qry);
            
            
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getMessage());
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }  
    public static ResultSet queryArray(String select,String from,String where,String orden){
     ResultSet rs = null;
        try {

            
            Connection conn = new conectar().conexion();
            Statement st = conn.createStatement();
            String qry = "SELECT "+ select +" FROM "+ from + " WHERE "+where+ " ORDER BY "+orden;
            rs = st.executeQuery(qry);
            //System.out.println(qry);
            
            
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getMessage());
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }  
    public static ResultSet queryArray(String sql){
     ResultSet rs = null;
        try {

            conectar co = new conectar();
            Connection conn = co.conexion();
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            conn.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static int queryInsert(String[] col_name,String[] col_value,String tbl_name){
        int clave_generada = 0;
        try {
        
            Connection conn = new conectar().conexion();
            PreparedStatement psInsert;

            String sql = "INSERT INTO "+tbl_name+" ( ";
            String str_col_value ="";
            for(int i=0;i < col_name.length;i++){
                sql +=col_name[i]+",";
                str_col_value += "?,";
            }

            sql = sql.substring(0,sql.length()-1)+" ) values ( ";
            str_col_value = str_col_value.substring(0, str_col_value.length()-1);
            sql += str_col_value +" ) ";
            psInsert = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            for(int j=0;j < col_value.length;j++){
               psInsert.setString(j+1, col_value[j]); 
            }

            int fila = psInsert.executeUpdate();

            if (fila > 0){
                ResultSet rs = psInsert.getGeneratedKeys();

                if(rs.next()){

                    clave_generada = rs.getInt(1);

                }
                rs.close();
            }else{
                System.err.println("ERROR: No se insertaron ningun registro.");
            }

            psInsert.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }

    return clave_generada;
    }   
    public static boolean validaString(String[] str_valid){

        for (String str_valid1 : str_valid) {
            if (str_valid1.trim().isEmpty() || str_valid1.equals("...")) {
                return false;
            }
        }
        return true;
    }
    public static boolean validaString(String str_valid){
        if(str_valid.trim().isEmpty() || str_valid.equals("...")){
            return false;
        }
        return true;
    }
    public static String strCedula(String cedula){

        cedula = cedula.replaceAll("-","");
        return cedula;
     }
    public static JComboBox cbCargar(JComboBox model,Map map){
        model.removeAllItems();
        ArrayList al = new ArrayList(map.keySet());
        Collections.sort(al);
        for(Object o : al){
            model.addItem(o);
        }
        /*
        map.keySet().forEach((value) -> {
            model.addItem(value);
        });*/
       
        return model;
    }
    public static JComboBox cbCargar(JComboBox model,ResultSet rs){
        try {
            model.removeAllItems();
            
            while(rs.next()){
                model.addItem(rs.getString(1));
                
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    } 
    public static Map mapCargar(String tbl_name){
        
        Map<String,String> map = new HashMap<>();
        try {

            ResultSet rs = queryArray("*",tbl_name);

            while(rs.next()){            
                
                map.put(rs.getString(2),rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    public static Map mapCargar(String tbl_name,String orden){
        
        Map<String,String> map = new HashMap<>();
        try {

            ResultSet rs = queryArray("*",tbl_name + " ORDER BY " + orden );

            while(rs.next()){            
                
                map.put(rs.getString(2),rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    public static Map mapCargar(String select,String tbl_name,String orden){
        
        Map<String,String> map = new HashMap<>();
        try {

            ResultSet rs = queryArray(select,tbl_name + " ORDER BY " + orden );

            while(rs.next()){            
                
                map.put(rs.getString(2),rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    public static List listSingleFila(String select,String tbl_name,String where){
        
        List<String> lst = new LinkedList<>();
        try {

            ResultSet rs = queryArrayW(select,tbl_name,where);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int cant_colum = rsmd.getColumnCount();            
            while(rs.next()){            
                for(int i=0;i < cant_colum;i++ ){
                    lst.add(rs.getString(i+1));
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    public static int queryUpdate(String[] col_name,String[] col_value,String tbl_name,String where){
        int filas = 0;
        try {
        
            Connection conn = new conectar().conexion();
            PreparedStatement psInsert;

            String sql = "UPDATE "+tbl_name+" SET ";
            
            for(int i=0;i < col_name.length;i++){
                sql +=col_name[i]+ " =?,";
               
            }

            sql = sql.substring(0,sql.length()-1)+" WHERE "+ where;
            psInsert = conn.prepareStatement(sql);
            for(int j=0;j < col_value.length;j++){
               psInsert.setString(j+1, col_value[j]); 
            }

            filas = psInsert.executeUpdate();

            if (filas == 0){
                
                System.err.println("ERROR: No se actualiaron ningun registro.");
            }            

            psInsert.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }

        return filas;
    }
    public static int existeRegistro(String select,String from,String where){
        ResultSet rs = null;
        int exist = 0; //cero si no existe y uno si existe
        try {

            
            Connection conn = new conectar().conexion();
            Statement st = conn.createStatement();
            String qry = "SELECT "+ select +" FROM "+ from + " WHERE "+where;
            //System.out.println(qry);
            rs = st.executeQuery(qry);
            if(rs.next()){
                exist = 1;
            }
            
            st.close();
            rs.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getMessage());
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }
    public static int queryDelete(String from,String where,String value){
        int ok = 0;
        
        try {
            if(validaString(new String[] {from,where,value})){
                conectar co = new conectar();
                Connection conn = co.conexion();
                Statement st = conn.createStatement();
                
                ok = st.executeUpdate("DELETE  FROM "+ from +" WHERE "+   where + " = '" +value+ " '" );
                //System.out.println("SELECT "+ select +" FROM "+ from);
                st.close();
                conn.close();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ok;
        
    }
}
