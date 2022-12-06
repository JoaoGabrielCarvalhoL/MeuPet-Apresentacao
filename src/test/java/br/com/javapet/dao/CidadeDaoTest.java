package br.com.javapet.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.javapet.domain.Cidade;
import br.com.javapet.domain.Estado;

public class CidadeDaoTest 
{
	@Test
	@Ignore
	public void salvar()
	{
		Long codigo = 1L;
		
		EstadoDao estadoDao = new EstadoDao(); 
		
		Estado estado = estadoDao.buscar(codigo);
		
		if (estado == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			Cidade cidade = new Cidade();
			cidade.setNome("Ribeirão do Sul"); 
			cidade.setEstado(estado);
			
			CidadeDao cidadeDao = new CidadeDao(); 
			cidadeDao.salvar(cidade);
		}
		
	}
	
	@Test
	@Ignore
	public void listar()
	{
		CidadeDao cidadeDao = new CidadeDao(); 
		
		List<Cidade> resultado = cidadeDao.listar(); 
		
		for (Cidade cidade : resultado)
		{
			System.out.println("Código Cidade: " + cidade.getId());
			System.out.println("Nome Cidade: " + cidade.getNome());
			System.out.println("Código Estado: " + cidade.getEstado().getId());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();
			
		}
	}
	
	@Test
	@Ignore
	public void buscar()
	{
		Long codigo = 3L;
		
		CidadeDao cidadeDao = new CidadeDao(); 
		Cidade cidade = cidadeDao.buscar(codigo);
		
		if (cidade == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			System.out.println("Código Cidade: " + cidade.getId());
			System.out.println("Nome Cidade: " + cidade.getNome());
			System.out.println("Código Estado: " + cidade.getEstado().getId());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void excluir()
	{
		Long codigo = 3L;
		
		CidadeDao cidadeDao = new CidadeDao(); 
		Cidade cidade = cidadeDao.buscar(codigo);
		
		if (cidade == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			cidadeDao.excluir(cidade);
			System.out.println("Cidade exclúida: "); 
			System.out.println("Código Cidade: " + cidade.getId());
			System.out.println("Nome Cidade: " + cidade.getNome());
			System.out.println("Código Estado: " + cidade.getEstado().getId());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar()
	{
		/*
		Long codigoEstado = 11L;
		
		EstadoDao estadoDao = new EstadoDao(); 
		Estado estado = estadoDao.buscar(codigoEstado); 
		
		System.out.println("Código Estado: " + estado.getId());
		System.out.println("Sigla Estado: " + estado.getSigla());
		System.out.println("Nome Estado: " + estado.getNome());
		
		Para alterar o código do estado, caso esteja errado.
		*/
		
		Long codigoCidade = 4L;
		
		CidadeDao cidadeDao = new CidadeDao(); 
		Cidade cidade = cidadeDao.buscar(codigoCidade);
		
		if (cidade == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			
			System.out.println("Cidade a ser editada: "); 
			System.out.println("Código Cidade: " + cidade.getId());
			System.out.println("Nome Cidade: " + cidade.getNome());
			System.out.println("Código Estado: " + cidade.getEstado().getId());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();
			
			cidade.setNome("Salto Grande");
			cidadeDao.editar(cidade);
			
			System.out.println("Cidade editada: "); 
			System.out.println("Código Cidade: " + cidade.getId());
			System.out.println("Nome Cidade: " + cidade.getNome());
			System.out.println("Código Estado: " + cidade.getEstado().getId());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}

	}
}
