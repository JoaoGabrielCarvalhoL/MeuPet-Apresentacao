package br.com.javapet.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.javapet.domain.Estado;

public class EstadoDaoTest 
{
	@Test
	@Ignore
	public void salvar()
	{
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDao estadoDao = new EstadoDao();
		estadoDao.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar()
	{
		EstadoDao estadoDao = new EstadoDao();
		List<Estado> resultado = estadoDao.listar();
		
		System.out.println("Total de registros encontrados: " + resultado.size());
		
		for (Estado estado: resultado)
		{
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar()
	{
		Long codigo = 1L;
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigo); 
		
		if(estado == null) 
		{
			System.out.println("Nennhum registro encontrado");
		}
		else
		{
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir()
	{
		Long codigo = 1L; 
		EstadoDao estadoDao = new EstadoDao(); 
		Estado estado = estadoDao.buscar(codigo);
		
		if(estado == null) 
		{
			System.out.println("Nennhum registro encontrado");
		}
		else
		{	
			estadoDao.excluir(estado);
			System.out.println("Registro removido: ");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
		
	}
	
	@Test
	public void editar()
	{
		Long codigo = 1L; 
		EstadoDao estadoDao = new EstadoDao(); 
		Estado estado = estadoDao.buscar(codigo);
		
		if(estado == null) 
		{
			System.out.println("Nennhum registro encontrado");
		}
		
		else
		{
			System.out.println("Registro a ser editado: ");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
			
			estado.setNome("Rio de Janeiro");
			estado.setSigla("RJ");
			estadoDao.editar(estado);
			
			System.out.println("Registro editado: ");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
		
		
	}
}	
