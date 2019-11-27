/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class NhaCungCapBUS {
      public static ArrayList<NhaCungCapDTO> getList(){
         return NhaCungCapDAO.getlist();
     }
    public static int createOrUpdate(NhaCungCapDTO hoadon){
       return NhaCungCapDAO.CreateOrUpdate(hoadon);
    }
    public static void Delete(int MaHD){
        NhaCungCapDAO.Delete(MaHD);
    }
       public static int MaTheLoai_Max(){
        int max=0;
        ArrayList<NhaCungCapDTO> sp= getList();
        for (NhaCungCapDTO ncc : sp) {
            if(ncc.getMaNCC()>max) {
                max=ncc.getMaNCC();
            }
        }
        return max;
    }
    public static NhaCungCapDTO getTheLoai_TheoMa(int MaSP){
         ArrayList<NhaCungCapDTO> sp= getList();
        for (NhaCungCapDTO ncc : sp) {
            if(ncc.getMaNCC()== MaSP) {
              return ncc;
            }
        }
        return null;
    }
}
