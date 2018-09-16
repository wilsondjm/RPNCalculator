package me.vincent.rpncalculator.operators.common;

import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.AbstractOperator;

public class ClearOperator extends AbstractOperator {
	
	public ClearOperator() {
		
	}

	public ClearOperator(Number[] parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRequiredNumofParameters() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Number doCalculate() {
		// TODO Auto-generated method stub
		return null;
	}

}
