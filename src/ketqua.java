

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class ketqua extends JFrame {
		private JLabel jLabel_tieude3;
		private JTable table;
		private final JLabel lblNewLabel = new JLabel("");
		private JTextField jtf_1;
		private JTextField jtf_2;
		private JTextField jtf_tran;
		private JComboBox comboBox_2;
		private JComboBox comboBox_1;
		public ketqua() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(ketqua.class.getResource("/GUI/anhnen.jpg")));
			this.setTitle("Kết quả thi đấu");
			this.setSize(800,600);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			
			JMenuBar jmnbar= new JMenuBar();//có 2 menu con
			
			//tạo 1 menu
			JMenu jmnbar_file= new JMenu("File");
			//có 2 item là open và exit
			
			
			JMenuItem jmnItem_back= new JMenuItem("Back");
			jmnItem_back.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(lichthidau.class.getResource("back.png"))));
			jmnbar_file.addSeparator();//gach ngang
			jmnbar_file.add(jmnItem_back);

			//tạo menu thứ 2
			JMenu jmnbar_help= new JMenu("Help");
			//có 1 item là welcpme
			JMenuItem jmnItem_Sdt= new JMenuItem("SDT");
			jmnbar_help.add(jmnItem_Sdt);
			JMenuItem jmnItem_fb= new JMenuItem("Facebook");
			jmnbar_help.add(jmnItem_fb);
			
			jmnbar.add(jmnbar_file);
			jmnbar.add(jmnbar_help);
			
			//Thêm thanh menu vào chương trình
			this.setJMenuBar(jmnbar);
			
			jmnItem_Sdt.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "My Phone :0377129456");
				}
	        	
	        });
			jmnItem_fb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null,"Nick Facebook : https://www.facebook.com/profile.php?id=100010321987722");
				}
	        	
	        });
			
			jLabel_tieude3 = new JLabel("KẾT QUẢ THI ĐẤU",0);
			jLabel_tieude3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JPanel jPanel_north = new JPanel();
			jPanel_north.setBackground(Color.GRAY);
			getContentPane().add(jPanel_north, BorderLayout.NORTH);
			jPanel_north.setLayout(new BorderLayout());
			String doibong [] = { "Becamex Bình Dương","Aston Villa","Man Unt","Man City","Norwich","Liverpool","Nam Định","Viettel","Man Utd","Than Quang Ninh","Tottenham"
					,"Quang Tri FC","Barcelona","Chealse","Paris Saint Germain","Hà Nội FC", "Hoàng Anh Gia Lai", "FLC Thanh Hóa", "Sông Lam Nghệ An", "SHB Đà Nẵng", "Vettel"};
			
			JPanel panel_kq = new JPanel();    //  phần ket quả
			jPanel_north.add(panel_kq, BorderLayout.NORTH);
			panel_kq.setLayout(new GridLayout(1,7));
			
			JLabel jLabel_1 = new JLabel("Đội 1",0);
			jLabel_1.setForeground(Color.RED);
			jLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			panel_kq.add(jLabel_1);
			comboBox_1 = new JComboBox(doibong);	
			panel_kq.add(comboBox_1);
			
			JLabel lblNewLabel_4 = new JLabel("");
			panel_kq.add(lblNewLabel_4);
			
			JLabel lblNewLabel_16 = new JLabel("Trận thứ :",0);
			lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_16.setForeground(Color.RED);
			panel_kq.add(lblNewLabel_16);
			
			JLabel lblNewLabel_2 = new JLabel("");
			panel_kq.add(lblNewLabel_2);
			comboBox_2 = new JComboBox(doibong);
			panel_kq.add(comboBox_2);
			JLabel jLabel_2 = new JLabel("Đội 2",0);
			jLabel_2.setForeground(Color.RED);
			jLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			panel_kq.add(jLabel_2);
			
			JPanel panel_button = new JPanel();  // phần panel các button
			jPanel_north.add(panel_button, BorderLayout.CENTER);
			panel_button.setLayout(new GridLayout(4,3));
			
			JLabel lblNewLabel_1 = new JLabel("");
			panel_button.add(lblNewLabel_1);
			
			JLabel lblNewLabel_7 = new JLabel("");
			panel_button.add(lblNewLabel_7);
			jtf_tran = new JTextField(20);
			panel_button.add(jtf_tran);
			
			JLabel lblNewLabel_11 = new JLabel("");
			panel_button.add(lblNewLabel_11);
			
			JLabel lblNewLabel_8 = new JLabel("");
			panel_button.add(lblNewLabel_8);
			
			JLabel lblNewLabel_5 = new JLabel("Bàn thắng đội 1",0);
			lblNewLabel_5.setForeground(Color.RED);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel_button.add(lblNewLabel_5);
			
			jtf_1 = new JTextField();
			panel_button.add(jtf_1);
			jtf_1.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("");
			panel_button.add(lblNewLabel_3);
			jtf_2 = new JTextField(20);
			panel_button.add(jtf_2);
			
			JLabel lblNewLabel_9 = new JLabel("Bàn thắng đội 2",0);
			lblNewLabel_9.setForeground(Color.RED);
			lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel_button.add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("");
			panel_button.add(lblNewLabel_10);
			
			JButton jbt_them = new JButton("      Thêm      ");
			jbt_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ketqua.class.getResource("add.png"))));
			jbt_them.setBackground(Color.CYAN);
			jbt_them.setForeground(Color.BLUE);
			panel_button.add(jbt_them);		
			JButton jbt_sua = new JButton("Sửa");
			jbt_sua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ketqua.class.getResource("fix.png"))));
			jbt_sua.setForeground(Color.BLUE);
			jbt_sua.setBackground(Color.CYAN);
			panel_button.add(jbt_sua);	
			JButton jbt_xoa = new JButton("      Xóa      ");
			jbt_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ketqua.class.getResource("delete.png"))));
			jbt_xoa.setForeground(Color.BLUE);
			jbt_xoa.setBackground(Color.CYAN);
			panel_button.add(jbt_xoa);		
			
			JLabel lblNewLabel_12 = new JLabel("");
			panel_button.add(lblNewLabel_12);
			panel_button.add(lblNewLabel);
			
			JLabel lblNewLabel_6 = new JLabel("");
			panel_button.add(lblNewLabel_6);
			
			JLabel lblNewLabel_13 = new JLabel("");
			panel_button.add(lblNewLabel_13);
			
			JLabel lblNewLabel_14 = new JLabel("");
			panel_button.add(lblNewLabel_14);
			
			JLabel lblNewLabel_15 = new JLabel("");
			panel_button.add(lblNewLabel_15);
			

			JPanel panel_giua = new JPanel();
			panel_giua.setBackground(Color.ORANGE);
			getContentPane().add(panel_giua, BorderLayout.CENTER);
			
			table = new JTable();
			table.setBackground(Color.PINK);
			table.setForeground(Color.BLACK);
			panel_giua.add(table, BorderLayout.CENTER);
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Trận thứ","Đội 1", "Bàn thắng đội 1",  "Bàn thắng đội 2","Đội 2" }));
			JScrollPane sc= new JScrollPane(table);
			sc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			
			table.addMouseListener(new MouseListener() {

				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					jtf_tran.setText((String)table.getValueAt(row,0));
					comboBox_1.setSelectedItem(table.getValueAt(table.getSelectedRow(),1)+"");	
					jtf_1.setText((String)table.getValueAt(row,2));
					jtf_2.setText((String)table.getValueAt(row,3));
					comboBox_2.setSelectedItem(table.getValueAt(table.getSelectedRow(),4)+"");		
				}
				public void mousePressed(MouseEvent e) {
				}
			
				public void mouseReleased(MouseEvent e) {
				}
		
				public void mouseEntered(MouseEvent e) {
				}
		
				public void mouseExited(MouseEvent e) {
				}
			});
				Connectdoan dbcon = new Connectdoan();
				ResultSet rs1 = dbcon.getAllFromKETQUA();
				Statement stmt = Connectdoan.getStmt();
				
				try {
					while(rs1.next()) {
						DefaultTableModel model_table = (DefaultTableModel) table.getModel();
						model_table.addRow(new String[]{rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5)});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jbt_them.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model_table = (DefaultTableModel) table.getModel();
						model_table.addRow(new String[] { jtf_tran.getText(), comboBox_1.getSelectedItem().toString(), jtf_1.getText(),jtf_2.getText(),
								 comboBox_2.getSelectedItem().toString()});		
						
						try {
							stmt.executeUpdate("insert into KETQUA values (\'"+jtf_tran.getText()+"\',\'"+comboBox_1.getSelectedItem().toString()
									+"\',\'"+jtf_1.getText()+"\',\'"+jtf_2.getText()+"\',\'"+comboBox_2.getSelectedItem().toString()+"\')");
							JOptionPane.showMessageDialog(null, " Thêm thành công");
						}catch(SQLException e1) {
							System.out.print(e1);
							JOptionPane.showMessageDialog(null, " Thêm không thành công");
						}	
						jtf_tran.setText("");
						comboBox_1.getSelectedItem().toString();
						jtf_1.setText("");
						jtf_2.setText("");
						comboBox_2.getSelectedItem().toString();					
						
			}
		});		
				jbt_sua.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						int row = table.getSelectedRow();
						DefaultTableModel model_table = (DefaultTableModel)table.getModel();
						model_table.removeRow( row );
						model_table.addRow(new String[] { jtf_tran.getText(), comboBox_1.getSelectedItem().toString(), jtf_1.getText(),jtf_2.getText(),
								 comboBox_2.getSelectedItem().toString()});		
						
						try {
							
							stmt.executeUpdate("update KETQUA set doi1= \'"+comboBox_1.getSelectedItem().toString()+"\'"
									+ ",banthang1= \'"+jtf_1.getText()+"\',banthang2= \'"+jtf_2.getText()+"\',"
									+ "doi2= \'"+comboBox_2.getSelectedItem().toString()+"\'"+ "where trandau= \'"+jtf_tran.getText()+"\'");
							JOptionPane.showMessageDialog(null, " Sửa thành công");
						}catch(SQLException e2) {
							JOptionPane.showMessageDialog(null, " Sửa không thành công");

						}
						jtf_tran.setText("");
						comboBox_1.getSelectedItem().toString();
						jtf_1.setText("");
						jtf_2.setText("");
						comboBox_2.getSelectedItem().toString();					
						
					}	
				});
				jbt_xoa.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						int row = table.getSelectedRow();
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						model.removeRow( row );					
								try {
									stmt.executeUpdate("delete from KETQUA where (trandau = \'"+jtf_tran.getText()+"\')");
									JOptionPane.showMessageDialog(null, " Xóa thành công");
								}catch(SQLException e1) {
									System.out.print(e1);
									JOptionPane.showMessageDialog(null, " Xóa không thành công");
								}
								jtf_tran.setText("");
								comboBox_1.getSelectedItem().toString();
								jtf_1.setText("");
								comboBox_2.getSelectedItem().toString();					
								jtf_2.setText("");
							}
				});
			
			panel_giua.add(sc);
			jmnItem_back.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new FootballView();
					setVisible(false);
				}
			});
			this.setVisible(true);
		}
		public static void main(String[] args) {
			new ketqua();
		}
}