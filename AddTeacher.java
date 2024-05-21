
package university.management.syste;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname , tffname, tfaddress, tfphone , tfcnic , tfemail , tfx , tfxii;
    JLabel labelempid;  
    JDateChooser dcdob;
    JComboBox cbquilifi ,cbdep;
   JButton submit , cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L)+1000L);
    
    AddTeacher(){
        
        setSize(650,550);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading= new JLabel("Add New Teacher");
        heading.setBounds(200, 40, 500, 30);
        heading.setFont(new Font("Tahoms", Font.BOLD,25));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 130, 100, 20);
        lblname.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(120, 130, 150, 20);
        add(tfname);
        
        JLabel lblfname = new JLabel(" Father Name");
        lblfname.setBounds(320, 130, 100, 20);
        lblfname.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(450, 130, 150, 20);
        add(tffname);
        
        
        JLabel lblempid = new JLabel("Employe ID");
        lblempid .setBounds(40, 170, 100, 20);
        lblempid .setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblempid );
        
        labelempid= new JLabel("1533"+first4);
        labelempid.setBounds(150, 170, 150, 20);
        labelempid.setFont(new Font("Tahoms",Font.BOLD,15));
        add(labelempid);
        
        
        
        JLabel lbldob = new JLabel("Date OF Birth");
        lbldob.setBounds(320, 170, 120, 20);
        lbldob.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(450, 170, 150, 20);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(40, 220, 100, 20);
        lbladdress.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(120, 220, 150, 20);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Contact NO.");
        lblphone.setBounds(320, 220, 100, 20);
        lblphone.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(450, 220, 150, 20);
        add(tfphone);
        
        JLabel lblcnic = new JLabel("CNIIC NO.");
        lblcnic.setBounds(40, 260, 100, 20);
        lblcnic.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblcnic);
        
        tfcnic = new JTextField();
        tfcnic.setBounds(120, 260, 150, 20);
        add(tfcnic);
        
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(320, 260, 100, 20);
        lblemail.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(450, 260, 150, 20);
        add(tfemail);
      
        JLabel lblx = new JLabel("class X %");
        lblx.setBounds(40, 300, 100, 20);
        lblx.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(120, 300, 150, 20);
        add(tfx);
        
        JLabel lblxii = new JLabel("Class xii %");
        lblxii.setBounds(320, 300, 100, 20);
        lblxii.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(450, 300, 150, 20);
        add(tfxii);
        
        JLabel lblcourse = new JLabel("Education");
        lblcourse.setBounds(40, 340, 100, 20);
        lblcourse.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblcourse);
        
        String quailification[] = {"Matric","Intermediate","Bachelor","Master","Diploma"};
        cbquilifi = new JComboBox(quailification);
        cbquilifi.setBounds(120, 340, 150, 20);
        add(cbquilifi);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(320, 340, 140, 20);
        lblbranch.setFont(new Font("Tahoms",Font.BOLD,15));
        add(lblbranch);
        
        String Dep[] = {"Software Engineering","Information Technology","English","Mathematics"};
        cbdep = new JComboBox(Dep);
        cbdep.setBounds(450, 340, 150, 20);
        add(cbdep);
        
        submit = new JButton("Submit");
        submit.setBounds(120, 420, 150, 20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoms" , Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(320, 420, 140, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoms" , Font.BOLD, 15));
        add(cancel);
         
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
           String name = tfname.getText();
            String fname = tffname.getText();
            String empid = labelempid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String cnic = tfcnic.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String course = (String)cbquilifi.getSelectedItem();
            String branch = (String)cbdep.getSelectedItem();
            
            try{
                String query = "insert into teacher values('"+name+"' , '"+fname+"','"+empid+"','"+dob+"','"+address+"','"+email+"','"+phone+"','"+cnic+"','"+x+"', '"+xii+"','"+course+"','"+branch+"')";
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Detail Inserted Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddTeacher();
    }
}
