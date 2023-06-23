

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;


public class lichthidau extends JFrame {

	private static JTable table;
	private static SimpleDateFormat dateFormat;
	private JTextField jtf_thoigian;
	private JTextField jtf_tran;
	private JTextField jtf_svd;
	
	public lichthidau() {
				
			JFrame jf = new JFrame();
			jf.setSize(800,650);
			jf.setTitle("Lịch thi đấu");
			jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
			jf.setLocationRelativeTo(null);
			jf.getContentPane().setLayout(null);
			
			
			String doibong [] = { "Becamex Bình Dương","Aston Villa","Brighton","Man City","Norwich","Liverpool","Nam Định","Viettel","Man Utd","Than Quảng Ninh","Tottenham"
					,"Quảng Trị FC","Barcelona","Chealse","Paris Saint-Germain","Hà Nội FC", "Hoàng Anh Gia Lai", "FLC Thanh Hóa", "Sông Lam Nghệ An", "SHB Đà Nẵng", "Vettel"};
			
			
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
			jf.setJMenuBar(jmnbar);
			
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
			
			
			//jpanel trên 
			JPanel panel_tren = new JPanel();
			panel_tren.setBackground(Color.YELLOW);
			panel_tren.setBounds(0, 0, 786, 30);
			jf.getContentPane().add(panel_tren);
			
			JLabel lblNewLabel = new JLabel("Lịch thi đấu V_League\r\n");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			panel_tren.add(lblNewLabel);
			
			
			//jpanel dưới
			JPanel panel_duoi = new JPanel();
			panel_duoi.setBounds(0, 392, 786, 171);
			jf.getContentPane().add(panel_duoi);
			panel_duoi.setLayout(new GridLayout(5,7));
			
			JLabel lblNewLabel_2 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_3);
			
			JLabel lblNewLabel_1 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_1);
			
			JLabel lblNewLabel_4 = new JLabel("Trận\r\n",0);
			panel_duoi.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Đội 1",0);
			panel_duoi.add(lblNewLabel_8);
			
			JComboBox comboBox_1 = new JComboBox(doibong);
			panel_duoi.add(comboBox_1);
			
			JLabel lblNewLabel_9 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_9);
			
			jtf_tran = new JTextField();
			panel_duoi.add(jtf_tran);
			jtf_tran.setColumns(10);
			
			JLabel lblNewLabel_18 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_18);
			
			JComboBox comboBox_2 = new JComboBox(doibong);
			panel_duoi.add(comboBox_2);
			
			JLabel lblNewLabel_19 = new JLabel("Đội 2",0);
			panel_duoi.add(lblNewLabel_19);
			
			JLabel lblNewLabel_20 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_20);
			
			JLabel lblNewLabel_21 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_21);
			
			JLabel lblNewLabel_22 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_22);
			
			JLabel lblNewLabel_10 = new JLabel("Sân vận động",0);
			panel_duoi.add(lblNewLabel_10);
			
			JLabel lblNewLabel_23 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_23);
			
			JLabel lblNewLabel_24 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_24);
			
			JLabel lblNewLabel_25 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_25);
			
			JLabel lblNewLabel_11 = new JLabel("Thời gian",0);
			panel_duoi.add(lblNewLabel_11);
			
			jtf_thoigian = new JTextField();
			panel_duoi.add(jtf_thoigian);
			jtf_thoigian.setColumns(10);
			
			JLabel lblNewLabel_12 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_12);
			
			jtf_svd = new JTextField();
			panel_duoi.add(jtf_svd);
			jtf_svd.setColumns(10);
			
			JLabel lblNewLabel_13 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_13);
			
			JDateChooser dateChooser = new JDateChooser();
			panel_duoi.add(dateChooser);
			
			JLabel lblNewLabel_14 = new JLabel("Ngày diễn ra",0);
			panel_duoi.add(lblNewLabel_14);
			
			JLabel lblNewLabel_15 = new JLabel("");
			panel_duoi.add(lblNewLabel_15);
			
			JLabel lblNewLabel_26 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_26);
			
			JButton jbt_them = new JButton("Thêm");
			jbt_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(lichthidau.class.getResource("add.png"))));
			jbt_them.setBackground(Color.CYAN);
			jbt_them.setForeground(Color.BLACK);
			jbt_them.setFont(new Font("Tahoma", Font.BOLD, 12));
			panel_duoi.add(jbt_them);
			
			JButton jbt_sua = new JButton("Sửa");
			jbt_sua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(lichthidau.class.getResource("fix.png"))));
			jbt_sua.setBackground(Color.CYAN);
			jbt_sua.setFont(new Font("Tahoma", Font.BOLD, 12));
			jbt_sua.setForeground(Color.BLACK);
			panel_duoi.add(jbt_sua);
			
			JButton jbt_xoa = new JButton("Xóa");
			jbt_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(lichthidau.class.getResource("delete.png"))));
			jbt_xoa.setBackground(Color.CYAN);
			jbt_xoa.setFont(new Font("Tahoma", Font.BOLD, 12));
			jbt_xoa.setForeground(Color.BLACK);
			panel_duoi.add(jbt_xoa);
			
			JLabel lblNewLabel_16 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_16);
			
			JLabel lblNewLabel_17 = new JLabel(" ");
			panel_duoi.add(lblNewLabel_17);
			
		
								
			JPanel panel_bang = new JPanel();
			panel_bang.setBounds(0, 29, 786, 363);
			jf.getContentPane().add(panel_bang);
			
		
			panel_bang.setLayout(new BorderLayout());
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder tborder= BorderFactory.createTitledBorder(border,"Lịch thi đấu");
			panel_bang.setBorder(tborder);
				
				//Tạo bảng
			table = new JTable();
			panel_bang.add(table, BorderLayout.CENTER);
			table.setBackground(new Color(255, 204, 255));
			JScrollPane sc= new JScrollPane(table);
			panel_bang.add(sc);
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] {"Trận","Tên đội 1", "Tên đội 2","Thời gian","Sân vận động","Ngày diễn ra" }));
						
			table.addMouseListener(new MouseListener() {

				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					jtf_tran.setText((String)table.getValueAt(row,0));
					comboBox_1.setSelectedItem(table.getValueAt(table.getSelectedRow(),1)+"");	
					comboBox_2.setSelectedItem(table.getValueAt(table.getSelectedRow(),2)+"");	
					jtf_thoigian.setText((String)table.getValueAt(row,3));
					jtf_svd.setText((String)table.getValueAt(row,4));
					try {
			            DefaultTableModel model = (DefaultTableModel)table.getModel();
			            int row1 = table.getSelectedRow();
			            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(row, 5));
			            dateChooser.setDate(date);
			        } catch (ParseException ex) {
			           
			        }
					
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
			ResultSet rs2 = dbcon.getAllFromLICHTHIDAU();
			Statement stmt = Connectdoan.getStmt();
			
			try {
				while(rs2.next()) {
					DefaultTableModel model_table = (DefaultTableModel) table.getModel();
					model_table.addRow(new String[]{rs2.getString(1), rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5),rs2.getString(6)});
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jmnItem_back.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new FootballView();
					jf.setVisible(false);
				}
			});
			
			jbt_them.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dateFormat = new SimpleDateFormat("YYYY-MM-DD");
					DefaultTableModel model_table = (DefaultTableModel) table.getModel();
					model_table.addRow(new String[] {jtf_tran.getText(), comboBox_1.getSelectedItem().toString(), comboBox_2.getSelectedItem().toString(), jtf_thoigian.getText(),
							jtf_svd.getText(),dateFormat.format(dateChooser.getDate())});
					
					try {
						stmt.executeUpdate("insert into LICHTHIDAU values (\'"+jtf_tran.getText()+"\',\'"+comboBox_1.getSelectedItem().toString()+"\',\'"+comboBox_2.getSelectedItem().toString()+"\',\'"
								+jtf_thoigian.getText()+"\',\'"+jtf_svd.getText()+"\',\'"+dateFormat.format(dateChooser.getDate())+"\')");
						JOptionPane.showMessageDialog(null, " Thêm thành công");
					}catch(SQLException e1) {
						System.out.print(e1);
					}	
					jtf_tran.setText("");
					comboBox_1.getSelectedItem().toString();
					comboBox_2.getSelectedItem().toString();
					jtf_thoigian.setText("");
					jtf_svd.setText("");
					dateFormat.format(dateChooser.getDate());
		}
	});		
			jbt_sua.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dateFormat = new SimpleDateFormat("YYYY-MM-DD");
					int row = table.getSelectedRow();
					DefaultTableModel table_model = (DefaultTableModel)table.getModel();
					table_model.removeRow( row );
					table_model.addRow(new String[] {jtf_tran.getText(), comboBox_1.getSelectedItem().toString(), comboBox_2.getSelectedItem().toString(), jtf_thoigian.getText(),
							jtf_svd.getText(),dateFormat.format(dateChooser.getDate())});
					
					try {
						
						stmt.executeUpdate("update LICHTHIDAU set doi1= \'"+comboBox_1.getSelectedItem().toString()+"\',doi2=\'"+comboBox_2.getSelectedItem().toString()+"\'"
								+ ",thoigian= \'"+jtf_thoigian.getText()+"\',sanvandong= \'"+jtf_svd.getText()+"\',ngaydienra= \'"+dateFormat.format(dateChooser.getDate())+"\'"
								+ "where trandau= \'"+jtf_tran.getText()+"\'");
						JOptionPane.showMessageDialog(null, " Sửa thành công");
					}catch(SQLException e2) {
						e2.printStackTrace();
				
						JOptionPane.showMessageDialog(null, " Sửa không thành công");

					}
					jtf_tran.setText("");
					comboBox_1.getSelectedItem().toString();
					comboBox_2.getSelectedItem().toString();
					jtf_thoigian.setText("");
					jtf_svd.setText("");
					dateFormat.format(dateChooser.getDate());
				}
				
			});
			jbt_xoa.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dateFormat = new SimpleDateFormat("YYYY-MM-DD");
					int row = table.getSelectedRow();
					DefaultTableModel table_model = (DefaultTableModel)table.getModel();
					table_model.removeRow( row );
							
							try {
								stmt.executeUpdate("delete from LICHTHIDAU where (trandau = \'"+jtf_tran.getText()+"\')");
								JOptionPane.showMessageDialog(null, " Xóa thành công");
							}catch(SQLException e1) {
								System.out.print(e1);
								JOptionPane.showMessageDialog(null, " Xóa không thành công");
							}
							jtf_tran.setText("");
							comboBox_1.getSelectedItem().toString();
							comboBox_2.getSelectedItem().toString();
							jtf_thoigian.setText("");
							jtf_svd.setText("");
							dateFormat.format(dateChooser.getDate());
						}
			});
			
			jf.setVisible(true);
		} 
	public static void main(String[] args) {
		new lichthidau();
		
	}
	}
/*
JButton jbt_reset = new JButton("      Reset      ");
jbt_reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
panel_button.add(jbt_reset);
jbt_reset.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	jTextField_stt.setText("");
	jComboBox_1.getSelectedItem().toString();
	jTextField_ntd.setText("");
	jTextField_gio.setText("");
	jComboBox_2.getSelectedItem().toString();
	jTextField_san.setText("");
	
}
});
*/