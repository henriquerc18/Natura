package natura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Estoque extends Produtos{
	
	private int qtdEstoque = 0;
	
	private Scanner scan = Natura.scan;
	
	public int getQtdEstoque(){
		return qtdEstoque;
	}
	
	public void setQtdEstoque(int qtdEstoque){
		this.qtdEstoque = qtdEstoque;
	}
	
	public Estoque(int paginaProd, long codigoProd, String descricaoProd, Double precoProd, int qtdEstoque){
		super(paginaProd, codigoProd, descricaoProd, precoProd);
		this.qtdEstoque = qtdEstoque;
	}
	
	public Estoque(){
		super();
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
		super.updateProdutos();
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
		super.mostraProduto();
		System.out.println("Quantidade em Estoque: " + this.qtdEstoque);
	}	
}