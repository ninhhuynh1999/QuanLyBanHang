/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
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
public class NhanVienDAO {
        public static ArrayList<NhanVienDTO> getlist() {
       
        try {
           
             Connection cons= DBConnect.getConnection();
        String sql="select * from nhanvien";
        
        
        
        ArrayList<NhanVienDTO> listNhanvien= new ArrayList<>();
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienDTO hd=new NhanVienDTO();
                
                hd.setMaNV(rs.getInt(1)); 
                hd.setTenNV(rs.getString(2)); 
                hd.setSDT(rs.getInt(3)); 
                hd.setMatkhau(rs.getString(4)); 
                hd.setQuyenTruyCap(rs.getInt(5)); 
              
                listNhanvien.add(hd);
            }
            ps.close();
            rs.close();
            cons.close();
         
            return listNhanvien;
        } catch     (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi NhanVienDAO get list");
        }
        return null;
    }
        public NhanVienDTO TimNV_TheoMa(int maNV){
        try {
            Connection con=DBConnect.getConnection();
            String sql="select * from nhanvien where manv = "+maNV+"";
            NhanVienDTO nv=new NhanVienDTO();
         
            PreparedStatement ps=con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                
                nv.setMaNV(rs.getInt(1)); 
                nv.setTenNV(rs.getString(2)); 
                nv.setSDT(rs.getInt(3)); 
                nv.setMatkhau(rs.getString(4)); 
                nv.setQuyenTruyCap(rs.getInt(5)); 
              
               
            }
                ps.close();
            rs.close();
            con.close();
            return nv;
       
         
            
            
        } catch (Exception e) {
            System.out.println("wdew");
        }
            return null;
        
    }
        
    public ArrayList<NhanVienDTO> TimNV_TheoTen(String tennv){
        try {
            Connection con=DBConnect.getConnection();
            String sql="select * from nhanvien where manv like '%"+tennv+"'%";
            ArrayList<NhanVienDTO> listNhanvien= new ArrayList<>();
            PreparedStatement ps=con.prepareCall(sql);ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienDTO hd=new NhanVienDTO();
                
                hd.setMaNV(rs.getInt(1)); 
                hd.setTenNV(rs.getString(2)); 
                hd.setSDT(rs.getInt(3)); 
                hd.setMatkhau(rs.getString(4)); 
                hd.setQuyenTruyCap(rs.getInt(5)); 
              
                listNhanvien.add(hd);
            }
            ps.close();
            rs.close();
            con.close();
         
            return listNhanvien;
            
        } catch (Exception e) {
        }
            return null;
        
    }

   
    public static int CreateOrUpdate(NhanVienDTO nhanVien) {
        try {
            Connection cons= DBConnect.getConnection();
            String sql="INSERT INTO nhanvien(MaNV, TenNV, SDT, MatKhau, QuyenTruyCap )  VALUES(?, ?, ?, ?, ?) ";
            sql+=" ON DUPLICATE KEY UPDATE TenNV= VALUES(TenNV), SDT= VALUES(SDT), MatKhau= VALUES(MatKhau), QuyenTruyCap= VALUES(QuyenTruyCap);";
            PreparedStatement ps=cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,nhanVien.getMaNV());
            ps.setString(2,nhanVien.getTenNV());
            ps.setLong(3,nhanVien.getSDT());
            ps.setString(4,nhanVien.getMatkhau());
            ps.setInt(5,nhanVien.getQuyenTruyCap());
            
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
              System.out.println("Loi iinsert update nhan vien ");
        }
        return 0;
    }
   
   
    
    public static void Delete(int MaNV){
        Connection cons = DBConnect.getConnection();
        String sql="DELETE FROM `nhanvien` WHERE `MaNV` = "+MaNV;
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi delete nhan vien ");
        }
      
        
    }
    
    public static void main(String[] args) {
        NhanVienDAO dao=new NhanVienDAO();
        System.out.println(dao.getlist());
        NhanVienDTO nv=new NhanVienDTO(3, "Nhan vien 3", 1234567891, "123", 1);
        dao.CreateOrUpdate(nv);
        System.out.println(dao.getlist());
        
    }
}
