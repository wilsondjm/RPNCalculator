package me.vincent.rpncalculator.operators;

import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.noparam.PutOperator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

/**
 * [Please add some comments]
 *
 * @Author Vincent.Huang
 */
public class OperatorFactory {

    private Stack<Number> numberStack;

    private Stack<Operator> operatorStack;

    public OperatorFactory(Stack<Number> numberStack, Stack<Operator> operatorStack) {
        this.numberStack = numberStack;
        this.operatorStack = operatorStack;
    }

    public Operator getOperator(String operatorString) {
        if (Operators.operatorsMapping.size() == 0) {
            return null;
        }

        Class<? extends Operator> clazz = null;

        if (Operators.isValidateOperator(operatorString)) {
            clazz = Operators.operatorsMapping.get(operatorString);
        }
        /**for unrecognized operators like numbers, return the {@link PutOperator}*/
        if (clazz == null) {
            /** Should check if the command is a valid {@link Number}*/
            if (Number.isValidNumber(operatorString)) {
                clazz = Operators.operatorsMapping.get("");
            } else {
                return null;
            }
        }
        try {
            Constructor<? extends Operator> constructor = clazz.getDeclaredConstructor(new Class[]{String.class});
            Operator targetOperator = constructor.newInstance(operatorString);
            return OperatorPostProcess(targetOperator);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            System.out.printf("[%s]-[%s]-[%s] : %s\n",
                    Thread.currentThread().getName(),
                    "ERROR",
                    "Failed to create operator\"" + operatorString + "\" with ERROR ",
                    e.getMessage());
            return null;
        }
    }

    public Operator OperatorPostProcess(Operator operator) {
        if (operator instanceof OperatorsAware) {
            ((OperatorsAware) operator).setOperatorStack(operatorStack);
        }

        if (operator instanceof NumbersAware) {
            ((NumbersAware) operator).setNumberStack(numberStack);
        }

        return operator;
    }

}
