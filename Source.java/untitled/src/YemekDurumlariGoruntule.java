

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class YemekDurumlariGoruntule {

	Connection con;
	YemekDurumlariGoruntule(Connection conn){
		this.con = conn;
		JFrame frame=new JFrame("Yemek Durumlari Goruntuleme Sayfasi");
		
		JCheckBox a1,a2; 
		
		a1=new JCheckBox("Kahvalti");
		a1.setFont(new Font("Dialog",Font.BOLD,15));
        a1.setBounds(10,10,150,20); 
        a1.setFocusable(false);
        frame.add(a1);
        
        a2=new JCheckBox("Ogle Yemegi");
        a2.setFont(new Font("Dialog",Font.BOLD,15));
        a2.setBounds(160,10,150,20);  
        a2.setFocusable(false);
        frame.add(a2);
        
		JButton buton1=new JButton("Goruntule");
		buton1.setBounds(250,250, 130, 35);
		buton1.setBackground(Color.GRAY);
		buton1.setFont(new Font("times new roman",Font.BOLD,16));
		buton1.setForeground(Color.white);
		buton1.setFocusable(false);
		frame.add(buton1);
		
		DefaultListModel<String> model=new DefaultListModel<>();
		JList<String> list=new JList<>(model);
		list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 370,200 );
		scrollPane.setViewportView(list);
		list.setForeground(Color.yellow);
		list.setBackground(Color.darkGray);
		frame.add(scrollPane);
		
		
		JButton buton2=new JButton("Ana Menu");
		buton2.setBounds(10, 250, 130, 35);
		buton2.setForeground(Color.white);
		buton2.setFont(new Font("times new roman",Font.BOLD,16));
		buton2.setBackground(Color.GRAY);
		buton2.setFocusable(false);
		frame.add(buton2);
		
		
		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					model.removeAllElements();
					String goruntulenecekDeger;
					try{
						if(a1.isSelected() && a2.isSelected()){
							goruntulenecekDeger="breakfast";
							//----------------------------------------
							//model.addElement("aaa");

							ResultSet set = Kid.breakfastAndLunch(con);
							while (set.next()) {
								model.addElement(set.getString("kidId") + " " + set.getString("firstName") + " " + set.getString("lastName") + " " + set.getString("classroom"));
							}

							//---------------------------------------
						}
						else if(a1.isSelected()){
							goruntulenecekDeger="lunch";
							//----------------------------------------
							//model.addElement("bbb");
							ResultSet set = Kid.breakfastOnly(con);
							while (set.next()) {
								model.addElement(set.getString("kidId") + " " + set.getString("firstName") + " " + set.getString("lastName") + " " + set.getString("classroom"));
							}
							//---------------------------------------
						}

						else if(a2.isSelected()){
							goruntulenecekDeger="lunch";
							//----------------------------------------
							//model.addElement("bbb");
							ResultSet set = Kid.lunchOnly(con);
							while (set.next()) {
								model.addElement(set.getString("kidId") + " " + set.getString("firstName") + " " + set.getString("lastName") + " " + set.getString("classroom"));
							}
							//---------------------------------------
						}

						else {
							ResultSet set = Kid.noMeal(con);
							while (set.next()) {
								model.addElement(set.getString("kidId") + " " + set.getString("firstName") + " " + set.getString("lastName") + " " + set.getString("classroom"));
							}
						}
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		
		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu anaMenu = new AnaMenu(conn);
				frame.dispose();			
			}
		});
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(440, 350);
		frame.setLayout(null);
		frame.setLocation(600, 300);
		frame.setVisible(true);	
	}
}
