package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;


public class EmployeeView extends JFrame implements ActionListener{
    JButton view,logins,exit,attendance;
    JTextField empid;
    Choice choiceEmp;
    JTable table;
    EmployeeView(){
        getContentPane().setBackground(Color.decode("#37474F"));
      choiceEmp= new Choice();
        choiceEmp.setBounds(250,250,150,100);
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

        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icons/Employee.png"));
        Image i22= i11.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i33= new ImageIcon(i22);
        JLabel imgg= new JLabel(i33);
        imgg.setBounds(100,10,300,200);
        //imgg.setOpaque(false);
        imgg.setForeground(Color.white);
        add(imgg);


        logins = new JButton("view Personal Details");
        logins.setBounds(130, 320, 180, 40);
        logins.setBackground(Color.BLACK);
        logins.setOpaque(false);
        logins.setForeground(Color.white);
        //logins.setFont(new Font("Raleway",Font.BOLD,20));
        logins.addActionListener(this);
        add(logins);
        
        view = new JButton("Mark Attendence");
        view.setBounds(150, 450, 140, 40);
        view.setBackground(Color.BLACK);
        view.setOpaque(false);
        view.setForeground(Color.white);
        view.addActionListener(this);
        add(view);

        exit = new JButton("Exit");
        exit.setBounds(240, 380, 140, 40);
        exit.setBackground(Color.BLACK);
        exit.setOpaque(false);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        attendance = new JButton("View Attendance");
        attendance.setBounds(50, 380, 140, 40);
        attendance.setBackground(Color.BLACK);
        attendance.setOpaque(false);
        attendance.setForeground(Color.white);
        attendance.addActionListener(this);
        add(attendance);

        JLabel label= new JLabel("Employee ID");
        label.setBounds(50, 240, 150, 30);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);

        add(label);

       /* JPanel panel= new JPanel();
        panel.setBorder(BorderFactory.createMatteBorder(3, 3,3, 3,Color.white));
        panel.setBounds(0, 190, 500, 450);
        panel.setFocusable(false);
        panel.setBackground(Color.decode("#37474F"));
        //panel.setOpaque(false);
        add(panel);*/

      /*  ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/print.jpg"));
        Image i2= i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0, 0, 1170, 650);
        add(img);*/
    
        table = new JTable();
        try {
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from attendance");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }
         JScrollPane jp= new JScrollPane(table);
        jp.setBounds(500, 50, 300, 400);
        //jp.setBackground(Color.white);
        jp.setForeground(Color.BLACK);
        jp.setBorder(BorderFactory.createMatteBorder(3, 3,3, 3,Color.white));
        add(jp);
     

        setSize(900, 650);
        setLayout(null);
        setVisible(true);
        setLocation(200, 50);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==logins){
           try{
            setVisible(false);
            new Emploinformation(choiceEmp.getSelectedItem());
           } catch (Exception E) {
            E.printStackTrace();
           }
        }else if(e.getSource()==view){
            setVisible(false);
            new attendance();
        }else if(e.getSource()==attendance){
            String query="select * from attendance where employee_id='"+choiceEmp.getSelectedItem()+"'";
            try {
                conn c= new conn();
             ResultSet resultSet= c.statement.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));
                setVisible(false);
            } catch (Exception p) {
             
                p.printStackTrace();
            }
            setVisible(true);
          
        }else{
            new Login();
            setVisible(false);
        }
    
     }
    public static void main(String[] args) {
        new EmployeeView();
    }

}
