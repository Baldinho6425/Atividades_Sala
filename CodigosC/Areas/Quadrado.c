#include <stdio.h>

int main() {
    float lado, area;

    // Solicitar ao usuário o valor do lado do quadrado
    printf("Digite o valor do lado do quadrado: ");
    scanf("%f", &lado);

    // Calcular a área
    area = lado * lado;

    // Exibir o resultado
    printf("A área do quadrado é: %.2f\n", area);

    return 0;
}