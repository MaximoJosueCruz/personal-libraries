/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Verificaciones;

import javax.swing.JOptionPane;

/**
 *
 * @author Chumy
 */
public class verificaciones {
    
    public boolean vInt(float a){
        return (a%1)==0;
    }
    
    public boolean vVacio(String v){
        return(v.equals(""));
    }
    
    public boolean vCar(String v){
        int asisI=0;
        float asisF=0;
        try{
            asisI=Integer.parseInt(v);
            asisF=Float.parseFloat(v);
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,"El valor" +v+ "\nno es un valor con únicamente números");
            return false;
        }
        return true;
    }
}
