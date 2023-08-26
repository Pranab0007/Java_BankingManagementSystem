/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication82;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class signup implements ActionListener 
{
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1=new JButton("Register");
    JButton b2=new JButton("Home");
    JFrame jf1;
    public void signupform()
    {
        jf1=new JFrame("Sign Up Page");
        l1=new JLabel("Name");
        l1.setBounds(50, 100, 120, 30);
        jf1.add(l1);
        tf1=new JTextField();
        tf1.setBounds(250, 100, 150, 30);
        jf1.add(tf1);
        l2=new JLabel("Address");
        l2.setBounds(50, 150, 130, 30);
        jf1.add(l2);
        tf2=new JTextField();
        tf2.setBounds(250, 150, 150, 30);
        jf1.add(tf2);
        l3=new JLabel("Mobile");
        l3.setBounds(50, 200, 130, 30);
        jf1.add(l3);
        tf3=new JTextField();
        tf3.setBounds(250, 200, 150, 30);
        jf1.add(tf3);
        l4=new JLabel("Email");
        l4.setBounds(50, 250, 130, 30);
        jf1.add(l4);
        tf4=new JTextField();
        tf4.setBounds(250, 250, 150, 30);
        jf1.add(tf4);
        l5=new JLabel("Password");
        l5.setBounds(50, 300, 120, 30);
        jf1.add(l5);
        tf5=new JTextField();
        tf5.setBounds(250, 300, 150,30);
        jf1.add(tf5);
        l6=new JLabel("Amount");
        l6.setBounds(50, 350, 120, 30);
        jf1.add(l6);
        tf6=new JTextField();
        tf6.setBounds(250, 350, 150,30);
        jf1.add(tf6);
        
        b1.setBounds(50, 400, 100, 30);
        jf1.add(b1);
        b1.addActionListener(this);
        b2.setBounds(170, 400, 100, 30);
        jf1.add(b2);
        b2.addActionListener(this);
        jf1.setSize(500,500);
        jf1.setLayout(null);
        jf1.setVisible(true); 
    }
public void actionPerformed(ActionEvent e)
  {
         String s1,s2,s3,s4,s5,s6;
         if(e.getSource()==b1)
         {
         s1=tf1.getText();
         s2=tf2.getText();
         s3=tf3.getText();
         s4=tf4.getText();
         s5=tf5.getText();
         s6=tf6.getText();
         int s=Integer.parseInt(s6);
         try
         {  
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasweta1", "root", "");
         Statement st=con.createStatement();
         String sql="insert into registration1 values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"',"+s+")";
         st.executeUpdate(sql);
         JOptionPane.showMessageDialog(null,"successfully Register");
         jf1.setVisible(false); 
         A ob=new A(); 
         }
         catch(Exception ex)
         {
             System.out.println(ex.getMessage());
         }
         }
         else
         {
          jf1.setVisible(false);
          A ob1=new A();
         }
         
 }
  
}
