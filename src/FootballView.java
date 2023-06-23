

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JButton;

public class FootballView extends JFrame implements ActionListener {

	private JPanel jpanel;

	public FootballView() {
		 init();
	 }
	public void init() {
		this.setTitle("FootballView Management");
		this.setSize(640,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		jpanel = new JPanel();
		setContentPane(jpanel);
		jpanel.setLayout(null);
		
		Font font = new Font("Arial", Font.BOLD,15);
		
		URL url_notepad= FootballView.class.getResource("bongda.png");
		Image img= Toolkit.getDefaultToolkit().createImage(url_notepad);
		this.setIconImage(img);
		
		
		//label tạo tên
		JLabel label1 = new JLabel(" CHÀO MỪNG BẠN ĐẾN VỚI HỆ THỐNG QUẢN LÍ GIẢI BÓNG ĐÁ V_LEAGUE 2022",0);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label1.setForeground(new Color(0, 0, 128));
		label1.setBackground(new Color(255, 0, 51));
		label1.setBounds(0, 10, 632, 60);
		jpanel.add(label1);
		
		//panel bên trái
		JPanel panel_trai = new JPanel();
		panel_trai.setBounds(0, 70, 225, 393);
		jpanel.add(panel_trai);
		panel_trai.setLayout(new GridLayout(6,1));
		
		JButton jbtbxh = new JButton("XẾP HẠNG");
		jbtbxh.setForeground(Color.RED);
		jbtbxh.setFont(font);
		jbtbxh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FootballView.class.getResource("bxh2.png"))));
		jbtbxh.setBackground(Color.GREEN);
		JButton jbtlich = new JButton("LỊCH THI ĐẤU");
		jbtlich.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FootballView.class.getResource("lich.png"))));
		jbtlich.setForeground(Color.RED);
		jbtlich.setFont(font);
		jbtlich.setBackground(Color.GREEN);
		JButton jbtkiem = new JButton("    ĐỘI BÓNG");	
		jbtkiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FootballView.class.getResource("search.png"))));
		jbtkiem.setForeground(Color.RED);
		jbtkiem.setFont(font);
		jbtkiem.setBackground(Color.GREEN);
		JButton jbtketqua = new JButton("    KẾT QUẢ");	
		jbtketqua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FootballView.class.getResource("ketqua.png"))));
		jbtketqua.setForeground(Color.RED);
		jbtketqua.setFont(font);
		jbtketqua.setBackground(Color.GREEN);
		JButton jbtback = new JButton("    TRỞ VỀ ");
		jbtback.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FootballView.class.getResource("back1.png"))));
		jbtback.setForeground(Color.RED);
		jbtback.setFont(font);
		jbtback.setBackground(Color.GREEN);
		JButton jbtexit = new JButton("    THOÁT");	
		jbtexit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FootballView.class.getResource("exit.png"))));
		jbtexit.setForeground(Color.RED);
		jbtexit.setFont(font);
		jbtexit.setBackground(Color.GREEN);
		panel_trai.add(jbtlich);
		panel_trai.add(jbtkiem);
		panel_trai.add(jbtbxh);
		
		panel_trai.add(jbtketqua);
		panel_trai.add(jbtback);
		panel_trai.add(jbtexit);
		jbtbxh.setFont(font);
		jbtlich.setFont(font);
		jbtkiem.setFont(font);
		jbtback.setFont(font);
		jbtexit.setFont(font);
		
		//tạo sự kiện
		jbtback.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginView loginView = new LoginView();
				setVisible(false);


			}
		});
		
		 jbtlich.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				lichthidau lich = new lichthidau();
				setVisible(false);
			}
		});

		jbtexit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
		});
		
		jbtbxh.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					new bangxephang();
					setVisible(false);
				}
		});
		
		jbtkiem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 xemthongtin tk = new xemthongtin();
					setVisible(false);
			}
		});		

		jbtketqua.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new ketqua();
					setVisible(false);
			}
		});		
		JLabel jlbhienthi = new JLabel(" ");
		jlbhienthi.setIcon(new ImageIcon(FootballView.class.getResource("quabong.jpg")));
		jlbhienthi.setBounds(224, 70, 408, 393);
		jpanel.add(jlbhienthi);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
	new FootballView();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}