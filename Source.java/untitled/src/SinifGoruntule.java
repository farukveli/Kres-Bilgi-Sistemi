

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class SinifGoruntule {
	Connection con;
	SinifGoruntule(Connection con){
		JFrame frame=new JFrame("Sinif Gortuleme Sayfasi");		
		DefaultListModel<String> model=new DefaultListModel<>();
		//-----------------------------------------------------------------------------------

		try {
			String sql = "SELECT * FROM classroom";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				model.addElement(rs.getString("className") + " " + rs.getString("quota") + " " + rs.getString("teacherId"));
			}
		}
		catch (Exception e) {
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
		
		JLabel a1=new JLabel("Sinif: ");
		a1.setFont(new Font("Dialog",Font.BOLD,13));
		a1.setBounds(50,170,400,50);
		frame.add(a1);
		
		
		JButton buton1=new JButton("Sinifi Goruntule");
		buton1.setBounds(230, 180, 150, 35);
		buton1.setForeground(Color.white);
		buton1.setFont(new Font("times new roman",Font.BOLD,16));
		buton1.setBackground(Color.GRAY);
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
					a1.setText(" Durum: Sinif Secilmedi ");	
				}
				else {
					String goruntulenecekSinif =list.getSelectedValue();
					model2.removeAllElements();
					
					//---------------------------------------------------------

					try {
						System.out.println(goruntulenecekSinif);
						goruntulenecekSinif = goruntulenecekSinif.substring(0,5);
						String goruntulenecekSinif2 = list.getSelectedValue().substring(0,list.getSelectedValue().indexOf(" "));
						if(goruntulenecekSinif2.length() > 6) {
							goruntulenecekSinif = goruntulenecekSinif2;
						}
						System.out.println(goruntulenecekSinif);
						System.out.println(goruntulenecekSinif);
						CallableStatement stmt = con.prepareCall("{ call listClass(?) }");
						stmt.setString(1, goruntulenecekSinif);
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

						for(int i = 0; i < resultArray.length; i = i + 10) {
							model2.addElement("id: " + resultArray[i] + " Isim: " + resultArray[i + 1] + " " +   resultArray[i + 2] );
						}

					}
					catch (Exception e1) {
						e1.printStackTrace();
					}

					
					//----------------------------------------------------------
					
					a1.setText("Sinif: "+list.getSelectedValue());
				}			
			}
		});
		
		JButton buton2=new JButton("Ana Menu");
		buton2.setBounds(20, 480, 150, 35);
		buton2.setForeground(Color.white);
		buton2.setFont(new Font("times new roman",Font.BOLD,16));
		buton2.setBackground(Color.GRAY);
		buton2.setFocusable(false);
		frame.add(buton2);
		
		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AnaMenu(con);
				frame.dispose();			
			}
		});

		frame.getContentPane().setBackground(Color.lightGray);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(440, 570);
		frame.setLayout(null);
		frame.setLocation(600, 200);
		frame.setVisible(true);	
	}
}
