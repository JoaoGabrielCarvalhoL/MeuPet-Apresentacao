package br.com.javapet.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.javapet.dao.CidadeDao;
import br.com.javapet.dao.EstadoDao;
import br.com.javapet.domain.Cidade;
import br.com.javapet.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable
{
	private Cidade cidade; 
	
	private List<Cidade> cidades;
	
	private List<Estado> estados;
	
	public List<Estado> getEstados() 
	{
		return estados;
	}
	
	public void setEstados(List<Estado> estados) 
	{
		this.estados = estados;
	}
	
	public Cidade getCidade() 
	{
		return cidade;
	}
	
	public void setCidade(Cidade cidade) 
	{
		this.cidade = cidade;
	}
	
	public List<Cidade> getCidades() 
	{
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) 
	{
		this.cidades = cidades;
	}
	
	@PostConstruct
	public void listar()
	{
		try 
		{
			CidadeDao cidadeDao = new CidadeDao(); 
			cidades = cidadeDao.listar("nome");
		}
		catch(RuntimeException erro)
		{
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as cidades");
			erro.printStackTrace();
		}
	}
	
	public void novo()
	{
		try
		{
			cidade = new Cidade(); 
			EstadoDao estadoDao = new EstadoDao(); 
			estados = estadoDao.listar("nome");
		}
		catch(RuntimeException erro)
		{
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar gerar uma nova cidade");
			erro.printStackTrace();
		}
	}
	
	public void salvar() 
	{
		try
		{
			CidadeDao cidadeDao = new CidadeDao(); 
			cidadeDao.merge(cidade);
			
			cidade = new Cidade();
			
			EstadoDao estadoDao = new EstadoDao(); 
			estados = estadoDao.listar();
			
			cidades = cidadeDao.listar();
			Messages.addFlashGlobalInfo("Cidade salva com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar uma nova cidade");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento)
	{
		try
		{
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			CidadeDao cidadeDao = new CidadeDao(); 
			cidadeDao.excluir(cidade);
			
			cidades = cidadeDao.listar();
			
			Messages.addGlobalInfo("Cidade removida com sucesso");
			
		}
		catch(RuntimeException erro)
		{
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir uma cidade");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento)
	{
		try
		{ 
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			EstadoDao estadoDao = new EstadoDao(); 
			estados = estadoDao.listar();
			
		}
		catch(RuntimeException erro)
		{
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar alterar uma cidade");
			erro.printStackTrace();
		}
	}
}
