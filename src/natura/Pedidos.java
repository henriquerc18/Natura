package natura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pedidos{
	
	private long codigoPedido = 0;
	private Double precoTotal = 0.00;
	private String data = "";
	private Cliente clientePedido = null;
	private Produtos produtoPedido = null;
	
	private int indice = 0;
	
	private Scanner scan = Natura.scan;
	
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
	
	public Cliente getClientePedido() {
		return clientePedido;
	}
	
	public Produtos getProdutoPedido(){
		return produtoPedido;
	}
	
	public void setCodigoPedido(long codigoPedido){
		this.codigoPedido = codigoPedido;
	}
	
	public void setprecoTotal(Double precoTotal){
		this.precoTotal = precoTotal;
	}

	public void setData(String data){
		this.data = data;
	}
	
	public void setIndice(int indice){
		this.indice = indice;
	}
	
	public void setClientePedido(Cliente clientePedido) {
		this.clientePedido = clientePedido;
	}
	
	public void setProdutoPedido(Produtos produtoPedido){
		this.produtoPedido = produtoPedido;
	}
	
	public Pedidos(long codigoPedido, Double precoTotal, String data, Cliente cli, Produtos prod){
		this.codigoPedido = codigoPedido;
		this.precoTotal = precoTotal;
		this.data = data;
		this.clientePedido = cli;
		this.produtoPedido = prod;
	}
	
	public Pedidos(Cliente cli, Produtos prod){
		try{
			System.out.println("C�digo do Pedido: ");
			this.codigoPedido = scan.nextLong();
			scan.nextLine();
			clientePedido = cli;
			produtoPedido = prod;
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente n�meros!");
			scan.nextLine();			
		}
		
		try{
			System.out.println("Pre�o Total do Pedido: ");
			this.precoTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente n�meros!");
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
			System.out.println("Novo C�digo do Pedido: ");
			this.codigoPedido = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente n�meros!");
			scan.nextLine();			
		}
		
		try{
			System.out.println("Novo Pre�o Total do Pedido: ");
			this.precoTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente n�meros!");
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
		System.out.println("C�digo: " + this.codigoPedido);
		System.out.println("Pre�o Total: " + this.precoTotal);
		System.out.println("Data: " + this.data);
	}
}