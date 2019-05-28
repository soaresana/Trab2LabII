package lab.trabalhoII;

public class Ordenacao{

	 public static int[] bubbleSort(int[] vetor) {
	        long tempoinicial = System.currentTimeMillis();
	        for (int i = vetor.length; i >= 1; i--) {
	            for (int j = 1; j < i; j++) {
	                if (vetor[j - 1] > vetor[j]) {
	                    int aux = vetor[j];
	                    vetor[j] = vetor[j - 1];
	                    vetor[j - 1] = aux;
	                }
	            }
	        }
	        long tempofinal = System.currentTimeMillis();
	        long tempototal = tempofinal - tempoinicial;
	        System.out.println("Tempo de Processamento de BubbleSort: " + tempototal + "ms");
	        return vetor;
	    }
	
	public static int[] insercao(int[] vetor) {
		 long tempoinicial = System.currentTimeMillis();
	        for (int i = 0; i < vetor.length; i++) {
	            int atual = vetor[i];
	            int j = i - 1;
	            while (j >= 0 && vetor[j] >= atual) {
	                vetor[j + 1] = vetor[j];
	                j--;
	            }
	            vetor[j + 1] = atual;;
	        }
	        long tempofinal = System.currentTimeMillis();
	        long tempototal = tempofinal - tempoinicial;
	        System.out.println("Tempo de Processamento de inserção: " + tempototal + "ms");
	        return vetor;
    }
	
	public static int[] selecao(int[] vetor) {
		 long tempoinicial = System.currentTimeMillis();
	        for (int i = 0; i < vetor.length; i++) {
	            int indiceMinimo = i;
	            for (int j = i + 1; j < vetor.length; j++) {
	                if (vetor[j] < vetor[indiceMinimo]) {
	                    indiceMinimo = j;
	                }
	            }
	 
	            int tmp = vetor[indiceMinimo];
	            vetor[indiceMinimo] = vetor[i];
	            vetor[i] = tmp;
	        }
	        long tempofinal = System.currentTimeMillis();
	        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de Processamento de Selecao: " + tempototal + "ms");
        return vetor;
    }
	
	public static int[] mergeSort(int[] array) {
        long tempoinicial = System.currentTimeMillis();
        array = MergeSort.sort(array);
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de Processamento de MergeSort: " + tempototal + "ms");
        return array;
    }
	
	//Aqui vai entrar o ShellSort
	
//	public int[] shellSort(int[] vetor, int size) {
//	    int i , j , value;
//	    int gap = 1;
//	    while(gap < size) {
//	        gap = 3*gap+1;
//	    }
//	    while ( gap > 1) {
//	        gap /= 3;
//	        for(i = gap; i < size; i++) {
//	            value = vet[i];
//	            j = i - gap;
//	            while (j >= 0 && value < vet[j]) {
//	                vet [j + gap] = vet[j];
//	                j -= gap;
//	            }
//	            vet [j + gap] = value;
//	        }
//	    }
//	}
	
	
	 public static int[] quickSort(int[] array) {
	        long tempoinicial = System.currentTimeMillis();
	        array = QuickSort.quicksort(array, 0, (array.length - 1));
	        long tempofinal = System.currentTimeMillis();
	        long tempototal = tempofinal - tempoinicial;
	        System.out.println("Tempo de Processamento de QuickSort: " + tempototal + "ms");
	        return array;
	    }
	
	
	public static class QuickSort {
		  
	    public static int[] quicksort(int vet[], int ini, int fim) {
	 
	        int meio;
	 
	        if (ini < fim) {
	 
	            meio = partition(vet, ini, fim);
	 
	            quicksort(vet, ini, meio);
	 
	            quicksort(vet, meio + 1, fim);
	 
	        }
	        
	        return vet;
	    }
	 
	    public static int partition(int vet[], int ini, int fim) {
	 
	        int pivo, topo, i;
	 
	        pivo = vet[ini];
	 
	        topo = ini;
	 
	        
	        for (i = ini + 1; i <= fim; i++) {
	 
	            if (vet[i] < pivo) {
	 
	                vet[topo] = vet[i];
	 
	                vet[i] = vet[topo + 1];
	 
	                topo++;
	            }
	        }
	 
	        vet[topo] = pivo;
	 
	        return topo;
	    }
	}
	
	public static class MergeSort {
		 
	    public static int[] sort(int[] array) {
	       
	        if (array.length <= 1) {
	           
	            return array;
	        }
	        int meio = array.length / 2;
	        int[] dir = array.length % 2 == 0 ? new int[meio] : new int[meio + 1];
	        int[] esq = new int[meio];
	 
	        int[] aux = new int[array.length];
	 
	        for (int i = 0; i < meio; i++) {
	            esq[i] = array[i];
	        }
	 
	        int auxIndex = 0;
	        for (int i = meio; i < array.length; i++) {
	            dir[auxIndex] = array[i];
	            auxIndex++;
	        }
	 
	        esq = sort(esq);
	        dir = sort(dir);
	        
	        aux = mergesort(esq, dir);
	 
	        return aux;
	    }
	 
	    static int[] mergesort(int[] esq, int[] dir) {
	        int[] aux = new int[esq.length + dir.length];
	 
	        int indexDir = 0, indexEsq = 0, indexAux = 0;
	 
	        while (indexEsq < esq.length || indexDir < dir.length) {
	            if (indexEsq < esq.length && indexDir < dir.length) {
	                if (esq[indexEsq] <= dir[indexDir]) {
	                    aux[indexAux] = esq[indexEsq];
	                    indexAux++;
	                    indexEsq++;
	                } else {
	                    aux[indexAux] = dir[indexDir];
	                    indexAux++;
	                    indexDir++;
	                }
	            } else if (indexEsq < esq.length) {
	                aux[indexAux] = esq[indexEsq];
	                indexAux++;
	                indexEsq++;
	            } else if (indexDir < dir.length) {
	                aux[indexAux] = dir[indexDir];
	                indexAux++;
	                indexDir++;
	            }
	        }
	        return aux;
	    }
	}
}
	