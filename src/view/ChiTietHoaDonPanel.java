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
import BUS.SanPhamBUS;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;

import DTO.SanPhamDTO;
import interfaces.InTroVe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import ultity.ClassTableModel;
import ultity.ConvertString;

public class ChiTietHoaDonPanel extends javax.swing.JPanel {

    private InTroVe introve;
    private JTable table = new JTable();
    private ClassTableModel classTableModel = null;
    private String[] ListColum = {"Mã CTDH", "Mã đon hàng", "Mã sản phẩm", "Số lượng ", "Đơn giá  ", "thành tiền"};
    private TableRowSorter<TableModel> rowSorter = null;
    private ArrayList<SanPhamDTO> DSSanPham = new ArrayList<>();
    private String ThaoTac;
    private ArrayList<ChiTietHoaDonDTO> listItem = ChiTietHoaDonBUS.getlist();

    //  private ArrayList<ChiTietHoaDonDTO> listCTHD= ChiTietHoaDonBUS.getlist();
    private ChiTietHoaDonDTO CTHD_HienHanh = new ChiTietHoaDonDTO();

    private SanPhamDTO SanPham_HienHanh;

    public ChiTietHoaDonPanel() {
        initComponents();
        setView();
        setDataTable();

    }

    public ChiTietHoaDonPanel(int MaHD, InTroVe introve) {

        this.introve = introve;
        initComponents();
        ArrayList<ChiTietHoaDonDTO> ds = ChiTietHoaDonBUS.getlist_TheoMaHD(MaHD);
        setDataTable(ds);
        setView();
        setEventButton();
        lbTieuDe.setText("Chi tiết hóa đơn : " + MaHD);

    }

    public void setDataTable() {
        listItem = ChiTietHoaDonBUS.getlist();
        setDataTable(listItem);
    }

    public void setDataTable(ArrayList<ChiTietHoaDonDTO> listItem) {

        this.classTableModel = new ClassTableModel();
        DefaultTableModel model = classTableModel.setTableChiTietHoaDon(listItem, ListColum);
        table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int vitri = table.getSelectedRow();

                ChiTietHoaDonDTO chitiethd = new ChiTietHoaDonDTO(listItem.get(vitri));

                CTHD_HienHanh = new ChiTietHoaDonDTO(chitiethd);
                SanPham_HienHanh = new SanPhamDTO(SanPhamBUS.getSP_TheoMa(chitiethd.getMaSP()));

                txMaCTHD.setText(CTHD_HienHanh.getMaCTHD() + "");
                txMaHD.setText(CTHD_HienHanh.getMaHD() + "");
                cbSanPham.setSelectedItem(SanPham_HienHanh.getMa_SP() + ") " + SanPham_HienHanh.getTen_SP());
                txDonGia.setText(CTHD_HienHanh.getDongia() + "");
                txSL.setText(CTHD_HienHanh.getSL() + "");
                txThanhTien.setText(CTHD_HienHanh.getThanhtien() + "");

            }

        });
        table.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(50, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(table);
        scrollpane.setPreferredSize(new Dimension(1100, 400));
        pnView.removeAll();
        pnView.setLayout(new BorderLayout());
        pnView.add(scrollpane);
        pnView.validate();

        pnView.repaint();

    }

    public void setEventButton() {
        btTroVe.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                introve.trove();
            }
        });

        btXemDS.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lbTieuDe.setText("Danh sách Chi tiết Hóa Đơn");
                setDataTable(ChiTietHoaDonBUS.getlist());

            }
        });

        btXoa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int xacnhan = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa chi tiết hóa đơn này?"); //Thong báo xác nhận xóa 
                if (xacnhan == 0) {

                    if (table.getSelectedRow() != -1) {
                        try {
                            ChiTietHoaDonBUS.Delete(CTHD_HienHanh.getMaHD());
                            int tongtien_cthd = ChiTietHoaDonBUS.TongCTHD(CTHD_HienHanh.getMaHD());
                            HoaDonBUS.SuaHD_TongTien(CTHD_HienHanh.getMaHD(), tongtien_cthd);
                            setDataTable();
                        } catch (Exception ex) {
                            System.out.println("loi btXoa CTHD");
                        }

                    }

                }
            }
        });
        btSua.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (table.getSelectedRow() != -1) {
                    setDisableEdit();
                    cbSanPham.setEnabled(true);
                    txSL.setEditable(true);

                    table.setEnabled(false);

                    btThem.setEnabled(false);
                    btSua.setEnabled(false);
                    btXoa.setEnabled(false);

                    ThaoTac = "Sua";
                }
            }
        });
        btThem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (table.getSelectedRow() != -1) {
                    setDisableEdit();
                    cbSanPham.setEnabled(true);
                    txSL.setEditable(true);

                    table.setEnabled(false);

                    btThem.setEnabled(false);
                    btSua.setEnabled(false);
                    btXoa.setEnabled(false);

                    ThaoTac = "Sua";
                }
            }
        });

        cbSanPham.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ConvertString convert=new ConvertString();
                int masanpham=convert.getNumbers((String) cbSanPham.getSelectedItem());
                SanPhamDTO sanpham_CB=SanPhamBUS.getSP_TheoMa(masanpham);
                txDonGia.setText(sanpham_CB.getGia()+"");
                int tong=sanpham_CB.getGia()*Integer.valueOf(txSL.getText());
                txThanhTien.setText(tong+"");
            }
        });

    }

    public void setView() {
        for (SanPhamDTO sanpham : DSSanPham) {
            cbSanPham.addItem(sanpham.getMa_SP() + ") " + sanpham.getTen_SP());
        }
        DSSanPham = SanPhamBUS.getList();
        for (SanPhamDTO sp : DSSanPham) {
            cbSanPham.addItem(sp.getMa_SP() + ") " + sp.getTen_SP());
        }
        setDisableEdit();

    }

    public void setDisableEdit() {
        txMaCTHD.setEditable(false);
        txMaHD.setEditable(false);
        cbSanPham.setEditable(false);
        txDonGia.setEditable(false);
        txSL.setEditable(false);
        txThanhTien.setEditable(false);
    }

    public void setEnableEdit() {
        txMaCTHD.setEditable(true);
        txMaHD.setEditable(true);
        cbSanPham.setEditable(true);
        txDonGia.setEditable(true);
        txSL.setEditable(true);
        txThanhTien.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnroot = new javax.swing.JPanel();
        pnThongTin = new javax.swing.JPanel();
        pnMaCTHD = new javax.swing.JPanel();
        txMaCTHD = new javax.swing.JTextField();
        pnMaHD = new javax.swing.JPanel();
        txMaHD = new javax.swing.JTextField();
        pnMaSP = new javax.swing.JPanel();
        cbSanPham = new javax.swing.JComboBox();
        pnSL = new javax.swing.JPanel();
        txSL = new javax.swing.JTextField();
        pnDonGia = new javax.swing.JPanel();
        txDonGia = new javax.swing.JTextField();
        pnThanhTien = new javax.swing.JPanel();
        txThanhTien = new javax.swing.JTextField();
        pnChucNang = new javax.swing.JPanel();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btXemDS = new javax.swing.JButton();
        btTroVe = new javax.swing.JButton();
        pnTieuDe = new javax.swing.JPanel();
        lbTieuDe = new javax.swing.JLabel();
        pnView = new javax.swing.JPanel();
        pnTimKiem = new javax.swing.JPanel();
        cbTimKiem = new javax.swing.JComboBox();
        txTimKiem = new javax.swing.JTextField();
        btTImKiem = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(930, 592));
        setPreferredSize(new java.awt.Dimension(1006, 690));

        pnroot.setBackground(new java.awt.Color(255, 255, 255));
        pnroot.setMinimumSize(new java.awt.Dimension(981, 690));

        pnThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Chi tiết Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 15), new java.awt.Color(255, 0, 0))); // NOI18N

        pnMaCTHD.setBackground(new java.awt.Color(255, 255, 255));
        pnMaCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 255, 102), new java.awt.Color(0, 51, 51)), "Mã Chi tiết Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16))); // NOI18N

        txMaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txMaCTHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMaCTHDLayout = new javax.swing.GroupLayout(pnMaCTHD);
        pnMaCTHD.setLayout(pnMaCTHDLayout);
        pnMaCTHDLayout.setHorizontalGroup(
            pnMaCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMaCTHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txMaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnMaCTHDLayout.setVerticalGroup(
            pnMaCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMaCTHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txMaCTHD)
                .addContainerGap())
        );

        pnMaHD.setBackground(new java.awt.Color(255, 255, 255));
        pnMaHD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 255, 102), new java.awt.Color(0, 51, 51)), "Mã Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16))); // NOI18N

        javax.swing.GroupLayout pnMaHDLayout = new javax.swing.GroupLayout(pnMaHD);
        pnMaHD.setLayout(pnMaHDLayout);
        pnMaHDLayout.setHorizontalGroup(
            pnMaHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMaHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMaHDLayout.setVerticalGroup(
            pnMaHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMaHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMaSP.setBackground(new java.awt.Color(255, 255, 255));
        pnMaSP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 255, 102), new java.awt.Color(0, 51, 51)), "Mã sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16))); // NOI18N

        javax.swing.GroupLayout pnMaSPLayout = new javax.swing.GroupLayout(pnMaSP);
        pnMaSP.setLayout(pnMaSPLayout);
        pnMaSPLayout.setHorizontalGroup(
            pnMaSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMaSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMaSPLayout.setVerticalGroup(
            pnMaSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMaSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnSL.setBackground(new java.awt.Color(255, 255, 255));
        pnSL.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 255, 102), new java.awt.Color(0, 51, 51)), "Số lượng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16))); // NOI18N

        javax.swing.GroupLayout pnSLLayout = new javax.swing.GroupLayout(pnSL);
        pnSL.setLayout(pnSLLayout);
        pnSLLayout.setHorizontalGroup(
            pnSLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txSL, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnSLLayout.setVerticalGroup(
            pnSLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txSL, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnDonGia.setBackground(new java.awt.Color(255, 255, 255));
        pnDonGia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 255, 102), new java.awt.Color(0, 51, 51)), "Đơn giá", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16))); // NOI18N

        javax.swing.GroupLayout pnDonGiaLayout = new javax.swing.GroupLayout(pnDonGia);
        pnDonGia.setLayout(pnDonGiaLayout);
        pnDonGiaLayout.setHorizontalGroup(
            pnDonGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDonGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnDonGiaLayout.setVerticalGroup(
            pnDonGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDonGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnThanhTien.setBackground(new java.awt.Color(255, 255, 255));
        pnThanhTien.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 255, 102), new java.awt.Color(0, 51, 51)), "Thành tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16))); // NOI18N

        txThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txThanhTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnThanhTienLayout = new javax.swing.GroupLayout(pnThanhTien);
        pnThanhTien.setLayout(pnThanhTienLayout);
        pnThanhTienLayout.setHorizontalGroup(
            pnThanhTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThanhTienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnThanhTienLayout.setVerticalGroup(
            pnThanhTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThanhTienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txThanhTien)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnMaCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMaCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnChucNang.setBackground(new java.awt.Color(255, 255, 255));
        pnChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 15), new java.awt.Color(51, 51, 255))); // NOI18N

        btThem.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btThem.setText("Thêm CTHD");

        btSua.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btSua.setText("Sửa CTHD");

        btXoa.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btXoa.setText("Xóa CTHD");

        btXemDS.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btXemDS.setText("Xem DS CTHD");

        btTroVe.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btTroVe.setText("Trở về HĐ");

        javax.swing.GroupLayout pnChucNangLayout = new javax.swing.GroupLayout(pnChucNang);
        pnChucNang.setLayout(pnChucNangLayout);
        pnChucNangLayout.setHorizontalGroup(
            pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChucNangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXemDS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        pnChucNangLayout.setVerticalGroup(
            pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btXemDS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnTieuDe.setBackground(new java.awt.Color(255, 255, 255));

        lbTieuDe.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbTieuDe.setForeground(new java.awt.Color(0, 0, 255));
        lbTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieuDe.setText("Danh sách Chi tiết Hóa Đơn");

        javax.swing.GroupLayout pnTieuDeLayout = new javax.swing.GroupLayout(pnTieuDe);
        pnTieuDe.setLayout(pnTieuDeLayout);
        pnTieuDeLayout.setHorizontalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addComponent(lbTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        pnTieuDeLayout.setVerticalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnViewLayout = new javax.swing.GroupLayout(pnView);
        pnView.setLayout(pnViewLayout);
        pnViewLayout.setHorizontalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnViewLayout.setVerticalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        pnTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        pnTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(51, 255, 51))); // NOI18N

        btTImKiem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btTImKiem.setText("Tìm");

        javax.swing.GroupLayout pnTimKiemLayout = new javax.swing.GroupLayout(pnTimKiem);
        pnTimKiem.setLayout(pnTimKiemLayout);
        pnTimKiemLayout.setHorizontalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btTImKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txTimKiem)
                    .addComponent(cbTimKiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTimKiemLayout.setVerticalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btTImKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnrootLayout = new javax.swing.GroupLayout(pnroot);
        pnroot.setLayout(pnrootLayout);
        pnrootLayout.setHorizontalGroup(
            pnrootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnrootLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnrootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnrootLayout.createSequentialGroup()
                        .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(pnChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(pnrootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnrootLayout.setVerticalGroup(
            pnrootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnrootLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnrootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnroot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnroot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txMaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txMaCTHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMaCTHDActionPerformed

    private void txThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txThanhTienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua;
    private javax.swing.JButton btTImKiem;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTroVe;
    private javax.swing.JButton btXemDS;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox cbSanPham;
    private javax.swing.JComboBox cbTimKiem;
    private javax.swing.JLabel lbTieuDe;
    private javax.swing.JPanel pnChucNang;
    private javax.swing.JPanel pnDonGia;
    private javax.swing.JPanel pnMaCTHD;
    private javax.swing.JPanel pnMaHD;
    private javax.swing.JPanel pnMaSP;
    private javax.swing.JPanel pnSL;
    private javax.swing.JPanel pnThanhTien;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JPanel pnTieuDe;
    private javax.swing.JPanel pnTimKiem;
    private javax.swing.JPanel pnView;
    private javax.swing.JPanel pnroot;
    private javax.swing.JTextField txDonGia;
    private javax.swing.JTextField txMaCTHD;
    private javax.swing.JTextField txMaHD;
    private javax.swing.JTextField txSL;
    private javax.swing.JTextField txThanhTien;
    private javax.swing.JTextField txTimKiem;
    // End of variables declaration//GEN-END:variables
}
