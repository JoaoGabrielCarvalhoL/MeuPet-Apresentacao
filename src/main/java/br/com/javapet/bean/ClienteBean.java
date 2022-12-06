package br.com.javapet.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.javapet.dao.ClienteDao;
import br.com.javapet.dao.PessoaDao;
import br.com.javapet.domain.Cliente;
import br.com.javapet.domain.Pessoa;
import br.com.javapet.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable
{
	private Cliente cliente;
	
	private List<Cliente> clientes; 
	
	private List<Pessoa> pessoas; 
	
	
	public List<Cliente> getClientes() 
	{
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) 
	{
		this.clientes = clientes;
	}
	
	public Cliente getCliente() 
	{
		return cliente;
	}
	
	public void setCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}
	
	public List<Pessoa> getPessoas() 
	{
		return pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas) 
	{
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void listar()
	{
		try
		{
			ClienteDao clienteDao = new ClienteDao(); 
			clientes = clienteDao.listar("dataCadastro");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar listar clientes.");
			erro.printStackTrace();
		}
	}
	
	public void novo()
	{
		try
		{
			cliente = new Cliente(); 
			PessoaDao pessoaDao = new PessoaDao();
		
			pessoas = pessoaDao.listar("nome");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo cliente.");
			erro.printStackTrace();
		}
	}
	
	public void salvar()
	{
		try
		{
			ClienteDao clienteDao = new ClienteDao(); 
			clienteDao.merge(cliente);
			
			cliente = new Cliente(); 
			clientes = clienteDao.listar("dataCadastro");
			
			PessoaDao pessoaDao = new PessoaDao(); 
			pessoas = pessoaDao.listar("nome");
			Messages.addGlobalInfo("Cliente salvo com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo cliente");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento)
	{
		try
		{
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			ClienteDao clienteDao = new ClienteDao(); 
			clienteDao.excluir(cliente);
			
			clientes = clienteDao.listar("dataCadastro");
			Messages.addGlobalInfo("Cliente excluído com sucesso!");
			
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir um cliente");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento)
	{
		try
		{
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar um cliente");
			erro.printStackTrace();
		}
		
	}
	
	public void imprimir()
	{
		try
		{
			String caminho = Faces.getRealPath("/reports/Clientes.jasper");
			
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
