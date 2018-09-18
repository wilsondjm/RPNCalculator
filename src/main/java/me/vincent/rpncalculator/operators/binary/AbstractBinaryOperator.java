package me.vincent.rpncalculator.operators.binary;

import me.vincent.rpncalculator.constants.Constants;
import me.vincent.rpncalculator.operators.AbstractOperator;

public abstract class AbstractBinaryOperator extends AbstractOperator {

    public AbstractBinaryOperator(String operatorString) {
        super(operatorString);
    }

    @Override
    public int getRequiredNumofParameters() {
        return Constants.BINARY_OPERATOR_PARAM_SIZE;
    }

}
