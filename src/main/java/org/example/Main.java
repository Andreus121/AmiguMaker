package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // El "String[] args" es obligatorio para que Java sepa que aquí inicia todo
    public static void main(String[] args) {
        Circulo redondo = new Circulo(3,1);
        System.out.println("Circulo de diámetro 53cm");
        System.out.println("Perimetro del circulo: " + redondo.getPerimetro()+"cm");
        System.out.println("Puntos de la vuelta más grande: " + redondo.getPuntosMax());
        System.out.println("Numero de vueltas del circulo: " + redondo.vueltasDeAumento()+"\n");
        System.out.println(redondo.generarPatron());

        Esfera prueba = new Esfera(5.3,1);
        System.out.println("Esfera de diámetro 4 cm");
        System.out.println("Perimetro de la esfera: " + prueba.getPerimetro()+"cm");
        System.out.println("Puntos de la vuelta más grande: " + prueba.getPuntosMax());
        System.out.println("Numero de vueltas de la esfera: " + prueba.numeroDeVueltas()+"\n");
        System.out.println(prueba.generarPatron());
    }
}
