package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class patient_discharge extends JFrame{
    patient_discharge(){
        setSize(800,400);
        setLocation(400,250);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label2 = new JLabel("Customer Id");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);
        
        JLabel rno = new JLabel();
        rno.setBounds(200,130,150,20);
        rno.setFont(new Font("Tahoma",Font.BOLD,14));
        rno.setForeground(Color.white);
        panel.add(rno);     
        
        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30,180,250,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel intime = new JLabel();
        intime.setBounds(200,180,150,20);
        intime.setFont(new Font("Tahoma",Font.BOLD,14));
        intime.setForeground(Color.white);
        panel.add(intime);    
        
        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        Date date = new Date();
        JLabel outtime = new JLabel(""+date);
        outtime.setBounds(200,230,250,20);
        outtime.setFont(new Font("Tahoma",Font.BOLD,14));
        outtime.setForeground(Color.white);
        panel.add(outtime); 

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.white);
        discharge.setOpaque(true); 
        discharge.setBorderPainted(false);  
        discharge.setFocusPainted(false);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                conn c = new conn();
                try{
                    c.statement.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no ='"+rno.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.setOpaque(true); 
        check.setBorderPainted(false);  
        check.setFocusPainted(false);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                conn c = new conn();
                try{
                    ResultSet resultSet= c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        rno.setText(resultSet.getString("Room_number"));
                        intime.setText(resultSet.getString("Time"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setOpaque(true); 
        back.setBorderPainted(false);  
        back.setFocusPainted(false);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new patient_discharge();
    }
}
