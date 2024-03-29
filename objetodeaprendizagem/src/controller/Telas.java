package controller;


import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * Classe que herda de jFrame e contem os metodos de aparencia do frame
 * @author jo�o
 * @author Hury
 */
@SuppressWarnings("serial")
public abstract class Telas extends JFrame {
	
	protected static String look="javax.swing.plaf.nimbus.NimbusLookAndFeel";
	protected static int tamanhofonte=16;
	protected static String linguagem="portugues-br.txt";
	
	/**
	 * M�todo que altera o icone das telas
	 */
	public void iconeBarra(){
	     BufferedImage image = null;  
	        try {  
	            image = ImageIO.read(  
	            this.getClass().getResource("/Imagens/icon.png"));  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        this.setIconImage(image);
	}
	
	/**
	 * M�todo para centralizar as telas no centro
	 */
	  public void centralizeFrame(){
	        int x,y;
	        Rectangle scr=this.getGraphicsConfiguration().getBounds();
	        Rectangle form=this.getBounds();
	        x= (int) (scr.getWidth() - form.getWidth())/2;
	        y=(int) (scr.getHeight()-form.getHeight())/2;
	        this.setLocation(x, y);
	    }
	  
	 /**
	  * M�todo que seta o estilo de todas as telas
	  */
	  public void Estilo(){		  
		  try {
			 UIManager.setLookAndFeel(look);
			 javax.swing.SwingUtilities.updateComponentTreeUI( this );
			} catch (Exception e) {
				System.out.println(e);
			}		  
	  }
	  
	 /* 
	  public void linguagem(){
		  try {
			Linguagem_c lg = new Linguagem_c();
			//lg.diretorio();
		} catch (Exception e) {
			// TODO: handle exception
		}
	  }*/

}
