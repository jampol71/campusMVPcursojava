/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesanidadas;

import java.math.BigDecimal;

/**
 *
 * @author rafaellucenamartinez
 */
public class Clasesanidadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        (new Aplicacion()).run();
        
        
    }
    
}


class Aplicacion {
    
    public void run() {
        Factura f = new Factura();
        Factura.Linea l;
        
        
        
        l = f.new Linea("Caja discos", 2, new BigDecimal("10.5"));
        System.out.println(l);
        //f.anadeLinea(l);
        f.anadeLinea("Conector USB", 1, new BigDecimal("8.45"));
        
        
    }
    
    
}


