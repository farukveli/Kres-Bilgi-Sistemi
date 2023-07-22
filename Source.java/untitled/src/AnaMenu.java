
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;


public class AnaMenu {

	public  Connection conn;
	public AnaMenu(Connection conn) {
		this.conn = conn;


		JFrame frame = new JFrame("Ana Menu");
		frame.getContentPane().setBackground(Color.white);



		JLabel a = new JLabel("Kres Bilgi Sistemi");
		a.setForeground(Color.yellow);
		a.setFont(new Font("colonna mt",Font.BOLD,20));
		a.setFont(new Font("jokerman",Font.BOLD,20));
		a.setBounds(10,0,400,40);
		frame.add(a);


		frame.getContentPane().setBackground(Color.lightGray);



		JButton buton1=new JButton("Tum Ogrencileri Goruntule");
		buton1.setBounds(20, 40, 300, 50);
		buton1.setForeground(Color.white);
		buton1.setFont(new Font("times new roman",Font.BOLD,16));
		buton1.setBackground(Color.GRAY);
		buton1.setFocusable(false);
		frame.add(buton1);

		//---------------------------------------------------------------------------------
		//change buton2 color to gray
		JButton buton2=new JButton("Odeme Islemleri");
		buton2.setBounds(20, 90, 300, 50);
		buton2.setForeground(Color.white);
		buton2.setFont(new Font("times new roman",Font.BOLD,16));
		buton2.setBackground(Color.GRAY);
		buton2.setFocusable(false);
		frame.add(buton2);
		buton2.setBackground(Color.gray);


		//------------------------------------------------------------------------------------


		JButton buton3=new JButton("Ogrenci Islemleri");
		buton3.setBounds(20, 140, 300, 50);
		buton3.setForeground(Color.white);
		buton3.setFont(new Font("times new roman",Font.BOLD,16));
		buton3.setBackground(Color.GRAY);
		buton3.setFocusable(false);
		frame.add(buton3);

		JButton buton4 = new JButton("Ogretmen Islemleri");
		buton4.setBounds(20, 190, 300, 50);
		buton4.setForeground(Color.white);
		buton4.setFont(new Font("times new roman",Font.BOLD,16));
		buton4.setBackground(Color.GRAY);
		buton4.setFocusable(false);
		frame.add(buton4);

		//---------------------------------------------------------------------------
		JButton buton5=new JButton("Sinif Goruntule");
		buton5.setBounds(20, 240, 300, 50);
		buton5.setForeground(Color.white);
		buton5.setFont(new Font("times new roman",Font.BOLD,16));
		buton5.setBackground(Color.GRAY);
		buton5.setFocusable(false);
		frame.add(buton5);
		//-----------------------------------------------------------------------------


		//------------------------------------------------------------------------
		JButton buton6=new JButton("Istatistik");
		buton6.setBounds(20, 290, 300, 50);
		buton6.setForeground(Color.white);
		buton6.setFont(new Font("times new roman",Font.BOLD,16));
		buton6.setBackground(Color.GRAY);
		buton6.setFocusable(false);
		frame.add(buton6);
		//------------------------------------------------------------------------

		buton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AllKidsGUI(conn);
			}
		});
		buton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgretmenIslemleri ogretmenIslemleri = new OgretmenIslemleri(conn);
				frame.dispose();
			}
		});


		buton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinifGoruntule sinifGoruntuleme = new SinifGoruntule(conn);
				frame.dispose();
			}
		});

		buton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OgrenciIslemleri(conn);
				frame.dispose();
			}
		});

		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OdemeIslemleri odemeIslemleri=new OdemeIslemleri(conn);
				frame.dispose();
			}
		});

		//------------------------------------------------------------------------
		buton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Istatistik istatislik = new Istatistik(conn);
				frame.dispose();
			}
		});
		//------------------------------------------------------------------------


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//------------------------------------------------------------------------
		frame.setSize(365, 410);
		//------------------------------------------------------------------------
		frame.setLayout(null);
		frame.setVisible(true);


		frame.setLocation(600, 250);
		frame.setVisible(true);
	}


}


