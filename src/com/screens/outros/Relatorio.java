package com.screens.outros;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Relatorio {

	JFrame relatorioFrame;
	private JTextField buscaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio window = new Relatorio();
					window.relatorioFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Relatorio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		relatorioFrame = new JFrame();
		relatorioFrame.setBounds(100, 100, 800, 544);
		relatorioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		relatorioFrame.getContentPane().setLayout(null);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Relat\u00F3rio Excepcional'");
		lblVocEstEm.setBounds(57, 57, 229, 14);
		relatorioFrame.getContentPane().add(lblVocEstEm);
		
		JLabel buscaLabel = new JLabel("Digite o nome da avaliacao recuperativa:");
		buscaLabel.setBounds(141, 150, 253, 14);
		relatorioFrame.getContentPane().add(buscaLabel);
		
		buscaField = new JTextField();
		buscaField.setBounds(141, 188, 188, 20);
		relatorioFrame.getContentPane().add(buscaField);
		buscaField.setColumns(10);
		
		JLabel erroLabel = new JLabel("Erro Label");
		erroLabel.setBounds(430, 150, 0, 14);
		relatorioFrame.getContentPane().add(erroLabel);
		
		JButton buscaBotao = new JButton("Buscar");
		buscaBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					for (int j = 0; j < Aplicacao.bd.getTurmas().get(i).getAvaliacoesRecuperativas().size(); j++) {
						if (buscaField.getText().equals(Aplicacao.bd.getTurmas().get(i).getAvaliacoesRecuperativas().get(j).getNome())) {
							Aplicacao.bd.getTurmas().get(i).getAvaliacoesRecuperativas().get(j).gerarRelatorioExcepcional();
							erroLabel.setText("Relatório elaborado com sucesso.");
							erroLabel.setBounds(430, 150, 200, 14);
							return;
						}
					}
				}
				
				erroLabel.setText("Avaliação não encontrada.");
				erroLabel.setBounds(430, 150, 200, 14);
				return;
			}
		});
		buscaBotao.setBounds(141, 243, 89, 23);
		relatorioFrame.getContentPane().add(buscaBotao);
		
		JButton button = new JButton("Voltar para menu de avalia\u00E7\u00F5es");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOutros window = new MenuOutros();
				window.menuFrame.setVisible(true);
				relatorioFrame.dispose();
			}
		});
		button.setBounds(526, 454, 213, 23);
		relatorioFrame.getContentPane().add(button);
		
	}

}
