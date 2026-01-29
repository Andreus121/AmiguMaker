package org.example;

public class Cilindro extends Circulo{
    //=====Atributos=====
    private double alturaCm;
    private int vueltasCuerpo;

    //=====CONSTRUCTOR=====
    public Cilindro(double diametro,double altura, int id){
        super(diametro,id,6);
        this.nombre="Cilindro";
        this.alturaCm = altura;
        this.vueltasCuerpo = this.calcularVueltasCuerpo();
    }

    //=====GETTERS=====
    //ya existen en la clase Circulo
    public double getAltura(){
        return this.alturaCm;
    }

    //=====SETTERS=====
    //ya existen en la clase Circulo
    public void setAltura(double altura){
        this.alturaCm = altura;
        this.vueltasCuerpo = this.calcularVueltasCuerpo();
    }

    //=====EXTRAS=====
    public int calcularVueltasCuerpo(){
        //considerando extremos planos (lata)
        if(this.baseAumentos == 8){
            double vueltasPorCm = 2.5;
            return (int) Math.round(this.alturaCm * vueltasPorCm);
        }
        //considerando extremos redondos (capsula)
        else{
            double alturaCuerpoCm = this.alturaCm-this.radio*2;
            return (int) Math.round(Math.max(0,alturaCuerpoCm)*2.5);
        }
    }

    public int numeroDeVueltas(){
        return this.vueltasCuerpo + (this.puntosMax/this.baseAumentos)*2 -1;
    }

    @Override
    public StringBuilder generarPatron(){
        return null;
    }
}
