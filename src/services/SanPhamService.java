/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainModels.SanPham;
import java.util.ArrayList;
import java.util.List;
import repositories.SanPhamRepository;
import viewModels.ViewSanPham;

/**
 *
 * @author Dell
 */
public class SanPhamService implements ISanPhamService {

    private SanPhamRepository repository;
    private List<ViewSanPham> listView;

    public SanPhamService() {
        repository = new SanPhamRepository();
        listView = new ArrayList<>();
    }

    @Override
    public List<ViewSanPham> findAll() {
        listView = new ArrayList<>();
        var model = repository.findAll();
        for (SanPham x : model) {
            listView.add(new ViewSanPham(x.getMa(), x.getTen()));
        }
        return listView;
    }

    @Override
    public String insert(ViewSanPham cv) {
        var model = new SanPham(cv.getMa(), cv.getTen());
        if(repository.insert(model)){
            return " Thêm thành công rồi nè";
        }else{
            return "Thêm chưa thành công nha";
        }
    }

    @Override
    public String update(ViewSanPham cv) {
        var model = new SanPham(cv.getMa(), cv.getTen());
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
