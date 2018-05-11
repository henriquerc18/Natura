package natura;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ClienteNat{
	
	private String nomeCliente = "";
	private String enderecoCliente = "";
	private String emailCliente = "";
	private long telefoneCliente = 0;
	private ArrayList<PedidosNat> listaPedidos = new ArrayList<PedidosNat>();
	
	private int indice = 0;
	
	private Scanner scan = Natura.scan;
	
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
	
	public List<PedidosNat> getListaPedidos() {
		return listaPedidos;
	}
		
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
	
	public void setListaPedidos(ArrayList<PedidosNat> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	public ClienteNat(String nomeCliente, String enderecoCliente, String emailCliente, long telefoneCliente){
		this.nomeCliente = nomeCliente;
		this.enderecoCliente = enderecoCliente;
		this.emailCliente = emailCliente;
		this.telefoneCliente = telefoneCliente;
	}
		
	public ClienteNat(){
		System.out.println("Nome: ");
		this.nomeCliente = scan.nextLine();
		
		System.out.println("Endere�o: ");
		this.enderecoCliente = scan.nextLine();
		
		System.out.println("Email: ");
		this.emailCliente = scan.nextLine();
		
		try{
			System.out.println("Telefone: ");
			this.telefoneCliente = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente n�meros!");
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
		
		System.out.println("Novo Endere�o: ");
		this.enderecoCliente = scan.nextLine();
		
		System.out.println("Novo Email: ");
		this.emailCliente = scan.nextLine();
		
		try{
			System.out.println("Novo Telefone: ");
			this.telefoneCliente = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente n�meros!");
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
		System.out.println("Endere�o: " + this.enderecoCliente);
		System.out.println("Email: " + this.emailCliente);
		System.out.println("Telefone: " + this.telefoneCliente);
	}
}