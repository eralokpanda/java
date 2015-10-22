/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofolder;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author alok
 */
public class AutoFolder extends JFrame {

   
    static String msg;
    JFrame f;
    JButton b;
    JPanel p;
    JLabel l;
    
    AutoFolder()
    {
        f = new JFrame("AutoFolder");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("d:/logo.png"));
         f.setSize(300,120);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(2,1));
        p = new JPanel();
        l = new JLabel("Something went wrong !!");
        l.setText(msg);
        p.add(l);
        p.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));
        f.add(p);
        p = new JPanel();
        b = new JButton("OK");
        p.setLayout(new FlowLayout(FlowLayout.CENTER,0,8));
        p.add(b);
        f.add(p);
        b.addActionListener(new Close());
    }
    
    public static void main(String[] args) {
     
    
        String path = null;
        
        File f = new File("C:/AutoFolder/config.dat");
        if(f.exists() == false)
            {
                msg = "Folder Creater is not Configured";
                System.exit(0);
            }
        try{
            path = new String(Files.readAllBytes(Paths.get("C:/AutoFolder/config.dat")));
        }
        catch(IOException e)
            {
               msg = "Something went wrong !!";  
            }
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
	Calendar cal = Calendar.getInstance();
	String date = sdf.format(cal.getTime());
        File file = new File(path+"/"+date);
        if(file.exists()==false)
            {
                if(file.mkdir())
                    msg = "Directory successfully created";
                else
                    msg = "Something went wrong !!";
            }
            else
		msg = "Directory already exists!!";
        
        AutoFolder auto= new AutoFolder();  
        ImageIcon img = new ImageIcon("d:/logo.png");        
        auto.setIconImage(img.getImage());
         
 
    }
    
    
    class Close implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
             System.exit(0);
        }

    

   
    }
    
}
