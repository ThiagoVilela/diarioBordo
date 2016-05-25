package com.screens.avaliacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

public class ConsultaAvaliacao {

	JFrame consultaFrame;
	private JTextField buscaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaAvaliacao window = new ConsultaAvaliacao();
					window.consultaFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultaAvaliacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		consultaFrame = new JFrame();
		consultaFrame.setBounds(100, 100, 801, 551);
		consultaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consultaFrame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Voltar para menu de avalia\u00E7\u00F5es");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAvaliacao window = new MenuAvaliacao();
				window.menuAvaliacaoFrame.setVisible(true);
				consultaFrame.dispose();
			}
		});
		button.setBounds(521, 458, 213, 23);
		consultaFrame.getContentPane().add(button);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Consultar Avaliac\u00F5es'");
		lblVocEstEm.setBounds(62, 53, 228, 14);
		consultaFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome da prova que deseja consultar:");
		lblDigiteONome.setBounds(137, 173, 300, 14);
		consultaFrame.getContentPane().add(lblDigiteONome);
		
		buscaField = new JTextField();
		buscaField.setBounds(137, 224, 213, 20);
		consultaFrame.getContentPane().add(buscaField);
		buscaField.setColumns(10);
		
		JLabel encontrouLabel = new JLabel("New label");
		encontrouLabel.setBounds(443, 173, 0, 14);
		consultaFrame.getContentPane().add(encontrouLabel);
		
		JLabel encontradaLabel = new JLabel("New label");
		encontradaLabel.setBounds(443, 227, 0, 81);
		consultaFrame.getContentPane().add(encontradaLabel);
		
		JButton buscaBotao = new JButton("Buscar");
		buscaBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buscaField.getText().equals("")){
					encontrouLabel.setText("Preencha o campo de busca");
					encontrouLabel.setBounds(443, 173, 240, 14);
					encontradaLabel.setBounds(443, 227, 0, 81);
					return;
				}
				
				String nomeAvaliacao = buscaField.getText();
				
				for (int i = 0; i < Aplicacao.bd.getAvaliacoes().size(); i++) {
					if (nomeAvaliacao.equals(Aplicacao.bd.getAvaliacoes().get(i).getNome())) {
						encontrouLabel.setText("Avaliacao encontrada");
						encontrouLabel.setBounds(443, 173, 150, 14);
						
						encontradaLabel.setText(Aplicacao.bd.getAvaliacoes().get(i).toString());
						encontradaLabel.setBounds(443, 227, 300, 81);
						return;
					}
				}
				
				encontrouLabel.setText("Avaliacao não encontrada");
				encontrouLabel.setBounds(443, 173, 150, 14);
				encontradaLabel.setBounds(443, 227, 0, 81);
				return;
			}
		});
		buscaBotao.setBounds(137, 285, 89, 23);
		consultaFrame.getContentPane().add(buscaBotao);
		
	}
}
