package lab.trabalhoII;

public class AB {
	int cont =0;
	
	class CNo {
        private int chave;
        private Object valor;
        private CNo esq, dir;

        public CNo()
        {
            valor = esq = dir = null;
        }

        public CNo(int k)
        {
            chave = k;
            valor = esq = dir = null;
        }

        public CNo(int k, Object v)
        {
            chave = k;
            valor = v;
            esq = null;
            dir = null;
        }

        public CNo(int k, Object v, CNo e, CNo d)
        {
            chave = k;
            valor = v;
            esq = e;
            dir = d;
        }
    }
	 private CNo raiz = null;

	    public Object get(int k)
	    {
	        return get(raiz, k);
	    }

	    private Object get(CNo no, int k)
	    {
	        if (no == null)
	            return null;
	        if (k < no.chave)
	            return get(no.esq, k);
	        else
	            if (k > no.chave)
	                return get(no.dir, k);
	            else
	                return no.valor;
	    }

	    public void put(int k, Object v)
	    {
	        raiz = put(raiz, k, v);
	    }

	    private CNo put(CNo no, int k, Object v)
	    {
	    	if (no == null)
	            return new CNo(k, v);
	        if (k < no.chave)
	            no.esq = put(no.esq, k, v);
	        else
	            if (k > no.chave)
	                no.dir = put(no.dir, k, v);
	            else
	                no.valor = v;
	        cont++;
	        return no;
	    }

	    private void emOrdem(CNo no)
	    {
	        if (no != null) {
	            emOrdem(no.esq);
	            System.out.println(no.chave+" "+no.valor);
	            emOrdem(no.dir);
	        }
	    }

	    private void preOrdem(CNo no)
	    {
	        if (no != null) {
	            System.out.println(no.chave+" "+no.valor);
	            preOrdem(no.esq);
	            preOrdem(no.dir);
	        }
	    }

	    private void posOrdem(CNo no)
	    {
	        if (no != null) {
	            posOrdem(no.esq);
	            posOrdem(no.dir);
	            System.out.println(no.chave+" "+no.valor);
	        }
	    }

	    public void imprimir(int op)
	    {
	    	// Ordem = 1 => EmOrdem
	    	// Ordem = 2 => PreOrdem
			// Ordem = 1 => PosOrdem
	  		switch (op) {
	    		case 1:
				System.out.println("\n\nImpressao em ordem");
				emOrdem(raiz);
				break;
				case 2:
					System.out.println("\n\nImpressao pre ordem");
					preOrdem(raiz);
					break;
				case 3:
					System.out.println("\n\nImpressao pos ordem");
					posOrdem(raiz);
					break;
				default:
					System.out.println("Opcao invalida!!!\n\n");
					break;
				}
	  	}

	    public int somaNosInt()
	    {
	        return somaNosInt(raiz);
	    }
	    
	    private int somaNosInt(CNo no)
	    {
	        if (no != null && (no.dir != null || no.esq != null))
	            return no.chave + somaNosInt(no.esq) + somaNosInt(no.dir);
	        else
	            return 0;
	    }
	    
	 // Chama o metodo ContaNos passando a raiz como no inicial
	    public int contaNos()
	    {
	        return contaNos(raiz);
	    }

	    // Realiza a contagem de nos a partir de um dado no
	    private int contaNos(CNo no)
	    {
	        if (no != null)
	            return 1 + contaNos(no.esq) + contaNos(no.dir);
	        else
	            return 0;
	    }

	    // Chama o metodo QtdeNosFolha passando a raiz como no inicial
	    public int qtdeNosFolha()
	    {
	        return qtdeNosFolha(raiz);
	    }
	    
	    // Realiza a contagem de nos folhas a partir de determinado no
	    private int qtdeNosFolha(CNo no)
	    {
	        if (no != null)
	        {
	            int incremento = 0;
	            if (no.esq == null && no.dir == null)
	                incremento++;
	            return incremento + qtdeNosFolha(no.dir) + qtdeNosFolha(no.esq);
	        }
	        else
	            return 0;
	    }

	    // Chama o metodo QtdeNosInternos passando a raiz como no inicial
	    public int qtdeNosInternos()
	    {
	        return qtdeNosInternos(raiz);
	    }
	    
	    // Realiza a contagem de nos internos a partir de determinado no
	    private int qtdeNosInternos(CNo no)
	    {
	        if (no != null)
	        {
	            int incremento = 0;
	            if (no.esq != null || no.dir != null)
	                incremento++;
	            return incremento + qtdeNosInternos(no.dir) + qtdeNosInternos(no.esq);
	        }
	        else
	            return 0;
	    }
	    
	    // Imprime os nos folha no percurso em ordem
	    private void imprimeNosFolhaEmOrdem(CNo no)
	    {
	        if (no != null)
	        {
	            imprimeNosFolhaEmOrdem(no.esq);
	            if (no.esq == null && no.dir == null)
	            {
	                System.out.println(no.valor);
	            }
	            imprimeNosFolhaEmOrdem(no.dir);
	        }
	    }

	    // Chama o metodo ImprimeNosFolhaEmOrdem passando a raiz como parametro
	    public void imprimeNosFolhaEmOrdem()
	    {
	        imprimeNosFolhaEmOrdem(raiz);
	    }

	    // Imprime os nos folha no percurso em ordem
	    private void imprimeNosInternosEmOrdem(CNo no)
	    {
	        if (no != null)
	        {
	            imprimeNosInternosEmOrdem(no.esq);
	            if (no.esq != null || no.dir != null)
	                System.out.println(no.valor);
	            imprimeNosInternosEmOrdem(no.dir);
	        }
	    }

	    // Chama o metodo ImprimeNosFolhaEmOrdem passando a raiz como parametro
	    public void imprimeNosInternosEmOrdem()
	    {
	        imprimeNosInternosEmOrdem(raiz);
	    }

	    // Chama o metodo ImprimeNosFolhaEmOrdem passando a raiz como parametro
	    public void ImprimeNosInternosEmOrdem()
	    {
	        imprimeNosInternosEmOrdem(raiz);
	    }

	    public void info() {
			info(raiz, raiz);
		}

		private void info(CNo no, CNo pai) {

			if (no != null) {

				int filhos = 0;

				System.out.println("\nValor: " + no.chave);
				System.out.println("Altura: " + altura(no));
				System.out.println("Profundidade: " + profundidade(no.chave));
				if (no != pai)
					System.out.println("Pai: " + pai.chave);
				else
					System.out.println("Pai: Não tem.");

				if (no.esq != null)
					filhos++;
				if (no.dir != null)
					filhos++;

				System.out.println("Quantidade de filhos: " + filhos);

				if (no.dir != null)
					System.out.println("Filho a direita: " + no.dir.chave);
				else
					System.out.println("Filho a direita: Não tem.");
				if (no.esq != null)
					System.out.println("Filho a esquerda: " + no.esq.chave);
				else
					System.out.println("Filho a esquerda: Não tem.");
				if (no.dir == null && no.esq == null)
					System.out.println("Nó folha.");
				else if (no == pai)
					System.out.println("Nó raiz.");
				else if (no.dir != null || no.esq != null)
					System.out.println("Nó intermedário.");

				info(no.dir, no);
				info(no.esq, no);
			}

		}
		public void imprimeDecresc() {
			imprimeDecresc(raiz);
		}

		private void imprimeDecresc(CNo no) {
			if (no != null) {
				imprimeDecresc(no.dir);
				System.out.println("Chave = " + no.chave);
				imprimeDecresc(no.esq);
			}
		}

		public void folhas() {
			folhas(raiz);
		}

		private void folhas(CNo no) {
			if (no != null) {
				folhas(no.esq);
				if (no.dir == null && no.esq == null)
					System.out.println("Folha: " + no.chave);
				folhas(no.dir);
			}
		}


	    public Object maiorNo()
	    {
	        if (raiz != null)
	            return maiorNo(raiz);
	        else
	            return -1;
	    }

	    private Object maiorNo(CNo no)
	    {
	        if (no.dir != null)
	            return maiorNo(no.dir);
	        else
	            return no.chave;
	    }

	    private Object menorNo(CNo no)
	    {
	        if (no.esq != null)
	            return menorNo(no.esq);
	        else
	            return no.valor;
	    }

	    public Object menorNo()
	    {
	        if (raiz != null)
	            return menorNo(raiz);
	        else
	            return -1;
	    }

	    public boolean achou(int k)
	    {
	        return achouRec(raiz, k);
	    }

	    private boolean achouRec(CNo no, int k)
	    {
	        if (no != null && no.chave != k)
	        {
	            if (k < no.chave)
	                return achouRec(no.esq, k);
	            else
	                return achouRec(no.dir, k);
	        }

	        return no != null ? true : false;
	    }
	    
		// Método recursivo de busca em ABP
		private boolean contem(CNo no, int v) {
			if (no == null)
				return false;
			if (v == no.chave)
				return true;
			return v < no.chave ? contem(no.esq, v) : contem(no.dir, v);
		}

		// Chama o método recursivo "contem"
		public boolean contem(int v) {
			return contem(raiz, v);
		}
		
		// Método iterativo de busca em ABP
				public CNo achar(int k) {
					CNo no = raiz;
					while (no != null) {
						if (no.chave == k)
							return no;
						else if (no.chave > k)
							no = no.esq;
						else
							no = no.dir;
					}
					return null;
				}
	public void delete(int valor) {
		raiz = deleteRecursivo(raiz, valor);
	}

	// Método recursivo de exclusão de nós
	private CNo deleteRecursivo(CNo no, int v) {
		if (no == null)
			return null;

		if (v == no.chave) {
			if (no.esq == null && no.dir == null)
				return null;

			if (no.dir == null)
				return no.esq;

			if (no.esq == null)
				return no.dir;

			int menorValor = menorValor(no.dir);
			no.chave = menorValor;
			no.dir = deleteRecursivo(no.dir, menorValor);
			return no;
		}

		if (v < no.chave) {
			no.esq = deleteRecursivo(no.esq, v);
			return no;
		}
		no.dir = deleteRecursivo(no.dir, v);
		return no;
	}
// Retorna o menor valor em uma subárvore
	private int menorValor(CNo no) {
		return no.esq == null ? no.chave : menorValor(no.esq);
	}
	
	private int maiorValor(CNo no) {
		return no.dir == null ? no.chave : maiorValor(no.dir);
	}
	
	public Object subMenorValor(int chave) {
		CNo no = achar(chave);
		int valor = menorValor(no);
		return valor;
	}
	
	public Object subMaiorValor(int chave) {
		CNo no = achar(chave);
		int valor = maiorValor(no);
		return valor;
	}
	
	public int profundidade(int valor) {
		return profundidade(raiz, valor, 1);
	}
	
	private int profundidade(CNo no, int valor, int cont) {
		if (no == null)
			return 0;
		if (valor == no.chave)
			return cont;
		cont++;
		return valor < no.chave ? profundidade(no.esq, valor, cont) : profundidade(no.dir, valor, cont);
	}
	
	public int altura(int valor) {
		CNo no = achar(valor);
		return altura(no);
	}
	
	private int altura(CNo no) {
	
		int esq = 0, dir = 0;
	
		if (no != null) {
			dir = dir + altura(no.dir);
			esq = esq + altura(no.esq);
		} else
			return 0;
	
		if (dir > esq)
			return dir + 1;
		else
			return esq + 1;
	}
	
	public CNo localizaPai(int chave) {
		CNo atual = raiz;
		CNo pai = null;
		while (atual.chave != chave) {
			if (chave < atual.chave) {
				pai = atual;
				atual = atual.esq;
			} else {
				pai = atual;
				atual = atual.dir;
			}
			if (atual == null)
				return null;
		}
		return pai;
	}
	public int fatorBalanceamento(CNo atual) {

		int fatorbalanceamento = 0;

		if ((atual.esq != null) && (atual.dir != null)) {
			fatorbalanceamento = altura(atual.esq) - altura(atual.dir);

		} else if ((atual.esq == null) && (atual.dir != null)) {
			fatorbalanceamento = -1 - altura(atual.dir);

		} else if ((atual.esq != null) && (atual.dir == null)) {
			fatorbalanceamento = altura(atual.esq) + 1;
		}

		return fatorbalanceamento;
	}
	protected void balanceia(CNo atual) {
		CNo aux;
		CNo aux2;
		if ((atual != null) && (atual.dir != null) && (atual.dir.dir != null) && (fatorBalanceamento(atual) == -2)
				&& (fatorBalanceamento(atual.dir) == -1) && (fatorBalanceamento(atual.dir.dir) == -1)) {
			if (localizaPai(atual.chave).dir == atual) {
				localizaPai(atual.chave).dir = atual.dir;
			} else {
				localizaPai(atual.chave).esq = atual.dir;
			}
			;
			aux = atual;
			atual = atual.dir;
			aux.dir = atual.esq;
			atual.esq = aux;
		} else if ((atual != null) && (atual.esq != null) && (atual.esq.esq != null) && (fatorBalanceamento(atual) == 2)
				&& (fatorBalanceamento(atual.esq) == 1) && (fatorBalanceamento(atual.esq.esq) == 1)) {
			if (localizaPai(atual.chave).dir == atual) {
				localizaPai(atual.chave).dir = atual.esq;
			} else {
				localizaPai(atual.chave).esq = atual.esq;
			}
			;
			aux = atual;
			atual = atual.esq;
			aux.esq = atual.dir;
			atual.dir = aux;
		} else if ((atual != null) && (atual.esq != null) && (atual.esq.dir != null) && (fatorBalanceamento(atual) == 2)
				&& (fatorBalanceamento(atual.esq) == -1) && (fatorBalanceamento(atual.esq.dir) == 1)) {
			if (localizaPai(atual.chave).dir == atual) {
				localizaPai(atual.chave).dir = atual.esq.dir;
			} else {
				localizaPai(atual.chave).esq = atual.esq.dir;
			}
			;
			aux = atual;
			aux2 = atual.esq;
			atual = atual.esq.dir;
			aux2.dir = atual.esq;
			aux.esq = atual.dir;
			atual.dir = aux;
			atual.esq = aux2;
		} else if ((atual != null) && (atual.dir != null) && (atual.dir.esq != null)
				&& (fatorBalanceamento(atual) == -2) && (fatorBalanceamento(atual.dir) == 1)
				&& (fatorBalanceamento(atual.dir.esq) == -1)) {
			if (localizaPai(atual.chave).dir == atual) {
				localizaPai(atual.chave).dir = atual.dir.esq;
			} else {
				localizaPai(atual.chave).esq = atual.dir.esq;
			}
			;
			aux = atual;
			aux2 = atual.dir;
			atual = atual.dir.esq;
			aux.dir.esq = atual.dir;
			aux.dir = atual.esq;
			atual.dir = aux;
			atual.esq = aux2;
		}
	}

	public void inserirAVL(int chave, Object valor) {
		CNo no = new CNo(chave,valor);
		inserirAVL(raiz, no);
	}

	private void inserirAVL(CNo aComparar, CNo aInserir) {

		if (aComparar == null) {
			raiz = aInserir;

		} else {

			if (aInserir.chave < aComparar.chave) {

				if (aComparar.esq == null) {
					aComparar.esq = aInserir;
					localizaPai(aComparar.chave);
					fatorBalanceamento(aComparar);

				} else {
					inserirAVL(aComparar.esq, aInserir);
				}

			} else if (aInserir.chave > aComparar.chave) {

				if (aComparar.dir == null) {
					aComparar.dir = aInserir;
					localizaPai(aComparar.chave);
					fatorBalanceamento(aComparar);

				} else {
					inserirAVL(aComparar.dir, aInserir);
				}

			} else {
				System.out.println("Este nó já existe!");
			}
		}
	}

}
