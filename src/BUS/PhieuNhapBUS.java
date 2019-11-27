/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class PhieuNhapBUS {
      public static ArrayList<PhieuNhapDTO> getList(){
         return PhieuNhapDAO.getlist();
     }
    public static int createOrUpdate(PhieuNhapDTO hoadon){
       return PhieuNhapDAO.CreateOrUpdate(hoadon);
    }
    public static void Delete(int MaHD){
        PhieuNhapDAO.Delete(MaHD);
    }
}
