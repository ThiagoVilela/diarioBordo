package com.screens.aluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaAluno {

	JFrame consultaAlunoFrame;
	private JTextField nomeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaAluno window = new ConsultaAluno();
					window.consultaAlunoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultaAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		consultaAlunoFrame = new JFrame();
		consultaAlunoFrame.setBounds(100, 100, 801, 526);
		consultaAlunoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consultaAlunoFrame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Voltar para menu Aluno");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAluno window = new MenuAluno();
				window.menuAlunoFrame.setVisible(true);
				consultaAlunoFrame.dispose();
			}
		});
		button.setBounds(567, 435, 167, 23);
		consultaAlunoFrame.getContentPane().add(button);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Consultar Aluno'");
		lblVocEstEm.setBounds(44, 43, 208, 14);
		consultaAlunoFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome do aluno:");
		lblDigiteONome.setBounds(106, 145, 338, 14);
		consultaAlunoFrame.getContentPane().add(lblDigiteONome);
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		nomeField.setBounds(106, 170, 242, 20);
		consultaAlunoFrame.getContentPane().add(nomeField);
		
		JLabel encontrouLabel = new JLabel("Encontrou label");
		encontrouLabel.setBounds(454, 145, 0, 14);
		consultaAlunoFrame.getContentPane().add(encontrouLabel);
		
		JLabel alunoLabel = new JLabel("alunoLabel");
		alunoLabel.setBounds(399, 224, 0, 14);
		consultaAlunoFrame.getContentPane().add(alunoLabel);
		
		JButton buscarBotao = new JButton("Buscar");
		buscarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = nomeField.getText();
				
				for (int i = 0; i < Aplicacao.bd.getAlunos().size(); i++) {
					if (nome.equals(Aplicacao.bd.getAlunos().get(i).getNome())) {
						encontrouLabel.setText("Aluno encontrado: ");
						encontrouLabel.setBounds(454, 145, 150, 14);
						
						alunoLabel.setText(Aplicacao.bd.getAlunos().get(i).toString());
						alunoLabel.setBounds(399, 224, 200, 14);
						return;
					}
				}
				
				encontrouLabel.setText("Aluno não encontrado.");
				encontrouLabel.setBounds(454, 145, 150, 14);
				
				alunoLabel.setBounds(399, 224, 0, 14);
				return;
			}
		});
		buscarBotao.setBounds(106, 240, 89, 23);
		consultaAlunoFrame.getContentPane().add(buscarBotao);
	}

}
