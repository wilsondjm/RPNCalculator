package me.vincent.rpncalculator.operators;

import java.util.Stack;

/**
 * Operators that implements will be injected with operator stack
 *
 * @Author Vincent.Huang
 */
public interface OperatorsAware {

    /**
     * inject the operatorstack
     * @param operatorStack
     */
    void setOperatorStack(Stack<Operator> operatorStack);
}
