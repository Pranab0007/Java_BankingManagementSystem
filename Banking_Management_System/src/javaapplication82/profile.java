
package javaapplication82;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class profile implements ActionListener
{
    JTextField tf1,tf2,tf3,tf4,tf5;
    JLabel l1,l2,l3,l4,l5;
    JFrame f1;
    JButton b1,b2,b3,b4;
    String email;
    public void showprofile(String s1)
      {
          email=s1;
          try
          {
            f1=new JFrame("Profile Page");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasweta1", "root", "");
            Statement st=con.createStatement();
            String sql="select * from registration1 WHERE email='"+s1+"'";
            ResultSet rs=st.executeQuery(sql);
            if(rs.next())
            {
            
            String data[][]={ {"Name",rs.getString(1)},
                            {"Address",rs.getString(2)},    
                            {"Mobile",rs.getString(3)},
                            {"E-mail",rs.getString(4)},
                            {"password",rs.getString(5)},
                            {"amount",rs.getString(6)}}; 
            String column []={"field","value"};
            JTable jt=new JTable(data,column);    
            jt.setBounds(30,40,200,300);     
            f1.add(jt);
            b1=new JButton("Logout");
            b2=new JButton("Edit");
            b3=new JButton("Deposit");
            b4=new JButton("Withdrawl");
            b1.setBounds(350, 50, 100, 40);
            f1.add(b1);
            b2.setBounds(350, 100, 100, 40);
            f1.add(b2);
            b3.setBounds(350, 150, 100, 40);
            f1.add(b3);
            b4.setBounds(350, 200, 100, 40);
            f1.add(b4);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            f1.setSize(500,500);
            f1.setLayout(null);
            f1.setVisible(true);
            }
                      
          }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
   }
   public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==b1)
    {
        f1.setVisible(false);
        A ob=new A();
    }
    else if(e.getSource()==b2)
    {
        f1.setVisible(false);
        edit ob1=new edit();
        ob1.edit(email);
    }
    else if(e.getSource()==b3)
    {
       f1.setVisible(false);
       deposit ob2=new deposit();
       ob2.depositamt(email);
    }
     else
    {
        f1.setVisible(false);
        withdrawl ob3=new withdrawl();
        ob3.withdrawlamt(email);
    }
    }
    
}
