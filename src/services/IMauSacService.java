/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainModels.ChucVu;
import java.util.List;
import viewModels.ViewChucVu;
import viewModels.ViewMauSac;

/**
 *
 * @author Dell
 */
public interface IMauSacService {

    List<ViewMauSac> findAll();

    String insert(ViewMauSac cv);

    String update(ViewMauSac cv);

    String delete(String ma);
}
