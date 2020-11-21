package cps_geti.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import cps_geti.model.Candidato;

public class TelaInscricao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNome;
	
	int xx, xy;
	private JTextField campoEmail;
	private JTextField campoCEP;
	private JTextField campoCPF;

	/**
	 * Create the frame.
	 */
	public TelaInscricao() {
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
		        setLocation(x - xx, y - xy);  
			}
		});
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 438, 810);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(TelaInscricao.class.getResource("/cps_geti/view/imgs/new-people.jpg")));
		lblImagem.setBounds(-152, -214, 603, 1187);
		panel.add(lblImagem);
		
		JLabel lblTitulo = new JLabel("Processo Seletivo -GETI");
		lblTitulo.setForeground(new Color(47, 79, 79));
		lblTitulo.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblTitulo.setIcon(new ImageIcon(TelaInscricao.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblTitulo.setBounds(519, 81, 411, 159);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(47, 79, 79));
		lblNome.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblNome.setBounds(519, 239, 70, 15);
		contentPane.add(lblNome);
		
		campoNome = new JTextField();
		campoNome.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		campoNome.setBounds(519, 268, 411, 42);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setForeground(new Color(47, 79, 79));
		lblEmail.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblEmail.setBounds(519, 322, 70, 15);
		contentPane.add(lblEmail);
		
		
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
		

		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		campoEmail.setColumns(10);
		campoEmail.setBounds(519, 349, 411, 42);
		contentPane.add(campoEmail);
		
		campoCEP = new JTextField();
		campoCEP.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		campoCEP.setColumns(10);
		campoCEP.setBounds(519, 431, 185, 42);
		contentPane.add(campoCEP);
		
		campoCPF = new JTextField();
		campoCPF.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		campoCPF.setColumns(10);
		campoCPF.setBounds(752, 431, 185, 42);
		contentPane.add(campoCPF);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setForeground(new Color(47, 79, 79));
		lblCep.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblCep.setBounds(519, 403, 70, 15);
		contentPane.add(lblCep);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(new Color(47, 79, 79));
		lblCpf.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblCpf.setBounds(752, 403, 70, 15);
		contentPane.add(lblCpf);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AutenticacaoNovoCandidato auth = new AutenticacaoNovoCandidato();
				auth.setCandidato(new Candidato(
						campoNome.getText(),
						campoEmail.getText(),
						campoCPF.getText(),
						campoCEP.getText()));
				auth.setUndecorated(true);
				auth.setVisible(true);
			}
		});
		
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnCadastrar.setBorder(new LineBorder(new Color(128, 128, 128)));
		btnCadastrar.setBackground(new Color(46, 139, 87));
		btnCadastrar.setBounds(647, 535, 175, 55);
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