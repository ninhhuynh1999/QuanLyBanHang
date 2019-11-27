/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import ultity.ClassTableModel;

/**
 *
 * @author dell
 */
public class QLPhieunhapController {
      private JPanel pnView;
           JTable table = new JTable();
        private ClassTableModel classTableModel = null;
          private String[] ListColum={"Mã Phiếu Nhập","Ngày Lập","Mã NV","Tổng tiền"};
     private TableRowSorter<TableModel> rowSorter=null;


    public QLPhieunhapController(JPanel pnView) {
        this.pnView = pnView;
           this.classTableModel = new ClassTableModel();
        
    }
     public void setDataToTable(){
         ArrayList<PhieuNhapDTO> listItem=PhieuNhapDAO.getlist();
         System.out.println(listItem.getClass());
         
         DefaultTableModel model = classTableModel.setTablePhieuNhap(listItem, ListColum);
                   table = new JTable(model);

          rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
       //  table.setAutoCreateRowSorter(true);
        
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
           
      
}
