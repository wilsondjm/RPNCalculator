package me.vincent.rpncalculator;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operations.Operation;
import me.vincent.rpncalculator.operators.Operator;
import me.vincent.rpncalculator.operators.Operators;
import me.vincent.rpncalculator.operators.binary.AddOperator;
import me.vincent.rpncalculator.operators.common.ClearOperator;
import me.vincent.rpncalculator.operators.common.UndoOperator;

import static java.lang.String.join;

/**
 * RPN Calculator
 * @author Vincent.Huang
 */

public class RPNCalculator {

    /** Stack that keeps all the Operation recoreds so that undo can rely on it, Should wrap it in future*/
	private Stack<Operation> operations = new Stack<>();

	/** Stack that keeps all the Numbers, should wrap it in future...*/
	private Stack<Number> numbers = new Stack<>();

	public static void main(String[] args) {
	    init();

		System.out.println("RPN Calculator:");

		RPNCalculator calculator = new RPNCalculator();
		while (calculator.read()) {
			calculator.printStack();
		}
	}

	public static void init(){
	    Operators.initOperators();
    }

	public boolean read() {
		Scanner sc = new Scanner(System.in);
		String commandString = sc.nextLine().trim();
		if (commandString.isEmpty()) {
			return true;
		}
        return processConsoleCommand(commandString);
	}

	public boolean processConsoleCommand(String commandString){
        if (!commandString.equalsIgnoreCase("EXIT")) {
            /** record the current running command pos */
            int pos = 1;
            try {
                String[] commands = commandString.split(" ");
                for (int i = 0; i < commands.length; i++) {
                    processCommand(commands[i]);
                    pos += commands[i].length() + 1;
                }
                return true;
            } catch(EmptyStackException e) {
                System.out.printf("operator * (position: %d): insucient parameters\r\n", pos);
                return true;
            }
        } else {
            return false;
        }
    }

	public void processCommand(String command) {
		if(command == null || command.isEmpty()) {
			return;
		}

        Operator action = Operators.getOperator(command);
		/** ignore the unqualified operators*/
		if (action == null){
		    return;
        }

		if (!Operators.isValidateOperator(command)) {
            operatePut(command);
		} else {
            operateOperations(action);
		}
	}

	private void operatePut(String number) {

	    Operator action = Operators.getOperator("");
		Number wrappedNumber = new Number(number);
		action.setParameters(new Number[] { wrappedNumber });

		/** for PutOperation, ignore its parameter as when undo the put, no need to insert anything back to stack*/
		Operation putOperation = new Operation( new Number[]{}, action, action.calculate());
		numbers.push(putOperation.getResult());
		operations.push(putOperation);
	}

	private void operateOperations(Operator action) {
		int requiredNum = action.getRequiredNumofParameters();

		if (requiredNum == 0) {
			if (action instanceof ClearOperator) {
				Operation clearOperation = new Operation(numbers.toArray(new Number[] {}), action, action.calculate());
				numbers.clear();
				operations.push(clearOperation);
			} else if (action instanceof UndoOperator) {
				Operation tobeUndoOperation = operations.pop();
				if (tobeUndoOperation.getResult() != null) {
					numbers.pop();
				}
				Number[] tobeUndoParameters = tobeUndoOperation.getParameters();
				for (Number i : tobeUndoParameters) {
					numbers.push(i);
				}
			}
		} else {
			final int size_t = action.getRequiredNumofParameters();
			Number[] parameters = new Number[size_t];
            int popIndex = 0;
            try{
                for (; popIndex < requiredNum; popIndex++) {
                    parameters[size_t - popIndex - 1] = numbers.pop();
                }
            }catch (EmptyStackException e){

                /**push the poped numbers back to stack when error*/
                popIndex -= 1;
                for(; popIndex >= 0; popIndex-- ){
                    numbers.push(parameters[size_t - popIndex - 1]);
                }
                throw e;
            }

			action.setParameters(parameters);
			Number result = action.calculate();
			numbers.push(result);

			Operation operation = new Operation(parameters, action, result);
			operations.push(operation);
		}
	}

	public String printStack() {
		Number[] stackArray = numbers.toArray(new Number[] {});
		List<String> numberStringList = Arrays.stream(stackArray).map(num -> num.toString())
				.collect(Collectors.toList());
		String stackString = String.join(" ", numberStringList);
		System.out.printf("Stack: %s\n", stackString);
		return stackString;
	}
}
