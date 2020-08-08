package Table;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QuanLyThongTinBan {

	private List<Ban> dsBan = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        public QuanLyThongTinBan(){
            this.dsBan = new ArrayList<>();
        }
        
        //============= XEM, TIM KIEM ==========================//
        
        public void xemDSBan() {
            this.dsBan.forEach(i-> {
                System.out.println(i);
            });
        }
        
	public void xemDSBanTrong() {
            QuanLyThongTinBan qlBan = new QuanLyThongTinBan();
            for (int i = 0; i < this.dsBan.size(); i++){
                if (this.dsBan.get(i).getTinhTrang().compareToIgnoreCase("trong") == 0) {
                    qlBan.them(this.dsBan.get(i));
                }
            }
            qlBan.xemDSBan();
	}
        
        public void timKiemTheoSucChua() {
            try {
                System.out.println("\nNhap so luong nguoi: ");
                int soLuong = scanner.nextInt();
                QuanLyThongTinBan qlBan = new QuanLyThongTinBan();
                this.dsBan.forEach(i -> {
                    if (soLuong > 0 && soLuong <= i.getSucChua())
                        qlBan.them(i);
                });
                if (qlBan.dsBan.size() > 0)
                    qlBan.xemDSBan();
                else
                    System.out.println("\nKhong tim thay ban phu hop!");
            } catch (InputMismatchException ex) {
                System.err.println("\nNhap sai! " + ex.getMessage());
            }
        }
        
        public Ban nhapThongTinBan() {
            Ban ban = new Ban();
            try {
                ban.setTinhTrang("Trong");  //Mặc định là bàn trống 
                System.out.println("\nNhap suc chua: ");
                int sucChua;
                do {
                    sucChua = scanner.nextInt();
                    if (sucChua < 1 || sucChua > 25) {
                        System.out.print("Nhap sai! Hay nhap lai." + " -> ");
                    }
                } while (sucChua < 1 || sucChua > 25);
                ban.setSucChua(sucChua); 
            } catch(InputMismatchException ex) {
                System.err.println("\nNhap sai! " + ex.getMessage());
                ban = null;
            }
            return ban;
        }
        
        public Ban traCuuBanTheoMaBan() {
            System.out.println("\n - Nhap ma ban:... ");
            String maBan = scanner.nextLine();
            
          
            for (int i = 0; i < this.dsBan.size(); i++) {
                if (this.dsBan.get(i).getMaBan().compareToIgnoreCase(maBan) == 0) {
                   return this.dsBan.get(i);
                }
            }  
            System.out.println("\nKhong tim thay!");
            return null;
        }
        
        //============ THEM, CAP NHAT, XOA ==========================/
        
    	public void them(Ban ban) {
            this.dsBan.add(ban);
	}
        
	public int capNhat(Ban ban) {
            
            System.out.print("Chon chuc nang can cap nhat: ");
            System.out.print("\n\t1. Suc chua"
                            + "\n\t2. Tinh trang"
                            + "\n\t -> ");
            int n = 0;  //Biến n dùng để chọn thông tin cần cập nhật, 
                    //Phươnng thức capNhat sẽ trả về n, 
                    //để sau này lấy dùng tiếp trong phương thức updateBan trong class ConnectDatabase
            
            try {
                do {    
                n = scanner.nextInt();
                if (n != 1 && n != 2)
                     System.out.println("Nhap sai! Hay nhap lai." + " -> ");
                }while(n != 1 && n!= 2);

                switch(n) {
                    case 1: 
                    {
                        System.out.print("Nhap suc chua can thay doi: ");
                        int sucChua;
                        do {
                            sucChua = scanner.nextInt();
                            if (sucChua < 1 || sucChua > 25) {
                                System.out.print("Nhap sai! Hay nhap lai." + " -> ");
                            }
                        } while (sucChua < 1 || sucChua > 25);

                        ban.setSucChua(sucChua);
                         break;
                    }
                    case 2:
                    {
                        System.out.print("Nhap tinh trang ban can thay doi (0: TRONG, 1: DAY): ");
                        int tinhTrang;
                        do {
                            tinhTrang = scanner.nextInt();
                            if (tinhTrang != 0 && tinhTrang != 1) {
                                System.out.print("Nhap sai! Hay nhap lai." + " -> ");
                            }
                        }while(tinhTrang != 0 && tinhTrang != 1 );

                        ban.setTinhTrang(tinhTrang == 0 ? "Trong" : "Day");
                        break;
                }
            } 
            } catch (InputMismatchException ex) {
                System.out.println("\nNhap sai! " + ex.getMessage());
                n = 0;
            }
                 
            return n;
        }

	public void xoa(Ban ban) {
            this.dsBan.remove(ban);
	}      

}
