package cps_geti.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cps_geti.bd.GerenciamentoUsuario;

import java.awt.Color;
import java.awt.Button;
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


public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUsuario;
	private JPasswordField campoSenha;
	
	int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
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
		        TelaLogin.this.setLocation(x - xx, y - xy);  
			}
		});
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 438, 810);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(TelaLogin.class.getResource("/cps_geti/view/imgs/new-people.jpg")));
		lblImagem.setBounds(-152, -214, 603, 1187);
		panel.add(lblImagem);
		
		JLabel lblTitulo = new JLabel("Processo Seletivo -GETI");
		lblTitulo.setForeground(new Color(47, 79, 79));
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblTitulo.setIcon(new ImageIcon(TelaLogin.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblTitulo.setBounds(519, 81, 411, 159);
		contentPane.add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setForeground(new Color(47, 79, 79));
		lblUsuario.setFont(new Font("Open Sans", Font.BOLD, 15));
		lblUsuario.setBounds(519, 317, 70, 15);
		contentPane.add(lblUsuario);
		
		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Open Sans", Font.PLAIN, 13));
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
		lblSenha.setFont(new Font("Open Sans", Font.BOLD, 15));
		lblSenha.setBounds(519, 415, 70, 15);
		contentPane.add(lblSenha);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(519, 442, 411, 42);
		contentPane.add(campoSenha);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 206, 209));
		separator_1.setForeground(new Color(0, 206, 209));
		separator_1.setBounds(519, 484, 411, 2);
		contentPane.add(separator_1);
		
		Button btnEntrar = new Button("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GerenciamentoUsuario gu = new GerenciamentoUsuario();
				
				boolean testeCriacao = gu.usuarioValido(campoUsuario.getText(), campoSenha.getPassword());
				String msg = "Usuário inexistente ou senha inválida.";
				
				if (!testeCriacao) {
					Sucesso sucesso = new Sucesso(msg);
					sucesso.setUndecorated(true);
					sucesso.setVisible(true);
				} else {
					setVisible(false);
					TelaLogin2 tl2 = new TelaLogin2(); // NOVA TELA EXEMPLO
					tl2.setUndecorated(true);
					tl2.setVisible(true);
				}
			}
		});
		
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Open Sans", Font.PLAIN, 18));
		btnEntrar.setBackground(new Color(70, 130, 180));
		btnEntrar.setActionCommand("");
		btnEntrar.setBounds(537, 540, 175, 55);
		contentPane.add(btnEntrar);
	
		Button btnCadastrar = new Button("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GerenciamentoUsuario gu = new GerenciamentoUsuario();
				
				boolean testeCriacao = gu.criarUsuario(campoUsuario.getText(), campoSenha.getPassword());
				String msg = "Usuário existente. Tente novamente.";
				
				if (testeCriacao) {
					msg = "Usuário criado com sucesso!";
				}
				
				Sucesso sucesso = new Sucesso(msg);
				sucesso.setUndecorated(true);
				sucesso.setVisible(true);
				
			}
		});
		
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnCadastrar.setBackground(new Color(119, 136, 153));
		btnCadastrar.setActionCommand("");
		btnCadastrar.setBounds(757, 540, 175, 55);
		contentPane.add(btnCadastrar);
		
		
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

	}
}