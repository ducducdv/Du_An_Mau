/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;
import utilities.JDBCHelper;

/**
 *
 * @author Dell
 */
public class ChucVuRepository implements IChucVuRepository {

    final String INSERT_SQL = "INSERT INTO [dbo].[ChucVu] ([Ma],[Ten])VALUES(?,?)";
    final String UPDATE_SQL = "UPDATE [dbo].[ChucVu] SET [Ten] = ? WHERE [Ma] = ?";
    final String DELETE_SQL = "DELETE FROM [dbo].[ChucVu] WHERE [Ma] = ?";
//    final String SELECT_BY_SQL = "SELECT * FROM [dbo].[Category] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM [dbo].[ChucVu]";
    private List<ChucVu> listChucVus;
    
    public ChucVuRepository() {
        listChucVus = new ArrayList<>();
    }

    @Override
    public List<ChucVu> findAll() {
        return getSelectSQL(SELECT_ALL_SQL);

    }

    @Override
    public Boolean insert(ChucVu cv) {
        int row = JDBCHelper.executeUpdate(INSERT_SQL, cv.getMa(), cv.getTen());
        return row > 0;
    }

    @Override
    public Boolean update(ChucVu cv) {
        int row = JDBCHelper.executeUpdate(UPDATE_SQL, cv.getTen(), cv.getMa());
        return row > 0;
    }

    @Override
    public Boolean delete(String ma) {
        int row = JDBCHelper.executeUpdate(DELETE_SQL, ma);
        return row > 0;
    }

    private List<ChucVu> getSelectSQL(String sql, Object... args) {
        try {
            ResultSet resultSet = JDBCHelper.executeQuerry(sql, args);
            while (resultSet.next()) {
                listChucVus.add(new ChucVu(
                        resultSet.getString("Ma"),
                        resultSet.getString("Ten")));
            }
            return listChucVus;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
}
