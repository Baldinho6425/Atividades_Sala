#include <stdio.h>
#include <string.h>

#define MAX_ANIMAIS 100
#define TAM_NOME 50

struct Animal {
    char nome[TAM_NOME];
    char especie[TAM_NOME];
    int idade;
};

void adicionarAnimal(struct Animal animais[], int *total) {
    if (*total >= MAX_ANIMAIS) {
        printf("Capacidade máxima de animais atingida!\n");
        return;
    }

    struct Animal novoAnimal;

    // Solicitar os dados do novo animal
    printf("Digite o nome do animal: ");
    scanf(" %[^\n]", novoAnimal.nome);
    printf("Digite a espécie do animal: ");
    scanf(" %[^\n]", novoAnimal.especie);
    printf("Digite a idade do animal: ");
    scanf("%d", &novoAnimal.idade);

    // Adicionar o animal ao array
    animais[*total] = novoAnimal;
    (*total)++;
    printf("Animal adicionado com sucesso!\n");
}

void listarAnimais(struct Animal animais[], int total) {
    if (total == 0) {
        printf("Nenhum animal cadastrado.\n");
        return;
    }

    printf("\nLista de Animais no Zoológico:\n");
    for (int i = 0; i < total; i++) {
        printf("%d. Nome: %s, Espécie: %s, Idade: %d anos\n",
               i + 1, animais[i].nome, animais[i].especie, animais[i].idade);
    }
}

void pesquisarAnimal(struct Animal animais[], int total) {
    if (total == 0) {
        printf("Nenhum animal cadastrado.\n");
        return;
    }

    char nomePesquisa[TAM_NOME];
    printf("Digite o nome do animal para pesquisa: ");
    scanf(" %[^\n]", nomePesquisa);

    for (int i = 0; i < total; i++) {
        if (strcmp(animais[i].nome, nomePesquisa) == 0) {
            printf("Animal encontrado: Nome: %s, Espécie: %s, Idade: %d anos\n",
                   animais[i].nome, animais[i].especie, animais[i].idade);
            return;
        }
    }

    printf("Animal com nome '%s' não encontrado.\n", nomePesquisa);
}

int main() {
    struct Animal animais[MAX_ANIMAIS];
    int totalAnimais = 0;
    int opcao;

    do {
        // Exibir menu de opções
        printf("\n--- Sistema de Gerenciamento do Zoológico ---\n");
        printf("1. Adicionar Animal\n");
        printf("2. Listar Animais\n");
        printf("3. Pesquisar Animal\n");
        printf("4. Sair\n");
        printf("Escolha uma opção: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1:
                adicionarAnimal(animais, &totalAnimais);
                break;
            case 2:
                listarAnimais(animais, totalAnimais);
                break;
            case 3:
                pesquisarAnimal(animais, totalAnimais);
                break;
            case 4:
                printf("Encerrando o sistema...\n");
                break;
            default:
                printf("Opção inválida. Tente novamente.\n");
        }
    } while (opcao != 4);

    return 0;
}
