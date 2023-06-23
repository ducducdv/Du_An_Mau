/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import domainModels.MauSac;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IMauSacRepository {

    List<MauSac> findAll();

    Boolean insert(MauSac cv);

    Boolean update(MauSac cv);

    Boolean delete(String ma);

}
 