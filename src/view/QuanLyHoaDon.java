/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import ultity.ClassTableModel;

/**
 *
 * @author ninhh
 */
public class QuanLyHoaDon extends javax.swing.JPanel {

    private JTable table_HD = new JTable();
    private JTable table_CTHD = new JTable();
    private ClassTableModel classTableModel;
    private TableRowSorter<TableModel> rowSorter_HD = null;
    private TableRowSorter<TableModel> rowSorter_CTHD = null;

    private ArrayList<ChiTietHoaDonDTO> listItem_CTHD;
    private ArrayList<HoaDonDTO> listItem_HD;
    private ChiTietHoaDonDTO CTHD_HienHanh = new ChiTietHoaDonDTO();
    private HoaDonDTO HoaDon_Hienhanh;
    private SanPhamDTO SanPham_HienHanh;
    private String ThaoTac;

    public QuanLyHoaDon() {
        listItem_CTHD=ChiTietHoaDonBUS.getlist();
        listItem_HD=HoaDonBUS.getList();
        initComponents();
        setDataTable(listItem_HD, listItem_CTHD);
    }

    public void setDataTable(ArrayList<HoaDonDTO> listHD, ArrayList<ChiTietHoaDonDTO> listCTHD) {
        classTableModel=new ClassTableModel();
        String[] ListColum_HD =   {"Mã Hóa Đơn", "Ngày lập", "Mã Nhân viên", "Tổng tiền ", "Mã Khách hàng ", "Giảm giá", "Số tiền thanh toán"};
        String[] ListColum_CTHD = {"Mã CTDH", "Mã đon hàng", "Mã sản phẩm", "Số lượng ", "Đơn giá  ", "Thành tiền"};
        //hoa don
         DefaultTableModel model_HD = classTableModel.setTableHoaDon(listHD, ListColum_HD);
          table_HD = new JTable(model_HD);
          rowSorter_HD = new TableRowSorter<>(table_HD.getModel());
          table_HD.setRowSorter(rowSorter_HD);
        //cthd  
   
          DefaultTableModel model_CTHD = classTableModel.setTableChiTietHoaDon(listCTHD, ListColum_CTHD);
   
        DefaultTableModel model = classTableModel.setTableChiTietHoaDon(listCTHD, ListColum_CTHD);
        table_CTHD = new JTable(model);
        rowSorter_CTHD=new TableRowSorter<>(table_CTHD.getModel());
        table_CTHD.setRowSorter(rowSorter_CTHD);
        
        
        //hoa don
        table_HD.setRowHeight(50);
        table_HD.getTableHeader().setReorderingAllowed(false);
        table_HD.getTableHeader().setPreferredSize(new Dimension(30 , 50));
                 table_HD.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));

         
         JScrollPane scrollpane_HD=new JScrollPane();
         scrollpane_HD.getViewport().add(table_HD);
         scrollpane_HD.setPreferredSize(new Dimension(800, 300));
         
         
         pnHoaDon.removeAll();
         pnHoaDon.setLayout(new BorderLayout());
         pnHoaDon.add(scrollpane_HD);
         pnHoaDon.validate();
         pnHoaDon.repaint();
         
         
         //cthd
         table_CTHD.setRowHeight(50);
         table_CTHD.getTableHeader().setReorderingAllowed(false);
         table_CTHD.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
        table_CTHD.getTableHeader().setPreferredSize(new Dimension(30, 50));
        
    

        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(table_CTHD);
        scrollpane.setPreferredSize(new Dimension(700,200));
        
        pnCTHD.removeAll();
        pnCTHD.setLayout(new BorderLayout());
        pnCTHD.add(scrollpane);
        pnCTHD.validate();

        pnCTHD.repaint();
        
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRoot = new javax.swing.JPanel();
        pnHoaDon = new javax.swing.JPanel();
        pnCTHD = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btSua_1 = new javax.swing.JButton();
        btThem_1 = new javax.swing.JButton();
        btXoa_1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btSua_2 = new javax.swing.JButton();
        btThem_2 = new javax.swing.JButton();
        btXoa_2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        pnRoot.setBackground(new java.awt.Color(255, 255, 255));

        pnHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        javax.swing.GroupLayout pnHoaDonLayout = new javax.swing.GroupLayout(pnHoaDon);
        pnHoaDon.setLayout(pnHoaDonLayout);
        pnHoaDonLayout.setHorizontalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
        );
        pnHoaDonLayout.setVerticalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pnCTHD.setBackground(new java.awt.Color(255, 255, 255));
        pnCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        javax.swing.GroupLayout pnCTHDLayout = new javax.swing.GroupLayout(pnCTHD);
        pnCTHD.setLayout(pnCTHDLayout);
        pnCTHDLayout.setHorizontalGroup(
            pnCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnCTHDLayout.setVerticalGroup(
            pnCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btSua_1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btSua_1.setText("Sửa");

        btThem_1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btThem_1.setText("Thêm");

        btXoa_1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btXoa_1.setText("Xóa");

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jButton7.setText("jButton7");

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jButton8.setText("jButton8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoa_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThem_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSua_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btSua_1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btThem_1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btXoa_1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btSua_2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btSua_2.setText("Sửa");

        btThem_2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btThem_2.setText("Thêm");

        btXoa_2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btXoa_2.setText("Xóa");

        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jButton9.setText("jButton9");

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jButton10.setText("jButton10");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoa_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThem_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSua_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btSua_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btThem_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btXoa_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCTHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua_1;
    private javax.swing.JButton btSua_2;
    private javax.swing.JButton btThem_1;
    private javax.swing.JButton btThem_2;
    private javax.swing.JButton btXoa_1;
    private javax.swing.JButton btXoa_2;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel pnCTHD;
    private javax.swing.JPanel pnHoaDon;
    private javax.swing.JPanel pnRoot;
    // End of variables declaration//GEN-END:variables
}
