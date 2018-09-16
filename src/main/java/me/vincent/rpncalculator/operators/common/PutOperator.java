package me.vincent.rpncalculator.operators.common;
import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.AbstractOperator;

public class PutOperator extends AbstractOperator {
	
	public PutOperator() {
		
	}

	public PutOperator(Number[] parameters) {
		super(parameters);
	}

	@Override
	public int getRequiredNumofParameters() {
		return 0;
	}

	@Override
	public Number doCalculate() {
		return parameters[0];
	}

}
