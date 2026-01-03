package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class update_patient_details extends JFrame{
    update_patient_details(){
        setSize(950,500);
        setLocation(400,250);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        // ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/"));
        // Image image = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        // ImageIcon imageIcon1 = new ImageIcon(image);
        // JLabel label = new JLabel(imageIcon1);
        // label.setBounds(500,60,300,300);
        // panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textField = new JTextField();
        textField.setBounds(248,129,140,20);
        panel.add(textField);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldintime = new JTextField();
        textFieldintime.setBounds(248,174,140,20);
        panel.add(textFieldintime);

        JLabel label5 = new JLabel("Amount Piad (Rs) :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldamount = new JTextField();
        textFieldamount.setBounds(248,216,140,20);
        panel.add(textFieldamount);

        JLabel label6 = new JLabel("Pending Piad (Rs) :");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldpending = new JTextField();
        textFieldpending.setBounds(248,261,140,20);
        panel.add(textFieldpending);

        JButton check = new JButton("CHECK");
        check.setBounds(220,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.setOpaque(true); 
        check.setBorderPainted(false);  
        check.setFocusPainted(false);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet= c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textField.setText(resultSet.getString("Room_number"));
                        textFieldintime.setText(resultSet.getString("Time"));
                        textFieldamount.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1= c.statement.executeQuery("select * from room where room_no = '"+textField.getText()+"'");
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldamount.getText());
                        textFieldpending.setText(""+amountPaid);
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56,378,110,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setOpaque(true); 
        update.setBorderPainted(false);  
        update.setFocusPainted(false);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    conn c= new conn();
                    String q = choice.getSelectedItem();
                    String room = textField.getText();
                    String time = textFieldintime.getText();
                    String amount = textFieldamount.getText();
                    c.statement.executeUpdate("update patient_info set Room_number = '"+room+"',Time = '"+time+"', Deposite = '"+amount+"' where name = '"+q+"'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(358,378,89,23);
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
        new update_patient_details();
    }
}
