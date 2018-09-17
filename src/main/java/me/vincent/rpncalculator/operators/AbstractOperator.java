package me.vincent.rpncalculator.operators;
import me.vincent.rpncalculator.numbers.Number;

public abstract class AbstractOperator implements Operator {
	
	protected Number[] parameters;
	
	public AbstractOperator() {
	}

	public AbstractOperator(Number[] parameters) {
		setParameters(parameters);
	}

	@Override
	public void setParameters(Number[] args) {
		parameters = args;
	}

	@Override
	public final Number calculate() {
		
		return doCalculate();
	}
	
	@Override
	public abstract int getRequiredNumofParameters();
	
	public abstract Number doCalculate();
	
	
}
