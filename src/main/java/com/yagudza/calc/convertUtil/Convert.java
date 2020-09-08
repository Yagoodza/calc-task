package com.yagudza.calc.convertUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Convert {

    private static List<RomanDigit> getReverseSortedValues() {
        List<RomanDigit> romanDigitList = Arrays.asList(RomanDigit.values());
        Collections.reverse(romanDigitList);
        return romanDigitList;
    }

    public static String arabToRoman(String value) {

        int number = Integer.parseInt(value);
        if (number == 0) {
            return "0";
        }
        List<RomanDigit> romanNumerals = getReverseSortedValues();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        if (number < 0) {
            sb.append("-");
            number = Math.abs(number);
        }
        while ((number > 0) && (i < romanNumerals.size())) {
            RomanDigit currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static String romanToArab(String roman) {

        int result = 0;
        List<RomanDigit> romanNumerals = getReverseSortedValues();

        int i = 0;

        while ((roman.length() > 0) && (i < romanNumerals.size())) {
            RomanDigit symbol = romanNumerals.get(i);
            if (roman.startsWith(symbol.name())) {
                result += symbol.getValue();
                roman = roman.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (roman.length() > 0) {
            throw new IllegalArgumentException();
        }
        return String.valueOf(result);
    }
}
