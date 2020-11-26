package cps_geti.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import cps_geti.controller.ApplicantControllerDAO;

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

public class MemberHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	int xx, xy;

	/**
	 * Create the frame.
	 */
	public MemberHome(String user) {
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

		JLabel lblImage = new JLabel("");
		lblImage.setForeground(new Color(47, 79, 79));
		lblImage.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblImage.setIcon(new ImageIcon(MemberHome.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblImage.setBounds(22, 37, 196, 92);
		contentPane.add(lblImage);

		JLabel lblTitle = new JLabel("Candidatos Inscritos");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(new Color(47, 79, 79));
		lblTitle.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 25));
		lblTitle.setBounds(221, 61, 423, 41);
		contentPane.add(lblTitle);

		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		lblClose.setForeground(new Color(178, 34, 34));
		lblClose.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 23));
		lblClose.setBounds(994, 0, 30, 32);
		contentPane.add(lblClose);

		String[] columnNames = { "Nome", "e-mail", "CPF", "CEP", "Situação" };
		
		ApplicantControllerDAO dao = new ApplicantControllerDAO();
		Object[][] data = dao.getSortedFormattedList();

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
		
		JButton btnBack = new JButton("Sair");
		btnBack.setBounds(168, 54, 78, 15);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home ti = new Home();
				ti.setUndecorated(true);
				ti.setVisible(true);
			}
		});
		
		btnBack.setForeground(new Color(102, 102, 204));
		btnBack.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		btnBack.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnBack.setBackground(Color.WHITE);
		
		JLabel lblActiveUser = new JLabel("Olá, " + user + "! Seja bem-vindo!");
		lblActiveUser.setBounds(122, 12, 212, 18);
		panel.add(lblActiveUser);
		lblActiveUser.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setBounds(49, 12, 57, 74);
		panel.add(lblUserIcon);
		lblUserIcon.setIcon(new ImageIcon(MemberHome.class.getResource("/cps_geti/view/imgs/Webp.net-resizeimage (1).png")));
		
		JButton btnConfirm = new JButton("Confirmar Inscrição");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] rows = table.getSelectedRows();
				dao.confirmApplicants(rows);
				dispose();
				MemberHome memberHome = new MemberHome(user);
				memberHome.setUndecorated(true);
				memberHome.setVisible(true);
			}
		});

		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(new Color(102, 102, 204));
		btnConfirm.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnConfirm.setBorder(new LineBorder(new Color(102, 102, 204)));
		btnConfirm.setBounds(799, 639, 196, 61);
		contentPane.add(btnConfirm);
		
		JButton btnDelete = new JButton("Excluir Candidatos");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] rows = table.getSelectedRows();
				dao.deleteApplicant(rows);
				dispose();
				MemberHome memberHome = new MemberHome(user);
				memberHome.setUndecorated(true);
				memberHome.setVisible(true);
			}
		});

		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnDelete.setBorder(new LineBorder(new Color(128, 128, 128)));
		btnDelete.setBackground(new Color(204, 102, 0));
		btnDelete.setBounds(598, 639, 184, 61);
		contentPane.add(btnDelete);
	}
}
