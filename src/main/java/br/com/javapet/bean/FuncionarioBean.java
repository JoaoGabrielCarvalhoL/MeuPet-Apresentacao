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

import br.com.javapet.dao.FuncionarioDao;
import br.com.javapet.dao.PessoaDao;
import br.com.javapet.domain.Funcionario;
import br.com.javapet.domain.Pessoa;
import br.com.javapet.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable
{
	private Funcionario funcionario; 
	
	private List<Funcionario> funcionarios; 
	
	private List<Pessoa> pessoas;

	public Funcionario getFuncionario() 
	{
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) 
	{
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() 
	{
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) 
	{
		this.funcionarios = funcionarios;
	}

	public List<Pessoa> getPessoas() 
	{
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) 
	{
		this.pessoas = pessoas;
	} 
	
	@PostConstruct
	public void listar()
	{
		try
		{
			
			FuncionarioDao funcionarioDao = new FuncionarioDao(); 
			funcionarios = funcionarioDao.listar();
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar listar funcionários");
			erro.printStackTrace();
		}
	}
	
	public void novo()
	{
		try
		{
			funcionario = new Funcionario(); 
			PessoaDao pessoaDao = new PessoaDao();
			
			pessoas = pessoaDao.listar("nome");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo funcionário");
			erro.printStackTrace();
		}
	}
	
	public void salvar() 
	{
		try 
		{
			FuncionarioDao funcionarioDao = new FuncionarioDao(); 
			funcionarioDao.merge(funcionario);
			
			funcionario = new Funcionario(); 
			funcionarios = funcionarioDao.listar("carteiraTrabalho");
			
			PessoaDao pessoaDao = new PessoaDao(); 
			pessoas = pessoaDao.listar("nome");
			Messages.addGlobalInfo("Funcionário salvo com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo funcionário");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento)
	{
		try
		{
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
			FuncionarioDao funcionarioDao = new FuncionarioDao(); 
			funcionarioDao.excluir(funcionario);
			
			funcionarios = funcionarioDao.listar("carteiraTrabalho");
			Messages.addGlobalInfo("Funcionário excluído com sucesso!");
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir funcionário");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento)
	{
		try
		{
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
		
		}
		catch(RuntimeException erro)
		{
			Messages.addGlobalError("Ocorreu um erro ao tentar editar funcionário");
			erro.printStackTrace();
		}
	}
	
	public void imprimir()
	{
		try
		{
			String caminho = Faces.getRealPath("/reports/Funcionarios.jasper");
			
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
