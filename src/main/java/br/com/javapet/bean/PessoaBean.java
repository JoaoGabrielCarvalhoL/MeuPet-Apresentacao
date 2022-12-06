package br.com.javapet.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.javapet.dao.CidadeDao;
import br.com.javapet.dao.EstadoDao;
import br.com.javapet.dao.PessoaDao;
import br.com.javapet.domain.Cidade;
import br.com.javapet.domain.Estado;
import br.com.javapet.domain.Pessoa;
import br.com.javapet.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable
{
	private Pessoa pessoa; 
	
	private List<Pessoa> pessoas; 
	
	private Estado estado; 
		
	private List<Estado> estados; 
	
	private List<Cidade> cidades; 
	
	
	public List<Cidade> getCidades() 
	{
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) 
	{
		this.cidades = cidades;
	}
	
	public List<Estado> getEstados()
	{
		return estados;
	}
	
	public void setEstados(List<Estado> estados) 
	{
		this.estados = estados;
	}
	
	public Pessoa getPessoa() 
	{
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) 
	{
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getPessoas() 
	{
		return pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas) 
	{
		this.pessoas = pessoas;
	}
	
	public Estado getEstado() 
	{
		return estado;
	}
	
	public void setEstado(Estado estado) 
	{
		this.estado = estado;
	}
	
	@PostConstruct
	public void listar()
	{
		try 
		{
			PessoaDao pessoaDao = new PessoaDao(); 
			pessoas = pessoaDao.listar("nome");
		
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as pessoas");
			erro.printStackTrace();
		}
	}
	
	public void novo()
	{
		try
		{
			pessoa = new Pessoa(); 
			estado = new Estado(); 
			
			EstadoDao estadoDao = new EstadoDao(); 
			estados = estadoDao.listar("nome");
			
			cidades = new ArrayList<>();
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova pessoa");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento)
	{
		try
		{
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar apagar pessoa selecionada");
			erro.printStackTrace();
		}
		
	}
	
	public void salvar()
	{
		try
		{
			PessoaDao pessoaDao = new PessoaDao(); 
			pessoaDao.merge(pessoa);
			
			pessoas = pessoaDao.listar("nome");
			
			pessoa = new Pessoa(); 
			estado = new Estado(); 
			
			EstadoDao estadoDao = new EstadoDao(); 
			estados = estadoDao.listar("nome");
			
			cidades = new ArrayList<>();
			
			
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar uma pessoa");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento)
	{
		try
		{
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			PessoaDao pessoaDao = new PessoaDao(); 
			pessoaDao.excluir(pessoa);
			
			pessoas = pessoaDao.listar("nome");
			Messages.addGlobalInfo("Pessoa exclúida com sucesso!");
		}
		catch (RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir uma pessoa");
			erro.printStackTrace();
		}
	}
	
	public void popular()
	{
		try
		{
			if (estado != null)
			{
				CidadeDao cidadeDao = new CidadeDao(); 
				cidades = cidadeDao.buscarPorEstado(estado.getId());
			}
			
			else
			{
				cidades = new ArrayList<>();
			}
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorre um erro ao tentar filtrar as cidades");
			erro.printStackTrace();
		}
	}
	
	public void imprimir()
	{
		try
		{
			String caminho = Faces.getRealPath("/reports/Pessoas.jasper");
			
			Map<String, Object> parametros = new HashMap<>();
			
			Connection conexao = HibernateUtil.getConexao();
			
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			JasperPrintManager.printReport(relatorio, true);
		}
		catch(JRException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			erro.printStackTrace();
		}
	}
}
