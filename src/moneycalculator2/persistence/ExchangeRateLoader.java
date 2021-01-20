/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator2.persistence;

import moneycalculator2.model.Currency;
import moneycalculator2.model.ExchangeRate;
/**
 *
 * @author gabri
 */
public interface ExchangeRateLoader {
    //inicio del exchangeRate localizado en la carpeta Model
    public ExchangeRate load (Currency from, Currency to);
    
}
