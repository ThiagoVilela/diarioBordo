package com.screens.avaliacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.thiago.Aplicacao;

public class AlterarAvaliacao {

	JFrame alteraFrame;
	private JTextField buscaField;
	private JTextField pesoField;
	private JTextField nomeField;
	private JTextField mediaField;
	private JTextField turmaField;
	private JTextField dataField;
	private JTextField tipoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarAvaliacao window = new AlterarAvaliacao();
					window.alteraFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlterarAvaliacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		alteraFrame = new JFrame();
		alteraFrame.setBounds(100, 100, 800, 548);
		alteraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alteraFrame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Voltar para menu de avalia\u00E7\u00F5es");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAvaliacao window = new MenuAvaliacao();
				window.menuAvaliacaoFrame.setVisible(true);
				alteraFrame.dispose();
			}
		});
		button.setBounds(523, 460, 213, 23);
		alteraFrame.getContentPane().add(button);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Alterar Avalia\u00E7\u00E3o'");
		lblVocEstEm.setBounds(55, 44, 213, 14);
		alteraFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome da avalia\u00E7\u00E3o que deseja alterar:");
		lblDigiteONome.setBounds(123, 126, 277, 14);
		alteraFrame.getContentPane().add(lblDigiteONome);
		
		buscaField = new JTextField();
		buscaField.setBounds(123, 151, 218, 20);
		alteraFrame.getContentPane().add(buscaField);
		buscaField.setColumns(10);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(123, 147, 0, 14);
		alteraFrame.getContentPane().add(nomeLabel);
		
		JLabel pesoLabel = new JLabel("Peso");
		pesoLabel.setBounds(392, 147, 0, 14);
		alteraFrame.getContentPane().add(pesoLabel);
		
		pesoField = new JTextField();
		pesoField.setColumns(10);
		pesoField.setBounds(392, 172, 0, 20);
		alteraFrame.getContentPane().add(pesoField);
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		nomeField.setBounds(123, 172, 0, 20);
		alteraFrame.getContentPane().add(nomeField);
		
		JLabel mediaLabel = new JLabel("M\u00E9dia");
		mediaLabel.setBounds(123, 220, 0, 14);
		alteraFrame.getContentPane().add(mediaLabel);
		
		mediaField = new JTextField();
		mediaField.setColumns(10);
		mediaField.setBounds(123, 245, 0, 20);
		alteraFrame.getContentPane().add(mediaField);
		
		JLabel turmaLabel = new JLabel("Turma");
		turmaLabel.setBounds(392, 220, 0, 14);
		alteraFrame.getContentPane().add(turmaLabel);
		
		turmaField = new JTextField();
		turmaField.setColumns(10);
		turmaField.setBounds(392, 245, 0, 20);
		alteraFrame.getContentPane().add(turmaField);
		
		JLabel dataLabel = new JLabel("Data de aplica\u00E7\u00E3o (Ex: 10/01/2001)");
		dataLabel.setBounds(123, 295, 0, 14);
		alteraFrame.getContentPane().add(dataLabel);
		
		dataField = new JTextField();
		dataField.setColumns(10);
		dataField.setBounds(123, 320, 0, 20);
		alteraFrame.getContentPane().add(dataField);
		
		JLabel tipoLabel = new JLabel("Tipo");
		tipoLabel.setBounds(392, 295, 0, 14);
		alteraFrame.getContentPane().add(tipoLabel);
		
		tipoField = new JTextField();
		tipoField.setColumns(10);
		tipoField.setBounds(392, 320, 0, 20);
		alteraFrame.getContentPane().add(tipoField);
		
		JLabel erroLabel = new JLabel("New label");
		erroLabel.setBounds(457, 126, 0, 14);
		alteraFrame.getContentPane().add(erroLabel);
		
		JButton alteraBotao = new JButton("Alterar");
		alteraBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nomeField.getText().equals("") || pesoField.getText().equals("") || mediaField.getText().equals("") || turmaField.getText().equals("") || dataField.getText().equals("") || tipoField.getText().equals("")) {
					erroLabel.setText("Preencha todos os campos");
					erroLabel.setBounds(123, 400, 200, 23);
					return;
				}
				
				int posicaoTurma[] = new int[2];
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					for (int j = 0; j < Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().size(); j++) {
						if (buscaField.getText().equals(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(j).getNome())) {
							posicaoTurma[0] = i;
							posicaoTurma[1] = j;
						}
					}
				}
				
				int posicaoAvaliacao = -1;
				for (int i = 0; i < Aplicacao.bd.getAvaliacoes().size(); i++) {
					if (buscaField.getText().equals(Aplicacao.bd.getAvaliacoes().get(i).getNome())) {
						posicaoAvaliacao = i;
					}
				}
				
				String nome = nomeField.getText();
				
				double peso;
				try{
					peso = Double.parseDouble(pesoField.getText());
				}catch(NumberFormatException e1){
					erroLabel.setText("Erro no formato do peso");
					erroLabel.setBounds(123, 400, 200, 23);
					return;
				}
				
				double media;
				try{
					media = Double.parseDouble(mediaField.getText());
				}catch(NumberFormatException e2){
					erroLabel.setText("Erro no formato da media");
					erroLabel.setBounds(123, 400, 200, 23);
					return;
				}
				
				String turmaNome = turmaField.getText();
				boolean encontrou = false;
				//int newTurmaPosicao;
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (turmaNome.equals(Aplicacao.bd.getTurmas().get(i).getNome())) {
						encontrou = true;
						//newTurmaPosicao = i;
					}
				}
				
				if (!encontrou) {
					erroLabel.setText("Turma não encontrada");
					erroLabel.setBounds(123, 400, 200, 23);
					return;
				}
				
				String tipo = tipoField.getText();
				
				Date data;
				SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
				try{
					data = formataData.parse(dataField.getText());
				}catch(ParseException e3){
					erroLabel.setText("Data incorreta");
					erroLabel.setBounds(123, 400, 200, 23);
					return;
				}
				
				//Avaliacao avaliacao = new Avaliacao(nome, tipo, peso, media, data);
				
				if(posicaoAvaliacao > -1){
					Aplicacao.bd.getAvaliacoes().get(posicaoAvaliacao).setNome(nome);
					Aplicacao.bd.getAvaliacoes().get(posicaoAvaliacao).setTipo(tipo);
					Aplicacao.bd.getAvaliacoes().get(posicaoAvaliacao).setPeso(peso);
					Aplicacao.bd.getAvaliacoes().get(posicaoAvaliacao).setMedia(media);
					Aplicacao.bd.getAvaliacoes().get(posicaoAvaliacao).setDataAplicacao(data);
					
					Aplicacao.bd.getTurmas().get(posicaoTurma[0]).getAvaliacoesFormativas().get(posicaoTurma[1]).setNome(nome);
					Aplicacao.bd.getTurmas().get(posicaoTurma[0]).getAvaliacoesFormativas().get(posicaoTurma[1]).setTipo(tipo);
					Aplicacao.bd.getTurmas().get(posicaoTurma[0]).getAvaliacoesFormativas().get(posicaoTurma[1]).setPeso(peso);
					Aplicacao.bd.getTurmas().get(posicaoTurma[0]).getAvaliacoesFormativas().get(posicaoTurma[1]).setMedia(media);
					Aplicacao.bd.getTurmas().get(posicaoTurma[0]).getAvaliacoesFormativas().get(posicaoTurma[1]).setDataAplicacao(data);
					
					erroLabel.setText("Avaliação alterada com sucesso");
					erroLabel.setBounds(123, 400, 200, 23);
					
					return;
				}
				
				
			}
		});
		alteraBotao.setBounds(123, 372, 0, 23);
		alteraFrame.getContentPane().add(alteraBotao);
		
		JButton buscaBotao = new JButton("Buscar");
		buscaBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buscaField.getText().equals("")) {
					erroLabel.setBounds(457, 126, 200, 14);
					erroLabel.setText("Preencha todos os campos");
					
					lblDigiteONome.setBounds(123, 126, 277, 14);
					buscaField.setBounds(123, 151, 218, 20);
					buscaBotao.setBounds(123, 195, 89, 23);
					
					nomeLabel.setBounds(123, 147, 0, 14);
					pesoLabel.setBounds(392, 147, 0, 14);
					pesoField.setBounds(392, 172, 0, 20);
					nomeField.setBounds(123, 172, 0, 20);
					mediaLabel.setBounds(123, 220, 0, 14);
					mediaField.setBounds(123, 245, 0, 20);
					turmaLabel.setBounds(392, 220, 0, 14);
					turmaField.setBounds(392, 245, 0, 20);
					dataLabel.setBounds(123, 295, 0, 14);
					dataField.setBounds(123, 320, 0, 20);
					tipoLabel.setBounds(392, 295, 0, 14);
					tipoField.setBounds(392, 320, 0, 20);
					alteraBotao.setBounds(123, 372, 0, 23);
					return;
				}
				
				for (int i = 0; i < Aplicacao.bd.getAvaliacoes().size(); i++) {
					if (buscaField.getText().equals(Aplicacao.bd.getAvaliacoes().get(i).getNome())) {
						erroLabel.setBounds(457, 126, 0, 14);
						
						lblDigiteONome.setBounds(278, 44, 277, 14);
						buscaField.setBounds(278, 69, 218, 20);
						buscaBotao.setBounds(278, 113, 89, 23);
						
						nomeLabel.setBounds(123, 147, 46, 14);
						nomeField.setText(Aplicacao.bd.getAvaliacoes().get(i).getNome());
						nomeField.setBounds(123, 172, 212, 20);
						
						pesoLabel.setBounds(392, 147, 46, 14);
						pesoField.setText(""+ Aplicacao.bd.getAvaliacoes().get(i).getPeso());
						pesoField.setBounds(392, 172, 212, 20);
						
						mediaLabel.setBounds(123, 220, 46, 14);
						mediaField.setText("" + Aplicacao.bd.getAvaliacoes().get(i).getMedia());
						mediaField.setBounds(123, 245, 212, 20);
						
						
						int posicaoTurma = -1;
						
						for (int j = 0; j < Aplicacao.bd.getTurmas().size(); j++) {
							for (int k = 0; k < Aplicacao.bd.getTurmas().get(j).getAvaliacoesFormativas().size(); k++) {
								if (buscaField.getText().equals(Aplicacao.bd.getTurmas().get(j).getAvaliacoesFormativas().get(k).getNome())) {
									posicaoTurma = j;
								}
							}
						}
						
						if (posicaoTurma > -1) {
							turmaLabel.setBounds(392, 220, 46, 14);
							turmaField.setText(Aplicacao.bd.getTurmas().get(posicaoTurma).getNome());
							turmaField.setBounds(392, 245, 212, 20);
						} else{
							MessageDialog.openError(new Shell(), "Error", "Turma não encontrada no sistema");
							lblDigiteONome.setBounds(123, 126, 277, 14);
							buscaField.setBounds(123, 151, 218, 20);
							buscaBotao.setBounds(123, 195, 89, 23);
							
							erroLabel.setBounds(457, 126, 200, 14);
							erroLabel.setText("Erro na turma: não encontrada");
							
							nomeLabel.setBounds(123, 147, 0, 14);
							pesoLabel.setBounds(392, 147, 0, 14);
							pesoField.setBounds(392, 172, 0, 20);
							nomeField.setBounds(123, 172, 0, 20);
							mediaLabel.setBounds(123, 220, 0, 14);
							mediaField.setBounds(123, 245, 0, 20);
							turmaLabel.setBounds(392, 220, 0, 14);
							turmaField.setBounds(392, 245, 0, 20);
							dataLabel.setBounds(123, 295, 0, 14);
							dataField.setBounds(123, 320, 0, 20);
							tipoLabel.setBounds(392, 295, 0, 14);
							tipoField.setBounds(392, 320, 0, 20);
							alteraBotao.setBounds(123, 372, 0, 23);
							
							return;
						}
						
						
						SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
						String dataCampo = formatarData.format(Aplicacao.bd.getAvaliacoes().get(i).getDataAplicacao());
						
						dataLabel.setBounds(123, 295, 212, 14);
						dataField.setText(dataCampo);
						dataField.setBounds(123, 320, 212, 20);
						
						tipoLabel.setBounds(392, 295, 212, 14);
						tipoField.setText(Aplicacao.bd.getAvaliacoes().get(i).getTipo());
						tipoField.setBounds(392, 320, 212, 20);
						
						alteraBotao.setBounds(123, 372, 89, 23);
						
						return;
					}
				}
				
				lblDigiteONome.setBounds(123, 126, 277, 14);
				buscaField.setBounds(123, 151, 218, 20);
				buscaBotao.setBounds(123, 195, 89, 23);
				
				erroLabel.setBounds(457, 126, 200, 14);
				erroLabel.setText("Avaliação não encontrada");
				
				nomeLabel.setBounds(123, 147, 0, 14);
				pesoLabel.setBounds(392, 147, 0, 14);
				pesoField.setBounds(392, 172, 0, 20);
				nomeField.setBounds(123, 172, 0, 20);
				mediaLabel.setBounds(123, 220, 0, 14);
				mediaField.setBounds(123, 245, 0, 20);
				turmaLabel.setBounds(392, 220, 0, 14);
				turmaField.setBounds(392, 245, 0, 20);
				dataLabel.setBounds(123, 295, 0, 14);
				dataField.setBounds(123, 320, 0, 20);
				tipoLabel.setBounds(392, 295, 0, 14);
				tipoField.setBounds(392, 320, 0, 20);
				alteraBotao.setBounds(123, 372, 0, 23);
				
			}
		});
		buscaBotao.setBounds(123, 195, 89, 23);
		alteraFrame.getContentPane().add(buscaBotao);

	}

}
