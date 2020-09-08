package com.yagudza.calc.calculate;

import com.yagudza.calc.calculate.Operations.Division;
import com.yagudza.calc.calculate.Operations.Multiplication;
import com.yagudza.calc.calculate.Operations.Subtract;
import com.yagudza.calc.calculate.Operations.Sum;
import com.yagudza.calc.entity.CalcEntity;

public class SomeOperation {

    public Operation choice(CalcEntity calcEntity) {

        String sign = calcEntity.getSign();
        switch (sign) {
            case "+":
                return new Sum(calcEntity);
            case "-":
                return new Subtract(calcEntity);
            case "*":
                return new Multiplication(calcEntity);
            default:
                return new Division(calcEntity);
        }
    }
}