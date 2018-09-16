package me.vincent.rpncalculator.operators.binary;

import me.vincent.rpncalculator.numbers.Number;

public class DiviOperator extends AbstractBinaryOperator {
	
	public DiviOperator() {
		
	}

	public DiviOperator(Number[] parameters) {
		super(parameters);
	}

	@Override
	public Number doCalculate() {
		return parameters[0].divide(parameters[1]);
	}

}
