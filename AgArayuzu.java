
package com.postgresqltutorial;

import java.util.Scanner;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AgArayuzu {
    
    Database data = new Database(); 
    Scanner scanner = new Scanner(System.in);
    Eyleyici eyleyici = new Eyleyici();
    SıcaklıkAlgılayıcı sicaklikAlgilayici = new SıcaklıkAlgılayıcı();
    
    boolean kontrol = true;
    int secim;
    
    private static  AgArayuzu instance ;
  
    public static AgArayuzu getInstance() throws SQLException
    {
        if(instance == null)
        {
            instance = new AgArayuzu();
        }
        return instance;
    }
    
    private AgArayuzu() throws SQLException{
        
        PreparedStatement stmt = data.connect().prepareStatement("select * from login");
        ResultSet Rs = stmt.executeQuery();

        while(kontrol)
        {
            System.out.print("Kullanıcı Adı : ");
            String kullaniciAdi = scanner.next();
        
            System.out.print("Parola : ");
            String parola = scanner.next();
            
            while(Rs.next())
            {
                if (!parola.equals(Rs.getString(2)) || !kullaniciAdi.equals(Rs.getString(1))) {
                } else {
                    System.out.println("---> Başarı ile giriş yaptınız...");
                    kontrol = false;
                    break;
                }       
            }
            if(kontrol == true)
            {
                System.out.println("---> Hatalı kullanıcı adı veya parola girdiniz...");
                System.out.println("---> Lütfen tekrar deneyiniz...");
            }
            Rs = stmt.executeQuery();
        }   
    }
    
    public void arayuzSecenekler()
    {
        System.out.println("---------------------");
        System.out.println("1-Sogutucu Ac");
        System.out.println("2-Sogutucu Kapat");
        System.out.println("3-Sıcaklık Goruntule");
        System.out.println("4-Çıkış");  
        System.out.println("---------------------");
        System.out.print("İşleminiz : ");  
        secim = scanner.nextInt();
        while(secim > 4 || secim < 1)
        {
            System.out.println("---> Hatalı seçim. (1 - 4 arası bir seçenek seçiniz.)"); 
            System.out.print("İşleminiz : "); 
            secim = scanner.nextInt();
        }
        islem();
    }
    
    public void islem()
    {
        switch(secim){
            case 1:
                eyleyici.SogutucuAc();
                arayuzSecenekler();
                break;
            case 2:
                eyleyici.SogutucuKapat();
                arayuzSecenekler();
                break;
            case 3:
                sicaklikAlgilayici.sicaklikOku();
                arayuzSecenekler();
                break;
            case 4:
                System.out.println("---> Çıkış işlemi gerçekleştirildi...");
                break;
        }
            
    }
}
