package me.vincent.rpncalculator.operators.unary;
import me.vincent.rpncalculator.numbers.Number;

public class SqrtOperator extends AbstractUnaryOperator {
	
	public SqrtOperator() {
		
	}

	public SqrtOperator(Number[] parameters) {
		super(parameters);
	}

	@Override
	public Number doCalculate() {
		return new Number(String.valueOf(Math.sqrt(parameters[0].doubleValue())));
	}

}
