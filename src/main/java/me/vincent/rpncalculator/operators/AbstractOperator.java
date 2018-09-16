package me.vincent.rpncalculator.operators;
import me.vincent.rpncalculator.numbers.Number;

public abstract class AbstractOperator implements Operator {
	
	protected Number[] parameters;
	
	public AbstractOperator() {
		
	}
	
	
	public AbstractOperator(Number[] parameters) {
		setParameters(parameters);
	}
	
	public void setParameters(Number[] args) {
		parameters = args;
	}
	
	public final Number calculate() {
		
		return doCalculate();
	}
	
	
	public abstract int getRequiredNumofParameters();
	
	public abstract Number doCalculate();
	
	
}
