package conta.controller;

import java.util.ArrayList;
import conta.util.Cores;
import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.println(
					Cores.TEXT_RED_BOLD_BRIGHT + "\nA conta " + numero + " não foi encontrada!" + Cores.TEXT_RESET);
		}

	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();

		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\n A conta número: " + conta.getNumero() + Cores.TEXT_GREEN_BOLD_BRIGHT
				+ " foi criada com sucesso!" + Cores.TEXT_RESET);

	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA conta número: " + conta.getNumero() + Cores.TEXT_GREEN_BOLD_BRIGHT
					+ " foi atualizada com sucesso!" + Cores.TEXT_RESET);

		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA Conta número: " + conta.getNumero()
					+ " não foi encontrada!" + Cores.TEXT_RESET);
		}

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("\nA Conta número: " + numero + Cores.TEXT_GREEN_BOLD_BRIGHT
						+ " foi deletada com sucesso!" + Cores.TEXT_RESET);
		} else
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA Conta número " + numero + " não foi encontrada!"
					+ Cores.TEXT_RESET);
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (conta.sacar(valor) == true)
				System.out.println("\nO Saque na Conta número: " + numero + Cores.TEXT_GREEN_BOLD_BRIGHT
						+ " foi efetuado com sucesso!" + Cores.TEXT_RESET);
		} else
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA Conta número: " + numero + " não foi encontrada!"
					+ Cores.TEXT_RESET);

	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\nDepósito na Conta número: " + numero + Cores.TEXT_GREEN_BOLD_BRIGHT
					+ " foi efetuado com sucesso!" + Cores.TEXT_RESET);
		} else
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA Conta número: " + numero + " não foi encontrada!"
					+ Cores.TEXT_RESET);

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nA Transferência " + Cores.TEXT_GREEN_BOLD_BRIGHT + "foi efetuada com sucesso!"
						+ Cores.TEXT_RESET);
			}
		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA Conta de Origem e/ou Destino não foram encontradas!"
					+ Cores.TEXT_RESET);
		}

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {

		for (var conta : listaContas) {
			if (numero == conta.getNumero()) {
				return conta;
			}
		}
		return null;

	}
}
