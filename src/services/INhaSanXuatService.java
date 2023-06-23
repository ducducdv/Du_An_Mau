/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainModels.ChucVu;
import java.util.List;
import viewModels.ViewChucVu;
import viewModels.ViewMauSac;
import viewModels.ViewNhaSanXuat;

/**
 *
 * @author Dell
 */
public interface INhaSanXuatService {

    List<ViewNhaSanXuat> findAll();

    String insert(ViewNhaSanXuat x);

    String update(ViewNhaSanXuat x);

    String delete(String ma);
}
