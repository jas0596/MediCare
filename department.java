package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class department extends JFrame{
    department(){
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,700,250);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department ");
        label1.setBounds(145,11,105,20);
        label1.setFont(new Font("Tahoma ",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone number ");
        label2.setBounds(431,11,150,20);
        label2.setFont(new Font("Tahoma ",Font.BOLD,14));
        panel.add(label2);

        JButton back = new JButton("BACK");
        back.setBounds(275,410,130,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.setBorderPainted(false);
        panel.add(back);
        
        back.addActionListener(e -> {
            setVisible(false);
            dispose();
        });


        setVisible(true);
    }
    public static void main(String[] args) {
        new department();
    }
}
