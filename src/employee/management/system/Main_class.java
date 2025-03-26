package employee.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main_class extends  JFrame  {
    JMenuBar menubar;
      Main_class(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/up.jpg"));
        Image i2= i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icons/icon.png"));
        Image i23= i.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
        ImageIcon i43= new ImageIcon(i23);
        JLabel imag= new JLabel(i43);
        imag.setBounds(10, 10, 50, 30);
        add(img);

        ImageIcon i12= new ImageIcon(ClassLoader.getSystemResource("icons/Employee.png"));
        Image i22= i12.getImage().getScaledInstance(70, 40, Image.SCALE_DEFAULT);
        ImageIcon i33= new ImageIcon(i22);
        JLabel imgg= new JLabel(i33);
        imgg.setBounds(0, 0, 0, 0);

        JLabel heading= new JLabel("Employee Management System");
        heading.setBounds(330, 100, 500, 40);
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        heading.setForeground(Color.black);
        img.add(heading);

        JButton add= new JButton("Add Employee");
        add.setBounds(200 ,500 , 150, 40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view= new JButton("View Employee");
        view.setBounds(560 ,500 , 150, 40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new View_Employee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rem= new JButton("Remove Employee");
        rem.setBounds(380 ,500 , 150, 40);
        rem.setForeground(Color.white);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new RemoveEmployee();
                setVisible(false);
            }
        });
        img.add(rem);

        JButton back= new JButton("Back To Login");
        back.setBounds(740 ,500 , 150, 40);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Login();
                setVisible(false);
            }
        });
        img.add(back);

        menubar=new JMenuBar();
        this.setJMenuBar(menubar);
        menubar.setBackground(Color.white);
        menubar.setForeground(Color.BLACK);
        menubar.setBounds(0, 0, 1120, 20);
        menubar.add(imgg);
        menubar.add(heading);

        JLabel labelName= new JLabel("Name");
        labelName.setBounds(720,130, 300, 20);
        labelName.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(labelName);

        JLabel labelname= new JLabel("Narayan Singh");
        labelname.setBounds(850,130, 300, 20);
        labelname.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(labelname);

        JLabel labelpost= new JLabel("Post");
        labelpost.setBounds(720,170, 300, 20);
        labelpost.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(labelpost);

        JLabel labelPost= new JLabel("Manager");
        labelPost.setBounds(850,170, 300, 20);
        labelPost.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(labelPost);

        JLabel labelId= new JLabel("EmpID");
        labelId.setBounds(720,220, 300, 20);
        labelId.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(labelId);

        JLabel labelid= new JLabel("778240");
        labelid.setBounds(850,220, 300, 20);
        labelid.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(labelid);
//extra code for pratice
        JPanel panel= new JPanel();
        panel.setBorder(BorderFactory.createMatteBorder(3, 3,3, 3,Color.black));
        panel.setBounds(700, 20, 330, 330);
        panel.setBackground(new Color(0,0,0));
        panel.setOpaque(false);
        panel.setAutoscrolls(true);
        panel.add(imag);
        System.out.println();
        //panel.add(labelName);
        img.add(panel);
      
        setLayout(null);
        setSize(1120,630);
        setLocation(250, 100);       
        setVisible(true);
            }
            public static void main(String[] args) {
        new Main_class();
    }
}
