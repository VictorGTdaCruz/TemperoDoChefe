package devmob.processoseletivo.temperodochefe.core.util;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    public static String ApplyCurrency(int value) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return numberFormat.format((double) value / 100);
    }
}
