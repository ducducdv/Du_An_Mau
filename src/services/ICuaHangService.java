/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainModels.ChucVu;
import java.util.List;
import viewModels.ViewChucVu;
import viewModels.ViewCuaHang;
import viewModels.ViewMauSac;

/**
 *
 * @author Dell
 */
public interface ICuaHangService {

    List<ViewCuaHang> findAll();

    String insert(ViewCuaHang cv);

    String update(ViewCuaHang cv);

    String delete(String ma);
}
