
package view;

import Bean.DanhMucBean;
import BUS.ChuyenManHinhController;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends javax.swing.JFrame {

   
    public MainFrame() {
        initComponents();
        setTitle("Quản Lý Cửa Hàng Tạp Hóa Mini");
        ChuyenManHinhController controller=new ChuyenManHinhController(pnView);
        controller.setView(pnTrangChu, lbTrangChu);
        ArrayList<DanhMucBean> listitem=new ArrayList<>();
        listitem.add(new DanhMucBean("TrangChu", pnTrangChu, lbTrangChu));
        listitem.add(new DanhMucBean("SanPham", pnSP, lbSp));
        listitem.add(new DanhMucBean("HoaDon", pnHoaDon, lbHoaDon));
        listitem.add(new DanhMucBean("PhieuNhap", pnPhieuNhap, lbPhieuNhap));
        listitem.add(new DanhMucBean("NhanVien", pnNhanVien, lbNhanVien));
        listitem.add(new DanhMucBean("ThongKe", pnThongKe, lbThongKe));
        listitem.add(new DanhMucBean("KhachHang", pnKhachHang, lbKhachHang));
        listitem.add(new DanhMucBean("ThongTinKhac", pnThongTinKhac, lbThongTinKhac));
        listitem.add(new DanhMucBean("TimKiem", pnTimKiem, lbTimKiem));
        controller.setEvent(listitem);
      //  setResizable(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRoot = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        pnTitle = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        pnSP = new javax.swing.JPanel();
        lbSp = new javax.swing.JLabel();
        pnHoaDon = new javax.swing.JPanel();
        lbHoaDon = new javax.swing.JLabel();
        pnPhieuNhap = new javax.swing.JPanel();
        lbPhieuNhap = new javax.swing.JLabel();
        pnNhanVien = new javax.swing.JPanel();
        lbNhanVien = new javax.swing.JLabel();
        pnTrangChu = new javax.swing.JPanel();
        lbTrangChu = new javax.swing.JLabel();
        pnThongKe = new javax.swing.JPanel();
        pnThongKe1 = new javax.swing.JPanel();
        lbThongKe = new javax.swing.JLabel();
        pnKhachHang = new javax.swing.JPanel();
        lbKhachHang = new javax.swing.JLabel();
        pnThongTinKhac = new javax.swing.JPanel();
        lbThongTinKhac = new javax.swing.JLabel();
        pnTimKiem = new javax.swing.JPanel();
        lbTimKiem = new javax.swing.JLabel();
        pnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMenu.setBackground(new java.awt.Color(82, 83, 81));

        pnTitle.setBackground(new java.awt.Color(255, 0, 102));

        lbTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(51, 51, 0));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/store.png"))); // NOI18N
        lbTitle.setText("Quản Lý Cửa Hàng Tạp Hóa");

        javax.swing.GroupLayout pnTitleLayout = new javax.swing.GroupLayout(pnTitle);
        pnTitle.setLayout(pnTitleLayout);
        pnTitleLayout.setHorizontalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );
        pnTitleLayout.setVerticalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTitleLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnSP.setBackground(new java.awt.Color(136, 44, 83));
        pnSP.setForeground(new java.awt.Color(255, 102, 51));

        lbSp.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lbSp.setForeground(new java.awt.Color(255, 255, 255));
        lbSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_local_grocery_store_white_18dp.png"))); // NOI18N
        lbSp.setText("Quản Lý Sản Phẩm");

        javax.swing.GroupLayout pnSPLayout = new javax.swing.GroupLayout(pnSP);
        pnSP.setLayout(pnSPLayout);
        pnSPLayout.setHorizontalGroup(
            pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSPLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnSPLayout.setVerticalGroup(
            pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSp, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnHoaDon.setBackground(new java.awt.Color(136, 44, 83));
        pnHoaDon.setForeground(new java.awt.Color(255, 102, 51));

        lbHoaDon.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lbHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lbHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_featured_play_list_white_18dp.png"))); // NOI18N
        lbHoaDon.setText("Quản Lý Hóa Đơn");
        lbHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnHoaDonLayout = new javax.swing.GroupLayout(pnHoaDon);
        pnHoaDon.setLayout(pnHoaDonLayout);
        pnHoaDonLayout.setHorizontalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnHoaDonLayout.setVerticalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnPhieuNhap.setBackground(new java.awt.Color(136, 44, 83));
        pnPhieuNhap.setForeground(new java.awt.Color(255, 102, 51));

        lbPhieuNhap.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lbPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_featured_play_list_white_18dp.png"))); // NOI18N
        lbPhieuNhap.setText("Quản Lý Phiếu Nhập ");

        javax.swing.GroupLayout pnPhieuNhapLayout = new javax.swing.GroupLayout(pnPhieuNhap);
        pnPhieuNhap.setLayout(pnPhieuNhapLayout);
        pnPhieuNhapLayout.setHorizontalGroup(
            pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPhieuNhapLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnPhieuNhapLayout.setVerticalGroup(
            pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnNhanVien.setBackground(new java.awt.Color(136, 44, 83));
        pnNhanVien.setForeground(new java.awt.Color(255, 102, 51));

        lbNhanVien.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lbNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_perm_identity_white_18dp.png"))); // NOI18N
        lbNhanVien.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnTrangChu.setBackground(new java.awt.Color(136, 44, 83));
        pnTrangChu.setPreferredSize(new java.awt.Dimension(250, 76));

        lbTrangChu.setBackground(new java.awt.Color(136, 44, 83));
        lbTrangChu.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        lbTrangChu.setText("Trang Chủ");

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTrangChuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnThongKe.setBackground(new java.awt.Color(136, 44, 83));
        pnThongKe.setForeground(new java.awt.Color(255, 102, 51));

        pnThongKe1.setBackground(new java.awt.Color(136, 44, 83));
        pnThongKe1.setForeground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout pnThongKe1Layout = new javax.swing.GroupLayout(pnThongKe1);
        pnThongKe1.setLayout(pnThongKe1Layout);
        pnThongKe1Layout.setHorizontalGroup(
            pnThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        pnThongKe1Layout.setVerticalGroup(
            pnThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );

        lbThongKe.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_view_headline_white_18dp.png"))); // NOI18N
        lbThongKe.setText("Thống Kê");

        javax.swing.GroupLayout pnThongKeLayout = new javax.swing.GroupLayout(pnThongKe);
        pnThongKe.setLayout(pnThongKeLayout);
        pnThongKeLayout.setHorizontalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongKeLayout.createSequentialGroup()
                .addGroup(pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongKeLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pnThongKe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnThongKeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnThongKeLayout.setVerticalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongKeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbThongKe)
                .addGap(13, 13, 13)
                .addComponent(pnThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pnKhachHang.setBackground(new java.awt.Color(136, 44, 83));

        lbKhachHang.setBackground(new java.awt.Color(136, 44, 83));
        lbKhachHang.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lbKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lbKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_perm_identity_white_18dp.png"))); // NOI18N
        lbKhachHang.setText("Quản Lý Khách Hàng");

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnThongTinKhac.setBackground(new java.awt.Color(136, 44, 83));

        lbThongTinKhac.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lbThongTinKhac.setForeground(new java.awt.Color(255, 255, 255));
        lbThongTinKhac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_view_headline_white_18dp.png"))); // NOI18N
        lbThongTinKhac.setText("Thông tin khác");

        javax.swing.GroupLayout pnThongTinKhacLayout = new javax.swing.GroupLayout(pnThongTinKhac);
        pnThongTinKhac.setLayout(pnThongTinKhacLayout);
        pnThongTinKhacLayout.setHorizontalGroup(
            pnThongTinKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinKhacLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbThongTinKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnThongTinKhacLayout.setVerticalGroup(
            pnThongTinKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinKhacLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbThongTinKhac)
                .addContainerGap())
        );

        pnTimKiem.setBackground(new java.awt.Color(136, 44, 83));

        lbTimKiem.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lbTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        lbTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_view_headline_white_18dp.png"))); // NOI18N
        lbTimKiem.setText("Tìm kiếm");

        javax.swing.GroupLayout pnTimKiemLayout = new javax.swing.GroupLayout(pnTimKiem);
        pnTimKiem.setLayout(pnTimKiemLayout);
        pnTimKiemLayout.setHorizontalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTimKiemLayout.setVerticalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTimKiem)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(pnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnThongTinKhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnThongTinKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnViewLayout = new javax.swing.GroupLayout(pnView);
        pnView.setLayout(pnViewLayout);
        pnViewLayout.setHorizontalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1033, Short.MAX_VALUE)
        );
        pnViewLayout.setVerticalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lbPhieuNhap;
    private javax.swing.JLabel lbSp;
    private javax.swing.JLabel lbThongKe;
    private javax.swing.JLabel lbThongTinKhac;
    private javax.swing.JLabel lbTimKiem;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTrangChu;
    private javax.swing.JPanel pnHoaDon;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnPhieuNhap;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JPanel pnSP;
    private javax.swing.JPanel pnThongKe;
    private javax.swing.JPanel pnThongKe1;
    private javax.swing.JPanel pnThongTinKhac;
    private javax.swing.JPanel pnTimKiem;
    private javax.swing.JPanel pnTitle;
    private javax.swing.JPanel pnTrangChu;
    private javax.swing.JPanel pnView;
    // End of variables declaration//GEN-END:variables
}
