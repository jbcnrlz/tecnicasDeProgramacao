package sistema;

import biblioteca.Livro;
import biblioteca.LivroDigital;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("INICIALIZAÇÃO DO SISTEMA======");
		System.out.println("Qual o tamanho da sua biblioteca?");
		Scanner sc = new Scanner(System.in);
		int tamBib = sc.nextInt();
		Livro[] bib = new Livro[tamBib];
		int parar=0,posLivro=0;
		while (parar == 0) {
			System.out.println("O que você deseja fazer?");
			System.out.println("1 - Cadastrar novo livro");
			System.out.println("2 - Cadastrar novo livro digital");
			System.out.println("3 - Exibir livro");
			System.out.println("4 - Sair");
			int opt = sc.nextInt();
			sc.nextLine();
			if (opt == 1) {
				if (posLivro >= bib.length) {
					System.out.println("Biblioteca cheia!");
				} else {					
					System.out.println("Digite o autor: ");
					String nome = sc.nextLine();
					System.out.println("Digite o título: ");
					String tit = sc.nextLine();
					System.out.println("Digite o número de páginas:");
					int np = sc.nextInt();
					Livro l = new Livro(nome, tit, np);
					bib[posLivro] = l;
					posLivro += 1;
				}
			}else if(opt == 2) {
				if (posLivro >= bib.length) {
					System.out.println("Biblioteca cheia!");
				} else {					
					System.out.println("Digite o autor: ");
					String nome = sc.nextLine();
					System.out.println("Digite o título: ");
					String tit = sc.nextLine();
					System.out.println("Digite o número de páginas:");
					int np = sc.nextInt();
					System.out.println("Digite o tamanho em MB:");
					float tmb = sc.nextFloat();
					Livro l = new LivroDigital(nome, tit, np, tmb);
					bib[posLivro] = l;
					posLivro += 1;
				}				
			}else if(opt == 3) {
				System.out.println("Todos os livros cadastrados: ");
				for(int i = 0;i < posLivro;i+=1) {
					System.out.println(bib[i]);
				}
			} else {
				parar = 1;
			}
		}
		
		
	}
	
}
