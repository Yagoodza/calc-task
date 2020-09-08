package com.yagudza.calc.calculate.Operations;

import com.yagudza.calc.calculate.AbstractOperation;
import com.yagudza.calc.entity.CalcEntity;

public class Subtract extends AbstractOperation {


    public Subtract(CalcEntity calcEntity) {
        super(calcEntity);
    }

    @Override
    public int getResult(int num1, int num2) {
        return calcEntity.getNum1() - calcEntity.getNum2();
    }
}
