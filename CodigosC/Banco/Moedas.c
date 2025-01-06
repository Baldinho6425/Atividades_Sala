#include <stdio.h>

void converterMoeda(float valor, int opcaoOrigem, int opcaoDestino) {
    float valorConvertido;

    // Real para outras moedas
    if (opcaoOrigem == 1) {
        if (opcaoDestino == 2) {
            valorConvertido = valor * 0.19;  // Exemplo de taxa de conversão BRL para USD
            printf("R$%.2f em Dólares: $%.2f\n", valor, valorConvertido);
        } else if (opcaoDestino == 3) {
            valorConvertido = valor * 0.18;  // Exemplo de taxa de conversão BRL para EUR
            printf("R$%.2f em Euros: €%.2f\n", valor, valorConvertido);
        } else {
            printf("Moeda de destino inválida.\n");
        }
    }
    // Dólar para outras moedas
    else if (opcaoOrigem == 2) {
        if (opcaoDestino == 1) {
            valorConvertido = valor * 5.29;  // Exemplo de taxa de conversão USD para BRL
            printf("$%.2f em Reais: R$%.2f\n", valor, valorConvertido);
        } else if (opcaoDestino == 3) {
            valorConvertido = valor * 0.95;  // Exemplo de taxa de conversão USD para EUR
            printf("$%.2f em Euros: €%.2f\n", valor, valorConvertido);
        } else {
            printf("Moeda de destino inválida.\n");
        }
    }
    // Euro para outras moedas
    else if (opcaoOrigem == 3) {
        if (opcaoDestino == 1) {
            valorConvertido = valor * 5.56;  // Exemplo de taxa de conversão EUR para BRL
            printf("€%.2f em Reais: R$%.2f\n", valor, valorConvertido);
        } else if (opcaoDestino == 2) {
            valorConvertido = valor * 1.05;  // Exemplo de taxa de conversão EUR para USD
            printf("€%.2f em Dólares: $%.2f\n", valor, valorConvertido);
        } else {
            printf("Moeda de destino inválida.\n");
        }
    }
    else {
        printf("Moeda de origem inválida.\n");
    }
}

int main() {
    int opcaoOrigem, opcaoDestino;
    float valor;

    // Exibir opções de moeda
    printf("Escolha a moeda de origem:\n");
    printf("1. Real (BRL)\n");
    printf("2. Dólar (USD)\n");
    printf("3. Euro (EUR)\n");
    printf("Digite a opção: ");
    scanf("%d", &opcaoOrigem);

    // Solicitar o valor a ser convertido
    printf("Digite o valor a ser convertido: ");
    scanf("%f", &valor);

    // Exibir opções de moeda destino
    printf("Escolha a moeda de destino:\n");
    printf("1. Real (BRL)\n");
    printf("2. Dólar (USD)\n");
    printf("3. Euro (EUR)\n");
    printf("Digite a opção: ");
    scanf("%d", &opcaoDestino);

    // Realizar a conversão
    converterMoeda(valor, opcaoOrigem, opcaoDestino);

    return 0;
}
