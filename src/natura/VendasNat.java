package natura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VendasNat{
	
	private long numNotaFisc = 0;
	private int quantidade = 0;
	private Double precoTotal = 0.00;
	private String dataVenda = "";
	
	private int indice = 0;
	
	private Scanner scan = Natura.scan;
	
	public long getNumNotaFisc(){
		return numNotaFisc;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public Double getPrecoTotal(){
		return precoTotal;
	}
	
	public String dataVenda(){
		return dataVenda;
	}
	
	public int getIndice(){
		return indice;
	}
	
	public void setNumNotaFisc(long numNotaFisc){
		this.numNotaFisc = numNotaFisc;
	}
	
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	
	public void setPrecoTotal(Double precoTotal){
		this.precoTotal = precoTotal;
	}
	
	public void setDataVenda(String dataVenda){
		this.dataVenda = dataVenda;
	}
	
	public void setIndice(int indice){
		this.indice = indice;
	}
	
	public VendasNat(long numNotaFisc, int quantidade, Double precoTotal, String dataVenda){
		this.numNotaFisc = numNotaFisc;
		this.quantidade = quantidade;
		this.precoTotal = precoTotal;
		this.dataVenda = dataVenda;
	}
	
	public VendasNat(){
		try{
			System.out.println("Nº da Nota Fiscal: ");
			this.numNotaFisc = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Quantidade: ");
			this.quantidade = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Preço Total: ");
			this.precoTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		System.out.println("Data da Venda: ");
		this.dataVenda = scan.nextLine();
	}
	
	public void updateVendas(){
		try{
			System.out.println("Novo Nº da Nota Fiscal: ");
			this.numNotaFisc = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Nova Quantidade: ");
			this.quantidade = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Novo Preço Total: ");
			this.precoTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		System.out.println("Nova Data da Venda: ");
		this.dataVenda = scan.nextLine();
	}
	
	public boolean update(){
		Natura.listaVendas.set(this.getIndice(), this);
		return true;
	}
	
	public boolean save(){
		Natura.listaVendas.add(this);
		return true;
	}
	
	public void mostraVenda(){
		System.out.println("Venda:");
		System.out.println("Nº da Nota Fiscal: " + this.numNotaFisc);
		System.out.println("Quantidade: " + this.quantidade);
		System.out.println("Preço Total: " + this.precoTotal);
		System.out.println("Data da Venda: " + this.dataVenda);
	}
}