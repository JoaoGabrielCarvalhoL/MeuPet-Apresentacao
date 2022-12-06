package br.com.javapet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Animal extends GenericDomain
{
	@Column(length=30, nullable = false)
	private String nomeAnimal;
	
	@Column(length=20, nullable = false)
	private String racaAnimal; 
	
	@Column(length= 20, nullable = false)
	private String porteAnimal;
	
	@Column(length=30, nullable = false)
	private String tipoAnimal;
	
	@Column(nullable = false)
	private short idadeAnimal;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;

	public String getNomeAnimal() 
	{
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) 
	{
		this.nomeAnimal = nomeAnimal;
	}

	public String getRacaAnimal() 
	{
		return racaAnimal;
	}

	public void setRacaAnimal(String racaAnimal) 
	{
		this.racaAnimal = racaAnimal;
	}

	public String getPorteAnimal() 
	{
		return porteAnimal;
	}

	public void setPorteAnimal(String porteAnimal) 
	{
		this.porteAnimal = porteAnimal;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public short getIdadeAnimal() {
		return idadeAnimal;
	}

	public void setIdadeAnimal(short idadeAnimal) {
		this.idadeAnimal = idadeAnimal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	} 
}
