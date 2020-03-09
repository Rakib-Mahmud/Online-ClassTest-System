import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;


public class Result extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn=Database.dbConnector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public Result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 655, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 635, 246);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadResultTable = new JButton("Load Result Table");
		btnLoadResultTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String sql="select * from Result";
					PreparedStatement pst=conn.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnLoadResultTable.setBackground(new Color(250, 250, 210));
		btnLoadResultTable.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnLoadResultTable.setForeground(new Color(148, 0, 211));
		btnLoadResultTable.setBounds(254, 357, 168, 35);
		panel.add(btnLoadResultTable);
		
		JLabel lblNewLabel_1 = new JLabel("Result Sheet");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setBounds(254, 28, 198, 43);
		panel.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Admin ad=new Admin();
				ad.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(148, 0, 211));
		btnBack.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnBack.setBackground(new Color(250, 250, 210));
		btnBack.setBounds(554, 360, 71, 29);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\Download\\Webp.net-resizeimage (5).jpg"));
		lblNewLabel.setBounds(0, 0, 655, 403);
		panel.add(lblNewLabel);
	}
}
