/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import DTO.SanPhamDTO;
import BUS.SanPhamBUS;
import BUS.SanPhamBUS;
import DAO.SanPhamDAO;
import java.awt.Window;

/**
 *
 * @author ninhh
 */
public class ThongTinSVFrameController {
    private JButton btSubmit;
    private JTextField txMaSP;
    private JTextField txTenSp;
    private JTextField txSL;
    private JTextField txDonGia;
    private JTextField txNCC;
    private JTextField txTheLoai;
    private JCheckBox CheckBoxTinhTrang;
    private JLabel lbThongBao;
    
    private SanPhamDTO sanpham=null;
 //   private SanPhamBUS sanPhamServices=null;

    public ThongTinSVFrameController(JButton btSubmit, JTextField txMaSP, JTextField txTenSp, JTextField txSL, JTextField txDonGia, JTextField txNCC, JTextField txTheLoai, JCheckBox CheckBoxTinhTrang,JLabel lbThongBao) {
        this.btSubmit = btSubmit;
        this.txMaSP = txMaSP;
        this.txTenSp = txTenSp;
        this.txSL = txSL;
        this.txDonGia = txDonGia;
        this.txNCC = txNCC;
        this.txTheLoai = txTheLoai;
        this.CheckBoxTinhTrang = CheckBoxTinhTrang;
        this.lbThongBao=lbThongBao;
       // this.sanPhamServices=new SanPhamBUSImpl();
    }

   

 
    
    public void setView(SanPhamDTO sanpham){
        this.sanpham=sanpham;
        txMaSP.setText(""+sanpham.getMa_SP());
        txTenSp.setText(sanpham.getTen_SP());
        txSL.setText(""+sanpham.getSoluong());
        txDonGia.setText(""+sanpham.getGia());
        txTheLoai.setText(""+sanpham.getMaTheLoai());
        txNCC.setText(""+sanpham.getMaNCC());
      //  CheckBoxTinhTrang.setSelected(sanpham.getTinhTrang());
        
    }
    
    public void setEvent(){
        btSubmit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(txTenSp.getText().length()==0 ){
                     lbThongBao.setText("Vui lòng nhập đầu đủ thông tin");
                }else{
                  
                        int b=Integer.parseInt(txSL.getText());
                    int c=Integer.parseInt(txDonGia.getText());
                    int d=Integer.parseInt(txTheLoai.getText());
                    int ee=Integer.parseInt(txNCC.getText());
              
                   sanpham.setTen_SP(txTenSp.getText());
                   sanpham.setSoluong(b);
                   sanpham.setGia(c);
                   sanpham.setMaTheLoai(d);
                   sanpham.setMaNCC(ee);
                //   sanpham.setTinhTrang(CheckBoxTinhTrang.isSelected());
                   int lastID=SanPhamBUS.createOrUpdate(sanpham);
                   if(lastID>0){
                       sanpham.setMa_SP(lastID); 
                   txMaSP.setText(" "+lastID);
                  
                   lbThongBao.setText("Thêm sản phẩm thành công");
                   btSubmit.setEnabled(false);
                   
                     
                   }
                   
                   
                   
                   
                }
                    
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btSubmit.setBackground(new Color(153,255,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
           
            }
            
            
        });
    }
    
}
