import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;


public class About_Us extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About_Us frame = new About_Us();
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
	public About_Us() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 100, 257, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 241, 302);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("@Mahmudul Islam Rakib");
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setBounds(31, 44, 200, 38);
		panel.add(lblNewLabel);
		
		JLabel lblnazmusSadath = new JLabel("@Nazmus Sadath ");
		lblnazmusSadath.setForeground(new Color(255, 160, 122));
		lblnazmusSadath.setFont(new Font("Script MT Bold", Font.PLAIN, 17));
		lblnazmusSadath.setBounds(31, 93, 200, 38);
		panel.add(lblnazmusSadath);
		
		JLabel lblamorChandraNath = new JLabel("@Amor Chandra Nath");
		lblamorChandraNath.setForeground(new Color(255, 160, 122));
		lblamorChandraNath.setFont(new Font("Script MT Bold", Font.PLAIN, 17));
		lblamorChandraNath.setBounds(31, 142, 200, 38);
		panel.add(lblamorChandraNath);
		
		JLabel lblarfanulHaq = new JLabel("Dept. of CSTE");
		lblarfanulHaq.setForeground(new Color(255, 160, 122));
		lblarfanulHaq.setFont(new Font("Script MT Bold", Font.PLAIN, 17));
		lblarfanulHaq.setBounds(31, 191, 200, 38);
		panel.add(lblarfanulHaq);
		
		JLabel lblsayadAhmedChowdhury = new JLabel("NSTU");
		lblsayadAhmedChowdhury.setForeground(new Color(255, 160, 122));
		lblsayadAhmedChowdhury.setFont(new Font("Script MT Bold", Font.PLAIN, 17));
		lblsayadAhmedChowdhury.setBounds(31, 240, 200, 38);
		panel.add(lblsayadAhmedChowdhury);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\Download\\rsz_cyber_crime_hacked.jpg"));
		label.setBounds(0, 0, 241, 302);
		panel.add(label);
	}

}
