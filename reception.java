package hospital.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class reception extends JFrame {
    reception(){

        setSize(1950,1090);
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160, 1502, 780);
        panel.setBackground(new Color(109,164,170));
        add(panel);


        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image image = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1255,-12,253,180);
        panel1.add(label);

        //ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        //Image image1 = i11.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        //ImageIcon i22 = new ImageIcon(image1);
        //JLabel label1 = new JLabel(i22);   //only if wanna add one more pic
        //label1.setBounds(1330,0,250,180);
        //panel1.add(label1);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(246,215,118));
        btn1.setOpaque(true);
        btn1.setBorderPainted(false);
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new new_patient();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(246,215,118));
        btn2.setOpaque(true);
        btn2.setBorderPainted(false);
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new room();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(30,100,200,30);
        btn3.setBackground(new Color(246,215,118));
        btn3.setOpaque(true);
        btn3.setBorderPainted(false);
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new department();
            }
        });

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(270,15,200,30);
        btn4.setBackground(new Color(246,215,118));
        btn4.setOpaque(true);
        btn4.setBorderPainted(false);
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new employee_info();

            }
        });

        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(270,58,200,30);
        btn5.setBackground(new Color(246,215,118));
        btn5.setOpaque(true);
        btn5.setBorderPainted(false);
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new all_patient_info();
            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270,100,200,30);
        btn6.setBackground(new Color(246,215,118));
        btn6.setOpaque(true);
        btn6.setBorderPainted(false);
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new patient_discharge();
            }
        });

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(510,100,200,30);
        btn9.setBackground(new Color(246,215,118));
        btn9.setOpaque(true);
        btn9.setBorderPainted(false);
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new searchroom();
            }
        });

        JButton btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(510,58,200,30);
        btn8.setBackground(new Color(246,215,118));
        btn8.setOpaque(true);
        btn8.setBorderPainted(false);
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new ambulance();
            }
        });

        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(510,15,200,30);
        btn7.setBackground(new Color(246,215,118));
        btn7.setOpaque(true);
        btn7.setBorderPainted(false);
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new update_patient_details();
            }
        });

        JButton btn10 = new JButton("Logout");
        btn10.setBounds(750,15,200,30);
        btn10.setBackground(new Color(246,215,118));
        btn10.setOpaque(true);
        btn10.setBorderPainted(false);
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });

        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        
        new reception();
    }

    
}
