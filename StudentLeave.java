
package university.management.syste;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentLeave extends JFrame implements ActionListener{
    
    Choice crollno , ctime;
    JDateChooser dcdob;
    JButton submit , cancel;
    
    StudentLeave(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Apply Leave(Student)");
        heading.setBounds(40, 50, 300, 20);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(heading);
        
        JLabel rollno = new JLabel("Search By Roll No");
        rollno.setBounds(70, 100, 150, 20);
        rollno.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(rollno);
        
        crollno = new Choice();
        crollno.setBounds(70, 130, 150, 20);
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch(Exception ae){
            ae.printStackTrace();
        }
        
        JLabel date = new JLabel("Date");
        date.setBounds(70, 170, 150, 20);
        date.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(date);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(70, 200, 150, 20);
        add(dcdob);
        
        JLabel time = new JLabel("Time Duration");
        time.setBounds(70, 240, 150, 20);
        time.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(time);
        
        ctime = new Choice();
        ctime.setBounds(70, 270, 150, 20);
        ctime.add("HALF DAY");
        ctime.add("FULL DAY");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(70, 330, 80, 20);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 330, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
                
        setVisible(true);
        setSize(400,450);
        setLocation(350,100);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            
            String rollno = crollno.getSelectedItem();
            String date   = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String timeduration = ctime.getSelectedItem();
            
            try{
                String query = "insert into studLeave values('"+rollno+"','"+date+"', '"+timeduration+"')";
                
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Leave Successfully Inserted");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new StudentLeave();
    }
    
}
