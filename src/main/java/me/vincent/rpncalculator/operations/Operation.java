package me.vincent.rpncalculator.operations;

import me.vincent.rpncalculator.numbers.Number;
import me.vincent.rpncalculator.operators.Operator;

public class Operation {
	
	private Number[] parameters;

    private Operator operator;

    private Number result;

	public Operation(Number[] parameters, Operator operator, Number result){
		this.parameters = parameters;
		this.operator = operator;
		this.result = result;
	}

	public Number[] getParameters() {
		return parameters;
	}

	public void setParameters(Number[] parameters) {
		this.parameters = parameters;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Number getResult() {
		return result;
	}

	public void setResult(Number result) {
		this.result = result;
	}
}
