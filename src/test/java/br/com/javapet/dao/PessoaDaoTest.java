package br.com.javapet.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.javapet.domain.Pessoa;

public class PessoaDaoTest 
{
	@Test
	@Ignore
	public void salvar()
	{	
		Pessoa pessoa = new Pessoa(); 
		
		pessoa.setNome("Maria madalena das dores prado");
		pessoa.setCpf("111.111.111.11");
		pessoa.setRg("22.222.222-2");
		pessoa.setRua("Eduardo Martins Romeira"); 
		pessoa.setNumero(new Short("302"));
		pessoa.setBairro("Jardim Planalto"); 
		pessoa.setCep("19930-000");
		pessoa.setComplemento("Casa"); 
		pessoa.setTelefone("3379-0000"); 
		pessoa.setCelular("14-998045007");
		pessoa.setEmail("27.joaogabriel@gmail.com");
		
		
		PessoaDao pessoaDao = new PessoaDao(); 
		pessoaDao.salvar(pessoa);
		
	}
	
	@Test
	@Ignore
	public void listar()
	{
		PessoaDao pessoaDao = new PessoaDao(); 
		List<Pessoa> resultado = pessoaDao.listar();
		
		System.out.println("Total de registros encontrados: " + resultado.size());
		
		for (Pessoa pessoa : resultado)
		{
			System.out.println("Id: " + pessoa.getId() + " - " + "Nome: " + pessoa.getNome() + " - " + "Email: " + pessoa.getEmail() + " - " + "CPF: " + pessoa.getCpf() + " - " + 
"RG: " + pessoa.getRg() + " - " + "Rua: " + pessoa.getRua() + " - " + "Número: " + pessoa.getNumero() + " - " + "Complemento: " + pessoa.getComplemento() + " - " + "Bairro:" + pessoa.getBairro() + " - " +
"CEP: " + pessoa.getCep() + " - " + "Cidade: " + pessoa.getCidade() + " - " + "Telefone: " + pessoa.getTelefone() + " - " + "Celular: " + pessoa.getCelular());
		}
	}
	
	@Test
	@Ignore
	public void buscar()
	{
		Long codigo = 2L; 
		PessoaDao pessoaDao = new PessoaDao(); 
		Pessoa pessoa = pessoaDao.buscar(codigo);
		
		if (pessoa == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else 
		{
			System.out.println("Id: " + pessoa.getId() + " - " + "Nome: " + pessoa.getNome() + " - " + "Email: " + pessoa.getEmail() + " - " + "CPF: " + pessoa.getCpf() + " - " + 
					"RG: " + pessoa.getRg() + " - " + "Rua: " + pessoa.getRua() + " - " + "Número: " + pessoa.getNumero() + " - " + "Complemento: " + pessoa.getComplemento() + " - " + "Bairro:" + pessoa.getBairro() + " - " +
					"CEP: " + pessoa.getCep() + " - " + "Cidade: " + pessoa.getCidade() + " - " + "Telefone: " + pessoa.getTelefone() + " - " + "Celular: " + pessoa.getCelular());
		}
		
	}
	
	@Test
	@Ignore
	public void excluir()
	{
		Long codigo = 2L; 
		PessoaDao pessoaDao = new PessoaDao(); 
		Pessoa pessoa = pessoaDao.buscar(codigo);
		
		if (pessoa == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			pessoaDao.excluir(pessoa); 
			System.out.println("Registro excluído: ");
			
			System.out.println("Id: " + pessoa.getId() + " - " + "Nome: " + pessoa.getNome() + " - " + "Email: " + pessoa.getEmail() + " - " + "CPF: " + pessoa.getCpf() + " - " + 
					"RG: " + pessoa.getRg() + " - " + "Rua: " + pessoa.getRua() + " - " + "Número: " + pessoa.getNumero() + " - " + "Complemento: " + pessoa.getComplemento() + " - " + "Bairro:" + pessoa.getBairro() + " - " +
					"CEP: " + pessoa.getCep() + " - " + "Cidade: " + pessoa.getCidade() + " - " + "Telefone: " + pessoa.getTelefone() + " - " + "Celular: " + pessoa.getCelular());
			
		}
		
	}
	
	@Test
	@Ignore
	public void editar()
	{
		Long codigo = 5L; 
		PessoaDao pessoaDao = new PessoaDao(); 
		Pessoa pessoa = pessoaDao.buscar(codigo);
		
		if (pessoa == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else 
		{
			System.out.println("Registro a ser editado: ");
			
			System.out.println("Id: " + pessoa.getId() + " - " + "Nome: " + pessoa.getNome() + " - " + "Email: " + pessoa.getEmail() + " - " + "CPF: " + pessoa.getCpf() + " - " + 
					"RG: " + pessoa.getRg() + " - " + "Rua: " + pessoa.getRua() + " - " + "Número: " + pessoa.getNumero() + " - " + "Complemento: " + pessoa.getComplemento() + " - " + "Bairro:" + pessoa.getBairro() + " - " +
					"CEP: " + pessoa.getCep() + " - " + "Cidade: " + pessoa.getCidade() + " - " + "Telefone: " + pessoa.getTelefone() + " - " + "Celular: " + pessoa.getCelular());
			
			pessoa.setNome("Ruy Barbosa");
			pessoa.setCpf("222.333.444.55");
			pessoa.setRg("77.777.777-7");
			pessoa.setRua("João Silvério de Souza"); 
			pessoa.setNumero(new Short("205"));
			pessoa.setBairro("Jardim Planalto"); 
			pessoa.setCep("19930-000");
			pessoa.setComplemento("Casa"); 
			pessoa.setTelefone("3379-1264"); 
			pessoa.setCelular("14-998000000");
			pessoa.setEmail("ruy@gmail.com");
		
			
			pessoaDao.editar(pessoa);
			
			System.out.println("Registro atualizado: "); 
			System.out.println("Id: " + pessoa.getId() + " - " + "Nome: " + pessoa.getNome() + " - " + "Email: " + pessoa.getEmail() + " - " + "CPF: " + pessoa.getCpf() + " - " + 
					"RG: " + pessoa.getRg() + " - " + "Rua: " + pessoa.getRua() + " - " + "Número: " + pessoa.getNumero() + " - " + "Complemento: " + pessoa.getComplemento() + " - " + "Bairro:" + pessoa.getBairro() + " - " +
					"CEP: " + pessoa.getCep() + " - " + "Cidade: " + pessoa.getCidade() + " - " + "Telefone: " + pessoa.getTelefone() + " - " + "Celular: " + pessoa.getCelular());
		}
		
	}
}
