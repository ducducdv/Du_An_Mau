/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainModels.KhachHang;
import java.util.ArrayList;
import java.util.List;
import repositories.KhachHangRepository;
import viewModels.ViewKhachHang;

/**
 *
 * @author Dell
 */
public class KhachHangService implements IKhachHangService{
    
    private KhachHangRepository khachHangRepository;
    
    private List<ViewKhachHang> listKhachHang;

    public KhachHangService() {
        khachHangRepository = new KhachHangRepository();
        listKhachHang = new ArrayList<>();
    }
    
    
    @Override
    public List<ViewKhachHang> findAll() {
         listKhachHang = new ArrayList<>();
        var model = khachHangRepository.findAll();
        for (KhachHang x : model) {
            listKhachHang.add(new ViewKhachHang(x.getMa(), x.getTen(), x.getTenDem(), x.getHo(),x.getNgaySinh(), x.getSdt(),x.getDiaChi(), x.getThanhPho(),x.getQuocGia(),x.getMatKhau()));
        }
        return listKhachHang;
    }

    @Override
    public String insert(ViewKhachHang kh) {
         var model = new KhachHang(kh.getMa(), kh.getTen(), kh.getTenDem(), kh.getHo(),kh.getNgaySinh(), kh.getSdt(),kh.getDiaChi(), kh.getThanhPho(),kh.getQuocGia(),kh.getMatKhau());
        if(khachHangRepository.insert(model)){
            return " Thêm thành công rồi nè";
        }else{
            return "Thêm chưa thành công nha";
        }
    }

    @Override
    public String update(ViewKhachHang kh) {
          var model = new KhachHang(kh.getMa(), kh.getTen(), kh.getTenDem(), kh.getHo(),kh.getNgaySinh(), kh.getSdt(),kh.getDiaChi(), kh.getThanhPho(),kh.getQuocGia(),kh.getMatKhau());
        if(khachHangRepository.update(model)){
            return "Sửa thành công rồi nè";
        }else{
            return "Sửa chưa thành công nha";
        }
    }

    @Override
    public String delete(String ma) {
         if(khachHangRepository.delete(ma)){
            return "Xóa thành công rồi nè";
        }else{
            return "Chưa xóa được nha";
        }
    }
    
}
