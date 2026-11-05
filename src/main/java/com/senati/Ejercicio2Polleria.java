package com.senati;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2Polleria {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        final double PRECIO_POLLO = 65.00;
        final double PRECIO_CUARTO = 20.00;
        final double PRECIO_GASEOSA = 10.00;
        final double DESCUENTO_APP = 0.05;

        System.out.print("Cantidad de pollos enteros: ");
        int pollos = sc.nextInt();
        System.out.print("Cantidad de cuartos de pollo: ");
        int cuartos = sc.nextInt();
        System.out.print("Cantidad de gaseosas: ");
        int gaseosas = sc.nextInt();
        System.out.print("Porcentaje de propina: ");
        double propinaPorcentaje = sc.nextDouble();
        System.out.print("Número de personas que pagarán: ");
        int personas = sc.nextInt();

        if (pollos < 0 || cuartos < 0 || gaseosas < 0 || propinaPorcentaje < 0) {
            System.out.println("Error: no se permiten valores negativos.");
            return;
        }
        if (personas < 1) {
            System.out.println("Error: debe pagar al menos 1 persona.");
            return;
        }

        double consumo = pollos * PRECIO_POLLO + cuartos * PRECIO_CUARTO + gaseosas * PRECIO_GASEOSA;
        double descuento = consumo * DESCUENTO_APP;
        double consumoConDescuento = consumo - descuento;
        double propina = consumoConDescuento * propinaPorcentaje / 100;
        double total = consumoConDescuento + propina;
        double porPersona = total / personas;

        System.out.println();
        System.out.printf("Consumo (antes del descuento): S/ %.2f%n", consumo);
        System.out.printf("Descuento por pago con app (5%%): S/ %.2f%n", descuento);
        System.out.printf("Propina: S/ %.2f%n", propina);
        System.out.printf("Total a pagar: S/ %.2f%n", total);
        System.out.printf("Cada persona paga: S/ %.2f%n", porPersona);
    }
}
