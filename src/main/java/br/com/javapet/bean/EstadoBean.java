package br.com.javapet.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.javapet.dao.EstadoDao;
import br.com.javapet.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable
{
	private Estado estado;
	
	private List<Estado> estados; 
	
	public Estado getEstado() 
	{
		return estado;
	}
	
	public void setEstado(Estado estado) 
	{
		this.estado = estado;
	}
	
	public List<Estado> getEstados() 
	{
		return estados;
	}
	
	public void setEstados(List<Estado> estados) 
	{
		this.estados = estados;
	}
	
	public void salvar()
	{
		try
		{
			EstadoDao estadoDao = new EstadoDao();
			estadoDao.merge(estado);
			novo();
			estados = estadoDao.listar();
			Messages.addGlobalInfo("Estado salvo com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Erro ao tentar salvar o Estado");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento)
	{
		try 
		{
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			EstadoDao estadoDao = new EstadoDao(); 
			estadoDao.excluir(estado);
			estados = estadoDao.listar();
			Messages.addGlobalInfo("Estado removido com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o estado!");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento)
	{
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
	}
		
	
	@PostConstruct
	public void listar()
	{
		try
		{
			EstadoDao estadoDao = new EstadoDao(); 
			estados = estadoDao.listar();
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Erro ao tentar listar os Estados");
			erro.printStackTrace();
		}
	}
	
	public void novo() 
	{
		estado = new Estado(); 
	}
}
