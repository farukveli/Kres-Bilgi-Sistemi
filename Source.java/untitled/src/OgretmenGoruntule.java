import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class OgretmenGoruntule {
	Connection con;
	OgretmenGoruntule(Connection con){
		JFrame frame=new JFrame("Ogretmen Listesi");
		
		JLabel a1=new JLabel("Ogretmen Listesi: ");
		a1.setFont(new Font("Dialog",Font.BOLD,13));
		a1.setBounds(10,0,400,50);
		a1.setForeground(Color.red);
		frame.add(a1);
		
		DefaultListModel<String> model=new DefaultListModel<>();
		//----------------------------------------------------------------------------------
		String sql="SELECT * FROM teacher";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				model.addElement(rs.getString("teachId") + "  " +  rs.getString("firstName") + "  " + rs.getString("lastName") +
						"  " + rs.getString("address") + "  " + rs.getString("phone"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//----------------------------------------------------------------------------------
		JList<String> list=new JList<>(model);
		list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 325,200 );
		scrollPane.setViewportView(list);
		list.setForeground(Color.yellow);
		list.setBackground(Color.darkGray);
		frame.add(scrollPane);
		
		JButton buton1=new JButton("Ana Menu");
		buton1.setBounds(205, 250, 130, 35);
		buton1.setForeground(Color.white);
		buton1.setFont(new Font("times new roman",Font.BOLD,16));
		buton1.setBackground(Color.GRAY);
		buton1.setFocusable(false);
		frame.add(buton1);
		
		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu anaMenu = new AnaMenu(con);
				frame.dispose();			
			}
		});

		frame.getContentPane().setBackground(Color.lightGray);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(370, 340);
		frame.setLocation(600, 250);
		frame.setLayout(null);
		frame.setVisible(true);		
	}

}
