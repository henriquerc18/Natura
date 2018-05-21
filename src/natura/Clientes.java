package natura;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Clientes{
	
	//Atributos
	private String nomeCliente = "";
	private String enderecoCliente = "";
	private String emailCliente = "";
	private long telefoneCliente = 0;
	private int indice = 0;
	
	//Cliente - Pedido
	private ArrayList<Pedidos> listaPedidos = new ArrayList<Pedidos>();
	
	//Cliente - Venda
	private ArrayList<Vendas> listaVendas = new ArrayList<Vendas>();
	
	private Scanner scan = Natura.scan;
	
	//Gets
	public String getNomeCliente(){
		return nomeCliente;
	}
	
	public String getEnderecoCliente(){
		return enderecoCliente;
	}
		
	public String getEmailCliente(){
		return emailCliente;
	}
		
	public long getTelefoneCliente(){
		return telefoneCliente;
	}
	
	public int getIndice(){
		return indice;
	}
	
	//Get Cliente - Pedido
	public List<Pedidos> getListaPedidos() {
		return listaPedidos;
	}
	
	//Get Cliente - Venda
	public List<Vendas> getListaVendas(){
		return listaVendas;
	}
	
	//Sets
	public void setNomeCliente(String nomeCliente){
		this.nomeCliente = nomeCliente;
	}
		
	public void setEnderecoCliente(String enderecoCliente){
		this.enderecoCliente = enderecoCliente;
	}
		
	public void setEmailCliente(String emailCliente){
		this.emailCliente = emailCliente;
	}
		
	public void setTelefoneCliente(long telefoneCliente){
		this.telefoneCliente = telefoneCliente;
	}
	
	public void setIndice(int indice){
		this.indice = indice;
	}
	
	//Set Cliente - Pedido
	public void setListaPedidos(ArrayList<Pedidos> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	//Set Cliente - Venda
	public void setListaVendas(ArrayList<Vendas> listaVendas) {
		this.listaVendas = listaVendas;
	}
	
	public Clientes(String nomeCliente, String enderecoCliente, String emailCliente, long telefoneCliente){
		this.nomeCliente = nomeCliente;
		this.enderecoCliente = enderecoCliente;
		this.emailCliente = emailCliente;
		this.telefoneCliente = telefoneCliente;
	}
		
	public Clientes(){
		System.out.println("Nome: ");
		this.nomeCliente = scan.nextLine();
		
		System.out.println("Endereço: ");
		this.enderecoCliente = scan.nextLine();
		
		System.out.println("Email: ");
		this.emailCliente = scan.nextLine();
		
		try{
			System.out.println("Telefone: ");
			this.telefoneCliente = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
	}
	
	public boolean save(){
		Natura.listaClientes.add(this);
		return true;
	}
	
	public void updateCliente(){
		System.out.println("Novo Nome: ");
		this.nomeCliente = scan.nextLine();
		
		System.out.println("Novo Endereço: ");
		this.enderecoCliente = scan.nextLine();
		
		System.out.println("Novo Email: ");
		this.emailCliente = scan.nextLine();
		
		try{
			System.out.println("Novo Telefone: ");
			this.telefoneCliente = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
	}
    
    public boolean update(){
    	Natura.listaClientes.set(this.getIndice(), this);
    	return true;
    }
	
	public void mostraCliente(){
		System.out.println("Cliente:");
		System.out.println("Nome: " + this.nomeCliente);
		System.out.println("Endereço: " + this.enderecoCliente);
		System.out.println("Email: " + this.emailCliente);
		System.out.println("Telefone: " + this.telefoneCliente);
	}
}