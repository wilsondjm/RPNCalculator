package me.vincent.rpncalculator.operators.binary;

import me.vincent.rpncalculator.numbers.Number;

public class SubOperator extends AbstractBinaryOperator {
	
	public SubOperator() {
		
	}

	public SubOperator(Number[] parameters) {
		super(parameters);
	}

	@Override
	public Number doCalculate() {
		return parameters[0].substract(parameters[1]);
	}

}
