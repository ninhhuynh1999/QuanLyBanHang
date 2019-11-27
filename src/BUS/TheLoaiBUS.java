/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TheLoaiDAO;
import DTO.TheLoaiDTO;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class TheLoaiBUS {
      public static ArrayList<TheLoaiDTO> getList(){
         return TheLoaiDAO.getlist();
     }
    public static int createOrUpdate(TheLoaiDTO hoadon){
       return TheLoaiDAO.CreateOrUpdate(hoadon);
    }
    public static void Delete(int MaHD){
        TheLoaiDAO.Delete(MaHD);
    }
    public static int MaTheLoai_Max(){
        int max=0;
        ArrayList<TheLoaiDTO> sp= getList();
        for (TheLoaiDTO sp1 : sp) {
            if(sp1.getMaTheLoai()>max) {
                max=sp1.getMaTheLoai();
            }
        }
        return max;
    }
    public static TheLoaiDTO getTheLoai_TheoMa(int MaSP){
         ArrayList<TheLoaiDTO> sp= getList();
        for (TheLoaiDTO sp1 : sp) {
            if(sp1.getMaTheLoai()== MaSP) {
              return sp1;
            }
        }
        return null;
    }
}
