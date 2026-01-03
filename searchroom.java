package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class searchroom extends JFrame{
    searchroom(){
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);

        Choice choice;
        JTable table;

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.white);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);

        JLabel status = new JLabel("Status :");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.white);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setForeground(Color.white);
        table.setBackground(new Color(90,156,63));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(23,162,150,20);
        roomno.setForeground(Color.white);
        roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomno);

        JLabel available = new JLabel("Availability");
        available.setBounds(220,162,150,20);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add((available));

        JLabel price = new JLabel("Price");
        price.setBounds(420,162,150,20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add((price));

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(580,162,150,20);
        bed.setForeground(Color.white);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add((bed));

        JButton search = new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.white);
        search.setOpaque(true); 
        search.setBorderPainted(false);  
        search.setFocusPainted(false);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String q ="select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton back = new JButton("Back");
        back.setBounds(380,420,120,25);
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

        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new searchroom();
    }
}
