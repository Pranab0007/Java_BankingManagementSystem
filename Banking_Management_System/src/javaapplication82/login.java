
package javaapplication82;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class login implements ActionListener
{
    JTextField tf1,tf2;
    JLabel l1,l2;
    JButton b1=new JButton("login");
    JButton b2=new JButton("Home");
    JFrame jf1;
    public void loginform()
    {
        jf1=new JFrame("log in form");
        l1=new JLabel("Email");
        l1.setBounds(50, 100, 120, 30);
        jf1.add(l1);
        tf1=new JTextField();
        tf1.setBounds(250, 100, 150, 30);
        jf1.add(tf1);
        l2=new JLabel("password");
        l2.setBounds(50, 150, 130, 30);
        jf1.add(l2);
        tf2=new JTextField();
        tf2.setBounds(250, 150, 150, 30);
        jf1.add(tf2);
        b1.setBounds(50, 400, 80, 30);
        jf1.add(b1);
        b2.setBounds(170, 400, 100, 30);
        jf1.add(b2);
        b2.addActionListener(this);
        b1.addActionListener( this);
        jf1.setSize(500,500);
        jf1.setLayout(null);
        jf1.setVisible(true); 
  }
  public void actionPerformed(ActionEvent e)
  {
        String s1,s2;
        if(e.getSource()==b1)
        {
         s1=tf1.getText();
         s2=tf2.getText();
         try
         {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasweta1", "root", "");
         Statement st=con.createStatement();
         String sql="select * from registration1 where email='"+s1+"' and password='"+s2+"'";
         ResultSet rs=st.executeQuery(sql);
         if(rs.next())
         {
         JOptionPane.showMessageDialog(null,"successfully login");
         jf1.setVisible(false);
         profile ob=new profile();
         ob.showprofile(s1);
         }
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
