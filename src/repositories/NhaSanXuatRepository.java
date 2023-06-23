/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import domainModels.KhachHang;
import domainModels.MauSac;
import domainModels.NhaSanXuat;
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
public class NhaSanXuatRepository implements INhaSanXuatRepository {

    private DBConnection db = new DBConnection();

    @Override
    public List<NhaSanXuat> findAll() {
        String sql = "SELECT ma,ten FROM NSX";
        List<NhaSanXuat> listModel = new ArrayList<>();
        try ( Connection con = db.getConnection();  PreparedStatement mauSac = con.prepareStatement(sql)) {
            ResultSet resultSet = mauSac.executeQuery();
            while (resultSet.next()) {
                NhaSanXuat x = new NhaSanXuat();
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
    public Boolean insert(NhaSanXuat x) {
        String sql = "insert into NSX(ma,ten) values(?,?)";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement sqlNsx = con.prepareStatement(sql)) {
            sqlNsx.setObject(1, x.getMa());
            sqlNsx.setObject(2, x.getTen());
            check = sqlNsx.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(NhaSanXuat x) {
        String sql = "UPDATE NSX SET ten=? WHERE ma = ?";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement sqlNsx = con.prepareStatement(sql)) {

            sqlNsx.setObject(1, x.getTen());
            sqlNsx.setObject(2, x.getMa());
            check = sqlNsx.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(String ma) {
        String sql = "DELETE NSX WHERE ma = ?";
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
