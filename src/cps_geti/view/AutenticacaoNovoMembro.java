package cps_geti.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cps_geti.controller.GerenciamentoUsuario;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AutenticacaoNovoMembro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean validacao;
	
	private String login;
	private char[] senha;
	
	int xx, xy;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public AutenticacaoNovoMembro() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		        setLocation(x - xx, y - xy);  
			}
		});
		
		JLabel lblDigiteASenha = new JLabel("Digite a senha para cadastrar novo membro");
		lblDigiteASenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteASenha.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 16));
		lblDigiteASenha.setBounds(12, 30, 426, 54);
		contentPane.add(lblDigiteASenha);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 12));
		passwordField.setBounds(91, 98, 266, 32);
		contentPane.add(passwordField);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = String.valueOf(passwordField.getPassword());
				if (password.equals("senha")) {
					
					GerenciamentoUsuario gu = new GerenciamentoUsuario();
					
					boolean testeCriacao = gu.criarUsuario(getLogin(), getSenha());
					String msg = "Usuário existente. Tente novamente.";
					
					if (testeCriacao) {
						msg = "Usuário criado com sucesso!";
					}
					
					Dialogo dialogo = new Dialogo(msg);
					dialogo.setUndecorated(true);
					dialogo.setVisible(true);

				} else {
					Dialogo dialogo = new Dialogo("Senha incorreta!");
					dialogo.setUndecorated(true);
					dialogo.setVisible(true);
				}
				setVisible(false);
			}
		});
		btnConfirmar.setBackground(new Color(192, 192, 192));
		btnConfirmar.setBorder(new LineBorder(new Color(192, 192, 192)));
		btnConfirmar.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		btnConfirmar.setBounds(155, 168, 128, 41);
		contentPane.add(btnConfirmar);
	}
	
	public boolean getValidacao() {
		return this.validacao;
	}
	
	public void setValidacao(boolean bool) {
		this.validacao = bool;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public char[] getSenha() {
		return this.senha;
	}
	
	public void setSenha(char[] cs) {
		this.senha = cs;
	}
	
}
