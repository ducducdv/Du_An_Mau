/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainModels.ChucVu;
import domainModels.CuaHang;
import domainModels.MauSac;
import java.util.ArrayList;
import java.util.List;
import repositories.ChucVuRepository;
import repositories.CuaHangRepository;
import repositories.IChucVuRepository;
import repositories.MauSacRepository;
import viewModels.ViewChucVu;
import viewModels.ViewCuaHang;
import viewModels.ViewMauSac;

/**
 *
 * @author Dell
 */
public class CuaHangService implements ICuaHangService {

    private CuaHangRepository repository;
    private List<ViewCuaHang> listView;

    public CuaHangService() {
        repository = new CuaHangRepository();
        listView = new ArrayList<>();
    }

    @Override
    public List<ViewCuaHang> findAll() {
        listView = new ArrayList<>();
        var model = repository.findAll();
        for (CuaHang x : model) {
            listView.add(new ViewCuaHang(x.getMa(), x.getTen(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia()));
        }
        return listView;
    }

    @Override
    public String insert(ViewCuaHang x) {
        var model = new CuaHang(x.getMa(), x.getTen(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia());
        if(repository.insert(model)){
            return " Thêm thành công rồi nè";
        }else{
            return "Thêm chưa thành công nha";
        }
    }

    @Override
    public String update(ViewCuaHang x) {
        var model = new CuaHang(x.getMa(), x.getTen(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia());
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
