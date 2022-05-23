/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libCalculos;

import javax.swing.JOptionPane;

/**
 *
 * @author Chumy
 */
public class cEcuaciones extends cAritmetico{
    
    public float ecLineal(float ax, float b){
        float res=0;
        res= -b/ax;
        
        return res;
    } //luego cargar las verificaciones
    
    
    public boolean raizInt(float ax, float bx, float c){ //si da true puedes resolver, si no no
        float Rint=(Potencia(bx,2)-4*ax*c);
        if(Rint<0){
            JOptionPane.showMessageDialog(null,"No es posible encontrar valores reales");
            return false;
        }
        return true;
    }
    
    
    public float ecCuadraticaP(float ax, float bx, float c){
        float res=0;
        float Rint=Raiz((Potencia(bx,2)-4*ax*c));
            
        res=(bx+Rint)/(2*ax);
        
        return res;
    }
    public float ecCuadraticaN(float ax, float bx, float c){
        float res=0;
        float Rint=Raiz((Potencia(bx,2)-4*ax*c));
            
        res=(bx-Rint)/(2*ax);
        
        return res;
    }
}
