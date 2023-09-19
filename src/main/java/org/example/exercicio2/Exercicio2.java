package org.example.exercicio2;
/* ======================================================================================================================== */
// Desafio 2
// Conversão de Tempo

/*
Você terá o desafio de ler um valor inteiro, faça a conversão desse valor para date e informe-o expresso no formato
dia/mês/ano horas:minutos:segundos.

- Entrada

O arquivo de entrada contém um valor inteiro N.

- Saída

Imprima o tempo lido no arquivo de entrada (segundos), convertido para
horas:minutos:segundos, conforme exemplo fornecido.

- Obs

Utilize UTC (GMT-0)

- Exemplo:
    Entrada: 1693225566
    Saída: 28/Aug/2023 12:26:06
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TimeZone;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long seconds;

        while (true) {
            try {
                System.out.println("Digite um valor inteiro (somente números):");
                seconds = readLongInput(input);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Certifique-se de digitar somente números inteiros.");
                input.nextLine();
            }
        }

        long millis = seconds * 1000;
        Date date = new Date(millis);

        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println("Saída no formato dia/mês/ano horas:minutos:segundos (UTC):");
        System.out.println(df.format(date));
    }

    private static long readLongInput(Scanner input) throws NumberFormatException {
        return Long.parseLong(input.next());
    }
}
