def calcular_imposto(salario):
    """
    Calcula o imposto de renda com base em faixas progressivas.
    """
    if salario <= 1903.98:
        imposto = 0  # Isento
    elif salario <= 2826.65:
        imposto = (salario - 1903.98) * 0.075
    elif salario <= 3751.05:
        imposto = (salario - 2826.65) * 0.15 + (2826.65 - 1903.98) * 0.075
    elif salario <= 4664.68:
        imposto = (salario - 3751.05) * 0.225 + (3751.05 - 2826.65) * 0.15 + (2826.65 - 1903.98) * 0.075
    else:
        imposto = (salario - 4664.68) * 0.275 + (4664.68 - 3751.05) * 0.225 + (3751.05 - 2826.65) * 0.15 + (2826.65 - 1903.98) * 0.075

    return imposto


# Solicita o salário do usuário
try:
    salario = float(input("Digite o valor do salário bruto: R$ "))
    imposto = calcular_imposto(salario)
    print(f"O imposto calculado para o salário de R${salario:.2f} é: R${imposto:.2f}")
except ValueError:
    print("Por favor, insira um valor numérico válido.")
