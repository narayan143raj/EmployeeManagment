

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class attendance extends JFrame implements ActionListener{
   JTextField Empid;
   JButton back,submit;
   JDateChooser tdob;
   JLabel tempid,head;
   JComboBox boxeducation;
   Choice choiceEmp;
    attendance(){
        getContentPane().setBackground(Color.decode("#37474F"));
        choiceEmp= new Choice();
        choiceEmp.setBounds(180,60,150,20);
        add(choiceEmp);
        try {
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEmp.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        head = new JLabel("Attendance Marking");
        head.setBounds(80, 20, 240, 30);
        head.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        head.setForeground(Color.WHITE);
        add(head);

        tempid = new JLabel("Employee ID");
        tempid.setBounds(20, 60, 100, 30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        tempid.setForeground(Color.WHITE);
        add(tempid);
        
        JLabel Dob = new JLabel("Date");
        Dob.setBounds(20, 100, 150, 30);
        Dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        Dob.setForeground(Color.WHITE);
        add(Dob);

         tdob= new JDateChooser();
        tdob.setBounds(180, 100, 150, 30);
        tdob.setBackground(Color.BLACK);
        tdob.setForeground(Color.yellow);
        tdob.setOpaque(false);
        add(tdob);

         
        JLabel mark = new JLabel("Mark attendance");
        mark.setBounds(20, 140, 150, 30);
        mark.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        mark.setForeground(Color.WHITE);
        add(mark);
      
        String items[]={"Present","Absent","Late"};
        boxeducation = new JComboBox(items);
        boxeducation.setBounds(180, 140, 150, 30);
        boxeducation.setForeground(Color.black);
        boxeducation.setOpaque(false);
        add(boxeducation);

        submit= new JButton("Submit");
        submit.setBounds(50, 200, 100, 40);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        //submit.setOpaque(false);
        submit.addActionListener(this);
        add(submit);

        back= new JButton("Exit");
        back.setBounds(200, 200, 100, 40);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        //back.setOpaque(false);
        back.addActionListener(this);
        add(back);

        /* ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/black.jpg"));
        Image i2= i1.getImage().getScaledInstance(400, 630, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0, 0, 400, 630);
        add(img);*/

        setBounds(200,100,400,630);
        setLayout(null);
        setVisible(true);
           
    }
    public attendance(JButton submit) throws HeadlessException {
        this.submit = submit;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String employee_id =choiceEmp.getSelectedItem();
            String date=((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String status= (String)boxeducation.getSelectedItem();
            try {
                conn c= new conn();
                String query="INSERT into attendance values('"+employee_id+"','"+date+"','"+status+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Attendance added Sucessfully");
                setVisible(false);
                new EmployeeView();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new EmployeeView();
        } 
    }
            public static void main(String args[]) {
               new attendance();
        
            }
        
             
    }
