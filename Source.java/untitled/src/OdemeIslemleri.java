
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OdemeIslemleri {

    Connection con;
    OdemeIslemleri(Connection con){
        this.con = con;
        JFrame frame=new JFrame("Odeme Islemleri");
        frame.getContentPane().setBackground(Color.lightGray);


        JButton buton1=new JButton("Odeme Yap");
        buton1.setBounds(20, 40, 300, 50);
        buton1.setForeground(Color.white);
        buton1.setFont(new Font("times new roman",Font.BOLD,16));
        buton1.setBackground(Color.GRAY);
        buton1.setFocusable(false);
        frame.add(buton1);

        JButton buton2=new JButton("Odeme Durumlari Goruntule");
        buton2.setBounds(20, 90, 300, 50);
        buton2.setForeground(Color.white);
        buton2.setFont(new Font("times new roman",Font.BOLD,16));
        buton2.setBackground(Color.GRAY);
        buton2.setFocusable(false);
        frame.add(buton2);

        JButton buton3=new JButton("Ana Menu");
        buton3.setBounds(200, 160, 150, 35);
        buton3.setForeground(Color.white);
        buton3.setFont(new Font("times new roman",Font.BOLD,16));
        buton3.setBackground(Color.GRAY);
        buton3.setFocusable(false);
        frame.add(buton3);

        buton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PaymentGUI payment = new PaymentGUI(con);
            }
        });

        buton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PaymentStatusGUI paymentStatus = new PaymentStatusGUI(con);
                frame.dispose();
            }
        });

        buton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AnaMenu anaMenu = new AnaMenu(con);
                frame.dispose();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(600, 250);
        frame.setSize(400, 270);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
