/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ninhh
 */
public class NhanVienDTO {
    private int MaNV;
    private String TenNV;
    private int SDT;
        private String matkhau;
    private int QuyenTruyCap;

    public NhanVienDTO() {
    }
    
    public NhanVienDTO(NhanVienDTO nv) {
      this.MaNV = nv.getMaNV();
        this.TenNV = nv.getTenNV();
        this.SDT = nv.getSDT();
        this.matkhau = nv.getMatkhau();
        this.QuyenTruyCap = nv.getQuyenTruyCap();
    }

    public NhanVienDTO(int MaNV, String TenNV, int SDT, String matkhau, int QuyenTruyCap) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.SDT = SDT;
        this.matkhau = matkhau;
        this.QuyenTruyCap = QuyenTruyCap;
    }

    
    
    
    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getQuyenTruyCap() {
        return QuyenTruyCap;
    }

    public void setQuyenTruyCap(int QuyenTruyCap) {
        this.QuyenTruyCap = QuyenTruyCap;
    }

    @Override
    public String toString() {
        return ""+MaNV+" "+TenNV+" "+SDT+" "+matkhau+" "+QuyenTruyCap;
    }
    
    
    
    
    
}
