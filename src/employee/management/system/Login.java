package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends  JFrame implements ActionListener {
     JTextField tusername;
     JPasswordField tpassword;
     JButton login,back,logins;
    Login(){

        getContentPane().setBackground(Color.white);

        JLabel log= new JLabel("LOGIN");
        log.setBounds(130, 20, 100, 50);
        log.setForeground(Color.decode("#DEE4E7"));
        log.setFont(new Font("Raleway",Font.BOLD,30));
        add(log);

        JLabel username= new JLabel("Username");
        username.setBounds(30, 80, 100, 30);
        username.setForeground(Color.decode("#DEE4E7"));
        add(username);

        tusername= new JTextField();
        tusername.setBounds(120,80,150,30);
        tusername.setOpaque(false);
        tusername.setForeground(Color.white);
        add(tusername);

        JLabel password= new JLabel("Password");
        password.setBounds(30, 140, 100, 30);
        password.setForeground(Color.decode("#DEE4E7"));
        add(password);

        tpassword= new JPasswordField();
        tpassword.setBounds(120,140,150,30);
        tpassword.setOpaque(false);
        tpassword.setForeground(Color.white);
        add(tpassword);
        login = new JButton("Login");
        login.setBounds(100, 200, 150, 30);
        login.setBackground(Color.green);
        login.setOpaque(false);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        /* 
        logins = new JButton("Login as Employee");
        logins.setBounds(150, 200, 140, 30);
        logins.setBackground(Color.green);
        logins.setOpaque(false);
        logins.setForeground(Color.white);
        logins.addActionListener(this);
        add(logins);*/
        back = new JButton("Back");
        back.setBounds(100, 260, 150, 30);
        back.setBackground(Color.black);
        back.setOpaque(false);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
         ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icons/Employee.png"));
        Image i22= i11.getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT);
        ImageIcon i33= new ImageIcon(i22);
        JLabel imgg= new JLabel(i33);
        imgg.setBounds(300,0,300,350);
        //imgg.setOpaque(false);
        imgg.setForeground(Color.white);
        add(imgg);
   

        /* ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2= i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);*/

        JPanel panel= new JPanel();
        panel.setBorder(BorderFactory.createMatteBorder(3, 3,3, 3,Color.white));
        panel.setBounds(0, 0, 300, 400);
        panel.setFocusable(false);
        panel.setBackground(Color.decode("#37474F"));
        //panel.setOpaque(false);
        add(panel);
       
        setSize(600, 400);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            try {
                String username= tusername.getText();
                String password= tpassword.getText();

                conn conn= new conn();
          String query="select * from login where username= '"+ username +"'and password= '"+ password +"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }else{
                 JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if(e.getSource()==back){
            System.exit(98);
        } 
        
        
        
        
        
        
        
        
        /* else if(e.getSource()==logins){
            try {
                String username= tusername.getText();
                String password= tpassword.getText();

                conn conn= new conn();
          String query="select * from employee where name= '"+ username +"'and empID= '"+ password +"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new EmployeeView();
                }else{
                 JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }*/
    }

       
    public static void main(String[] args) {
        new Login();
    }
}
