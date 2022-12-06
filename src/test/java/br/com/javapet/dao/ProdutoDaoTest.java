package br.com.javapet.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.javapet.domain.Produto;

public class ProdutoDaoTest 
{
	@Test
	@Ignore
	public void salvar()
	{
		Produto produto = new Produto(); 
		produto.setDescricao("Banho e Tosa");
		produto.setPreco(new BigDecimal("60.00"));
		
		ProdutoDao produtoDao = new ProdutoDao(); 
		produtoDao.salvar(produto);
		
		System.out.println("Produto salvo com sucesso");
	}
	
	@Test
	public void listar()
	{
		ProdutoDao produtoDao = new ProdutoDao(); 
		List<Produto> resultado = produtoDao.listar();
		
		System.out.println("Total de registros encontrados: " + resultado.size());
		
		for (Produto produto : resultado)
		{
			System.out.println(produto.getId() + " - " + produto.getDescricao() + " - " + produto.getPreco());
		}
	}
	
	
	@Test
	public void buscar() 
	{
		Long codigo = 1L;
		ProdutoDao produtoDao = new ProdutoDao(); 
		Produto produto = produtoDao.buscar(codigo);
		
		if (produto == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			System.out.println(produto.getId() + " - " + produto.getDescricao() + " - " + produto.getPreco());
		}
		
	}
	
	@Test
	public void excluir()
	{
		Long codigo = 1L;
		ProdutoDao produtoDao = new ProdutoDao(); 
		Produto produto = produtoDao.buscar(codigo);
		
		
		if (produto == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			produtoDao.excluir(produto);
			System.out.println("Registro excluído: "); 
			System.out.println(produto.getId() + " - " + produto.getDescricao() + " - " + produto.getPreco());
		}
	}
	
	
	@Test
	public void editar()
	{
		Long codigo = 1L;
		ProdutoDao produtoDao = new ProdutoDao(); 
		Produto produto = produtoDao.buscar(codigo);
		
		if (produto == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else 
		{
			System.out.println("Registro a ser editado: "); 
			System.out.println(produto.getId() + " - " + produto.getDescricao() + " - " + produto.getPreco());
			
			produto.setDescricao("Novo produto");
			produto.setPreco(new BigDecimal("50.00"));
			produtoDao.editar(produto);
			System.out.println("");
		}
	
	}
}
