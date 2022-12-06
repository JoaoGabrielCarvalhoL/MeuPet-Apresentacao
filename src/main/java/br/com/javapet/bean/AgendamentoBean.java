package br.com.javapet.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.javapet.dao.AgendamentoDao;
import br.com.javapet.dao.ClienteDao;
import br.com.javapet.dao.ProdutoDao;
import br.com.javapet.domain.Agendamento;
import br.com.javapet.domain.Cliente;
import br.com.javapet.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped 
public class AgendamentoBean implements Serializable
{
	private Agendamento agendamento; 
	
	private List<Cliente> clientes; 
	
	private List<Produto> produtos; 
	
	private List<Agendamento> agendamentos;
	
	private Produto produto; 
	
	private Cliente cliente;


	public Agendamento getAgendamento()
	{
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) 
	{
		this.agendamento = agendamento;
	}

	public List<Cliente> getClientes() 
	{
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) 
	{
		this.clientes = clientes;
	}

	public List<Produto> getProdutos()
	{
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) 
	{
		this.produtos = produtos;
	}

	public List<Agendamento> getAgendamentos()
	{
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) 
	{
		this.agendamentos = agendamentos;
	}
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@PostConstruct
	public void listar()
	{
		try
		{
			AgendamentoDao agendamentoDao = new AgendamentoDao(); 
			agendamentos = agendamentoDao.listar("dataAgendamento");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar listar agendamentos");
			erro.printStackTrace();
		}
	}
	
	public void novo()
	{
		try
		{
			agendamento = new Agendamento();
			cliente = new Cliente(); 
			produto = new Produto(); 
			
			
			ClienteDao clienteDao = new ClienteDao(); 
			clientes = clienteDao.listar();
			
			ProdutoDao produtoDao = new ProdutoDao(); 
			produtos = produtoDao.listar();
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo agendamento");
			erro.printStackTrace();
		}
		
	}
	
	public void salvar()
	{
		try
		{
			AgendamentoDao agendamentoDao = new AgendamentoDao(); 
			agendamentoDao.merge(agendamento);
			
			agendamento = new Agendamento(); 
			agendamentos = agendamentoDao.listar("dataAgendamento");
			
			ClienteDao clienteDao = new ClienteDao(); 
			clientes = clienteDao.listar(); 
			
			ProdutoDao produtoDao = new ProdutoDao();
			produtos = produtoDao.listar();
			
			Messages.addGlobalInfo("Agendamento salvo com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo agendamento");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento)
	{
		try
		{
			agendamento = (Agendamento) evento.getComponent().getAttributes().get("agendamentoSelecionado");
			AgendamentoDao agendamentoDao = new AgendamentoDao(); 
			agendamentoDao.excluir(agendamento);
			
			agendamentos = agendamentoDao.listar("dataAgendamento");
			Messages.addGlobalInfo("Agendamento excluído com sucesso!");
			
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir um agendamento");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento)
	{
		try
		{
			agendamento = (Agendamento) evento.getComponent().getAttributes().get("agendamentoSelecionado");
			
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar um agendamento");
			erro.printStackTrace();
		}
		
	}
	
	
	
}
