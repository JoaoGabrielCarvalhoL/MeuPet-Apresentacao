package br.com.javapet.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.javapet.domain.Animal;
import br.com.javapet.domain.Cliente;

public class AnimalDaoTest 
{
	@Test
	@Ignore
	public void salvar()
	{
		Long codigo = 1L;
		ClienteDao clienteDao = new ClienteDao(); 
		Cliente cliente = clienteDao.buscar(codigo);
		
		if (cliente == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			Animal animal = new Animal(); 
			animal.setNomeAnimal("Ony");
			animal.setRacaAnimal("Vira-lata"); 
			animal.setPorteAnimal("Pequeno"); 
			animal.setTipoAnimal("Cachorro");
			animal.setIdadeAnimal(new Short("9"));
			animal.setCliente(cliente); 
			
			AnimalDao animalDao = new AnimalDao(); 
			animalDao.salvar(animal);
			System.out.println("Animal salvo com sucesso"); 
			
		}
	}
	
	@Test
	@Ignore
	public void listar()
	{
		AnimalDao animalDao = new AnimalDao(); 
		List<Animal> resultado = animalDao.listar();
		
		for (Animal animal : resultado)
		{
			System.out.println("Código Animal: " + animal.getId());
			System.out.println("Nome animal: " + animal.getNomeAnimal()); 
			System.out.println("Tipo animal: " + animal.getTipoAnimal()); 
			System.out.println("Raça animal: " + animal.getRacaAnimal()); 
			System.out.println("Porte animal: " + animal.getPorteAnimal()); 
			System.out.println("Idade animal: " + animal.getIdadeAnimal()); 
			System.out.println("Código dono Animal: " + animal.getCliente().getPessoa().getId());
			System.out.println("Nome dono Animal: " + animal.getCliente().getPessoa().getNome());
			System.out.println("CPF -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getCpf());
			System.out.println("RG -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getRg());
			System.out.println("Rua: " + animal.getCliente().getPessoa().getRua() + " Número:" + animal.getCliente().getPessoa().getNumero() + " Bairro:" + animal.getCliente().getPessoa().getBairro());
			System.out.println("CEP: " + animal.getCliente().getPessoa().getCep());
			System.out.println("Telefone: " + animal.getCliente().getPessoa().getTelefone() + " Celular: " + animal.getCliente().getPessoa().getTelefone());
			System.out.println("Email: " + animal.getCliente().getPessoa().getEmail());
			System.out.println();
		}
		
	}
	
	@Test
	public void buscar()
	{
		Long codigo = 1L;
		AnimalDao animalDao = new AnimalDao(); 
		Animal animal = animalDao.buscar(codigo);
		
		if(animal == null)
		{
			System.out.println("Registro não encontrado");
		}
		
		else
		{
			System.out.println("Código Animal: " + animal.getId());
			System.out.println("Nome animal: " + animal.getNomeAnimal()); 
			System.out.println("Tipo animal: " + animal.getTipoAnimal()); 
			System.out.println("Raça animal: " + animal.getRacaAnimal()); 
			System.out.println("Porte animal: " + animal.getPorteAnimal()); 
			System.out.println("Idade animal: " + animal.getIdadeAnimal()); 
			System.out.println("Código dono Animal: " + animal.getCliente().getPessoa().getId());
			System.out.println("Nome dono Animal: " + animal.getCliente().getPessoa().getNome());
			System.out.println("CPF -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getCpf());
			System.out.println("RG -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getRg());
			System.out.println("Rua: " + animal.getCliente().getPessoa().getRua() + " Número:" + animal.getCliente().getPessoa().getNumero() + " Bairro:" + animal.getCliente().getPessoa().getBairro());
			System.out.println("CEP: " + animal.getCliente().getPessoa().getCep());
			System.out.println("Telefone: " + animal.getCliente().getPessoa().getTelefone() + " Celular: " + animal.getCliente().getPessoa().getTelefone());
			System.out.println("Email: " + animal.getCliente().getPessoa().getEmail());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void editar()
	{
		Long codigo = 1L; 
		AnimalDao animalDao = new AnimalDao();
		Animal animal = animalDao.buscar(codigo);
		
		if (animal == null)
		{
			System.out.println("Registro não encontrado");
		}
		else
		{
			System.out.println("Registro a ser editado: ");
			System.out.println("Código Animal: " + animal.getId());
			System.out.println("Nome animal: " + animal.getNomeAnimal()); 
			System.out.println("Tipo animal: " + animal.getTipoAnimal()); 
			System.out.println("Raça animal: " + animal.getRacaAnimal()); 
			System.out.println("Porte animal: " + animal.getPorteAnimal()); 
			System.out.println("Idade animal: " + animal.getIdadeAnimal()); 
			System.out.println("Código dono Animal: " + animal.getCliente().getPessoa().getId());
			System.out.println("Nome dono Animal: " + animal.getCliente().getPessoa().getNome());
			System.out.println("CPF -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getCpf());
			System.out.println("RG -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getRg());
			System.out.println("Rua: " + animal.getCliente().getPessoa().getRua() + " Número:" + animal.getCliente().getPessoa().getNumero() + " Bairro:" + animal.getCliente().getPessoa().getBairro());
			System.out.println("CEP: " + animal.getCliente().getPessoa().getCep());
			System.out.println("Telefone: " + animal.getCliente().getPessoa().getTelefone() + " Celular: " + animal.getCliente().getPessoa().getTelefone());
			System.out.println("Email: " + animal.getCliente().getPessoa().getEmail());
			System.out.println();
			
			animal.setNomeAnimal("Gatinha");
			animal.setTipoAnimal("Gato");
			animal.setRacaAnimal("Vira-lata");
			animal.setPorteAnimal("Pequeno");
			animal.setIdadeAnimal(new Short("3"));
			animal.getCliente().getPessoa().setNome("Antônio Lopes da Cruz");
			animal.getCliente().getPessoa().setCpf("123.123.123-12");
			animal.getCliente().getPessoa().setRg("12.123.123-1");
			animal.getCliente().getPessoa().setRua("Eduardo Martins Romeira");
			animal.getCliente().getPessoa().setNumero(new Short("302"));
			animal.getCliente().getPessoa().setBairro("Jardim Planalto");
			animal.getCliente().getPessoa().setCep("19930-000");
			animal.getCliente().getPessoa().setTelefone("3379-1173");
			animal.getCliente().getPessoa().setCelular("998000000");
			animal.getCliente().getPessoa().setEmail("cruza70@terra.com.br");
			animalDao.editar(animal);
			
			System.out.println("Registro editado: ");
			System.out.println("Código Animal: " + animal.getId());
			System.out.println("Nome animal: " + animal.getNomeAnimal()); 
			System.out.println("Tipo animal: " + animal.getTipoAnimal()); 
			System.out.println("Raça animal: " + animal.getRacaAnimal()); 
			System.out.println("Porte animal: " + animal.getPorteAnimal()); 
			System.out.println("Idade animal: " + animal.getIdadeAnimal()); 
			System.out.println("Código dono Animal: " + animal.getCliente().getPessoa().getId());
			System.out.println("Nome dono Animal: " + animal.getCliente().getPessoa().getNome());
			System.out.println("CPF -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getCpf());
			System.out.println("RG -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getRg());
			System.out.println("Rua: " + animal.getCliente().getPessoa().getRua() + " Número:" + animal.getCliente().getPessoa().getNumero() + " Bairro:" + animal.getCliente().getPessoa().getBairro());
			System.out.println("CEP: " + animal.getCliente().getPessoa().getCep());
			System.out.println("Telefone: " + animal.getCliente().getPessoa().getTelefone() + " Celular: " + animal.getCliente().getPessoa().getTelefone());
			System.out.println("Email: " + animal.getCliente().getPessoa().getEmail());
			System.out.println();
						
		}
	}
	
	@Test
	@Ignore
	public void excluir()
	{
		Long codigo = 1L;
		AnimalDao animalDao = new AnimalDao(); 
		Animal animal = animalDao.buscar(codigo);
		
		if(animal == null)
		{
			System.out.println("Registro não encontrado"); 
		}
		else
		{
			System.out.println("Registro a ser excluído: ");
			System.out.println("Código Animal: " + animal.getId());
			System.out.println("Nome animal: " + animal.getNomeAnimal()); 
			System.out.println("Tipo animal: " + animal.getTipoAnimal()); 
			System.out.println("Raça animal: " + animal.getRacaAnimal()); 
			System.out.println("Porte animal: " + animal.getPorteAnimal()); 
			System.out.println("Idade animal: " + animal.getIdadeAnimal()); 
			System.out.println("Código dono Animal: " + animal.getCliente().getPessoa().getId());
			System.out.println("Nome dono Animal: " + animal.getCliente().getPessoa().getNome());
			System.out.println("CPF -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getCpf());
			System.out.println("RG -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getRg());
			System.out.println("Rua: " + animal.getCliente().getPessoa().getRua() + " Número:" + animal.getCliente().getPessoa().getNumero() + " Bairro:" + animal.getCliente().getPessoa().getBairro());
			System.out.println("CEP: " + animal.getCliente().getPessoa().getCep());
			System.out.println("Telefone: " + animal.getCliente().getPessoa().getTelefone() + " Celular: " + animal.getCliente().getPessoa().getTelefone());
			System.out.println("Email: " + animal.getCliente().getPessoa().getEmail());
			System.out.println();
			
			animalDao.excluir(animal);
			System.out.println("Registro excluído: "); 
			System.out.println("Código Animal: " + animal.getId());
			System.out.println("Nome animal: " + animal.getNomeAnimal()); 
			System.out.println("Tipo animal: " + animal.getTipoAnimal()); 
			System.out.println("Raça animal: " + animal.getRacaAnimal()); 
			System.out.println("Porte animal: " + animal.getPorteAnimal()); 
			System.out.println("Idade animal: " + animal.getIdadeAnimal()); 
			System.out.println("Código dono Animal: " + animal.getCliente().getPessoa().getId());
			System.out.println("Nome dono Animal: " + animal.getCliente().getPessoa().getNome());
			System.out.println("CPF -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getCpf());
			System.out.println("RG -" + animal.getCliente().getPessoa().getNome() + ": " + animal.getCliente().getPessoa().getRg());
			System.out.println("Rua: " + animal.getCliente().getPessoa().getRua() + " Número:" + animal.getCliente().getPessoa().getNumero() + " Bairro:" + animal.getCliente().getPessoa().getBairro());
			System.out.println("CEP: " + animal.getCliente().getPessoa().getCep());
			System.out.println("Telefone: " + animal.getCliente().getPessoa().getTelefone() + " Celular: " + animal.getCliente().getPessoa().getTelefone());
			System.out.println("Email: " + animal.getCliente().getPessoa().getEmail());
			System.out.println();
		}
	}
	
	
}
