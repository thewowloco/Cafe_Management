package Employee;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class QuanLyNV {
        
        Scanner scanner = new Scanner(System.in);
	private List<NhanVien> dsNhanVien = new ArrayList<>();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        
        
        public QuanLyNV() {
            this.dsNhanVien = new ArrayList<>();
        }

	public void xemDanhSachNV() {
            this.dsNhanVien.forEach((i) -> {
                System.out.println(i);
            });
	}
        
        public NhanVien nhapThongTinNhanVien() {
            NhanVien nv = new NhanVien();
            System.out.print("\n - Nhap ten nhan vien: ");
            String ten = scanner.nextLine();
            nv.setHoTen(ten);
            
            System.out.print(" - Nhap gioi tinh: ");
            String gioiTinh = scanner.nextLine();
            nv.setGioiTinh(gioiTinh);
            
            System.out.print(" - Nhap que quan: ");
            String queQuan = scanner.nextLine();
            nv.setQueQuan(queQuan);
            
            System.out.print(" - Nhap ngay sinh(dd/MM/yyyy):");
            String SngaySinh = scanner.nextLine();
            try {
                Date DngaySinh = f.parse(SngaySinh);
                 nv.setNgaySinh(DngaySinh);
            } catch (ParseException ex) {
                System.err.print("Ngay sinh khong hop le !!!");
                return null;
            } catch (NullPointerException ex) {
                System.err.println(ex.getMessage());
            }
            
            nv.setNgayVaoLam(new Date());
            
            System.out.println(" - Nhap bo phan truc thuoc: ");
            System.out.print("\t1. Pha che"
                    + "\n\t2. Phuc vu"
                    + "\n\t3. Tiep tan"
                    + "\n\t4. Bao ve"
                    + "\n\t5. Rua chen"
                    + "\n -->");
            String boPhan = null;
            int check = 1;
            do {
                boPhan = scanner.nextLine();
              
                if (!"1".equals(boPhan) && !"2".equals(boPhan) && !"3".equals(boPhan) && !"4".equals(boPhan) && !"5".equals(boPhan)) {
                    System.out.print("Nhap sai!"
                            + "\n - Nhap lai bo phan truc thuoc: ");
                    boPhan = null;
                    check = 0;
                }          
            } while(check == 0);
            nv.setBoPhan(boPhan); 
            return nv;
        }
        
//============================== TRA CUU THONG TIN NHAN VIEN ====================================//
        
        public NhanVien traCuuNVTheoMaNhanVien() {
            try {
                System.out.print(" - Nhap ma nhan vien:... ");
                int maNV = scanner.nextInt(); 
            
                for (int i = 0; i < this.dsNhanVien.size(); i++) {
                    if (this.dsNhanVien.get(i).getMaNhanVien() == maNV)
                        return this.dsNhanVien.get(i);
                }
                System.out.println("Khong tim thay!");
            }catch(InputMismatchException ex) {
                System.out.println("\nNhap sai! " + ex.getMessage());
            }
            return null;
	}
        
	public void traCuuNVTheoHoTen() {
            System.out.print("\nNhap ho ten:... ");
            String hoTen = scanner.nextLine();
            
            QuanLyNV ql = new QuanLyNV();
            this.dsNhanVien.forEach(i-> {
                if (i.getHoTen().toLowerCase().contains(hoTen.toLowerCase())){
                    ql.them(i);
                }
            });
		if (ql.dsNhanVien.size() >= 1) {
                    ql.xemDanhSachNV();
                } else {
                    System.out.println("\nKhong tim thay.");
                }
	}

	public void traCuuNVTheoGioiTinh() {
            System.out.println("\nNhap gioi tinh:... ");
            String gioiTinh = scanner.nextLine();
            
            QuanLyNV ql = new QuanLyNV();    
            this.dsNhanVien.forEach(i -> {
                if (i.getGioiTinh().toLowerCase().contains(gioiTinh.toLowerCase())) {
                    ql.them(i);
                }
            });
            if (ql.dsNhanVien.size() >= 1) {
                ql.xemDanhSachNV();
            } else {
                System.out.println("\nKhong tim thay.");
            }
            
        }

	public void traCuuNVTheoNgaySinh() {
            try {
                System.out.println("\nNhap ngay sinh [ngay/thang/nam]:... ");
                String ns = scanner.nextLine();
                Date ngaySinh = f.parse(ns);
                QuanLyNV ql = new QuanLyNV();
                
                
                this.dsNhanVien.forEach(i -> {
                    if(i.getNgaySinh().compareTo(ngaySinh) == 0)
                        ql.them(i);
                });
                
                if (ql.dsNhanVien.size() >= 1) {
                    ql.xemDanhSachNV();
                } else {
                    System.out.println("\nKhong tim thay.");
                }
                
            } catch (ParseException ex) {
                System.out.println("\nNgay sinh khong hop le!");
            }
	}

	public void traCuuNVTheoQueQuan() {
            System.out.println("\nNhap que quan:... ");
            String queQuan = scanner.nextLine();
            
            QuanLyNV ql = new QuanLyNV();
            this.dsNhanVien.forEach(i -> {
                if (i.getQueQuan().toLowerCase().contains(queQuan.toLowerCase())) {
                    ql.them(i);
                }
            });
            
            if (ql.dsNhanVien.size() >= 1) {
                ql.xemDanhSachNV();
            } else {
                System.out.println("\nKhong tim thay.");
            }
	}
        
//============================ THEM , CAP NHAT , XOA ================================//
	public void them(NhanVien nv) {
            this.dsNhanVien.add(nv);
	}

        public void xoa(NhanVien nv) {
            this.dsNhanVien.remove(nv);
        }
        
	public int capNhat(NhanVien nv) throws ParseException {

            System.out.print(" - Chon chuc nang can cap nhat: ");
            System.out.print("\n\t1. Ho ten"
                            + "\n\t2. Gioi tinh"
                            + "\n\t3. Que quan"
                            + "\n\t4. Ngay sinh"
                            + "\n\t5. Ngay vao lam"
                            + "\n\t6. Bo phan"
                            + "\n -> ");
            
            int n;  //Biến n dùng để chọn thông tin cần cập nhật, 
                    //Phươnng thức capNhat sẽ trả về n, 
                    //để sau này lấy dùng tiếp trong phương thức updateNhanVien trong class ConnectDatabase 
            
            do {
                n = scanner.nextInt();
                if (n<1 || n>6) {
                    System.out.println("Nhap sai! Hay nhap lai." + " -> ");
                }
            } while(n<1 || n>6);
            
            
            switch(n) {
                case 1: 
                {
                    System.out.print("Nhap ho ten muon thay doi: ");
                    scanner.nextLine();
                    String s1 = scanner.nextLine();
                    nv.setHoTen(s1);
                    break;
                }
                case 2:
                {
                    System.out.print("Nhap gioi tinh muon thay doi: ");
                    scanner.nextLine();
                    String s2 = scanner.nextLine();
                    nv.setGioiTinh(s2);
                    break;
                }
                case 3:
                {
                    System.out.print("Nhap que quan muon thay doi: ");
                    scanner.nextLine();
                    String s3 = scanner.nextLine();
                    nv.setQueQuan(s3);
                    break;
                }
                case 4:
                {
                    try {
                        System.out.print("Nhap ngay sinh muon thay doi [ngay/thang/nam]: ");
                        scanner.nextLine();
                        String s4 = scanner.nextLine();
                        nv.setNgaySinh(f.parse(s4));
                    } catch (ParseException ex) {
                        n = 0;
                        System.err.println("\nNgay khong hop le! " + ex.getMessage());
                    }
                    break;
                }
                case 5:
                {
                    try {
                        System.out.print("Nhap ngay vao lam muon thay doi [ngay/thang/nam]: ");
                        scanner.nextLine();
                        String s5 = scanner.nextLine();
                        nv.setNgayVaoLam(f.parse(s5));
                    } catch(ParseException ex) {    //Ngày sinh nhập sai vẽ giữ nguyên 
                        n = 0;
                        System.err.println("\nNgay khong hop le! " + ex.getMessage());
                    }
                    break;
                }
                case 6:
                {
                    try {  
                        System.out.println("Nhap bo phan muon thay doi: ");
                            System.out.print("\t1. Pha che"
                            + "\n\t2.Phuc vu"
                            + "\n\t3. Tiep tan"
                            + "\n\t4. Bao ve"
                            + "\n\t5. Rua chen"
                            + "\n -->");
                                          
                        int s6 = scanner.nextInt();
                        if (s6 >= 1 && s6 <= 5) 
                            nv.setBoPhan(String.valueOf(s6));
                        else {
                            n = 0;
                            System.out.println("\nNhap sai!");
                        }
                            
                    } catch(InputMismatchException ex) {
                        n = 0;
                        System.err.println("\nNhap sai! " + ex.getMessage());
                    }

                    break;
                }
                default:
                    System.out.println("Nhap sai!");
            }
            return n;
	}

        //============================ TO CHUC SINH NHAT =====================//
	public void sinhNhat() {
            Date d = new Date();
            int thisMonth = d.getMonth();
            
            QuanLyNV ql = new QuanLyNV();
            this.dsNhanVien.forEach(i -> {
                if (i.getNgaySinh().getMonth() == thisMonth)
                    ql.them(i);
            });
            ql.xemDanhSachNV();
	}

}
