/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator2.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import moneycalculator2.model.Currency;
import moneycalculator2.persistence.CurrencyListLoader;

/**
 *
 * @author gabri
 */
public class FileCurrencyListLoader implements CurrencyListLoader{
    private final String fileName;

    public FileCurrencyListLoader(String fileName) {
        this.fileName = fileName;
    }
    
            
    @Override
    public List<Currency> currencies() {
        List<Currency>list =new ArrayList<>();
        try {
            BufferedReader reader =new BufferedReader(new FileReader(new File(this.fileName)));
            while(true){
               String line=reader.readLine();
               if(line==null)break;
               list.add(currencyOf(line));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error para pillar el fichero");
        } catch (IOException ex) {
            System.out.println("Error para abrir o cerrar el fichero");
        }
        return list;
        }

    private Currency currencyOf(String line) {
        String [] split=line.split(",");
        return new Currency(split[0],split[1],split[2]);
    } 
}
