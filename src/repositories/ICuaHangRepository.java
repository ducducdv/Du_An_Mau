/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import domainModels.CuaHang;
import domainModels.MauSac;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface ICuaHangRepository {

    List<CuaHang> findAll();

    Boolean insert(CuaHang cv);

    Boolean update(CuaHang cv);

    Boolean delete(String ma);

}
 