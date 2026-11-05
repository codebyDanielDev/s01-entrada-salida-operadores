package com.senati;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio1Cajero {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        final double COMISION = 1.50;

        System.out.print("Saldo de la cuenta: ");
        double saldo = sc.nextDouble();
        System.out.print("Monto a retirar (múltiplo de 10): ");
        int monto = sc.nextInt();

        if (monto <= 0 || monto % 10 != 0) {
            System.out.println("Error: el cajero solo acepta montos múltiplos de 10.");
            return;
        }
        if (saldo < monto + COMISION) {
            System.out.println("Error: saldo insuficiente (se necesita el monto + la comisión).");
            return;
        }

        int billetes200 = monto / 200;
        int resto = monto % 200;

        int billetes100 = resto / 100;
        resto = resto % 100;

        int billetes50 = resto / 50;
        resto = resto % 50;

        int billetes20 = resto / 20;
        resto = resto % 20;

        int billetes10 = resto / 10;

        int totalBilletes = billetes200 + billetes100 + billetes50 + billetes20 + billetes10;
        double saldoFinal = saldo - monto - COMISION;

        System.out.println();
        System.out.println("Billetes de S/ 200: " + billetes200);
        System.out.println("Billetes de S/ 100: " + billetes100);
        System.out.println("Billetes de S/ 50: " + billetes50);
        System.out.println("Billetes de S/ 20: " + billetes20);
        System.out.println("Billetes de S/ 10: " + billetes10);
        System.out.println("Total de billetes: " + totalBilletes);
        System.out.printf("Saldo final: S/ %.2f%n", saldoFinal);
    }
}
