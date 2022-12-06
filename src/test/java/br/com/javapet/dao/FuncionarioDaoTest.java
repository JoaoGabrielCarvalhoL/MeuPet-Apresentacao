package br.com.javapet.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.javapet.domain.Funcionario;
import br.com.javapet.domain.Pessoa;

public class FuncionarioDaoTest 
{
	@Test
	@Ignore
	public void salvar()
	{
		Long codigo = 7L;
		PessoaDao pessoaDao = new PessoaDao(); 
		Pessoa pessoa = pessoaDao.buscar(codigo); 
		
		if (pessoa == null)
		{
			System.out.println("Registro não encontrado");
		}
		else
		{
			Funcionario funcionario = new Funcionario(); 
			funcionario.setCarteiraTrabalho("123456789");
			funcionario.setDataAdmissao(new Date());
			funcionario.setPessoa(pessoa);
			
			FuncionarioDao funcionarioDao = new FuncionarioDao(); 
			funcionarioDao.salvar(funcionario);
			System.out.println("Funcionário salvo com sucesso!");
		}
	}
	
	@Test
	@Ignore
	public void listar()
	{
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> resultado = funcionarioDao.listar();
		
		for (Funcionario funcionario : resultado)
		{
			System.out.println("Código funcionário: " + funcionario.getId());
			System.out.println("Carteira de trabalho: " + funcionario.getDataAdmissao());
			System.out.println("Data de admissão: " + funcionario.getDataAdmissao());
			System.out.println("Nome funcionário: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("RG: " + funcionario.getPessoa().getRg());
			System.out.println("Rua: " + funcionario.getPessoa().getRua());
			System.out.println("Número: " + funcionario.getPessoa().getNumero());
			System.out.println("Complemento: " + funcionario.getPessoa().getCpf());
			System.out.println("Bairro: " + funcionario.getPessoa().getBairro());
			System.out.println("Cidade: " + funcionario.getPessoa().getCidade());
			System.out.println("Cep: " + funcionario.getPessoa().getCep());
			System.out.println("Telefone: " + funcionario.getPessoa().getTelefone());
			System.out.println("Celular: " + funcionario.getPessoa().getCelular());
			System.out.println("Email: " + funcionario.getPessoa().getEmail());
			System.out.println();
			
		}
	}
	
	@Test
	@Ignore
	public void buscar()
	{
		Long codigo = 1L; 
		FuncionarioDao funcionarioDao = new FuncionarioDao(); 
		Funcionario funcionario = funcionarioDao.buscar(codigo);
		
		if(funcionario == null)
		{
			System.out.println("Registro não encotnrado");
		}
		
		else 
		{
			System.out.println("Código funcionário: " + funcionario.getId());
			System.out.println("Carteira de trabalho: " + funcionario.getDataAdmissao());
			System.out.println("Data de admissão: " + funcionario.getDataAdmissao());
			System.out.println("Nome funcionário: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("RG: " + funcionario.getPessoa().getRg());
			System.out.println("Rua: " + funcionario.getPessoa().getRua());
			System.out.println("Número: " + funcionario.getPessoa().getNumero());
			System.out.println("Complemento: " + funcionario.getPessoa().getCpf());
			System.out.println("Bairro: " + funcionario.getPessoa().getBairro());
			System.out.println("Cidade: " + funcionario.getPessoa().getCidade());
			System.out.println("Cep: " + funcionario.getPessoa().getCep());
			System.out.println("Telefone: " + funcionario.getPessoa().getTelefone());
			System.out.println("Celular: " + funcionario.getPessoa().getCelular());
			System.out.println("Email: " + funcionario.getPessoa().getEmail());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void editar()
	{
		Long codigo = 1L; 
		FuncionarioDao funcionarioDao = new FuncionarioDao(); 
		Funcionario funcionario = funcionarioDao.buscar(codigo); 
		
		if(funcionario == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else 
		{
			System.out.println("Registro a ser editado: "); 
			System.out.println("Código funcionário: " + funcionario.getId());
			System.out.println("Carteira de trabalho: " + funcionario.getDataAdmissao());
			System.out.println("Data de admissão: " + funcionario.getDataAdmissao());
			System.out.println("Nome funcionário: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("RG: " + funcionario.getPessoa().getRg());
			System.out.println("Rua: " + funcionario.getPessoa().getRua());
			System.out.println("Número: " + funcionario.getPessoa().getNumero());
			System.out.println("Complemento: " + funcionario.getPessoa().getCpf());
			System.out.println("Bairro: " + funcionario.getPessoa().getBairro());
			System.out.println("Cidade: " + funcionario.getPessoa().getCidade());
			System.out.println("Cep: " + funcionario.getPessoa().getCep());
			System.out.println("Telefone: " + funcionario.getPessoa().getTelefone());
			System.out.println("Celular: " + funcionario.getPessoa().getCelular());
			System.out.println("Email: " + funcionario.getPessoa().getEmail());
			System.out.println();
			
			funcionario.setCarteiraTrabalho("987654321");
			funcionario.setDataAdmissao(new Date());
			funcionario.getPessoa().setNome("Maria José");
			funcionario.getPessoa().setCpf("111.222.333.44");
			funcionario.getPessoa().setRg("11.222.333-4");
			funcionario.getPessoa().setRua("Rua 2");
			funcionario.getPessoa().setNumero(new Short("999"));
			funcionario.getPessoa().setComplemento("Casa");
			funcionario.getPessoa().setBairro("Planalto");
			
			funcionario.getPessoa().setCep("19930-000");
			funcionario.getPessoa().setTelefone("3378-1458");
			funcionario.getPessoa().setCelular("18-999999999");
			funcionario.getPessoa().setEmail("maria@gmail.com");
			System.out.println();
			
			funcionarioDao.editar(funcionario);
			
			System.out.println("Registro editado: "); 
			System.out.println("Código funcionário: " + funcionario.getId());
			System.out.println("Carteira de trabalho: " + funcionario.getDataAdmissao());
			System.out.println("Data de admissão: " + funcionario.getDataAdmissao());
			System.out.println("Nome funcionário: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("RG: " + funcionario.getPessoa().getRg());
			System.out.println("Rua: " + funcionario.getPessoa().getRua());
			System.out.println("Número: " + funcionario.getPessoa().getNumero());
			System.out.println("Complemento: " + funcionario.getPessoa().getCpf());
			System.out.println("Bairro: " + funcionario.getPessoa().getBairro());
			System.out.println("Cidade: " + funcionario.getPessoa().getCidade());
			System.out.println("Cep: " + funcionario.getPessoa().getCep());
			System.out.println("Telefone: " + funcionario.getPessoa().getTelefone());
			System.out.println("Celular: " + funcionario.getPessoa().getCelular());
			System.out.println("Email: " + funcionario.getPessoa().getEmail());
			System.out.println();
			
		}
	}
	
	@Test
	@Ignore
	public void excluir()
	{
		Long codigo = 2L; 
		FuncionarioDao funcionarioDao = new FuncionarioDao(); 
		Funcionario funcionario = funcionarioDao.buscar(codigo);
		
		if (funcionario == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			System.out.println("Registro a ser excluído: ");
			System.out.println("Código funcionário: " + funcionario.getId());
			System.out.println("Carteira de trabalho: " + funcionario.getDataAdmissao());
			System.out.println("Data de admissão: " + funcionario.getDataAdmissao());
			System.out.println("Nome funcionário: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("RG: " + funcionario.getPessoa().getRg());
			System.out.println("Rua: " + funcionario.getPessoa().getRua());
			System.out.println("Número: " + funcionario.getPessoa().getNumero());
			System.out.println("Complemento: " + funcionario.getPessoa().getCpf());
			System.out.println("Bairro: " + funcionario.getPessoa().getBairro());
			System.out.println("Cidade: " + funcionario.getPessoa().getCidade());
			System.out.println("Cep: " + funcionario.getPessoa().getCep());
			System.out.println("Telefone: " + funcionario.getPessoa().getTelefone());
			System.out.println("Celular: " + funcionario.getPessoa().getCelular());
			System.out.println("Email: " + funcionario.getPessoa().getEmail());
			System.out.println();
			
			funcionarioDao.excluir(funcionario);
			
			System.out.println("Registro excluído: "); 
			System.out.println("Registro a ser excluído: ");
			System.out.println("Código funcionário: " + funcionario.getId());
			System.out.println("Carteira de trabalho: " + funcionario.getDataAdmissao());
			System.out.println("Data de admissão: " + funcionario.getDataAdmissao());
			System.out.println("Nome funcionário: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("RG: " + funcionario.getPessoa().getRg());
			System.out.println("Rua: " + funcionario.getPessoa().getRua());
			System.out.println("Número: " + funcionario.getPessoa().getNumero());
			System.out.println("Complemento: " + funcionario.getPessoa().getCpf());
			System.out.println("Bairro: " + funcionario.getPessoa().getBairro());
			System.out.println("Cidade: " + funcionario.getPessoa().getCidade());
			System.out.println("Cep: " + funcionario.getPessoa().getCep());
			System.out.println("Telefone: " + funcionario.getPessoa().getTelefone());
			System.out.println("Celular: " + funcionario.getPessoa().getCelular());
			System.out.println("Email: " + funcionario.getPessoa().getEmail());
			System.out.println();
		}
	}

}