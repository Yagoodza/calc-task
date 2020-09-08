package com.yagudza.calc.convertUtil;

public enum RomanDigit {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private final int value;

    RomanDigit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

