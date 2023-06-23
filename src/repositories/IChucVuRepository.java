/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainModels.ChucVu;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IChucVuRepository {

    List<ChucVu> findAll();

    Boolean insert(ChucVu cv);

    Boolean update(ChucVu cv);

    Boolean delete(String ma);

}
 