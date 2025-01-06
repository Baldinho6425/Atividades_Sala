#include <stdio.h>

float calcularImposto(float renda) {
    float imposto = 0;

    // Faixas de imposto fictícias
    if (renda <= 1903.98) {
        imposto = 0;  // Isento
    } else if (renda <= 2826.65) {
        imposto = (renda - 1903.98) * 0.075;  // 7.5% na faixa
    } else if (renda <= 3751.05) {
        imposto = (2826.65 - 1903.98) * 0.075 + (renda - 2826.65) * 0.15;  // 15% na faixa
    } else if (renda <= 4664.68) {
        imposto = (2826.65 - 1903.98) * 0.075 + 
                  (3751.05 - 2826.65) * 0.15 + 
                  (renda - 3751.05) * 0.225;  // 22.5% na faixa
    } else {
        imposto = (2826.65 - 1903.98) * 0.075 + 
                  (3751.05 - 2826.65) * 0.15 + 
                  (4664.68 - 3751.05) * 0.225 + 
                  (renda - 4664.68) * 0.275;  // 27.5% na faixa
    }

    return imposto;
}

int main() {
    float renda, imposto;

    // Solicitar a renda do usuário
    printf("Digite sua renda mensal: R$");
    scanf("%f", &renda);

    // Calcular o imposto
    imposto = calcularImposto(renda);

    // Exibir o resultado
    printf("Renda informada: R$%.2f\n", renda);
    if (imposto == 0) {
        printf("Você está isento de imposto.\n");
    } else {
        printf("O imposto devido é: R$%.2f\n", imposto);
    }

    return 0;
}
