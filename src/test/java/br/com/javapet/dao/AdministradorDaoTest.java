package br.com.javapet.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.javapet.domain.Administrador;
import br.com.javapet.domain.Pessoa;

public class AdministradorDaoTest 
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
			Administrador administrador = new Administrador(); 
			
			administrador.setCnpj("XX.XXX.XXX/XXXX-XX");
			administrador.setInscricaoEstadual("11111111111");
			administrador.setNomeFantasia("Empresa João");
			administrador.setPessoa(pessoa);
		
			AdministradorDao administradorDao = new AdministradorDao(); 
			administradorDao.salvar(administrador);
			
			System.out.println("Administrador salvo com sucesso");
			
		}
	}
	
	@Test
	@Ignore
	public void listar()
	{
		AdministradorDao administradorDao = new AdministradorDao(); 
		List<Administrador> resultado = administradorDao.listar();
		
		for (Administrador administrador : resultado)
		{
			System.out.println("Código administrador: " + administrador.getId());
			System.out.println("CNPJ: " + administrador.getCnpj()); 
			System.out.println("Inscrição Estadual: " + administrador.getInscricaoEstadual()); 
			System.out.println("Nome fantasia: " + administrador.getNomeFantasia()); 
			System.out.println("Nome Administrador: " + administrador.getPessoa().getNome());
			System.out.println("CPF: " + administrador.getPessoa().getCpf());
			System.out.println("RG: " + administrador.getPessoa().getRg());
			System.out.println("Rua: " + administrador.getPessoa().getRua());
			System.out.println("Número: " + administrador.getPessoa().getNumero());
			System.out.println("Bairro: " + administrador.getPessoa().getBairro());
			System.out.println("CEP: " + administrador.getPessoa().getCep());
			System.out.println("Complemento: " + administrador.getPessoa().getComplemento());
			System.out.println("Cidade: " + administrador.getPessoa().getCidade());
			System.out.println("Telefone: " + administrador.getPessoa().getTelefone());
			System.out.println("Celular: " + administrador.getPessoa().getCelular());
			System.out.println("Email: " + administrador.getPessoa().getEmail());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar()
	{
		Long codigo = 1L; 
		AdministradorDao administradorDao = new AdministradorDao(); 
		Administrador administrador = administradorDao.buscar(codigo);
		
		if (administrador == null)
		{
			System.out.println("Registro não encontrado"); 
		}
		
		else
		{
			System.out.println("Código administrador: " + administrador.getId());
			System.out.println("CNPJ: " + administrador.getCnpj()); 
			System.out.println("Inscrição Estadual: " + administrador.getInscricaoEstadual()); 
			System.out.println("Nome fantasia: " + administrador.getNomeFantasia()); 
			System.out.println("Nome Administrador: " + administrador.getPessoa().getNome());
			System.out.println("CPF: " + administrador.getPessoa().getCpf());
			System.out.println("RG: " + administrador.getPessoa().getRg());
			System.out.println("Rua: " + administrador.getPessoa().getRua());
			System.out.println("Número: " + administrador.getPessoa().getNumero());
			System.out.println("Bairro: " + administrador.getPessoa().getBairro());
			System.out.println("CEP: " + administrador.getPessoa().getCep());
			System.out.println("Complemento: " + administrador.getPessoa().getComplemento());
			System.out.println("Cidade: " + administrador.getPessoa().getCidade());
			System.out.println("Telefone: " + administrador.getPessoa().getTelefone());
			System.out.println("Celular: " + administrador.getPessoa().getCelular());
			System.out.println("Email: " + administrador.getPessoa().getEmail());
			System.out.println();
		}
	}
	
	@Test
	public void excluir()
	{
		Long codigo = 2L; 
		AdministradorDao administradorDao = new AdministradorDao(); 
		Administrador administrador = administradorDao.buscar(codigo);
		
		if (administrador == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			System.out.println("Administrador a ser excluído: ");
			System.out.println("Código administrador: " + administrador.getId());
			System.out.println("CNPJ: " + administrador.getCnpj()); 
			System.out.println("Inscrição Estadual: " + administrador.getInscricaoEstadual()); 
			System.out.println("Nome fantasia: " + administrador.getNomeFantasia()); 
			System.out.println("Nome Administrador: " + administrador.getPessoa().getNome());
			System.out.println("CPF: " + administrador.getPessoa().getCpf());
			System.out.println("RG: " + administrador.getPessoa().getRg());
			System.out.println("Rua: " + administrador.getPessoa().getRua());
			System.out.println("Número: " + administrador.getPessoa().getNumero());
			System.out.println("Bairro: " + administrador.getPessoa().getBairro());
			System.out.println("CEP: " + administrador.getPessoa().getCep());
			System.out.println("Complemento: " + administrador.getPessoa().getComplemento());
			System.out.println("Cidade: " + administrador.getPessoa().getCidade());
			System.out.println("Telefone: " + administrador.getPessoa().getTelefone());
			System.out.println("Celular: " + administrador.getPessoa().getCelular());
			System.out.println("Email: " + administrador.getPessoa().getEmail());
			System.out.println();
			
			administradorDao.excluir(administrador);
			
			System.out.println("Administrador excluído: "); 
			System.out.println("Código administrador: " + administrador.getId());
			System.out.println("CNPJ: " + administrador.getCnpj()); 
			System.out.println("Inscrição Estadual: " + administrador.getInscricaoEstadual()); 
			System.out.println("Nome fantasia: " + administrador.getNomeFantasia()); 
			System.out.println("Nome Administrador: " + administrador.getPessoa().getNome());
			System.out.println("CPF: " + administrador.getPessoa().getCpf());
			System.out.println("RG: " + administrador.getPessoa().getRg());
			System.out.println("Rua: " + administrador.getPessoa().getRua());
			System.out.println("Número: " + administrador.getPessoa().getNumero());
			System.out.println("Bairro: " + administrador.getPessoa().getBairro());
			System.out.println("CEP: " + administrador.getPessoa().getCep());
			System.out.println("Complemento: " + administrador.getPessoa().getComplemento());
			System.out.println("Cidade: " + administrador.getPessoa().getCidade());
			System.out.println("Telefone: " + administrador.getPessoa().getTelefone());
			System.out.println("Celular: " + administrador.getPessoa().getCelular());
			System.out.println("Email: " + administrador.getPessoa().getEmail());
			System.out.println();
			
		}
	}
	
	@Test
	@Ignore
	public void editar()
	{
		Long codigo = 1L; 
		AdministradorDao administradorDao = new AdministradorDao(); 
		Administrador administrador = administradorDao.buscar(codigo);
		
		if (administrador == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			System.out.println("Administrador a ser editado: ");
			System.out.println("Código administrador: " + administrador.getId());
			System.out.println("CNPJ: " + administrador.getCnpj()); 
			System.out.println("Inscrição Estadual: " + administrador.getInscricaoEstadual()); 
			System.out.println("Nome fantasia: " + administrador.getNomeFantasia()); 
			System.out.println("Nome Administrador: " + administrador.getPessoa().getNome());
			System.out.println("CPF: " + administrador.getPessoa().getCpf());
			System.out.println("RG: " + administrador.getPessoa().getRg());
			System.out.println("Rua: " + administrador.getPessoa().getRua());
			System.out.println("Número: " + administrador.getPessoa().getNumero());
			System.out.println("Bairro: " + administrador.getPessoa().getBairro());
			System.out.println("CEP: " + administrador.getPessoa().getCep());
			System.out.println("Complemento: " + administrador.getPessoa().getComplemento());
			System.out.println("Cidade: " + administrador.getPessoa().getCidade());
			System.out.println("Telefone: " + administrador.getPessoa().getTelefone());
			System.out.println("Celular: " + administrador.getPessoa().getCelular());
			System.out.println("Email: " + administrador.getPessoa().getEmail());
			System.out.println();
			
			administrador.setCnpj("YY.YYY.YYY/YYYY-YY");
			administrador.setInscricaoEstadual("77777777777");
			administrador.setNomeFantasia("Carvalho Company");
			administrador.getPessoa().setNome("Laís Mansano");
			administrador.getPessoa().setCpf("252.525.252.52");
			administrador.getPessoa().setRg("12.212.121-2");
			administrador.getPessoa().setRua("Antônio Luiz Viana");
			administrador.getPessoa().setNumero(new Short("150"));
			administrador.getPessoa().setBairro("Centro");
			administrador.getPessoa().setCep("19930-000");
			administrador.getPessoa().setComplemento("Casa");
			
			administrador.getPessoa().setTelefone("3378-2525");
			administrador.getPessoa().setCelular("14-9999999");
			administrador.getPessoa().setEmail("laismansano@hotmail.com");
			
			administradorDao.salvar(administrador);
			
			System.out.println("Administrador a ser editado: ");
			System.out.println("Código administrador: " + administrador.getId());
			System.out.println("CNPJ: " + administrador.getCnpj()); 
			System.out.println("Inscrição Estadual: " + administrador.getInscricaoEstadual()); 
			System.out.println("Nome fantasia: " + administrador.getNomeFantasia()); 
			System.out.println("Nome Administrador: " + administrador.getPessoa().getNome());
			System.out.println("CPF: " + administrador.getPessoa().getCpf());
			System.out.println("RG: " + administrador.getPessoa().getRg());
			System.out.println("Rua: " + administrador.getPessoa().getRua());
			System.out.println("Número: " + administrador.getPessoa().getNumero());
			System.out.println("Bairro: " + administrador.getPessoa().getBairro());
			System.out.println("CEP: " + administrador.getPessoa().getCep());
			System.out.println("Complemento: " + administrador.getPessoa().getComplemento());
			System.out.println("Cidade: " + administrador.getPessoa().getCidade());
			System.out.println("Telefone: " + administrador.getPessoa().getTelefone());
			System.out.println("Celular: " + administrador.getPessoa().getCelular());
			System.out.println("Email: " + administrador.getPessoa().getEmail());
			System.out.println();
		}
	}
}