package university.management.syste;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;
    
    Splash(){
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icons/first.PNG"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        
        setLocation(300,50);
        setSize(500,500);
       
    }
    public void run(){
        try{
        Thread.sleep(4000);
        setVisible(false);
        
        //next frame
        new Login();
        }catch(Exception e){
        }
    }
    
    public static void main(String[] args){
    new Splash();
    }
}
