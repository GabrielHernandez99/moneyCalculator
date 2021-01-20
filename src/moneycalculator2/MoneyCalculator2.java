/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator2;

import moneycalculator2.control.CalculateCommand;
import moneycalculator2.file.FileCurrencyListLoader;
import moneycalculator2.persistence.CurrencyListLoader;
import moneycalculator2.persistence.ExchangeRateLoader;
import moneycalculator2.rest.RestExchangeRateLoader;
/**
 *
 * @author gabri
 */
public class MoneyCalculator2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //definimos los cargadores de las listas de currencies
        CurrencyListLoader currencyListLoader= new FileCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader=new RestExchangeRateLoader();
        MoneyCalculatorFrame moneyCalculatorFrame=new MoneyCalculatorFrame(currencyListLoader.currencies());
        moneyCalculatorFrame.add(new CalculateCommand(moneyCalculatorFrame.getMoneyDialog(),moneyCalculatorFrame.getMoneyDisplay(),exchangeRateLoader));
    }
    
    
}
//view

