package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import controller.AbreDoc;
import controller.AnimacaoPilha;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import controller.Telas;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Formulario da anima��o da Pilha
 * @author Zuzi
 */
@SuppressWarnings("serial")
public class Frm_animaPilha extends Telas {
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JLabel lbl_valor10;
	private JLabel lbl_valor20;
	private JLabel lbl_valor30;
	private JLabel lbl_valor40;
	private JLabel lbl_valor50;
	private JLabel lbl_valor60;
	private JLabel lbl_valor70;
	private int n = 6;
	private int z = 0;
	private JLabel vtEmpilhado[] = new JLabel[7];
	private JLabel vtDesempilhado[] = new JLabel[7];
	private Thread vtIniciar[] = new Thread[7];
	JButton btnAdicionar;
	JButton btnRemover;
	private int cont = 0;
	private int y = 30;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lblTopo;
	private JLabel lblCubo_1;
	private JLabel lblCubo_2;
	private JLabel lblCubo_3;
	private JLabel lblCubo_4;
	private JLabel lblCubo_5;
	private JLabel lblCubo_6;
	private JLabel lbl_fundo;
	private JLabel lblAdicioneUmElemento;
	private JLabel lblRemovaUmElemento;
	private JLabel lblFuncionamentoDeUma;
	private JLabel lblPilhaCheia;
	private boolean condi�ao;
	private JTextField tf_num;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_animaPilha frame = new Frm_animaPilha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frm_animaPilha() {
		setResizable(false);
		setTitle("Anima\u00E7\u00E3o - Pilha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 466);
		
		//Metodos para padroniza�ao das Telas
		centralizeFrame();
		iconeBarra();
		Estilo();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNewMenuItem = new JMenuItem("Menu Principal");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frm_principal telaprincipal = new Frm_principal();
				telaprincipal.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/home.png")));
		mnArquivo.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Fechar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/close.png")));
		mnArquivo.add(mntmNewMenuItem_1);
		
		mnNewMenu = new JMenu("Ajuda");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_2 = new JMenuItem("Manual");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbreDoc doc = new AbreDoc();
				doc.AbreManual();
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/manual.png")));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Sobre");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_3 = new JMenuItem("Detalhes");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frm_sobre sobre = new Frm_sobre();
				sobre.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/about-people.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_valor10 = new JLabel("10");
		lbl_valor10.setVisible(false);
		
		lblPilhaCheia = new JLabel("Pilha Cheia!!");
		lblPilhaCheia.setVisible(false);
		
		JLabel label_1 = new JLabel("*1 a 99.");
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_1.setBounds(242, 221, 46, 14);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("Valor a ser adicionado*.");
		label.setFont(new Font("Verdana", Font.BOLD, 14));
		label.setBounds(311, 191, 226, 25);
		contentPane.add(label);
		
		tf_num = new JTextField();
		tf_num.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					btnAdicionar.doClick();
				}
			}
		});
		tf_num.setFont(new Font("Tahoma", Font.BOLD, 16));
		tf_num.setColumns(10);
		tf_num.setBounds(226, 187, 75, 33);
		contentPane.add(tf_num);
		lblPilhaCheia.setForeground(Color.DARK_GRAY);
		lblPilhaCheia.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPilhaCheia.setBounds(226, 280, 169, 33);
		contentPane.add(lblPilhaCheia);
		lbl_valor10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_valor10.setForeground(Color.BLACK);
		lbl_valor10.setBounds(163, 54, 53, 38);
		contentPane.add(lbl_valor10);
		
		lbl_valor20 = new JLabel("20");
		lbl_valor20.setForeground(Color.BLACK);
		lbl_valor20.setVisible(false);
		lbl_valor20.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_valor20.setBounds(163, 58, 53, 31);
		contentPane.add(lbl_valor20);
		
		lbl_valor30 = new JLabel("30");
		lbl_valor30.setForeground(Color.BLACK);
		lbl_valor30.setVisible(false);
		lbl_valor30.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_valor30.setBounds(163, 58, 53, 31);
		contentPane.add(lbl_valor30);
		
		lbl_valor40 = new JLabel("40");
		lbl_valor40.setForeground(Color.BLACK);
		lbl_valor40.setVisible(false);
		lbl_valor40.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_valor40.setBounds(163, 58, 53, 31);
		contentPane.add(lbl_valor40);
		
		lbl_valor50 = new JLabel("50");
		lbl_valor50.setForeground(Color.BLACK);
		lbl_valor50.setVisible(false);
		lbl_valor50.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_valor50.setBounds(163, 58, 53, 31);
		contentPane.add(lbl_valor50);
		
		lbl_valor60 = new JLabel("60");
		lbl_valor60.setForeground(Color.BLACK);
		lbl_valor60.setVisible(false);
		lbl_valor60.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_valor60.setBounds(163, 58, 53, 31);
		contentPane.add(lbl_valor60);
		
		lbl_valor70 = new JLabel("70");
		lbl_valor70.setForeground(Color.BLACK);
		lbl_valor70.setVisible(false);
		lbl_valor70.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_valor70.setBounds(163, 58, 53, 31);
		contentPane.add(lbl_valor70);
		
		lblCubo_6 = new JLabel("");
		lblCubo_6.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/cubo.png")));
		lblCubo_6.setBounds(76, 39, 65, 67);
		contentPane.add(lblCubo_6);
		
		lblCubo_5 = new JLabel("");
		lblCubo_5.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/cubo.png")));
		lblCubo_5.setBounds(76, 89, 65, 67);
		contentPane.add(lblCubo_5);
		
		lblCubo_4 = new JLabel("");
		lblCubo_4.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/cubo.png")));
		lblCubo_4.setBounds(76, 138, 65, 67);
		contentPane.add(lblCubo_4);
		
		lblCubo_3 = new JLabel("");
		lblCubo_3.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/cubo.png")));
		lblCubo_3.setBounds(76, 187, 65, 67);
		contentPane.add(lblCubo_3);
		
		lblCubo_2 = new JLabel("");
		lblCubo_2.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/cubo.png")));
		lblCubo_2.setBounds(76, 236, 65, 67);
		contentPane.add(lblCubo_2);
		
		lblCubo_1 = new JLabel("");
		lblCubo_1.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/cubo.png")));
		lblCubo_1.setBounds(76, 285, 65, 67);
		contentPane.add(lblCubo_1);
		
		
		JLabel lblCubo0 = new JLabel("");
		lblCubo0.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/cubo.png")));
		lblCubo0.setBounds(76, 334, 65, 67);
		contentPane.add(lblCubo0);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setMnemonic('A');
		btnAdicionar.setToolTipText("Adicionar um novo elemento a pilha");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar.setBounds(226, 54, 108, 41);
		contentPane.add(btnAdicionar);
		
		JLabel lblTitulo = new JLabel("PILHA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTitulo.setBounds(64, 11, 96, 28);
		contentPane.add(lblTitulo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setMnemonic('V');
		btnVoltar.setToolTipText("Voltar para a descri��o da pilha");
		btnVoltar.setBounds(280, 346, 89, 38);
		contentPane.add(btnVoltar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setMnemonic('R');
		btnRemover.setToolTipText("Remover elemento da pilha");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(226, 125, 108, 41);
		contentPane.add(btnRemover);
		
		JButton btnQuestionario = new JButton("Question\u00E1rio");
		btnQuestionario.setMnemonic('Q');
		btnQuestionario.setBounds(391, 346, 108, 38);
		contentPane.add(btnQuestionario);
		
		lblTopo = new JLabel("TOPO ->");
		lblTopo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTopo.setBounds(10, 413, 53, 14);
		contentPane.add(lblTopo);
		
		JLabel lbl0 = new JLabel("0");
		lbl0.setBounds(64, 365, 11, 14);
		contentPane.add(lbl0);
		
		lbl1 = new JLabel("1");
		lbl1.setBounds(64, 317, 11, 14);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("2");
		lbl2.setBounds(64, 269, 11, 14);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("3");
		lbl3.setBounds(64, 221, 11, 14);
		contentPane.add(lbl3);
		
		lbl4 = new JLabel("4");
		lbl4.setBounds(64, 173, 11, 14);
		contentPane.add(lbl4);
		
		lbl5 = new JLabel("5");
		lbl5.setBounds(64, 125, 11, 14);
		contentPane.add(lbl5);
		
		lbl6 = new JLabel("6");
		lbl6.setBounds(64, 77, 11, 14);
		contentPane.add(lbl6);
		
		lblAdicioneUmElemento = new JLabel("Adicione um elemento");
		lblAdicioneUmElemento.setBounds(226, 39, 129, 14);
		contentPane.add(lblAdicioneUmElemento);
		
		lblRemovaUmElemento = new JLabel("Remova um elemento");
		lblRemovaUmElemento.setBounds(226, 106, 129, 14);
		contentPane.add(lblRemovaUmElemento);
		
		lblFuncionamentoDeUma = new JLabel("Funcionamento de uma Pilha");
		lblFuncionamentoDeUma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFuncionamentoDeUma.setForeground(Color.BLACK);
		lblFuncionamentoDeUma.setBounds(258, 11, 241, 14);
		contentPane.add(lblFuncionamentoDeUma);
		
		lbl_fundo = new JLabel("");
		lbl_fundo.setIcon(new ImageIcon(Frm_animaPilha.class.getResource("/Imagens/BackGround.png")));
		lbl_fundo.setBounds(-3, -12, 543, 428);
		contentPane.add(lbl_fundo);
		
		/**
		 * Botao voltar para a explica�ao da Pilha
		 */
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Frm_descricao(0).setVisible(true);
				
			}
		};
		
		/**
		 * Bot�o para adicionar elementos na Pilha
		 */
		ActionListener adicionar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				condi�ao = true;
				addElemento(btnAdicionar,btnRemover);
			}
		};
		
		/**
		 * Botao para remover elementos da Pilha
		 */
		ActionListener remover = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				condi�ao = false;
				rmElemento(btnAdicionar, btnRemover);
			}
		};
		/**
		 * Botao para ir para o questionario
		 */
		ActionListener questionario = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nomeArquivo="Perguntas.txt";
				Frm_Perguntas p = new Frm_Perguntas(nomeArquivo);
				p.setVisible(true);
				dispose();
			}
		};
		
		btnQuestionario.addActionListener(questionario);
		btnQuestionario.setToolTipText("Ir para o question�rio");
		btnRemover.addActionListener(remover);
		btnAdicionar.addActionListener(adicionar);
		btnVoltar.addActionListener(voltar);
		
			CarregaVtDesempilhado();
			
		if (vtEmpilhado[0] == null) {
			btnRemover.setEnabled(false);
		}
	}
	
	/**
	 * Metodo para carregar o vetor que armazena as JLabels dos elementos
	 * que entrarao na Pilha
	 */
	public void CarregaVtDesempilhado(){
		vtDesempilhado[0] = lbl_valor10;
		vtDesempilhado[1] = lbl_valor20;
		vtDesempilhado[2] = lbl_valor30;
		vtDesempilhado[3] = lbl_valor40;
		vtDesempilhado[4] = lbl_valor50;
		vtDesempilhado[5] = lbl_valor60;
		vtDesempilhado[6] = lbl_valor70;
	}
	
	/**
	 * Metodo que carrega o vetor com Threads, chamando uma classe 
	 * para adicionar elementos na Pilha
	 */
	public void CarregaThread(){
		Thread t7 = new AnimacaoPilha(lbl_valor70,btnAdicionar,btnRemover,y,lblTopo,cont, lblPilhaCheia,condi�ao);
		Thread t6 = new AnimacaoPilha(lbl_valor60,btnAdicionar,btnRemover,y,lblTopo,cont, lblPilhaCheia,condi�ao);
		Thread t5 = new AnimacaoPilha(lbl_valor50,btnAdicionar,btnRemover,y,lblTopo,cont, lblPilhaCheia,condi�ao);
		Thread t4 = new AnimacaoPilha(lbl_valor40,btnAdicionar,btnRemover,y,lblTopo,cont, lblPilhaCheia,condi�ao);
		Thread t3 = new AnimacaoPilha(lbl_valor30,btnAdicionar,btnRemover,y,lblTopo,cont, lblPilhaCheia,condi�ao);
		Thread t2 = new AnimacaoPilha(lbl_valor20,btnAdicionar,btnRemover,y,lblTopo,cont, lblPilhaCheia,condi�ao);
		Thread t1 = new AnimacaoPilha(lbl_valor10,btnAdicionar,btnRemover,y,lblTopo,cont, lblPilhaCheia,condi�ao);
		vtIniciar[0] = t1;
		vtIniciar[1] = t2;
		vtIniciar[2] = t3;
		vtIniciar[3] = t4;
		vtIniciar[4] = t5;
		vtIniciar[5] = t6;
		vtIniciar[6] = t7;
	}
	
	/**
	 * Metodo para chamar a Thread que sera executada na anima�ao de adicionar elementos
	 * @param btnAdicionar ficara false quando a anima�ao estiver em execu�ao
	 * @param btnRemover ficara false quando a anima�ao estiver em execu�ao
	 */ 
	public void addElemento(JButton btnAdicionar,JButton btnRemover){
		try {
			if (Frm_animaLista.TipoString(tf_num.getText()) != 1){
				JOptionPane.showMessageDialog(null, "Digite n�meros inteiros");
				tf_num.setText("");
				tf_num.grabFocus();
			}else{
				if (Integer.parseInt(tf_num.getText()) < 1 || Integer.parseInt(tf_num.getText()) > 99){
					JOptionPane.showMessageDialog(null, "Por favor, Digite n�meros de 1 a 99", "Aviso", 
							JOptionPane.INFORMATION_MESSAGE);
					tf_num.setText("");
					tf_num.grabFocus();
				}else{
				
				btnAdicionar.setEnabled(false);
				btnRemover.setEnabled(false);
				CarregaThread();
				for (int i = z; i < vtEmpilhado.length - n; i++) {
				vtEmpilhado[i] = vtDesempilhado[i];
				int valor=Integer.parseInt(tf_num.getText());
				tf_num.setText(String.valueOf(valor));
				vtDesempilhado[i].setText(tf_num.getText());
				vtDesempilhado[i] = null;
				vtIniciar[i].start();
				tf_num.setText("");
			}
			y -= 5;
			n -=1;
			z +=1;
			cont++;
			}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Por favor, Digite n�meros de 1 a 99", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			tf_num.setText("");
			tf_num.grabFocus();
		}
		
	}
	
	/**
	 * Metodo para chamar a Thread que sera executada na anima�ao de remover elementos
	 * @param btnAdicionar ficara false quando a anima�ao estiver em execu�ao
	 * @param btnRemover ficara false quando a anima�ao estiver em execu�ao
	 */
	public void rmElemento(JButton btnAdicionar,JButton btnRemover){
		btnRemover.setEnabled(false);
		btnAdicionar.setEnabled(false);
		lblPilhaCheia.setVisible(false);
		for (int i = vtDesempilhado.length-1; i > -1; i--) {
				if (vtDesempilhado[i] == null) {
					vtDesempilhado[i] = vtEmpilhado[i];
					vtEmpilhado[i] = null;
					CarregaThread();
					vtIniciar[i].start();
					i = -1;
					z-=1;
					n+=1;
					y += 5;
					cont--;
				}
		}
	}
}

