package locadora;

import java.util.LinkedList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		LinkedList<Montadora> dataMontadora = new LinkedList<>();
		int continuar = 1;
		while(continuar != 0) {
			continuar = Principal.gerarMenu("principal");
			if (continuar == 1) {
				continuar = Principal.gerarMenu("montadora");
				if (continuar == 1) {
					Montadora m = Principal.cadastrarMontadora();
					dataMontadora.add(m);
				} else if (continuar == 2) {
					System.out.println("Digite o nome da montadora que deseja buscar: ");
					Scanner sc = new Scanner(System.in);
					String nomeM = sc.nextLine();
					Montadora m = Principal.buscarMontadora(nomeM, dataMontadora);
					System.out.println("Dados da montadora: ");
					System.out.println(m);
				}
			}
		}
	}

	public static Montadora buscarMontadora(String nome, LinkedList<Montadora> monts) {
		Montadora mt = null;
		for(int i = 0;i < monts.size();i+=1) {
			if (monts.get(i).getNome().equals(nome)) {
				mt = monts.get(i); 
				break;
			}
		}
		return mt;
	}
	
	public static Montadora cadastrarMontadora() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome da montadora: ");
		String nome = sc.nextLine();
		System.out.println("Digite o país da montadora: ");
		String pais = sc.nextLine();
		Montadora m = new Montadora(nome, pais);
		return m;
	}
	
	public static int gerarMenu(String op) {
		System.out.println("Digite a opção que você deseja: ");
		if (op.equals("principal")) {
			System.out.println("1 - Montadora");
			System.out.println("2 - Carro");
		}else if (op.equals("montadora")) {
			System.out.println("1 - Cadastrar montadora");
			System.out.println("2 - Buscar montadora");			
		} 
		System.out.println("0 - Sair");
		Scanner sc = new Scanner(System.in);
		int opt = sc.nextInt();		
		return opt;
	}
	
}