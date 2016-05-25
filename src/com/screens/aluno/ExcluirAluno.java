package com.screens.aluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

public class ExcluirAluno {

	JFrame excluirAlunoFrame;
	private JTextField alunoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirAluno window = new ExcluirAluno();
					window.excluirAlunoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExcluirAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		excluirAlunoFrame = new JFrame();
		excluirAlunoFrame.setBounds(100, 100, 805, 534);
		excluirAlunoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		excluirAlunoFrame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Voltar para menu Aluno");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAluno window = new MenuAluno();
				window.menuAlunoFrame.setVisible(true);
				excluirAlunoFrame.dispose();
			}
		});
		button.setBounds(572, 444, 167, 23);
		excluirAlunoFrame.getContentPane().add(button);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Excluir Aluno'");
		lblVocEstEm.setBounds(81, 46, 192, 14);
		excluirAlunoFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome do aluno");
		lblDigiteONome.setBounds(145, 149, 197, 14);
		excluirAlunoFrame.getContentPane().add(lblDigiteONome);
		
		alunoField = new JTextField();
		alunoField.setBounds(145, 187, 197, 20);
		excluirAlunoFrame.getContentPane().add(alunoField);
		alunoField.setColumns(10);
		
		JLabel encontradoLabel = new JLabel("Aluno encontrado");
		encontradoLabel.setBounds(442, 149, 0, 14);
		excluirAlunoFrame.getContentPane().add(encontradoLabel);
		
		JLabel alunoEncontradoLabel = new JLabel("Texto Aluno");
		alunoEncontradoLabel.setBounds(442, 190, 0, 70);
		excluirAlunoFrame.getContentPane().add(alunoEncontradoLabel);
		
		JButton excluirBotao = new JButton("Excluir");
		excluirBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < Aplicacao.bd.getAlunos().size(); i++) {
					if (alunoField.getText().equals(Aplicacao.bd.getAlunos().get(i).getNome())) {
						Aplicacao.bd.getAlunos().remove(Aplicacao.bd.getAlunos().get(i));
						encontradoLabel.setText("Aluno excluído com sucesso.");
						
						alunoEncontradoLabel.setBounds(442, 190, 0, 70);
						excluirBotao.setBounds(442, 292, 0, 23);
					}
				}
				
			}
		});
		excluirBotao.setBounds(442, 292, 0, 23);
		excluirAlunoFrame.getContentPane().add(excluirBotao);
		
		JButton buscarBotao = new JButton("Buscar");
		buscarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < Aplicacao.bd.getAlunos().size(); i++) {
					if (alunoField.getText().equals(Aplicacao.bd.getAlunos().get(i).getNome())) {
						encontradoLabel.setText("Aluno encontrado");
						encontradoLabel.setBounds(442, 149, 250, 14);
						
						alunoEncontradoLabel.setBounds(442, 190, 250, 70);
						excluirBotao.setBounds(442, 292, 89, 23);
						
						for (int j = 0; j < Aplicacao.bd.getTurmas().size(); j++) {
							if (Aplicacao.bd.getAlunos().get(i).getTurma().getNome().equals(Aplicacao.bd.getTurmas().get(j).getNome())) {
								Aplicacao.bd.getTurmas().get(j).getAlunos().remove(Aplicacao.bd.getAlunos().get(i));
								return;
							}
						}
						
						return;
					}
				}
				
				encontradoLabel.setText("Aluno não encontrado");
				encontradoLabel.setBounds(442, 149, 250, 14);
				
				alunoEncontradoLabel.setBounds(442, 190, 0, 70);
				excluirBotao.setBounds(442, 292, 0, 23);
				
			}
		});
		buscarBotao.setBounds(145, 237, 89, 23);
		excluirAlunoFrame.getContentPane().add(buscarBotao);
	}

}
