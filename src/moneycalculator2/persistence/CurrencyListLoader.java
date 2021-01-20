/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator2.persistence;

import java.util.List;
import moneycalculator2.model.Currency;

/**
 *
 * @author gabri
 */
public interface CurrencyListLoader {
    public List<Currency> currencies();
}
