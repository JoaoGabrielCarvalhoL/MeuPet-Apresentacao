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

import br.com.javapet.dao.ProdutoDao;
import br.com.javapet.domain.Produto;
import br.com.javapet.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable 
{
	private Produto  produto;
	private List<Produto> produtos;
	
	
	public Produto getProduto() 
	{
		return produto;
	}

	public void setProduto(Produto produto) 
	{
		this.produto = produto;
	}

	public List<Produto> getProdutos() 
	{
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) 
	{
		this.produtos = produtos;
	}


	@PostConstruct
	public void listar() 
	{
		try 
		{
			ProdutoDao produtoDAO = new ProdutoDao();
			produtos = produtoDAO.listar();
		} 
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os produtos");
			erro.printStackTrace();
		}
	}
	
	public void novo() 
	{
		try 
		{
			produto = new Produto();

			
			
		} 
		catch (RuntimeException erro) 
		{
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar gerar um novo produto");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento)
	{
		try 
		{
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			
		} 
		catch (RuntimeException erro) 
		{
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um produto");
			erro.printStackTrace();
		}	
	}
	
	public void salvar()
	{
		try 
		{
			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.merge(produto);

			produto = new Produto();

			produtos = produtoDao.listar();

			Messages.addGlobalInfo("Produto salvo com sucesso");
		} 
		catch (RuntimeException erro) 
		{
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar o produto");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) 
	{
		try
		{
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.excluir(produto);

			produtos = produtoDao.listar();

			Messages.addGlobalInfo("Produto removido com sucesso");
		} 
		
		catch (RuntimeException erro)
		{
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o produto");
			erro.printStackTrace();
		}
	}
	
	public void imprimir()
	{
		try
		{
			String caminho = Faces.getRealPath("/reports/Produtos.jasper");
			
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