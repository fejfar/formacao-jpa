package br.com.dxt.execute;

import java.util.ArrayList;

import br.com.dxt.domain.Cliente;
import br.com.dxt.domain.Endereco;
import br.com.dxt.domain.Telefone;
import br.com.dxt.domain.UF;
import br.com.dxt.services.EntityManagerFactoryWrapper;
import br.com.dxt.services.PessoaFisicaService;

public class ExecPessoaOneToMany {
	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.cidade = "Campinas";
		endereco.estado = UF.SP;

		Telefone residencial = new Telefone("19", "11111111");
		Telefone celular = new Telefone("19", "911111111");

		ArrayList<Telefone> listTelefones = new ArrayList<Telefone>();
		listTelefones.add(celular);
		listTelefones.add(residencial);

		Cliente cliente = new Cliente();
		cliente.telefones = listTelefones;
		cliente.nome = "Walter";
		cliente.cpf = "cpf";
		cliente.rg = "rg";
		cliente.endereco = endereco;

		PessoaFisicaService pessoaService = new PessoaFisicaService();
		pessoaService.salvar(cliente);

		EntityManagerFactoryWrapper.close();
	}
}
