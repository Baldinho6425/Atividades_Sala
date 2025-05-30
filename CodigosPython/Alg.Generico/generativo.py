import random

# Parâmetros
TAM_POPULACAO = 10  # Tamanho da população
TAM_GENOMA = 10     # Tamanho do genoma binário (representação de x)
GERACOES = 50       # Número máximo de gerações
MUTACAO_TAXA = 0.1  # Probabilidade de mutação
SELECAO_TIPO = "roleta"  # Tipo de seleção: "roleta" ou "torneio"

# Função de aptidão: f(x) = x^2
def aptidao(individuo):
    x = int(''.join(map(str, individuo)), 2)  # Converte o binário para decimal
    return x ** 2

# Geração da população inicial
def gerar_populacao_inicial():
    return [[random.randint(0, 1) for _ in range(TAM_GENOMA)] for _ in range(TAM_POPULACAO)]

# Seleção por torneio
def torneio(populacao):
    pais = random.sample(populacao, 2)  # Escolhe dois indivíduos aleatoriamente
    pais.sort(key=lambda x: aptidao(x), reverse=True)  # Ordena pela aptidão
    return pais[0]  # Retorna o melhor

# Seleção por roleta
def roleta(populacao):
    soma_aptidao = sum(aptidao(individuo) for individuo in populacao)
    selecionado = random.choices(populacao, weights=[aptidao(individuo) for individuo in populacao], k=1)
    return selecionado[0]

# Crossover: troca de segmentos entre dois pais
def crossover(pai1, pai2):
    ponto_corte = random.randint(1, TAM_GENOMA - 1)
    filho1 = pai1[:ponto_corte] + pai2[ponto_corte:]
    filho2 = pai2[:ponto_corte] + pai1[ponto_corte:]
    return filho1, filho2

# Mutação: inverte um bit aleatório do genoma
def mutacao(individuo):
    if random.random() < MUTACAO_TAXA:
        ponto_mutacao = random.randint(0, TAM_GENOMA - 1)
        individuo[ponto_mutacao] = 1 - individuo[ponto_mutacao]  # Inverte o bit
    return individuo

# Algoritmo Genético
def algoritmo_genetico():
    populacao = gerar_populacao_inicial()
    melhor_individuo = None
    melhor_aptidao = 0

    for geracao in range(GERACOES):
        nova_populacao = []

        # Seleção, crossover e mutação
        while len(nova_populacao) < TAM_POPULACAO:
            if SELECAO_TIPO == "torneio":
                pai1 = torneio(populacao)
                pai2 = torneio(populacao)
            elif SELECAO_TIPO == "roleta":
                pai1 = roleta(populacao)
                pai2 = roleta(populacao)

            filho1, filho2 = crossover(pai1, pai2)
            nova_populacao.append(mutacao(filho1))
            nova_populacao.append(mutacao(filho2))

        populacao = nova_populacao

        # Avaliação da população
        melhor_da_geracao = max(populacao, key=lambda x: aptidao(x))
        aptidao_melhor = aptidao(melhor_da_geracao)

        if aptidao_melhor > melhor_aptidao:
            melhor_aptidao = aptidao_melhor
            melhor_individuo = melhor_da_geracao

        print(f"Geração {geracao}: Melhor aptidão = {melhor_aptidao}")

        if melhor_aptidao == (2 ** TAM_GENOMA - 1) ** 2:  # O melhor valor possível para f(x)
            break

    x_melhor = int(''.join(map(str, melhor_individuo)), 2)
    print(f"\nMelhor indivíduo: {melhor_individuo}")
    print(f"Valor de x: {x_melhor}")
    print(f"Aptidão final: {melhor_aptidao}")

# Executa o algoritmo
algoritmo_genetico()
