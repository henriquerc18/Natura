package natura;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Pedidos{
	
	//Atributos
	private long codigoPedido = 0;
	private Double precoTotal = 0.00;
	private String data = "";
	private int indice = 0;
	
	//Cliente - Pedido
	private Clientes clientePedido = null;
	
	//Pedido - Produto
	private ArrayList<Produtos> listaProdutos = new ArrayList<Produtos>();
	
	private Scanner scan = Natura.scan;
	
	//Gets
	public long getCodigoPedido(){
		return codigoPedido;
	}
	
	public Double getPrecoTotal(){
		return precoTotal;
	}
	
	public String getData(){
		return data;
	}
	
	public int getIndice(){
		return indice;
	}
	
	//Get Cliente - Pedido
	public Clientes getClientePedido() {
		return clientePedido;
	}
	
	//Get Pedido - Produto
	public List<Produtos> getListaProdutos() {
		return listaProdutos;
	}
	
	//Sets
	public void setCodigoPedido(long codigoPedido){
		this.codigoPedido = codigoPedido;
	}
	
	public void setPrecoTotal(Double precoTotal){
		this.precoTotal = precoTotal;
	}

	public void setData(String data){
		this.data = data;
	}
	
	public void setIndice(int indice){
		this.indice = indice;
	}
	
	//Set Cliente - Pedido
	public void setClientePedido(Clientes clientePedido) {
		this.clientePedido = clientePedido;
	}
	
	//Set Pedido - Produto
	public void setListaProdutos(ArrayList<Produtos> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public Pedidos(long codigoPedido, Double precoTotal, String data, Clientes cli){
		this.codigoPedido = codigoPedido;
		this.precoTotal = precoTotal;
		this.data = data;
		this.clientePedido = cli; //Set Cliente - Pedido
	}
	
	public Pedidos(Clientes cli, Produtos prod){
		try{
			System.out.println("Código do Pedido: ");
			this.codigoPedido = scan.nextLong();
			scan.nextLine();
			clientePedido = cli;
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();			
		}
		
		try{
			System.out.println("Preço Total do Pedido: ");
			this.precoTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		System.out.println("Data do Pedido: ");
		this.data = scan.nextLine();
	}
	
	public boolean save(){
		Natura.listaPedidos.add(this);
		return true;
	}
	
	public void updatePedidos(){
		try{
			System.out.println("Novo Código do Pedido: ");
			this.codigoPedido = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();			
		}
		
		try{
			System.out.println("Novo Preço Total do Pedido: ");
			this.precoTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		System.out.println("Nova Data do Pedido: ");
		this.data = scan.nextLine();
	}
    
    public boolean update(){
    	Natura.listaPedidos.set(this.getIndice(), this);
    	return true;
    }
	
	public void mostraPedido(){
		System.out.println("Pedido:");
		System.out.println("Realizado por: " + clientePedido.getNomeCliente());
		System.out.println("Código: " + this.codigoPedido);
		System.out.println("Preço Total: " + this.precoTotal);
		System.out.println("Data: " + this.data);
	}
}