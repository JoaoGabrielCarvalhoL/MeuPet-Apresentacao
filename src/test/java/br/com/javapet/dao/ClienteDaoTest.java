package br.com.javapet.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.javapet.domain.Cliente;
import br.com.javapet.domain.Pessoa;

public class ClienteDaoTest 
{
	@Test
	@Ignore
	public void salvar()
	{
		Long codigo = 1L;
		PessoaDao pessoaDao = new PessoaDao(); 
		Pessoa pessoa = pessoaDao.buscar(codigo); 
		
		if (pessoa == null)
		{
			System.out.println("Registro não encontrado");
		}
		else
		{
			Cliente cliente = new Cliente(); 
			cliente.setDataCadastro(new Date());
			cliente.setPessoa(pessoa);
		
			ClienteDao clienteDao = new ClienteDao(); 
			clienteDao.salvar(cliente);
			System.out.println("Cliente salvo com sucesso!");
		}
		 
	}
	
	@Test
	@Ignore
	public void listar()
	{
		ClienteDao clienteDao = new ClienteDao(); 
		List<Cliente> resultado = clienteDao.listar();
		
		for (Cliente cliente : resultado)
		{
			System.out.println("Código cliente: " + cliente.getId());
			System.out.println("Data Cadastro: " + cliente.getDataCadastro());
			System.out.println("Nome: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("RG: " + cliente.getPessoa().getRg());
			System.out.println("Rua: " + cliente.getPessoa().getRua());
			System.out.println("Número: " + cliente.getPessoa().getNumero());
			System.out.println("Bairro: " + cliente.getPessoa().getBairro());
			System.out.println("CEP: " + cliente.getPessoa().getCep());
			System.out.println("Complemento: " + cliente.getPessoa().getComplemento());
			System.out.println("Cidade: " + cliente.getPessoa().getCidade());
			System.out.println("Telefone: " + cliente.getPessoa().getTelefone());
			System.out.println("Celular: " + cliente.getPessoa().getCelular());
			System.out.println("Email: " + cliente.getPessoa().getEmail());
			System.out.println();
		}	
	}
	
	@Test
	@Ignore
	public void buscar()
	{
		Long codigo = 1L;
		ClienteDao clienteDao = new ClienteDao(); 
		Cliente cliente = clienteDao.buscar(codigo);
		
		if (cliente == null)
		{
			System.out.println("Registro não encontrado");
		}
		else
		{
			System.out.println("Código cliente: " + cliente.getId());
			System.out.println("Data Cadastro: " + cliente.getDataCadastro());
			System.out.println("Nome: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("RG: " + cliente.getPessoa().getRg());
			System.out.println("Rua: " + cliente.getPessoa().getRua());
			System.out.println("Número: " + cliente.getPessoa().getNumero());
			System.out.println("Bairro: " + cliente.getPessoa().getBairro());
			System.out.println("CEP: " + cliente.getPessoa().getCep());
			System.out.println("Complemento: " + cliente.getPessoa().getComplemento());
			System.out.println("Cidade: " + cliente.getPessoa().getCidade());
			System.out.println("Telefone: " + cliente.getPessoa().getTelefone());
			System.out.println("Celular: " + cliente.getPessoa().getCelular());
			System.out.println("Email: " + cliente.getPessoa().getEmail());
		}
	}
	
	@Test
	@Ignore
	public void excluir()
	{
		Long codigo = 1L;
		ClienteDao clienteDao = new ClienteDao(); 
		Cliente cliente = clienteDao.buscar(codigo); 
		
		if (cliente == null)
		{
			System.out.println("Registro não encontrado");
		}
		else
		{
			clienteDao.excluir(cliente);
			System.out.println("Cliente excluído: ");
			System.out.println("Código cliente: " + cliente.getId());
			System.out.println("Data Cadastro: " + cliente.getDataCadastro());
			System.out.println("Nome: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("RG: " + cliente.getPessoa().getRg());
			System.out.println("Rua: " + cliente.getPessoa().getRua());
			System.out.println("Número: " + cliente.getPessoa().getNumero());
			System.out.println("Bairro: " + cliente.getPessoa().getBairro());
			System.out.println("CEP: " + cliente.getPessoa().getCep());
			System.out.println("Complemento: " + cliente.getPessoa().getComplemento());
			System.out.println("Cidade: " + cliente.getPessoa().getCidade());
			System.out.println("Telefone: " + cliente.getPessoa().getTelefone());
			System.out.println("Celular: " + cliente.getPessoa().getCelular());
			System.out.println("Email: " + cliente.getPessoa().getEmail());
		}
		
	}
	
	
	@Test
	@Ignore
	public void editar()
	{
		Long codigo = 1L; 
		ClienteDao clienteDao = new ClienteDao(); 
		Cliente cliente = clienteDao.buscar(codigo);
		
		if (cliente == null)
		{
			System.out.println("Registro não encontrado");
		}
		else
		{
			System.out.println("Cliente a ser editado: ");
			System.out.println("Código cliente: " + cliente.getId());
			System.out.println("Data Cadastro: " + cliente.getDataCadastro());
			System.out.println("Nome: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("RG: " + cliente.getPessoa().getRg());
			System.out.println("Rua: " + cliente.getPessoa().getRua());
			System.out.println("Número: " + cliente.getPessoa().getNumero());
			System.out.println("Bairro: " + cliente.getPessoa().getBairro());
			System.out.println("CEP: " + cliente.getPessoa().getCep());
			System.out.println("Complemento: " + cliente.getPessoa().getComplemento());
			System.out.println("Cidade: " + cliente.getPessoa().getCidade());
			System.out.println("Telefone: " + cliente.getPessoa().getTelefone());
			System.out.println("Celular: " + cliente.getPessoa().getCelular());
			System.out.println("Email: " + cliente.getPessoa().getEmail());
			
			cliente.setDataCadastro(new Date());
			cliente.getPessoa().setNome("João Gabriel Carvalho");
			cliente.getPessoa().setCpf("000.000.000.00");
			cliente.getPessoa().setRg("00.000.000-0");
			cliente.getPessoa().setRua("João Silvério de Souza");
			cliente.getPessoa().setNumero(new Short("205"));
			cliente.getPessoa().setBairro("Jardim Planalto");
			cliente.getPessoa().setCep("19930-000");
			cliente.getPessoa().setComplemento("Casa");
			
			cliente.getPessoa().setTelefone("3379-1264");
			cliente.getPessoa().setCelular("14-9999999");
			cliente.getPessoa().setEmail("biel01_@hotmail.com");
			
			clienteDao.editar(cliente);
			System.out.println();
			
			System.out.println("Cliente a ser editado: ");
			System.out.println("Código cliente: " + cliente.getId());
			System.out.println("Data Cadastro: " + cliente.getDataCadastro());
			System.out.println("Nome: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("RG: " + cliente.getPessoa().getRg());
			System.out.println("Rua: " + cliente.getPessoa().getRua());
			System.out.println("Número: " + cliente.getPessoa().getNumero());
			System.out.println("Bairro: " + cliente.getPessoa().getBairro());
			System.out.println("CEP: " + cliente.getPessoa().getCep());
			System.out.println("Complemento: " + cliente.getPessoa().getComplemento());
			System.out.println("Cidade: " + cliente.getPessoa().getCidade());
			System.out.println("Telefone: " + cliente.getPessoa().getTelefone());
			System.out.println("Celular: " + cliente.getPessoa().getCelular());
			System.out.println("Email: " + cliente.getPessoa().getEmail());
		
		}
	}
}
