/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainModels.ChucVu;
import java.util.List;
import viewModels.ViewChucVu;

/**
 *
 * @author Dell
 */
public interface IChucVuService {

    List<ViewChucVu> findAll();

    String insert(ViewChucVu cv);

    String update(ViewChucVu cv);

    String delete(String ma);
}
