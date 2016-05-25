package com.screens.avaliacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

public class ExcluirAvaliacao {

	JFrame excluirFrame;
	private JTextField buscaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirAvaliacao window = new ExcluirAvaliacao();
					window.excluirFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExcluirAvaliacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		excluirFrame = new JFrame();
		excluirFrame.setBounds(100, 100, 801, 542);
		excluirFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Voltar para menu de avalia\u00E7\u00F5es");
		button.setBounds(526, 454, 213, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAvaliacao window = new MenuAvaliacao();
				window.menuAvaliacaoFrame.setVisible(true);
				excluirFrame.dispose();
			}
		});
		excluirFrame.getContentPane().setLayout(null);
		excluirFrame.getContentPane().add(button);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Excluir Avalia\u00E7\u00E3o'");
		lblVocEstEm.setBounds(41, 44, 240, 14);
		excluirFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome da avalia\u00E7\u00E3o que deseja excluir:");
		lblDigiteONome.setBounds(118, 114, 288, 14);
		excluirFrame.getContentPane().add(lblDigiteONome);
		
		buscaField = new JTextField();
		buscaField.setBounds(118, 158, 220, 20);
		excluirFrame.getContentPane().add(buscaField);
		buscaField.setColumns(10);
		
		JLabel erroLabel = new JLabel("Erro Label");
		erroLabel.setBounds(438, 114, 0, 14);
		excluirFrame.getContentPane().add(erroLabel);
		
		JLabel avaliacaolabel = new JLabel("Turma");
		avaliacaolabel.setBounds(438, 161, 0, 133);
		excluirFrame.getContentPane().add(avaliacaolabel);
		
		JButton excluirBotao = new JButton("Excluir");
		excluirBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Aplicacao.bd.getAvaliacoes().size(); i++) {
					if (buscaField.getText().equals(Aplicacao.bd.getAvaliacoes().get(i).getNome())) {
						Aplicacao.bd.getAvaliacoes().remove(Aplicacao.bd.getAvaliacoes().get(i));
					}
				}
				
				for (int j = 0; j < Aplicacao.bd.getTurmas().size(); j++) {
					for (int i = 0; i < Aplicacao.bd.getTurmas().get(j).getAvaliacoesFormativas().size(); i++) {
						if (buscaField.getText().equals(Aplicacao.bd.getTurmas().get(j).getAvaliacoesFormativas().get(i).getNome())) {
							Aplicacao.bd.getTurmas().get(j).getAvaliacoesFormativas().remove(Aplicacao.bd.getTurmas().get(j).getAvaliacoesFormativas().get(i));
						}
					}
				}
				
				erroLabel.setText("Avaliação excluída com sucesso");
				
				erroLabel.setBounds(438, 114, 200, 14);
				avaliacaolabel.setBounds(438, 161, 0, 133);
				excluirBotao.setBounds(438, 330, 0, 23);
				
			}
		});
		excluirBotao.setBounds(438, 330, 0, 23);
		excluirFrame.getContentPane().add(excluirBotao);
		
		JButton buscaBotao = new JButton("Buscar");
		buscaBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buscaField.getText().equals("")) {
					erroLabel.setText("Preencha o campo de busca");
					
					erroLabel.setBounds(438, 114, 200, 14);
					avaliacaolabel.setBounds(438, 161, 0, 133);
					excluirBotao.setBounds(438, 330, 0, 23);
					
					return;
				}
				
				String nomeAvaliacao = buscaField.getText();
				
				for (int i = 0; i < Aplicacao.bd.getAvaliacoes().size(); i++) {
					if (nomeAvaliacao.equals(Aplicacao.bd.getAvaliacoes().get(i).getNome())) {
						erroLabel.setText("Avaliacao encontrada");
						
						erroLabel.setBounds(438, 114, 150, 14);
						
						avaliacaolabel.setText(Aplicacao.bd.getAvaliacoes().get(i).toString());
						avaliacaolabel.setBounds(438, 161, 400, 133);
						
						excluirBotao.setBounds(438, 330, 89, 23);
						return;
					}
				}
				
				erroLabel.setText("Avaliacao não encontrada");
				
				erroLabel.setBounds(438, 114, 200, 14);
				avaliacaolabel.setBounds(438, 161, 0, 133);
				excluirBotao.setBounds(438, 330, 0, 23);
				
				return;
			}
		});
		buscaBotao.setBounds(118, 204, 89, 23);
		excluirFrame.getContentPane().add(buscaBotao);
		
		
	}

}
