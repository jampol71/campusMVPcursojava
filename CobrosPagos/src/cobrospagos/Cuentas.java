/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobrospagos;


import java.util.Date;
import java.math.BigDecimal;
import java.util.Scanner;
/**
 *
 * @author rafaellucenamartinez
 */
public class Cuentas {

    
    
    
    enum SeleccionarCuentas {CREAR, BORRAR, SELECCIONAR, SALIR};
    

    //void muestraListaOpcionesCuentas()
    

     void bucleApp() {
    
    
            
            SeleccionarCuentas seleccion;
        
        
        do {
            
            muestraListaOperacionesCuentas();
            seleccion = solicitaSeleccion();
            
            
            switch (seleccion){
                
                
                case CREAR:
                    
                    //creacionCuenta();
                    
                break;    
                case BORRAR:
                    
                    //borrarCuenta();
                 break;   
                case SELECCIONAR:
                    
                    //mostrarCuentasDisponibles();
                    
                  break;  
                    
              
                
            }
            
            
            
        }while (seleccion != SeleccionarCuentas.SALIR);
    


     }
    
        
        
   void muestraListaOperacionesCuentas() {
       
       
       for (SeleccionarCuentas unaOpcion: SeleccionarCuentas.values())
       
       System.out.printf("\t%d->%s\n", unaOpcion.ordinal(), unaOpcion.name());
       
   }     
        
 
   
   SeleccionarCuentas solicitaSeleccion() {
       
       Scanner peticion = new Scanner(System.in);
       
       int opcion;
       
       System.out.print("\nIntroduce el número de opción a ejecutar: ");
       
       opcion = peticion.nextInt();
       
       System.out.print(SeleccionarCuentas.values() [opcion]);
       
       return SeleccionarCuentas.values() [opcion];
       
       
       
   }
   
   
   public static void main(String[] args) {
        
        
        
        //saldo = new BigDecimal(0);
        
        
        (new Cuentas()).bucleApp();
        
        // TODO code application logic here
    }
   
   
   
   
}


