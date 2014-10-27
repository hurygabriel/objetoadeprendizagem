package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * @author Zuzi
 */
public class AnimašaoFilaRm extends Thread {
	
	private JLabel lbl_valor;
	private JButton btnAdicionar;
	private JButton btnRemover;
	
	public AnimašaoFilaRm(JLabel lbl_valor, JButton btnAdicionar, JButton btnRemover){
		this.lbl_valor = lbl_valor;
		this.btnAdicionar = btnAdicionar;
		this.btnRemover = btnRemover;
	}
	
	public void run (){
		animarRm();
	}
	
	public void animarRm(){
		btnAdicionar.setEnabled(false);
		btnRemover.setEnabled(false);
		Rectangle posišao = lbl_valor.getBounds();
		
		for (int i = 0; i < 8; i++) {
			posišao.y += 9;
			lbl_valor.setBounds(posišao);
			try {
				Thread.sleep(110);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			posišao.x = 281;
			lbl_valor.setBounds(posišao);
			lbl_valor.setVisible(false);
	}
}
