
package com.postgresqltutorial;

import java.util.Random;

public class SıcaklıkAlgılayıcı implements Ekran{

    private int sicaklikDegeri;
    Random random = new Random();
    
    public void sicaklikOku()
    {
        sicaklikDegeri = random.nextInt(100);
        Mesaj(0);
    }
    @Override
    public void Mesaj(int hangiMesaj) {
        System.out.println("----> Sıcaklık Değeri : "+ sicaklikDegeri);
    }
    
}
