

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OgretmenEkle {


	java.sql.Connection con;
	OgretmenEkle(Connection con){


		this.con=con;

		JFrame frame=new JFrame("Ogretmen Ekleme Sayfasi");
		
		JLabel a1=new JLabel(" Ad: ");
		a1.setFont(new Font("Dialog",Font.BOLD,13));
		a1.setBounds(10,10,400,50);
		frame.add(a1);
		
		JLabel a2=new JLabel(" Soyad: ");
		a2.setFont(new Font("Dialog",Font.BOLD,13));
		a2.setBounds(10,40,400,50);
		frame.add(a2);
		
		JLabel a3=new JLabel(" Adres: ");
		a3.setFont(new Font("Dialog",Font.BOLD,13));
		a3.setBounds(10,70,400,50);
		frame.add(a3);
		
		JLabel a4=new JLabel(" Telefon: ");
		a4.setFont(new Font("Dialog",Font.BOLD,13));
		a4.setBounds(10,100,400,50);
		frame.add(a4);
		
		JLabel label3=new JLabel(" ");
		label3.setFont(new Font("Dialog",Font.BOLD,13));
		label3.setBounds(10,200,400,50);
		label3.setForeground(Color.red);
		frame.add(label3);
		
		JTextField text1= new JTextField();
		text1.setBounds(160,25,120,20);
		frame.add(text1);
		
		JTextField text2= new JTextField();
		text2.setBounds(160,55,120,20);
		frame.add(text2);
		
		JTextField text3= new JTextField();
		text3.setBounds(160,85,120,20);
		frame.add(text3);

		
		JTextField text4= new JTextField();
		text4.setBounds(160,115,120,20);
		frame.add(text4);
		
		JButton buton1=new JButton("Ekle");
		buton1.setBounds(200,160, 100, 30);
		buton1.setBackground(Color.GRAY);
		buton1.setForeground(Color.white);
		buton1.setFocusable(false);
		frame.add(buton1);
		frame.getContentPane().setBackground(Color.lightGray);

		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname = text1.getText();
				String lastname = text2.getText();
				String adress = text3.getText();
				String phone = text4.getText();
				
				//----------------------------------------------------------------
				try {
					PreparedStatement ps = con.prepareStatement("INSERT INTO teacher VALUES (nextval('student_id_seq'),?,?,?,?)");
					ps.setString(1, firstname);
					ps.setString(2, lastname);
					ps.setString(3, adress);
					ps.setString(4, phone);
					ps.executeUpdate();
					label3.setText("Ogretmen Eklendi");
				}
				catch(Exception e1) {
					e1.printStackTrace();
					label3.setText("Ogretmen Eklenemedi");
				}


				
				//---------------------------------------------------------------
				label3.setText(" Durum: Basarili ");			
			}
		});
	
		JButton buton2=new JButton("Ana Menu");
		buton2.setBounds(10,160, 100, 30);
		buton2.setBackground(Color.GRAY);
		buton2.setForeground(Color.white);
		buton2.setFocusable(false);
		frame.add(buton2);
		
		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu anaMenu = new AnaMenu((java.sql.Connection) con);
				frame.dispose();			
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(330, 290);
		frame.setLayout(null);
		frame.setLocation(600, 250);
		frame.setVisible(true);
		
	}
}
