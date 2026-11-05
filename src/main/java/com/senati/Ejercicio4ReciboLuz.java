package com.senati;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio4ReciboLuz {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        final double PRECIO_KWH = 0.80;
        final double CARGO_FIJO = 5.00;
        final double IGV = 0.18;
        final int LIMITE_SUBSIDIO_KWH = 100;

        System.out.print("Código de suministro: ");
        String codigo = sc.next();
        System.out.print("Lectura anterior (kWh): ");
        int lecturaAnterior = sc.nextInt();
        System.out.print("Lectura actual (kWh): ");
        int lecturaActual = sc.nextInt();

        if (lecturaAnterior < 0 || lecturaActual < lecturaAnterior) {
            System.out.println("Error: la lectura actual no puede ser menor que la anterior.");
            return;
        }

        int consumo = lecturaActual - lecturaAnterior;
        double costoEnergia = consumo * PRECIO_KWH;
        double subtotal = costoEnergia + CARGO_FIJO;
        double igv = subtotal * IGV;
        double total = subtotal + igv;
        boolean calificaSubsidio = consumo <= LIMITE_SUBSIDIO_KWH;

        System.out.println();
        System.out.println("Código de suministro: " + codigo);
        System.out.println("Consumo del mes: " + consumo + " kWh");
        System.out.printf("Costo de la energía: S/ %.2f%n", costoEnergia);
        System.out.printf("Cargo fijo: S/ %.2f%n", CARGO_FIJO);
        System.out.printf("IGV (18%%): S/ %.2f%n", igv);
        System.out.printf("Total a pagar: S/ %.2f%n", total);
        System.out.println("Califica para subsidio: " + calificaSubsidio);
    }
}
