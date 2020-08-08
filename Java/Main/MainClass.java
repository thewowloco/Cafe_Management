/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.sql.*;
import java.text.ParseException;
import java.util.NoSuchElementException;


/**
 *
 * @author dungm1
 */
public class MainClass {
    
    public static void main(String[] args) throws SQLException, ParseException, NoSuchElementException, IllegalStateException {
                
        Menu menu = new Menu();
        menu.mainMenu();
             
        System.out.println("_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!!_");
        

      
    }
}
