/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator2.control;

import moneycalculator2.model.Currency;
import moneycalculator2.model.Money;
import moneycalculator2.persistence.ExchangeRateLoader;
import moneycalculator2.ui.MoneyDialog;
import moneycalculator2.ui.MoneyDisplay;

/**
 *
 * @author gabri
 */
public class CalculateCommand implements Command{

    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private final ExchangeRateLoader loader;

    public CalculateCommand(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay, ExchangeRateLoader loader) {
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
        this.loader = loader;
    }
    private Currency eur=new Currency("EUR","Euro","€");
    @Override
    public String name() {
        return "calculate";
    }

    @Override
    public void execute() {
        moneyDisplay.display(exchange(moneyDialog.get()));
    }

    private Money exchange(Money money) {
        return new Money(money.getAmount()* rateOf(money.getCurrency()),eur);
    }

    private double rateOf(Currency currency) {
        return loader.load(currency, eur).getAmount();
    }
    
    
}
