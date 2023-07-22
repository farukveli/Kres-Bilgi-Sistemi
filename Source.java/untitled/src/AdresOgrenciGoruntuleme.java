import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class AdresOgrenciGoruntuleme {
	Connection con;
	AdresOgrenciGoruntuleme(Connection con) {
		JFrame frame=new JFrame("Adrese Gore Ogrenci Goruntuleme Sayfasi");		
		DefaultListModel<String> model=new DefaultListModel<>();
		//-----------------------------------------------------------------------------------
		String sql = "SELECT * FROM kid, guardian where kid.kidId = guardian.kidId";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				model.addElement(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		//-----------------------------------------------------------------------------------
		
		JList<String> list=new JList<>(model);
		list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 20, 200,150);
		scrollPane.setViewportView(list);
		list.setForeground(Color.RED);
		frame.add(scrollPane);
		
		JLabel a1=new JLabel("");
		a1.setFont(new Font("Dialog",Font.BOLD,13));
		a1.setBounds(50,170,400,50);
		frame.add(a1);
		
		
		JButton buton1=new JButton("Goruntule");
		buton1.setBounds(230, 180, 130, 35);
		buton1.setForeground(Color.white);
		buton1.setFont(new Font("times new roman",Font.BOLD,16));
		buton1.setBackground(Color.lightGray);
		buton1.setFocusable(false);
		frame.add(buton1);
		
		
		DefaultListModel<String> model2=new DefaultListModel<>();
		
		JList<String> list2=new JList<>(model2);
		list2.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);	
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(50, 220, 330,240);
		scrollPane2.setViewportView(list2);
		frame.add(scrollPane2);
		//list2.setBackground(Color.white);
		list2.setForeground(Color.yellow);
		list2.setBackground(Color.darkGray);
		
		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex() == -1) {
					a1.setText(" Durum: Adres Secilmedi ");	
				}
				else {
					String goruntulenecekAdres =list.getSelectedValue();
					model2.removeAllElements();
					
					//---------------------------------------------------------
					try {
						PreparedStatement stmt = con.prepareCall("{ call getStudentByAddress (?) }");
						stmt.setString(1, goruntulenecekAdres);
						ResultSet res = stmt.executeQuery();
						res.next();

						System.out.println(res.getString(1));

						String result = res.getString(1);
						String[] resultArray = result.split(",");
						for(int i = 0; i < resultArray.length; i++) {
							resultArray[i] = resultArray[i].substring(resultArray[i].indexOf("(") + 1);
						}
						for(int i = 0; i < resultArray.length; i++) {
							if(resultArray[i].contains(")")) {
								resultArray[i] = resultArray[i].substring(0, resultArray[i].indexOf(")"));
							}
						}

						for(int i = 0; i < resultArray.length; i++) {
							System.out.println(resultArray[i]);
						}

						for(int i = 0; i < resultArray.length / 4; i++) {
							model2.addElement("Cocuk adi: " +resultArray[i] + " " + resultArray[i + 1] + " 		||| "+ "Ebeveyn adi:" + " " + resultArray[i + 2] + " " + resultArray[i + 3]);
						}
					}
					catch (Exception e1) {
						System.out.println(e1);
					}


					//----------------------------------------------------------
					
					a1.setText("");
				}			
			}
		});
		
		JButton buton2=new JButton("Ana Menu");
		buton2.setBounds(20, 480, 150, 35);
		buton2.setForeground(Color.white);
		buton2.setFont(new Font("times new roman",Font.BOLD,16));
		buton2.setBackground(Color.lightGray);
		buton2.setFocusable(false);
		frame.add(buton2);
		
		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu anaMenu = new AnaMenu(con);
				frame.dispose();			
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(440, 570);
		frame.setLayout(null);
		frame.setLocation(600, 200);
		frame.setVisible(true);	
		
		
		
		
		
		
		
	}

}
