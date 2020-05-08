
package com.postgresqltutorial;

import java.sql.SQLException;

public class AkilliCihazUygulamasi {

    public static void main(String[] args) throws SQLException {
       AgArayuzu.getInstance(); //Kullanıcı doğrulama işlemleri
       AgArayuzu.getInstance().arayuzSecenekler(); //Kullanıcıdan işlem seçeneği 
    }
}
