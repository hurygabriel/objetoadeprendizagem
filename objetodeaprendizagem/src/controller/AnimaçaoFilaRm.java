package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * @author Zuzi
 */
public class AnimašaoFilaRm extends Thread {
	
	private JLabel lbl_valor;
	
	public AnimašaoFilaRm(JLabel lbl_valor){
		this.lbl_valor = lbl_valor;
	}
	
	public void run (){
		animarRm();
	}
	
	public void animarRm(){
		Rectangle posišao = lbl_valor.getBounds();
		
		for (int i = 0; i < 8; i++) {
			posišao.y += 9;
			lbl_valor.setBounds(posišao);
			try {
				Thread.sleep(35);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			posišao.x = 281;
			lbl_valor.setBounds(posišao);
	}
}
