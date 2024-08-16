package placarTOP;

import java.util.Scanner;

public class Display {

	public static void main(String[] args) {
		PlacarBasico pb = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do time A:");
		String nomeA = sc.nextLine();
		System.out.println("Digite o nome do time B:");
		String nomeB = sc.nextLine();
		System.out.println("Qual placar você prefere? 1 ou 2");
		int pType = sc.nextInt();
		if (pType == 1) {
			pb = new PlacarBasico(nomeA, nomeB);
		}else {
			pb = new PlacarFutebol(nomeA, nomeB);
		}		
		
		int parar = 0;
		while (parar == 0) {
			pb.mostrarPlacar();
			System.out.println();
			System.out.println("O jogo terminou?");
			parar = sc.nextInt();
			if (parar == 1) {
				break;
			}
			System.out.println("Qual time fez gol?");
			int time = sc.nextInt();
			pb.pontuar(time);
		}
		sc.close();
		
	}
	
}
