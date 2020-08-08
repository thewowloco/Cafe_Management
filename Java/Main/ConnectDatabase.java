/*
 * To change this license header, 
License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Employee.*;
import Table.*;
import Food.*;
import Order.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


/**
 *
 * @author dungm
 */
public class ConnectDatabase {
    
    protected final String className = "com.mysql.cj.jdbc.Driver";
    protected final String url = "jdbc:mysql://127.0.0.1:3306/qlcafe";
    protected final String user = "root";
    protected final String password = "12345678";
    public Connection connection = null;
    
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    Scanner scanner = new Scanner(System.in);
    
    public ConnectDatabase() {};
    
    public void connect() {
        try {
                Class.forName(className);
            } catch (ClassNotFoundException ex) {
                System.err.println("Nhap sai driver!");
            }

            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                System.err.println("Thong tin dang nhap sai!");
            }
    }
 
    //============================== NHAN VIEN =================================//
    
    public void getDataNhanVien(QuanLyNV qlNV) throws NullPointerException{
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM qlcafe.nhanvien N INNER JOIN qlcafe.bophantructhuoc B"
                    + " ON N.BoPhanTrucThuoc_id = B.MaBoPhan ORDER BY MaNhanVien ");
            
            //Lay du lieu tu MySQL -> List<NhanVien>
            while(rs.next()){
                //int maNV = rs.getInt("MaNhanVien");
                int maNhanVien = rs.getInt("MaNhanVien");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                String queQuan = rs.getString("QueQuan");
                Date ngaySinh = rs.getDate("NgaySinh");
                Date ngayVaoLam = rs.getDate("NgayVaoLam");
                String boPhan = rs.getString("TenBoPhan");
                
                //nhanvien(HoTen, GioiTinh, QueQuan, NgaySinh, NgayVaoLam, BoPhanTrucThuoc_id)
                NhanVien nv = new NhanVien(maNhanVien, hoTen, gioiTinh, queQuan, ngaySinh, ngayVaoLam, boPhan);    
                qlNV.them(nv);
            }
        } catch (SQLException ex) {
            System.err.println("\n Error at getDataNhanVien" + ex.getMessage());
        }    }
    
    
    public void addNhanVien(NhanVien nv){   
        try {
            //NhanVien nv = new NhanVien("Selena Gomez", "Nu", "USA", f.parse("19/3/1993"), f.parse("2/6/2016"), "Rua chen");
            //nhanvien(HoTen, GioiTinh, QueQuan, NgaySinh, NgayVaoLam, BoPhanTrucThuoc_id)
            String addQuery = "INSERT INTO nhanvien(HoTen, GioiTinh, QueQuan, NgaySinh, NgayVaoLam, BoPhanTrucThuoc_id)"
                    + " VALUES (?, ?, ?, ?, ?, ?);";
            
            PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setString(1, nv.getHoTen());
            preparedStatement.setString(2, nv.getGioiTinh());
            preparedStatement.setString(3, nv.getQueQuan());
            preparedStatement.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(nv.getNgayVaoLam().getTime()));
            preparedStatement.setString(6, nv.getBoPhan());
            
            preparedStatement.executeUpdate();
            
            System.out.println("Them nhan vien thanh cong!");

        } catch (SQLException | NullPointerException ex) {
            System.err.println("\n Error at addNhanVien" + ex.getMessage());
        }
    }
    
    public void updateNhanVien(NhanVien nv, int maCotCapNhat) {

        PreparedStatement preparedStatement;
        try {
                    
            if (maCotCapNhat == 0) {
                System.out.println("\nCap nhat thong tin khong thanh cong!");
            }
            else {
                    if (maCotCapNhat == 6) {    //Neu chi cap nhat MaBoPhan
                    String updateQuery = "UPDATE nhanvien SET BoPhanTrucThuoc_id=? WHERE MaNhanVien=?";
                    preparedStatement = connection.prepareStatement(updateQuery);
                    preparedStatement.setInt(1, Integer.parseInt(nv.getBoPhan()));
                    preparedStatement.setInt(2, nv.getMaNhanVien());
                } else {
                    String updateQuery = "UPDATE nhanvien "
                        + "SET HoTen=?, GioiTinh=?, QueQuan=?, NgaySinh=?, NgayVaoLam=?"
                        + "WHERE MaNhanVien = ?";
                    preparedStatement = connection.prepareStatement(updateQuery);

                    preparedStatement.setString(1, nv.getHoTen());
                    preparedStatement.setString(2, nv.getGioiTinh());
                    preparedStatement.setString(3, nv.getQueQuan());
                    preparedStatement.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
                    preparedStatement.setDate(5, new java.sql.Date(nv.getNgayVaoLam().getTime()));
                    preparedStatement.setInt(6, nv.getMaNhanVien());
                }
                    preparedStatement.executeUpdate();
                    System.out.println("Cap nhat thanh cong!");
            }
    
        } catch (SQLException ex) {
            System.err.println("Error at updateNhanVien" + ex.getMessage());
        }        
    }
    
    public void deleteNhanVien(NhanVien nv) {
        try {
            int maNV = nv.getMaNhanVien();
            String deleteQuery = "DELETE FROM qlcafe.nhanvien WHERE MaNhanVien = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, maNV);
            
            preparedStatement.executeUpdate();
            
            System.out.println("\nXoa nhan vien thanh cong!");
        } catch (SQLException ex) {
            System.err.println("\nError at deleteNhanVien! " + ex.getMessage());
        }
    }
    
    
    //================================= BAN ===================================//
    public void getDataBan(QuanLyThongTinBan qlBan) {
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM qlcafe.ban");
            
            //Lấy dữ liệu từ MySQL -> List<Ban>
            while(rs.next()) {
                String maBan = String.format("B%03d", rs.getInt("MaBan"));
                int sucChua = rs.getInt("SucChua");
                String tinhTrang = rs.getString("TinhTrang");
                
                Ban ban = new Ban(sucChua, tinhTrang);
                ban.setMaBan(maBan);
                
                qlBan.them(ban);
            }
            
        } catch (SQLException ex) {
            System.err.println("\n Error at getDataBan " + ex.getMessage());
        }
    }
    
    public void showBanTrong() {
        QuanLyThongTinBan qlB = new QuanLyThongTinBan();
        getDataBan(qlB);
        qlB.xemDSBan();
    }
    
    public void addBan(Ban ban) {
        try {
            String addQuerry = "INSERT INTO qlcafe.ban(SucChua, TinhTrang) VALUES(?, ?);";
            
            PreparedStatement preparedStatement = connection.prepareStatement(addQuerry);
            preparedStatement.setInt(1, ban.getSucChua());
            preparedStatement.setString(2, ban.getTinhTrang());
            preparedStatement.executeUpdate();
            
            System.out.println("Them ban thanh cong!");
    
        } catch (SQLException ex) {
            System.err.println("\n Error at addBan " + ex.getMessage());
        }  
    }
    public void updateBan(Ban ban, int maCotCapNhat) {
        PreparedStatement preparedStatement;
        
        if (maCotCapNhat == 0) {
            System.out.println("\nCap nhat thong tin khong thanh cong!");
        } else {
            try {
                String updateQuery = "UPDATE ban SET SucChua=?, TinhTrang=? WHERE MaBan=?";
                preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setInt(1, ban.getSucChua());
                preparedStatement.setString(2, ban.getTinhTrang());
                preparedStatement.setString(3, ban.getMaBan().substring(1));    //Tách mã bàn B123 trong java -> Mã bàn 123 trong MySQL   
                preparedStatement.executeUpdate();
                
                System.out.println("Cap nhat thanh cong!");
                
            } catch (SQLException | NullPointerException ex) {
                System.err.println("Error at updateBan" + ex.getMessage());
            }
            
            
        }
        
    }
    
    public void deleteBan(Ban ban) {
        try {
            String deleteQuery = "DELETE FROM qlcafe.ban WHERE MaBan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, ban.getMaBan().substring(1));    //Tách mã bàn B123 trong java -> Mã bàn 123 trong MySQL
            preparedStatement.executeUpdate();
            
            System.out.println("Xoa ban thanh cong!");
        } catch (SQLException | NullPointerException ex) {
            System.err.println("Error at deleteBan" + ex.getMessage());
        }
    }
    
    public Ban chooseBan(int soLuongNguoi) {
        Ban ban = new Ban();
        ResultSet rs;
        String sqlCommand = "SELECT * FROM qlcafe.ban WHERE TinhTrang ='Trong' AND SucChua >= ? ORDER BY SucChua ASC";
        //Lấy bàn đầu tiên trong danh sách tăng dần (tất cả thỏa điều kiện) 
        PreparedStatement preparedStatement;
        try {
                preparedStatement = connection.prepareStatement(sqlCommand);
                preparedStatement.setInt(1, soLuongNguoi);
                rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String maBan = String.format("B%03d", rs.getInt("MaBan"));
                int sucChua = rs.getInt("SucChua");
                String tinhTrang = rs.getString("TinhTrang");
                
                ban.setMaBan(maBan);
                ban.setSucChua(sucChua);
                ban.setTinhTrang(tinhTrang);
            }
                
                
        } catch (SQLException | NullPointerException ex) {
            System.err.println("\n Error at getDataBan " + ex.getMessage());
        }
        return ban;
    }
    
 //============================ MON AN ===============================//   
    public void getDataMonAn(QLMonAn qlMA) {
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM qlcafe.monan M INNER JOIN qlcafe.danhmuc D ON M.DanhMuc = D.idDanhMuc ORDER BY IdMonAn;");
            
            while(rs.next()) {
                int id = rs.getInt("IdMonAn");
                String ten = rs.getString("Ten");
                double giaBan = rs.getInt("GiaBan");
                String tinhTrang = rs.getString("TinhTrang");
                String thoiDiemBan = rs.getString("ThoiDiemBan");
                String danhMuc = rs.getString("TenDanhMuc");
                String thongTinThem = rs.getString("ThongTinThem");
                int idDanhMuc = rs.getInt("idDanhMuc");
                              
                if (idDanhMuc == 1) {
                    MonAn m = new ThucAn(ten, giaBan, tinhTrang, thoiDiemBan);
                    m.setId(id);
                    m.setThongTinThem(thongTinThem);
                    m.setDanhMuc(danhMuc);
                    qlMA.them(m);
                } else {
                    MonAn m = new ThucUong(ten, giaBan, tinhTrang, thoiDiemBan);
                    m.setId(id);
                    m.setThongTinThem(thongTinThem);
                    m.setDanhMuc(danhMuc);
                    qlMA.them(m);
                }       
            }
            
        } catch (SQLException | NullPointerException ex) {
            System.err.println("\nError at getDataMonAn " + ex.getMessage());
        }   
   }
    /**
     * 
     * @param cachSapXep "tang dan", "giam dan", "danh muc"
     */
    public void sapXep(String cachSapXep) {
        try {
            QLMonAn qlMA = new QLMonAn();
            String sortQuery = "tang dan";
            
            if (cachSapXep.compareToIgnoreCase("giam dan") == 0) {
                sortQuery = "SELECT * FROM qlcafe.monan M INNER JOIN qlcafe.danhmuc D ON M.DanhMuc = D.idDanhMuc ORDER BY GiaBan DESC;";
            } else if (cachSapXep.compareToIgnoreCase("tang dan") == 0) {
                sortQuery = "SELECT * FROM qlcafe.monan M INNER JOIN qlcafe.danhmuc D ON M.DanhMuc = D.idDanhMuc ORDER BY GiaBan;";
            } else if (cachSapXep.compareToIgnoreCase("danh muc") == 0) {
                sortQuery ="SELECT * FROM qlcafe.monan M INNER JOIN qlcafe.danhmuc D ON M.DanhMuc = D.idDanhMuc ORDER BY idDanhMuc ASC;";
            }
            
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sortQuery);
            
            while(rs.next()) {
                int id = rs.getInt("IdMonAn");
                String ten = rs.getString("Ten");
                double giaBan = rs.getInt("GiaBan");
                String tinhTrang = rs.getString("TinhTrang");
                String thoiDiemBan = rs.getString("ThoiDiemBan");
                String danhMuc = rs.getString("TenDanhMuc");
                String thongTinThem = rs.getString("ThongTinThem");
                int idDanhMuc = rs.getInt("idDanhMuc");
                              
                if (idDanhMuc == 1) {
                    MonAn m = new ThucAn(ten, giaBan, tinhTrang, thoiDiemBan);
                    m.setId(id);
                    m.setThongTinThem(thongTinThem);
                    m.setDanhMuc(danhMuc);
                    qlMA.them(m);
                } else if (idDanhMuc == 2){
                    MonAn m = new ThucUong(ten, giaBan, tinhTrang, thoiDiemBan);
                    m.setId(id);
                    m.setThongTinThem(thongTinThem);
                    m.setDanhMuc(danhMuc);
                    qlMA.them(m);
                }       
            }
            qlMA.xemDSMonAn();
        } catch (SQLException ex) {
            System.err.println("\nError at getDataMonAn " + ex.getMessage());
        }   
   }
   
    public void addMonAn(MonAn m) {
        try {
            String addQuerry = "INSERT INTO qlcafe.monan(Ten, GiaBan, TinhTrang, ThoiDiemBan, DanhMuc, ThongTinThem) VALUES (?, ?, ?, ?, ?, ?);";
            
            PreparedStatement preparedStatement = connection.prepareStatement(addQuerry);
            preparedStatement.setString(1, m.getTen());
            preparedStatement.setDouble(2, m.getGiaBan());
            preparedStatement.setString(3, m.getTinhTrang());
            preparedStatement.setString(4, m.getThoiDiemBan());
            preparedStatement.setString(5, m.getDanhMuc());
            preparedStatement.setString(6, m.getThongTinThem());
            
            preparedStatement.executeUpdate();
            
            System.out.println("Them mon an thanh cong!");
    
        } catch (SQLException ex) {
            System.err.println("\n Error at addMonAn " + ex.getMessage());
        } 
    }
    
    public void deleteMonAn(MonAn m) {
        try {
            String deleteQuery = "DELETE FROM monan WHERE IdMonAn = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, m.getId());
            preparedStatement.executeUpdate();
            
            System.out.println("\nXoa mon an thanh cong!");
        } catch (SQLException ex) {
            System.err.println("\nError at deleteMonAn() " + ex.getMessage());
        }
    }
    //============================ DAT BAN ===============================//    
    public void orderTable(Ban ban, QLMonAn qlMA) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd-HHmmss");
        Date ngayTao = new Date();
        int maBan = Integer.parseInt(ban.getMaBan().substring(1));
               
        //idHoaDon là thời gian + mã bàn
        String idHoaDon = String.format("%s-%s", format.format(ngayTao), maBan);
        
        connection.setAutoCommit(false);
        try {
            //Add dữ liệu vào bảng hoadon
            String addHoaDonQuery = "INSERT INTO hoadon(idHoaDon, MaBan, NgayTao)"
                    + " VALUES (?, ?, ?);";
            PreparedStatement psHoaDon = connection.prepareStatement(addHoaDonQuery);
            psHoaDon.setString(1, idHoaDon);
            psHoaDon.setInt(2, maBan);
            psHoaDon.setDate(3, new java.sql.Date(ngayTao.getTime()));
            
            psHoaDon.executeUpdate();
            
            //Add dữ liệu vào bàng chitiethoadon
            String addChiTietHoaDonQuery = "INSERT INTO chitiethoadon(idMonAn, TenMon, DonGia, SoLuong, ThanhTien, idHD)"
                    + " VALUES (?,?,?,?,?,?);";
            PreparedStatement psChiTietHoaDon = connection.prepareStatement(addChiTietHoaDonQuery);
            for (MonAn m : qlMA.getDs()) {
                psChiTietHoaDon.setInt(1, m.getId());
                psChiTietHoaDon.setString(2, m.getTen());
                psChiTietHoaDon.setDouble(3, m.getGiaBan());
                psChiTietHoaDon.setInt(4, m.getSoLuong());
                psChiTietHoaDon.setDouble(5, m.getGiaBan() * m.getSoLuong());
                psChiTietHoaDon.setString(6, idHoaDon);
                psChiTietHoaDon.executeUpdate();
            }
            
            //Cập nhật bàn từ "trống" -> "đầy"
            String updateBanQuery = "UPDATE ban SET TinhTrang=? WHERE MaBan=?";
            PreparedStatement psBan = connection.prepareStatement(updateBanQuery);
            psBan.setString(1, "Day");
            psBan.setInt(2, maBan);
            psBan.executeUpdate();
            
            connection.commit();
            
            System.out.println("\n- Ma hoa don dat ban: " + idHoaDon + 
                    "\nMa ban: " + String.format("B%03d", maBan));
              
        } catch (SQLException ex) {
            connection.rollback();
            System.err.println("\nError at orderTable " + ex.getMessage());
        }
        
    }
    
//================================= THANH TOAN ==============================//
    public void getHoaDon(QLHoaDon qlHD) {
        try {
            Statement stm = connection.createStatement();
            String query = "SELECT * FROM hoadon";
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()) {
                String maHD = rs.getString("idHoaDon");
                int maBan = rs.getInt("MaBan");
                double tongTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                
                HoaDon order = new HoaDon(maHD, maBan, tongTien, ngayTao);
                qlHD.them(order);
            }
        } catch (SQLException ex) {
            System.err.println("\nError at getHoaDon() " + ex.getMessage());
        }
    }
    public double pay(String maHoaDon) throws SQLException{
          
        double tongTien = 0;
        int maBan;
        
            String mb = maHoaDon.substring(14);
            maBan = Integer.parseInt(mb);

        connection.setAutoCommit(false);
        try {
            Statement stm = connection.createStatement();
            PreparedStatement preparedStatement; 
            //Tính tiền của 1 hóa đơn
            String payQuery = String.format("SELECT SUM(C.ThanhTien) as ThanhTien "
                    + "FROM hoadon H INNER JOIN chitiethoadon C ON H.idHoaDon = C.idHD "
                    + "WHERE idHoaDon=\"%s\";", maHoaDon);
            
            ResultSet rs = stm.executeQuery(payQuery);
            if (rs.next()) {
                tongTien = rs.getDouble("ThanhTien");
            }
            else 
                return 0;
            
            //Add tongTien vô ThanhTien trong MySQL 
            String setThanhTienQuery = "UPDATE hoadon SET ThanhTien = ? WHERE idHoaDon = ?";
            preparedStatement = connection.prepareStatement(setThanhTienQuery);
            preparedStatement.setDouble(1, tongTien);
            preparedStatement.setString(2, maHoaDon);
            preparedStatement.executeUpdate();            
            
            //Cập nhật bàn từ "đầy" -> "trống"
            String updateBanQuery = "UPDATE ban SET TinhTrang=? WHERE MaBan=?";
            PreparedStatement psBan = connection.prepareStatement(updateBanQuery);
            psBan.setString(1, "Trong");
            psBan.setInt(2, maBan);
            psBan.executeUpdate();
            
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            System.err.println("\nError at pay() " + ex.getMessage());
        }
        return tongTien;
    }

    //=========================== THONG KE DOANH THU ===========================//
    public double revenueStatistic(int month) {
        double doanhThu=0;
        try {
            
            PreparedStatement ps;
            ResultSet rs;
            String query = "SELECT sum(ThanhTien) as DoanhThu FROM hoadon WHERE month(NgayTao) = ?;";
            
            ps = connection.prepareStatement(query);
            ps.setInt(1, month);
            
            rs = ps.executeQuery();
            if (rs.next())
                doanhThu = rs.getDouble("DoanhThu");
            
        } catch (SQLException ex) {
            System.err.println("\nError at revenueStatistic! " + ex.getMessage());
        }
        return doanhThu;
    }
}
