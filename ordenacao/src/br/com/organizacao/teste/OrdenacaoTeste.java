package br.com.organizacao.teste;

import br.com.ordenacao.Ordenacao;

public class OrdenacaoTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vetor = new int[6];
		int[] vetorAux = new int[vetor.length];
		Ordenacao ordenacao = new Ordenacao();
		//preencher valor
		ordenacao.aleatorio(vetor, 100);
		//organizar o vetor do menor para maior
		ordenacao.mergeSort(vetor, vetorAux, 0, vetor.length-1);;
		//impressao do vetor
		for(int i=0; i<vetor.length;i++) {
			System.out.print("[" + vetor[i] + "] ");
		}
	}

}
