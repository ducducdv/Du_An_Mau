/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainModels.ChucVu;
import domainModels.MauSac;
import java.util.ArrayList;
import java.util.List;
import repositories.ChucVuRepository;
import repositories.IChucVuRepository;
import repositories.MauSacRepository;
import viewModels.ViewChucVu;
import viewModels.ViewMauSac;

/**
 *
 * @author Dell
 */
public class MauSacService implements IMauSacService {

    private MauSacRepository repository;
    private List<ViewMauSac> listView;

    public MauSacService() {
        repository = new MauSacRepository();
        listView = new ArrayList<>();
    }

    @Override
    public List<ViewMauSac> findAll() {
        listView = new ArrayList<>();
        var model = repository.findAll();
        for (MauSac x : model) {
            listView.add(new ViewMauSac(x.getMa(), x.getTen()));
        }
        return listView;
    }

    @Override
    public String insert(ViewMauSac cv) {
        var model = new MauSac(cv.getMa(), cv.getTen());
        if(repository.insert(model)){
            return " Thêm thành công rồi nè";
        }else{
            return "Thêm chưa thành công nha";
        }
    }

    @Override
    public String update(ViewMauSac cv) {
        var model = new MauSac(cv.getMa(), cv.getTen());
        if(repository.update(model)){
            return "Sửa thành công rồi nè";
        }else{
            return "Sửa chưa thành công nha";
        }
    }

    @Override
    public String delete(String ma) {
        if(repository.delete(ma)){
            return "Xóa thành công rồi nè";
        }else{
            return "Chưa xóa được nha";
        }
    }

}
