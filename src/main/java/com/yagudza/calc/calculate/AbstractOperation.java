package com.yagudza.calc.calculate;

import com.yagudza.calc.convertUtil.Convert;
import com.yagudza.calc.entity.CalcEntity;
import com.yagudza.calc.entity.NumericSystem;

public abstract class AbstractOperation implements Operation{

    protected int result;
    protected CalcEntity calcEntity;

    public AbstractOperation(CalcEntity calcEntity) {
        this.calcEntity = calcEntity;
    }

    @Override
    public String operate(){
        result = getResult(calcEntity.getNum1(), calcEntity.getNum2());
        if (calcEntity.getSystem() == NumericSystem.ARAB){
            return String.valueOf(result);
        } else {
            return Convert.arabToRoman(String.valueOf(result));
        }
    }

    abstract protected int getResult(int num1, int num2);
}
