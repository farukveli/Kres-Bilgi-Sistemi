

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OgretmenIslemleri {

	Connection conn;
	OgretmenIslemleri(Connection conn) {
		this.conn = conn;
		JFrame frame=new JFrame("Ogretmen Islemleri");
		frame.getContentPane().setBackground(Color.white);
		
		JButton buton1=new JButton("Yeni Ogretmen Kaydet");
		buton1.setBounds(20, 40, 300, 50);
		buton1.setForeground(Color.white);
		buton1.setFont(new Font("times new roman",Font.BOLD,16));
		buton1.setBackground(Color.GRAY);
		buton1.setFocusable(false);
		frame.add(buton1);
		
		JButton buton2=new JButton("Ogretmen Sil");
		buton2.setBounds(20, 90, 300, 50);
		buton2.setForeground(Color.white);
		buton2.setFont(new Font("times new roman",Font.BOLD,16));
		buton2.setBackground(Color.GRAY);
		buton2.setFocusable(false);
		frame.add(buton2);
		
		JButton buton3=new JButton("Ana Menu");
		buton3.setBounds(220,200, 100, 40);
		buton3.setBackground(Color.GRAY);
		buton3.setForeground(Color.white);
		buton3.setFocusable(false);
		frame.add(buton3);

		JButton buton4=new JButton("Tum Ogretmenleri Goruntule");
		buton4.setBounds(20, 140, 300, 50);
		buton4.setForeground(Color.white);
		buton4.setFont(new Font("times new roman",Font.BOLD,16));
		buton4.setBackground(Color.GRAY);
		buton4.setFocusable(false);
		frame.add(buton4);

		buton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgretmenGoruntule ogretmenGoruntule=new OgretmenGoruntule(conn);
				frame.dispose();
			}
		});

		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgretmenEkle ogretmenEkleSayfasi = new OgretmenEkle(conn);
				frame.dispose();			
			}
		});
		
		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciSil ogretmenSilSayfasi = new OgrenciSil(conn);
				frame.dispose();			
			}
		});
		
		buton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu anaMenu=new AnaMenu(conn);
				frame.dispose();			
			}
		});

		frame.getContentPane().setBackground(Color.lightGray);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(370, 300);
		frame.setLocation(600, 250);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
