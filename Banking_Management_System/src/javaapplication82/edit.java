/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication82;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author CMC PC
 */
public class edit  implements ActionListener
{
   
    JTextField tf1,tf2,tf3,tf4,tf5;
    JLabel l1,l2,l3,l4,l5;
    JButton b1=new JButton("Update");
    JFrame jf1;
    String email;
    public void edit(String s1)
    {
        email=s1;
        jf1=new JFrame("Edit Profile");
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasweta1", "root", "");
        Statement st=con.createStatement();
        String sql="select * from registration1 WHERE email='"+s1+"'";
        ResultSet rs=st.executeQuery(sql);
        if(rs.next())
        {
        l1=new JLabel("Name");
        l1.setBounds(50, 100, 120, 30);
        jf1.add(l1);
        tf1=new JTextField();
        tf1.setText(rs.getString(1));
        tf1.setBounds(250, 100, 150, 30);
        jf1.add(tf1);
        l2=new JLabel("Address");
        l2.setBounds(50, 150, 130, 30);
        jf1.add(l2);
        tf2=new JTextField();
        tf2.setText(rs.getString(2));
        tf2.setBounds(250, 150, 150, 30);
        jf1.add(tf2);
        l3=new JLabel("Mobile");
        l3.setBounds(50, 200, 130, 30);
        jf1.add(l3);
        tf3=new JTextField();
        tf3.setText(rs.getString(3));
        tf3.setBounds(250, 200, 150, 30);
        jf1.add(tf3);
        l4=new JLabel("Email");
        l4.setBounds(50, 250, 130, 30);
        jf1.add(l4);
        tf4=new JTextField();
        tf4.setText(rs.getString(4));
        tf4.setBounds(250, 250, 150, 30);
        jf1.add(tf4);
        }
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        b1.setBounds(50, 400, 80, 30);
        jf1.add(b1);
        b1.addActionListener(this);
        jf1.setSize(500,500);
        jf1.setLayout(null);
        jf1.setVisible(true); 
    }
    public void actionPerformed(ActionEvent e)
  {
        String s1,s2,s3,s4,s5;
        s1=tf1.getText();
        s2=tf2.getText();
        s3=tf3.getText();
        s4=tf4.getText();
         
         try
         {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasweta1", "root", "");
         Statement st=con.createStatement();
         String sql="update registration1 set name='"+s1+"',address='"+s2+"',mobile='"+s3+"' where email='"+email+"'";
         st.executeUpdate(sql);
         JOptionPane.showMessageDialog(null,"successfully Update");
         jf1.setVisible(false); 
         profile ob=new profile();
         ob.showprofile(email);
         }
         catch(Exception ex)
         {
             System.out.println(ex.getMessage());
         }
 }
  
    
    
}
