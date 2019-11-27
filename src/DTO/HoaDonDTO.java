/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;




/**
 *
 * @author ninhh
 */
public class HoaDonDTO {
    private int MaHD;
    private Date NgayLap;
    private int MaNV;
    private int MaKH;
    private int TongTien;
    private int GiamGia;
    private int SoTienThanhToan;

    public HoaDonDTO(HoaDonDTO hd) {
        this.MaHD = hd.getMaHD();
        this.NgayLap = hd.getNgayLap();
        this.MaNV = hd.getMaNV();
        this.MaKH = hd.getMaKH();
        this.TongTien = hd.getTongTien();
        this.GiamGia = hd.getGiamGia();
        this.SoTienThanhToan = hd.getSoTienThanhToan();
    }
    
    

    public int getSoTienThanhToan() {
        return SoTienThanhToan;
    }

    public void setSoTienThanhToan(int SoTienThanhToan) {
        this.SoTienThanhToan = SoTienThanhToan;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public int getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(int GiamGia) {
        this.GiamGia = GiamGia;
    }

    public HoaDonDTO(int MaHD, Date NgayLap, int MaNV, int MaKH, int TongTien, int GiamGia, int SoTienThanhToan) {
        this.MaHD = MaHD;
        this.NgayLap = NgayLap;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.TongTien = TongTien;
        this.GiamGia = GiamGia;
        this.SoTienThanhToan = SoTienThanhToan;
    }

   

    public HoaDonDTO() {
    }

    @Override
    public String toString() {
        return ""+MaHD+" "+" "+NgayLap+" "+MaNV+" "+TongTien+" "+MaKH+" "+GiamGia+" "+SoTienThanhToan+" ";
    }
    public static void main(String[] args) {
        int a=0;
         while (a!=1) {   
            System.out.println("while 1");
          ngu: while(true){
                switch(a){
                case 0:
                    System.out.println("do ngu");
                    break;
                default:
                   break ngu;
                    
            }
                System.out.println("dongu12121");
        } 
        }
        
    }
}
