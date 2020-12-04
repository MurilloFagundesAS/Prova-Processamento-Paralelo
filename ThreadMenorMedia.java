
public class ThreadMenorMedia extends Thread{
	
	private int matrizThread[][];
	private int matrizPrimeiraLinha;
	private int matrizUltimaLinha;
	private int matrizPrimeiraColuna;
	private int matrizUltimaColuna;
	private float mediaThread;
	public int soma;
	
	
	public ThreadMenorMedia(int matriz[][], int primeiraLinha, int ultimaLinha, int primeiraColuna, int ultimaColuna, float media) {
		matrizThread = matriz;
		matrizPrimeiraLinha = primeiraLinha;
		matrizUltimaLinha = ultimaLinha;
		matrizPrimeiraColuna = primeiraColuna;
		matrizUltimaColuna = ultimaColuna;
		mediaThread = media;
		this.start();
	}
	
	
	public void run() {
		
		System.out.println("Thread Iniciou");
		
		soma = 0;
		for(int l = matrizPrimeiraLinha; l < matrizUltimaLinha; l++) {
			for (int c = matrizPrimeiraColuna; c < matrizUltimaColuna; c++) {
				if (matrizThread[l][c] < mediaThread) {
					soma += 1;
				}
			}
		}
		
		System.out.println("Fim da Thread");
		
	}
	
	
}