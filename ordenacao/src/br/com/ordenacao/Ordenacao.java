package br.com.ordenacao;

import java.util.Random;

public class Ordenacao {

	public Ordenacao() {
		super();
	}
										/*ordenação por inserção de elemento
										 * colocar cada elemento da direita para esquerda na posicão correta
										 * */
	public static int[] insertionSort(int[] vetor) {
		int auxA, auxB;
		
		for(int i=1;i<vetor.length;i++) {
										// inicial auxA == vetor[1] , armazenar o valor para inserir na posicao.
			auxA = vetor[i]; 
										//inicial auxB == 0
			auxB = i-1;
										//auxB 0 >= 0 e auxA 1 < posicao 0
			// 8 2 4 9 3 6
			while((auxB >=0 && vetor[auxB] > auxA)) {
				vetor[auxB+1] = vetor[auxB];
										//sair do while; -1 != 0
				auxB = auxB-1;
			}
										//inserir na posicao o valor armazenado
			vetor[auxB + 1] = auxA;
		}return vetor;
		
	}
											/*toma seus elementos dois a dois
											 * se os elementos nao estao em ordem, entao ordene
											 * senao, avance para o próximo par
											 * repita a operação ate que ordene todo vetor*/
	public static int[] bogoSort(int[] vetor) {
		for(int i=0; i<vetor.length;i++) {
										//vai ate penúltimo elemento
			for(int j=0; j<vetor.length-1;j++) {
										/*vetor[j] > vetor[j+1] ?
										8 2 4 9 7	
										*/
				if(vetor[j] > vetor[j+1]) {
					int aux = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = aux;
				}
			}
		}return vetor;
	}
											/*Encontre o maior elemento do vetor e troque com a primeira posição
											 * encontre o segundo menor elemento e troque com a segunda posição
											 * até que vetor esteja ordenado*/
	public static void selectSort(int[] vetor) {
		for(int i=0; i<vetor.length;i++) {
										/*se a posicao 1 estiver ordenada passa para prossima posicão 
										até está ordenado.
										*/
			for(int j = i+1;j<vetor.length;j++) {
										/*vetor[i+1] < vetor[i] ?
										8 2 4 9 7	
										*/
				if(vetor[j] < vetor[i]) {
					int auxiliar = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = auxiliar;
				}
			}
		}
	}
								//4 6 7 3 5 1 2 8
								/*Dividir vetor ao meio
								 * recursivamente ordenar a primeira metade
								 * recursivamente ordenar a segunda metade
								 * Intercale os dois e gerar um vetor ordenado
								 */
	public static void mergeSort(int[] vetorUm, int[] vetorDois, int inicio, int fim) {
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(vetorUm, vetorDois, inicio, meio);
			mergeSort(vetorUm, vetorDois, meio+1, fim);
			intercalar(vetorUm, vetorDois, inicio, meio, fim);
		}
	}
	public static void intercalar(int[] vetorUm, int[] vetorDois, int inicio, int meio, int fim ) {
		for(int k = inicio; k <=fim; k++) {
			vetorDois[k] = vetorUm[k];
		}
		int idInicioMeio = inicio;
		int idMeioFim = meio + 1;
		
		for(int k = inicio; k <= fim; k++) {
			if(idInicioMeio > meio){ 
				vetorUm[k] = vetorDois[idMeioFim++];
			}else if(idMeioFim > fim) {
				vetorUm[k] = vetorDois[idInicioMeio++];
			}else if(vetorDois[idInicioMeio] < vetorDois[idInicioMeio]) {
				vetorUm[k] = vetorDois[idInicioMeio++];
			}else
				vetorUm[k] = vetorDois[idMeioFim++];
			
		}
	}
											//popular o vetor com numeros randomico
	public static int[] aleatorio(int[] vetor, int randomInt) {
		Random random = new Random();

		for(int i = 0; i<vetor.length;i++) {
			vetor[i] = random.nextInt(randomInt);
		}
		return vetor;
	}
	
}
