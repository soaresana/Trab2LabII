package lab.trabalhoII;

import javax.swing.JOptionPane;

public class Arvores {
	
	static AB abp = new AB();
	static AB avl = new AB();
	static int cont = 0;

	// Primeira parte do trabalho Árvores ABP e AVL Inserção, busca, e tempo. 
	
	public static void abp(int[] vet,int busca) {
		 long tempoinicial = System.currentTimeMillis();
		 for(int i=0; i<=vet.length;i++) {
			 abp.put(i,vet[i]);
			 cont++;
		 }
		 
		 long tempofinal = System.currentTimeMillis();
	     long tempototal = tempofinal - tempoinicial;
	     
	     long tempoinicialbusca = System.currentTimeMillis();
	     abp.achar(busca);
	     long tempofinalbusca = System.currentTimeMillis();
	     long tempototalbusca = tempofinalbusca - tempoinicialbusca;
	     
	     JOptionPane.showMessageDialog(null, ""+
	    	     "Quantidade de elementos inseridos:"+cont+" \n");  
	     JOptionPane.showMessageDialog(null, ""+
	     "Tempo de Inserção:"+ tempototal +"ms\n"+"Tempo de busca:"+ tempototalbusca + "ms\n");     
	}
	

	public static void Avl(int[] vet,int busca){
		long tempoinicial = System.currentTimeMillis();
		 for(int i=0; i<=100;i++) {
			 avl.inserirAVL(i,vet[i]);
		     //System.out.println(avl.maiorNo());
		 }
		 long tempofinal = System.currentTimeMillis();
	     long tempototal = tempofinal - tempoinicial;
	     
	     long tempoinicialbusca = System.currentTimeMillis();
	     avl.achar(busca);
	     long tempofinalbusca = System.currentTimeMillis();
	     long tempototalbusca = tempofinalbusca - tempoinicialbusca;
	     
	     JOptionPane.showMessageDialog(null, ""+
	     "Tempo de Inserção:"+ tempototal +"ms\n"+"Tempo de busca:"+ tempototalbusca + "ms\n"); 
		
		}
	}
