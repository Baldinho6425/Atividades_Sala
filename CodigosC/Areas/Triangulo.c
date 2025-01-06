#include <stdio.h>

int main() {
    float base, altura, area;

    // Solicitar ao usuário o valor da base e altura do triângulo
    printf("Digite a base do triângulo: ");
    scanf("%f", &base);
    printf("Digite a altura do triângulo: ");
    scanf("%f", &altura);

    // Calcular a área
    area = (base * altura) / 2;

    // Exibir o resultado
    printf("A área do triângulo é: %.2f\n", area);

    return 0;
}
