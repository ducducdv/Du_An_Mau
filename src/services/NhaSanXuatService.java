/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import domainModels.NhaSanXuat;
import java.util.ArrayList;
import java.util.List;

import repositories.NhaSanXuatRepository;

import viewModels.ViewNhaSanXuat;

/**
 *
 * @author Dell
 */
public class NhaSanXuatService implements INhaSanXuatService {

    private NhaSanXuatRepository repository;
    private List<ViewNhaSanXuat> listView;

    public NhaSanXuatService() {
        repository = new NhaSanXuatRepository();
        listView = new ArrayList<>();
    }

    @Override
    public List<ViewNhaSanXuat> findAll() {
        listView = new ArrayList<>();
        var model = repository.findAll();
        for (NhaSanXuat x : model) {
            listView.add(new ViewNhaSanXuat(x.getMa(), x.getTen()));
        }
        return listView;
    }

    @Override
    public String insert(ViewNhaSanXuat cv) {
        var model = new NhaSanXuat(cv.getMa(), cv.getTen());
        if(repository.insert(model)){
            return " Thêm thành công rồi nè";
        }else{
            return "Thêm chưa thành công nha";
        }
    }

    @Override
    public String update(ViewNhaSanXuat cv) {
        var model = new NhaSanXuat(cv.getMa(), cv.getTen());
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
