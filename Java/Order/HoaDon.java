/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dungm
 */
public class HoaDon {
    private String maHoaDon;
    private int maBan;
    private double thanhTien;
    private Date ngayTao;

    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * @return the maHoaDon
     */
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public HoaDon(){}
    public HoaDon(String maHD, int maBan, double tongTien, Date ngayTao) {
        this.maHoaDon = maHD;
        this.maBan = maBan;
        this.thanhTien = tongTien;
        this.ngayTao = ngayTao;
    }
    
    /**
     * @param maHoaDon the maHoaDon to set
     */
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    /**
     * @return the maBan
     */
    public int getMaBan() {
        return maBan;
    }

    /**
     * @param maBan the maBan to set
     */
    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    /**
     * @return the ThanhTien
     */
    public double getThanhTien() {
        return thanhTien;
    }

    /**
     * @param ThanhTien the ThanhTien to set
     */
    public void setThanhTien(double ThanhTien) {
        this.thanhTien = ThanhTien;
    }

    /**
     * @return the ngayTao
     */
    public Date getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao the ngayTao to set
     */
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Ma hoa don: %s", this.maHoaDon));
        s.append(String.format("\nMa ban: %d", this.maBan));
        s.append(String.format("\nTong tien: ", this.thanhTien));
        s.append(String.format("\nNgay tao: ", f.format(ngayTao)));
        return s.toString(); //To change body of generated methods, choose Tools | Templates.
    }
        
}
