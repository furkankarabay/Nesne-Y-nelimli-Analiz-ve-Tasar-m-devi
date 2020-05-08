
package com.postgresqltutorial;

public class Eyleyici implements Ekran {

    private boolean sogutucu = false;

    void SogutucuAc()
    {
        if(sogutucu == false)
        {
            sogutucu = true;
            Mesaj(0);
        }
        else
            Mesaj(1);
    }
    
    void SogutucuKapat()
    {
        if(sogutucu == true)
        {
            sogutucu = false;
            Mesaj(2);
        }
        else
            Mesaj(3);
    }
    
    @Override
    public void Mesaj(int hangiMesaj) 
    {  
        switch (hangiMesaj)
        {
            case 0:
                System.out.println("---> Soğutucu açıldı.");
                break;
            case 1:
                System.out.println("---> Soğutucu zaten açık durumda.");
                break;
            case 2:
                System.out.println("---> Soğutucu kapatıldı.");
                break;
            case 3:
                System.out.println("---> Soğutucu zaten kapalı durumda.");
                break;
        }
    }
}
