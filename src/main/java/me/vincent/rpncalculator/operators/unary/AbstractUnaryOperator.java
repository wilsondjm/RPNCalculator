package me.vincent.rpncalculator.operators.unary;

import me.vincent.rpncalculator.constants.Constants;
import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.AbstractOperator;

public abstract class AbstractUnaryOperator extends AbstractOperator {
	
	public AbstractUnaryOperator() {
		
	}

	public AbstractUnaryOperator(Number[] parameters) {
		super(parameters);
	}

	@Override
	public final int getRequiredNumofParameters() {
		return Constants.UNARY_REQUIRED_PARAM_SIZE;
	}

}
