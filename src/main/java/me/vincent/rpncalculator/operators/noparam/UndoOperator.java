package me.vincent.rpncalculator.operators.noparam;

import me.vincent.rpncalculator.constants.Constants;
import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.AbstractOperator;
import me.vincent.rpncalculator.operators.Operator;
import me.vincent.rpncalculator.operators.OperatorsAware;

import java.util.EmptyStackException;
import java.util.Stack;

public class UndoOperator extends AbstractOperator implements OperatorsAware {

    private Stack<Operator> operatorStack;

    public UndoOperator(String operatorString) {
        super(operatorString);
    }

    @Override
    public int getRequiredNumofParameters() {
        return Constants.NO_PARAM_OPERATOR_PATAM_SIZE;
    }

    @Override
    public Number[] doExecute() {

        Operator tobeUndoOperator;

        try {
            tobeUndoOperator = operatorStack.pop();
        } catch (EmptyStackException e) {
            //log the error
            return new Number[]{};
        }
        if (tobeUndoOperator.getResult() != null) {
            int numberCountInResult = tobeUndoOperator.getResult().length;
            for (int i = 0; i < numberCountInResult; i++) {
                numberStack.pop();
                //TODO should implement some checks
            }
        }
        return tobeUndoOperator.getParameters();
    }

    @Override
    public void setOperatorStack(Stack<Operator> operatorStack) {
        this.operatorStack = operatorStack;
    }
}