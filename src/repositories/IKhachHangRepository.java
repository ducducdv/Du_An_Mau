/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import domainModels.KhachHang;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IKhachHangRepository {

    List<KhachHang> findAll();

    Boolean insert(KhachHang kh);

    Boolean update(KhachHang kh);

    Boolean delete(String ma);
}
