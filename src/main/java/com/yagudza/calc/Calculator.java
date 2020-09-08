package com.yagudza.calc;

//import com.yagudza.calc.convert.RomanToArab;
//import com.yagudza.calc.entity.CalcEntity;
import com.yagudza.calc.calculate.Operation;
import com.yagudza.calc.calculate.SomeOperation;
import com.yagudza.calc.entity.CalcEntity;
import com.yagudza.calc.exception.InputFormatException;
import com.yagudza.calc.parcer.Parser;
import com.yagudza.calc.verifie.Verifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    void letsCalc() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            new Verifier(input).verify();
            CalcEntity calcEntity = new Parser().parse(input);
            Operation operation = new SomeOperation().choice(calcEntity);
            System.out.println(operation.operate());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InputFormatException e) {
            System.err.println(e.getMessage());
        }
    }
}
