package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener{

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;


    login(){
    setSize(750,300);
    setLocation(400,270);
    setLayout(null);
    getContentPane().setBackground(new Color(109,164,170));
    
    JLabel nameLabel = new JLabel("Username");
    nameLabel.setBounds(40,20,100,30);
    nameLabel.setFont(new Font("Tahoma",Font.BOLD,16));
    nameLabel.setForeground(Color.BLACK);
    add(nameLabel);

    JLabel password = new JLabel("Password");
    password.setBounds(40,70,100,30);
    password.setFont(new Font("Tahoma",Font.BOLD,16));
    password.setForeground(Color.BLACK);
    add(password);

    textField= new JTextField();
    textField.setBounds(150,20,150,30);
    textField.setFont(new Font("Tahoma", Font.BOLD, 15));
    textField.setBackground(new Color(255,179,0));
    add(textField);

    jPasswordField = new JPasswordField();
    jPasswordField.setBounds(150,70,150,30);
    jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
    jPasswordField.setBackground(new Color(255,179,0));
    add(jPasswordField);


    JPanel buttonPanel = new JPanel();
    buttonPanel.setBounds(0, 120, 350, 50);
    buttonPanel.setLayout(null);
    buttonPanel.setOpaque(false); 


    ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg")); 
    Image i1 = imageIcon.getImage().getScaledInstance(250, 100, Image.SCALE_DEFAULT); 
    ImageIcon imageIcon1 = new ImageIcon(i1);
    JLabel label = new JLabel(imageIcon1);
    label.setBounds(335,-30,450,300); 
    add(label);

    b1 = new JButton("Login");
    b1.setBounds(40, 0, 120, 30);
    b1.setFont(new Font("serif",Font.BOLD,15));
    b1.setBackground(Color.black);
    b1.setForeground(Color.WHITE);
    b1.setOpaque(true);
    b1.setBorderPainted(false);
    b1.addActionListener(this);

    b2 = new JButton("Sign Up");
    b2.setBounds(180, 0, 120, 30);
    b2.setFont(new Font("serif",Font.BOLD,15));
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setOpaque(true);
    b2.setBorderPainted(false);
    b2.addActionListener(this);


    buttonPanel.add(b1);
    buttonPanel.add(b2);
    add(buttonPanel);

    setVisible(true);
    
    revalidate();
    repaint();
}

@Override
public void actionPerformed(ActionEvent e){
    if(e.getSource() == b1){
        try{
            conn c = new conn();
            String user = textField.getText();
            String Pass = jPasswordField.getText();

            String q = "select * from login where ID = '"+user+"' and PW = '"+Pass+"' ";
            ResultSet resultSet = c.statement.executeQuery(q);

            if(resultSet.next()){
                new reception();
                setVisible(false);
            }else{
                    JOptionPane.showMessageDialog(null, "Invalid");
            }

        }catch(Exception E){
            E.printStackTrace();
        }

    }else if(e.getSource() == b2){
            // Sign Up logic
            String user = textField.getText();
            String pass = new String(jPasswordField.getPassword());

            if(user.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter both username and password");
                return;
            }

            try{
                conn c = new conn();
                
                // Check if username already exists
                String checkQuery = "select * from login where ID = '"+user+"'";
                ResultSet resultSet = c.statement.executeQuery(checkQuery);
                
                if(resultSet.next()){
                    JOptionPane.showMessageDialog(null, "Username already exists! Please choose a different username.");
                }else{
                    // Insert new user
                    String insertQuery = "insert into login values('"+user+"', '"+pass+"')";
                    c.statement.executeUpdate(insertQuery);
                    JOptionPane.showMessageDialog(null, "Account created successfully! You can now login.");
                    
                    // Clear fields after successful signup
                    textField.setText("");
                    jPasswordField.setText("");
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error creating account: " + ex.getMessage());
            }
        }
}
    public static void main(String[] args) {
        new login();
    }
}