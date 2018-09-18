package me.vincent.rpncalculator.operators;

import me.vincent.rpncalculator.numbers.Number;

import java.util.EmptyStackException;
import java.util.Stack;


/**
 * @author Vincent.Huang
 */
public abstract class AbstractOperator implements Operator, NumbersAware {

    protected Number[] parameters;

    protected Number[] result;

    protected String operatorString;

    protected Stack<Number> numberStack;

    public AbstractOperator(String operatorString) {
        this.operatorString = operatorString;
    }

    /**
     * prepare the parameters for operators
     */
    private void prepareParameters() {
        int requiredNumofParameters = getRequiredNumofParameters();

        if (requiredNumofParameters == 0) {
            parameters = new Number[]{};
        }

        if (requiredNumofParameters == -1) {
            requiredNumofParameters = numberStack.size();
        }

        parameters = new Number[requiredNumofParameters];
        int popIndex = 0;
        try {
            for (; popIndex < requiredNumofParameters; popIndex++) {
                parameters[requiredNumofParameters - popIndex - 1] = numberStack.pop();
            }
        } catch (EmptyStackException e) {

            /**push the poped numbers back to stack when error*/
            popIndex -= 1;
            for (; popIndex >= 0; popIndex--) {
                numberStack.push(parameters[requiredNumofParameters - popIndex - 1]);
            }
            throw e;
        }
    }

    @Override
    public final void execute() {
        prepareParameters();
        result = doExecute();
        processResultAfterExecution();
    }

    private void processResultAfterExecution() {
        for (Number number : result) {
            numberStack.push(number);
        }
    }

    @Override
    public Number[] getParameters() {
        return parameters;
    }

    @Override
    public Number[] getResult() {
        return result;
    }

    @Override
    public void setNumberStack(Stack<Number> numberStack) {
        this.numberStack = numberStack;
    }

    /**
     * @return int size of the require parameters
     */
    @Override
    public abstract int getRequiredNumofParameters();

    /**
     * Run the operator
     *
     * @return {@link Number} the value that shoud be push into the number stack.
     */
    protected abstract Number[] doExecute();

}
