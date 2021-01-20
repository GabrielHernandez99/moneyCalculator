  
package moneycalculator2.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import moneycalculator2.model.Currency;
import moneycalculator2.model.ExchangeRate;
import moneycalculator2.persistence.ExchangeRateLoader;

public class RestExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
        } catch (IOException ex) {
            return null;
        }
    }

    private double read(String from, String to) throws IOException {
        String line = read(new URL("https://api.exchangeratesapi.io/latest?base=" + from + "&symbols=" + to));
        return Double.parseDouble(line.substring(line.indexOf(to)+5, line.indexOf("base") - 5));
    }

    private String read(URL url) throws IOException {
        InputStream is = url.openStream();
        byte[] buffer = new byte[1024];
        int length = is.read(buffer);
        return new String(buffer, 0, length);
    }
}