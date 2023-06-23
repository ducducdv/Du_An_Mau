/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainModels.ChucVu;
import java.util.ArrayList;
import java.util.List;
import repositories.ChucVuRepository;
import repositories.IChucVuRepository;
import viewModels.ViewChucVu;

/**
 *
 * @author Dell
 */
public class ChucVuService implements IChucVuService {

    private ChucVuRepository chucVuRepository;
    private List<ViewChucVu> listViewChucVu;

    public ChucVuService() {
        chucVuRepository = new ChucVuRepository();
        listViewChucVu = new ArrayList<>();
    }

    @Override
    public List<ViewChucVu> findAll() {
        listViewChucVu = new ArrayList<>();
        var model = chucVuRepository.findAll();
        for (ChucVu x : model) {
            listViewChucVu.add(new ViewChucVu(x.getMa(), x.getTen()));
        }
        return listViewChucVu;
    }

    @Override
    public String insert(ViewChucVu cv) {
        var model = new ChucVu(cv.getMa(), cv.getTen());
        if(chucVuRepository.insert(model)){
            return " Thêm thành công rồi nè";
        }else{
            return "Thêm chưa thành công nha";
        }
    }

    @Override
    public String update(ViewChucVu cv) {
        var model = new ChucVu(cv.getMa(), cv.getTen());
        if(chucVuRepository.update(model)){
            return "Sửa thành công rồi nè";
        }else{
            return "Sửa chưa thành công nha";
        }
    }

    @Override
    public String delete(String ma) {
        if(chucVuRepository.delete(ma)){
            return "Xóa thành công rồi nè";
        }else{
            return "Chưa xóa được nha";
        }
    }

}
