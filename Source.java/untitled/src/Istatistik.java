import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Istatistik {
	Connection con;

	Istatistik(Connection con) {


		this.con = con;
		JFrame frame=new JFrame("Istatislik");
		
		JLabel a2=new JLabel(" Toplam Devamsizlik Alt Sinir: ");
		a2.setFont(new Font("Dialog",Font.BOLD,13));
		a2.setBounds(10,10,400,50);
		frame.add(a2);
		
		JTextField text1= new JTextField();
		text1.setBounds(210,25,120,20);
		frame.add(text1);

		frame.getContentPane().setBackground(Color.lightGray);
		DefaultListModel<String> model=new DefaultListModel<>();
		JList<String> list=new JList<>(model);
		list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 325,200 );
		scrollPane.setViewportView(list);
		list.setForeground(Color.yellow);
		list.setBackground(Color.darkGray);
		frame.add(scrollPane);
		
		JButton buton1=new JButton("Ana Menu");
		buton1.setBounds(10, 270, 130, 35);
		buton1.setForeground(Color.white);
		buton1.setFont(new Font("times new roman",Font.BOLD,16));
		buton1.setBackground(Color.GRAY);
		buton1.setFocusable(false);
		frame.add(buton1);
		
		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AnaMenu(con);
				frame.dispose();			
			}
		});
		
		JButton buton2=new JButton("Listele");
		buton2.setBounds(205, 270, 130, 35);
		buton2.setForeground(Color.white);
		buton2.setFont(new Font("times new roman",Font.BOLD,16));
		buton2.setBackground(Color.GRAY);
		buton2.setFocusable(false);
		frame.add(buton2);
		
		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					model.removeAllElements();
					try {
						String minDevamsizlik =text1.getText();
						//-----------------------------------------------------
						String sql =  "SELECT classroom, COUNT(*) FROM kid k, nonattendances n WHERE k.kidId = n.kidId GROUP BY (classroom) HAVING COUNT(*) > " + minDevamsizlik;
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							model.addElement(rs.getString("classroom") + " " + rs.getString("count"));
						}
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(370, 360);
		frame.setLayout(null);
		frame.setLocation(600, 250);
		frame.setVisible(true);
		
	}

}
