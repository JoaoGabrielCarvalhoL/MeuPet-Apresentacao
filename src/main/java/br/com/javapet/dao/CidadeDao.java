package br.com.javapet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.javapet.domain.Cidade;
import br.com.javapet.util.HibernateUtil;

public class CidadeDao extends GenericDao<Cidade>
{
	@SuppressWarnings("unchecked")
	public List<Cidade> buscarPorEstado(Long estadoCodigo)
	{
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try
		{
			Criteria consulta = sessao.createCriteria(Cidade.class);
			consulta.add(Restrictions.eq("estado.id", estadoCodigo)); 
			consulta.addOrder(Order.asc("nome"));
			List<Cidade> resultado = consulta.list();
			return resultado; 
			
		}catch(RuntimeException erro)
		{
			throw erro; 
		}
		finally
		{
			sessao.close();
		}
	}
}
