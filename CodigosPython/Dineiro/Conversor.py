def converter_moeda(valor, taxa_cambio):
    """
    Converte o valor de uma moeda para outra com base na taxa de câmbio fornecida.
    """
    return valor * taxa_cambio

# Solicita os dados ao usuário
try:
    valor = float(input("Digite o valor em moeda original: "))
    taxa_cambio = float(input("Digite a taxa de câmbio (exemplo: 5.25 para USD -> BRL): "))

    # Realiza a conversão
    valor_convertido = converter_moeda(valor, taxa_cambio)

    # Exibe o resultado
    print(f"O valor convertido é: {valor_convertido:.2f}")
except ValueError:
    print("Por favor, insira valores numéricos válidos.")
