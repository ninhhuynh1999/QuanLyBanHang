/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;


public class KhachHangBUS {
     public static ArrayList<KhachHangDTO> getList(){
         return KhachHangDAO.getlist();
     }
    public static int createOrUpdate(KhachHangDTO hoadon){
       return KhachHangDAO.CreateOrUpdate(hoadon);
    }
    public static void Delete(int MaHD){
        KhachHangDAO.Delete(MaHD);
    }
     public static int MaKH_Max(){
        int max=0;
        ArrayList<KhachHangDTO> sp= getList();
        for (KhachHangDTO kh : sp) {
            if(kh.getMaKH()>max) {
                max=kh.getMaKH();
            }
        }
        return max;
    }
    public static KhachHangDTO getKH_TheoMa(int MaNV){
         ArrayList<KhachHangDTO> sp= getList();
        for (KhachHangDTO kh : sp) {
            if(kh.getMaKH()== MaNV) {
              return kh;
            }
        }
        return null;
    }
     
}
