#include <stdio.h>

struct ContaBancaria {
    char titular[50];
    float saldo;
};

void depositar(struct ContaBancaria *conta, float valor) {
    conta->saldo += valor;
    printf("Depósito de R$%.2f realizado com sucesso.\n", valor);
}

void retirar(struct ContaBancaria *conta, float valor) {
    if (valor > conta->saldo) {
        printf("Erro: Saldo insuficiente para realizar a retirada de R$%.2f.\n", valor);
    } else {
        conta->saldo -= valor;
        printf("Retirada de R$%.2f realizada com sucesso.\n", valor);
    }
}

void consultarSaldo(struct ContaBancaria conta) {
    printf("Saldo atual: R$%.2f\n", conta.saldo);
}

int main() {
    struct ContaBancaria conta;
    int opcao;
    float valor;

    // Solicitar o nome do titular e o saldo inicial
    printf("Digite o nome do titular da conta: ");
    fgets(conta.titular, 50, stdin);
    conta.saldo = 0;

    do {
        // Exibir menu de opções
        printf("\n--- MENU ---\n");
        printf("1. Depositar\n");
        printf("2. Retirar\n");
        printf("3. Consultar Saldo\n");
        printf("4. Sair\n");
        printf("Escolha uma opção: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1:
                printf("Digite o valor a ser depositado: ");
                scanf("%f", &valor);
                depositar(&conta, valor);
                break;
            case 2:
                printf("Digite o valor a ser retirado: ");
                scanf("%f", &valor);
                retirar(&conta, valor);
                break;
            case 3:
                consultarSaldo(conta);
                break;
            case 4:
                printf("Saindo do sistema...\n");
                break;
            default:
                printf("Opção inválida. Tente novamente.\n");
        }
    } while (opcao != 4);

    return 0;
}
