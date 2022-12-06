package br.com.javapet.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.javapet.dao.PessoaDao;
import br.com.javapet.dao.UsuarioDao;
import br.com.javapet.domain.Pessoa;
import br.com.javapet.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable 
{
	private Usuario usuario;
	
	private List<Pessoa> pessoas;
	private List<Usuario> usuarios;
	
	public Usuario getUsuario() 
	{
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) 
	{
		this.usuario = usuario;
	}
	
	public List<Pessoa> getPessoas()
	{
		return pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas) 
	{
		this.pessoas = pessoas;
	}
	
	public List<Usuario> getUsuarios() 
	{
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) 
	{
		this.usuarios = usuarios;
	}
	
	@PostConstruct
	public void listar()
	{
		try
		{
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarios = usuarioDao.listar("tipo");
			
		}catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os usuários");
			erro.printStackTrace();
		}
	}
	
	public void novo() 
	{
		try 
		{
			usuario = new Usuario();

			PessoaDao pessoaDao = new PessoaDao();
			pessoas = pessoaDao.listar("nome");
		} 
		catch (RuntimeException erro) 
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo usuário");
			erro.printStackTrace();
		}
	}

	public void salvar() 
	{
		try 
		{
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.merge(usuario);
			
			usuario = new Usuario();
			usuarios = usuarioDao.listar("tipo");
			
			PessoaDao pessoaDAO = new PessoaDao();
			pessoas = pessoaDAO.listar("nome");
			
			Messages.addGlobalInfo("Usuário salvo com sucesso");
		} 
		catch (RuntimeException erro) 
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuário");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento)
	{
		try
		{
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar o usuário");
			erro.printStackTrace();	
		}
	}
	
	public void excluir(ActionEvent evento)
	{
		try
		{
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			UsuarioDao usuarioDao = new UsuarioDao(); 
			usuarioDao.excluir(usuario);
			
			
			usuarios = usuarioDao.listar(); 
			Messages.addGlobalInfo("Usuário excluído com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o usuário");
			erro.printStackTrace();
		}
	}
}
