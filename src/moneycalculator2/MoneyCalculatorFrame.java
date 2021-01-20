/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator2.control.Command;
import moneycalculator2.model.Currency;
import moneycalculator2.ui.MoneyDialog;
import moneycalculator2.ui.MoneyDisplay;
import moneycalculator2.ui.swing.SwingMoneyDialog;
import moneycalculator2.ui.swing.SwingMoneyDisplay;

/**
 *
 * @author gabri
 */
public class MoneyCalculatorFrame extends JFrame {
    private final Map <String, Command> commands=new HashMap<>();
    //clase que compone todo
    private final List<Currency> currencies;
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    
    public MoneyCalculatorFrame(List<Currency> currencies) {
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog(),BorderLayout.NORTH);
        this.add(moneyDisplay(),BorderLayout.SOUTH);
        this.add(toolbar(),BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    public void add(Command command){
        commands.put(command.name(),command);
    }
    public MoneyDialog getMoneyDialog(){
        return moneyDialog;
    }
    public MoneyDisplay getMoneyDisplay(){
        return moneyDisplay;
    }

    private Component moneyDialog() {
        SwingMoneyDialog swingMoneyDialog=new SwingMoneyDialog(currencies);
        this.moneyDialog=swingMoneyDialog;
        return swingMoneyDialog;
    }

    private Component toolbar() {
        JPanel toolbarPanel=new JPanel();
        toolbarPanel.add(calculateButton());
        return toolbarPanel;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay swingMoneyDisplay = new SwingMoneyDisplay();
        this.moneyDisplay=swingMoneyDisplay;
        return swingMoneyDisplay;
    }

    private JButton calculateButton() {
        JButton button=new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                commands.get("calculate").execute();
            }
        };
    }
    
    
}
