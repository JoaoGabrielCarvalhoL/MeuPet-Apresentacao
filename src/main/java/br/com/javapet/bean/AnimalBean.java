package br.com.javapet.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.javapet.dao.AnimalDao;
import br.com.javapet.dao.ClienteDao;
import br.com.javapet.domain.Animal;
import br.com.javapet.domain.Cliente;
import br.com.javapet.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AnimalBean implements Serializable
{
	private Animal animal; 
	
	private List<Animal> animais;
	
	private Cliente cliente; 
	
	private List<Cliente> clientes;
	
	public Animal getAnimal() 
	{
		return animal;
	}

	public void setAnimal(Animal animal) 
	{
		this.animal = animal;
	}

	public List<Animal> getAnimais() 
	{
		return animais;
	}

	public void setAnimais(List<Animal> animais) 
	{
		this.animais = animais;
	}

	public Cliente getCliente() 
	{
		return cliente;
	}

	public void setCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() 
	{
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) 
	{
		this.clientes = clientes;
	}

	@PostConstruct
	public void listar()
	{
		try
		{
			AnimalDao animalDao = new AnimalDao(); 
			animais = animalDao.listar("nomeAnimal");
			
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar listar animais");
			erro.printStackTrace();
		}
	}
	
	public void novo()
	{
		try
		{
			animal = new Animal();
			cliente = new Cliente(); 
			
			ClienteDao clienteDao = new ClienteDao();
			clientes = clienteDao.listar();
			
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo animal");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento)
	{
		try
		{
			animal = (Animal) evento.getComponent().getAttributes().get("animalSelecionado");
			
		}catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar animal");
			erro.printStackTrace();
		}
	}
	
	public void salvar()
	{
		try
		{
			AnimalDao animalDao = new AnimalDao(); 
			animalDao.merge(animal);
			
			animal = new Animal(); 
			animais = animalDao.listar("nomeAnimal");
			
			ClienteDao clienteDao = new ClienteDao(); 
			clientes = clienteDao.listar();
			
			Messages.addGlobalInfo("Animal salvo com sucesso!");
			
		}catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar animal");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) 
	{
		try
		{
			animal = (Animal) evento.getComponent().getAttributes().get("animalSelecionado");
			AnimalDao animalDao = new AnimalDao(); 
			animalDao.excluir(animal);
			
			animais = animalDao.listar();
			Messages.addGlobalInfo("Animal excluído com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir animal");
			erro.printStackTrace();
		}
	}
	
	public void imprimir()
	{
		try
		{
			String caminho = Faces.getRealPath("/reports/Animais.jasper");
			
			Map<String, Object> parametros = new HashMap<>();
			
			Connection conexao = HibernateUtil.getConexao();
			
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			JasperPrintManager.printReport(relatorio, true);
		}
		catch(JRException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			erro.printStackTrace();
		}
	}
	
}
