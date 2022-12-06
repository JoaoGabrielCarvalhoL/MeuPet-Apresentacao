package br.com.javapet.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
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
import br.com.javapet.dao.FuncionarioDao;
import br.com.javapet.dao.ProdutoDao;
import br.com.javapet.dao.VendaDao;
import br.com.javapet.domain.Cliente;
import br.com.javapet.domain.Funcionario;
import br.com.javapet.domain.ItemVenda;
import br.com.javapet.domain.Produto;
import br.com.javapet.domain.Venda;
import br.com.javapet.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable 
{
	private List<Produto> produtos;
	
	private List<ItemVenda> itensVenda; 
	
	private Venda venda; 
	
	private List<Cliente> clientes; 
	
	private List<Funcionario> funcionarios; 
	
	public List<Funcionario> getFuncionarios() 
	{
		return funcionarios;
	}
	
	public void setFuncionarios(List<Funcionario> funcionarios) 
	{
		this.funcionarios = funcionarios;
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
	
	public List<ItemVenda> getItensVenda() 
	{
		return itensVenda;
	}
	
	public void setItensVenda(List<ItemVenda> itensVenda)
	{
		this.itensVenda = itensVenda;
	}
	
	public Venda getVenda() 
	{
		return venda;
	}
	
	public void setVenda(Venda venda) 
	{
		this.venda = venda;
	}
	
	@PostConstruct
	public void listar()
	{
		try
		{
			venda = new Venda(); 
			venda.setValorTotal(new BigDecimal("0.00"));
			
			ProdutoDao produtoDao = new ProdutoDao(); 
			produtos = produtoDao.listar("descricao");
			itensVenda = new ArrayList<>();
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar a tela de vendas");
			erro.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void adicionar(ActionEvent evento)
	{
		try
		{
			Produto produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			
			int achou = -1; 
			for(int posicao =0; posicao<itensVenda.size(); posicao++)
			{
				if (itensVenda.get(posicao).getProduto().equals(produto))
				{
					achou = posicao;
				}
			}
			
			if (achou < 0)
			{
				ItemVenda itemVenda = new ItemVenda(); 
				itemVenda.setValorParcial(produto.getPreco());
				itemVenda.setProduto(produto);
				itemVenda.setQuantidade(new Short("1"));
			
				itensVenda.add(itemVenda);
			}
			
			else
			{
				ItemVenda itemVenda = itensVenda.get(achou);
				itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() + 1 + ""));
				itemVenda.setValorParcial(produto.getPreco().multiply(new BigDecimal(itemVenda.getQuantidade())));
			}
			
			calcular();
			
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar adicionar produtos ao carrinho");
			erro.printStackTrace();
		}
	}
	
	public void remover(ActionEvent evento)
	{
		try
		{
			ItemVenda itemVenda = (ItemVenda)evento.getComponent().getAttributes().get("itemSelecionado");
			
			int achou = -1; 
			for(int posicao =0; posicao<itensVenda.size(); posicao ++)
			{
				if (itensVenda.get(posicao).getProduto().equals(itemVenda.getProduto()))
				{
					achou = posicao;
				}
			}
			
			if(achou >-1)
			{
				itensVenda.remove(achou);
			}
			
			calcular();
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar remover produtos");
			erro.printStackTrace();
		}
	}
	
	public void calcular()
	{
		venda.setValorTotal(new BigDecimal("0.00"));
		
		for (int posicao = 0; posicao<itensVenda.size(); posicao++)
		{
			ItemVenda itemVenda = itensVenda.get(posicao);
			venda.setValorTotal(venda.getValorTotal().add(itemVenda.getValorParcial()));
		}
	}
	
	public void finalizar()
	{
		try
		{
			venda.setHorario(new Date());
			venda.setCliente(null);
			venda.setFuncionario(null);
			
			FuncionarioDao funcionarioDao = new FuncionarioDao(); 
			funcionarios = funcionarioDao.listarOrdenado();
			
			ClienteDao clienteDao = new ClienteDao(); 
			clientes = clienteDao.listarOrdenado();
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar finalizar a venda");
			erro.printStackTrace();
		}
	}
	
	public void salvar()
	{
		try
		{
			if(venda.getValorTotal().signum() == 0)
			{
				Messages.addGlobalError("Não existe produtos na cesta de compras");
			}
			
			VendaDao vendaDao = new VendaDao(); 
			vendaDao.salvar(venda, itensVenda);
			
			listar();
			Messages.addGlobalInfo("Venda realizada com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a venda");
			erro.printStackTrace();
		}
	}
	
	public void imprimir()
	{
		try
		{
			String caminho = Faces.getRealPath("/reports/Vendas.jasper");
			
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
