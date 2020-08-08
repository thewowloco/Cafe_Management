package Food;

public class ThucUong extends MonAn {

	public ThucUong() {
            this.danhMuc = "2";
	}

	public ThucUong(String ten, double giaBan, String tinhTrang, String thoiDiemBan) {
            
            super(ten, giaBan, tinhTrang, thoiDiemBan);
            this.danhMuc = "2";
	}


    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return (MonAn) super.clone();
        } catch(CloneNotSupportedException ex) {
            MonAn a = new ThucUong(this.getTen(), this.getGiaBan(), this.getTinhTrang(), this.getThoiDiemBan());
            a.setThongTinThem(this.getThongTinThem());
            a.setId(this.getId());
            return a;
        }
    }
  
}
