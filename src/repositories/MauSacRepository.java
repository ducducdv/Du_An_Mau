/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
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
public class MauSacRepository implements IMauSacRepository {

    private DBConnection db = new DBConnection();

    @Override
    public List<MauSac> findAll() {
        String sql = "SELECT ma,ten FROM MauSac";
        List<MauSac> listModel = new ArrayList<>();
        try ( Connection con = db.getConnection();  PreparedStatement mauSac = con.prepareStatement(sql)) {
            ResultSet resultSet = mauSac.executeQuery();
            while (resultSet.next()) {
                MauSac x = new MauSac();
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
    public Boolean insert(MauSac x) {
        String sql = "insert into MauSac(ma,ten) values(?,?)";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement mauSac = con.prepareStatement(sql)) {
            mauSac.setObject(1, x.getMa());
            mauSac.setObject(2, x.getTen());
            check = mauSac.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(MauSac x) {
        String sql = "UPDATE MauSac SET ten=? WHERE ma = ?";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement khachHang = con.prepareStatement(sql)) {

            khachHang.setObject(1, x.getTen());
            khachHang.setObject(2, x.getMa());
            check = khachHang.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(String ma) {
        String sql = "DELETE MauSac WHERE ma = ?";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement mauSac = con.prepareStatement(sql)) {
            mauSac.setObject(1, ma);
            check = mauSac.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
