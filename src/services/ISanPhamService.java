/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainModels.ChucVu;
import java.util.List;
import viewModels.ViewChucVu;
import viewModels.ViewMauSac;
import viewModels.ViewSanPham;

/**
 *
 * @author Dell
 */
public interface ISanPhamService {

    List<ViewSanPham> findAll();

    String insert(ViewSanPham x);

    String update(ViewSanPham x);

    String delete(String ma);
}
