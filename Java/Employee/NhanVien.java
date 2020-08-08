package Employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVien {

//	private static int count = 0;

        private int maNhanVien;
        
	private String hoTen;

	private String gioiTinh = "";

	private String queQuan = "";

	private Date ngaySinh;

	private Date ngayVaoLam;

	private String boPhan;

        public NhanVien(){
//            ++count;
//            this.maNhanVien = count;
        }
        public NhanVien(int maNhanVien, String hoTen, Date ngaySinh, Date ngayVaoLam, String boPhan) {
            this.maNhanVien = maNhanVien;
            this.hoTen = hoTen;
            this.ngaySinh = ngaySinh;
            this.ngayVaoLam = ngayVaoLam;
            this.boPhan = boPhan;
            //++maNhanVien;
	}
        
	public NhanVien(int maNhanVien, String hoTen, String gioiTinh, String queQuan, Date ngaySinh, Date ngayVaoLam, String boPhan) {
            this(maNhanVien,hoTen, ngaySinh, ngayVaoLam, boPhan);
            this.queQuan = queQuan;
            this.gioiTinh = gioiTinh;
            this.ngaySinh = ngaySinh;
        }

    /**
     * @return the maNhanVien
     */
    public int getMaNhanVien() {
        return this.maNhanVien;
    }

        /**
     * @param maNhanVien the maNhanVien to set
     */
    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    
    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the ngayVaoLam
     */
    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    /**
     * @param ngayVaoLam the ngayVaoLam to set
     */
    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    /**
     * @return the boPhan
     */
    public String getBoPhan() {
        return boPhan;
    }

    /**
     * @param boPhan the boPhan to set
     */
    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }

    @Override
    public String toString() {
        
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        
        
        StringBuilder s = new StringBuilder();
        s.append("\nMa nhan vien: ").append(this.getMaNhanVien());
        s.append("\nTen nhan vien: ").append(this.getHoTen());
        s.append("\nGioi tinh: ").append(this.getGioiTinh());
        s.append("\nQue quan: ").append(this.getQueQuan());
        s.append("\nNgay sinh: ").append(f.format(this.getNgaySinh()));
        s.append("\nNgay vao lam: ").append(f.format(this.getNgayVaoLam()));
        s.append("\nBo phan: ").append(this.boPhan);
        return s.toString(); 
    }


    
}
            