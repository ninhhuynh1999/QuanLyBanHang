/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class KhachHangDAO {
        public static ArrayList<KhachHangDTO> getlist() {
       
        try {
           
             Connection cons= DBConnect.getConnection();
        String sql="select * from khachhang";
        
        
        
        ArrayList<KhachHangDTO> listKhachHang= new ArrayList<>();
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHangDTO hd=new KhachHangDTO();
                
                hd.setMaKH(rs.getInt(1)); 
                hd.setTenKH(rs.getString(2)); 
                hd.setSDT(rs.getInt(3)); 
                hd.setDiachi(rs.getString(4)); 
                
              
                listKhachHang.add(hd);
            }
            ps.close();
            rs.close();
            cons.close();
         
            return listKhachHang;
        } catch     (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi KhachHangDAO get list");
        }
        return null;
    }
    

   
    public static int CreateOrUpdate(KhachHangDTO khachHang) {
        try {
            Connection cons= DBConnect.getConnection();
            String sql="INSERT INTO khachhang(MaKH, TenKH, SDT, DiaChi )  VALUES(?, ?, ?, ?) ";
            sql+=" ON DUPLICATE KEY UPDATE TenKH= VALUES(TenKH), SDT= VALUES(SDT), DiaChi= VALUES(DiaChi);";
            PreparedStatement ps=cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,khachHang.getMaKH());
            ps.setString(2,khachHang.getTenKH());
            ps.setLong(3,khachHang.getSDT());
            ps.setString(4,khachHang.getDiachi());
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey=0;
            if(rs.next()){
                 generatedKey=rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
            
        } catch (Exception e) {
            e.printStackTrace();
               System.out.println("Loi instert update khach hang ");
        }
        return 0;
    }
    
      public static void Delete(int MaKH){
        Connection cons = DBConnect.getConnection();
        String sql="DELETE FROM `khachhang` WHERE `MaNV` = "+MaKH;
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 ps.executeUpdate();
                  ps.close();
            cons.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi delete khach hang ");
        }
      
        
    }
    
    public static void main(String[] args) {
        KhachHangDAO dao=new KhachHangDAO();
        System.out.println(dao.getlist());
        KhachHangDTO nv=new KhachHangDTO(3, "Khach Hang 3", 1234567891, "123");
        dao.CreateOrUpdate(nv);
        System.out.println(dao.getlist());
        
    }
}
