package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class viewattendance extends JFrame implements ActionListener{
    Choice choiceEmp;
        JTable table;
        JButton searchbtn,print,back;
    viewattendance(){
         JLabel search= new JLabel("Search by employee id");
        search.setBounds(20, 20, 150, 20);
        add(search);
          searchbtn= new JButton("Search");
        searchbtn.setBounds(20, 70, 80, 20);
        searchbtn.setBackground(Color.blue);
        searchbtn.setForeground(Color.BLACK);
        searchbtn.setOpaque(false);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print= new JButton("print");
        print.setBounds(120, 70, 80, 20);
        print.setBackground(Color.blue);
        print.setForeground(Color.BLACK);
        print.setOpaque(false);
        print.addActionListener(this);
        add(print);

        back= new JButton("Back");
        back.setBounds(230, 70, 80, 20);
        back.setBackground(Color.blue);
        back.setForeground(Color.BLACK);
        back.setOpaque(false);
        back.addActionListener(this);
        add(back);

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
            ResultSet resultSet= c.statement.executeQuery("select * from attendance");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }
           JScrollPane jp= new JScrollPane(table);
        jp.setBounds(380, 10, 400, 600);
        jp.setBackground(Color.BLACK);
        jp.setForeground(Color.white);
        add(jp);
        
        setSize(900, 700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
     
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==searchbtn){
            String query="select * from attendance where employee_id='"+choiceEmp.getSelectedItem()+"'";
           try {
             conn c= new conn();
             ResultSet resultSet= c.statement.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));
           } catch (Exception E) {
            E.printStackTrace();
           }
        }  else if(e.getSource()==print){
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else if(e.getSource()==back){
            setVisible(false);
            new EmployeeView();
        }
    
     }
      
    public static void main(String[] args) {
        new viewattendance();
    }
}
