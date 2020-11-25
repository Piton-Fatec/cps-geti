package cps_geti.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import cps_geti.controller.GerenciamentoCandidato;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class TelaInicialMembro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	int xx, xy;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaInicialMembro(String usuario) {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1024, 768);
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

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setForeground(new Color(47, 79, 79));
		lblTitulo.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblTitulo.setIcon(new ImageIcon(TelaInicialMembro.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblTitulo.setBounds(22, 37, 196, 92);
		contentPane.add(lblTitulo);

		JLabel lblTela = new JLabel("Candidatos Inscritos");
		lblTela.setHorizontalAlignment(SwingConstants.LEFT);
		lblTela.setForeground(new Color(47, 79, 79));
		lblTela.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 25));
		lblTela.setBounds(221, 61, 423, 41);
		contentPane.add(lblTela);

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

		String[] columnNames = { "Nome", "e-mail", "CPF", "CEP", "Situação" };
		
		GerenciamentoCandidato manageCandidato = new GerenciamentoCandidato();
		Object[][] data = manageCandidato.retonaListaFormatadaOrdenada();

		table = new JTable(data, columnNames);
		table.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 14));
		table.setBackground(new Color(255,255,255));
		table.setBounds(893, 343, -864, -137);
		table.setGridColor(new Color(153, 153, 153));
		table.setRowHeight(28);
		table.setRowSelectionAllowed(true);
		
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(190, 190, 190));
		head.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 14));
		

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(990, 428);
		scrollPane.setLocation(22, 168);
		scrollPane.setBorder(new LineBorder(new Color(170, 170, 170)));

		table.setFillsViewportHeight(true);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(644, 38, 346, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnVoltar = new JButton("Sair");
		btnVoltar.setBounds(168, 54, 78, 15);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home ti = new Home();
				ti.setUndecorated(true);
				ti.setVisible(true);
			}
		});
		btnVoltar.setForeground(new Color(102, 102, 204));
		btnVoltar.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		btnVoltar.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnVoltar.setBackground(Color.WHITE);
		
		JLabel lblUsuarioLogado = new JLabel("Olá, " + usuario + "! Seja bem-vindo!");
		lblUsuarioLogado.setBounds(122, 12, 212, 18);
		panel.add(lblUsuarioLogado);
		lblUsuarioLogado.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(49, 12, 57, 74);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(TelaInicialMembro.class.getResource("/cps_geti/view/imgs/Webp.net-resizeimage (1).png")));

		
		JButton btnConfirmar = new JButton("Confirmar Inscrição");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] rows = table.getSelectedRows();
				manageCandidato.confirmarCandidatos(rows);
				dispose();
				TelaInicialMembro tl = new TelaInicialMembro(usuario);
				tl.setUndecorated(true);
				tl.setVisible(true);
			}
		});

		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(new Color(102, 102, 204));
		btnConfirmar.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnConfirmar.setBorder(new LineBorder(new Color(102, 102, 204)));
		btnConfirmar.setBounds(799, 639, 196, 61);
		contentPane.add(btnConfirmar);
		
		
		JButton btnExcluir = new JButton("Excluir Candidatos");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] rows = table.getSelectedRows();
				manageCandidato.removerCandidatos(rows);
				dispose();
				TelaInicialMembro tl = new TelaInicialMembro(usuario);
				tl.setUndecorated(true);
				tl.setVisible(true);
			}
		});

		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnExcluir.setBorder(new LineBorder(new Color(128, 128, 128)));
		btnExcluir.setBackground(new Color(204, 102, 0));
		btnExcluir.setBounds(598, 639, 184, 61);
		contentPane.add(btnExcluir);
	}
}
