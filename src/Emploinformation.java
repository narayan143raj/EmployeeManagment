package employee.management.system;

import static java.awt.Window.log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

import conn;



public class Emploinformation extends JFrame implements ActionListener {
 JTextField teduction,tfname,taddress,tphone,taadhar,temail,tdesignation;
    JLabel tempid;
   JButton print,back;
   String number;
   Emploinformation(String number){
        this.number=number;
     getContentPane().setBackground(Color.decode("#37474F"));
    
     /* ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
     Image i2= i1.getImage().getScaledInstance(1120, 730, Image.SCALE_DEFAULT);
     ImageIcon i3= new ImageIcon(i2);
     JLabel img= new JLabel(i3);
     img.setBounds(0, 0, 1120, 730);
     add(img);  */ 


     ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icons/EMployee.png"));
     Image i22= i11.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT);
     ImageIcon i33= new ImageIcon(i22);
     JLabel imgg= new JLabel(i33);
     imgg.setBounds(0, 10, 150, 100);
     //imgg.setBorder(BorderFactory.createMatteBorder(0, 0,2, 0,Color.black));
     imgg.setBackground(Color.BLACK);
     add(imgg);

        JLabel heading= new JLabel("                              View Employee Detail\n");
        heading.setBounds(0, 70, 900, 50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        heading.setBorder(BorderFactory.createMatteBorder(0, 0,5, 0,Color.white));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        name.setForeground(Color.WHITE);
        add(name);

        JLabel tname= new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177,252,197));
        tname.setForeground(Color.WHITE);
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        fname.setForeground(Color.WHITE);
        add(fname);

        JLabel tfname= new JLabel();
        tfname.setBounds(600, 150, 150, 30);
        //tfname.setBackground(new Color(177,252,197));
        tfname.setOpaque(false);
        tfname.setForeground(Color.WHITE);
        add(tfname);

        JLabel Dob = new JLabel("Date Of Birth");
        Dob.setBounds(50, 200, 150, 30);
        Dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        Dob.setForeground(Color.WHITE);
        add(Dob);

        JLabel tdob= new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
        tdob.setForeground(Color.WHITE);
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        salary.setForeground(Color.WHITE);
        add(salary);

       JLabel tsalary= new JLabel();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setOpaque(false);
        tsalary.setForeground(Color.WHITE);
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        address.setForeground(Color.WHITE);
        add(address);

        JLabel taddress= new JLabel();
        taddress.setBounds(200, 250, 150, 30);
       // taddress.setBackground(new Color(177,252,197));
       taddress.setOpaque(false);
       taddress.setForeground(Color.WHITE);
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        phone.setForeground(Color.WHITE);
        add(phone);

        JLabel tphone= new JLabel();
        tphone.setBounds(600, 250, 150, 30);
       // tphone.setBackground(new Color(177,252,197));
        tphone.setOpaque(false);
        tphone.setForeground(Color.WHITE);
        add(tphone);
  
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        email.setForeground(Color.WHITE);
        add(email);

        JLabel temail= new JLabel();
        temail.setBounds(200, 300, 150, 30);
        temail.setOpaque(false);
        temail.setForeground(Color.WHITE);
        add(temail);

        
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
       education.setForeground(Color.WHITE);
        add(education);

        JLabel teduction= new JLabel();
        teduction.setBounds(600, 300, 150, 30);
        teduction.setOpaque(false);
        teduction.setForeground(Color.WHITE);
        add(teduction);

      
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        aadhar.setForeground(Color.WHITE);
        add(aadhar);

        JLabel taadhar= new JLabel();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177,252,197));
        taadhar.setForeground(Color.WHITE);
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        empid.setForeground(Color.WHITE);
        add(empid);

        tempid= new JLabel("");
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        designation.setForeground(Color.WHITE);
        add(designation);

        JLabel tdesignation= new JLabel();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setOpaque(false);
        tdesignation.setForeground(Color.WHITE);
        add(tdesignation);
       
        try {
            conn c= new conn();
            String query="select * from employee where empID='"+number+"'";
            ResultSet resultSet=c.statement.executeQuery(query);
            while(resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teduction.setText(resultSet.getString("education"));
                tdesignation.setText(resultSet.getString("designation"));
                taadhar.setText(resultSet.getString("aadhar"));
                tempid.setText(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        back= new JButton("Exit");
        back.setBounds(250, 550, 200, 40);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.setOpaque(false);
        back.setFont(new Font("Raleway",Font.BOLD,30));
        back.addActionListener(this);
        add(back);
        
 
        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
        

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            try {
                setVisible(false);
                new EmployeeView();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } 
    }
public static void main(String[] args) {
    new Emploinformation("");
}
}
