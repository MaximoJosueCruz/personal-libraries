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
public class cAritmetico {
    
    public long Factorial(int n){
        long res=1;
        
        if(n<0){
            JOptionPane.showMessageDialog(null,"Los factoriales se calculan para valores POSITIVOS");
            
        }else if(n != (int)n){
            JOptionPane.showMessageDialog(null,"Los factoriales se calculan para valores ENTEROS");
        }else{
            for (int i=1; i<=n;i++){
            res=res*i;
        }
        }
        
        
        return res;
    }
    
    public float Potencia(float n, int p){
            //n= valor a potenciar    p= valor de potencia EN ENTEROS
        float res=1;
        
        if(p>0){
           for(int i=0;i<p;i++){
                res=res*n;
            } 
        }else if(p==0){
            res=1;
        }else{
            for(int i=0;i<p;i--){
                res=res/n;
            } 
        }
            
    return res;
    }
    
    public float Raiz(float r){
        float asis=(float) 1.0;
        float asis2;
        float margen=(float) 0.0001;
        do{
            asis2=asis;
            asis=(asis+r/asis)/2;
        }while(ValorAbsoluto(margError(asis,asis2))>margen);
        return asis;
    }
    
    public float ValorAbsoluto(float r){
        if (r<0){
            return -1*r;
        }
        return r;
    }
    
    public float margError(float valA, float valB){
        float Error= ((valA-valB)/valA);
        return Error;
    }
    
}
