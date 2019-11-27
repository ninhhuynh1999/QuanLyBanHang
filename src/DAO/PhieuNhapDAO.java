/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class PhieuNhapDAO {
    
     public static ArrayList<PhieuNhapDTO> getlist() {
        Connection cons= DBConnect.getConnection();
        String sql="select * from nhaphang";
        ArrayList<PhieuNhapDTO> list= new ArrayList<>();
        try {
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                PhieuNhapDTO pn=new  PhieuNhapDTO();
                pn.setMaphieunhap(rs.getString(1)); 
                pn.setNgaylap(rs.getDate(2)); 
                pn.setManv(rs.getString(3)); 
                pn.setTongtien(rs.getInt(4));                
                list.add(pn);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    
    public static int CreateOrUpdate(PhieuNhapDTO pnDTO) {
        try {
            Connection cons= DBConnect.getConnection();
            String sql="INSERT INTO nhaphang(MaPhieuNhap,Ma_SP,SoLuong,DonGia,ThanhTien)  VALUES(?, ?, ?, ?, ?) ";
            sql+=" ON DUPLICATE KEY UPDATE Ma_SP= VALUES(Ma_SP), SoLuong= VALUES(SoLuong), DonGia= VALUES(DonGia), ThanhTien=VALUES(Thanhien);";
            PreparedStatement ps=cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,pnDTO.getMaphieunhap());
            ps.setDate(2,pnDTO.getNgaylap());
            ps.setString(3,pnDTO.getManv());
            ps.setInt(4,pnDTO.getTongtien());           
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
        }
        return 0;
    }
    
     public static  void Delete(int MaPhieuNhap){
        Connection cons = DBConnect.getConnection();
        String sql="DELETE FROM `nhaphang` WHERE `MaPhieuNhap` = "+MaPhieuNhap;
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi delete Phieu nhập ");
        }
      
        
    }
    
    
    public static void main(String[] args) {            
        PhieuNhapDAO pn = new PhieuNhapDAO();
        System.out.println(pn.getlist());
       
    }
}
