package cps_geti.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cps_geti.controller.GerenciamentoUsuario;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class TelaLoginMembro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUsuario;
	private JPasswordField campoSenha;
	
	int xx, xy;

	/**
	 * Create the frame.
	 */
	public TelaLoginMembro() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
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
		        TelaLoginMembro.this.setLocation(x - xx, y - xy);  
			}
		});
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 438, 810);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(TelaLoginMembro.class.getResource("/cps_geti/view/imgs/new-people.jpg")));
		lblImagem.setBounds(-152, -214, 603, 1187);
		panel.add(lblImagem);
		
		JLabel lblTitulo = new JLabel("Processo Seletivo -GETI");
		lblTitulo.setForeground(new Color(47, 79, 79));
		lblTitulo.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblTitulo.setIcon(new ImageIcon(TelaLoginMembro.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblTitulo.setBounds(519, 81, 411, 159);
		contentPane.add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setForeground(new Color(47, 79, 79));
		lblUsuario.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblUsuario.setBounds(519, 317, 70, 15);
		contentPane.add(lblUsuario);
		
		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		campoUsuario.setBounds(519, 344, 411, 42);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 206, 209));
		separator.setBackground(new Color(0, 206, 209));
		separator.setBounds(519, 385, 411, 2);
		contentPane.add(separator);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(47, 79, 79));
		lblSenha.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblSenha.setBounds(519, 415, 70, 15);
		contentPane.add(lblSenha);
		
		campoSenha = new JPasswordField();
		campoSenha.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 12));
		campoSenha.setBounds(519, 442, 411, 42);
		contentPane.add(campoSenha);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 206, 209));
		separator_1.setForeground(new Color(0, 206, 209));
		separator_1.setBounds(519, 484, 411, 2);
		contentPane.add(separator_1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GerenciamentoUsuario gu = new GerenciamentoUsuario();
				
				boolean testeCriacao = gu.usuarioValido(campoUsuario.getText(), campoSenha.getPassword());
				String msg = "Usuário inexistente ou senha inválida.";
				
				if (!testeCriacao) {
					Dialogo dialogo = new Dialogo(msg);
					dialogo.setUndecorated(true);
					dialogo.setVisible(true);
				} else {
					dispose();
					TelaLogin2 tl2 = new TelaLogin2(); // NOVA TELA EXEMPLO
					tl2.setUndecorated(true);
					tl2.setVisible(true);
				}
			}
		});
		
		
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(102, 102, 204));
		btnEntrar.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnEntrar.setBorder(new LineBorder(new Color(102, 102, 204)));
		btnEntrar.setBounds(531, 523, 175, 55);
		contentPane.add(btnEntrar);
		
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lbl_close.setForeground(new Color(178, 34, 34));
		lbl_close.setFont(new Font("Open Sans", Font.BOLD, 23));
		lbl_close.setBounds(994, 0, 30, 32);
		contentPane.add(lbl_close);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AutenticacaoNovoMembro auth = new AutenticacaoNovoMembro();
				auth.setLogin(campoUsuario.getText());
				auth.setSenha(campoSenha.getPassword());
				auth.setUndecorated(true);
				auth.setVisible(true);
			}
		});
		
		
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnCadastrar.setBorder(new LineBorder(new Color(128, 128, 128)));
		btnCadastrar.setBackground(new Color(128, 128, 128));
		btnCadastrar.setBounds(752, 523, 175, 55);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaInicial ti = new TelaInicial();
				ti.setUndecorated(true);
				ti.setVisible(true);
			}
		});
		btnVoltar.setForeground(new Color(102, 102, 204));
		btnVoltar.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnVoltar.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setBounds(450, 690, 138, 42);
		contentPane.add(btnVoltar);
		
		

	}
}