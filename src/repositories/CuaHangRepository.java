/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import domainModels.CuaHang;
import domainModels.KhachHang;
import domainModels.MauSac;
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
public class CuaHangRepository implements ICuaHangRepository {

    private DBConnection db = new DBConnection();

    @Override
    public List<CuaHang> findAll() {
        String sql = "SELECT ma,ten,diaChi,thanhPho,quocGia FROM CuaHang";
        List<CuaHang> listModel = new ArrayList<>();
        try ( Connection con = db.getConnection();  PreparedStatement mauSac = con.prepareStatement(sql)) {
            ResultSet resultSet = mauSac.executeQuery();
            while (resultSet.next()) {
                CuaHang x = new CuaHang();
                x.setMa(resultSet.getString(1));
                x.setTen(resultSet.getString(2));
                x.setDiaChi(resultSet.getString(3));
                x.setThanhPho(resultSet.getString(4));
                x.setQuocGia(resultSet.getString(5));
                listModel.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listModel;
    }

    @Override
    public Boolean insert(CuaHang x) {
        String sql = "insert into CuaHang(ma,ten,diaChi,thanhPho,quocGia) values(?,?,?,?,?)";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement y = con.prepareStatement(sql)) {
            y.setObject(1, x.getMa());
            y.setObject(2, x.getTen());
            y.setObject(3, x.getDiaChi());
            y.setObject(4, x.getThanhPho());
            y.setObject(5, x.getQuocGia());

            check = y.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(CuaHang x) {
        String sql = "UPDATE CuaHang SET ten=?,diaChi=?,thanhPho=?,quocGia=? WHERE ma = ?";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement sqlModel = con.prepareStatement(sql)) {

            sqlModel.setObject(1, x.getTen());
            sqlModel.setObject(2, x.getDiaChi());
            sqlModel.setObject(3, x.getThanhPho());
            sqlModel.setObject(4, x.getQuocGia());
            sqlModel.setObject(5, x.getMa());
            check = sqlModel.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(String ma) {
        String sql = "DELETE CuaHang WHERE ma = ?";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement sqlModel = con.prepareStatement(sql)) {
            sqlModel.setObject(1, ma);
            check = sqlModel.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
