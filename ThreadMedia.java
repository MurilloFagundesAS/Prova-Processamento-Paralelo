
public class ThreadMedia extends Thread{
	
	private int matrizThread[][];
	private int matrizPrimeiraLinha;
	private int matrizUltimaLinha;
	private int matrizPrimeiraColuna;
	private int matrizUltimaColuna;
	private int somaValores;
	private int somaQtde;
	public int media;
	
	
	public ThreadMedia(int matriz[][], int primeiraLinha, int ultimaLinha, int primeiraColuna, int ultimaColuna) {
		matrizThread = matriz;
		matrizPrimeiraLinha = primeiraLinha;
		matrizUltimaLinha = ultimaLinha;
		matrizPrimeiraColuna = primeiraColuna;
		matrizUltimaColuna = ultimaColuna;
		this.start();
	}
	
	
	public void run() {
		
		System.out.println("Thread Iniciou");
		
		somaValores = 0;
		somaQtde = 0;
		for(int l = matrizPrimeiraLinha; l < matrizUltimaLinha; l++) {
			for (int c = matrizPrimeiraColuna; c < matrizUltimaColuna; c++) {
				somaValores += matrizThread[l][c];
				somaQtde +=1;
			}
		}
		
		System.out.println("Fim da Thread");
		
		
		media = somaValores/somaQtde;
		
	}
	
	
}
