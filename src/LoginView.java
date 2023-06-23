

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class LoginView extends JFrame implements ActionListener {
	JLabel lbPass;
	JTextField tfUser;
	JPasswordField tfPass;
	JButton btnLogin, btnCancel;
	JPanel pnLogin;
	JFrame frLogin;
	static JFrame f;
	static JProgressBar b;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	Connection con;
	ResultSet rs;
	Statement stm;
	public LoginView() {
		
		try {
			String UR = "jdbc:sqlserver://LAPTOP-H9PTCLCF\\\\\\\\SQLEXPRESS:1433;databaseName=DoAnJaVa;user=sa;password=sa";
			
			con = DriverManager.getConnection(UR);
			
			stm = con.createStatement();
			System.out.print("Connected");
			String sql = "SELECT*FROM Login";
			rs = stm.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
		frLogin = new JFrame("Login");
		frLogin.setBackground(Color.YELLOW);
		pnLogin = new JPanel();
		pnLogin.setBackground(Color.WHITE);
		tfUser = new JTextField(15);
		tfUser.setBounds(135, 123, 166, 25);
		pnLogin.setLayout(null);
		pnLogin.add(tfUser);

		lbPass = new JLabel("  Password",0);
		lbPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbPass.setForeground(Color.RED);
		lbPass.setBounds(23, 162, 86, 28);
		tfPass = new JPasswordField("");
		tfPass.setBounds(135, 166, 166, 26);
		pnLogin.add(lbPass);
		pnLogin.add(tfPass);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Hiển thị mật khẩu");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(139, 213, 162, 28);
		pnLogin.add(chckbxNewCheckBox);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(225, 261, 111, 28);
		
		btnLogin.addActionListener(this);
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(50, 261, 111, 28);
		btnCancel.addActionListener(this);
		pnLogin.add(btnCancel);
		pnLogin.add(btnLogin);
		frLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frLogin.getContentPane().add(pnLogin, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP",0);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(134, 52, 139, 35);
		pnLogin.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("UserName");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(33, 120, 76, 27);
		pnLogin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Administrator\\eclipse-workspace\\ảnh đồ án\\tk.PNG"));
		lblNewLabel_4.setBounds(15, 36, 86, 73);
		pnLogin.add(lblNewLabel_4);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu mnuFile = new JMenu("Help");
        menubar.add(mnuFile);
        JMenuItem mnusdt = new JMenuItem("SDT");
        JMenuItem mnuface = new JMenuItem("Facebook");
        JMenuItem mnuexit = new JMenuItem("Exit");
        mnuFile.add(mnusdt);
        mnuFile.add(mnuface);
        mnuFile.add(mnuexit);
        mnuFile.addSeparator();
        frLogin.setSize(430, 382);
		frLogin.setLocationRelativeTo(null);
		frLogin.setResizable(false);
		frLogin.setVisible(true);
		
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					tfPass.setEchoChar((char) 0);
				} else {
					tfPass.setEchoChar('*');
				}
			}
		});
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Login")) {
			String usename = tfUser.getText();
			String password = tfPass.getText();
			try {
				while(rs.next()) {
					String user = rs.getString(1);
					String pass = rs.getString(2);
					if(user.equals(usename) && pass.equals(password)) {
						 FootballView gd = new FootballView();
						 gd.setVisible(true);
						 frLogin.setVisible(false);
						 break;
					}else {
						JOptionPane.showMessageDialog(null,
								"Sai tài khoản hoặc mật khẩu");
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if (e.getActionCommand().equals("Cancel")) {
			String usename = tfUser.getText();
			String password = tfPass.getText();
			if (usename.trim().equals("") && password.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Please sign up to start program." + "If you don't have account ,"
						+ " you should contact with owner to sign up ");

			}
		}
	}
	
	public static void main(String[] args) {
		new LoginView();
	}
}