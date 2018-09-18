package me.vincent.rpncalculator.operators;


import me.vincent.rpncalculator.numbers.Number;

/**
 *
 *
 * @Author Vincent.Huang
 */
public interface Operator {

    /**
     * Every operater should define the actual number of parameters from the stack
     *
     * @return int the number of parameters required
     */
    int getRequiredNumofParameters();

    /**
     * run the operator
     */
    void execute();

    Number[] getParameters();

    Number[] getResult();

}
