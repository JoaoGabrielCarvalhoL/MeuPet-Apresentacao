package br.com.javapet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Administrador extends GenericDomain
{
	@Column(length=18, nullable = false)
	private String cnpj;
	
	@Column(length=20, nullable = false)
	private String inscricaoEstadual; 
	
	@Column(length=50, nullable = false)
	private String nomeFantasia; 
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getCnpj() 
	{
		return cnpj;
	}

	public void setCnpj(String cnpj) 
	{
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() 
	{
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) 
	{
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getNomeFantasia() 
	{
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) 
	{
		this.nomeFantasia = nomeFantasia;
	}

	public Pessoa getPessoa() 
	{
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) 
	{
		this.pessoa = pessoa;
	} 
}
