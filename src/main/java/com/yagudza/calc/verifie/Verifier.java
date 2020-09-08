package com.yagudza.calc.verifie;

import com.yagudza.calc.convertUtil.Convert;
import com.yagudza.calc.exception.InputFormatException;

import java.util.regex.Pattern;

public class Verifier {

    private final int STRINGS_COUNT = 3;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 10;
    private final String ALLOWED_MATH_OPERATION = "/*+-";
    private final Pattern INTEGER_PATTERN = Pattern.compile("^[1-9][0-9]*$");
    private final Pattern ROMAN_PATTERN = Pattern.compile("^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$");

    private final String input;

    public Verifier(String input) {
        this.input = input;
    }

    /**
     * checks all the conditions of the problem
     * if something is wrong, throws an exception with the description
     */
    public void verify(){
        String[] statements = input.split(" ");
        String num1, num2, operation;

        if (statements.length != STRINGS_COUNT) {
            throw new InputFormatException("Wrong count of input statements");
        }

        operation = statements[1];

        if (operation.length() != 1 || !ALLOWED_MATH_OPERATION.contains(operation)) {
            throw new InputFormatException("Incorrect sign for a mathematical operation");
        }

        num1 = statements[0];
        num2 = statements[2];

        if ((isArab(num1) && isRoman(num2))
                || (isRoman(num1) && isArab(num2))
                || (!isArab(num2) && !isRoman(num2))
                || (!isArab(num1) && !isRoman(num1))
        ) {
            throw new InputFormatException("Unresolved set of operands");
        }

        if (!isDigitInRange(num1) || !isDigitInRange(num2)) {
            throw new InputFormatException("Unresolved range of digit");
        }
    }

    private boolean isArab(String statement) {
        return INTEGER_PATTERN.matcher(statement).matches();
    }

    private boolean isRoman(String statement) {
        return ROMAN_PATTERN.matcher(statement).matches();
    }

    private boolean isDigitInRange(String statement) {
        int digit;
        if (isRoman(statement)) {
            statement = Convert.romanToArab(statement);
        }
        digit = Integer.parseInt(statement);
        return MIN_VALUE <= digit && digit <= MAX_VALUE;
    }
}
