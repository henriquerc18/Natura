package natura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EstoqueNat{
	
	private long codigoProd = 0;
	private String descricaoProd = "";
	private Double precoProd = 0.00;
	private int qtdEstoque = 0;
	
	private int indice = 0;
	
	private Scanner scan = Natura.scan;
	
	public long getCodigoProd(){
		return codigoProd;
	}
	
	public String getDescricaoProd(){
		return descricaoProd;
	}
	
	public Double getPrecoProd(){
		return precoProd;
	}
	
	public int getQtdEstoque(){
		return qtdEstoque;
	}
	
	public int getIndice(){
		return indice;
	}
	
	public void setCodigoProd(long codigoProd){
		this.codigoProd = codigoProd;
	}
	
	public void setDescricaoProd(String descricaoProd){
		this.descricaoProd = descricaoProd;
	}
	
	public void setPrecoProd(Double precoProd){
		this.precoProd = precoProd;
	}
	
	public void setQtdEstoque(int qtdEstoque){
		this.qtdEstoque = qtdEstoque;
	}
	
	public void setIndice(int indice){
		this.indice = indice;
	}
	
	public EstoqueNat(long codigoProd, String descricaoProd, Double precoProd, int qtdEstoque){
		this.codigoProd = codigoProd;
		this.descricaoProd = descricaoProd;
		this.precoProd = precoProd;
		this.qtdEstoque = qtdEstoque;
	}
	
	public EstoqueNat(){
		try{
			System.out.println("Código do Produto: ");
			this.codigoProd = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		System.out.println("Descrição do Produto: ");
		this.descricaoProd = scan.nextLine();
		
		try{
			System.out.println("Preço do Produto: ");
			this.precoProd = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Quantidade em Estoque: ");
			this.qtdEstoque = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
	}
	
	public void updateEstoque(){
		try{
			System.out.println("Novo Código do Produto: ");
			this.codigoProd = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		System.out.println("Nova Descrição do Produto: ");
		this.descricaoProd = scan.nextLine();
		
		try{
			System.out.println("Preço do Produto: ");
			this.precoProd = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Nova Quantidade em Estoque: ");
			this.qtdEstoque = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
	}
	
	public boolean update(){
		Natura.listaEstoque.set(this.getIndice(), this);
		return true;
	}
	
	public boolean save(){
		Natura.listaEstoque.add(this);
		return true;
	}
	
	public void mostraEstoque(){
		System.out.println("Preço:");
		System.out.println("Código: " + this.qtdEstoque);
		System.out.println("Descrição: " + this.qtdEstoque);
		System.out.println("Preço: " + this.qtdEstoque);
		System.out.println("Quantidade em Estoque: " + this.qtdEstoque);
	}	
}