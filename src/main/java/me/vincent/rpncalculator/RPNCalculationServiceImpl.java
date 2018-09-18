package me.vincent.rpncalculator;

import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.Operator;
import me.vincent.rpncalculator.operators.OperatorFactory;
import me.vincent.rpncalculator.operators.OperatorsAware;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static me.vincent.rpncalculator.operators.Operators.initOperatorsRegistry;

/**
 * @author Vincent.Huang
 */
public class RPNCalculationServiceImpl implements CalculationService {

    /**
     * Stack that keeps all the Operator recoreds.
     */
    private Stack<Operator> operatorStack = new Stack<>();

    /**
     * Stack that keeps all the Numbers.
     */
    private Stack<Number> numberStack = new Stack<>();

    private OperatorFactory operatorFactory;

    private CommandParser commandParser;

    public RPNCalculationServiceImpl() {
        initOperatorsRegistry();
        operatorFactory = new OperatorFactory(numberStack, operatorStack);
        commandParser = new CommandParser(operatorFactory);
    }

    @Override
    public void execute(String commandInputString) {
        Operator[] operators = commandParser.parseMultiCommandsString(commandInputString);
        for (Operator operator : operators) {
            try {
                operator.execute();
            } catch (EmptyStackException e) {
                System.out.printf("operator * (position: %d): insucient parameters\r\n", ((OperatorWrapper) operator).getPos());
                break;
            }
            if (((OperatorWrapper) operator).getOperator() instanceof OperatorsAware) {
                continue;
            }
            operatorStack.push(operator);
        }
        String numberStackAsString = getStackAsString();
        System.out.printf("Stack: %s\n", numberStackAsString);
    }

    @Override
    public String getStackAsString() {
        Number[] stackArray = numberStack.toArray(new Number[]{});
        List<String> numberStringList = Arrays.stream(stackArray).map(num -> num.toString())
                .collect(Collectors.toList());
        String stackString = String.join(" ", numberStringList);
        return stackString;
    }
}
