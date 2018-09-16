package me.vincent.rpncalculator.operators.binary;

import me.vincent.rpncalculator.numbers.Number;

public class AddOperator extends AbstractBinaryOperator {
	
	public AddOperator() {
		
	}

	public AddOperator(Number[] parameters) {
		super(parameters);
	}

	@Override
	public Number doCalculate() {
		return parameters[0].add(parameters[1]);
	}

}
