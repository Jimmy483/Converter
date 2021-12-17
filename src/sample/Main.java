package sample;

import sample.models.CurrencyList;

import javax.swing.*;
import java.awt.*;

public class Main  {

    public static void main(String[] args) {

        JFrame jFrame=new JFrame();
        jFrame.setTitle("Converter");
        jFrame.setSize(300,350);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel=new JPanel();
        jFrame.add(jPanel);

        jPanel.setLayout(null);
        JLabel labelHead=new JLabel();
        labelHead.setText("Currency Converter");
        labelHead.setBounds(80,40,150,30);
        jPanel.add(labelHead);

        JLabel labelAmount = new JLabel();
        labelAmount.setText("Amount ");
        labelAmount.setBounds(30,90,60,20);
        jPanel.add(labelAmount);

        JTextField textAmount = new JTextField();
        textAmount.setBounds(80,90,120,20);
        jPanel.add(textAmount);

        JComboBox jComboBox=new JComboBox();
        jComboBox.addItem(new CurrencyList("USD (American Dollar)",1));
        jComboBox.addItem(new CurrencyList("AUD (Australian Dollar)",2));
        jComboBox.addItem(new CurrencyList("NPR (Nepali Rupee)",3));
        jComboBox.addItem(new CurrencyList("YEN (Japanese Yen)",4));
        jComboBox.addItem(new CurrencyList("WON (Korean Won)",5));
        //jComboBox.setSelectedItem("NPR (Nepali Rupee)");
        jComboBox.getModel().setSelectedItem(new CurrencyList("NPR (Nepali Rupee)",3));
        jComboBox.setBounds(80, 130, 120,20);
        jPanel.add(jComboBox);

        JLabel labelTo=new JLabel();
        labelTo.setBounds(125,160,70,40);
        labelTo.setText("TO");
        labelTo.setFont(new Font("Arial",Font.BOLD,20));
        jPanel.add(labelTo);

        JComboBox jBox=new JComboBox();
        jBox.addItem(new CurrencyList("USD (American Dollar)",1));
        jBox.addItem(new CurrencyList("AUD (Australian Dollar)",2));
        jBox.addItem(new CurrencyList("NPR (Nepali Rupee)",3));
        jBox.addItem(new CurrencyList("YEN (Japanese Yen)",4));
        jBox.addItem(new CurrencyList("WON (Korean Won)",5));
        jBox.getModel().setSelectedItem(new CurrencyList("AUD (Australian Dollar)",2));
        jBox.setBounds(80,210,120,20);
        jPanel.add(jBox);

        JTextField textResult=new JTextField();
        textResult.setBounds(95,250,100,20);
        textResult.setText("0");
        textResult.setEnabled(false);
        jPanel.add(textResult);

//        JButton jButton=new JButton();
//        jButton.setBounds(95,280,100,30);
//        jButton.setBackground(Color.darkGray);
//        jButton.setForeground(Color.WHITE);
//        jButton.setFont(new Font("Arial",Font.ITALIC,15));
//        jButton.setText("Convert");
//        jPanel.add(jButton);



        jFrame.setVisible(true);
    }
}
