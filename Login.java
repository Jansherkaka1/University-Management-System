
package university.management.syste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;  


public class Login extends JFrame implements ActionListener {
    
    JButton login ,cancel;
    JTextField tfusername,tfpassword;
    Login(){
    
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50, 40, 100, 20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 40, 150, 20);
        add(tfusername);
        
         JLabel lblpassword = new JLabel("password");
        lblpassword.setBounds(50, 80, 100, 40);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 90, 150, 20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoms" , Font.BOLD, 15));
        add(login);
        
        cancel  = new JButton("Cancel");
        cancel.setBounds(200, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tohams",Font.BOLD,15));
        add(cancel);
        
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     setVisible(true);
     setLocation(400,200);
     setSize(600,300);
     
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
        String username = tfusername.getText();
        String password = tfpassword.getText();
        
        String query = "select * from login where username='"+username+"' and password='"+password+"'";
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            
            if(rs.next()){
                setVisible(false);
                new Project();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();  
        }
        }else if (ae.getSource()== cancel){
        setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
