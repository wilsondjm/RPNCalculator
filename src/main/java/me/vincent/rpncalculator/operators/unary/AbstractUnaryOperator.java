package me.vincent.rpncalculator.operators.unary;

import me.vincent.rpncalculator.constants.Constants;
import me.vincent.rpncalculator.operators.AbstractOperator;

/**
 * @Author Vincent.Huang
 */
public abstract class AbstractUnaryOperator extends AbstractOperator {

    public AbstractUnaryOperator(String operatorString) {
        super(operatorString);
    }

    @Override
    public final int getRequiredNumofParameters() {
        return Constants.UNARY_OPERATOR_PARAM_SIZE;
    }

}
