/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dungm
 */
public class QLHoaDon {
    Scanner scanner = new Scanner(System.in);
    List<HoaDon> dsHD = new ArrayList<>();

    public QLHoaDon() {
        this.dsHD = new ArrayList<>();
    }
    public void them(HoaDon order) {
        this.dsHD.add(order);
    }
    
    public HoaDon traCuuBanTheoMaHoaDon() {
        System.out.print("\n - Nhap ma hoa don:... ");
        String maHoaDon = scanner.nextLine();
            
          
        for (int i = 0; i < this.dsHD.size(); i++) {
            if (this.dsHD.get(i).getMaHoaDon().compareToIgnoreCase(maHoaDon) == 0) {
               return this.dsHD.get(i);
            }
        }  
       return null; 
    }
    
}
