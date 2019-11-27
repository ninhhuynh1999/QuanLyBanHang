/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietHoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ninhh
 */
public class ChiTietHoaDonDAO {
    public static ArrayList<ChiTietHoaDonDTO> getlist() {
       
        try {
         
             Connection cons= DBConnect.getConnection();
        String sql="select * from cthd";
        
        
        
        ArrayList<ChiTietHoaDonDTO> listCTHD= new ArrayList<ChiTietHoaDonDTO>();
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietHoaDonDTO chitiet=new  ChiTietHoaDonDTO();
                
                chitiet.setMaCTHD(rs.getInt(1)); 
                chitiet.setMaHD(rs.getInt(2)); 
                chitiet.setMaSP(rs.getInt(3)); 
                chitiet.setSL(rs.getInt(4)); 
                chitiet.setDongia(rs.getInt(5)); 
                chitiet.setThanhtien(rs.getInt(6));
              
                listCTHD.add(chitiet);
            }
            ps.close();
            rs.close();
            cons.close();
         
            return listCTHD;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi chi tiet hoa don");
        }
        return null;
    }
    public static ArrayList<ChiTietHoaDonDTO> getlist_TheoMaHD(int MaHD) {
       
        try {
         
             Connection cons= DBConnect.getConnection();
        String sql="select * from cthd where MaHD = "+MaHD;
        
        
        
        ArrayList<ChiTietHoaDonDTO> listCTHD= new ArrayList<>();
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietHoaDonDTO chitiet=new  ChiTietHoaDonDTO();
                
                chitiet.setMaCTHD(rs.getInt(1)); 
                chitiet.setMaHD(rs.getInt(2)); 
                chitiet.setMaSP(rs.getInt(3)); 
                chitiet.setSL(rs.getInt(4)); 
                chitiet.setDongia(rs.getInt(5)); 
                chitiet.setThanhtien(rs.getInt(6));
              
                listCTHD.add(chitiet);
            }
            ps.close();
            rs.close();
            cons.close();
         
            return listCTHD;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi chi tiet hoa don");
        }
        return null;
    }
    public static ChiTietHoaDonDTO timCTHD_TheoMaHD(int mahd){
        Connection cons=DBConnect.getConnection();
        String sql="select *  FROM CTHD where MaHD = "+mahd ;
        ChiTietHoaDonDTO temp=new ChiTietHoaDonDTO();
        try {
            PreparedStatement ps=cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               temp.setMaCTHD(rs.getInt(1)); 
                temp.setMaHD(rs.getInt(3)); 
                temp.setMaSP(rs.getInt(2)); 
                temp.setSL(rs.getInt(5)); 
                temp.setDongia(rs.getInt(4)); 
                temp.setThanhtien(rs.getInt(6));
            }
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return null;
    }
    
    public static void themCTHD(ChiTietHoaDonDTO chitiet) {
           // create the mysql insert preparedstatement
           ArrayList<ChiTietHoaDonDTO> arr =getlist();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaCTHD()==chitiet.getMaCTHD()){
                   System.out.println("Ma chi tiet hoa don da ton tai");
                   return;
               }
        }
      String sql = "insert into cthd (MaCTHD, MaHD, MaSP, SoLuong, Gia	, ThanhTien) values (?,?,?,?,?,?)";
   
     
        try {
              Connection cons= DBConnect.getConnection();
              PreparedStatement ps = cons.prepareCall(sql);
               ps.setInt(1,chitiet.getMaCTHD());
            ps.setInt(2, chitiet.getMaHD());
            ps.setInt(3,chitiet.getMaSP());
            ps.setInt(4,chitiet.getSL());
            ps.setInt(5,chitiet.getDongia());
            ps.setInt(6,chitiet.getThanhtien());
         
            ps.execute();
              
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
    public static  void SuaCTHD(ChiTietHoaDonDTO chitiet){
        Connection cons = DBConnect.getConnection();
       String sql = "UPDATE cthd SET  MaHD = ?, MaSP = ?, SoLuong = ?, Gia = ?, ThanhTien = ? WHERE MaCTHD = ?";
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 
                    ps.setInt(1, chitiet.getMaHD());
                    ps.setInt(2,chitiet.getMaSP());
                    ps.setInt(3,chitiet.getSL());
                    ps.setInt(4,chitiet.getDongia());
                    ps.setInt(5,chitiet.getThanhtien());
                    ps.setInt(6,chitiet.getMaCTHD());
                   
                 ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Loi update Chi tiet hoa don ");
        }
      
        
    }
    
    
     public static void Delete(int MaCTHD){
        Connection cons = DBConnect.getConnection();
        String sql="DELETE FROM `cthd` WHERE `MaCTHD` = "+MaCTHD;
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi delete chi tiet hoa don ");
        }
      
        
    }
     public static  int TongCTHD(int MaHD){
         Connection cons = DBConnect.getConnection();
         String sql="Select SUM(ThanhTien) from cthd where MaHD= "+MaHD;
         int tongcthd=0;
         try {
             
              PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              
                
                tongcthd=rs.getInt(1); 
             
              
                
            }
            ps.close();
            rs.close();
            cons.close();
         
           
         } catch (Exception e) {
         }
          return tongcthd;
     }
     public static void main(String[] args) {
        ChiTietHoaDonDAO dao=new ChiTietHoaDonDAO();
        dao.getlist();
         System.out.println(dao.getlist());
    }
}
