
package DAO;

import com.mysql.jdbc.ResultSetRow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.SanPhamDTO;
import java.sql.Date;

public class SanPhamDAO {
     

   
    public  static  ArrayList<SanPhamDTO> getlist() {
        Connection cons= DBConnect.getConnection();
        String sql="select * from SanPham ";
        ArrayList<SanPhamDTO> list= new ArrayList<>();
        try {
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                SanPhamDTO sp=new  SanPhamDTO();
                sp.setMa_SP(rs.getInt(1)); 
                sp.setTen_SP(rs.getString(2)); 
                sp.setSoluong(rs.getInt(3)); 
                sp.setGia(rs.getInt(4)); 
                sp.setMaTheLoai(rs.getInt(5)); 
                sp.setMaNCC(rs.getInt(6)); 
              //  sp.setTinhTrang(rs.getBoolean(7)); 
                list.add(sp);
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
    public  static  ArrayList<String> getColumnName() {
        Connection cons= DBConnect.getConnection();
        String sql="SHOW COLUMNS FROM `sanpham` WHERE 1";
        ArrayList<String> list= new ArrayList<>();
        try {
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
             
                list.add(rs.getString(1));
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
    public  static  ArrayList<SanPhamDTO> TimKiemChung(String TimCaiGi,String noidung) {
//       Mã sản phẩm
//  Tên sản phẩm
//  Số lượng
//  Giá
//  Thể loại
//  Nhà cung cấp 
        String sql="SELECT * FROM `sanpham` WHERE 1";
        if(TimCaiGi.equals("Mã sản phẩm")){
            sql="SELECT * FROM `sanpham` WHERE MaSP like '%"+noidung+"%' ORDER BY MaSP ASC";
        }
        if(TimCaiGi.equals("Tên sản phẩm")){
            sql="SELECT * FROM `sanpham` WHERE TenSP like '%"+noidung+"%' ORDER BY TenSP ASC";
        }
        if(TimCaiGi.equals("Số lượng")){
            sql="SELECT * FROM `sanpham` WHERE SoLuong like '%"+noidung+"%' ORDER BY SoLuong ASC";
        }
        if(TimCaiGi.equals("Giá")){
            sql="SELECT * FROM `sanpham` WHERE DonGia like '%"+noidung+"%' ORDER BY DonGia ASC";
        }
        if(TimCaiGi.equals("Thể loại")){
            sql="SELECT * FROM `sanpham` WHERE MaTheLoai like '%"+noidung+"%' ORDER BY MaTheLoai ASC";
        }
        if(TimCaiGi.equals("Nhà cung cấp")){
            sql="SELECT * FROM `sanpham` WHERE MaNCC like '%"+noidung+"%' ORDER BY MaNCC ASC";
        }
       

        Connection cons= DBConnect.getConnection();
       
        ArrayList<SanPhamDTO> list= new ArrayList<>();
        try {
            PreparedStatement ps= cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                SanPhamDTO sp=new  SanPhamDTO();
                sp.setMa_SP(rs.getInt(1)); 
                sp.setTen_SP(rs.getString(2)); 
                sp.setSoluong(rs.getInt(3)); 
                sp.setGia(rs.getInt(4)); 
                sp.setMaTheLoai(rs.getInt(5)); 
                sp.setMaNCC(rs.getInt(6)); 
              //  sp.setTinhTrang(rs.getBoolean(7)); 
                list.add(sp);
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
    

    
    public static  int CreateOrUpdate(SanPhamDTO sanpham) {
        try {
            Connection cons= DBConnect.getConnection();
            String sql="INSERT INTO sanpham(MaSP, TenSP, SoLuong, DonGia, MaTheLoai, MaNCC, TinhTrang)  VALUES(?, ?, ?, ?, ?, ?, ?) ";
            sql+=" ON DUPLICATE KEY UPDATE TenSP= VALUES(TenSP), SoLuong= VALUES(SoLuong), DonGia= VALUES(DonGia), MaTheLoai= VALUES(MaTheLoai), MaNCC=VALUES(MaNCC), TinhTrang=VALUES(TinhTrang);";
            PreparedStatement ps=cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,sanpham.getMa_SP());
            ps.setString(2, sanpham.getTen_SP());
            ps.setInt(3,sanpham.getSoluong());
            ps.setInt(4,sanpham.getGia());
            ps.setInt(5,sanpham.getMaTheLoai());
            ps.setInt(6,sanpham.getMaNCC());
          
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
              System.out.println("Loi insret update  san pham ");
        }
        return -1;
    }
      public static void themSP(SanPhamDTO sp) {
           // create the mysql insert preparedstatement
           ArrayList<SanPhamDTO> arr =getlist();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMa_SP()==sp.getMa_SP()){
                   System.out.println("Ma san pham ton tai");
                   return;
               }
        }
      String sql = "insert into sanpham ( MaSP , TenSP , SoLuong , DonGia , MaTheLoai , MaNCC ) values (?,?,?,?,?,?)";
   
     
        try {
              Connection cons= DBConnect.getConnection();
              PreparedStatement ps = cons.prepareCall(sql);
               ps.setInt(1,sp.getMa_SP());
            ps.setString(2, sp.getTen_SP());
            ps.setInt(3,sp.getSoluong());
            ps.setInt(4,sp.getGia());
            ps.setInt(5,sp.getMaTheLoai());
            ps.setInt(6,sp.getMaNCC());
          
            ps.execute();
               ps.close();
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
     
      public static  void SuaSP(SanPhamDTO sp){
       String sql = "UPDATE sanpham SET TenSP = ? , SoLuong = ? , DonGia = ? , MaTheLoai = ?, MaNCC = ? WHERE MaSp = ? ";
        try {
                    Connection cons = DBConnect.getConnection();

                  PreparedStatement ps = cons.prepareStatement(sql);
                  //  System.out.println(sp.getMa_SP());
                    ps.setString(1, sp.getTen_SP());
                    ps.setInt(2,sp.getSoluong());
                    ps.setInt(3,sp.getGia());
                    ps.setInt(4,sp.getMaTheLoai());
                    ps.setInt(5,sp.getMaNCC());
                   
                    ps.setInt(6,sp.getMa_SP());
                  //  System.out.println(sql);
                   ps.execute();
               //  System.out.println(ps.toString());
                    ps.close();
            cons.close();
        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Loi update san pham ");
        }
      
        
    }
    
    
    
    
    
     public static  void Delete(int MaSP){
        Connection cons = DBConnect.getConnection();
        String sql="DELETE FROM `sanpham` WHERE `MaSP` = "+MaSP;
        try {
                 PreparedStatement ps= cons.prepareStatement(sql);
                 ps.executeUpdate(sql);
                  ps.close();
            cons.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi delete san pham ");
            
        }
      
        
    }

    
    
    
    public static void main(String[] args) {
//        SanPhamDAO spp=new SanPhamDAO();
//       SanPhamDTO sp=new SanPhamDTO();
//       sp.setMa_SP(1);
//       sp.setTen_SP("12344");
//       sp.setSoluong(1);
//       sp.setGia(1);
//       sp.setMaTheLoai(1);
//       sp.setMaNCC(1);
//       spp.SuaSP(sp);
//       Connection con = DBConnect.getConnection();
//        try {
//            PreparedStatement ps= con.prepareStatement("UPDATE sanpham SET TenSP = 'Leo Tolstoy' WHERE MaSP = 1");
//            ps.executeQuery();
//        } catch (SQLException ex) {
//            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
       SanPhamDAO dao=new SanPhamDAO();
       ArrayList<SanPhamDTO> sp=dao.TimKiemChung("Mã sản phẩm", "142r");
        System.out.println(sp.size());
    }

}
