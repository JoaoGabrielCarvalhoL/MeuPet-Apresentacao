package br.com.javapet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain
{
	@Column(length=32, nullable = false)
	private String senha; 
	
	@Column(nullable = false)
	private Character tipo; 
	
	@Column(nullable = false)
	private Boolean ativo; 
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getSenha() 
	{
		return senha;
	}

	public void setSenha(String senha) 
	{
		this.senha = senha;
	}

	public Character getTipo() 
	{
		return tipo;
	}

	public void setTipo(Character tipo) 
	{
		this.tipo = tipo;
	}

	public Boolean getAtivo() 
	{
		return ativo;
	}

	public void setAtivo(Boolean ativo) 
	{
		this.ativo = ativo;
	}

	public Pessoa getPessoa() 
	{
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) 
	{
		this.pessoa = pessoa;
	} 
	
	@Transient
	public String getTipoFormatado()
	{
		String tipoFormatado = null;
		
		if(tipo == 'A' || tipo == 'a')
		{
			tipoFormatado = "Administrador";
		}
		
		if(tipo == 'C' || tipo == 'c')
		{
			tipoFormatado = "Cliente";
		}
		
		if(tipo == 'F' || tipo == 'f')
		{
			tipoFormatado = "Funcionário";
		}
		
		return tipoFormatado; 
	}
	
	@Transient
	public String getAtivoFormatado()
	{
		String ativoFormatado = null;
		
		if(ativo)
		{
			ativoFormatado = "Sim";
		}
		else 
		{
			ativoFormatado = "Não";
		}
		
		return ativoFormatado; 
		
		
	}
}
