package org.example;

public class Esfera extends Circulo{

    //=====CONSTRUCTOR=====
    public Esfera(double diametro, int id){
        super(diametro,id,6);
        this.nombre="Esfera";
    }

    //=====GETTERS=====
    //ya existen en la clase Circulo

    //=====SETTERS=====
    //ya existen en la clase Circulo

    //=====EXTRAS=====
    public int numeroDeVueltas(){
        return (this.puntosMax/this.baseAumentos)*3-1;
    }

    @Override
    public StringBuilder generarPatron(){
        //String donde se escribirá el patron
        StringBuilder patron;

        //Int de la cantidad de vueltas
        int vueltas = this.numeroDeVueltas();
        int puntosActuales = this.puntosMax;

        //fase 1: aumentos
        patron = super.generarPatron();
        int i = super.vueltasDeAumento()+1;

        //fase 2: filas de puntos bajos
        if(!(vueltas/3==0)){
            patron.append(i).append("-").append(i+vueltas/3).append(". ").append(puntosActuales).append(" pb ").append("[").append(puntosActuales).append("]\n");
        }
        i = i + vueltas/3;

        //fase 3: disminuciones
        for(i=i+1;i<=vueltas; i++){
            //ultima vuelta de disminuciones
           if(i == vueltas){
                puntosActuales -= this.baseAumentos;
                patron.append(i).append(". ").append(this.baseAumentos).append(" dis [").append(puntosActuales).append("]\n");
            }
            //calcular los pb y dis
            else{
                int pbs = puntosActuales/this.baseAumentos - 2;
                puntosActuales -= this.baseAumentos;
                patron.append(i).append(". (").append(pbs).append(" pb, dis)x").append(this.baseAumentos).append(" [").append(puntosActuales).append("]\n");
            }
        }
        return patron;
    }
}
