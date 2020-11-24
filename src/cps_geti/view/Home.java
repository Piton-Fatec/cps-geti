package cps_geti.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
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
		        Home.this.setLocation(x - xx, y - xy);  
			}
		});
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 438, 810);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(Home.class.getResource("/cps_geti/view/imgs/new-people.jpg")));
		lblImagem.setBounds(-152, -214, 603, 1187);
		panel.add(lblImagem);
		
		JLabel lblTitulo = new JLabel("Processo Seletivo -GETI");
		lblTitulo.setForeground(new Color(47, 79, 79));
		lblTitulo.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblTitulo.setIcon(new ImageIcon(Home.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblTitulo.setBounds(519, 81, 411, 159);
		contentPane.add(lblTitulo);
		
		JButton btnEntrar = new JButton("Acessar área do candidato");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(102, 102, 204));
		btnEntrar.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnEntrar.setBorder(new LineBorder(new Color(102, 102, 204)));
		btnEntrar.setBounds(608, 336, 268, 55);
		contentPane.add(btnEntrar);
		
		
		JButton btnInscrioParaO = new JButton("Inscrição para o edital");
		btnInscrioParaO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TelaInscricao ti = new TelaInscricao();
				ti.setUndecorated(true);
				ti.setVisible(true);
			}
		});
		
		
		btnInscrioParaO.setForeground(Color.WHITE);
		btnInscrioParaO.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnInscrioParaO.setBorder(new LineBorder(new Color(60, 179, 113), 5, true));
		btnInscrioParaO.setBackground(new Color(60, 179, 113));
		btnInscrioParaO.setBounds(608, 427, 268, 55);
		contentPane.add(btnInscrioParaO);
		
		JButton btnMembroCps = new JButton("Membro CPS");
		btnMembroCps.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TelaLoginMembro tl = new TelaLoginMembro();
				tl.setUndecorated(true);
				tl.setVisible(true);
			}
		});
		
		btnMembroCps.setForeground(Color.WHITE);
		btnMembroCps.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnMembroCps.setBorder(new LineBorder(new Color(95, 158, 160)));
		btnMembroCps.setBackground(new Color(95, 158, 160));
		btnMembroCps.setBounds(608, 517, 268, 55);
		contentPane.add(btnMembroCps);
		
		
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
		
		JLabel lblSejaBemvindoClique = new JLabel("Seja Bem-Vindo! Clique na opção desejada");
		lblSejaBemvindoClique.setHorizontalAlignment(SwingConstants.CENTER);
		lblSejaBemvindoClique.setForeground(new Color(47, 79, 79));
		lblSejaBemvindoClique.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblSejaBemvindoClique.setBounds(519, 252, 411, 62);
		contentPane.add(lblSejaBemvindoClique);
	}
}