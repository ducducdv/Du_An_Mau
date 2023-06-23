/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import domainModels.MauSac;
import domainModels.NhaSanXuat;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface INhaSanXuatRepository {

    List<NhaSanXuat> findAll();

    Boolean insert(NhaSanXuat x);

    Boolean update(NhaSanXuat x);

    Boolean delete(String ma);

}
 