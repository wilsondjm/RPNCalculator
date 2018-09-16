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
import me.vincent.rpncalculator.operators.common.ClearOperator;
import me.vincent.rpncalculator.operators.common.UndoOperator;

public class RPNCalculator {

	private Stack<Operation> operations = new Stack<>();

	private Stack<Number> numbers = new Stack<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("RPN Calculator:");

		RPNCalculator calculator = new RPNCalculator();
		while (calculator.read()) {
			calculator.printStack();
		}
	}

	public boolean read() {
		Scanner sc = new Scanner(System.in);
		String commandString = sc.nextLine();
		if (commandString.trim().isEmpty()) {
			return true;
		}
		if (!commandString.equalsIgnoreCase("EXIT")) {
			/** record the current running command pos */
			int pos = 1;
			
			try {

				String[] commands = commandString.split(" ");
				for (int i = 0; i < commands.length; i++) {
					process(commands[i]);
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

	public void process(String command) {
		if(command == null || command.isEmpty()) {
			return;
		}
		
		if (!Operators.isValidateOperator(command)) {
			storeNumber(command);
		} else {
			operate(command);
		}
	}

	private void storeNumber(String number) {

		Operator action = Operators.getOperator("");
		Number wrappedNumber = new Number(number);
		action.setParameters(new Number[] { wrappedNumber });

		Operation putOperation = new Operation();
		putOperation.parameters = new Number[] {};
		putOperation.operator = action;
		putOperation.result = action.calculate();

		numbers.push(putOperation.result);

		operations.push(putOperation);
	}

	private void operate(String operator) {
		Operator action = Operators.getOperator(operator);

		int requiredNum = action.getRequiredNumofParameters();

		if (requiredNum == 0) {
			if (action instanceof ClearOperator) {
				Operation clearOperation = new Operation();
				clearOperation.parameters = numbers.toArray(new Number[] {});
				clearOperation.operator = action;
				clearOperation.result = action.calculate();

				numbers.clear();

				operations.push(clearOperation);
			} else if (action instanceof UndoOperator) {
				Operation tobeUndoOperation = operations.pop();
				if (tobeUndoOperation.result != null) {
					Number topInNumbersStack = numbers.pop();
				}
				Number[] tobeUndoParameters = tobeUndoOperation.parameters;
				for (Number i : tobeUndoParameters) {
					numbers.push(i);
				}
			}
		} else {
			final int size_t = action.getRequiredNumofParameters();
			Number[] parameters = new Number[size_t];

			for (int i = 0; i < requiredNum; i++) {
				parameters[size_t - i - 1] = numbers.pop();
			}

			action.setParameters(parameters);
			Number result = action.calculate();
			numbers.push(result);

			Operation operation = new Operation();
			operation.parameters = parameters;
			operation.operator = action;
			operation.result = result;
			operations.push(operation);
		}
	}

	public void printStack() {
		Number[] stackArray = numbers.toArray(new Number[] {});
		List<String> numberStringList = Arrays.stream(stackArray).map(num -> num.toString())
				.collect(Collectors.toList());
		System.out.printf("Stack: %s\n", String.join(" ", numberStringList));
	}

}
