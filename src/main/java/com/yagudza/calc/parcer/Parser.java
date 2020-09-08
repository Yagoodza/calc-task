package com.yagudza.calc.parcer;

import com.yagudza.calc.convertUtil.Convert;
import com.yagudza.calc.entity.CalcEntity;
import com.yagudza.calc.entity.NumericSystem;

import java.util.regex.Pattern;

public class Parser {

    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[1-9][0-9]*$");

    /**
     *
     * @param input verified string from console
     * @return Calc entity
     */

    public CalcEntity parse(String input) {
        String[] statements = input.split(" ");
        boolean isArab = isArab(statements[0]);

        int num1 = getValue(statements[0], isArab);
        int num2 = getValue(statements[2], isArab);
        String sign = statements[1];
        NumericSystem numericSystem = isArab ? NumericSystem.ARAB : NumericSystem.ROMAN;
        return new CalcEntity(num1, num2, sign, numericSystem);
    }

    private int getValue(String statement, boolean isArab) {
        return Integer.parseInt(isArab ? statement : Convert.romanToArab(statement));
    }

    private boolean isArab(String statement) {
        return INTEGER_PATTERN.matcher(statement).matches();
    }
}
