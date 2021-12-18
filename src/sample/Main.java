package sample;

import sample.models.CurrencyList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.TextAction;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.net.http.WebSocket;

public class Main implements ActionListener {


    JTextField textAmount = new JTextField();
    JComboBox jComboBox=new JComboBox();
    JComboBox jBox=new JComboBox();


    public Main(){
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


        textAmount.setBounds(80,90,120,20);
        textAmount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                check();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                check();
            }
        });
        jPanel.add(textAmount);

        jComboBox.addItem(new CurrencyList("NPR (Nepali Rupee)",1));
        jComboBox.addItem(new CurrencyList("USD (American Dollar)",2));
        jComboBox.addItem(new CurrencyList("AUD (Australian Dollar)",3));
        jComboBox.addItem(new CurrencyList("YEN (Japanese Yen)",4));
        jComboBox.addItem(new CurrencyList("WON (Korean Won)",5));
        //jComboBox.setSelectedItem("NPR (Nepali Rupee)");
        jComboBox.getModel().setSelectedItem(new CurrencyList("NPR (Nepali Rupee)",3));
        jComboBox.setBounds(80, 130, 120,20);
        jComboBox.addActionListener(this);
        //System.out.println(jComboBox.getSelectedIndex());
        jPanel.add(jComboBox);


        JLabel labelTo=new JLabel();
        labelTo.setBounds(125,160,70,40);
        labelTo.setText("TO");
        labelTo.setFont(new Font("Arial",Font.BOLD,20));
        jPanel.add(labelTo);

        jBox.addItem(new CurrencyList("NPR (Nepali Rupee)",1));
        jBox.addItem(new CurrencyList("USD (American Dollar)",2));
        jBox.addItem(new CurrencyList("AUD (Australian Dollar)",3));
        jBox.addItem(new CurrencyList("YEN (Japanese Yen)",4));
        jBox.addItem(new CurrencyList("WON (Korean Won)",5));
        jBox.getModel().setSelectedItem(new CurrencyList("NPR (Nepali Rupee)",3));
        jBox.setBounds(80,210,120,20);
        System.out.println(jBox.getSelectedIndex());
        jBox.addActionListener(this);
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

    public static void main(String[] args) {
        new Main();

    }

    public double convert(double rawAmount,int idFirst,int idSecond){
        double convertedAmount=0;
        //double nonConvertedAmount=rawAmount;
        double[] currencyValue={100,90,1,1.11,0.1};
        double rate=currencyValue[idFirst]/currencyValue[idSecond];

        convertedAmount=rawAmount*rate;
        System.out.println(convertedAmount);

        return convertedAmount;

    }

    @Override
    public void actionPerformed(ActionEvent e) {



        check();

    }

    public void check(){
        if(jComboBox.getSelectedIndex()>=0 && jBox.getSelectedIndex()>=0 && !textAmount.getText().equals("") ) {

            convert(Double.parseDouble(textAmount.getText()), jComboBox.getSelectedIndex(), jBox.getSelectedIndex());
        }
    }
}
