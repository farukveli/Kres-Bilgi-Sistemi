import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OgrenciGuncelle {

	public OgrenciGuncelle() {
	}

	public static void ogrenciGuncelleGui() {
		JFrame frame=new JFrame("Ogrenci Guncelleme Sayfasi");	
		
		JCheckBox a1,a2,a3,a4,a5,a6,a7,a8,a9; 
		
		a1=new JCheckBox("Ad");
		a1.setFont(new Font("Dialog",Font.BOLD,13));
        a1.setBounds(10,10,150,20);  
        a1.setFocusable(false);
        frame.add(a1);
        
        a2=new JCheckBox("Soyad");
        a2.setFont(new Font("Dialog",Font.BOLD,13));
        a2.setBounds(10,30,150,20);  
        a2.setFocusable(false);
        frame.add(a2);
        
        a3=new JCheckBox("Dogum Tarihi");
        a3.setFont(new Font("Dialog",Font.BOLD,13));
        a3.setBounds(10,50,150,20);  
        a3.setFocusable(false);
        frame.add(a3);
        
        a4=new JCheckBox("Kahvalti Secenegi");
        a4.setFont(new Font("Dialog",Font.BOLD,13));
        a4.setBounds(10,70,150,20);  
        a4.setFocusable(false);
        frame.add(a4);
        
		a5=new JCheckBox("Ogle Yemegi Secenegi");
		a5.setFont(new Font("Dialog",Font.BOLD,13));
		a5.setBounds(10,90,170,20);  
		a5.setFocusable(false);
        frame.add(a5);
        
        a6=new JCheckBox("Cinsiyet");
        a6.setFont(new Font("Dialog",Font.BOLD,13));
        a6.setBounds(200,10,150,20);  
        a6.setFocusable(false);
        frame.add(a6);
        
        a7=new JCheckBox("Kayit Tipi");
        a7.setFont(new Font("Dialog",Font.BOLD,13));
        a7.setBounds(200,30,150,20);  
        a7.setFocusable(false);
        frame.add(a7);
        
        a8=new JCheckBox("Devamsizlik");
        a8.setFont(new Font("Dialog",Font.BOLD,13));
        a8.setBounds(200,50,150,20);  
        a8.setFocusable(false);
        frame.add(a8);
        
        a9=new JCheckBox("Sinif");
        a9.setFont(new Font("Dialog",Font.BOLD,13));
        a9.setBounds(200,70,150,20);  
        a9.setFocusable(false);
        frame.add(a9);
        
		JLabel label1=new JLabel(" Guncellenecek Ogrenci ID: ");
		label1.setFont(new Font("Dialog",Font.BOLD,13));
		label1.setBounds(10,110,400,50);
		frame.add(label1);
		
		JLabel label2=new JLabel(" Guncel Deger: ");
		label2.setFont(new Font("Dialog",Font.BOLD,13));
		label2.setBounds(10,135,400,50);
		frame.add(label2);
		
		JLabel label3=new JLabel(" ");
		label3.setFont(new Font("Dialog",Font.BOLD,13));
		label3.setBounds(10,200,400,50);
		label3.setForeground(Color.red);
		frame.add(label3);
		
		JTextField text1= new JTextField();
		text1.setBounds(180,125,100,20);
		frame.add(text1);
		
		JTextField text2= new JTextField();
		text2.setBounds(180,150,100,20);
		frame.add(text2);
		
		JButton buton1=new JButton("Guncelle");
		buton1.setBounds(200,180, 100, 30);
		buton1.setBackground(Color.GRAY);
		buton1.setForeground(Color.white);
		buton1.setFocusable(false);
		frame.add(buton1);
		
		JButton buton2=new JButton("Ana Menu");
		buton2.setBounds(10,180, 100, 30);
		buton2.setBackground(Color.GRAY);
		buton2.setForeground(Color.white);
		buton2.setFocusable(false);
		frame.add(buton2);
		frame.getContentPane().setBackground(Color.lightGray);

		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new AnaMenu(co);
				frame.dispose();			
			}
		});
			
		buton1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//---------------------------------------------------------------
				String guncellenecekKisi=text1.getText();
				String guncelDeger=text2.getText();
				String guncellenecekDeger;
				
				if(a1.isSelected()){  
					guncellenecekDeger="firstname";
		        }  
				else if(a2.isSelected()){  
					guncellenecekDeger="lastname";
		        }  
				else if(a3.isSelected()){  
					guncellenecekDeger="birthdate";
		        }  
				else if(a4.isSelected()){  
					guncellenecekDeger="breakfast";
		        }  
				else if(a5.isSelected()){  
					guncellenecekDeger="lunch";
		        }  
				else if(a6.isSelected()){  
					guncellenecekDeger="gender";
		        }  
				else if(a7.isSelected()){  
					guncellenecekDeger="regtype";
		        } 
				else if(a8.isSelected()){  
					guncellenecekDeger="nonattendances";
		        }
				else if(a9.isSelected()){  
					guncellenecekDeger="classroom";
		        }
				else {
					guncellenecekDeger="HATA";
				}
				//----------------------------------------------------------------
				//----------------------------------------------------------------

				
				//---------------------------------------------------------------
				//----------------------------------------------------------------
				label3.setText(" Durum: Basarili ");		
			}
		});
		 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(360, 280);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}