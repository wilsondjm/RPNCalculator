package me.vincent.rpncalculator.operators.binary;

import me.vincent.rpncalculator.constants.Constants;
import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.AbstractOperator;

public abstract class AbstractBinaryOperator extends AbstractOperator {
	
	public AbstractBinaryOperator() {
		
	}

	public AbstractBinaryOperator(Number[] parameters) {
		super(parameters);
	}

	@Override
	public int getRequiredNumofParameters() {
		return Constants.BINARY_REQUIRED_PARAM_SIZE;
	}

}
