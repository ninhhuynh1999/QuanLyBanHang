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
public class TheLoaiDTO {
    private int MaTheLoai;
    private String TenTheLoai;

    public TheLoaiDTO() {
        
    }
    
    public TheLoaiDTO(TheLoaiDTO theloai){
        this.MaTheLoai=theloai.getMaTheLoai();
        this.TenTheLoai=theloai.getTenTheLoai();
    }

    public int getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(int MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }

    public TheLoaiDTO(int MaTheLoai, String TenTheLoai) {
        this.MaTheLoai = MaTheLoai;
        this.TenTheLoai = TenTheLoai;
    }
    
}
