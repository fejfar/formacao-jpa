package br.com.dxt.execute;

import java.util.List;

import br.com.dxt.domain.Cliente;
import br.com.dxt.domain.Pessoa;
import br.com.dxt.domain.PessoaFisica;
import br.com.dxt.services.PessoaFisicaService;

public class ExecPessoa {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.nome = "Walter";
		cliente.cpf = "cpf";
		cliente.rg = "rg";

		PessoaFisicaService pessoaService = new PessoaFisicaService();
		pessoaService.salvar(cliente);

		Pessoa pessoaEncontrada = pessoaService.buscarPorId(cliente.id);

		System.out.println(pessoaEncontrada.nome);

		List<PessoaFisica> listPessoa = pessoaService.buscarPorNome("alt");

		System.out.println("Nome do primeiro na lista: " + listPessoa.get(0).nome);
	}

}
