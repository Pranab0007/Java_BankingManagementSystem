package javaapplication82;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class A implements ActionListener
{
    JLabel l1;
    JButton b2,b3;
    String s1;
    JTextField tf1;
    JFrame jf1;
    A()
    {
    jf1=new JFrame("Home Page");
    l1=new JLabel("Banking Management System");
    l1.setBounds(120, 50, 200, 30);
    jf1.add(l1);
    //b1= new JButton("Home"); 
    b2= new JButton("Sign Up");
    b3= new JButton("Login");
    //jf1.add(b1);
    jf1.add(b2);
    jf1.add(b3);
    //b1.setBounds(50, 150, 80, 40);
    b2.setBounds(100, 150, 80, 40);
    b3.setBounds(250, 150, 80, 40);
    //b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    jf1.setSize(500, 800);
    jf1.setLayout(null);
    jf1.setVisible(true);
    }
public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==b2)
    {
        jf1.setVisible(false);
        signup ob=new signup();
        ob.signupform();
    }
    if(e.getSource()==b3)
    {
        jf1.setVisible(false);
         login ob=new login();
         ob.loginform();
    }
}
    
}

public class JavaApplication82 
{   
    public static void main(String[] args) 
    {
        A ob=new A();
    }
    
}
