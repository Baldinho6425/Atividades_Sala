
class ContaBancaria:
    def __init__(self, titular, saldo_inicial=0):
        self.titular = titular
        self.saldo = saldo_inicial

    def depositar(self, valor):
        if valor > 0:
            self.saldo += valor
            print(f"Depósito de R${valor:.2f} realizado com sucesso!")
        else:
            print("O valor do depósito deve ser positivo.")

    def sacar(self, valor):
        if valor > self.saldo:
            print("Saldo insuficiente para o saque.")
        elif valor <= 0:
            print("O valor do saque deve ser positivo.")
        else:
            self.saldo -= valor
            print(f"Saque de R${valor:.2f} realizado com sucesso!")

    def exibir_saldo(self):
        print(f"Saldo atual de {self.titular}: R${self.saldo:.2f}")


print("Bem-vindo ao sistema bancário!")
titular = input("Digite o nome do titular da conta: ")
conta = ContaBancaria(titular)

while True:
    print("\nEscolha uma operação:")
    print("1. Exibir saldo")
    print("2. Depositar")
    print("3. Sacar")
    print("4. Sair")
    opcao = input("Digite o número da opção: ")

    if opcao == "1":
        conta.exibir_saldo()
    elif opcao == "2":
        valor = float(input("Digite o valor a ser depositado: "))
        conta.depositar(valor)
    elif opcao == "3":
        valor = float(input("Digite o valor a ser sacado: "))
        conta.sacar(valor)
    elif opcao == "4":
        print("Obrigado por usar o sistema bancário! Até mais!")
        break
    else:
        print("Opção inválida. Tente novamente.")
