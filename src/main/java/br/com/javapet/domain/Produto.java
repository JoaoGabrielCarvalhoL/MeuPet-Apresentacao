package br.com.javapet.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain
{
	@Column(length=80, nullable = false)
	private String descricao;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal preco; 
	

	public String getDescricao() 
	{
		return descricao;
	}

	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}

	public BigDecimal getPreco() 
	{
		return preco;
	}

	public void setPreco(BigDecimal preco) 
	{
		this.preco = preco;
	}


}
