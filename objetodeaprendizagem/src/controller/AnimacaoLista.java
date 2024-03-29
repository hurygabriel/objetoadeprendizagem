package controller;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Classe com os metodos da Lista
 * @author Hury
 *
 */

public class AnimacaoLista extends Thread implements OperacaoAnimacao {

	private JLabel lbl_cubo1;
	private JLabel lbl_cubo2;
	private JLabel lbl_cubo3;
	private JLabel lbl_cubo4;
	private JLabel lbl_cubo5;
	private JLabel lbl_cubo6;

	private JLabel lbl_valor1;
	private JLabel lbl_valor2;
	private JLabel lbl_valor3;
	private JLabel lbl_valor4;
	private JLabel lbl_valor5;
	private JLabel lbl_valor6;
	private JTextField txt_num;

	private int Selecionado;
	private int lista[];
	private int tamanho;
	private int operacao;

	public AnimacaoLista(int operacao, JLabel lbl_cubo1, JLabel lbl_cubo2,
			JLabel lbl_cubo3, JLabel lbl_cubo4, JLabel lbl_cubo5,
			JLabel lbl_cubo6, JLabel lbl_valor1, JLabel lbl_valor2,
			JLabel lbl_valor3, JLabel lbl_valor4, JLabel lbl_valor5,
			JLabel lbl_valor6, JLabel lbl_cheia, JTextField txt_num,
			int selecionado, int[] lista, int tamanho) {
		super();
		this.operacao = operacao;
		this.lbl_cubo1 = lbl_cubo1;
		this.lbl_cubo2 = lbl_cubo2;
		this.lbl_cubo3 = lbl_cubo3;
		this.lbl_cubo4 = lbl_cubo4;
		this.lbl_cubo5 = lbl_cubo5;
		this.lbl_cubo6 = lbl_cubo6;
		this.lbl_valor1 = lbl_valor1;
		this.lbl_valor2 = lbl_valor2;
		this.lbl_valor3 = lbl_valor3;
		this.lbl_valor4 = lbl_valor4;
		this.lbl_valor5 = lbl_valor5;
		this.lbl_valor6 = lbl_valor6;
		this.txt_num = txt_num;
		Selecionado = selecionado;
		this.lista = lista;
		this.tamanho = tamanho;
	}

	/**
	 * Metodo de inicializada da thread
	 */
	public void run() {
		// opera��es: 1=add inicio 2=add Final 3=add posi��o especifica
		// 4=remove inicio 5=remove final 6= remove posi��o especifica

		switch (operacao) {
		case 1:
			addInicio();
			txt_num.setText("");
			txt_num.grabFocus();
			break;
		case 2:
			addFinal();
			txt_num.setText("");
			txt_num.grabFocus();
			break;
		case 3:
			addElemento();
			txt_num.setText("");
			txt_num.grabFocus();
			break;
		case 4:
			removeInicio();
			break;
		case 5:
			removeFinal();
			break;
		case 6:
			removeElemento();
			break;
		default:
			System.out.println("Erro de implementa��o:" + operacao
					+ " opera��o");
			break;
		}
	}

	/**
	 * Adiciona 1 elemento no espa�o selecionado
	 */

	@Override
	public void addElemento() {
		System.out.println("Selecionado=" + Selecionado);
		switch (Selecionado) {
		case 1:
			movDireita(1);
			add(1);
			habilita(tamanho + 1);
			break;
		case 2:
			if (lista[1] == 0) {
				add(tamanho + 1);
			} else {
				movDireita(2);
				add(2);
				habilita(tamanho + 1);
			}
			break;
		case 3:
			if (lista[2] == 0) {
				add(tamanho + 1);
			} else {
				movDireita(3);
				add(3);
				habilita(tamanho + 1);
			}
			break;
		case 4:
			if (lista[3] == 0) {
				add(tamanho + 1);
			} else {
				movDireita(4);
				add(4);
				habilita(tamanho + 1);
			}
			break;
		case 5:
			if (lista[4] == 0) {
				add(tamanho + 1);
			} else {
				movDireita(5);
				add(5);
				habilita(tamanho + 1);
			}
			break;
		case 6:
			if (lista[5] == 0) {
				add(tamanho + 1);
			} else {
				add(6);
				habilita(tamanho + 1);
			}
			break;
		default:
			break;
		}

	}

	/**
	 * Remove 1 elemento de um espa�o selecionado.
	 */
	@Override
	public void removeElemento() {

		desabilita(tamanho);
		if (tamanho >= Selecionado) {
			movEsquerda(Selecionado + 1);
		} else {
			removeFinal();
		}

	}

	/**
	 * Adiciona no inicio da lista
	 */
	public void addInicio() {
		if (cheia() == false) {
			if (tamanho == 0) {
				add(1);
			} else {
				movDireita(1);
				add(1);
				habilita(tamanho + 1);
			}
		} else {
			System.out.println("Lista Cheia");
		}
		System.out.println("Tamanho=" + tamanho);
	}

	/**
	 * Adiciona no Final da lista
	 */
	public void addFinal() {
		if (cheia() == false) {
			if (tamanho == 0) {
				add(1);
			} else {
				add(tamanho + 1);
			}
		} else {
			System.out.println("Lista Cheia");
		}
	}

	/**
	 * Remove o primeiro elemento da fila
	 */
	public void removeInicio() {
		movEsquerda(2);
		desabilita(tamanho);
	}

	/**
	 * Remove o ultimo elemento da fila
	 */

	public void removeFinal() {
		desabilita(tamanho);
		lista[tamanho] = 0;
	}

	/**
	 * Verifica se a lista est� cheia.
	 * 
	 * @return
	 */

	public boolean cheia() {
		if (tamanho >= lista.length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Verifica se o n�mero em quest�o est� em duplicidade com o conte�do da
	 * arvore.
	 * 
	 * @param rand
	 * @return
	 */

	public boolean verificadupli(int rand) {
		boolean result = false;
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == rand) {
				result = true;
			} else {

			}
		}
		return result;
	}

	/**
	 * Move os elementos da lista para a direita a partir de determinada
	 * posi��o.
	 * 
	 * @param elemento
	 */
	public void movDireita(int elemento) {
		int aux1 = 0;
		int aux2 = 0;

		switch (elemento) {

		case 1:
			aux1 = lista[1];
			lista[1] = lista[0];
			aux2 = lista[2];
			lista[2] = aux1;
			aux1 = lista[3];
			lista[3] = aux2;
			aux2 = lista[4];
			lista[4] = aux1;
			aux1 = lista[5];
			lista[5] = aux2;

			lbl_valor6.setText(Integer.toString(lista[5]));
			lbl_valor5.setText(Integer.toString(lista[4]));
			lbl_valor4.setText(Integer.toString(lista[3]));
			lbl_valor3.setText(Integer.toString(lista[2]));
			lbl_valor2.setText(Integer.toString(lista[1]));

			break;
		case 2:
			aux2 = lista[2];
			lista[2] = lista[1];
			aux1 = lista[3];
			lista[3] = aux2;
			aux2 = lista[4];
			lista[4] = aux1;
			aux1 = lista[5];
			lista[5] = aux2;

			lbl_valor6.setText(Integer.toString(lista[5]));
			lbl_valor5.setText(Integer.toString(lista[4]));
			lbl_valor4.setText(Integer.toString(lista[3]));
			lbl_valor3.setText(Integer.toString(lista[2]));

			break;
		case 3:
			aux1 = lista[3];
			lista[3] = lista[2];
			aux2 = lista[4];
			lista[4] = aux1;
			aux1 = lista[5];
			lista[5] = aux2;

			lbl_valor6.setText(Integer.toString(lista[5]));
			lbl_valor5.setText(Integer.toString(lista[4]));
			lbl_valor4.setText(Integer.toString(lista[3]));

			System.out.println("[3]=" + lista[3] + "[4]=" + lista[4] + "[5]="
					+ lista[5]);

			break;
		case 4:
			aux2 = lista[4];
			lista[4] = lista[3];
			aux1 = lista[5];
			lista[5] = aux2;
			lbl_valor6.setText(Integer.toString(lista[5]));
			lbl_valor5.setText(Integer.toString(lista[4]));

			break;
		case 5:
			lista[5] = lista[4];
			lbl_valor6.setText(Integer.toString(lista[5]));

			break;
		default:
			System.out.println("Implementa��o incorreta, movDireita");
			break;
		}

	}

	/**
	 * Move os elementos da lista para a esquerda a partir de determinada
	 * posi��o
	 * 
	 * @param elemento
	 */

	public void movEsquerda(int elemento) {
		switch (elemento) {
		case 2:
			lista[0] = lista[1];
			lista[1] = lista[2];
			lista[2] = lista[3];
			lista[3] = lista[4];
			lista[4] = lista[5];
			lista[5] = 0;
			lbl_valor5.setText(Integer.toString(lista[4]));
			lbl_valor4.setText(Integer.toString(lista[3]));
			lbl_valor3.setText(Integer.toString(lista[2]));
			lbl_valor2.setText(Integer.toString(lista[1]));
			lbl_valor1.setText(Integer.toString(lista[0]));
			break;
		case 3:
			lista[1] = lista[2];
			lista[2] = lista[3];
			lista[3] = lista[4];
			lista[4] = lista[5];
			lista[5] = 0;
			lbl_valor5.setText(Integer.toString(lista[4]));
			lbl_valor4.setText(Integer.toString(lista[3]));
			lbl_valor3.setText(Integer.toString(lista[2]));
			lbl_valor2.setText(Integer.toString(lista[1]));
			break;
		case 4:
			lista[2] = lista[3];
			lista[3] = lista[4];
			lista[4] = lista[5];
			lista[5] = 0;
			lbl_valor5.setText(Integer.toString(lista[4]));
			lbl_valor4.setText(Integer.toString(lista[3]));
			lbl_valor3.setText(Integer.toString(lista[2]));
			break;
		case 5:
			lista[3] = lista[4];
			lista[4] = lista[5];
			lista[5] = 0;
			lbl_valor5.setText(Integer.toString(lista[4]));
			lbl_valor4.setText(Integer.toString(lista[3]));
			break;
		case 6:
			lista[4] = lista[5];
			lista[5] = 0;
			lbl_valor5.setText(Integer.toString(lista[4]));
			break;
		default:
			System.out.println("Implementa��o incorreta, movEsquerda");
			break;
		}
	}

	/**
	 * Adiciona em determinado cubo
	 * 
	 * @param opc
	 */

	private void add(int opc) {
		Rectangle posicao1;
		Rectangle posicao2;
		switch (opc) {
		case 1:
			posicao1 = lbl_valor1.getBounds();
			posicao2 = lbl_cubo1.getBounds();

			posicao1.x = posicao2.x + 15;
			posicao1.y = posicao2.y + 30;

			lbl_valor1.setText(txt_num.getText());
			alinhar(lbl_valor1, posicao1, posicao2);
			lbl_valor1.setBounds(posicao1);

			lista[0] = Integer.parseInt(txt_num.getText());

			lbl_valor1.setVisible(true);

			break;
		case 2:
			posicao1 = lbl_valor2.getBounds();
			posicao2 = lbl_cubo2.getBounds();

			posicao1.x = posicao2.x + 15;
			posicao1.y = posicao2.y + 30;

			lbl_valor2.setText(txt_num.getText());
			alinhar(lbl_valor2, posicao1, posicao2);
			lbl_valor2.setBounds(posicao1);

			lista[1] = Integer.parseInt(txt_num.getText());
			lbl_valor2.setVisible(true);

			break;
		case 3:
			posicao1 = lbl_valor3.getBounds();
			posicao2 = lbl_cubo3.getBounds();

			posicao1.y = posicao2.y + 30;

			lbl_valor3.setText(txt_num.getText());
			alinhar(lbl_valor3, posicao1, posicao2);
			lbl_valor3.setBounds(posicao1);

			lista[2] = Integer.parseInt(txt_num.getText());
			lbl_valor3.setVisible(true);

			break;
		case 4:
			posicao1 = lbl_valor4.getBounds();
			posicao2 = lbl_cubo4.getBounds();

			posicao1.y = posicao2.y + 30;

			lbl_valor4.setText(txt_num.getText());
			alinhar(lbl_valor4, posicao1, posicao2);
			lbl_valor4.setBounds(posicao1);

			lista[3] = Integer.parseInt(txt_num.getText());
			lbl_valor4.setVisible(true);

			break;
		case 5:
			posicao1 = lbl_valor5.getBounds();
			posicao2 = lbl_cubo5.getBounds();

			posicao1.y = posicao2.y + 30;

			lbl_valor5.setText(txt_num.getText());
			alinhar(lbl_valor1, posicao1, posicao2);
			lbl_valor5.setBounds(posicao1);

			lista[4] = Integer.parseInt(txt_num.getText());
			lbl_valor5.setVisible(true);

			break;
		case 6:
			posicao1 = lbl_valor6.getBounds();
			posicao2 = lbl_cubo6.getBounds();

			posicao1.y = posicao2.y + 30;

			lbl_valor6.setText(txt_num.getText());
			alinhar(lbl_valor1, posicao1, posicao2);
			lbl_valor6.setBounds(posicao1);

			lista[5] = Integer.parseInt(txt_num.getText());
			lbl_valor6.setVisible(true);

			break;
		}
	}
	/**
	 * Metodo para alinhar a Label ao cubo
	 * @param lbl_valor
	 * @param posicao1
	 * @param posicao2
	 * @return
	 */
	public int alinhar(JLabel lbl_valor, Rectangle posicao1, Rectangle posicao2) {
		if (Integer.parseInt(lbl_valor.getText()) < 10) {
			return posicao1.x = posicao2.x + 15;
		} else {
			return posicao1.x = posicao2.x + 10;
		}
	}

	/**
	 * Habilita e move labels
	 * 
	 * @param tamanho2
	 */
	private void habilita(int tamanho2) {
		Rectangle posicao1;
		Rectangle posicao2;
		switch (tamanho2) {
		case 1:
			posicao1 = lbl_valor1.getBounds();
			posicao2 = lbl_cubo1.getBounds();

			posicao1.x = posicao2.x + 15;
			posicao1.y = posicao2.y + 30;

			lbl_valor1.setBounds(posicao1);
			lbl_valor1.setVisible(true);

			break;
		case 2:
			posicao1 = lbl_valor2.getBounds();
			posicao2 = lbl_cubo2.getBounds();

			posicao1.x = posicao2.x + 15;
			posicao1.y = posicao2.y + 30;

			lbl_valor2.setBounds(posicao1);
			lbl_valor2.setVisible(true);
			break;
		case 3:
			posicao1 = lbl_valor3.getBounds();
			posicao2 = lbl_cubo3.getBounds();

			posicao1.x = posicao2.x + 15;
			posicao1.y = posicao2.y + 30;

			lbl_valor3.setBounds(posicao1);
			lbl_valor3.setVisible(true);
			break;
		case 4:
			posicao1 = lbl_valor4.getBounds();
			posicao2 = lbl_cubo4.getBounds();

			posicao1.x = posicao2.x + 15;
			posicao1.y = posicao2.y + 30;

			lbl_valor4.setBounds(posicao1);
			lbl_valor4.setVisible(true);
			break;
		case 5:
			posicao1 = lbl_valor5.getBounds();
			posicao2 = lbl_cubo5.getBounds();

			posicao1.x = posicao2.x + 15;
			posicao1.y = posicao2.y + 30;

			lbl_valor5.setBounds(posicao1);
			lbl_valor5.setVisible(true);
			break;
		case 6:
			posicao1 = lbl_valor6.getBounds();
			posicao2 = lbl_cubo6.getBounds();

			posicao1.x = posicao2.x + 15;
			posicao1.y = posicao2.y + 30;

			lbl_valor6.setBounds(posicao1);
			lbl_valor6.setVisible(true);
			break;
		}
	}

	/**
	 * desabilita labels
	 * 
	 * @param element
	 */

	private void desabilita(int element) {

		switch (element) {
		case 1:
			lbl_valor1.setVisible(false);
			break;
		case 2:
			lbl_valor2.setVisible(false);
			break;
		case 3:
			lbl_valor3.setVisible(false);
			break;
		case 4:
			lbl_valor4.setVisible(false);
			break;
		case 5:
			lbl_valor5.setVisible(false);
			break;
		case 6:
			lbl_valor6.setVisible(false);
			break;

		default:
			break;
		}
	}
}
