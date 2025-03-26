package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends  JFrame implements ActionListener {
    Random ran= new Random();
    int number= ran.nextInt(999999);
    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempid;
    JDateChooser tdob;
    JButton add,back;
    JComboBox boxeducation,gender;
     AddEmployee(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/addemploy.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0, 0, 900, 700);
        add(img);

        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icons/EMployee.png"));
        Image i22= i11.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT);
        ImageIcon i33= new ImageIcon(i22);
        JLabel imgg= new JLabel(i33);
        imgg.setBounds(230, 10, 90, 70);
        imgg.setBorder(BorderFactory.createMatteBorder(0, 0,2, 0,Color.black));
        imgg.setBackground(Color.BLACK);
        img.add(imgg);

        getContentPane().setBackground(new Color(163,255,188));
    
        JLabel heading= new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 350, 50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        heading.setBorder(BorderFactory.createMatteBorder(0, 0,2, 0,Color.black));
        heading.setAlignmentX(2);
        img.add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(name);

        tname= new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177,252,197));
        tname.setOpaque(false);
        img.add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(fname);

        tfname= new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177,252,197));
        tfname.setOpaque(false);
        img.add(tfname);

        JLabel Dob = new JLabel("Date Of Birth");
        Dob.setBounds(50, 200, 150, 30);
        Dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(Dob);

        tdob= new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(Color.BLACK);
        tdob.setForeground(Color.yellow);
        tdob.setOpaque(false);
        img.add(tdob);

        JLabel gen = new JLabel("Gender");
        gen.setBounds(400, 200, 150, 30);
        gen.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(gen);

        String itemss[]={"Male","Female","Other"};
        gender = new JComboBox(itemss);
        gender.setBounds(600, 200, 150, 30);
        gender.setOpaque(false);
        img.add(gender);
     

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(address);

        taddress= new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177,252,197));
        taddress.setOpaque(false);
        img.add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(phone);

        tphone= new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177,252,197));
        tphone.setOpaque(false);
        img.add(tphone);
  
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(email);

        temail= new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177,252,197));
        temail.setOpaque(false);
        img.add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        education.setOpaque(false);
        img.add(education);

        String items[]={"BBA","B.Tech","BCA","BA","BSC","B.COM","MBA","MCA","MA","MTech","MSC","PHD"};
        boxeducation = new JComboBox(items);
        boxeducation.setBounds(600, 300, 150, 30);
        boxeducation.setOpaque(false);
        img.add(boxeducation);

        JLabel aadhar = new JLabel("AAdhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(aadhar);

        taadhar= new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177,252,197));
        taadhar.setOpaque(false);
        img.add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(empid);

        tempid= new JLabel(""+number);
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
        tdesignation.setBackground(new Color(177,252,197));
        tdesignation.setOpaque(false);
        img.add(tdesignation);

        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 400, 150, 30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(salary);

        tsalary= new JTextField();
        tsalary.setBounds(600, 400, 150, 30);
        tsalary.setBackground(new Color(177,252,197));
        tsalary.setOpaque(false);
        img.add(tsalary);

        add= new JButton("ADD");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.black);
        add.addActionListener(this);
        add.setOpaque(false);
        img.add(add);

        back= new JButton("Back");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.black);
        back.setOpaque(false);
        back.addActionListener(this);
        img.add(back);
 
        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }
    public AddEmployee(JButton add) throws HeadlessException {
        this.add = add;
    }
 public void actionPerformed(ActionEvent e){
    if(e.getSource()==add){
        String name= tname.getText();
        String fname=tfname.getText();
        String dob=((JTextField) tdob.getDateEditor().getUiComponent()).getText();
        String salary= tsalary.getText();
        String address= taddress.getText();
        String aadhar=taadhar.getText();
        String phone= tphone.getText();
        String email= temail.getText();
        String education= (String)boxeducation.getSelectedItem();
        String genders= (String)gender.getSelectedItem();
        String designation=tdesignation.getText();
        String empID=tempid.getText();

        try {
            conn c= new conn();
            String query="INSERT into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empID+"','"+genders+"')";
            c.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details added Sucessfully");
            setVisible(false);
            new Main_class();
        } catch (Exception E) {
            E.printStackTrace();
        }
 } else{
    setVisible(false);
    new Main_class();
 }
}
public static void main(String[] args) {
    new AddEmployee();
}
}
