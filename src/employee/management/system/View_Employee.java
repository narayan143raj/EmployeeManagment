package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class View_Employee extends JFrame implements ActionListener {
    Choice choiceEmp;
    JButton searchbtn,print,update,back;
    JTable table;
    View_Employee(){
         getContentPane().setBackground(new Color(255,131,122));

        JLabel search= new JLabel("Search by employee id");
        search.setBounds(20, 20, 150, 20);
        add(search);

        choiceEmp= new Choice();
        choiceEmp.setBounds(180,20,150,20);
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
        
        table = new JTable();
        try {
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jp= new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        searchbtn= new JButton("Search");
        searchbtn.setBounds(20, 70, 80, 20);
        searchbtn.setBackground(Color.blue);
        searchbtn.setForeground(Color.BLACK);
        searchbtn.setOpaque(false);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print= new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setBackground(Color.blue);
        print.setForeground(Color.BLACK);
        print.setOpaque(false);
        print.addActionListener(this);
        add(print);

        update= new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.setBackground(Color.blue);
        update.setForeground(Color.BLACK);
        update.setOpaque(false);
        update.addActionListener(this);
        add(update);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/print.jpg"));
        Image i2= i1.getImage().getScaledInstance(1120, 730, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0, 0, 1120, 730);
        add(img);

        back= new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.setBackground(Color.blue);
        back.setForeground(Color.BLACK);
        back.setOpaque(false);
        back.setFocusPainted(false);
        back.addActionListener(this);
        img.add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }   
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==searchbtn){
            String query="select * from employee where empID='"+choiceEmp.getSelectedItem()+"'";
           try {
             conn c= new conn();
             ResultSet resultSet= c.statement.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));
           } catch (Exception E) {
            E.printStackTrace();
           }
        } else if(e.getSource()==print){
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else if(e.getSource()==update){
            setVisible(false);
            new UpdateEmployee(choiceEmp.getSelectedItem());

        }else{
            setVisible(false);
            new Main_class();
        }
    
     }
    public static void main(String[] args) {
        new View_Employee();
    }
    }

