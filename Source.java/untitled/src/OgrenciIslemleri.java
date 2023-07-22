

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OgrenciIslemleri {

	Connection con;

	OgrenciIslemleri(Connection con) {
		this.con = con;
		JFrame frame=new JFrame("Ogrenci Islemleri");
		frame.getContentPane().setBackground(Color.white);

		JButton buton1=new JButton("Yeni Ogrenci Kaydet");
		buton1.setBounds(20, 40, 300, 50);
		buton1.setForeground(Color.white);
		buton1.setFont(new Font("times new roman",Font.BOLD,16));
		buton1.setBackground(Color.GRAY);
		buton1.setFocusable(false);
		frame.add(buton1);

		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OgrenciEkle(con);
				frame.dispose();
			}
		});

		JButton buton2=new JButton("Ogrenci Sil");
		buton2.setBounds(20, 90, 300, 50);
		buton2.setForeground(Color.white);
		buton2.setFont(new Font("times new roman",Font.BOLD,16));
		buton2.setBackground(Color.GRAY);
		buton2.setFocusable(false);
		frame.add(buton2);

		JButton buton3=new JButton("Devamsizlik Guncelle");
		buton3.setBounds(20, 140, 300, 50);
		buton3.setForeground(Color.white);
		buton3.setFont(new Font("times new roman",Font.BOLD,16));
		buton3.setBackground(Color.GRAY);
		buton3.setFocusable(false);
		frame.add(buton3);

		JButton buton4=new JButton("Ogrenci Guncelle");
		buton4.setBounds(20, 190, 300, 50);
		buton4.setForeground(Color.white);
		buton4.setFont(new Font("times new roman",Font.BOLD,16));
		buton4.setBackground(Color.GRAY);
		buton4.setFocusable(false);
		frame.add(buton4);

		JButton buton5=new JButton("Yemek Durumlari Goruntule");
		buton5.setBounds(20, 240, 300, 50);
		buton5.setForeground(Color.white);
		buton5.setFont(new Font("times new roman",Font.BOLD,16));
		buton5.setBackground(Color.GRAY);
		buton5.setFocusable(false);
		frame.add(buton5);

		JButton buton7=new JButton("Ogrenci-Veli Bilgisi Goruntule");
		buton7.setBounds(20, 290, 300, 50);
		buton7.setForeground(Color.white);
		buton7.setFont(new Font("times new roman",Font.BOLD,16));
		buton7.setBackground(Color.GRAY);
		buton7.setFocusable(false);
		frame.add(buton7);

		JButton buton8=new JButton("Devamsizlik tarihleri goruntule");
		buton8.setBounds(20, 340, 300, 50);
		buton8.setForeground(Color.white);
		buton8.setFont(new Font("times new roman",Font.BOLD,16));
		buton8.setBackground(Color.GRAY);
		buton8.setFocusable(false);
		frame.add(buton8);
		frame.getContentPane().setBackground(Color.lightGray);

		buton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NonattendanceOver devamsizlikFiltrelere = new NonattendanceOver(con);
				frame.dispose();
			}
		});

		JButton buton6=new JButton("Ana Menu");
		//-----------------------------------------------------------------------
		buton6.setBounds(200, 460, 150, 35);
		//-----------------------------------------------------------------------
		buton6.setForeground(Color.white);
		buton6.setFont(new Font("times new roman",Font.BOLD,16));
		buton6.setBackground(Color.GRAY);
		buton6.setFocusable(false);
		frame.add(buton6);

		buton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditKid(con);
				frame.dispose();
			}
		});

		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OgrenciSil(con);
				frame.dispose();
			}
		});

		buton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NonAttendanceGUI(con);
						frame.dispose();
			}
		});

		buton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new YemekDurumlariGoruntule(con);
				frame.dispose();
			}
		});

		buton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new AnaMenu(con);
				frame.dispose();
			}
		});

		buton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KidGuardianGUI(con);
				frame.dispose();
			}
		});

		//-------------------------------------------------------------------------------

		JButton buton11=new JButton("Adrese Gore Ogrencileri Goruntule");
		buton11.setBounds(20, 390, 300, 50);
		buton11.setForeground(Color.white);
		buton11.setFont(new Font("times new roman",Font.BOLD,16));
		buton11.setBackground(Color.GRAY);
		buton11.setFocusable(false);
		frame.add(buton11);

		buton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdresOgrenciGoruntuleme adresOgrenci = new AdresOgrenciGoruntuleme(con);
				frame.dispose();
			}
		});
		//--------------------------------------------------------------------------------

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//--------------------------------------------------
		frame.setLocation(600, 210);
		frame.setSize(410, 550);
		//------------------------------------------------------
		frame.setLayout(null);
		frame.setVisible(true);

	}

}
