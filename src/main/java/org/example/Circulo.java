package org.example;

public class Circulo implements FiguraTejible{

    //=====ATRIBUTOS=====
    protected final int id;
    protected String nombre = "Círculo";
    protected int baseAumentos;
    protected double radio;
    protected double perimetro;
    protected int puntosMax;


    //=====CONSTRUCTOR=====
    //incluye parámetro de baseAumentos
    public Circulo(double diametro, int id,int baseAumentos){
        this.id = id;
        this.baseAumentos = baseAumentos;
        this.radio = diametro/2;
        this.perimetro = 2*Math.PI*this.radio;
        this.puntosMax = this.calcularPuntosMax();
    }

    //define baseAumentos en 8 por defecto en caso de no ser añadidos
    public Circulo(double diametro, int id) {
        this(diametro, id, 8); // Llama al de arriba pasándole un 8 por defecto
    }

    //=====GETTERS=====
    @Override
    public String getNombre(){
        return this.nombre;
    }

    public int getId(){
        return this.id;
    }

    public double getRadio(){
        return this.radio;
    }

    public double getPerimetro(){
        return this.perimetro;
    }

    public int getPuntosMax(){
        return this.puntosMax;
    }

    //=====SETTERS=====
    public void setRadio(double radio){
        this.radio = radio;
        this.perimetro = 2*Math.PI*radio;
        this.puntosMax = this.calcularPuntosMax();
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setBaseAumentos(int baseAumentos){
        this.baseAumentos = baseAumentos;
        this.puntosMax = this.calcularPuntosMax();
    }

    //=====EXTRAS=====
    //esto suponiendo tensión media y ganchillo 3
    private int calcularPuntosMax(){
        //medida media de puntos por centímetro
        double puntosPorCentimetro = 2.5;
        //redondear decimales y calcular puntos
        int puntos = Math.toIntExact(Math.round(puntosPorCentimetro * this.perimetro));

        //si no es multiplo de baseAumentos hay que calcular los puntos
        if(puntos % this.baseAumentos != 0){
            //analizar la menor distancia a los puntos deseados
            int multiploMenor = (puntos/this.baseAumentos)*this.baseAumentos;
            int multiploMayor = multiploMenor+this.baseAumentos;
            //toca ver si hay menos diferencia de puntos con el multiplo de baseAumentos mayor o menor a los puntos que queremos
            if(Math.abs(puntos-multiploMenor)<=Math.abs(puntos-multiploMayor)){
                puntos = multiploMenor;
            } else{
                puntos = multiploMayor;
            }
        }
        return puntos;
    }

    public int vueltasDeAumento() {
        return this.puntosMax / this.baseAumentos;
    }

    @Override
    public StringBuilder generarPatron(){
        //String donde se escribirá el patron
        StringBuilder patron = new StringBuilder();

        //Int de la cantidad de vueltas
        int vueltas = this.vueltasDeAumento();
        int aumentos = this.baseAumentos;

        //inicio del patron
        patron.append("Patron de la pieza \"").append(this.nombre).append("\"").append("\n");

        //i es la vuelta actual
        int puntosActuales = 0;

        //fase 1: aumentos
        for(int i = 1;i<=vueltas; i++){
            //anillo mágico
            if(i==1){
                puntosActuales += aumentos;
                patron.append("1. Anillo mágico ").append(aumentos).append(" pb [").append(puntosActuales).append("]\n");
            }
            //segunda vuelta solo aumentos
            else if(i==2){
                puntosActuales += aumentos;
                patron.append(i).append(". ").append(aumentos).append(" aum [").append(puntosActuales).append("]\n");
            }
            //calcular puntos bajos y aumentos para agrandar el círculo
            else{
                int pbs = puntosActuales/aumentos - 1;
                puntosActuales += aumentos;
                patron.append(i).append(". (").append(pbs).append(" pb, aum)x").append(aumentos).append(" [").append(puntosActuales).append("]\n");
            }
        }
        return patron;
    }
}
