/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 
import BUS.NhaCungCapBUS;
import BUS.SanPhamBUS;
import BUS.SanPhamBUS;
import BUS.TheLoaiBUS;

import DTO.KhachHangDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javafx.scene.control.TableRow;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import DTO.SanPhamDTO;
import DTO.TheLoaiDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ultity.ClassTableModel;
import ultity.ComboItem;
import ultity.ConvertString;
import view.SanPhamJFrame;

/**
 *
 * @author ninhh
 */
public class QLSanPhamController {
     private JPanel pnView;
     private JButton btAdd;
     private  JComboBox cbTimKiem;
     private JTextField txSearch;
     private JButton btTimKiem;
     
      private JTable table = new JTable();
    private JPanel pnXacNhan;
    private JButton btLuu;
    private JButton btHuy;
  
    private  JButton btSua;
    private  JButton btXoa;
    private  JComboBox cbNCC;
    private  JComboBox cbTheLoai;
    private  JTextField txGia;
    private  JTextField txMaSP;
    private  JTextField txSL;
    private  JTextField txTenSp;
     
    private  static SanPhamDTO SP_HienHanh;
    private  static NhaCungCapDTO NCC_HienHanh;
    private  static TheLoaiDTO TheLoai_HienHanh;
    private int selectedRowIndex;
    private String ThaoTac="";
    //de tao combobox
    private ArrayList<SanPhamDTO> listItem=SanPhamBUS.getList();
     private ArrayList<TheLoaiDTO> theloaiDTO=new ArrayList<>();
     private ArrayList<NhaCungCapDTO> NccDTO=new ArrayList<>();
     
     
   //   private SanPhamDAO sanPhamDAO=null;
//     private TheLoaiDAO theloaiDAO=null;
//     private NhaCungCapDAO NccDAO=null;
    //het combobox
     
     
      private ClassTableModel classTableModel = null;
    
     private String[] ListColum={"Mã SẢn Phẩm","Tên Sản Phẩm","Số Lượng","Đơn Giá","Mã Thể Loại","Mã Nhà Cung cấp"};
     private TableRowSorter<TableModel> rowSorter=null;

    public QLSanPhamController(JPanel pnView, JButton btAdd, JTextField txSearch) {
        this.pnView = pnView;
        this.btAdd = btAdd;
        this.txSearch = txSearch;
        this.classTableModel = new ClassTableModel();
     //   this.sanPhamDAO=new SanPhamDAO();
    }

    public QLSanPhamController(JPanel pnView, JButton btAdd, JComboBox cbTimKiem, JTextField txSearch,JButton btTimKiem, JButton btSua, JButton btXoa, JComboBox cbNCC, JComboBox cbTheLoai, JTextField txGia, JTextField txMaSP, JTextField txSL, JTextField txTenSp,JPanel pnXacNhan,JButton btLuu,JButton btHuy) {
        this.pnView = pnView;
        this.btAdd = btAdd;
        this.cbTimKiem = cbTimKiem;
        this.txSearch = txSearch;
        this.btTimKiem=btTimKiem;
        this.btSua = btSua;
        this.btXoa = btXoa;
        this.cbNCC = cbNCC;
        this.cbTheLoai = cbTheLoai;
        this.txGia = txGia;
        this.txMaSP = txMaSP;
        this.txSL = txSL;
        this.txTenSp = txTenSp;
        this.pnXacNhan=pnXacNhan;
        this.btLuu=btLuu;
        this.btHuy=btHuy;
        this.classTableModel = new ClassTableModel();
        
        //set víitable
        this.pnXacNhan.setVisible(false);
        
        
        theloaiDTO=TheLoaiBUS.getList();
        NccDTO=NhaCungCapBUS.getList();
        for (TheLoaiDTO theloai : theloaiDTO) {
            cbTheLoai.addItem(theloai.getMaTheLoai()+") "+theloai.getTenTheLoai());
            
        }
        for (NhaCungCapDTO nhacungcap : NccDTO) {
            cbNCC.addItem(nhacungcap.getMaNCC()+") "+nhacungcap.getTenNCC());
        }
//        cbNCC.setEnabled(false);
//        cbTheLoai.setEnabled(false);
    }
    

    public void setDataToTable(){
    listItem=SanPhamBUS.getList();
        setDataToTable(listItem);
    
    }
     
     public void setDataToTable(ArrayList<SanPhamDTO> listItem){
       
         ArrayList<SanPhamDTO> danhsach=listItem;
       
        // System.out.println(listItem.getClass());
         
         DefaultTableModel model = classTableModel.setTableSanPham(danhsach, ListColum);
                   table = new JTable(model);

          rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
       //  table.setAutoCreateRowSorter(true);
         
//         txSearch.getDocument().addDocumentListener(new DocumentListener() {
//              
//             @Override
//             public void insertUpdate(DocumentEvent e) {
//                 String text=txSearch.getText();
//                 if(text.trim().length()==0){
//                     rowSorter.setRowFilter(null);
//                     
//                 }else{
////                     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text));
//                 }
//             
//             }
//            
//
//             @Override
//             public void removeUpdate(DocumentEvent e) {
//                 String text=txSearch.getText();
//                 if(text.trim().length()==0){
//                     rowSorter.setRowFilter(null);
//                     
//                 }else{
////                     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text));
//                 }
//             }
//
//             @Override
//             public void changedUpdate(DocumentEvent e) {
//                 
//             }
//         });
//     
        
//         table.addMouseListener(new MouseAdapter() {
//
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                   SP_HienHanh=new SanPhamDTO();
//                   DefaultTableModel model=(DefaultTableModel) table.getModel();
//                  selectedRowIndex=table.getSelectedRow();
//                 selectedRowIndex=table.convertRowIndexToModel(selectedRowIndex);     
//                
//                 SP_HienHanh.setMa_SP((int) model.getValueAt(selectedRowIndex, 0));
//                 SP_HienHanh.setTen_SP(model.getValueAt(selectedRowIndex, 1).toString());
//                 SP_HienHanh.setSoluong((int) model.getValueAt(selectedRowIndex, 2));
//                 SP_HienHanh.setGia((int) model.getValueAt(selectedRowIndex, 3));
//                 SP_HienHanh.setMaTheLoai((int) model.getValueAt(selectedRowIndex, 4));
//                 SP_HienHanh.setMaNCC((int) model.getValueAt(selectedRowIndex, 5));
//                // SP_HienHanh.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 6));
//                
//                if(e.getClickCount()==2 && table.getSelectedRow() != -1){
//                
//         
//                 
//                 SanPhamJFrame frame=new SanPhamJFrame(SP_HienHanh);
//                 frame.setTitle("Thông tin sản phẩm");
//                 frame.setResizable(false);
//                 frame.setLocationRelativeTo(null);
//                 frame.setVisible(true);
//                }
//                 txMaSP.setText(""+SP_HienHanh.getMa_SP());
//                 txTenSp.setText(SP_HienHanh.getTen_SP());
//                 txSL.setText(""+SP_HienHanh.getSoluong());
//                 txGia.setText(""+SP_HienHanh.getGia());
//                 
//              
//                         NCC_HienHanh=NhaCungCapBUS.getTheLoai_TheoMa(SP_HienHanh.getMaNCC());
//                           cbNCC.setSelectedItem(NCC_HienHanh.getMaNCC()+") "+NCC_HienHanh.getTenNCC()); 
//                       //    System.out.println(nccdto.getMaNCC()+"  "+nccdto.getTenNCC());
//                
//                 
//                
//                         TheLoai_HienHanh=TheLoaiBUS.getTheLoai_TheoMa(SP_HienHanh.getMaTheLoai());
//                           cbTheLoai.setSelectedItem(TheLoai_HienHanh.getMaTheLoai()+") "+TheLoai_HienHanh.getTenTheLoai());
//                         //  System.out.println(theloaiDTO1.getMaTheLoai()+"  "+theloaiDTO1.getTenTheLoai());
//                     
//             }
//                
//         
//         });
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                    @Override
                    public void valueChanged(ListSelectionEvent event) {
                        // do some actions here, for example
                        // print first column value from selected row
                        int vitri=table.getSelectedRow();
                        SanPhamDTO sanpham;
                        sanpham = new SanPhamDTO(danhsach.get(vitri));
                       // System.out.println(table.getSelectedRow());
                       SP_HienHanh=new SanPhamDTO(sanpham);
                        
                          txMaSP.setText(""+SP_HienHanh.getMa_SP());
                        txTenSp.setText(SP_HienHanh.getTen_SP());
                        txSL.setText(""+SP_HienHanh.getSoluong());
                        txGia.setText(""+SP_HienHanh.getGia());
                 
              
                         NCC_HienHanh=NhaCungCapBUS.getTheLoai_TheoMa(SP_HienHanh.getMaNCC());
                           cbNCC.setSelectedItem(NCC_HienHanh.getMaNCC()+") "+NCC_HienHanh.getTenNCC()); 
                      
                
                 
                
                         TheLoai_HienHanh=TheLoaiBUS.getTheLoai_TheoMa(SP_HienHanh.getMaTheLoai());
                           cbTheLoai.setSelectedItem(TheLoai_HienHanh.getMaTheLoai()+") "+TheLoai_HienHanh.getTenTheLoai());
                        
                 
                        
                    
                     }
        
            });
         
         table.getColumnModel().getColumn(0).setMinWidth(120);
       //  table.getColumnModel().getColumn(0).setMaxWidth(80);
         table.getColumnModel().getColumn(0).setPreferredWidth(80);
         
          table.getColumnModel().getColumn(1).setMinWidth(120);
      //   table.getColumnModel().getColumn(1).setMaxWidth(80);
         table.getColumnModel().getColumn(1).setPreferredWidth(80);
         
          table.getColumnModel().getColumn(2).setMinWidth(120);
         table.getColumnModel().getColumn(3).setMinWidth(120);
       
         
     
         
         table.getTableHeader().setFont(new Font("Arrial",Font.BOLD,14));
         table.getTableHeader().setPreferredSize(new Dimension(100, 50));
         table.setRowHeight(50);
         table.validate();
         table.repaint();
         
         JScrollPane scrollpane=new JScrollPane();
         scrollpane.getViewport().add(table);
         scrollpane.setPreferredSize(new Dimension(1300, 400));
         pnView.removeAll();
         pnView.setLayout(new BorderLayout());
         pnView.add(scrollpane);
         pnView.validate();
         pnView.repaint();
     }
    public void ChucNang(){
            
       DisableEdit();
        
        
        
//            btAdd.addMouseListener(new MouseAdapter() {
//
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                 SanPhamJFrame f= new SanPhamJFrame(new SanPhamDTO() );
//                 f.setResizable(false);
//                 f.setLocationRelativeTo(null);
//                 f.setVisible(true);
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                      btAdd.setBackground(new Color(0,204,255));
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                       btAdd.setBackground(new Color(153,255,255));
//                }
//                
//                
//            });
//            
          btXoa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                   
                 DefaultTableModel model=(DefaultTableModel) table.getModel();
                 int selectedRowIndex=table.getSelectedRow();
                 selectedRowIndex=table.convertRowIndexToModel(selectedRowIndex);     
                   int MaSanPham=(int) model.getValueAt(selectedRowIndex, 0);
                    //System.out.println(MaSanPham);
                    SanPhamBUS.Delete(MaSanPham);
                    setDataToTable();
                    
            }
        });
          
          btSua.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getSelectedRow() != -1){
                    //txMaSP.setEditable(true);
                    EnableEdit();
                    
                    table.setEnabled(false);
                    ThaoTac="Sua";
                    btAdd.setEnabled(   false);
                    btSua.setEnabled(   false);
                    btXoa.setEnabled(   false);
                    
                }
            }
        });
         
          
           btAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 
                    EnableEdit();
                    int a=1+SanPhamBUS.MaSP_Max();
                    txMaSP.setText(a+"");
                    txMaSP.setEditable(false);
                  txMaSP.setText(a+"");
                   
                    txTenSp.setText("");
                    txGia.setText("");
                    txSL.setText("");
                    
                    ThaoTac="Them";
                    table.setEnabled(false);
                  
                    btAdd.setEnabled(   false);
                    btSua.setEnabled(   false);
                    btXoa.setEnabled(   false);
                    
                    
                  
            }
              
          
          });
         
          
            btLuu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SanPhamDTO sp_Sua=new SanPhamDTO();
                int ma=Integer.parseInt(txMaSP.getText());
                int sl=Integer.parseInt(txSL.getText());
                int gia=Integer.parseInt(txGia.getText());
                int ncc=ConvertString.getNumbers((String) cbNCC.getSelectedItem());
                int theloai=ConvertString.getNumbers((String) cbTheLoai.getSelectedItem());
                
                System.out.println(ncc +"  "+theloai);
                sp_Sua.setMa_SP(ma); 
                sp_Sua.setGia(gia);
                sp_Sua.setSoluong(sl);
                sp_Sua.setTen_SP(txTenSp.getText());
                sp_Sua.setMaNCC(ncc);
                sp_Sua.setMaTheLoai(theloai);
                //System.out.println(sp_Sua.getMaNCC());
            
             //  SP_HienHanh=new SanPhamDTO(sp_Sua);
                if(ThaoTac=="Sua"){
                    SanPhamBUS.SuaSP(sp_Sua);
                    ThaoTac="";
                }    
                if(ThaoTac=="Them"){
                    SanPhamBUS.themSP(sp_Sua);
                    ThaoTac="";
                }    
                  
                DisableEdit();
                      
                table.setEnabled(true);
                  
                btSua.setEnabled(   true);
                    
                setDataToTable();
                pnXacNhan.setVisible(false);
                btAdd.setEnabled(   true);
                btSua.setEnabled(   true);
                btXoa.setEnabled(   true);
               
            }
        });
          
         
          btHuy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DisableEdit();
                table.setEnabled(true);
                 btAdd.setEnabled(   true);
                btSua.setEnabled(   true);
                btXoa.setEnabled(   true);
            }
          });
        btTimKiem.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               String noidung=txSearch.getText();
              String TimCaiGi=(String) cbTimKiem.getSelectedItem();
              if(TimCaiGi.equals("Chung")){
                   rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ noidung));
              }else{
                ArrayList<SanPhamDTO> danhsach=SanPhamBUS.TimKiemChung(TimCaiGi, noidung);
                  setDataToTable(danhsach);
              }
           }
       });
        
         
         
         txSearch.getDocument().addDocumentListener(new DocumentListener() {

             @Override
             public void insertUpdate(DocumentEvent e) {
                 String text=txSearch.getText();
                 if(text.trim().length()==0){
                     setDataToTable(listItem);
                     
                 }else{
//                     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text));
                 }
             
             }
            

             @Override
             public void removeUpdate(DocumentEvent e) {
                 String text=txSearch.getText();
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
   
    
    public void EnableEdit(){
        txMaSP.setEditable(true);
        txTenSp.setEditable(true);
        txGia.setEditable(true);
        txSL.setEditable(true);
        cbNCC.setEnabled(true);
        cbTheLoai.setEnabled(true);
        pnXacNhan.setVisible(true);
    }
    public void DisableEdit(){
        txMaSP.setEditable(false);
        txTenSp.setEditable(false);
        txGia.setEditable(false);
        txSL.setEditable(false);
        cbNCC.setEnabled(false);
        cbTheLoai.setEnabled(false);
        pnXacNhan.setVisible(false);
    }
      
        
        
}
