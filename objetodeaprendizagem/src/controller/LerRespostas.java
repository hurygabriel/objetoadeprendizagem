package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
/**
 * Classe para ler as respostas corretas no arquivo
 * @author Pedro
 *
 */
public class LerRespostas {
		
		public Pilha p1 = new Pilha();

		/**
		 * Metodo para pegar achar o arquivo, pegar e jogar na Pilha seus elementos.
		 */
		public void leArquivos(String nomeArquivo) {
			StringBuffer sbDir=new StringBuffer();
			sbDir.append("src");
			sbDir.append(File.separator);
			sbDir.append("Arquivos");
			sbDir.append(File.separator);
			
			File dir= new File(sbDir.toString());
			
			if(dir.exists()){
				
				File arquivo = new File(sbDir.toString(),nomeArquivo);
				
				if(arquivo.exists()){
					try {
						FileInputStream abreArquivo= new FileInputStream(arquivo);
						InputStreamReader leFluxo=new InputStreamReader(abreArquivo);
						BufferedReader buffer= new BufferedReader(leFluxo);

						String linha = buffer.readLine();
						int numero;
						
						
						while(linha!=null){	
							numero = Integer.parseInt(linha);
							p1.empilha(numero);
							linha=buffer.readLine();
					    }
						buffer.close();
						leFluxo.close();
						abreArquivo.close();
						
						} catch (IOException e) {
							e.printStackTrace();
						}
				}else{
					JOptionPane.showMessageDialog(null, "Arquivo n�o pode ser encontrado!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

