package me.vincent.rpncalculator.operators.binary;

import me.vincent.rpncalculator.numbers.Number;

public class MultipOperator extends AbstractBinaryOperator {
	
	public MultipOperator() {
		
	}

	public MultipOperator(Number[] parameters) {
		super(parameters);
	}

	@Override
	public Number doCalculate() {
		return parameters[0].multiple(parameters[1]);
	}

}
