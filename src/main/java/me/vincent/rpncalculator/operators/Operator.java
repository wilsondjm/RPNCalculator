package me.vincent.rpncalculator.operators;

import me.vincent.rpncalculator.numbers.Number;

public interface Operator {
	
	int getRequiredNumofParameters();
	
	void setParameters(Number[] args);
	
	Number calculate();

}
