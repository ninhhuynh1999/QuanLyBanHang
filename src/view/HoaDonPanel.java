/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;

import DAO.HoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import interfaces.InTroVe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import ultity.ClassTableModel;
import ultity.ConvertString;

/**
 *
 * @author ninhh
 */
public class HoaDonPanel extends javax.swing.JPanel implements InTroVe{
    private ChiTietHoaDonPanel chiTietHoaDonPanel;
    private  HoaDonDTO HoaDon_HienHanh;
    private  NhanVienDTO NhanVien_HienHanh;
    private  KhachHangDTO KhachHang_HienHanh;
    
    private ClassTableModel classTableModel = null;
    // private HoaDonDAO hoadonDAO=null;
     private String[] ListColum={"Mã Hóa Đơn","Ngày lập","Mã Nhân viên","Tổng tiền ","Mã Khách hàng ","Giảm giá","Số tiền thanh toán"};
     private TableRowSorter<TableModel> rowSorter=null;
     
     private ArrayList<HoaDonDTO> listItem= HoaDonDAO.getlist();
     private ArrayList<KhachHangDTO> DSKhachHang=new ArrayList<>();
     private ArrayList<NhanVienDTO> DSNhanVien=new ArrayList<>();
     
     private JTable table ;
     private String ThaoTac;
     
   
   
    public HoaDonPanel() {
        initComponents();
        
    
        
       
       // QLHoaDonController controller=new QLHoaDonController(this,pnRoot,pnView, cbTimkiem, txTiemkiem, dateNL, btSua, btThem, btXoa, btXemCTHD, cbMaKH, cbMaNV, txGiamGia, txMaHD, txThanhtOAN, txTongtien, btLuu, btHuy,chiTietHoaDonPanel);
               setView();
        setDataToTable();
        ChucNang();

        
        
        
        
        
     
       
       
        
    }
    
    public void setView(){
        this.btLuu.setVisible(false);
        this.btHuy.setVisible(false);
        this.classTableModel = new ClassTableModel();
       // this.hoadonDAO=new HoaDonDAO();
        
      DSKhachHang=KhachHangBUS.getList();
      DSNhanVien=NhanVienBUS.getList();
      
      //tạo jcombobox nhân viên kahch hàng
        for (KhachHangDTO khachhang : DSKhachHang) {
            cbMaKH.addItem(khachhang.getMaKH()+") "+ khachhang.getTenKH());
        }
        for (NhanVienDTO nhanvien : DSNhanVien) {
            cbMaNV.addItem(nhanvien.getMaNV()+") "+ nhanvien.getTenNV());
        }
//        cbMaKH.setEnabled(false);
//        cbMaNV.setEnabled(false);
        this.ThaoTac="";
         DisableEdit();
        
        
    }
     public void setDataToTable(){
         listItem= HoaDonDAO.getlist();
         setDataToTable(listItem);
     }
     
    public void setDataToTable(ArrayList<HoaDonDTO> listItem){
        
        // tạo dữ liệu trong table
         DefaultTableModel model = classTableModel.setTableHoaDon(listItem, ListColum);
          table = new JTable(model);
          rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
       //  table.setAutoCreateRowSorter(true);
         
         

         // Chọn vào table để hiện lện thông tin  
          table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                    @Override
                    public void valueChanged(ListSelectionEvent event) {
                       
                        int vitri=table.getSelectedRow();// lấy vị trí đang chọn
                        HoaDonDTO hoadon=new HoaDonDTO(listItem.get(vitri));
                        System.out.println(vitri);
                        
                        
                         HoaDon_HienHanh=new HoaDonDTO(hoadon);
                        
                        txMaHD.setText(""+HoaDon_HienHanh.getMaHD());
                        txGiamGia.setText(HoaDon_HienHanh.getGiamGia()+"");
                        txThanhtOAN.setText(""+HoaDon_HienHanh.getSoTienThanhToan());
                        txTongtien.setText(""+HoaDon_HienHanh.getTongTien());
                 
              
                        NhanVien_HienHanh=NhanVienBUS.getNV_TheoMa(HoaDon_HienHanh.getMaNV());
                        cbMaNV.setSelectedItem(NhanVien_HienHanh.getMaNV()+") "+NhanVien_HienHanh.getTenNV()); 
                      
                         KhachHang_HienHanh=KhachHangBUS.getKH_TheoMa(HoaDon_HienHanh.getMaNV());
                        cbMaKH.setSelectedItem(KhachHang_HienHanh.getMaKH()+") "+KhachHang_HienHanh.getTenKH());
                        dateNL.setDate(HoaDon_HienHanh.getNgayLap());
                 
                        
                    
                     }

            
            });
         // ket thuc phần chọn vao table
        
         
          table.getColumnModel().getColumn(0).setMinWidth(120);
       //  table.getColumnModel().getColumn(0).setMaxWidth(80);
         table.getColumnModel().getColumn(0).setPreferredWidth(80);
         
          table.getColumnModel().getColumn(1).setMinWidth(120);
      //   table.getColumnModel().getColumn(1).setMaxWidth(80);
         table.getColumnModel().getColumn(1).setPreferredWidth(80);
         
          table.getColumnModel().getColumn(2).setMinWidth(120);
         table.getColumnModel().getColumn(3).setMinWidth(120);
         
         
         
         table.setRowHeight(50);
         table.getTableHeader().setPreferredSize(new Dimension(100, 50));
         
         JScrollPane scrollpane=new JScrollPane();
         scrollpane.getViewport().add(table);
         scrollpane.setPreferredSize(new Dimension(1300, 400));
         
         
         pnView.removeAll();
         pnView.setLayout(new BorderLayout());
         pnView.add(scrollpane);
         pnView.validate();
         pnView.repaint();
         
     }
     public void DisableEdit(){
       
        this.dateNL.setEnabled(false);
        this.cbMaKH.setEnabled(false);
        this.cbMaNV.setEnabled(false);
        this.txGiamGia.setEditable(false);
        this.txMaHD.setEditable(false);
        this.txThanhtOAN.setEditable(false);
        this.txTongtien.setEditable(false);
      
        this.btLuu.setVisible(false);
        this.btHuy.setVisible(false);
     }
     public void EnableEdit(){
          this.dateNL.setEnabled(true);
        this.cbMaKH.setEnabled(true);
        this.cbMaNV.setEnabled(true);
        this.txGiamGia.setEditable(true);
        this.txMaHD.setEditable(true);
        this.txThanhtOAN.setEditable(true);
        this.txTongtien.setEditable(true);
       
        
        this.btLuu.setVisible(true);
        this.btHuy.setVisible(true);
     }
    
    
     public void ChucNang(){
         
         
         btXoa.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                int xacnhan =JOptionPane.showConfirmDialog(null, "Ban co muon xoa hoa don nay?"); //Thong báo xác nhận xóa
                    if(xacnhan==0){
                           try {
                         if(table.getSelectedRow() != -1 ){

                             HoaDonBUS.Delete(HoaDon_HienHanh.getMaHD());
                             setDataToTable();
                         }
                     } catch (Exception ex) {
                               System.out.println("e");
                     }
                    }
              
             }
             
         });
         
         btThem.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                EnableEdit();
                txGiamGia.setEditable(false);
                txTongtien.setEditable(false);
                txThanhtOAN.setEditable(false);
                txMaHD.setEditable(false);
//                txTongtien.setEditable(false);
//                txGiamGia.setEditable(false);
//                txThanhtOAN.setEditable(false);
                
                dateNL.setDate(null);
                cbMaNV.setSelectedItem(null);
                cbMaKH.setSelectedItem(null);
                txTongtien.setText("");
                txGiamGia.setText("");
                txThanhtOAN.setText("");
                txMaHD.setText((HoaDonBUS.MaSP_Max()+1)+"");
                table.setEnabled(false);
                  
                btThem.setEnabled(   false);
                btSua.setEnabled(   false);
                btXoa.setEnabled(   false);
                ThaoTac="Them";
                 
             }
         });
         btSua.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                
                  if(table.getSelectedRow() != -1){
                     EnableEdit();
                     
                     txMaHD.setEditable(false);
                     
                     txMaHD.setText(HoaDon_HienHanh.getMaHD()+"");
                     dateNL.setDate(HoaDon_HienHanh.getNgayLap());
                     cbMaNV.setSelectedItem(NhanVien_HienHanh.getMaNV()+") "+NhanVien_HienHanh.getTenNV());
                     cbMaKH.setSelectedItem(KhachHang_HienHanh.getMaKH()+") "+KhachHang_HienHanh.getTenKH());
                     txTongtien.setText(HoaDon_HienHanh.getTongTien()+"");
                     txGiamGia.setText(HoaDon_HienHanh.getGiamGia()+"");
                     txThanhtOAN.setText(HoaDon_HienHanh.getSoTienThanhToan()+"");
                     
                     
                     
                     table.setEnabled(false);

                     btThem.setEnabled(   false);
                     btSua.setEnabled(   false);
                     btXoa.setEnabled(   false);
                     
                     ThaoTac="Sua";
                  }
             }
         });
         btLuu.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                HoaDonDTO hoadon_sua=new HoaDonDTO();
                int tongtien=0;
                int thanhtoan=0;
                int giamgia=0;
                 try {
                       tongtien=Integer.parseInt(txTongtien.getText());
                 thanhtoan=Integer.parseInt(txThanhtOAN.getText());
                 giamgia=Integer.parseInt(txGiamGia.getText());
                 } catch (Exception ex) {
                     System.out.println("loi nul");
                 }
                int mahd=Integer.parseInt(txMaHD.getText());
               
                
                int makh=ConvertString.getNumbers((String) cbMaKH.getSelectedItem());
                int manv=ConvertString.getNumbers((String) cbMaNV.getSelectedItem());
                
                //lấy dữ liệu ngày
                 DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                 String ngaylap=df.format(dateNL.getDate());
                  Date date=Date.valueOf(ngaylap);
                  
                  
               //  System.out.println(ngaylap);
                hoadon_sua.setMaHD(mahd); 
                hoadon_sua.setNgayLap( date);
                hoadon_sua.setMaNV(manv);
                hoadon_sua.setTongTien(tongtien);
                hoadon_sua.setMaKH(makh);
                hoadon_sua.setGiamGia(giamgia);
                hoadon_sua.setSoTienThanhToan(thanhtoan);
                
            
            
                if(ThaoTac=="Sua"){
                    HoaDonBUS.SuaHD(hoadon_sua);
                    ThaoTac="";
                }    
                if(ThaoTac=="Them"){
                    HoaDonBUS.ThemHD(hoadon_sua);
                    ThaoTac="";
                }    
                DisableEdit();
                 table.setEnabled(false);
                  
                btSua.setEnabled(   true);
                    
                
               
                btThem.setEnabled(   true);
                btSua.setEnabled(   true);
                btXoa.setEnabled(   true);
                
                setDataToTable();
             }
         });
         btHuy.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                  DisableEdit();
                 table.setEnabled(false);
                  
                btSua.setEnabled(   true);
                    
                
               
                btThem.setEnabled(   true);
                btSua.setEnabled(   true);
                btXoa.setEnabled(   true);
                setDataToTable();
             }
         });
         
          btXemCTHD.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getSelectedRow() != -1){
                   
                    XemChiTietHoaDon(HoaDon_HienHanh.getMaHD());
                }
           
            }
        });
          btTimKiem.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 String TimCaigi=(String) cbTimkiem.getSelectedItem();
                 String noidung=txTimkiem.getText();
                 if(TimCaigi=="Chung"){
                     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ noidung));
                 }else{
                     setDataToTable(HoaDonBUS.TimKiemChung(TimCaigi, noidung));
                 }
             }
         });
         
          
          txTimkiem.getDocument().addDocumentListener(new DocumentListener() {

             @Override
             public void insertUpdate(DocumentEvent e) {
                 String text=txTimkiem.getText();
                 if(text.trim().length()==0){
                     setDataToTable(listItem);
                     
                 }else{
//                     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text));
                 }
             
             }
            

             @Override
             public void removeUpdate(DocumentEvent e) {
                 String text=txTimkiem.getText();
                 if(text.trim().length()==0){
                    setDataToTable(listItem);
                     
                 }else{
//                     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text));
                 }
             }

             @Override
             public void changedUpdate(DocumentEvent e) {
                 
             }
         });
         
         
         
     }
      public void XemChiTietHoaDon(int mahd){
                    chiTietHoaDonPanel=new ChiTietHoaDonPanel(mahd,this);
                    chiTietHoaDonPanel.setBounds(0, 0, 1010, 750);
        
       
                    add(chiTietHoaDonPanel);
                     pnRoot.setVisible(false);
                     chiTietHoaDonPanel.setVisible(true);
                    validate();
                    revalidate();
                    repaint();
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRoot = new javax.swing.JPanel();
        pnChucnang = new javax.swing.JPanel();
        btSua = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btXemCTHD = new javax.swing.JButton();
        pnView = new javax.swing.JPanel();
        PnThongtin = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        txMaHD = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        dateNL = new com.toedter.calendar.JDateChooser();
        cbMaNV = new javax.swing.JComboBox();
        txTongtien = new javax.swing.JTextField();
        cbMaKH = new javax.swing.JComboBox();
        txGiamGia = new javax.swing.JTextField();
        txThanhtOAN = new javax.swing.JTextField();
        btLuu = new javax.swing.JButton();
        btHuy = new javax.swing.JButton();
        pnTimkiem = new javax.swing.JPanel();
        txTimkiem = new javax.swing.JTextField();
        cbTimkiem = new javax.swing.JComboBox();
        btTimKiem = new javax.swing.JButton();

        pnRoot.setBackground(new java.awt.Color(255, 255, 255));
        pnRoot.setPreferredSize(new java.awt.Dimension(930, 592));

        pnChucnang.setBackground(new java.awt.Color(255, 255, 255));
        pnChucnang.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        btSua.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btSua.setText("Sửa Thông tin");
        btSua.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btThem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btThem.setText("Tạo hóa đơn");
        btThem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btXoa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btXoa.setText("Xóa hóa Đơn");
        btXoa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btXemCTHD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btXemCTHD.setText("Xem CTHD");
        btXemCTHD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnChucnangLayout = new javax.swing.GroupLayout(pnChucnang);
        pnChucnang.setLayout(pnChucnangLayout);
        pnChucnangLayout.setHorizontalGroup(
            pnChucnangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChucnangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnChucnangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btXemCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnChucnangLayout.setVerticalGroup(
            pnChucnangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChucnangLayout.createSequentialGroup()
                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btXemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnView.setBackground(new java.awt.Color(255, 255, 255));
        pnView.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Danh sách Đơn hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        pnView.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pnView.setPreferredSize(new java.awt.Dimension(0, 263));

        javax.swing.GroupLayout pnViewLayout = new javax.swing.GroupLayout(pnView);
        pnView.setLayout(pnViewLayout);
        pnViewLayout.setHorizontalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1051, Short.MAX_VALUE)
        );
        pnViewLayout.setVerticalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        PnThongtin.setBackground(new java.awt.Color(255, 255, 255));
        PnThongtin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thông tin Hóa đơn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel100.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel100.setText("  Mã Hóa Đơn");
        jLabel100.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 102), new java.awt.Color(0, 153, 204)));

        jLabel101.setBackground(new java.awt.Color(255, 255, 255));
        jLabel101.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel101.setText("  Ngày lập");
        jLabel101.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 102), new java.awt.Color(0, 204, 204)));

        jLabel102.setBackground(new java.awt.Color(255, 255, 255));
        jLabel102.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel102.setText("  Mã Nhân viên");
        jLabel102.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 102), new java.awt.Color(0, 204, 255)));

        jLabel103.setBackground(new java.awt.Color(255, 255, 255));
        jLabel103.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel103.setText("  Tổng tiền");
        jLabel103.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 102), new java.awt.Color(0, 204, 255)));

        jLabel104.setBackground(new java.awt.Color(255, 255, 255));
        jLabel104.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel104.setText(" Giảm Giá ");
        jLabel104.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 153), new java.awt.Color(0, 204, 204)));

        jLabel105.setBackground(new java.awt.Color(255, 255, 255));
        jLabel105.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel105.setText(" Mã Khách Hàng");
        jLabel105.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 153), new java.awt.Color(0, 204, 204)));

        jLabel106.setBackground(new java.awt.Color(255, 255, 255));
        jLabel106.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel106.setText(" Số tiền thanh toán");
        jLabel106.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 153), new java.awt.Color(0, 204, 204)));

        dateNL.setDateFormatString("yyyy-MM-dd");

        btLuu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btLuu.setText("Lưu");
        btLuu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btHuy.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btHuy.setText("Hủy");
        btHuy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PnThongtinLayout = new javax.swing.GroupLayout(PnThongtin);
        PnThongtin.setLayout(PnThongtinLayout);
        PnThongtinLayout.setHorizontalGroup(
            PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnThongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PnThongtinLayout.createSequentialGroup()
                        .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateNL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnThongtinLayout.createSequentialGroup()
                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txTongtien)))
                .addGap(110, 110, 110)
                .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PnThongtinLayout.createSequentialGroup()
                        .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txGiamGia))
                    .addGroup(PnThongtinLayout.createSequentialGroup()
                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnThongtinLayout.createSequentialGroup()
                        .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txThanhtOAN)
                            .addGroup(PnThongtinLayout.createSequentialGroup()
                                .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnThongtinLayout.setVerticalGroup(
            PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnThongtinLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnThongtinLayout.createSequentialGroup()
                        .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnThongtinLayout.createSequentialGroup()
                                .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txMaHD)
                                        .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(cbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PnThongtinLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dateNL, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnThongtinLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txThanhtOAN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGroup(PnThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txTongtien, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(btLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnTimkiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txTimkiem.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txTimkiem.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 204, 0), new java.awt.Color(102, 102, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 153), new java.awt.Color(0, 0, 102))));

        cbTimkiem.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        cbTimkiem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chung", "Mã hóa đơn", "Ngày lập", "Mã nhân viên", "Tổng tiền", "Mã khách hàng", "Giảm giá", "Thanh Toán" }));
        cbTimkiem.setBorder(new javax.swing.border.MatteBorder(null));

        btTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btTimKiem.setText("Tìm kiếm");
        btTimKiem.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, java.awt.Color.black)));

        javax.swing.GroupLayout pnTimkiemLayout = new javax.swing.GroupLayout(pnTimkiem);
        pnTimkiem.setLayout(pnTimkiemLayout);
        pnTimkiemLayout.setHorizontalGroup(
            pnTimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimkiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnTimkiemLayout.setVerticalGroup(
            pnTimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimkiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTimkiemLayout.createSequentialGroup()
                        .addComponent(txTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(pnTimkiemLayout.createSequentialGroup()
                        .addGroup(pnTimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbTimkiem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRootLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnRootLayout.createSequentialGroup()
                                .addComponent(PnThongtin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(pnChucnang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnRootLayout.createSequentialGroup()
                                .addComponent(pnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 602, Short.MAX_VALUE))))
                    .addGroup(pnRootLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnChucnang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnThongtin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(pnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnThongtin;
    private javax.swing.JButton btHuy;
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXemCTHD;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox cbMaKH;
    private javax.swing.JComboBox cbMaNV;
    private javax.swing.JComboBox cbTimkiem;
    private com.toedter.calendar.JDateChooser dateNL;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JPanel pnChucnang;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JPanel pnTimkiem;
    private javax.swing.JPanel pnView;
    private javax.swing.JTextField txGiamGia;
    private javax.swing.JTextField txMaHD;
    private javax.swing.JTextField txThanhtOAN;
    private javax.swing.JTextField txTimkiem;
    private javax.swing.JTextField txTongtien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void trove() {
        pnRoot.setVisible(true);
        chiTietHoaDonPanel.setVisible(false);
    }
}
