package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class ambulance extends JFrame{

    ambulance(){
        setSize(900,600);
        setLocation(300,200);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD, 15));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet= c.statement.executeQuery(q);
            table.setModel((DbUtils.resultSetToTableModel(resultSet)));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(31,11,100,16);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(200,11,100,16);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label2);

        JLabel label3 = new JLabel("Car_name");
        label3.setBounds(385,11,100,16);
        label3.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label3);

        JLabel label4 = new JLabel("Available");
        label4.setBounds(570,11,100,16);
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(745,11,100,16);
        label5.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label5);

        JButton button = new JButton("BACK");
        button.setBounds(390,510,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setOpaque(true); 
        button.setBorderPainted(false);  
        button.setFocusPainted(false);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
        setUndecorated(true);
        setVisible(true);
    }


    public static void main(String[] args) {
        new ambulance();
    }
}
