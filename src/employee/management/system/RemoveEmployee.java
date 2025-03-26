package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    Choice choiceEMPID;
    JButton delete,back;
    RemoveEmployee(){

        JLabel label= new JLabel("Employee ID");
        label.setBounds(50, 50, 100, 30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEMPID= new Choice();
        choiceEMPID.setBounds(200, 50, 150, 30);
        add(choiceEMPID);

        try {
            conn c= new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMPID.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        JLabel labelName= new JLabel("Name");
        labelName.setBounds(50, 100, 100, 30);
        labelName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelName);

        JLabel textName= new JLabel();
        textName.setBounds(200, 100, 200, 30);
        add(textName);

        JLabel labelPhone= new JLabel("Phone");
        labelPhone.setBounds(50, 150, 100, 30);
        labelPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelPhone);

        JLabel textPhone= new JLabel();
        textPhone.setBounds(200, 150, 100, 30);
        add(textPhone);

        JLabel labelEmail= new JLabel("Email");
        labelEmail.setBounds(50, 200, 100, 30);
        labelEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelEmail);

        JLabel textEmail= new JLabel();
        textEmail.setBounds(200, 200, 150, 30);
        add(textEmail);
       
        try {
           conn c= new conn();
           ResultSet resultSet=c.statement.executeQuery("select * from employee where empID='"+
           choiceEMPID.getSelectedItem()+"'") ;
           while(resultSet.next()){
            textName.setText(resultSet.getString("name"));
            textPhone.setText(resultSet.getString("phone"));
            textEmail.setText(resultSet.getString("email"));
           }
        } catch (Exception e) {
           e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e){
                try {
                    conn c= new conn();
           ResultSet resultSet=c.statement.executeQuery("select * from employee where empID='"+
           choiceEMPID.getSelectedItem()+"'") ;
           while(resultSet.next()){
            textName.setText(resultSet.getString("name"));
            textPhone.setText(resultSet.getString("phone"));
            textEmail.setText(resultSet.getString("email"));
           }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }

        });

        delete= new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.black);
        delete.setOpaque(false);
        delete.addActionListener(this);
        add(delete);

        back= new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.black);
        back.setOpaque(false);
        back.addActionListener(this);
        add(back);


        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icons/logo.gif"));
        Image i12= i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33= new ImageIcon(i12);
        JLabel image= new JLabel(i33);
        image.setBounds(0,0,1120,630);
        add(image);
          
        JPanel panel= new JPanel();
        panel.setBorder(BorderFactory.createMatteBorder(3, 3,3, 3,Color.black));
        panel.setBounds(30, 20, 330, 330);
        panel.setBackground(new Color(0,0,0));
        panel.setOpaque(false);
        image.add(panel);

        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==delete){
            try {
                conn c= new conn();
                String query= "delete from employee where empID='"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Delete Sucessfully");
                setVisible(false);
                new Main_class();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
           setVisible(false); 
           new Main_class();
        }
    }
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
