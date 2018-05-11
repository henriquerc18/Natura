package natura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PedidosNat{
	
	private long codigoPedido = 0;
	private Double precoTotal = 0.00;
	private String data = "";
	private ClienteNat clientePedido = null;
	
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
	
	public ClienteNat getClientePedido() {
		return clientePedido;
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
	
	public void setClientePedido(ClienteNat clientePedido) {
		this.clientePedido = clientePedido;
	}
	
	public PedidosNat(long codigoPedido, Double precoTotal, String data, ClienteNat cli){
		this.codigoPedido = codigoPedido;
		this.precoTotal = precoTotal;
		this.data = data;
		this.clientePedido = cli;
	}
	
	public PedidosNat(ClienteNat cli){
		try{
			System.out.println("C�digo do Pedido: ");
			this.codigoPedido = scan.nextLong();
			scan.nextLine();
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
		System.out.println("Realizado por: " + this.clientePedido.getNomeCliente());
		System.out.println("C�digo: " + this.codigoPedido);
		System.out.println("Pre�o Total: " + this.precoTotal);
		System.out.println("Data: " + this.data);
	}
}