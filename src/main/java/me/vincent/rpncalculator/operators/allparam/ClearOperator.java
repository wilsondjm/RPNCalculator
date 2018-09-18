package me.vincent.rpncalculator.operators.allparam;

import me.vincent.rpncalculator.constants.Constants;
import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.AbstractOperator;

/**
 * @author Vincent.Huang
 */
public class ClearOperator extends AbstractOperator {


    public ClearOperator(String operatorString) {
        super(operatorString);
    }

    @Override
    public int getRequiredNumofParameters() {
        return Constants.ALL_PARAM_OPERATOR_PATAM_SIZE;
    }

    @Override
    public Number[] doExecute() {
        numberStack.clear();
        return new Number[]{};
    }
}
