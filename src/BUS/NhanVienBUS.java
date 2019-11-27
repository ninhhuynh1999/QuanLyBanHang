/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class NhanVienBUS {
    
    
    
 
    public static ArrayList<NhanVienDTO> getList() {
      return NhanVienDAO.getlist();
    }

    public static int createOrUpdate(NhanVienDTO NhanVien) {
     return NhanVienDAO.CreateOrUpdate(NhanVien);
    }
    public static void Delete(int MaNV){
        NhanVienDAO.Delete(MaNV);
    }
    public static int MaNV_Max(){
        int max=0;
        ArrayList<NhanVienDTO> sp= getList();
        for (NhanVienDTO nv : sp) {
            if(nv.getMaNV()>max) {
                max=nv.getMaNV();
            }
        }
        return max;
    }
    public static NhanVienDTO getNV_TheoMa(int MaNV){
         ArrayList<NhanVienDTO> sp= getList();
        for (NhanVienDTO nv : sp) {
            if(nv.getMaNV()== MaNV) {
              return nv;
            }
        }
        return null;
    }
    
}
