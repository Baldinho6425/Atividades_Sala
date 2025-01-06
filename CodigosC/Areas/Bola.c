#include <stdio.h>
#include <math.h>

int main() {
    float raio, area;

    // Solicitar ao usuário o valor do raio do círculo
    printf("Digite o valor do raio do círculo: ");
    scanf("%f", &raio);

    // Calcular a área
    area = M_PI * raio * raio;

    // Exibir o resultado
    printf("A área do círculo é: %.2f\n", area);

    return 0;
}
