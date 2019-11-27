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
public class ChiTietHoaDonDTO {
    private int MaCTHD;
    private int MaHD;
    private int MaSP;
    private int SL;
    private int dongia;
    private int thanhtien;

    public ChiTietHoaDonDTO() {
    }
    public ChiTietHoaDonDTO(ChiTietHoaDonDTO ct) {
         this.MaCTHD=ct.getMaCTHD();
        this.MaHD = ct.getMaHD();
        this.MaSP = ct.getMaSP();
        this.SL = ct.getSL();
        this.dongia = ct.getDongia();
        this.thanhtien = ct.getThanhtien();
    }

   

    public int getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(int MaCTHD) {
        this.MaCTHD = MaCTHD;
    }

    
    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return MaCTHD+"  "+MaHD+"  "+MaSP+"  "+SL+"  "+dongia+"  "+thanhtien+"  ";
    }
    
    
}
