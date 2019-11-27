
package BUS;


import DAO.SanPhamDAO;
import DAO.SanPhamDAO;
import java.util.List;
import DTO.SanPhamDTO;
import java.util.ArrayList;


public class SanPhamBUS {
//    private SanPhamDAO spDAO=null;
//
//        public SanPhamBUSImpl() {
//          spDAO=new SanPhamDAO();
//    }
    
    
    
    public static ArrayList<SanPhamDTO> getList() {
      return SanPhamDAO.getlist();
    }
     public  static  ArrayList<String> getColumnName() {
         return SanPhamDAO.getColumnName();
    }
    public  static  ArrayList<SanPhamDTO> TimKiemChung(String TimCaiGi,String noidung) {
//       Mã sản phẩm
//  Tên sản phẩm
//  Số lượng
//  Giá
//  Thể loại
//  Nhà cung cấp 
        return SanPhamDAO.TimKiemChung(TimCaiGi, noidung);
    }
    
    
    
    
    
    

    public static int createOrUpdate(SanPhamDTO sanpham) {
     return SanPhamDAO.CreateOrUpdate(sanpham);
    }
    public static void Delete (int MaSP){
        SanPhamDAO.Delete(MaSP);
    }
    public static int MaSP_Max(){
        int max=0;
        ArrayList<SanPhamDTO> sp= getList();
        for (SanPhamDTO sp1 : sp) {
            if(sp1.getMa_SP()>max) {
                max=sp1.getMa_SP();
            }
        }
        return max;
    }
    public static SanPhamDTO getSP_TheoMa(int MaSP){
         ArrayList<SanPhamDTO> sp= getList();
        for (SanPhamDTO sp1 : sp) {
            if(sp1.getMa_SP() == MaSP) {
              return sp1;
            }
        }
        return null;
    }
     public static  void SuaSP(SanPhamDTO sp){
         SanPhamDAO.SuaSP(sp);
     }
     public static  void themSP(SanPhamDTO sp){
         SanPhamDAO.themSP(sp);
     }
    
}
