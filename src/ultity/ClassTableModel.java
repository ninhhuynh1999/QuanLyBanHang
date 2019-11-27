/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultity;

import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.PhieuNhapDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author ninhh
 */
public class ClassTableModel {
    public  DefaultTableModel setTableSanPham(ArrayList<SanPhamDTO> listItem,String[] ListColum ){
        DefaultTableModel dtm=new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                    return false; //To change body of generated methods, choose Tools | Templates.
            }
//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                return columnIndex== 7 ? boolean.class : String.class;
//                
//            }

        };
        dtm.setColumnIdentifiers(ListColum);
        int colums=ListColum.length;
        Object[] obj=null;
        int rows=listItem.size();
        if(rows>0){
            for (int i = 0; i < rows; i++) {
                SanPhamDTO sp=listItem.get(i);
                obj=new Object[colums];
                obj[0]=sp.getMa_SP();
                obj[1]=sp.getTen_SP();
                obj[2]=sp.getSoluong();
                obj[3]=sp.getGia();
                obj[4]=sp.getMaTheLoai();
                obj[5]=sp.getMaNCC();
           //     obj[6]=sp.getTinhTrang();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
    public DefaultTableModel setTableHoaDon(ArrayList<HoaDonDTO> listItem, String[] listColum  ){
        DefaultTableModel dtm=new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColum);
        int colums=listColum.length;
        Object[] obj=null;
        int rows=listItem.size();
        if(rows>0){
            for (int i = 0; i < rows; i++) {
                HoaDonDTO hoadon=listItem.get(i);
                 obj=new Object[colums];
                obj[0]=hoadon.getMaHD();
                obj[1]=hoadon.getNgayLap();
                obj[2]=hoadon.getMaNV();
                obj[3]=hoadon.getTongTien();
                obj[4]=hoadon.getMaKH();
                obj[5]=hoadon.getGiamGia();
                obj[6]=hoadon.getSoTienThanhToan();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
    
     public DefaultTableModel setTablePhieuNhap(ArrayList<PhieuNhapDTO> listItem, String[] listColum  ){
        DefaultTableModel dtm=new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColum);
        int colums=listColum.length;
        Object[] obj=null;
        int rows=listItem.size();
        if(rows>0){
            for (int i = 0; i < rows; i++) {
                PhieuNhapDTO phieunhap=listItem.get(i);
                 obj=new Object[colums];
                obj[0]=phieunhap.getMaphieunhap();
                obj[1]=phieunhap.getNgaylap();
                obj[2]=phieunhap.getManv();
                obj[3]=phieunhap.getTongtien();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
     
     public DefaultTableModel setTableChiTietHoaDon(ArrayList<ChiTietHoaDonDTO> listItem, String[] listColum  ){
        DefaultTableModel dtm=new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColum);
        int colums=listColum.length;
        Object[] obj=null;
        int rows=listItem.size();
        if(rows>0){
            for (int i = 0; i < rows; i++) {
                ChiTietHoaDonDTO chitiethoadon=listItem.get(i);
                obj=new Object[colums];
                obj[0]=chitiethoadon.getMaCTHD();
                obj[1]=chitiethoadon.getMaHD();
                obj[2]=chitiethoadon.getMaSP();
                obj[3]=chitiethoadon.getSL();
                obj[4]=chitiethoadon.getDongia();
                obj[5]=chitiethoadon.getThanhtien();
              
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
     
}
