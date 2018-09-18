package me.vincent.rpncalculator;

import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.Operator;

/**
 * Wrap the Operator for the pos requirement when error
 *
 * @Author Vincent.Huang
 */
public class OperatorWrapper implements Operator {

    private Operator operator;
    private int pos = 0;

    public OperatorWrapper(Operator operator, int pos) {
        this.operator = operator;
        this.pos = pos;
    }

    @Override
    public int getRequiredNumofParameters() {
        return operator.getRequiredNumofParameters();
    }


    @Override
    public void execute() {
        operator.execute();
    }

    @Override
    public Number[] getParameters() {
        return operator.getParameters();
    }

    @Override
    public Number[] getResult() {
        return operator.getResult();
    }

    public int getPos() {
        return pos;
    }

    public Operator getOperator() {
        return operator;
    }
}
