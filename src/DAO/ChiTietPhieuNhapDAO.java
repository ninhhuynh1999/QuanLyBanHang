/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class ChiTietPhieuNhapDAO {
    public static ArrayList<ChiTietPhieuNhapDTO> getlist() {
        Connection cons= DBConnect.getConnection();
        String sql="select * from ctnh";
        ArrayList<ChiTietPhieuNhapDTO> list= new ArrayList<>();
        try {
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ChiTietPhieuNhapDTO ctpn=new  ChiTietPhieuNhapDTO();
                ctpn.setMaphieunhap(rs.getInt(1)); 
                ctpn.setMaSP(rs.getInt(2)); 
                ctpn.setSoluong(rs.getInt(3)); 
                ctpn.setDongia(rs.getInt(4)); 
                ctpn.setThanhtien(rs.getInt(5));                
                list.add(ctpn);
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

    
    public static int CreateOrUpdate(ChiTietPhieuNhapDTO chitietDTO) {
        try {
            Connection cons= DBConnect.getConnection();
            String sql="INSERT INTO ctnh(MaPhieuNhap,Ma_SP,SoLuong,DonGia,ThanhTien)  VALUES(?, ?, ?, ?, ?) ";
            sql+=" ON DUPLICATE KEY UPDATE Ma_SP= VALUES(Ma_SP), SoLuong= VALUES(SoLuong), DonGia= VALUES(DonGia), ThanhTien=VALUES(Thanhien);";
            PreparedStatement ps=cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,chitietDTO.getMaphieunhap());
            ps.setInt(2,chitietDTO.getMaSP());
            ps.setInt(3,chitietDTO.getSoluong());
            ps.setInt(4,chitietDTO.getDongia());
            ps.setInt(5,chitietDTO.getThanhtien());
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
             System.out.println("Loi inster update chi tiet phieu nhap");
        }
        return 0;
    }
    
    
     public static void Delete(int MaPhieuNhap){
        Connection cons = DBConnect.getConnection();
        String sql="DELETE FROM `ctnh` WHERE `MaPhieuNhap` = "+MaPhieuNhap;
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi delete chi tiet phieu nhap");
        }
      
        
    }
    
    
    public static void main(String[] args) {      
        ChiTietPhieuNhapDAO ctpn=new ChiTietPhieuNhapDAO();
        System.out.println(ctpn.getlist());
       
    }
}
