package org.example.exercicio1;

// Desafio 1
// Ordenando Números Pares e Ímpares

/* Crie um programa onde você receberá valores inteiros não negativos como
entrada.

Ordene estes valores de acordo com o seguinte critério:

- Primeiro os Pares
- Depois os Ímpares
- Você deve exibir os pares em ordem crescente e na sequência os ímpares em
ordem decrescente.

- Entrada

A primeira linha de entrada contém um único inteiro positivo N (1 < N < 10000)
Este é o número de linhas de entrada que vem logo a seguir. As próximas N
linhas terão, cada uma delas, um valor inteiro não negativo.

- Saída

Exiba todos os valores lidos na entrada segundo a ordem apresentada acima.
Cada número deve ser impresso em uma linha, conforme exemplo de saída abaixo.
*/

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Exercicio1 {
    public static void main(String[] args) throws IOException {

        List<Integer> listNumPar = new ArrayList<>();
        List<Integer> listNumImpar = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("Digite um número entre 1 e 10000:");
            int numEntrada = entrada.nextInt();

            if (numEntrada < 1 || numEntrada > 10000) {
                throw new IllegalArgumentException("Digite um número válido!");
            }

            for (int i = 1; i <= numEntrada; i++) {
                if (i % 2 == 0) {
                    listNumPar.add(i);
                } else {
                    listNumImpar.add(i);
                }
            }

            List<String> numParesOrdenados = listNumPar.stream()
                    .sorted()
                    .map(Object::toString)
                    .collect(Collectors.toList());

            List<String> numImparesOrdenados = listNumImpar.stream()
                    .sorted(Collections.reverseOrder())
                    .map(Object::toString)
                    .collect(Collectors.toList());

            System.out.println("Números pares em ordem crescente: ");
            System.out.println(String.join(" | ", numParesOrdenados));

            System.out.println("Números ímpares em ordem decrescente: ");
            System.out.println(String.join(" | ", numImparesOrdenados));

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            entrada.close();
        }
    }
}
