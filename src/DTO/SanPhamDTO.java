/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class SanPhamDTO {
    private int Ma_SP;
    private String Ten_SP;
    private int Soluong;
    private int Gia; 
    private int MaTheLoai; 
    private int MaNCC; 
   // private boolean TinhTrang; 

    public SanPhamDTO(SanPhamDTO sp) {
       this.Ma_SP=sp.getMa_SP();
       this.Ten_SP=sp.getTen_SP();
       this.Gia=sp.getGia();
       this.Soluong=sp.getSoluong();
       this.MaNCC=sp.getMaNCC();
       this.MaTheLoai=sp.getMaTheLoai();
    //   this.TinhTrang=sp.getTinhTrang();
    }

    public int getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(int MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

//    public boolean getTinhTrang() {
//        return TinhTrang;
//    }
//
//    public void setTinhTrang(boolean TinhTrang) {
//        this.TinhTrang = TinhTrang;
//    }

    public int getMa_SP() {
        return Ma_SP;
    }

    public void setMa_SP(int Ma_SP) {
        this.Ma_SP = Ma_SP;
    }

    public String getTen_SP() {
        return Ten_SP;
    }

    public void setTen_SP(String Ten_SP) {
        this.Ten_SP = Ten_SP;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public SanPhamDTO() {
    }

   
    @Override
    public String toString() {
       
 
        return ""+Ma_SP+" "+" "+Ten_SP+" "+Soluong+" "+Gia+" "+MaTheLoai+" "+MaNCC+" ";
    }
   
   
    
    
    
}
