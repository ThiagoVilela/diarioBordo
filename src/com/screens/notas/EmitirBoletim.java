package com.screens.notas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

public class EmitirBoletim {

	JFrame boletimFrame;
	private JTextField buscaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmitirBoletim window = new EmitirBoletim();
					window.boletimFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmitirBoletim() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		boletimFrame = new JFrame();
		boletimFrame.setBounds(100, 100, 807, 541);
		boletimFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boletimFrame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Voltar para o menu de notas");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuNotas window = new MenuNotas();
				window.menuNotasFrame.setVisible(true);
				boletimFrame.dispose();
			}
		});
		button.setBounds(545, 458, 213, 23);
		boletimFrame.getContentPane().add(button);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Emitir Boletim'");
		lblVocEstEm.setBounds(53, 44, 191, 14);
		boletimFrame.getContentPane().add(lblVocEstEm);
		
		JLabel buscaLabel = new JLabel("Digite o nome da turma desejada:");
		buscaLabel.setBounds(109, 115, 235, 14);
		boletimFrame.getContentPane().add(buscaLabel);
		
		buscaField = new JTextField();
		buscaField.setBounds(109, 155, 162, 20);
		boletimFrame.getContentPane().add(buscaField);
		buscaField.setColumns(10);
		
		JLabel erroLabel = new JLabel("Erro Label");
		erroLabel.setBounds(421, 115, 0, 14);
		boletimFrame.getContentPane().add(erroLabel);
		
		JButton btnEmitir = new JButton("Emitir");
		btnEmitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StringBuilder conteudoTurma = new StringBuilder();
				StringBuilder conteudoAluno = new StringBuilder();
				
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (buscaField.getText().equals(Aplicacao.bd.getTurmas().get(i).getNome())) {
						conteudoTurma.append("\n" + Aplicacao.bd.getTurmas().get(i).toString() + "\n\n\n");
						for (int j = 0; j < Aplicacao.bd.getTurmas().get(i).getAlunos().size(); j++) {
							conteudoAluno.append("\n" + Aplicacao.bd.getTurmas().get(i).getAlunos().get(j).toString() + "\n");
						}
						i = Aplicacao.bd.getTurmas().size();
					}
				}
				
				try{
					FileWriter leitor = new FileWriter("boletim.txt",true);
					BufferedWriter buffer = new BufferedWriter(leitor);
					
					buffer.write(conteudoTurma.toString());
					buffer.newLine();
					
					buffer.flush();
					buffer.close();
					
					//System.out.println(conteudo);
					erroLabel.setText("Boletim emitido com sucesso.");
					erroLabel.setBounds(421, 115, 200, 14);
					btnEmitir.setBounds(421, 211, 0, 23);
				}catch(Exception e1){
					e1.printStackTrace();
					erroLabel.setText("Erro na emissão do boletim.");
					erroLabel.setBounds(421, 115, 200, 14);
					return;
				}
				
				try{
					FileWriter leitor = new FileWriter("boletim.txt",true);
					BufferedWriter buffer = new BufferedWriter(leitor);
					
					buffer.write(conteudoAluno.toString());
					buffer.newLine();
					
					buffer.flush();
					buffer.close();
					
					//System.out.println(conteudo);
					erroLabel.setText("Boletim emitido com sucesso.");
					erroLabel.setBounds(421, 115, 200, 14);
					btnEmitir.setBounds(421, 211, 0, 23);
					return;
				}catch(Exception e1){
					e1.printStackTrace();
					erroLabel.setText("Erro na emissão do boletim.");
					erroLabel.setBounds(421, 115, 200, 14);
					return;
				}
			}
		});
		btnEmitir.setBounds(372, 211, 0, 23);
		boletimFrame.getContentPane().add(btnEmitir);
		
		JButton buscaBotao = new JButton("Buscar");
		buscaBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buscaField.getText().equals("")) {
					erroLabel.setText("Preencha o campo de Turma.");
					erroLabel.setBounds(421, 115, 200, 14);
					return;
				}
				
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (buscaField.getText().equals(Aplicacao.bd.getTurmas().get(i).getNome())) {
						btnEmitir.setBounds(421, 211, 89, 23);
						erroLabel.setText("Turma encontrada: " + Aplicacao.bd.getTurmas().get(i).getNome());
						erroLabel.setBounds(421, 115, 200, 14);
						return;
					}
				}
				
				erroLabel.setText("Turma não encontrada.");
				erroLabel.setBounds(421, 115, 200, 14);
				
				btnEmitir.setBounds(421, 211, 0, 23);
				return;
			}
		});
		buscaBotao.setBounds(109, 211, 89, 23);
		boletimFrame.getContentPane().add(buscaBotao);
		
		
		
		
	}

}
