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
public class KhachHangDTO {
    private int MaKH;
    private String TenKH;
    private long SDT;
    private String Diachi;

    public KhachHangDTO() {
    }

    public KhachHangDTO(KhachHangDTO kh) {
         this.MaKH = kh.getMaKH();
        this.TenKH = kh.getTenKH();
        this.SDT = kh.getSDT();
        this.Diachi = kh.getDiachi();
    }

    public KhachHangDTO(int MaKH, String TenKH, long SDT, String Diachi) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.Diachi = Diachi;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public long getSDT() {
        return SDT;
    }

    public void setSDT(long SDT) {
        this.SDT = SDT;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    @Override
    public String toString() {
        return " "+MaKH+" "+TenKH+" "+SDT+" "+Diachi;
    }
    
    
    
}
