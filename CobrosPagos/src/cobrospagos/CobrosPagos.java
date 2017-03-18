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
public class CobrosPagos {
    
    
    enum Opcion { COBRO, PAGO, MOVIMIENTOS, SALIR};
    
    enum TipoMovimiento { CARGO, ABONO};
    
    public BigDecimal saldo = new BigDecimal(0);

    final class Movimiento {
        
        Date fechaRegistro;
        TipoMovimiento tipo;
        String concepto;
        BigDecimal importe;
        
    
        public String toString() {
            
            return tipo.name() + " el " + fechaRegistro + "por "+ importe + "euros" + concepto; 
            
        }
    
    
    }
    
    
    
    final static int MAX_MOVIMIENTOS = 1024;
    
    Movimiento[] movimientos = new Movimiento[MAX_MOVIMIENTOS];
    
    
    int numMovimientos = 0;
    
    
    
    void bucleApp() {
        
        Opcion opcion;
        
        do {
            
            muestraListaOperaciones();
            opcion = solicitaOpcion();
            
            
            switch (opcion){
                
                case COBRO:
                case PAGO:
                    anotaMovimiento (
                            opcion == Opcion.COBRO ? TipoMovimiento.ABONO : TipoMovimiento.CARGO);
                    break;
                
                case MOVIMIENTOS:
                    listaMovimientos();
                    break;
            }
            
            
            System.out.println("En la cuenta hay: ");
            
            
        }while (opcion != Opcion.SALIR);
        
    }
    
    
    void muestraListaOperaciones() {
        
        for (Opcion unaOpcion: Opcion.values())
            System.out.printf("\t%d->%s\n", unaOpcion.ordinal(),unaOpcion.name());
        
    }
    
    Opcion solicitaOpcion() {
        
        Scanner peticion = new Scanner(System.in);
        int opcion;
        
        System.out.print("\nIntroduce el numero de opción a ejecutar: ");
        opcion = peticion.nextInt();
        
        return Opcion.values() [opcion]; 
        
    }
    
    
    void anotaMovimiento (TipoMovimiento tipo){
        
        Scanner scanner = new Scanner (System.in);
        
        movimientos[numMovimientos] = new Movimiento();
        movimientos[numMovimientos].tipo = tipo;
       
        
        movimientos[numMovimientos].fechaRegistro = new Date();
        
        System.out.print("Concepto: ");
        movimientos[numMovimientos].concepto = scanner.nextLine();
        
        System.out.print("Importe: ");
        movimientos[numMovimientos].importe = new BigDecimal(scanner.next());
        
        
      //Contador del saldo que hay en al cuenta
       
       
      
        /*
        if (movimientos[numMovimientos].tipo.equals(TipoMovimiento.ABONO)){
            
            
           BigDecimal saldo = saldo.add(movimientos[numMovimientos].importe);
            
        };
        
        */
        
        
        
        
        System.out.println("\nMovimiento anotado");
        System.out.println(movimientos[numMovimientos].tipo);
        
        numMovimientos++;
        
    }
    
    
    
    void listaMovimientos(){
        
        System.out.println();
        for (int indice = 0; indice < numMovimientos; indice++)
                System.out.println(movimientos[indice]);
        System.out.println();
        
    }
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        //saldo = new BigDecimal(0);
        
        
        (new CobrosPagos()).bucleApp();
        
        // TODO code application logic here
    }
    
}





