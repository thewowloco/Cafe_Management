/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Employee.*;
import Table.*;
import Food.*;
import Order.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dungm
 */
public class Menu {
    
    Scanner scanner = new Scanner(System.in);
    ConnectDatabase connectDatabase = new ConnectDatabase();
    boolean mainLoop = true;
    boolean loop = true;
    public Menu(){
        connectDatabase.connect();
        
    };
    
    public void mainMenu() throws ParseException {
        
        while (mainLoop == true) {
            loop = true;
            while (loop == true) {
                System.out.println("\n======== QUAN LY QUAN CAFE ========");
                System.out.print("# 1. Quan ly nhan vien             #"
                             + "\n# 2. Quan ly thong tin ban         #"
                             + "\n# 3. Quan ly mon an                #"
                             + "\n# 4. To chuc sinh nhat             #"
                             + "\n# 5. Dat ban                       #"
                             + "\n# 6. Thanh toan hoa don            #"
                             + "\n# 7. Thong ke doanh thu theo thang #"
                             + "\n# X. Thoat                         #"
                             + "\n===================================="
                        + "\n --> ");
                String chucNangMenuChinh = scanner.nextLine();
                switch(chucNangMenuChinh) {
                    case "1" : {
                            this.QuanLyNVMenu();
                        break;
                    }
                    case "2" : {
                            this.QuanLyThongTinBanMenu();
                        break;
                    }
                    case "3" : {
                            this.QuanLyMonAnMenu();
                        break;
                    }
                    case "4" : {                       
                            this.toChucSinhNhat();
                        break;
                    }
                    case "5" : {                        
                            this.datBan();
                        break;
                    }
                    case "6" : {                       
                            this.thanhToan();
                        break;
                    }
                    case "7" : {
                            this.ThongKeDoanhThu();
                        break;
                    }
                    default : {
                        System.out.println("Thoat chuong trinh");
                        loop = false;
                        mainLoop = false;
                        //scanner.close();
                        break;
                    }
                }
                
            }
            
        }
        
        
    }
    
    //=========================== QUAN LY NHAN VIEN ===========================//
    
    public void QuanLyNVMenu() throws ParseException{
        
        QuanLyNV qlNV = new QuanLyNV();
        connectDatabase.getDataNhanVien(qlNV);
        
        System.out.println("---------------------------------");
        System.out.println("QUAN LY NHAN VIEN: ");
        System.out.println("Chon chuc nang: ");
        System.out.print(" + 1. Xem danh sach nhan vien"
                + "\n + 2. Tra cuu nhan vien theo ho ten"
                + "\n + 3. Tra cuu nhan vien theo gioi tinh"
                + "\n + 4. Tra cuu nhan vien theo ngay sinh"
                + "\n + 5. Tra cuu nhan vien theo que quan"
                + "\n + 6. Them nhan vien"
                + "\n + 7. Cap nhat nhan vien"
                + "\n + 8. Xoa nhan vien"
                + "\n + X. Quay lai menu chinh"
                + "\n --> ");

        String chucNang = scanner.nextLine();
        
        switch(chucNang) {
            case "1" : {
                qlNV.xemDanhSachNV();
                break;
            }
            case "2" : {
                qlNV.traCuuNVTheoHoTen();
                break;
            }
            case "3" : {
                qlNV.traCuuNVTheoGioiTinh();
                break;
            }
            case "4" : {
                qlNV.traCuuNVTheoNgaySinh();
                break;
            }
            case "5" : {
                qlNV.traCuuNVTheoQueQuan();
                break;
            }
            case "6" : {
                NhanVien nv = qlNV.nhapThongTinNhanVien();
                if (nv != null)
                    connectDatabase.addNhanVien(nv);
                else
                    System.out.println("\nNhap thong tin khong thanh cong!");
                break;
            }
            case "7" : {
                NhanVien nv = qlNV.traCuuNVTheoMaNhanVien();
                if (nv != null) {
                    int maCotCapNhat = qlNV.capNhat(nv);
                    connectDatabase.updateNhanVien(nv, maCotCapNhat);
                }

                break;
            }
            case "8" : {
                NhanVien nv = qlNV.traCuuNVTheoMaNhanVien();
                if (nv != null) {
                    connectDatabase.deleteNhanVien(nv);
                }

                break;
            }
            default : {
                loop = false;
            }
            
        }
        
    }
    //============================= QUAN LY BAN ================================//
    public void QuanLyThongTinBanMenu() {
        QuanLyThongTinBan qlBan = new QuanLyThongTinBan();
        connectDatabase.getDataBan(qlBan);
        
        System.out.println("---------------------------------");
        System.out.println("QUAN LY THONG TIN BAN: ");
        System.out.println("Chon chuc nang: ");
        System.out.print(" + 0. Xem danh sach ban"
                + "\n + 1. Xem danh sach ban trong"
                + "\n + 2. Tim kiem ban theo suc chua"
                + "\n + 3. Them ban"
                + "\n + 4. Cap nhat ban"
                + "\n + 5. Xoa ban"
                + "\n + X. Quay lai menu chinh"
                + "\n --> ");

        String chucNang = scanner.nextLine();
        
        switch(chucNang) {
            case "0" : {
                qlBan.xemDSBan();
                break;
            }
            case "1" : {
                qlBan.xemDSBanTrong();
                break;
            }
            case "2" : {
                qlBan.timKiemTheoSucChua();
                break;
            }
            case "3" : {
                Ban ban = qlBan.nhapThongTinBan();
                if (ban != null)
                    connectDatabase.addBan(ban);
                else
                    System.out.println("\nThem ban khong thanh cong!");
                break;
            }
            case "4" : {
                Ban ban = qlBan.traCuuBanTheoMaBan(); 
                if (ban != null) {
                    int maCotCapNhat = qlBan.capNhat(ban);
                    connectDatabase.updateBan(ban, maCotCapNhat);                    
                }
                break;
            }
            case "5" : {
                Ban ban = qlBan.traCuuBanTheoMaBan();
                if (ban != null) {
                    connectDatabase.deleteBan(ban);
                }
                break;
            }
            default : {
                loop = false;
            }
            
        }
    }
    //========================= QUAN LY MON AN ====================//
    public void QuanLyMonAnMenu() throws ParseException{
        
        QLMonAn qlMA = new QLMonAn();
        connectDatabase.getDataMonAn(qlMA);
        
        System.out.println("---------------------------------");
        System.out.println("QUAN LY MON AN: ");
        System.out.println("Chon chuc nang: ");
        System.out.print(" + 0. Xem danh sach mon an"
                + "\n + 1. Tim kiem theo ten"
                + "\n + 2. Tim kiem theo khoang gia"
                + "\n + 3. Sap xep theo gia tang dan"
                + "\n + 4. Sap xep theo gia giam dan"
                + "\n + 5. Sap xep theo danh muc"
                + "\n + 6. Them"
                + "\n + 7. Xoa"
                + "\n + X. Quay lai menu chinh"
                + "\n --> ");

        String chucNang = scanner.nextLine();
        
        switch(chucNang) {
            case "0" : {
                qlMA.xemDSMonAn();
                break;
            }
            case "1" : {
                System.out.print("\nNhap ten mon an: ");
                String ten = scanner.nextLine();
                qlMA.timKiem(ten);
                break;
            }
            case "2" : {
                try {
                    int gia1, gia2;
                    System.out.print("\nNhap gia cua mon an: "
                            + "\n\t- Bat dau tu...");
                    gia1 = scanner.nextInt();
                    System.out.print("\n\t- den...");
                    gia2 = scanner.nextInt();
                    qlMA.timKiem(gia1, gia2);
                    scanner.nextLine();
                } catch(InputMismatchException ex) {
                    System.err.println("\nNhap sai! " + ex.getMessage());
                }
                break;
            }
            case "3" : {
                connectDatabase.sapXep("tang dan");
                break;
            }
            case "4" : {
                connectDatabase.sapXep("giam dan");
                break;
            }
            case "5" : {
                connectDatabase.sapXep("danh muc");
                break;
            }
            case "6" : {
                MonAn m = qlMA.nhapMonAn();
                if (m != null)
                    connectDatabase.addMonAn(m);
                else
                    System.out.println("\nThem mon an khong thanh cong");
                break;
            }
            case "7" : {
                MonAn m = qlMA.traCuuMonAn();
                if (m != null)
                    connectDatabase.deleteMonAn(m);
                break;
            }
            default : {
                loop = false;
            }
            
        }
        
    }
    
    //========================TO CHUC SINH NHAT ======================//
    public void toChucSinhNhat() {
        QuanLyNV qlNV = new QuanLyNV();
        connectDatabase.getDataNhanVien(qlNV);
        qlNV.sinhNhat();
        loop = false;
    }
    
    //================================= DAT BAN ==============================//
    
    public Ban chonBan() {
        int soLuongNguoi;
        System.out.println("\nNhap so luong nguoi: ");  
        Ban ban = new Ban();
        try {        
            do {
                soLuongNguoi = scanner.nextInt();
                if (soLuongNguoi < 1 || soLuongNguoi > 25) {
                    System.out.print("\nSo luong nguoi qua lon hoac qua be."
                            + "\nHay nhap lai ->... ");
                }
                ban = connectDatabase.chooseBan(soLuongNguoi);
            } while (soLuongNguoi < 1 || soLuongNguoi > 25);
        
        System.out.print(ban); 
                
       loop = false;
        } catch (InputMismatchException ex) {
            System.err.println("\nNhap sai! " + ex.getMessage());
            ban = null;
        }
        scanner.nextLine();
        return ban;
    }
    
    public QLMonAn chonMon() {
        QLMonAn qlMA = new QLMonAn();   //Lấy danh sách từ MySQL 
        connectDatabase.getDataMonAn(qlMA);
        
        QLMonAn dsma = new QLMonAn();   //Danh sách các món ăn trả về
        
        boolean chonMonLoop = true;
        
        do {
            System.out.println("\nChon chuc nang: ");
            System.out.print(" + 0. Xem danh sach mon an"
                    + "\n + 1. Tim kiem theo ten"
                    + "\n + 2. Tim kiem theo khoang gia"
                    + "\n + 3. Sap xep theo gia tang dan"
                    + "\n + 4. Sap xep theo gia giam dan"
                    + "\n + 5. Sap xep theo danh muc"
                    + "\n + 6. Chon mon"
                    + "\n + x. Thoat"
                    + " -->... ");
            String chucNang = scanner.nextLine();

            switch(chucNang) {
                case "0" : {
                    qlMA.xemDSMonAn();
                    break;
                }
                case "1" : {
                    System.out.print("\nNhap ten mon an: ");
                    String ten = scanner.nextLine();
                    qlMA.timKiem(ten);
                    break;
                }
                case "2" : {
                    try {
                        int gia1, gia2;
                        System.out.print("\nNhap gia cua mon an: "
                                + "\n\t- Bat dau tu...");
                        gia1 = scanner.nextInt();
                        System.out.print("\n\t- den...");
                        gia2 = scanner.nextInt();
                        qlMA.timKiem(gia1, gia2);
                        scanner.nextLine();
                    } catch(InputMismatchException ex) {
                        System.err.println("\nNhap sai! " + ex.getMessage());
                    }
                    break;
                }
                case "3" : {
                    connectDatabase.sapXep("tang dan");
                    break;
                }
                case "4" : {
                    connectDatabase.sapXep("giam dan");
                    break;
                }
                case "5" : {
                    connectDatabase.sapXep("danh muc");
                    break;
                }
                case "6" : {     
                    try {
                        String loopCase6;
                        do {
                            MonAn m = qlMA.chonTungMon();
                            dsma.them(m);
                            
                            System.out.print("\nTiep tuc? (1: YES, X: NO) ");
                            loopCase6 = scanner.nextLine();
                        }while(loopCase6.equalsIgnoreCase("1"));

                    } catch (CloneNotSupportedException | InputMismatchException ex) {
                        System.err.println("\nError at chonMon() " + ex.getMessage());
                    }
                }
                default : 
                    chonMonLoop = false;
            }
        } while (chonMonLoop == true);

        return dsma;
    }
    
    
    public void datBan() {

        Ban ban = chonBan();
        QLMonAn qlma = new QLMonAn();
        
        if (ban != null)
            qlma = chonMon();            
   
        if (!qlma.getDs().isEmpty()) {
            try {
                connectDatabase.orderTable(ban, qlma);
                System.out.println("Danh sach mon an da dat: ");
                qlma.xemDSMonAnDaDat();
        
                System.out.println("\nDAT BAN THANH CONG!!!");
            } catch (SQLException ex) {
                System.err.println("\nError at datBan() in Menu.java " + ex.getMessage());
            }
        }
        
        
        
        loop = false;

    }
  
    //================================= THANH TOAN ==============================//
    public void thanhToan(){
        try {
            QLHoaDon qlHD = new QLHoaDon();
            connectDatabase.getHoaDon(qlHD);
            double tongTien;
            HoaDon order = qlHD.traCuuBanTheoMaHoaDon();
            
            if (order != null) {
                tongTien = connectDatabase.pay(order.getMaHoaDon());
                System.out.printf("\nSo tien can thanh toan la: %.0f VND\n", tongTien);
            } else
                System.out.println("\nNhap sai hoa don!");
            
        loop = false;
        } catch (SQLException ex) {
            System.err.println("\nError at thanhToan() " + ex.getMessage());
        }

    }
    
    //=========================== THONG KE DOANH THU ===========================//
    public void ThongKeDoanhThu() {
        
        try {
            int month;
            System.out.print("\nNhap thang:... ");
            do {
                month = scanner.nextInt();
                scanner.nextLine();
                if (month < 1 || month > 12)
                    System.out.println("\nNhap sai! Hay nhap lai ->... ");
            } while(month < 1 || month > 12);
            
            double doanhThu = connectDatabase.revenueStatistic(month);
            
            System.out.printf("\nDoanh thu thang %d: %.0f VND\n", month, doanhThu);
        } catch (InputMismatchException ex) {
            System.err.println("\nNhap sai!" + ex.getLocalizedMessage());
        }
        loop = false;
        
    }
    
}
