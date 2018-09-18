package me.vincent.rpncalculator;

import me.vincent.rpncalculator.operators.Operator;
import me.vincent.rpncalculator.operators.OperatorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Vincent.Huang
 */
public class CommandParser {

    private OperatorFactory operatorFactory;

    public CommandParser(OperatorFactory operatorFactory) {
        this.operatorFactory = operatorFactory;
    }

    public Operator[] parseMultiCommandsString(String commandInputString) {
        List<Operator> tempStorageOperators = new ArrayList<>();
        int pos = 1;

        if (commandInputString == null || commandInputString.isEmpty()) {
            return new Operator[]{};
        }

        String[] commands = commandInputString.split(" ");
        for (String command : commands) {
            if (command.isEmpty()) {
                pos++;
                continue;
            }
            Operator operator = parseSingleCommandString(command, pos);
            if (operator != null) {
                tempStorageOperators.add(operator);
            }
            pos += command.length();
        }
        return tempStorageOperators.toArray(new Operator[]{});

    }

    public Operator parseSingleCommandString(String command, int pos) {
        Operator operator = operatorFactory.getOperator(command);
        return operator == null ? operator : new OperatorWrapper(operator, pos);
    }
}
