package Programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Pedido;

public class Lanchonete {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos produtos serão adicionados ao cardápio? ");
		int n = sc.nextInt();
		System.out.println();
		
		List<Pedido> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			System.out.print("Informe o código do produto: ");
			int id = sc.nextInt();
			while(hasId(list, id)) {
				System.out.println();
				System.out.println("Código já existente. Tente novamente! ");
				System.out.print("Informe o código do produto: ");
				id = sc.nextInt();
			}
			System.out.print("Produto: ");
			sc.nextLine();
			String product = sc.nextLine();
			System.out.print("Preço: ");
			double price = sc.nextDouble();
			System.out.println();
			
			Pedido pedido = new Pedido(id, product, price);
			list.add(pedido);
		}
		
		for(Pedido pedido : list) {
			System.out.println(pedido);
		}
				
		double sum = 0.0;
		char resp;
		
		List<Pedido> result = new ArrayList<>();
		
		do {
			System.out.println();
			System.out.print("Digite o código do pedido: ");
			int IdPedido = sc.nextInt();
			Integer pos = position(list, IdPedido);
			while(pos == null) {
				System.out.println();
				System.out.println("Código inválido! Digite um código válido: ");
				System.out.print("Digite o código do pedido: ");
				IdPedido = sc.nextInt();
				pos = position(list, IdPedido);
			}
					
			System.out.println();
			
			result.add(list.get(pos));
			
			sum += list.get(pos).getPrice();
					
			System.out.printf("Total parcial: R$ %.2f", sum);
			System.out.println();
			System.out.print("Encerrar a conta? (s/n) ");
				resp = sc.next().charAt(0);
			
		}
		while(resp != 's');
		
		System.out.println();
		System.out.println("------------------ C O N T A ------------------");
		System.out.println();
		for(Pedido p : result) {
			System.out.println(p);
		}
		
		System.out.println();
		System.out.printf("Total: R$ %.2f%n%nObrigado e volte sempre!", sum);
		
		sc.close();
	}
	
	public static Integer position(List<Pedido> list, int id) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Pedido> list, int id) {
		Pedido pedido = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return pedido != null;
	}
	
}
