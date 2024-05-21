
package university.management.syste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class Project extends JFrame implements ActionListener{
    
    Project(){
    
        setSize(1500,850);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1580, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
           
        JMenuBar mb = new JMenuBar();
        
        /////   Information Menu BAr    ///////
        JMenu newinformation = new JMenu("Information");
        mb.add(newinformation);
        
        JMenuItem facultyInfo =  new JMenuItem("New Faculty Information");
        facultyInfo.addActionListener(this);
        newinformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.addActionListener(this);
        newinformation.add(studentInfo);
        
        ///////       Detial          ////////
        JMenu detail = new JMenu("View Detial");
        mb.add(detail);
        
        JMenuItem facultyDetial = new JMenuItem("Faculty Detials");
        facultyDetial.addActionListener(this);
        detail.add(facultyDetial);
        
        JMenuItem studentDetial = new JMenuItem("Students Detials");
        studentDetial.addActionListener(this);
        detail.add(studentDetial);
        
        ///////       LEave          ////////
        JMenu leave = new JMenu("Leaves");
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("Students Leave");
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        ///////       LEave Detial         ////////
        JMenu leavedetail = new JMenu("Leaves Detail");
        mb.add(leavedetail);
        
        JMenuItem facultyleavedetail = new JMenuItem("Faculty Leave Detail");
        facultyleavedetail.addActionListener(this);
        leavedetail.add(facultyleavedetail);
        
        JMenuItem studentleavedetail = new JMenuItem("Students Leave Detail");
        studentleavedetail.addActionListener(this);
        leavedetail.add(studentleavedetail);
        
         ///////       LEave Detial         ////////
        JMenu exam = new JMenu(" Examination");
        mb.add(exam);
        
        JMenuItem examinationResult = new JMenuItem("Examination Result");
        exam.add(examinationResult);
        
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        exam.add(entermarks);
        
         ///////     Update Information        ////////
        JMenu updateInfo = new JMenu("Update Information");
        mb.add(updateInfo);
        
        JMenuItem facultyUpdate = new JMenuItem("Udpate Faculty Information");
        updateInfo.add(facultyUpdate);
        
        JMenuItem studentUpdate = new JMenuItem("Udpate Student Information");
        updateInfo.add(studentUpdate);
        
         ///////     Update Information        ////////
        JMenu fees = new JMenu("Update Information");
        mb.add(fees);
        
        JMenuItem feesStructure = new JMenuItem("Fees Structure");
        fees.add(feesStructure);
        
        JMenuItem feesform = new JMenuItem("Student Fees Form");
        fees.add(feesform);
        
          ///////    Utility       ////////
        JMenu Utility = new JMenu("Utility");
        mb.add(Utility);
        
        JMenuItem notepad = new JMenuItem("NotePade");
        notepad.addActionListener(this);
        Utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.addActionListener(this);
        Utility.add(calc);
        
         ///////    Exit       ////////
        JMenu Exit = new JMenu("Exit");
        mb.add(Exit);
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        Exit.add(exit);
        
        
        
        setJMenuBar(mb);
        
        
        
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae){
    
        String msg = ae.getActionCommand();
        
        if(msg.equals("Exit")){
        setVisible(false);
        }else if(msg.equals("Calculator")){
        try{
            Runtime.getRuntime().exec("calc.exe");
        
        }catch(Exception e){}
        
        }else if (msg.equals("NotePade")){
                try{
                Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){
                }
                }else if(msg.equals("New Faculty Information")){
                    new AddTeacher();
                }else if (msg.equals("New Student Information")){
                    new AddStudent();
                }else if (msg.equals("Faculty Detials")){
                    new TeacherDetails();
                }else if (msg.equals("Students Detials")){
                    new StudentDetail();
                }else if (msg.equals("Faculty Leave")){
                    new TeacherLeave();
                }else if (msg.equals("Students Leave")){
                    new StudentLeave();
                }else if (msg.equals("Faculty Leave Detail")){
                    new TeacherLeaveDetial();
                }else if (msg.equals("Students Leave Detail")){
                    new StudentLeaveDetial();
                }
        
        }
    
    
     
    public static void main(String[] args){
    
        new Project();
        
    }

   
}
