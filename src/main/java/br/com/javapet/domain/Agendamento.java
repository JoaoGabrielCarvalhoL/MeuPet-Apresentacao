package br.com.javapet.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Agendamento extends GenericDomain
{
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAgendamento; 
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente; 
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto produto;

	public Date getDataAgendamento() 
	{
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) 
	{
		this.dataAgendamento = dataAgendamento;
	}

	public Cliente getCliente() 
	{
		return cliente;
	}

	public void setCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}

	public Produto getProduto() 
	{
		return produto;
	}

	public void setProduto(Produto produto) 
	{
		this.produto = produto;
	}
	
	
	
}
