package lab.trabalhoII;

import java.util.Random;

import javax.swing.JOptionPane;

public class Menus {
	
	static int op;
	static int[] vetorA = new int[25000];
	static int[] vetorB = new int[25100];
	static int[] vetorC = new int[25100];
	
	{
	int tam = 25100;
	Random rand = new Random();
	
	
	for(int i = 0; i < tam; i++){
		vetorA[i] = i+1;
		vetorB[i] = tam-i;
		vetorC[i] = rand.nextInt(10000000);
	}
	
	}
	
public static void menu() {
		
		do {
		op = Integer.parseInt(JOptionPane.showInputDialog(null,"" + 
		"Escolha uma das opções abaixo\n"+
		"1) Árvores Binárias\n"+
		"2) Métodos de Ordenação\n"+
		"0) Sair\n","Trabalho de Laboratório de Computação II ",JOptionPane.QUESTION_MESSAGE ));

		
		switch(op) {
		
		case 1:
			menuArvore();
			break;
		
		case 2: 
			menuInsercao();
		case 0:
			JOptionPane.showMessageDialog(null,"Encerrando Programa");
			break;
		default	:
			JOptionPane.showMessageDialog(null,"Opção Inválida");
				break;
		}
		}
		while(op != 0);
		
		}

	public static void menuArvore() {

		do {
		op = Integer.parseInt(JOptionPane.showInputDialog(null,"" + 
		"Escolha uma das opções abaixo\n"+
		"1)ABP\n"+
		"2)AVL\n"+
		"3)Voltar Menu Anterior\n"+
		"0) Sair",JOptionPane.QUESTION_MESSAGE));
		
		switch(op) {
		
		case 1:{
			int busca = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira valor de busca:",JOptionPane.QUESTION_MESSAGE));
			Arvores.abp(vetorA,busca);
			//Arvores.abp(vetorB,busca);
			//Arvores.abp(vetorC,busca);
		}
			break;
		
		case 2: {
			int busca = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira valor de busca:",JOptionPane.QUESTION_MESSAGE));
			Arvores.Avl(vetorA,busca);
			Arvores.Avl(vetorB,busca);
			Arvores.Avl(vetorC,busca);
		}
			break;
		
		case 3:
			menu();
			break;
		
		case 0:
			JOptionPane.showMessageDialog(null,"Encerrando Programa");
			break;
			
		default:
			JOptionPane.showMessageDialog(null,"Opção Inválida");
			break;	
		}	
	}
		while(op!=0);
		
	}
	

	public static void menuInsercao() {
		do {
			 op = Integer.parseInt(JOptionPane.showInputDialog(null,""+
			"Escolha uma das opções abaixo\n"+
			"1)BubbleSort Tradicional\n"+
			"2)BubbleSort Adap. 1\n"+
			"3)BubbleSort Adap. 2\n"+
			"4)BubbleSort Hibrido\n"+
			"5)Inserção\n"+
			"6) Seleção\n"+
			"7)MergeSort\n"+
			"8)ShellSort\n"+
			"9)QuickSort\n"+
			"10)Voltar ao Menu Anterior\n"+
			"0)Sair", JOptionPane.QUESTION_MESSAGE));
			 
			 switch (op) {
			 case 1:
				 Ordenacao.bubbleSort(vetorA);
				 Ordenacao.bubbleSort(vetorB);
				 Ordenacao.bubbleSort(vetorC);
				 break;
				 
			 case 2:
				 JOptionPane.showMessageDialog(null, "Ainda não existe");
				 break;
			
			 case 3:
				 JOptionPane.showMessageDialog(null, "Ainda não existe");
				 break;
				 
			 case 4:
				 JOptionPane.showMessageDialog(null, "Ainda não existe");
				 break;
				 
			 case 5:
				 Ordenacao.insercao(vetorA);
				 Ordenacao.insercao(vetorB);
				 Ordenacao.insercao(vetorC);
				 break;
				 
			 case 6:
				 Ordenacao.selecao(vetorA);
				 Ordenacao.selecao(vetorB);
				 Ordenacao.selecao(vetorC);
				 break;
				 
			 case 7:
				 Ordenacao.mergeSort(vetorA);
				 Ordenacao.mergeSort(vetorB);
				 Ordenacao.mergeSort(vetorC);
				 break;
				 
			 case 8:
				 JOptionPane.showMessageDialog(null, "Ainda não existe");
				 break;
				 
			 case 9:
				 Ordenacao.quickSort(vetorA);
				 Ordenacao.quickSort(vetorB);
				 Ordenacao.quickSort(vetorC);
				 break;
				 
			 case 10:
				 menu();
				 break;
				 
			case 0:
				JOptionPane.showMessageDialog(null,"Encerrando Programa");
				 break;
				 
			default:
				JOptionPane.showMessageDialog(null,"Opção Inválida");
			 }
			}
			while(op != 0);
		}
}

