package controller;
import com.deniza.utils.ListaEncadeadaInt.ListaEncadeadaInt;

/*
 * Considere listas implementadas por encadeamento simples, então pede-se para implementar funções que:
 * a. Concatenar/intercalar duas listas;
 * b. Dividir uma lista em várias;
 * c. Copiar uma lista;
 * d. Ordenar (sort) uma lista por ordem crescente/decrescente.
 */


public class ManipulaListaSimples {
	
	public ManipulaListaSimples() {
		super();
	}
	
	public void insere(int numero, ListaEncadeadaInt l) {
		l.insertAtBack(numero);
	}
	
	public ListaEncadeadaInt concatena(
			ListaEncadeadaInt l1, ListaEncadeadaInt l2) throws Exception {
		int tamanhoL2 = l2.size();
		int posicao = 0;
		while(posicao < tamanhoL2) {
			l1.insertAtBack(l2.getValue(posicao));
			posicao++;
		}
		return l1;
	}
	
	public ListaEncadeadaInt intercala(
			ListaEncadeadaInt l1, ListaEncadeadaInt l2) throws Exception {
		ListaEncadeadaInt listaRes = new ListaEncadeadaInt();
		
		int posicao = 0;
		int tamanho = 0;
		
		if(l1.size() >= l2.size()) {
			tamanho = l1.size();
		} else {
			tamanho = l2.size();
		}
		
		while(posicao < tamanho) {
			if(!l1.isEmpty()) {
				listaRes.insertAtBack(l1.getValue(posicao));
			}
			if(!l2.isEmpty()) {
				listaRes.insertAtBack(l2.getValue(posicao));
			}
			posicao++;
		}
		return listaRes;
	}
	
	public ListaEncadeadaInt[] divide(
			ListaEncadeadaInt l, int qtdListas) throws Exception {
		ListaEncadeadaInt listaRes[] = new ListaEncadeadaInt[qtdListas];
		int posicao = l.size() - 1;
		int qtdNumeros = (posicao + 1) / qtdListas;
		int resto = (posicao + 1) % qtdListas;
		
		for(int k = 0; k < qtdListas; k++) {
			listaRes[k] = new ListaEncadeadaInt();
			for(int j = 1; j <= qtdNumeros; j++) {
				if(posicao >= 0) {
					listaRes[k].insertAtFront(l.getValue(posicao));
					if(resto > 0) {
						posicao--;
						listaRes[k].insertAtFront(l.getValue(posicao));
						resto--;
					}
					posicao--;
				}
			}
		}
		return listaRes;
	}
	
	public ListaEncadeadaInt copia(ListaEncadeadaInt l) throws Exception {
		ListaEncadeadaInt auxiliar = new ListaEncadeadaInt();
		
		for(int i = 0; i < l.size(); i++) {
			auxiliar.insertPosition(i, l.getValue(i));
		}
		return auxiliar;
	}
	
	public ListaEncadeadaInt ordenaCrescente(ListaEncadeadaInt l) throws Exception {
		int tamanho = l.size();
		
		for(int i = 0; i < tamanho; i++) {
			for(int j = 0 ; j < tamanho - 1 ; j++) {
				if(l.getValue(j) > l.getValue(j + 1)) {
					int aux = l.getValue(j);
					l.removePosition(j);
					l.insertPosition(j, l.getValue(j));
					l.removePosition(j + 1);
					l.insertPosition(j + 1, aux);
				}
			}
		}
		return l;
	}
	
	public ListaEncadeadaInt ordenaDecrescente(ListaEncadeadaInt l) throws Exception {
		int tamanho = l.size();
		
		for(int i = 0; i < tamanho; i++) {
			for(int j = 0 ; j < tamanho - 1 ; j++) {
				if(l.getValue(j) < l.getValue(j + 1)) {
					int aux = l.getValue(j);
					l.removePosition(j);
					l.insertPosition(j, l.getValue(j));
					l.removePosition(j + 1);
					l.insertPosition(j + 1, aux);
				}
			}
		}
		return l;
	}

}
