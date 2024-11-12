package conta;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner scanner = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar Contas\n");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		while (true) {

			System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "\n\n*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                  Generation Bank                    ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			System.out.printf(Cores.TEXT_YELLOW_BRIGHT);

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT+"\nDigite Valores Inteiros!"+Cores.TEXT_RESET);
				scanner.nextInt();
				opcao = 0;

			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT+ "\nGeneration Bank - O seu Futuro começa aqui!"+Cores.TEXT_RESET);
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "Criar Conta\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número da Agência: ");
				agencia = scanner.nextInt();

				System.out.println("Digite o nome do titular: ");
				scanner.skip("\\R?");
				titular = scanner.nextLine();

				do {
					System.out.println("Digite o tipo da Conta (1-CC ou 2-CP):");
					tipo = scanner.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da conta (R$):");
				saldo = scanner.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite de crédito (R$):");
					limite = scanner.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}

				case 2 -> {
					System.out.println("Digite o dia do aniversário da Conta Poupança:");
					aniversario = scanner.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nListar todas as Contas");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(
						Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nConsultar dados da Conta - por número\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número da conta: ");
				numero = scanner.nextInt();
				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nAtualizar dados da Conta\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número da conta: ");
				numero = scanner.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);
				if (buscaConta != null) {
					tipo = buscaConta.getTipo();

					System.out.println("Digite o Numero da Agência: ");
					agencia = scanner.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					scanner.skip("\\R?");
					titular = scanner.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = scanner.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = scanner.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = scanner.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}
				} else {
					System.out.println("A Conta não foi encontrada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nApagar Conta\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número da conta: ");
				numero = scanner.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
			case 6:

				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nSaque\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número da conta: ");
				numero = scanner.nextInt();

				do {
					System.out.println("Digite o valor de saque: ");
					valor = scanner.nextFloat();

				} while (valor <= 0);
				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nDepósito\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número da conta: ");
				numero = scanner.nextInt();

				do {
					System.out.println("Digite o valor de depósito: ");
					valor = scanner.nextFloat();

				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nTransferência entre Contas\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o Numero da Conta de Origem: ");
				numero = scanner.nextInt();

				System.out.println("Digite o Numero da Conta de Destino: ");
				numeroDestino = scanner.nextInt();

				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = scanner.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nOpção Inválida!" + Cores.TEXT_RESET);
				keyPress();
			}
		}
	}

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_YELLOW_BRIGHT+"\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Rubio Dainton");
		System.out.println("Rubio Dainton - rubiodaiton@gmail.com");
		System.out.println("https://github.com/Rubio01/contabancaria");
		System.out.println("*********************************************************"+Cores.TEXT_RESET);
	}

}
