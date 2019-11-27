/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhaCungCapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class NhaCungCapDAO {
     public static ArrayList<NhaCungCapDTO> getlist() {
       
        try {
         //   System.out.println("vao don hang");
             Connection cons= DBConnect.getConnection();
        String sql="select * from nhacungcap";
        
        
        
        ArrayList<NhaCungCapDTO> listTheloai= new ArrayList<>();
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhaCungCapDTO theloai=new NhaCungCapDTO();
                
                theloai.setMaNCC(rs.getInt(1)); 
                theloai.setTenNCC(rs.getString(2)); 
              
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
     
      public static int CreateOrUpdate(NhaCungCapDTO nhacungcap) {
        try {
            Connection cons= DBConnect.getConnection();
            String sql="INSERT INTO nhacungcap(MaNCC, TenNCC )  VALUES(?, ?) ";
            sql+=" ON DUPLICATE KEY UPDATE TenNCC= VALUES(TenNCC);";
            PreparedStatement ps=cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,nhacungcap.getMaNCC());
            ps.setString(2,nhacungcap.getTenNCC());
           
            
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
              System.out.println("Loi iinsert update NCC ");
        }
        return 0;
    }
      
    public static void Delete(int MaNCC){
        Connection cons = DBConnect.getConnection();
        String sql="DELETE FROM `nhacungcap` WHERE `MaNCC` = "+MaNCC;
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi delete NCC ");
        }
      
        
    }
    

}
