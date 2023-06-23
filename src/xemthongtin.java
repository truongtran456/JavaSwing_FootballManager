


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
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

public class xemthongtin extends JFrame {
		private JTextField jtf_id;
		private JTextField jtf_ten;
		private JTextField jtf_vdv;
		private JTextField jtf_diachi;
		private JTextField jtf_hlv;
		private JTable table;
		private JButton jbt_xoa;
		private JButton jbt_them;
		private JButton jbt_sua;
		private JButton jbt_timkiem;
		private JTextField jtf_timkiem;
		private JButton jbt_huytim;
		private DefaultTableModel model;
		
		public void Timkiem(String str) {
			model=(DefaultTableModel)table.getModel();
			TableRowSorter<DefaultTableModel> ts= new TableRowSorter<>(model);
			table.setRowSorter(ts);
			ts.setRowFilter(RowFilter.regexFilter(str));
		}
		public xemthongtin() {
			this.setTitle("Search");
			this.setSize(900,600);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			
			Connectdoan dbcon = new Connectdoan();
			ResultSet rs = dbcon.getAllFromDOIBONG();
			Statement stmt = Connectdoan.getStmt();
			
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
				
			//panel bên trái
			JPanel panel_trai = new JPanel();
			getContentPane().add(panel_trai, BorderLayout.WEST);
			panel_trai.setLayout(new BorderLayout());
				
			//panel bên trái 3 nút lệnh
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
				
			//label đẹp
			JLabel lblNewLabel_3 = new JLabel("");
			panel_nutlenh.add(lblNewLabel_3);
			JLabel lblNewLabel_4 = new JLabel("");
			panel_nutlenh.add(lblNewLabel_4);
			JLabel lblNewLabel_5 = new JLabel("");
			panel_nutlenh.add(lblNewLabel_5);
			JLabel lblNewLabel_6 = new JLabel("");
			panel_nutlenh.add(lblNewLabel_6);
				
				
			//jpn bên trái để nhập các thông tin
			JPanel panel_nhap = new JPanel();
			panel_trai.add(panel_nhap, BorderLayout.CENTER);
			panel_nhap.setLayout(new GridLayout(12,1));
				
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder tborder= BorderFactory.createTitledBorder(border,"CHỈNH SỬA THÔNG TIN CÁC ĐỘI BÓNG");
			panel_nhap.setBorder(tborder);
			JLabel jlb_madoibong= new JLabel("     Mã đội bóng : ");
			panel_nhap.add(jlb_madoibong);	
			jtf_id = new JTextField();
			panel_nhap.add(jtf_id);
			jtf_id.setColumns(10);
			
			JLabel jlb_tendoibong = new JLabel("     Tên đội bóng :");
			panel_nhap.add(jlb_tendoibong);
			jtf_ten = new JTextField();
			panel_nhap.add(jtf_ten);
			jtf_ten.setColumns(10);
				
			JLabel jlb_diachi = new JLabel("      Địa chỉ :");
			panel_nhap.add(jlb_diachi);	
			jtf_diachi = new JTextField();
			panel_nhap.add(jtf_diachi);
			jtf_diachi.setColumns(10);
				
			JLabel jlb_vdv = new JLabel("      Số VDV :");
			panel_nhap.add(jlb_vdv);	
			jtf_vdv = new JTextField();
			panel_nhap.add(jtf_vdv);
			jtf_vdv.setColumns(10);
				
			JLabel jlb_hlv = new JLabel("     Tên HLV :");
			panel_nhap.add(jlb_hlv);
			jtf_hlv = new JTextField();
			panel_nhap.add(jtf_hlv);
			jtf_hlv.setColumns(10);
				
				
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
					new String[] {"Mã đội bóng","Tên đội bóng", "Địa chỉ","Số VDV","Tên HLV" }));
		
				///jpn dưới bảng để tìm kiếm
			JPanel panel_timkiem = new JPanel();
			panel_phai.add(panel_timkiem, BorderLayout.SOUTH);
			panel_timkiem.setLayout(new GridLayout(2,5));
				
			Border border1 = BorderFactory.createLineBorder(Color.GREEN);
			TitledBorder tborder1= BorderFactory.createTitledBorder(border1,"Nhập mã đội bóng mà bạn muốn tìm kiếm");
			panel_timkiem.setBorder(tborder1);
				
			JLabel jbt_mdb = new JLabel("Mã đội bóng",0);
			jbt_mdb.setForeground(Color.BLUE);
			jbt_mdb.setBackground(Color.YELLOW);
			panel_timkiem.add(jbt_mdb);
			jbt_mdb.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jtf_timkiem = new JTextField();
			
			
			panel_timkiem.add(jtf_timkiem);
			jtf_timkiem.setColumns(10);	
			
			
			jtf_timkiem.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
						String search = jtf_timkiem.getText();
						Timkiem(search);
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
			JLabel lblNewLabel = new JLabel("DANH SÁCH ĐỘI BÓNG", 0);
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel_phai.add(lblNewLabel, BorderLayout.NORTH);
				
			table.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					jtf_id.setText((String)table.getValueAt(row,0));
					jtf_ten.setText((String)table.getValueAt(row,1));
					jtf_diachi.setText((String)table.getValueAt(row,2));
					jtf_vdv.setText((String)table.getValueAt(row,3));
					jtf_hlv.setText((String)table.getValueAt(row,4));
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
					model_table.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jbt_them.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model_table = (DefaultTableModel) table.getModel();
					model_table.addRow(new String[] { jtf_id.getText(), jtf_ten.getText(), jtf_diachi.getText(),
									jtf_vdv.getText(),jtf_hlv.getText()});						
							try {
								stmt.executeUpdate("insert into DOIBONG values (\'"+jtf_id.getText()+"\',\'"+jtf_ten.getText()+"\'"
										+ ",\'"+jtf_diachi.getText()+"\',\'"+jtf_vdv.getText()+"\',\'"+jtf_hlv.getText()+"\')");
								 JOptionPane.showMessageDialog(null, "Thêm thành công");
							}catch(SQLException e1) {
								System.out.print(e1);
								JOptionPane.showMessageDialog(null, " Thêm không thành công");
							}	
							jtf_id.setText("");
							jtf_ten.setText("");
							jtf_diachi.setText("");
							jtf_vdv.setText("");
							jtf_hlv.setText("");		
				}
			});
			jbt_sua.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					DefaultTableModel model_table = (DefaultTableModel)table.getModel();
					model_table.removeRow( row );
					model_table.addRow(new String[] {jtf_id.getText(), jtf_ten.getText(), jtf_diachi.getText(),
							jtf_vdv.getText(),jtf_hlv.getText()});				
					try {
						
						stmt.executeUpdate("update DOIBONG set tendoibong=\'"+jtf_ten.getText()+"\'"+ ",diachi= \'"+jtf_diachi.getText()+"\',vdv= \'"+jtf_vdv.getText()
						+"\',hlv= \'"+jtf_hlv.getText()+"\'"+ "where madoibong= \'"+jtf_id.getText()+"\'");
						 JOptionPane.showMessageDialog(null, "Sửa thành công");
					}catch(SQLException e2) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công");
						
					}
					jtf_id.setText("");
					jtf_ten.setText("");
					jtf_diachi.setText("");
					jtf_vdv.setText("");
					jtf_hlv.setText("");
					
				}
			});
			
			jbt_xoa.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					DefaultTableModel model_table = (DefaultTableModel)table.getModel();
					model_table.removeRow( row );
							try {
								stmt.executeUpdate("delete from DOIBONG where (madoibong = \'"+jtf_id.getText()+"\')");
								 JOptionPane.showMessageDialog(null, "Xóa thành công");
							}catch(SQLException e1) {
								System.out.print(e1);
								JOptionPane.showMessageDialog(null, "Xóa không thành công");
							}
							jtf_id.setText("");
							jtf_ten.setText("");
							jtf_diachi.setText("");
							jtf_vdv.setText("");
							jtf_hlv.setText("");
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
			new xemthongtin();
		}
}