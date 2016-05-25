package com.screens.outros;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;
import com.thiago.AvaliacaoRecuperativa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddAvaliacaoRec {

	JFrame addFrame;
	private JTextField nomeField;
	private JTextField mediaField;
	private JTextField pesoField;
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
					AddAvaliacaoRec window = new AddAvaliacaoRec();
					window.addFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddAvaliacaoRec() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addFrame = new JFrame();
		addFrame.setBounds(100, 100, 802, 550);
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrame.getContentPane().setLayout(null);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Adicionar Avalia\u00E7\u00E3o Recuperativa'");
		lblVocEstEm.setBounds(63, 53, 404, 14);
		addFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblDigiteOContedo = new JLabel("Preencha os campos abaixos com os dados indicados:");
		lblDigiteOContedo.setBounds(133, 128, 322, 14);
		addFrame.getContentPane().add(lblDigiteOContedo);
		
		nomeField = new JTextField();
		nomeField.setBounds(133, 199, 212, 20);
		addFrame.getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(133, 174, 46, 14);
		addFrame.getContentPane().add(nomeLabel);
		
		JLabel mediaLabel = new JLabel("M\u00E9dia");
		mediaLabel.setBounds(133, 247, 46, 14);
		addFrame.getContentPane().add(mediaLabel);
		
		mediaField = new JTextField();
		mediaField.setColumns(10);
		mediaField.setBounds(133, 272, 212, 20);
		addFrame.getContentPane().add(mediaField);
		
		JLabel pesoLabel = new JLabel("Peso");
		pesoLabel.setBounds(402, 174, 46, 14);
		addFrame.getContentPane().add(pesoLabel);
		
		pesoField = new JTextField();
		pesoField.setColumns(10);
		pesoField.setBounds(402, 199, 212, 20);
		addFrame.getContentPane().add(pesoField);
		
		JLabel turmaLabel = new JLabel("Turma");
		turmaLabel.setBounds(402, 247, 46, 14);
		addFrame.getContentPane().add(turmaLabel);
		
		turmaField = new JTextField();
		turmaField.setColumns(10);
		turmaField.setBounds(402, 272, 212, 20);
		addFrame.getContentPane().add(turmaField);
		
		JLabel erroLabel = new JLabel("Por favor, preencha todos os campos");
		erroLabel.setBounds(345, 403, 0, 14);
		addFrame.getContentPane().add(erroLabel);
		
		JLabel dataLabel = new JLabel("Data de aplica\u00E7\u00E3o (Ex: 10/01/2001)");
		dataLabel.setBounds(133, 322, 212, 14);
		addFrame.getContentPane().add(dataLabel);
		
		dataField = new JTextField();
		dataField.setColumns(10);
		dataField.setBounds(133, 347, 212, 20);
		addFrame.getContentPane().add(dataField);
		
		JLabel tipoLabel = new JLabel("Tipo");
		tipoLabel.setBounds(402, 322, 212, 14);
		addFrame.getContentPane().add(tipoLabel);
		
		tipoField = new JTextField();
		tipoField.setColumns(10);
		tipoField.setBounds(402, 347, 212, 20);
		addFrame.getContentPane().add(tipoField);
		
		JButton addBotao = new JButton("Adicionar");
		addBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nomeField.getText().equals("") || pesoField.getText().equals("") || mediaField.getText().equals("") || turmaField.getText().equals("") || dataField.getText().equals("")) {
					erroLabel.setText("Por favor, preencha todos os campos acima.");
					erroLabel.setBounds(345, 403, 300, 14);
					return;
				}
				
				String nome = nomeField.getText();
				
				double peso, media;
				
				try{
					peso = Double.parseDouble(pesoField.getText());
				}catch(NumberFormatException e1){
					erroLabel.setText("Erro no peso da avaliação.");
					erroLabel.setBounds(345, 403, 300, 14);
					return;
				}
				
				try{
					media = Double.parseDouble(mediaField.getText());
				}catch(NumberFormatException e2){
					erroLabel.setText("Erro na média da avaliação");
					erroLabel.setBounds(345, 403, 300, 14);
					return;
				}
				
				String nomeTurma = turmaField.getText();
				boolean encontrouTurma = false;
				int posicaoTurma = -1;
				
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (nomeTurma.equals(Aplicacao.bd.getTurmas().get(i).getNome())) {
						encontrouTurma = true;
						posicaoTurma = i;
						i = Aplicacao.bd.getTurmas().size();
					}
				}
				
				if (!encontrouTurma) {
					erroLabel.setText("Turma não encontrada.");
					erroLabel.setBounds(345, 403, 300, 14);
					return;
				}
				
				Date date;
				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				try {
					date = data.parse(dataField.getText());
				} catch (ParseException e3) {
					erroLabel.setText("Erro na data inserida");
					erroLabel.setBounds(345, 403, 300, 14);
					return;
				}
				
				String tipo = tipoField.getText();
				
				AvaliacaoRecuperativa avaliacao = new AvaliacaoRecuperativa(nome,tipo,peso,media,date);
				
				Aplicacao.bd.getTurmas().get(posicaoTurma).getAvaliacoesRecuperativas().add(avaliacao);
				Aplicacao.bd.getAvaliacoes().add(avaliacao);
				
				erroLabel.setText("Avaliação cadastrada com sucesso.");
				erroLabel.setBounds(345, 403, 300, 14);
				
				return;
			}
		});
		addBotao.setBounds(133, 399, 89, 23);
		addFrame.getContentPane().add(addBotao);
		
		JButton btnVoltarParaMenu = new JButton("Voltar para menu de avalia\u00E7\u00F5es");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOutros window = new MenuOutros();
				window.menuFrame.setVisible(true);
				addFrame.dispose();
			}
		});
		btnVoltarParaMenu.setBounds(520, 456, 213, 23);
		addFrame.getContentPane().add(btnVoltarParaMenu);
		
	}
}
