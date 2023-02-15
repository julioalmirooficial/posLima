package controllerpublic;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormat {

    public String deleteCharacter(String number) {
        String replaceCharacter = ",";
        String newCharacter = "";
        String resultData = number.replaceAll(replaceCharacter, newCharacter);
        return resultData;
    }

    public String formatCurrency(Double number) {
        
        return NumberFormat.getCurrencyInstance(new Locale("en", "US"))
        .format(number);
    }
}
