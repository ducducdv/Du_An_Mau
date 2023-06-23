/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import domainModels.MauSac;
import domainModels.SanPham;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface ISanPhamRepository {

    List<SanPham> findAll();

    Boolean insert(SanPham x);

    Boolean update(SanPham x);

    Boolean delete(String ma);

}
 