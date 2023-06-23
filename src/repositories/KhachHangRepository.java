/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainModels.KhachHang;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class KhachHangRepository implements IKhachHangRepository {

    private DBConnection db = new DBConnection();

    @Override
    public List<KhachHang> findAll() {
        String sql = "SELECT * FROM KhachHang";
        List<KhachHang> listKhachHang = new ArrayList<>();
        try ( Connection con = db.getConnection();  PreparedStatement khachHang = con.prepareStatement(sql)) {
            ResultSet resultSet = khachHang.executeQuery();
            while (resultSet.next()) {
                KhachHang kh = new KhachHang();
                kh.setMa(resultSet.getString(2));
                kh.setTen(resultSet.getString(3));
                kh.setTenDem(resultSet.getString(4));
                kh.setHo(resultSet.getString(5));
                kh.setNgaySinh(resultSet.getString(6));
                kh.setSdt(resultSet.getString(7));
                kh.setDiaChi(resultSet.getString(8));
                kh.setThanhPho(resultSet.getString(9));
                kh.setQuocGia(resultSet.getString(10));
                kh.setMatKhau(resultSet.getString(11));
                listKhachHang.add(kh);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    @Override
    public Boolean insert(KhachHang kh) {
        String sql = "insert into KhachHang(ma,ten,tendem,ho,sdt,ngaysinh,diachi,thanhpho,quocgia,matkhau) values(?,?,?,?,?,?,?,?,?,?)";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement khachHang = con.prepareStatement(sql)) {
            khachHang.setObject(1, kh.getMa());
            khachHang.setObject(2, kh.getTen());
            khachHang.setObject(3, kh.getTenDem());
            khachHang.setObject(4, kh.getHo());
            khachHang.setObject(5, kh.getSdt());
            khachHang.setObject(6, kh.getNgaySinh());
            khachHang.setObject(7, kh.getDiaChi());
            khachHang.setObject(8, kh.getThanhPho());
            khachHang.setObject(9, kh.getQuocGia());
            khachHang.setObject(10, kh.getMatKhau());
            check = khachHang.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(KhachHang kh) {
        String sql = "UPDATE KhachHang SET ten=?,tendem =?,ho=?,sdt=?,ngaysinh=?,diachi=?,thanhpho=?,quocgia=?,matkhau=? WHERE ma = ?";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement khachHang = con.prepareStatement(sql)) {
         
            khachHang.setObject(1, kh.getTen());
            khachHang.setObject(2, kh.getTenDem());
            khachHang.setObject(3, kh.getHo());
            khachHang.setObject(4, kh.getSdt());
            khachHang.setObject(5, kh.getNgaySinh());
            khachHang.setObject(6, kh.getDiaChi());
            khachHang.setObject(7, kh.getThanhPho());
            khachHang.setObject(8, kh.getQuocGia());
            khachHang.setObject(9, kh.getMatKhau());
            khachHang.setObject(10, kh.getMa());
            check = khachHang.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public Boolean delete(String ma) {
                String sql = "DELETE KhachHang WHERE ma = ?";
        int check;
        try ( Connection con = db.getConnection();  PreparedStatement khachHang = con.prepareStatement(sql)) {     
            khachHang.setObject(1, ma);
            check = khachHang.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    }
    

}
