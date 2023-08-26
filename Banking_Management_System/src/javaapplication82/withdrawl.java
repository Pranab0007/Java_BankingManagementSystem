/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication82;
import com.sun.xml.internal.fastinfoset.EncodingConstants;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class withdrawl implements ActionListener{
    JTextField tf1;
    JLabel l1;
    JButton b1=new JButton("Update");
    JFrame jf1;
    String email;
    public void withdrawlamt(String em)
    {
        jf1=new JFrame();
        email=em;
        l1=new JLabel("Withdrawl Amount");
        l1.setBounds(50, 100, 120, 30);
        jf1.add(l1);
        tf1=new JTextField();
        tf1.setBounds(250, 100, 150, 30);
        jf1.add(tf1);
        b1.setBounds(50, 150, 80, 30);
        jf1.add(b1);
        b1.addActionListener(this);
        jf1.setSize(500,500);
        jf1.setLayout(null);
        jf1.setVisible(true); 
    }
    public void actionPerformed(ActionEvent e)
    {
        String s1;
        s1=tf1.getText();
        int s=Integer.parseInt(s1);
        int avl;
         try
         {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasweta1", "root", "");
         Statement st=con.createStatement();
         String sq="select * from registration1 WHERE email='"+email+"'";
         ResultSet rs=st.executeQuery(sq);
         if(rs.next())
         {
            avl=Integer.parseInt(rs.getString(6));
            if(avl>=s)
            {
               avl=avl-s;
               String sql="update registration1 set amount="+avl+" where email='"+email+"'";
               st.executeUpdate(sql);
               JOptionPane.showMessageDialog(null,"Balance successfully withdrawl");
               jf1.setVisible(false); 
               profile ob=new profile();
               ob.showprofile(email);
               
            }
            else
            {
             JOptionPane.showMessageDialog(null,"sorry you have not sufficient balance");
             jf1.setVisible(false); 
             profile ob=new profile();
             ob.showprofile(email);
            }
            
             
         }
         }
         catch(Exception ex)
         {
             System.out.println(ex.getMessage());
         }
    }
    
}
