
package university.management.syste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;




public class StudentLeaveDetial extends JFrame implements ActionListener{
    
    JTable table;
    Choice crollno;
    JButton search , print , cancel;
            
    StudentLeaveDetial(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
         JLabel heading = new JLabel("Search By Roll No.");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         table = new JTable();
         
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from studleave");
             table.setModel(DbUtils.resultSetToTableModel(rs));
                     
         }catch(Exception e){
             e.printStackTrace();
         }
         
         JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
         
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("Add");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
      
        
        setLocation(180,50);
        setSize(900,700);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == search){
            
            String query = "select * from studleave where rollno = '"+crollno.getSelectedItem()+"'";
            
           try{
               
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
           }catch(Exception e){
               e.printStackTrace();
           }
            
        }else if(ae.getSource() == print){
            try{
                
                table.print();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main (String args[]){
        new StudentLeaveDetial();
    }
    
}
