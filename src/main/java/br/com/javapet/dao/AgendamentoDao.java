package br.com.javapet.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.javapet.domain.Agendamento;
import br.com.javapet.util.HibernateUtil;

public class AgendamentoDao extends GenericDao<Agendamento>
{
	public Agendamento buscar(Date dataAgendamento)
	{
		 Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		 try
		 {
			 Criteria consulta = sessao.createCriteria(Agendamento.class);
			 consulta.add(Restrictions.eq("dataAgendamento", dataAgendamento));
			 Agendamento resultado = (Agendamento)consulta.uniqueResult(); 
			 return resultado; 
		 }
		 catch(RuntimeException erro)
		 {
			throw erro;
		 }
		finally 
		{
			sessao.close(); 
		}
	}
}
