/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class HoaDonBUS {
    
    
    public static ArrayList<HoaDonDTO> getList(){
         return HoaDonDAO.getlist();
    }
    public static ArrayList<HoaDonDTO> TimKiemChung(String TimCaiGi, String noidung){
         return HoaDonDAO.TimKiemChung(TimCaiGi, noidung);
    }
    public static int createOrUpdate(HoaDonDTO hoadon){
       return HoaDonDAO.CreateOrUpdate(hoadon);
    }
    public static void Delete(int MaHD){
        HoaDonDAO.Delete(MaHD);
    }
    public static void SuaHD(HoaDonDTO hd){
        HoaDonDAO.SuaHD(hd);
    }
    public static void ThemHD(HoaDonDTO hd){
        HoaDonDAO.themHD(hd);
    }
   
    public static int MaSP_Max(){
        int max=0;
        ArrayList<HoaDonDTO> hd= getList();
        for (HoaDonDTO hoadon : hd) {
            if(hoadon.getMaHD()>max) {
                max=hoadon.getMaHD();
            }
        }
        return max;
    }
    public static HoaDonDTO TimHoaDon(int MaHD){
       
        ArrayList<HoaDonDTO> hd= getList();
        for (HoaDonDTO hoadon : hd) {
            if(hoadon.getMaHD() == MaHD) {
               return hoadon;
            }
        }
        return null;
    }
    public static  void SuaHD_TongTien(int MaHD,int TongTien){
        HoaDonDAO.SuaHD_TongTien(MaHD, TongTien);
      
        
    }
    
    
}
