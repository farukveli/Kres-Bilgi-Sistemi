import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

public class OgrenciEkle {

	Connection conn;

	public OgrenciEkle(Connection conn) {
		this.conn = conn;

		JFrame frame=new JFrame("Ogrenci Ekleme Sayfasi");


		JLabel a1=new JLabel(" Ad: ");
		a1.setFont(new Font("Dialog",Font.BOLD,13));
		a1.setBounds(10,10,400,50);
		frame.add(a1);

		JLabel a2=new JLabel(" Soyad: ");
		a2.setFont(new Font("Dialog",Font.BOLD,13));
		a2.setBounds(10,40,400,50);
		frame.add(a2);

		JLabel a3=new JLabel(" Dogum Tarihi: ");
		a3.setFont(new Font("Dialog",Font.BOLD,13));
		a3.setBounds(10,70,400,50);
		frame.add(a3);

		JLabel a4=new JLabel(" Kahvalti Secenegi: ");
		a4.setFont(new Font("Dialog",Font.BOLD,13));
		a4.setBounds(10,100,400,50);
		frame.add(a4);

		JLabel a5=new JLabel(" Ogle Yemegi Secenegi: ");
		a5.setFont(new Font("Dialog",Font.BOLD,13));
		a5.setBounds(10,130,400,50);
		frame.add(a5);

		JLabel a6=new JLabel(" Cinsiyet: ");
		a6.setFont(new Font("Dialog",Font.BOLD,13));
		a6.setBounds(10,160,400,50);
		frame.add(a6);

		JLabel a7=new JLabel(" Kayit Tipi: ");
		a7.setFont(new Font("Dialog",Font.BOLD,13));
		a7.setBounds(10,190,400,50);
		frame.add(a7);


		JLabel a7a=new JLabel("Toplam Taksit Sayisi: ");
		a7a.setFont(new Font("Dialog",Font.BOLD,13));
		a7a.setBounds(10,220,400,50);
		frame.add(a7a);

		JLabel a7b=new JLabel(" Toplam  Tutar ");
		a7b.setFont(new Font("Dialog",Font.BOLD,13));
		a7b.setBounds(10,250,400,50);
		frame.add(a7b);
		//---------------------------------------------------------------

		//------------------------------------------------------------------
		JLabel a7c=new JLabel(" Sinif ");
		a7c.setFont(new Font("Dialog",Font.BOLD,13));
		a7c.setBounds(10,280,400,50);
		frame.add(a7c);
		//------------------------------------------------------------------

		JLabel bilgi=new JLabel(" Veli Islemleri: ");
		bilgi.setFont(new Font("Dialog",Font.BOLD,14));
		bilgi.setForeground(Color.red);
		bilgi.setBounds(95,305,400,50);
		frame.add(bilgi);


		JLabel a8=new JLabel(" Veli Adi: ");
		a8.setFont(new Font("Dialog",Font.BOLD,13));
		a8.setBounds(10,330,400,50);
		frame.add(a8);

		JLabel a9=new JLabel(" Veli Soyadi: ");
		a9.setFont(new Font("Dialog",Font.BOLD,13));
		a9.setBounds(10,360,400,50);
		frame.add(a9);

		JLabel a10=new JLabel(" Veli Adresi: ");
		a10.setFont(new Font("Dialog",Font.BOLD,13));
		a10.setBounds(10,390,400,50);
		frame.add(a10);

		JLabel a11=new JLabel(" Veli Telefon No: ");
		a11.setFont(new Font("Dialog",Font.BOLD,13));
		a11.setBounds(10,420,400,50);
		frame.add(a11);

		JLabel a12=new JLabel(" Veli Akrabalik: ");
		a12.setFont(new Font("Dialog",Font.BOLD,13));
		a12.setBounds(10,450,400,50);
		frame.add(a12);

		JLabel durum=new JLabel(" ");
		durum.setFont(new Font("Dialog",Font.BOLD,13));
		durum.setBounds(10,525,400,50);
		durum.setForeground(Color.red);
		frame.add(durum);


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

		JTextField text5= new JTextField();
		text5.setBounds(160,145,120,20);
		frame.add(text5);

		JTextField text6= new JTextField();
		text6.setBounds(160,175,120,20);
		frame.add(text6);

		JTextField text7= new JTextField();
		text7.setBounds(160,205,120,20);
		frame.add(text7);

		JTextField text7a= new JTextField();
		text7a.setBounds(160,235,120,20);
		frame.add(text7a);

		JTextField text7b= new JTextField();
		text7b.setBounds(160,265,120,20);
		frame.add(text7b);

		//-------------------------------------------------------
		JTextField text7c= new JTextField();
		text7c.setBounds(160,295,120,20);
		frame.add(text7c);
		//-----------------------------------------------------


		JTextField text8= new JTextField();
		text8.setBounds(160,350,120,20);
		frame.add(text8);

		JTextField text9= new JTextField();
		text9.setBounds(160,380,120,20);
		frame.add(text9);

		JTextField text10= new JTextField();
		text10.setBounds(160,410,120,20);
		frame.add(text10);

		JTextField text11= new JTextField();
		text11.setBounds(160,440,120,20);
		frame.add(text11);

		JTextField text12= new JTextField();
		text12.setBounds(160,470,120,20);
		frame.add(text12);


		JButton buton1=new JButton("Ekle");
		//----------------------------------------------------
		buton1.setBounds(200,500, 100, 30);
		//----------------------------------------------------
		buton1.setBackground(Color.GRAY);
		buton1.setForeground(Color.white);
		buton1.setFocusable(false);
		frame.add(buton1);


		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname =text1.getText();
				String lastname =text2.getText();
				String birthdate =text3.getText();
				String breakfast =text4.getText();
				String lunch =text5.getText();
				String gender =text6.getText();
				String regtype =text7.getText();

				String firstnameVeli =text8.getText();
				String lastNameVeli = text9.getText();
				String address = text10.getText();
				String phone = text11.getText();
				String deptype =text12.getText();

				String classroom=text7c.getText();


				//----------------------------------------------------------------

				try {

					//check whether any of the strings is empty
					if(firstname.equals("") || lastname.equals("") || birthdate.equals("") || breakfast.equals("") || lunch.equals("") ||
							gender.equals("") || regtype.equals("") || firstnameVeli.equals("") || lastNameVeli.equals("") ||
						address.equals("") || phone.equals("") || deptype.equals("")) 	{
						JOptionPane.showMessageDialog(null, "Please fill all the input fields!");
					}



					PreparedStatement statement = conn.prepareStatement("INSERT INTO kid VALUES (nextval('student_id_seq'),?,?,?,?,?,?,?,?,?)");



					SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
					java.util.Date date = sdf1.parse(birthdate);
					java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());





					Calendar cal = Calendar.getInstance();
					cal.setTime(new java.util.Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 365 * 2));
					int year = cal.get(Calendar.YEAR);

					System.out.println("int year: " + year);
					System.out.println("sqlStartDate: " + sqlStartDate.getYear());


					String parsedYear = birthdate.substring(6);
					Integer birthYear = Integer.parseInt(parsedYear);
					System.out.println(parsedYear);
					System.out.println(birthYear);

					statement.setString(1, firstname);
					statement.setString(2, lastname);
					statement.setDate(3, sqlStartDate);

					statement.setBoolean(4, lunch.equals("t"));
					statement.setBoolean(5, breakfast.equals("t"));


					if(breakfast.equals("t") && lunch.equals("t") && !regtype.equals("full")) {
						JOptionPane.showMessageDialog(null, "Hem kahvalti hem ogle yemegi icin full time kayit tipini secin!");
						throw new Exception();
					}
					statement.setString(6, gender);
					statement.setString(7, regtype);
					statement.setInt(8, 0);

					if(birthYear == year - 4) {
						JOptionPane.showMessageDialog(null, "Dogum tarihi 2-5 yil arasinda olmali");
						return;
					}

					statement.setString(9, classroom);

					String sql = "SELECT numofStudent FROM classroom WHERE className = '" + classroom + "'";
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					rs.next();
					int numofStudentBefore = rs.getInt(1);
					statement.execute();

					sql = "SELECT numofStudent FROM classroom WHERE className = '" + classroom + "'";
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					rs.next();
					int numofStudentAfter = rs.getInt(1);

					if(numofStudentBefore != numofStudentAfter) {
						JOptionPane.showMessageDialog(null, "TRIGGER CALLED");
						return;
					}

				}
				catch (Exception ex) {
					System.out.println(ex.getMessage());
					if(ex.getMessage().equals("ERROR: no\n" +
							"  Where: PL/pgSQL function attendancetriggerfunction() line 14 at RAISE")){
						JOptionPane.showMessageDialog(null, "A non-attendance for this kid already exists for today.");
					}
					else {
						JOptionPane.showMessageDialog(null, "Check your inputs!");
						ex.printStackTrace();
					}
					//create pop up

					return;

				}


				try {

					Statement statement1 = conn.createStatement();
					String sql = "SELECT max(kidId) FROM kid";
					ResultSet rs = statement1.executeQuery(sql);
					rs.next();
					int kidId = rs.getInt(1);

					PreparedStatement statement = conn.prepareStatement("INSERT INTO guardian  VALUES  (?, ?, ?, ?, ?, ?)");
					statement.setString(1, firstnameVeli);
					statement.setString(2, lastNameVeli);
					statement.setString(3, address);
					statement.setString(4, phone);
					statement.setString(5, deptype);
					statement.setInt(6, kidId);
					statement.execute();
					JOptionPane.showMessageDialog(null, "New kid has been added!");

					String taksitSayisi = text7a.getText();
					String toplamTutar = text7b.getText();


					PreparedStatement statement2 = conn.prepareStatement("INSERT INTO payment VALUES (" + kidId + ", ?, ?, ?, ?)");

					//todays date sql
					java.util.Date today = new java.util.Date();
					java.sql.Date sqlToday = new java.sql.Date(today.getTime());

					System.out.println(taksitSayisi);
					statement2.setDate(1, sqlToday);
					statement2.setInt(2, Integer.valueOf(taksitSayisi));
					statement2.setInt(3, 1);
					statement2.setInt(4, Integer.valueOf(toplamTutar));
					statement2.execute();


				}

				catch (Exception e2) {
					e2.printStackTrace();
				}


				//---------------------------------------------------------------

			}
		});

		JButton buton2 = new JButton("Ana Menu");
		//--------------------------------------------------------------
		buton2.setBounds(10,500, 100, 30);
		//--------------------------------------------------------------
		buton2.setBackground(Color.GRAY);
		buton2.setForeground(Color.white);
		buton2.setFocusable(false);
		frame.add(buton2);

		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu ana = new AnaMenu(conn);
				frame.dispose();
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//--------------------------------------------------------
		frame.setSize(320, 580);
		frame.setLocation(600, 200);
		//-------------------------------------------------------------
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.lightGray);

	}



}
