package com.senati;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio3Notas {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        final double PESO_PRACTICAS = 0.30;
        final double PESO_PARCIAL = 0.25;
        final double PESO_TRABAJO = 0.15;
        final double PESO_FINAL = 0.30;
        final double NOTA_APROBATORIA = 10.5;

        System.out.print("Nombre del alumno: ");
        String nombre = sc.nextLine();
        System.out.print("Nota de la práctica 1: ");
        int practica1 = sc.nextInt();
        System.out.print("Nota de la práctica 2: ");
        int practica2 = sc.nextInt();
        System.out.print("Nota de la práctica 3: ");
        int practica3 = sc.nextInt();
        System.out.print("Nota del examen parcial: ");
        int parcial = sc.nextInt();
        System.out.print("Nota del trabajo final: ");
        int trabajo = sc.nextInt();

        int[] notas = {practica1, practica2, practica3, parcial, trabajo};
        for (int nota : notas) {
            if (nota < 0 || nota > 20) {
                System.out.println("Error: todas las notas deben estar entre 0 y 20.");
                return;
            }
        }

        double promedioPracticas = (practica1 + practica2 + practica3) / 3.0;

        double puntajeAcumulado = promedioPracticas * PESO_PRACTICAS
                + parcial * PESO_PARCIAL
                + trabajo * PESO_TRABAJO;

        double notaMinimaFinal = (NOTA_APROBATORIA - puntajeAcumulado) / PESO_FINAL;
        if (notaMinimaFinal < 0) {
            notaMinimaFinal = 0;
        }

        boolean aprobacionAsegurada = puntajeAcumulado >= NOTA_APROBATORIA;

        System.out.println();
        System.out.println("Alumno: " + nombre);
        System.out.printf("Promedio de prácticas: %.2f%n", promedioPracticas);
        System.out.printf("Puntaje acumulado: %.2f%n", puntajeAcumulado);
        System.out.printf("Nota mínima en el examen final: %.2f%n", notaMinimaFinal);
        System.out.println("Aprobación asegurada: " + aprobacionAsegurada);
    }
}
