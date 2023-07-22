

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

public class OgrenciSil {

	Connection con;
	OgrenciSil(Connection con) {
		this.con = con;
		JFrame frame = new JFrame("Ogrenci Silme Sayfasi");

		DefaultListModel<String> model = new DefaultListModel<>();
		//-----------------------------------------------------------------------------------


		//-----------------------------------------------------------------------------------

		JList<String> list = new JList<>(model);
		list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane();

		//---------------------------------------------------------
		scrollPane.setBounds(40, 20, 320, 200);
		//-
		scrollPane.setViewportView(list);
		frame.add(scrollPane);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * from kid");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.addElement(rs.getString("kidId") + " " + rs.getString("firstName") + " " + rs.getString("lastName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.setModel(model);


		JLabel a1 = new JLabel("");
		a1.setFont(new Font("Dialog", Font.BOLD, 13));
		//--------------------------------------------------------
		a1.setBounds(10, 270, 400, 50);
		a1.setForeground(Color.red);

		a1.setBounds(10, 270, 400, 50);
		a1.setForeground(Color.red);


		//---
		frame.add(a1);


		JButton buton1 = new JButton("Sil");

		buton1.setBounds(290, 240, 90, 35);
		buton1.setBounds(290, 240, 90, 35);
		buton1.setFont(new Font("times new roman", Font.BOLD, 16));
		buton1.setBackground(Color.GRAY);
		buton1.setFocusable(false);
		frame.add(buton1);

		JButton buton2 = new JButton("Ana Menu");
		//--------------------------------------------------------
		buton2.setBounds(10, 240, 90, 35);
		//--------------------------------------------------------

		buton2.setBackground(Color.GRAY);
		buton2.setForeground(Color.white);
		buton2.setFocusable(false);
		frame.add(buton2);

		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() == -1) {
					a1.setText(" Durum: Basarisiz ");
				} else {
					String silinecekId = list.getSelectedValue();
					//parse the string to get the id
					silinecekId = silinecekId.substring(0, silinecekId.indexOf(" "));
					System.out.println(silinecekId);

					try {
						PreparedStatement statement = con.prepareStatement("DELETE FROM kid WHERE kidId=?");
						statement.setInt(1, Integer.parseInt(silinecekId));
						statement.execute();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					//----------------------------------------------------------
					a1.setText(" Durum: Basarili ");
				}
				refreshList(model);
			}
		});

		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu anaMenu = new AnaMenu(con);
				frame.dispose();
			}
		});


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(null);
		frame.setLocation(600, 300);
		//--------------------------------------------------------------
		frame.setSize(440, 350);
		//--------------------------------------------------------------
		frame.setVisible(true);
	}

	void refreshList(DefaultListModel model) {
		model.clear();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * from kid order by kidId");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.addElement(rs.getString("kidId") + " " + rs.getString("firstName") + " " + rs.getString("lastName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
