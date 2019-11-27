/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ninhh
 */
public class HoaDonDAO {
     public static ArrayList<HoaDonDTO> getlist() {
       
        try {
         
             Connection cons= DBConnect.getConnection();
        String sql="select * from hoadon";
        
        
        
        ArrayList<HoaDonDTO> listDonHang= new ArrayList<>();
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonDTO hd=new  HoaDonDTO();
                
                hd.setMaHD(rs.getInt(1)); 
                hd.setMaNV(rs.getInt(3)); 
                hd.setNgayLap(rs.getDate(2)); 
                hd.setMaKH(rs.getInt(5)); 
                hd.setTongTien(rs.getInt(4)); 
                hd.setGiamGia(rs.getInt(6));
                hd.setSoTienThanhToan(rs.getInt(7));
                listDonHang.add(hd);
            }
            ps.close();
            rs.close();
            cons.close();
         
            return listDonHang;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi hoa don");
        }
        return null;
    }
     
      public  static  ArrayList<HoaDonDTO> TimKiemChung(String TimCaiGi,String noidung) {

//          Chung
//        Mã hóa đơn
//        Ngày lập
//        Mã nhân viên
//        Tổng tiền
//        Mã khách hàng
//        Giảm giá
        String sql="SELECT * FROM `hoadon` WHERE 1";
        if(TimCaiGi.equals("Mã hóa đơn ")){
            sql="SELECT * FROM `hoadon` WHERE MaHD like '%"+noidung+"%' ORDER BY MaHD ASC";
        }
        if(TimCaiGi.equals("Ngày lập")){
            sql="SELECT * FROM `hoadon` WHERE NgayLap like '%"+noidung+"%' ORDER BY NgayLap ASC";
        }
        if(TimCaiGi.equals("Mã nhân viên")){
            sql="SELECT * FROM `hoadon` WHERE MaNV like '%"+noidung+"%' ORDER BY MaNV ASC";
        }
        if(TimCaiGi.equals("Tổng tiền")){
            sql="SELECT * FROM `hoadon` WHERE TongTien like '%"+noidung+"%' ORDER BY TongTien ASC";
        }
        if(TimCaiGi.equals("Mã khách hàng")){
            sql="SELECT * FROM `hoadon` WHERE MaKH like '%"+noidung+"%' ORDER BY MaKH ASC";
        }
        if(TimCaiGi.equals("Giảm giá")){
            sql="SELECT * FROM `hoadon` WHERE GiamGia like '%"+noidung+"%' ORDER BY GiamGia ASC";
        }
        if(TimCaiGi.equals("Thanh Toán")){
            sql="SELECT * FROM `hoadon` WHERE SoTienThanhToan like '%"+noidung+"%' ORDER BY SoTienThanhToan ASC";
        }
        
       

        Connection cons= DBConnect.getConnection();
       
        ArrayList<HoaDonDTO> list= new ArrayList<>();
        try {
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                   HoaDonDTO hd=new  HoaDonDTO();
              hd.setMaHD(rs.getInt(1)); 
                hd.setMaNV(rs.getInt(3)); 
                hd.setNgayLap(rs.getDate(2)); 
                hd.setMaKH(rs.getInt(5)); 
                hd.setTongTien(rs.getInt(4)); 
                hd.setGiamGia(rs.getInt(6));
                hd.setSoTienThanhToan(rs.getInt(7));
                list.add(hd);
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
    

   
    public static int CreateOrUpdate(HoaDonDTO hoadon) {
        try {
            Connection cons= DBConnect.getConnection();
            String sql="INSERT INTO hoadon(MaHD, NgayLap, MaNV, TongTIen, MaKH, GiamGia , SoTienThanhToan )  VALUES(?, ?, ?, ?, ?, ?, ?) ";
            sql+=" ON DUPLICATE KEY UPDATE NgayLap= VALUES(NgayLap), MaNV= VALUES(MaNV), TongTIen= VALUES(TongTIen), MaKH= VALUES(MaKH), GiamGia=VALUES(GiamGia), SoTienThanhToan=VALUES(SoTienThanhToan);";
            PreparedStatement ps=cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,hoadon.getMaHD());
            ps.setDate(2, (Date) hoadon.getNgayLap());
            ps.setInt(3,hoadon.getMaNV());
            ps.setInt(4,hoadon.getTongTien());
            ps.setInt(5,hoadon.getMaKH());
            ps.setInt(6,hoadon.getGiamGia());
            ps.setInt(7,hoadon.getSoTienThanhToan());
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
              System.out.println("Loi insert ỏ update hoa don ");
        }
        return 0;
    }
    public static void Delete(int MaHD){
        Connection cons = DBConnect.getConnection();
        String sql="DELETE FROM `hoadon` WHERE `MaHD` = "+MaHD;
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi delete hoa don ");
        }
      
        
    }
    public static void themHD(HoaDonDTO hd) {
           // create the mysql insert preparedstatement
           ArrayList<HoaDonDTO> arr =getlist();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaHD()==hd.getMaHD()){
                   System.out.println("Ma hoa don da ton tai");
                   return;
               }
        }
      String sql = "insert into hoadon (MaHD, NgayLap, MaNV, TongTIen, MaKH, GiamGia , SoTienThanhToan ) values (?,?,?,?,?,?,?)";
   
     
        try {
              Connection cons= DBConnect.getConnection();
              PreparedStatement ps = cons.prepareCall(sql);
               ps.setInt(1,hd.getMaHD());
            ps.setDate(2, hd.getNgayLap());
            ps.setInt(3,hd.getMaNV());
            ps.setInt(4,hd.getTongTien());
            ps.setInt(5,hd.getMaKH());
            ps.setInt(6,hd.getGiamGia());
            ps.setInt(7,hd.getSoTienThanhToan());
            ps.execute();
             ps.close();
            cons.close();
              
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
     
      public static  void SuaHD(HoaDonDTO hd){
        Connection cons = DBConnect.getConnection();
       String sql = "UPDATE hoadon SET NgayLap=?, MaNV = ?, TongTien = ?,MaKH= ?,GiamGia = ?, SoTienThanhToan = ? WHERE MaHD = ?";
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 
                   
                    ps.setDate(1,hd.getNgayLap());
                    ps.setInt(2,hd.getMaNV());
                    ps.setInt(3,hd.getTongTien());
                    ps.setInt(4,hd.getMaKH());
                    ps.setInt(5,hd.getGiamGia());
                    ps.setInt(6,hd.getSoTienThanhToan());
                     ps.setInt(7, hd.getMaHD());
                 ps.execute();
                  ps.close();
            cons.close();
        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Loi update hoa don ");
        }
      
        
    }
    public static  void SuaHD_TongTien(int MaHD,int TongTien){
        Connection cons = DBConnect.getConnection();
       String sql = "UPDATE hoadon SET TongTien = ? WHERE MaHD = ?";
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 
                   
                    ps.setInt(1,TongTien);
                    ps.setInt(2,MaHD);
                   
                 ps.execute();
                  ps.close();
            cons.close();
        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Loi update hoa don TongTien ");
        }
      
        
    }
    
    
    
    
    //Ham này test ko quan trong
    public static void main(String[] args) throws ParseException {
//    String str="2015-03-31";  
//    Date date=Date.valueOf(str);//converting string into sql date  
//    System.out.println(date);  
 //       HoaDonDTO hoaDon=new HoaDonDTO(5,  date, 1, 2, 35000, 0, 35000);
        HoaDonDAO dao=new HoaDonDAO();
 //      dao.CreateOrUpdate(hoaDon);
        System.out.println(dao.getlist());
        dao.SuaHD_TongTien(1, 12);
        System.out.println(dao.getlist());
       
    }
}
