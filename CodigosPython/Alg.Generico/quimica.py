import random
import math
import matplotlib.pyplot as plt

# Número de parâmetros experimentais (ex: temperatura, pH, tempo)
num_parameters = 3

# Limites inferior e superior para cada parâmetro (normalizado de 0 a 1)
lower_bound = 0.0
upper_bound = 1.0

# Parâmetros do AG
population_size = 50
generations = 100
initial_mutation_rate = 0.05
final_mutation_rate = 0.2
crossover_rate = 0.8

# Simulação da função rendimento da reação com base em 3 parâmetros
def objective_function(individual):
    # Exemplo artificial: picos em certas combinações
    t, ph, tempo = individual
    rendimento = (
        math.exp(-((t - 0.7)**2) / 0.01) +
        math.exp(-((ph - 0.4)**2) / 0.02) +
        math.sin(5 * math.pi * tempo)**2
    )
    return rendimento  # quanto maior, melhor

# Inicialização da população
def initialize_population():
    return [
        [random.uniform(lower_bound, upper_bound) for _ in range(num_parameters)]
        for _ in range(population_size)
    ]

# Avaliação da população
def evaluate_population(population):
    return [objective_function(individual) for individual in population]

# Seleção por torneio
def tournament_selection(population, fitness, tournament_size=3):
    selected = []
    for _ in range(population_size):
        contenders = random.sample(range(population_size), tournament_size)
        best = max(contenders, key=lambda i: fitness[i])
        selected.append(population[best])
    return selected

# Crossover aritmético vetor
def crossover(parent1, parent2):
    if random.random() < crossover_rate:
        alpha = random.random()
        child1 = [
            alpha * p1 + (1 - alpha) * p2 for p1, p2 in zip(parent1, parent2)
        ]
        child2 = [
            alpha * p2 + (1 - alpha) * p1 for p1, p2 in zip(parent1, parent2)
        ]
        return child1, child2
    return parent1[:], parent2[:]

# Mutação com taxa adaptativa
def mutate(individual, generation, total_generations):
    mutation_rate = initial_mutation_rate + (
        (final_mutation_rate - initial_mutation_rate) * generation / total_generations
    )
    mutated = []
    for gene in individual:
        if random.random() < mutation_rate:
            gene += random.uniform(-0.1, 0.1)
            gene = min(max(gene, lower_bound), upper_bound)
        mutated.append(gene)
    return mutated

# Algoritmo Genético principal
def genetic_algorithm():
    population = initialize_population()
    best_fitness_per_generation = []
    best_solution = None
    best_fitness = -float('inf')

    for gen in range(generations):
        fitness = evaluate_population(population)
        gen_best = max(fitness)
        best_fitness_per_generation.append(gen_best)

        if gen_best > best_fitness:
            best_fitness = gen_best
            best_solution = population[fitness.index(gen_best)]

        selected = tournament_selection(population, fitness)
        next_population = []

        for i in range(0, population_size, 2):
            p1, p2 = selected[i], selected[i + 1]
            c1, c2 = crossover(p1, p2)
            next_population.append(mutate(c1, gen, generations))
            next_population.append(mutate(c2, gen, generations))

        population = next_population

    return best_fitness_per_generation, best_solution

# Executar o AG
fitness_history, best_individual = genetic_algorithm()

# Plotar evolução da aptidão
plt.plot(fitness_history)
plt.xlabel('Geração')
plt.ylabel('Melhor rendimento da reação')
plt.title('Evolução do rendimento com Algoritmo Genético')
plt.grid(True)
plt.show()

# Imprimir melhor conjunto de parâmetros
print("Melhor conjunto de parâmetros (normalizado):", best_individual)
