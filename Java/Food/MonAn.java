package Food;

public abstract class MonAn {

        private int id;
    
	private String ten;

	private double giaBan;

	private String tinhTrang;

	private String thoiDiemBan;

        private int soLuong = 0;
        
	String danhMuc = "";
        
        private String thongTinThem = "";
        
	public MonAn() {

	}

	public MonAn(String ten, double giaBan, String tinhTrang, String thoiDiemBan) {
            this.ten = ten;
            this.giaBan = giaBan;
            this.tinhTrang = tinhTrang;
            this.thoiDiemBan = thoiDiemBan;
	}

    //=============== GETTER & SETTER =========================/
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the giaBan
     */
    public double getGiaBan() {
        return giaBan;
    }

    /**
     * @param giaBan the giaBan to set
     */
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    /**
     * @return the tinhTrang
     */
    public String getTinhTrang() {
        return tinhTrang;
    }

    /**
     * @param tinhTrang the tinhTrang to set
     */
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    /**
     * @return the thoiDiemBan
     */
    public String getThoiDiemBan() {
        return thoiDiemBan;
    }

    /**
     * @param thoiDiemBan the thoiDiemBan to set
     */
    public void setThoiDiemBan(String thoiDiemBan) {
        this.thoiDiemBan = thoiDiemBan;
    }

    /**
     * @return the danhMuc
     */
    public String getDanhMuc() {
        return danhMuc;
    }

    /**
     * @param danhMuc the danhMuc to set
     */
    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    /**
     * @return the thongTinThem
     */
    public String getThongTinThem() {
        return thongTinThem;
    }

    /**
     * @param thongTinThem the thongTinThem to set
     */
    public void setThongTinThem(String thongTinThem) {
        this.thongTinThem = thongTinThem;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
        @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("\nMa mon an: %s", getId()));
        s.append(String.format("\nTen mon: %s", getTen()));
        s.append(String.format("\nGia ban: %.0f VND", getGiaBan()));
        s.append(String.format("\nTinh trang: %s", getTinhTrang()));
        s.append(String.format("\nThoi diem ban: %s", getThoiDiemBan()));
        s.append(String.format("\nDanh muc: %s", getDanhMuc()));
        s.append(String.format("\n%s", this.getThongTinThem() == null ? "" : this.getThongTinThem()));
        
        return s.toString();
    }

     @Override
    protected Object clone() throws CloneNotSupportedException  {
        try {
            return (MonAn) super.clone();
        } catch (CloneNotSupportedException ex) {
            MonAn a = new ThucAn(this.getTen(), this.getGiaBan(), this.getTinhTrang(), this.getThoiDiemBan());
            a.setThongTinThem(this.getThongTinThem());
            a.setId(this.getId());
            return a;
        }
    }



}
