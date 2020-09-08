package com.yagudza.calc.entity;

public class CalcEntity {
    private final int num1;
    private final int num2;
    private final String sign;
    private final NumericSystem numericSystem;

    public CalcEntity(int num1, int num2, String sign, NumericSystem numericSystem) {
        this.num1 = num1;
        this.num2 = num2;
        this.sign = sign;
        this.numericSystem = numericSystem;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getSign() {
        return sign;
    }

    public NumericSystem getSystem() {
        return numericSystem;
    }
}
