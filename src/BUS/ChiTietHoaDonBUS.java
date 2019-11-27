/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class ChiTietHoaDonBUS {
     public static ArrayList<ChiTietHoaDonDTO> getlist() {
       return ChiTietHoaDonDAO.getlist();
      
    }
        public static ArrayList<ChiTietHoaDonDTO> getlist_TheoMaHD(int MaHD) {
       return ChiTietHoaDonDAO.getlist_TheoMaHD(MaHD);
      
    }
    
    public static void themSP(ChiTietHoaDonDTO chitiet) {
        ChiTietHoaDonDAO.SuaCTHD(chitiet);
      
        
    }
    
        public static ChiTietHoaDonDTO timCTHD_TheoMaHD(int mahd){
            return ChiTietHoaDonDAO.timCTHD_TheoMaHD(mahd);
        }
     public static void Delete(int MaCTHD){
      
      ChiTietHoaDonDAO.Delete(MaCTHD);
        
    }
     
     public static void SuaCTHD(ChiTietHoaDonDTO chitiet){
         ChiTietHoaDonDAO.SuaCTHD(chitiet);
     }
      public static ChiTietHoaDonDTO TimCTHD_TheoMa(int MaCTHD){
         
        ArrayList<ChiTietHoaDonDTO> hd= getlist();
        for (ChiTietHoaDonDTO hoadon : hd) {
            if(hoadon.getMaHD()==MaCTHD) {
               return hoadon;
            }
        }
        return null;
     }
      public static  int TongCTHD(int MaHD){
         return ChiTietHoaDonDAO.TongCTHD(MaHD);
     }
}
