package conta;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import java.util.Scanner;
import conta.model.Conta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// teste classe conta removido

// teste conta corrente

		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "José da Silva ", 0.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
// teste conta corrente

		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Bruce", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(12000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		int opcao;

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
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = scanner.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "\nGeneration Bank - O seu Futuro começa aqui!");
				sobre();
				scanner.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Rubio Dainton");
		System.out.println("Rubio Dainton - rubiodaiton@gmail.com");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");
	}

}
