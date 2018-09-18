package me.vincent.rpncalculator.operators;

import me.vincent.rpncalculator.numbers.Number;

import java.util.Stack;

/**
 * Operator that implements {@link NumbersAware} will be indect with Number Stack
 * @Author Vincent.Huang
 */
public interface NumbersAware {
    /**
     * Inject with number stack
     * @param numberStack
     */
    void setNumberStack(Stack<Number> numberStack);
}
