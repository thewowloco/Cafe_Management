
package Table;
public class Ban {

	private String maBan;

	private int sucChua;

	private String tinhTrang;


        public Ban(){
        }
	

        /**
         * @param sucChua > 0
         * @param tinhTrang true is empty, false is full 
         */
        public Ban(int sucChua, String tinhTrang) {
            this.sucChua = sucChua;
            this.tinhTrang = tinhTrang;
	}
        
     /**
     * @param maBan the maBan to set
     */
    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    /**
     * @return the maBan
     */
    public String getMaBan() {
        return maBan;
    }

    /**
     * @return the sucChua
     */
    public int getSucChua() {
        return sucChua;
    }

    /**
     * @param sucChua the sucChua to set
     */
    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nMa ban: ").append(this.getMaBan());
        s.append("\nSuc chua: ").append(this.getSucChua());
        s.append("\nTinh trang: ").append(this.tinhTrang);
        return s.toString();
    }


}
