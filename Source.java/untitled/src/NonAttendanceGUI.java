/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Home PC
 */
public class NonAttendanceGUI extends javax.swing.JFrame {

    Connection con;
    /**
     * Creates new form NonAttendanceGUI
     */
    public NonAttendanceGUI(Connection con) {
        getContentPane().setBackground(Color.lightGray);
        this.con = con;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NonAttendanceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NonAttendanceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NonAttendanceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NonAttendanceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        initComponents();
        setVisible(true);




    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputField = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kidList = new javax.swing.JList<>();
        mainMenuButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputField.setText("Non-Attendance");

        kidList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(kidList);

        mainMenuButton.setText("Main Menu");

        okButton.setText("OK");

        jTextField1.setText("");

        jLabel2.setText("Choose from list or enter an ID.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainMenuButton)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainMenuButton)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        setLocation(600, 300);
        pack();

        PreparedStatement stmt;

        DefaultListModel model = new DefaultListModel();
        try{
            ResultSet kids = Kid.getAllKids(con);
            while(kids.next()){
                stmt = con.prepareCall("{ call getTotalNonAttendance(?) }");
                stmt.setInt(1, kids.getInt("kidId"));
                ResultSet res = stmt.executeQuery();
                res.next();
                model.addElement(kids.getInt("kidid") +"   "  + kids.getString("firstName") + "   " + kids.getString("lastname") + "   " + "non-attendance: " + "   " + res.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        kidList.setModel(model);




        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String kidid = jTextField1.getText();
                    PreparedStatement statement = con.prepareStatement("INSERT INTO nonattendances (kidid, date) VALUES (?, ?)");
                    java.util.Date utilDate = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                    statement.setInt(1, Integer.parseInt(kidid));
                    statement.setDate(2, sqlDate);
                    statement.execute();
                }

                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    if(ex.getMessage().equals("ERROR: no\n" +
                            "  Where: PL/pgSQL function attendancetriggerfunction() line 14 at RAISE")){
                        JOptionPane.showMessageDialog(null, "A non-attendance for this kid already exists for today.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Check your input!");
                        ex.printStackTrace();
                    }

                }

                refreshList();
            }
        });


        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int kidid = Integer.parseInt(kidList.getSelectedValue().split(" ")[0]);
                    jTextField1.setText(String.valueOf(kidid));
                }
            }
        };
        inputField.addMouseListener(mouseListener);


        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new OdemeIslemleri(con);
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AnaMenu(con);
            }
        });






    }// </editor-fold>//GEN-END:initComponents


    public void refreshList() {
        PreparedStatement stmt;

        DefaultListModel model = new DefaultListModel();
        try{
            ResultSet kids = Kid.getAllKids(con);
            while(kids.next()){
                stmt = con.prepareCall("{ call getTotalNonAttendance(?) }");
                stmt.setInt(1, kids.getInt("kidId"));
                ResultSet res = stmt.executeQuery();
                res.next();
                model.addElement(kids.getInt("kidid") +"   "  + kids.getString("firstName") + "   " + kids.getString("lastname") + "   " + "non-attendance: " + "   " + res.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        kidList.setModel(model);


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel inputField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> kidList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}