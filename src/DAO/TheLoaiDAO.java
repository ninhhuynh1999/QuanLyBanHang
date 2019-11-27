/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.TheLoaiDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class TheLoaiDAO {
    
     public static  ArrayList<TheLoaiDTO> getlist() {
       
        try {
         //   System.out.println("vao don hang");
             Connection cons= DBConnect.getConnection();
        String sql="select * from loaisp";
        
        
        
        ArrayList<TheLoaiDTO> listTheloai= new ArrayList<>();
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TheLoaiDTO theloai=new TheLoaiDTO();
                
                theloai.setMaTheLoai(rs.getInt(1)); 
                theloai.setTenTheLoai(rs.getString(2)); 
              
                listTheloai.add(theloai);
            }
            ps.close();
            rs.close();
            cons.close();
         
            return listTheloai;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi the loai list");
        }
        return null;
    }
     
      public static  int CreateOrUpdate(TheLoaiDTO theLoai) {
        try {
            Connection cons= DBConnect.getConnection();
            String sql="INSERT INTO loaisp(MaLoai, TenLoaiSP )  VALUES(?, ?) ";
            sql+=" ON DUPLICATE KEY UPDATE TenLoaiSP= VALUES(TenLoaiSP);";
            PreparedStatement ps=cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,theLoai.getMaTheLoai());
            ps.setString(2,theLoai.getTenTheLoai());
           
            
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
              System.out.println("Loi iinsert update the loai ");
        }
        return 0;
    }
      
    public static  void Delete(int MaLoai){
        Connection cons = DBConnect.getConnection();
        String sql="DELETE FROM `loaisp` WHERE `MaLoai` = "+MaLoai;
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi delete the loai ");
        }
      
        
    }
    
    
}
