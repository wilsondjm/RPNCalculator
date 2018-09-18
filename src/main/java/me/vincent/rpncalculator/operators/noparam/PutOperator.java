package me.vincent.rpncalculator.operators.noparam;

import me.vincent.rpncalculator.constants.Constants;
import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.AbstractOperator;

/**
 * @author Vincent.Huang
 */
public class PutOperator extends AbstractOperator {

    public PutOperator(String operatorString) {
        super(operatorString);
    }

    @Override
    public int getRequiredNumofParameters() {
        return Constants.NO_PARAM_OPERATOR_PATAM_SIZE;
    }

    @Override
    public Number[] doExecute() {
        String operatorString = this.operatorString;
        return new Number[]{new Number(operatorString)};
    }

}
