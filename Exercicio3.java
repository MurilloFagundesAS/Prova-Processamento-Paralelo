import java.util.Random;

public class Exercicio3 {
	
	public static int matriz[][];
	public static float media;
	public static int maior;
	public static int menor;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		matriz = new int[100][100];
		
		Random randomico = new Random();
		
		for (int l = 0; l < 100; l++) {
			for (int c = 0; c < 100; c++) {
				matriz[l][c] = randomico.nextInt(5001);
			}
		}
		
		ThreadMedia media1 = new ThreadMedia(matriz, 0, 50, 0, 100);
		ThreadMedia media2 = new ThreadMedia(matriz, 50, 100, 0, 100);
		
		try {
			media1.join();
			media2.join();
		} catch (InterruptedException e) {
			System.out.println("Erro: " + e);
		}
		
		media = (media1.media + media2.media)/2;
		System.out.println("Média dos valores: " + media);
		
		
		ThreadMaiorMedia maior1 = new ThreadMaiorMedia(matriz, 0, 50, 0, 100, media);
		ThreadMaiorMedia maior2 = new ThreadMaiorMedia(matriz, 50, 100, 0, 100, media);
		
		try {
			maior1.join();
			maior2.join();
		}catch (InterruptedException e) {
			System.out.println("Erro: " + e);
		}
		
		maior = maior1.soma + maior2.soma;
		System.out.println("Qtde acima da média: " + maior);
		
		
		ThreadMenorMedia menor1 = new ThreadMenorMedia(matriz, 0, 50, 0, 100, media);
		ThreadMenorMedia menor2 = new ThreadMenorMedia(matriz, 50, 100, 0, 100, media);
		
		try {
			menor1.join();
			menor2.join();
		}catch (InterruptedException e) {
			System.out.println("Erro: " + e);
		}
		
		menor = menor1.soma + menor2.soma;
		System.out.println("Qtde abaixo da média: " + maior);
		
		
//		System.out.println();
//		for (int l = 0; l < 100; l++) {
//			for (int c = 0; c < 100; c++) {
//				System.out.print(matriz[l][c]+"\t");
//			}
//			System.out.println();
//		}
		
		
	}

}
