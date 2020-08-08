package Food;

public class ThucAn extends MonAn implements Cloneable{
         
	public ThucAn() {
            this.danhMuc = "1";
	}

	public ThucAn(String ten, double giaBan, String tinhTrang, String thoiDiemBan) {
            super(ten, giaBan, tinhTrang, thoiDiemBan);
            this.danhMuc = "1";
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
