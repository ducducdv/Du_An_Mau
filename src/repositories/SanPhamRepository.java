/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import domainModels.KhachHang;
import domainModels.MauSac;
import domainModels.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class SanPhamRepository implements ISanPhamRepository {

    private DBConnection db = new DBConnection();

    @Override
    public List<SanPham> findAll() {
        String sql = "SELECT ma,ten FROM SanPham";
        List<SanPham> listModel = new ArrayList<>();
        try ( Connection con = db.getConnection();  PreparedStatement mauSac = con.prepareStatement(sql)) {
            ResultSet resultSet = mauSac.executeQuery();
            while (resultSet.next()) {
                SanPham x = new SanPham();
                x.setMa(resultSet.getString(1));
                x.setTen(resultSet.getString(2));
                listModel.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listModel;
    }

    @Override
    public Boolean insert(SanPham x) {
        String sql = "insert into SanPham(ma,ten) values(?,?)";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement sqlSP = con.prepareStatement(sql)) {
            sqlSP.setObject(1, x.getMa());
            sqlSP.setObject(2, x.getTen());
            check = sqlSP.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(SanPham x) {
        String sql = "UPDATE SanPham SET ten=? WHERE ma = ?";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement sqlSP = con.prepareStatement(sql)) {

            sqlSP.setObject(1, x.getTen());
            sqlSP.setObject(2, x.getMa());
            check = sqlSP.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(String ma) {
        String sql = "DELETE SanPham WHERE ma = ?";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement sqlSP = con.prepareStatement(sql)) {
            sqlSP.setObject(1, ma);
            check = sqlSP.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
