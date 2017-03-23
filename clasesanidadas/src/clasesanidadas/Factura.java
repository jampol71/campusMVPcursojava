/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesanidadas;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author rafaellucenamartinez
 */
public class Factura {
    
    public static final int MAX_LINEAS_FACTURA = 10;
    private static int siguienteNumero = 1;
    
    private Date fecha;
    private int numero;
    private BigDecimal importe;
    private Linea [] lineasFactura;
    private int numLineasFactura;

    
    
    
    
    
    
    
    public class Linea {
        
        private int numero;
        private String concepto;
        private int unidades;
        private BigDecimal precio;
        
        public Linea (String c, int u, BigDecimal p) {
            
            numero = numLineasFactura + 1; //Acceso a miembro de instancia de la clase externa
            concepto = c;
            unidades = u;
            precio = p;
            
        }
        
        @Override
        
        public String toString() {
            
            return "Linea{" + "numero=" +getNumero() +", concepto=" + getConcepto() + ", unidades" + getUnidades() + ", precio" + getPrecio() + '}';
            
        }
        
        

        /**
         * @return the numero
         */
        public int getNumero() {
            return numero;
        }

        /**
         * @param numero the numero to set
         */
        public void setNumero(int numero) {
            this.numero = numero;
        }

        /**
         * @return the concepto
         */
        public String getConcepto() {
            return concepto;
        }

        /**
         * @param concepto the concepto to set
         */
        public void setConcepto(String concepto) {
            this.concepto = concepto;
        }

        /**
         * @return the unidades
         */
        public int getUnidades() {
            return unidades;
        }

        /**
         * @param unidades the unidades to set
         */
        public void setUnidades(int unidades) {
            this.unidades = unidades;
        }

        /**
         * @return the precio
         */
        public BigDecimal getPrecio() {
            return precio;
        }

        /**
         * @param precio the precio to set
         */
        public void setPrecio(BigDecimal precio) {
            this.precio = precio;
        }
        
        
        
        
        
        
        
        
    } // class LineaFactura
   
    
    
    
    
    
    
    
   
    
    
    @Override
    
    public String toString() {
        
        String str = "Factura{" + "fecha=" + getFecha() +  ", numero" + getNumero() + ", importe" + getImporte() + ", lineasFactura=";
        
        for (int indice = 0; indice < numLineasFactura; indice++)
            str = str + getLineasFactura() [indice];
        
        
        return str + ", numLineasFactura=" + numLineasFactura + '}';
        
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the importe
     */
    public BigDecimal getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    /**
     * @return the lineasfactura
     */
    public Linea[] getLineasFactura() {
        return lineasFactura;
    }

    /**
     * @param lineasfactura the lineasfactura to set
     */
    public void setLineasFactura(Linea[] lineasfactura) {
        this.lineasFactura = lineasfactura;
    }

     
    
    
    
    public void anadeLinea (Linea l) {
        
        
       getLineasFactura() [numLineasFactura++] = l;
       actualizaImporte();
       
    }
    
    
    public void anadeLinea (String concepto, int unidades, BigDecimal precio) {
        
        anadeLinea (new Linea (concepto, unidades, precio));
        
    }
    
    private void actualizaImporte() {
        
        setImporte(new BigDecimal("0"));
        for (int indice = 0; indice < numLineasFactura; indice++)
            setImporte(getImporte().add(getLineasFactura() [indice].getPrecio()
                    .multiply(new BigDecimal (getLineasFactura() [indice]
                    .getUnidades()))));
           
        
    }
    
        
    
    
    
}
