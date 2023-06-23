/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewModels.ViewChucVu;
import viewModels.ViewKhachHang;

/**
 *
 * @author Dell
 */
public interface IKhachHangService {
     List<ViewKhachHang> findAll();

    String insert(ViewKhachHang kh);

    String update(ViewKhachHang kh);

    String delete(String ma);
}
