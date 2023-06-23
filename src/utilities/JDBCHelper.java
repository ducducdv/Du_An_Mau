/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DBConnection;
/**
 *
 * @author Admin
 */
public class JDBCHelper {
    public static ResultSet executeQuerry(String sql, Object ...args){
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        connection = DBContext.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
    public static int executeUpdate(String sql, Object ...args){
        Connection connection = null;
        int affectedRows = 0;
        PreparedStatement preparedStatement = null;
        
        connection = DBContext.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return affectedRows;
    }
}
