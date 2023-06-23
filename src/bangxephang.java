



import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import javax.swing.JComboBox;

public class bangxephang extends JFrame {
		private JTable table;
		private JButton jbt_xoa;
		private JButton jbt_them;
		private JButton jbt_sua;
		private JButton jbt_timkiem;
		private JTextField jtf_timkiem;
		private JButton jbt_huytim;
		private DefaultTableModel model;
		private JTextField jtf_tran;
		private JTextField jtf_xephang;
		private JTextField jtf_hieuso;
		private JTextField jtf_thang;
		private JTextField jtf_hoa;
		private JTextField jtf_thua;
		private JTextField jtf_diem;
		
		public void Timkiem(String str) {
			model=(DefaultTableModel)table.getModel();
			TableRowSorter<DefaultTableModel> ts= new TableRowSorter<>(model);
			table.setRowSorter(ts);
			ts.setRowFilter(RowFilter.regexFilter(str));
		}
		public bangxephang() {
			this.setTitle("Search");
			this.setSize(1000,600);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			
			Connectdoan dbcon = new Connectdoan();
			ResultSet rs = dbcon.getAllFromBANGXEPHANG();
			Statement stmt = Connectdoan.getStmt();
			
			JMenuBar jmnbar= new JMenuBar();//có 2 menu con
			
			//tạo 1 menu
			JMenu jmnbar_file= new JMenu("File");
			//có 2 item là open và exit
			
			
			JMenuItem jmnItem_back= new JMenuItem("Back");
			jmnItem_back.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(bangxephang.class.getResource("back.png"))));
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
				
			//jpn bên trái
			JPanel panel_trai = new JPanel();
			getContentPane().add(panel_trai, BorderLayout.WEST);
			panel_trai.setLayout(new BorderLayout());
				
			JPanel panel_nutlenh = new JPanel();
			panel_trai.add(panel_nutlenh, BorderLayout.SOUTH);
			panel_nutlenh.setLayout(new GridLayout(3,3));
			jbt_them = new JButton("  Thêm   ");
			jbt_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FootballView.class.getResource("add.png"))));
			jbt_them.setBackground(Color.CYAN);
			jbt_them.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel_nutlenh.add(jbt_them);		
			jbt_sua = new JButton("Sửa");
			jbt_sua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FootballView.class.getResource("fix.png"))));
			jbt_sua.setBackground(Color.CYAN);
			jbt_sua.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel_nutlenh.add(jbt_sua);		
			jbt_xoa = new JButton("Xóa");
			jbt_xoa.setBackground(Color.CYAN);
			jbt_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FootballView.class.getResource("delete.png"))));
			jbt_xoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel_nutlenh.add(jbt_xoa);
				
			//
			JLabel lblNewLabel_3 = new JLabel("");
			panel_nutlenh.add(lblNewLabel_3);
			JLabel lblNewLabel_4 = new JLabel("");
			panel_nutlenh.add(lblNewLabel_4);
			JLabel lblNewLabel_5 = new JLabel("");
			panel_nutlenh.add(lblNewLabel_5);
			JLabel lblNewLabel_6 = new JLabel("");
			panel_nutlenh.add(lblNewLabel_6);
			
			JPanel panel_nhap = new JPanel();
			panel_trai.add(panel_nhap, BorderLayout.CENTER);
			panel_nhap.setLayout(new GridLayout(8,2));
			
			JLabel lblNewLabel_11 = new JLabel("Tên đội bóng",0);
			panel_nhap.add(lblNewLabel_11);
			
			JLabel lblNewLabel_2 = new JLabel("Xếp hạng\r\n",0);
			panel_nhap.add(lblNewLabel_2);
			
			String doibong [] = { "Becamex Bình Dương","Aston Villa","Man Unt","Man City","Norwich","Liverpool","Nam Định","Viettel","Man Utd","Than Quang Ninh","Tottenham"
					,"Quảng Trị FC","Barcelona","Chealse","Paris Saint Germain","Hà Nội FC", "Hoàng Anh Gia Lai", "FLC Thanh Hóa", "Sông Lam Nghệ An", "SHB Đà Nẵng", "Vettel"};
			
			JComboBox comboBox = new JComboBox(doibong);
			panel_nhap.add(comboBox);
			
			jtf_xephang = new JTextField();
			panel_nhap.add(jtf_xephang);
			jtf_xephang.setColumns(10);
			
			JLabel lblNewLabel_14 = new JLabel("Số trận",0);
			panel_nhap.add(lblNewLabel_14);
			
			JLabel lblNewLabel_13 = new JLabel("Thắng",0);
			panel_nhap.add(lblNewLabel_13);
			
			jtf_tran = new JTextField();
			panel_nhap.add(jtf_tran);
			jtf_tran.setColumns(10);
			
			jtf_thang = new JTextField();
			panel_nhap.add(jtf_thang);
			jtf_thang.setColumns(10);
			
			JLabel lblNewLabel_15 = new JLabel("Hòa",0);
			panel_nhap.add(lblNewLabel_15);
			
			JLabel lblNewLabel_12 = new JLabel("Thua",0);
			panel_nhap.add(lblNewLabel_12);
			
			jtf_hoa = new JTextField();
			panel_nhap.add(jtf_hoa);
			jtf_hoa.setColumns(10);
			
			jtf_thua = new JTextField();
			panel_nhap.add(jtf_thua);
			jtf_thua.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Hiệu số",0);
			panel_nhap.add(lblNewLabel_1);
			
			JLabel lblNewLabel_16 = new JLabel("Điểm",0);
			panel_nhap.add(lblNewLabel_16);
			
			jtf_hieuso = new JTextField();
			panel_nhap.add(jtf_hieuso);
			jtf_hieuso.setColumns(10);
			
			jtf_diem = new JTextField();
			panel_nhap.add(jtf_diem);
			jtf_diem.setColumns(10);
				
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder tborder= BorderFactory.createTitledBorder(border,"CHỈNH SỬA THÔNG TIN CÁC ĐỘI BÓNG");
				
				
				///jpn bên phải
			JPanel panel_phai = new JPanel();
			getContentPane().add(panel_phai, BorderLayout.CENTER);
			panel_phai.setLayout(new BorderLayout());
				
				//Tạo bảng
			table = new JTable();
			panel_phai.add(table, BorderLayout.CENTER);
			table.setBackground(new Color(255, 204, 255));
			JScrollPane sc= new JScrollPane(table);
			panel_phai.add(sc);
			
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] {"Xếp hạng","Tên đội bóng", "Số trận","Thắng","Hòa","Thua","Hiệu số","Điểm" }));
		
				///jpn dưới bảng
			JPanel panel_timkiem = new JPanel();
			panel_phai.add(panel_timkiem, BorderLayout.SOUTH);
			panel_timkiem.setLayout(new GridLayout(2,5));
				
			Border border1 = BorderFactory.createLineBorder(Color.GREEN);
			TitledBorder tborder1= BorderFactory.createTitledBorder(border1,"Nhập đội bóng bạn muốn xem thứ hạng");
			panel_timkiem.setBorder(tborder1);
				
			JLabel jbt_mdb = new JLabel("Tên đội bóng",0);
			jbt_mdb.setForeground(Color.BLUE);
			jbt_mdb.setBackground(Color.YELLOW);
			panel_timkiem.add(jbt_mdb);
			jbt_mdb.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jtf_timkiem = new JTextField();
			
			
			panel_timkiem.add(jtf_timkiem);
			jtf_timkiem.setColumns(10);	
			
			jtf_timkiem.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
						String a = jtf_timkiem.getText();
						Timkiem(a);
					}
				});
			
			
			JLabel lblNewLabel_7 = new JLabel("");
			panel_timkiem.add(lblNewLabel_7);
			JLabel lblNewLabel_8 = new JLabel("");
			panel_timkiem.add(lblNewLabel_8);	
				
			//jlabel nay để chèn cho dòng nó dưng lên cho đẹp
			JLabel lblNewLabel_9 = new JLabel("");
			panel_timkiem.add(lblNewLabel_9);
			JLabel lblNewLabel_10 = new JLabel("");
			panel_timkiem.add(lblNewLabel_10);
				
				
			//Panel nằm trên bẳng
			JPanel panel_trenbang = new JPanel();
			panel_phai.add(panel_trenbang, BorderLayout.NORTH);
					
			//label trên bảng
			JLabel lblNewLabel = new JLabel("BẢNG XẾP HẠNG", 0);
			lblNewLabel.setBackground(Color.ORANGE);
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel_phai.add(lblNewLabel, BorderLayout.NORTH);
				
			table.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					jtf_xephang.setText((String)table.getValueAt(row,0));
					comboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(),1)+"");	
					jtf_tran.setText((String)table.getValueAt(row,2));
					jtf_thang.setText((String)table.getValueAt(row,3));
					jtf_hoa.setText((String)table.getValueAt(row,4));
					jtf_thua.setText((String)table.getValueAt(row,5));
					jtf_hieuso.setText((String)table.getValueAt(row,6));
					jtf_diem.setText((String)table.getValueAt(row,7));
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
			
			try {
				while(rs.next()) {
					DefaultTableModel model_table = (DefaultTableModel) table.getModel();
					model_table.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
							rs.getString(6),rs.getString(7),rs.getString(8)});
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jbt_them.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model_table = (DefaultTableModel) table.getModel();
					model_table.addRow(new String[] { jtf_xephang.getText(),comboBox.getSelectedItem().toString(), jtf_tran.getText(),
									jtf_thang.getText(),jtf_hoa.getText(),jtf_thua.getText(),jtf_hieuso.getText(),jtf_diem.getText()});						
							try {
								stmt.executeUpdate("insert into BANGXEPHANG values (\'"+jtf_xephang.getText()+"\',\'"+comboBox.getSelectedItem().toString()+"\'"
										+ ",\'"+jtf_tran.getText()+"\',\'"+jtf_thang.getText()+"\',\'"+jtf_hoa.getText()+"\',\'"+jtf_thua.getText()+"\',\'"+jtf_hieuso.getText()+"\'"
												+ ",\'"+jtf_diem.getText()+"\')");
								 JOptionPane.showMessageDialog(null, "Thêm thành công");
							}catch(SQLException e1) {
								System.out.print(e1);
								JOptionPane.showMessageDialog(null, " Thêm không thành công");
							}	
							jtf_xephang.setText("");
							comboBox.getSelectedItem().toString();
							jtf_tran.setText("");
							jtf_thang.setText("");
							jtf_hoa.setText("");
							jtf_thua.setText("");
							jtf_hieuso.setText("");
							jtf_diem.setText("");		
				}
			});
			jbt_sua.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					DefaultTableModel model_table = (DefaultTableModel)table.getModel();
					model_table.removeRow( row );
					model_table.addRow(new String[] { jtf_xephang.getText(), comboBox.getSelectedItem().toString(), jtf_tran.getText(),
							jtf_thang.getText(),jtf_hoa.getText(),jtf_thua.getText(),jtf_hieuso.getText(),jtf_diem.getText()});			
					try {
						stmt.executeUpdate("update BANGXEPHANG set tendoi=\'"+comboBox.getSelectedItem().toString()+"\'"+ ",sotran= \'"+jtf_tran.getText()+"\',thang= \'"+jtf_thang.getText()
						+"\',hoa= \'"+jtf_hoa.getText()+"\',thua= \'"+jtf_thua.getText()+"\',hieuso= \'"+jtf_hieuso.getText()+"\',diem= \'"+jtf_diem.getText()+"\'"
						+ "where xephang= \'"+jtf_xephang.getText()+"\'");
						 JOptionPane.showMessageDialog(null, "Sửa thành công");
					}catch(SQLException e2) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công");
						
					}
					jtf_xephang.setText("");
					comboBox.getSelectedItem().toString()	;
					jtf_tran.setText("");
					jtf_thang.setText("");
					jtf_hoa.setText("");
					jtf_thua.setText("");
					jtf_hieuso.setText("");
					jtf_diem.setText("");		
					
				}
			});
			
			jbt_xoa.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					DefaultTableModel model_table = (DefaultTableModel)table.getModel();
					model_table.removeRow( row );
							try {
								stmt.executeUpdate("delete from BANGXEPHANG where (xephang = \'"+jtf_xephang.getText()+"\')");
								 JOptionPane.showMessageDialog(null, "Xóa thành công");
							}catch(SQLException e1) {
								System.out.print(e1);
								JOptionPane.showMessageDialog(null, "Xóa không thành công");
							}
							jtf_xephang.setText("");
							comboBox.getSelectedItem().toString();
							jtf_tran.setText("");
							jtf_thang.setText("");
							jtf_hoa.setText("");
							jtf_thua.setText("");
							jtf_hieuso.setText("");
							jtf_diem.setText("");		
				}
			});
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
			new bangxephang();
		}
}