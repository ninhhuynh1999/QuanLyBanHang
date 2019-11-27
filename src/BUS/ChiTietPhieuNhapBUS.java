/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class ChiTietPhieuNhapBUS {
      public static ArrayList<ChiTietPhieuNhapDTO> getList(){
         return ChiTietPhieuNhapDAO.getlist();
     }
    public static int createOrUpdate(ChiTietPhieuNhapDTO hoadon){
       return ChiTietPhieuNhapDAO.CreateOrUpdate(hoadon);
    }
    public static void Delete(int MaHD){
        ChiTietPhieuNhapDAO.Delete(MaHD);
    }
}
