/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


class GUI extends JFrame
{
    JFrame f;
    JLabel l1;
    JPanel p1,p2;
    JButton b1,b2;
    JTextField txt;
    String path;
   
    GUI()
    {
        
        f = new JFrame("Control Panel");
        f.setSize(500, 200);
        f.setResizable(false);
        f.setLayout(new GridLayout(3,1));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        l1 = new JLabel("Enter the PATH:");
        p1.add(l1);
        f.add(p1);
      
        p1 = new JPanel();
        p2 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
        p2.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        p1.add(p2);
        txt = new JTextField(25);
        p2.add(txt);
        b1 = new JButton("Browse");
        p2.add(b1);
        f.add(p1);
        p1 = new JPanel();
        b2 = new JButton("OK"); 
        p1.add(b2);
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        f.add(p1);
        f.setVisible(true);
        
        b1.addActionListener(new Browse());
        b2.addActionListener(new Ok());
    }  
        public static void main(String args[])
        {
            GUI gui = new GUI();
             ImageIcon img = new ImageIcon("d:/logo.png");
            gui.setIconImage(img.getImage());
        }

  class Ok implements ActionListener{

      JFrame f2;
      JPanel pn;
      JLabel l1;
      JButton ok;
      FileCreater fileCreate;
      public void actionPerformed(ActionEvent e) {
         f2 = new JFrame();
         path = txt.getText();
         fileCreate = new FileCreater(path);
          f2.setLayout(new GridLayout(2,1));
         f2.setSize(300, 120);
         f2.setResizable(false);
         f2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         f2.setTitle("Control Panel");
         pn = new JPanel();
         l1 = new JLabel("Something went wrong !!");
         l1.setText(fileCreate.msg);
         pn.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
         pn.add(l1);
         f2.add(pn);
         ok = new JButton("OK");
         pn = new JPanel();
         pn.add(ok);
         f2.add(pn);
         f2.setVisible(true);
         
         
         ok.addActionListener(new Popup());
         
         
         
      }
      class Popup implements ActionListener{

      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }
   }
      
      
   }
    
  
  
  
    class Browse extends JPanel implements ActionListener{
  JFileChooser fc;
  JFrame f2;
      public void actionPerformed(ActionEvent e) {
        fc = new JFileChooser();
        f2 = new JFrame();
       
        f2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
       
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
   
       String s=fc.getSelectedFile().toString();
       txt.setText(s);
      }
    else {
     txt.setText("No File Selected");
      }
     
         }
      }
   }
  
