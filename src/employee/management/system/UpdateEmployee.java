package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;



public class UpdateEmployee extends JFrame implements ActionListener {
 JTextField teduction,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempid;
   JButton add,back;
   String number;
   JLabel gender;
    UpdateEmployee(String number){
        this.number=number;
     getContentPane().setBackground(new Color(163,255,188));
    
     ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/addemploy.jpg"));
     Image i2= i1.getImage().getScaledInstance(1120, 730, Image.SCALE_DEFAULT);
     ImageIcon i3= new ImageIcon(i2);
     JLabel img= new JLabel(i3);
     img.setBounds(0, 0, 1120, 730);
     add(img);   


     ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icons/EMployee.png"));
     Image i22= i11.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT);
     ImageIcon i33= new ImageIcon(i22);
     JLabel imgg= new JLabel(i33);
     imgg.setBounds(230, 10, 90, 70);
     imgg.setBorder(BorderFactory.createMatteBorder(0, 0,2, 0,Color.black));
     imgg.setBackground(Color.BLACK);
     img.add(imgg);

        JLabel heading= new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 400, 50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        heading.setBorder(BorderFactory.createMatteBorder(0, 0,2, 0,Color.black));
        img.add(heading);

        JLabel gen = new JLabel("Gender");
        gen.setBounds(400, 200, 150, 30);
        gen.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(gen);

       
        gender = new JLabel();
        gender.setBounds(600, 200, 150, 30);
        gender.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(gender);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(name);

        JLabel tname= new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177,252,197));
        img.add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(fname);

        tfname= new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        //tfname.setBackground(new Color(177,252,197));
        tfname.setOpaque(false);
        img.add(tfname);

        JLabel Dob = new JLabel("Date Of Birth");
        Dob.setBounds(50, 200, 150, 30);
        Dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(Dob);

        JLabel tdob= new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
        img.add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 400, 150, 30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(salary);

        tsalary= new JTextField();
        tsalary.setBounds(600, 400, 150, 30);
        tsalary.setOpaque(false);
        img.add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(address);

        taddress= new JTextField();
        taddress.setBounds(200, 250, 150, 30);
       // taddress.setBackground(new Color(177,252,197));
       taddress.setOpaque(false);
        img.add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(phone);

        tphone= new JTextField();
        tphone.setBounds(600, 250, 150, 30);
       // tphone.setBackground(new Color(177,252,197));
        tphone.setOpaque(false);
        img.add(tphone);
  
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(email);

        temail= new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setOpaque(false);
        img.add(temail);

        
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(education);

        teduction= new JTextField();
        teduction.setBounds(600, 300, 150, 30);
        teduction.setOpaque(false);
        img.add(teduction);

      
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(aadhar);

        JLabel taadhar= new JLabel();
        taadhar.setBounds(600, 350, 180, 30);
        taadhar.setBackground(new Color(177,252,197));
        img.add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(empid);

        tempid= new JLabel("");
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        img.add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(designation);

        tdesignation= new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        //tdesignation.setBackground(new Color(177,252,197));
        tdesignation.setOpaque(false);
        img.add(tdesignation);
       
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
                gender.setText(resultSet.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add= new JButton("Update");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.blue);
        add.setForeground(Color.black);
        add.setOpaque(false);
        add.setFocusPainted(false);
        add.addActionListener(this);
        img.add(add);

        back= new JButton("Back");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.blue);
        back.setForeground(Color.black);
        back.setOpaque(false);
        back.addActionListener(this);
        img.add(back);

     
 
        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
        

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==add){
            String fname=tfname.getText();
            String salary= tsalary.getText();
            String address= taddress.getText();
            String phone= tphone.getText();
            String email= temail.getText();
            String education= teduction.getText();
            String designation= tdesignation.getText();

            try {
                conn c= new conn();
                String query="update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empID='"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Update Sucessfully");
                setVisible(false);
                new Main_class();
            } catch (Exception E) {
                // TODO: handle exception
                E.printStackTrace();
            }
        } else{
            setVisible(false);
            new View_Employee();
        }
    }
public static void main(String[] args) {
    new UpdateEmployee("");
}
}
