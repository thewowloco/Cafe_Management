package Food;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QLMonAn implements Cloneable{
        Scanner scanner = new Scanner(System.in);
        
	private List<MonAn> ds = new ArrayList<>();
        
        public QLMonAn() {
            this.ds = new ArrayList<>();
        }
        
	public void them(MonAn monAn) {
            this.getDs().add(monAn);
	}

	public void xoa(MonAn monAn) {
            this.getDs().remove(monAn);

	}
        
        public void xemDSMonAn() {
            this.getDs().forEach( i -> {
                System.out.println(i);
            });
        }

        public void xemDSMonAnDaDat() {
            for (int i = 0; i < this.getDs().size(); i++ ) {
                System.out.printf("%d. %s - Don gia: %.0f VND - So luong: %d\n", i+1, this.ds.get(i).getTen(),
                        this.ds.get(i).getGiaBan() ,this.ds.get(i).getSoLuong());
            }
        }
        
        public MonAn traCuuMonAn() {
            System.out.println("\nNhap ma mon an:");
            try {
                int maMonAn = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < this.ds.size(); i++) {
                    if (this.ds.get(i).getId() == maMonAn)
                        return this.ds.get(i);
                }
                System.out.println("Khong tim thay!");
            } catch (InputMismatchException ex) {
                System.err.println("\nNhap sai! " + ex.getMessage());
            }
            
            return null;
        }
        
        public MonAn nhapMonAn() {
            try {
                //Chon danh muc
                System.out.println("Nhap ID danh muc cua mon an: "
                                + "\n\t1. Thuc an"
                                + "\n\t2. Thuc uong");
                int id;
                do {
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (id != 1 && id != 2) {
                        System.out.print("\nNhap sai! Hay nhap lai --> ");
                    }
                } while (id != 1 && id != 2);

                //Nhap ten, Gia ban, Tinh trang, Thoi diem ban, Thong tin them(neu co)
                System.out.print("\nNhap ten mon an: ");
                String ten = scanner.nextLine();

                System.out.print("\nNhap gia ban: ");
                double giaBan = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("\nNhap tinh trang (0: Het, 1: Con): ");
                String tinhTrang = null;
                int tt;
                do {
                    tt = scanner.nextInt();
                    switch (tt) {
                        case 1:
                            tinhTrang = "Con";
                            break;
                        case 0:
                            tinhTrang = "Het";
                            break;
                        default:
                            System.out.print("\nNhap sai! Hay nhap lai -> ");
                            break;
                    }
                    
                } while(tt != 0 && tt != 1);

                String thoiDiem;
                do {
                    System.out.print("\nNhap thoi diem ban (Theo thu tu 1: Sang, 2: Trua, 3: Toi): ");
                    int n = scanner.nextInt();
                    thoiDiem = null;
                    switch (n) {
                        case 1:
                            thoiDiem = "Sang";
                            break;
                        case 12:
                            thoiDiem = "Sang, Trua";
                            break;
                        case 13:
                            thoiDiem = "Sang, Toi";
                            break;
                        case 123:
                            thoiDiem = "Sang, Trua, Toi";
                            break;
                        case 2:
                            thoiDiem = "Trua";
                            break;
                        case 23:
                            thoiDiem = "Trua, Toi";
                            break;
                        case 3:
                            thoiDiem = "Toi";
                            break;
                        default:
                            System.out.println("\nNhap sai! Hay nhap lai!");
                            break;
                    }
                } while(thoiDiem == null);

                //Tao doi tuong & Nhap thong tin them 
                int thongTinThem;
                MonAn m;
                if (id == 1) {    //Thuc an
                    m = new ThucAn(ten, giaBan, tinhTrang, thoiDiem);
                    System.out.print("\nMon nay an chay duoc khong? "
                            + "\n(1: Duoc, 0: Khong) --> ");
                    do {
                        thongTinThem = scanner.nextInt();
                        if (thongTinThem != 1 && thongTinThem != 0)
                            System.out.println("\nNhap sai! Hay nhap lai!");
                        else if (thongTinThem == 1)
                            m.setThongTinThem("Mon chay");
                    } while (thongTinThem != 1 && thongTinThem != 0);



                } else {  //Thuc uong
                    m = new ThucUong(ten, giaBan, tinhTrang, thoiDiem);
                    System.out.print("\nMon nay uong da duoc khong? "
                            + "\n(1: Duoc, 0: Khong) --> ");
                    do {
                        thongTinThem = scanner.nextInt();
                        if (thongTinThem != 1 && thongTinThem != 0)
                            System.out.println("\nNhap sai! Hay nhap lai!");
                        else if (thongTinThem == 1)
                            m.setThongTinThem("Co da");
                    } while (thongTinThem != 1 && thongTinThem != 0);
                }

                scanner.nextLine();

                return m;
            } catch(InputMismatchException | NumberFormatException ex) {
                System.err.println("\nNhap sai! " + ex.getMessage());   
            }
            return null;
        }
        
        public MonAn chonTungMon() throws CloneNotSupportedException { 
            MonAn m;
            boolean loop = true;
            
            do {
                m = null;   //gán m = null để sau này kiểm tra cho chắc ăn
                System.out.print("\nNhap ID mon an: ");
                int id = scanner.nextInt();
                //Kiểm tra xem món đó có trong danh sách hay không,
                // nếu có thì clone() món ăn đó vô m 
                for (int i = 0; i < this.ds.size(); i++) {
                    if (this.getDs().get(i).getId() == id){
                        m = (MonAn) this.getDs().get(i).clone();
                    }
                } 
                //Kiem tra de nhap so luong
                 if (m != null) {
                    System.out.print("\nNhap so luong cua " + m.getTen() + ": ");
                    int sl;
                    do {
                        sl = scanner.nextInt();
                        if (sl < 1 || sl > 100) 
                             System.out.print("\nSo luong mon an qua nhieu hoac qua it! Nhap lai ->... ");
                    } while(sl < 1 || sl > 100);
                    
                    m.setSoLuong(sl);
                    System.out.println("\nOK!");                     
                    loop = false;
                } else
                    System.out.println("\nKhong tim thay mon an!");
            } while (loop == true);   
            return m;
        }
        
	public void timKiem(String ten) {
            QLMonAn qLMonAn = new QLMonAn();
            
            this.getDs().forEach( i -> {
                if (i.getTen().toLowerCase().contains(ten.toLowerCase()))
                    qLMonAn.them(i);
            });
            if (qLMonAn.getDs().isEmpty()) {
                System.out.println("\nKhong tim thay!");
            } else {
                qLMonAn.xemDSMonAn();
            }
            
        }

	public void timKiem(double giaNho, double giaLon) 
        {
            try {
                if (giaNho > giaLon){
                    double tam = giaNho;
                    giaNho = giaLon;
                    giaLon = tam;
                }
                
                QLMonAn qLMonAn = new QLMonAn();
              
                for (int i = 0; i < this.getDs().size(); i++) {
                    if (this.getDs().get(i).getGiaBan() <= giaLon && this.getDs().get(i).getGiaBan() >= giaNho)
                        qLMonAn.them(this.getDs().get(i));
                }
                
                if (qLMonAn.getDs().isEmpty()) {
                    System.out.println("\nKhong tim thay!");
                } else {
                    qLMonAn.xemDSMonAn();
                }
            } catch(InputMismatchException ex) {
                System.err.println("\nNhap sai! " + ex.getMessage());
            }
        }

        
        public void sapXepTangDan() {
            QLMonAn deepcopy = new QLMonAn();
            try {
                deepcopy = (QLMonAn)this.clone();
            } catch (CloneNotSupportedException ex) {
                System.err.println("\nEror at sapXepTangDan() " + ex.getMessage());
            }    
            deepcopy.getDs().sort((MonAn m1, MonAn m2) -> {
                double gia1 = m1.getGiaBan();
                double gia2 = m2.getGiaBan();
                
                return (gia1 > gia2) ? 1 : (gia1 < gia2) ? -1 : 0;
            });
            
            deepcopy.xemDSMonAn();
        }


        
        public void sapXepGiamDan() {
            QLMonAn deepcopy =  new QLMonAn(); 
            try {
                deepcopy = (QLMonAn) this.clone();
            } catch (CloneNotSupportedException ex) {
                System.err.println("\nEror at sapXepGiamDan() " + ex.getMessage());
            }
            
            deepcopy.getDs().sort((MonAn m1, MonAn m2) -> {
                double gia1 = m1.getGiaBan();
                double gia2 = m2.getGiaBan();
                
                return (gia1 < gia2) ? 1 : (gia1 > gia2) ? -1 : 0;
            });
            deepcopy.xemDSMonAn();
            
            
        }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        QLMonAn ql;
        try {
            ql = (QLMonAn) super.clone();
            
        } catch (CloneNotSupportedException ex) {
            ql = new QLMonAn();
        }
        
        for (int i = 0; i < this.getDs().size(); i++) {
            ql.getDs().set(i, (MonAn) this.getDs().get(i).clone());                 
        }
        return ql;
    }

    /**
     * @return the ds
     */
    public List<MonAn> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<MonAn> ds) {
        this.ds = ds;
    }

    
        
    

    
    
        
}
