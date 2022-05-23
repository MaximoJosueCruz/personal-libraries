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
public class cFiguras extends cAritmetico{
    float p,a,ac,vc,angulo,apotema;
    
    public String getP(){
        return Float.toString(p);
    }
    public String getA(){
        return Float.toString(a);
    }
    public String getAC(){
        return Float.toString(ac);
    }
    public String getV(){
        return Float.toString(vc);
    }
    public String getAngulo(){
        return Float.toString(angulo);
    }
    public String getApotema(){
        return Float.toString(apotema);
    }
    
    public void sFigP(float lado, float apotema, float largo, int lados,String figura){
                switch(figura){
                case "Círculo":
                    this.p=circuloP(lado);
                    this.a=circuloA(lado);
                    break;
            
                case "Triángulo":
                    this.p=trianguloP(lado,largo);
                    this.a=trianguloA(lado,largo);
                
                break;
                case "Cuadrado" :
                    this.p=cuadradoP(lado);
                    this.a=cuadradoA(lado);
                
                break;
                case "Rectángulo" :
                    this.p=rectanguloP(lado,largo);
                    this.a=rectanguloA(lado,largo);
                break;
                case "Polígono":
                    this.p=poligonoP(lado,lados);
                    this.angulo=anguloP(lados);
                    this.apotema=apotemaC(lado,anguloP(lados));
                    this.a=poligonoA(lado,lados,this.apotema);
                    this.anguloP(lados);
                break;
            
            }
            
        
        
    }
    public void sFigP(float lado, float apotema, float largo,float altura, int lados,String figura,String tipo){
        if("Esfera".equals(tipo)){
            this.p=circuloP(lado);
            this.ac=esferaA(lado);
            this.vc=esferaV(lado);
        }else{
            sFigP(lado, apotema,largo,lados,figura);
                switch(tipo){
                    case"Prisma":
                        this.ac=prismaA(altura);
                        this.vc=prismaV(altura);
                        break;
                    case"Pirámide":
                        this.vc=piramideV(altura);
                        break;
                } 
        }
        
        
        
    }
    
    
    public float trianguloA(float base, float altura){
        return (base*altura)/2;
    }
    public float trianguloP(float base, float altura){
        //float diag=hipotenusaC()
        float res=(base+2*hipotenusaC(base/2, altura));
        return res;
    }
    
    public float cuadradoA(float base){
        return Potencia(base,2);
    }
    public float cuadradoP(float base){
        return 4*base;
    }
    
    public float rectanguloA(float base, float altura){
        return base*altura;
    }
    
    public float rectanguloP(float base, float altura){
        return (2*base+2*altura);
    }
    
    public float circuloA(float radio){
        return (float) (3.141594*Potencia(radio,2));
    }
    public float circuloP(float radio){
        return (float)(3.141594*2*radio);
    }
    
    public float poligonoA(float lado, int n, float apo){
        return (float)(((lado*n)*apo)/2);
    }
    
    public float poligonoP(float lado, int n){
        return (float)(lado*n);
    }
    
    //hacer lo de los prismas y piramides
    public float prismaA(float altura){
        float area= this.p*altura+(2*this.a);
        return area;
    }
    
    public float prismaV(float altura){
        return this.a*altura;
    }
    
    public float piramideV(float altura){
        return ((this.a*altura)/3);
    }
    
    
    public float esferaA(float radio){
        return (float) (4*3.141594*Potencia(radio,2));
    }
    public float esferaV(float radio){
        return (float) (4*3.141594*Potencia(radio,3)/3);
    }
    
    public float hipotenusaC(float base, float altura){
        float hip=0;
        hip=Raiz((Potencia(base,2)+Potencia(altura,2)));
        
        return hip;
    }
    public float hipotenusaB(float hipo, float base){
        float altura=0;
        altura=Raiz((Potencia(hipo/2,2)-Potencia(base,2)));
        
        return altura;
    }
    
    public float seno(float angulo){
        //ángulo a radianes
        float rad= (float) (angulo*1/180*3.141594);
        float sum= rad;
        
        for (int i=1; i<=10;i++){
            if(i%2==0){
                sum=sum+Potencia(rad,2*i+1)/Factorial(2*i+1);
            }else{
                sum=sum-Potencia(rad,2*i+1)/Factorial(2*i+1);
            }
    
        }
        return sum;
    }
    
    public float coseno(float angulo){
        int iteraciones=0;
        angulo= (float)((angulo*3.141594)/180);
        float angF=0;
        float margen=(float) 0.0001;
        float angA=0;
        
        do{
            angA=angF;
            angF=angF+Potencia(-1,iteraciones)*Potencia(angulo,2*iteraciones)/Factorial(2*iteraciones);
            iteraciones++;
        }while(ValorAbsoluto(margError(angF,angA))>margen);
        return angF;
    }
    
    public float tangente(float angulo){
        if(angulo/(3.141594/2)==(int)(angulo/(3.141594/2))){
            JOptionPane.showMessageDialog(null,"El ángulo no puede ser múltiplo de 90°");
        }
            float sen= seno(angulo);
            float cos= coseno(angulo);
        return (seno(angulo) / coseno(angulo));
    }
    
    
    public float anguloP(int lados){
        return (((lados-2)*180)/lados);
        
    }
    
    public float apotemaC(float lado,float angulo){
        float angR=angulo/2;
        float ladoR=lado/2;
       
        float apotema=tangente(angR)*ladoR;
        return (tangente(angulo/2))*(lado/2);
    }
    
    
}
