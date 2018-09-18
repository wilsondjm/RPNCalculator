package me.vincent.rpncalculator.operators.unary;

import me.vincent.rpncalculator.numbers.Number;

public class SqrtOperator extends AbstractUnaryOperator {

    public SqrtOperator(String operatorString) {
        super(operatorString);
    }

    @Override
    public Number[] doExecute() {
        return new Number[]{new Number(String.valueOf(Math.sqrt(parameters[0].doubleValue())))};
    }

}
