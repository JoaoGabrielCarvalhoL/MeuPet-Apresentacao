package br.com.javapet.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.javapet.domain.Pessoa;
import br.com.javapet.domain.Usuario;

public class UsuarioDaoTest 
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
		
			System.out.println("Pessoa encontrada: ");
		
			System.out.println("Código cliente: " + pessoa.getId());
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Número: " + pessoa.getNumero());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println("CEP: " + pessoa.getCep());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Cidade: " + pessoa.getCidade());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("Email: " + pessoa.getEmail());
			
			
			Usuario usuario = new Usuario(); 
			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);
			usuario.setSenha("123456");
			usuario.setTipo('A');
			
			UsuarioDao usuarioDao = new UsuarioDao(); 
			usuarioDao.salvar(usuario);
			
			System.out.println("Usuário salvo com sucesso");
		}	
	}
	
	@Test
	@Ignore
	public void listar()
	{
		UsuarioDao usuarioDao = new UsuarioDao(); 
		List<Usuario> resultado = usuarioDao.listar();
		
		for(Usuario usuario : resultado)
		{
			System.out.println("Código Usuário: " + usuario.getId());
			System.out.println("Situação: " + usuario.getAtivo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Nome: " + usuario.getPessoa().getNome());
			System.out.println("CPF: " + usuario.getPessoa().getCpf());
			System.out.println("RG: " + usuario.getPessoa().getRg());
			System.out.println("Rua: " + usuario.getPessoa().getRua());
			System.out.println("Número: " + usuario.getPessoa().getNumero());
			System.out.println("Bairro: " + usuario.getPessoa().getBairro());
			System.out.println("CEP: " + usuario.getPessoa().getCep());
			System.out.println("Complemento: " + usuario.getPessoa().getComplemento());
			System.out.println("Cidade: " + usuario.getPessoa().getCidade());
			System.out.println("Telefone: " + usuario.getPessoa().getTelefone());
			System.out.println("Celular: " + usuario.getPessoa().getCelular());
			System.out.println("Email: " + usuario.getPessoa().getEmail());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar()
	{
		Long codigo = 2L; 
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.buscar(codigo); 
		
		if (usuario == null)
		{
			System.out.println("Registro não encontrado");
		}
		else
		{
			System.out.println("Código Usuário: " + usuario.getId());
			System.out.println("Situação: " + usuario.getAtivo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Nome: " + usuario.getPessoa().getNome());
			System.out.println("CPF: " + usuario.getPessoa().getCpf());
			System.out.println("RG: " + usuario.getPessoa().getRg());
			System.out.println("Rua: " + usuario.getPessoa().getRua());
			System.out.println("Número: " + usuario.getPessoa().getNumero());
			System.out.println("Bairro: " + usuario.getPessoa().getBairro());
			System.out.println("CEP: " + usuario.getPessoa().getCep());
			System.out.println("Complemento: " + usuario.getPessoa().getComplemento());
			System.out.println("Cidade: " + usuario.getPessoa().getCidade());
			System.out.println("Telefone: " + usuario.getPessoa().getTelefone());
			System.out.println("Celular: " + usuario.getPessoa().getCelular());
			System.out.println("Email: " + usuario.getPessoa().getEmail());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void excluir() 
	{
		Long codigo = 3L; 
		UsuarioDao usuarioDao = new UsuarioDao(); 
		Usuario usuario = usuarioDao.buscar(codigo);
		
		if (usuario == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			usuarioDao.excluir(usuario);
			System.out.println("Usuário deleteado: ");
			System.out.println("Código Usuário: " + usuario.getId());
			System.out.println("Situação: " + usuario.getAtivo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Nome: " + usuario.getPessoa().getNome());
			System.out.println("CPF: " + usuario.getPessoa().getCpf());
			System.out.println("RG: " + usuario.getPessoa().getRg());
			System.out.println("Rua: " + usuario.getPessoa().getRua());
			System.out.println("Número: " + usuario.getPessoa().getNumero());
			System.out.println("Bairro: " + usuario.getPessoa().getBairro());
			System.out.println("CEP: " + usuario.getPessoa().getCep());
			System.out.println("Complemento: " + usuario.getPessoa().getComplemento());
			System.out.println("Cidade: " + usuario.getPessoa().getCidade());
			System.out.println("Telefone: " + usuario.getPessoa().getTelefone());
			System.out.println("Celular: " + usuario.getPessoa().getCelular());
			System.out.println("Email: " + usuario.getPessoa().getEmail());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void editar()
	{
		Long codigo = 3L;
		UsuarioDao usuarioDao = new UsuarioDao(); 
		Usuario usuario = usuarioDao.buscar(codigo);
		
		if (usuario == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else 
		{
			System.out.println("Registro a ser editado: "); 
			System.out.println("Código Usuário: " + usuario.getId());
			System.out.println("Situação: " + usuario.getAtivo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Nome: " + usuario.getPessoa().getNome());
			System.out.println("CPF: " + usuario.getPessoa().getCpf());
			System.out.println("RG: " + usuario.getPessoa().getRg());
			System.out.println("Rua: " + usuario.getPessoa().getRua());
			System.out.println("Número: " + usuario.getPessoa().getNumero());
			System.out.println("Bairro: " + usuario.getPessoa().getBairro());
			System.out.println("CEP: " + usuario.getPessoa().getCep());
			System.out.println("Complemento: " + usuario.getPessoa().getComplemento());
			System.out.println("Cidade: " + usuario.getPessoa().getCidade());
			System.out.println("Telefone: " + usuario.getPessoa().getTelefone());
			System.out.println("Celular: " + usuario.getPessoa().getCelular());
			System.out.println("Email: " + usuario.getPessoa().getEmail());
			System.out.println();
			
			usuario.setAtivo(false);
			usuario.setTipo('F');
			usuario.setSenha("q1w2e3r4"); 
			usuario.getPessoa().setNome("Antônio Lopes da Cruz");
			usuario.getPessoa().setCpf("000.000.000-00");
			usuario.getPessoa().setRg("11.111.111-1");
			usuario.getPessoa().setRua("Eduardo Martins Romeira");
			usuario.getPessoa().setNumero(new Short("302"));
			usuario.getPessoa().setBairro("Jardim Planalto");
			usuario.getPessoa().setCep("19930-000");
			usuario.getPessoa().setComplemento("Casa");
			
			usuario.getPessoa().setTelefone("3379-0000");
			usuario.getPessoa().setCelular("14-000000000");
			usuario.getPessoa().setEmail("antonio@hotmail.com");
			
			usuarioDao.editar(usuario);
			System.out.println("Registro editado: ");
			System.out.println("Código Usuário: " + usuario.getId());
			System.out.println("Situação: " + usuario.getAtivo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Nome: " + usuario.getPessoa().getNome());
			System.out.println("CPF: " + usuario.getPessoa().getCpf());
			System.out.println("RG: " + usuario.getPessoa().getRg());
			System.out.println("Rua: " + usuario.getPessoa().getRua());
			System.out.println("Número: " + usuario.getPessoa().getNumero());
			System.out.println("Bairro: " + usuario.getPessoa().getBairro());
			System.out.println("CEP: " + usuario.getPessoa().getCep());
			System.out.println("Complemento: " + usuario.getPessoa().getComplemento());
			System.out.println("Cidade: " + usuario.getPessoa().getCidade());
			System.out.println("Telefone: " + usuario.getPessoa().getTelefone());
			System.out.println("Celular: " + usuario.getPessoa().getCelular());
			System.out.println("Email: " + usuario.getPessoa().getEmail());
			System.out.println();
			
		}
	}
}
