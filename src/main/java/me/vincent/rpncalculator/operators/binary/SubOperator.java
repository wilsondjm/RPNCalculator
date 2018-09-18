package me.vincent.rpncalculator.operators.binary;

import me.vincent.rpncalculator.numbers.Number;

public class SubOperator extends AbstractBinaryOperator {

    public SubOperator(String operatorString) {
        super(operatorString);
    }

    @Override
    public Number[] doExecute() {
        return new Number[]{new Number(String.valueOf(parameters[0].doubleValue() - parameters[1].doubleValue()))};
    }

}
