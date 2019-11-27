/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import Bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Border;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.ChiTietHoaDonPanel;
import view.HoaDonPanel;
import view.PhieuNhapPanel;
import view.SanPhamPanel;
import view.TestPanel;
import view.ThongTinKhacPanel;
import view.TrangChuPanel;

/**
 *
 * @author ninhh
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected="";
    private ArrayList<DanhMucBean> listitem=null;
    public ChuyenManHinhController(JPanel pnRoot) {
        this.root = pnRoot;
    }
    public void setView(JPanel pnItem,JLabel lbItem){
        kindSelected="TrangChu";
        pnItem.setBackground(Color.red);
        lbItem.setBackground(Color.red);
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuPanel());
        root.validate();
        root.repaint();
        
    }
    public void setEvent( ArrayList<DanhMucBean> listitem ){
        this.listitem= listitem;
        for(DanhMucBean item: listitem){
            item.getPn().addMouseListener(new LabelEvent(item.getKind(), item.getPn(), item.getLb()));
        }
    }
  
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        private JPanel pnItem;
        private JLabel lbItem;

        public LabelEvent(String kind, JPanel pnItem, JLabel lbItem) {
            this.kind = kind;
            this.pnItem = pnItem;
            this.lbItem = lbItem;
        }
       
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "TrangChu":
                    node=new ChiTietHoaDonPanel();
                    break;
                case "SanPham":
                    node=new  SanPhamPanel();
                    break;
                case "HoaDon":
                    node=new HoaDonPanel();
                    break;
                case "PhieuNhap":
                    node = new PhieuNhapPanel();
                    break;
                case "ThongTinKhac":
                    node = new ThongTinKhacPanel();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected=kind;
            pnItem.setBackground(Color.red);
            lbItem.setBackground(Color.red);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          pnItem.setBackground(Color.red);
            lbItem.setBackground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                pnItem.setBackground(new Color(136,44,83));
                lbItem.setBackground(new Color(136,44,83));
            }
        }
        
    }
    public void setChangeBackground(String kind){
        for(DanhMucBean item: listitem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getPn().setBackground(Color.red);
                item.getLb().setBackground(Color.red);
            }else{
                 item.getPn().setBackground(new Color(136,44,83));
                item.getLb().setBackground(new Color(136,44,83));
            }
        }
    }
}
