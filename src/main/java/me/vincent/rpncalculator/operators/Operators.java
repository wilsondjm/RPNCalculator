package me.vincent.rpncalculator.operators;

import java.util.Vector;

import me.vincent.rpncalculator.constants.Constants;
import me.vincent.rpncalculator.operators.binary.AddOperator;
import me.vincent.rpncalculator.operators.binary.DiviOperator;
import me.vincent.rpncalculator.operators.binary.MultipOperator;
import me.vincent.rpncalculator.operators.binary.SubOperator;
import me.vincent.rpncalculator.operators.common.ClearOperator;
import me.vincent.rpncalculator.operators.common.PutOperator;
import me.vincent.rpncalculator.operators.common.UndoOperator;
import me.vincent.rpncalculator.operators.unary.SqrtOperator;

public class Operators {
	
	private static Vector<String> operators;
	
	static {
		init();
	}
	
	private static void init() {
		operators = new Vector<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		operators.add("sqrt");
		operators.add("undo");
		operators.add("clear");
	}
	
	public static boolean isValidateOperator(String arg) {
		return operators.contains(arg);
	}
	
	public static Operator getOperator(String operator) {
		Operator targetOperator = null;
		
		switch(operator) {
			case Constants.OPREATOR_MULTIPLICATION:
				targetOperator = new MultipOperator();
				break;
			case Constants.OPERATOR_ADDITION:
				targetOperator = new AddOperator();
				break;
			case Constants.OPERATOR_SUBSTRACTION:
				targetOperator = new SubOperator();
				break;
			case Constants.OPERATOR_DIVISION:
				targetOperator = new DiviOperator();
				break;
			case Constants.OPERATOR_SQRT:
				targetOperator = new SqrtOperator();
				break;
			case Constants.OPERATOR_UNDO:
				targetOperator = new UndoOperator();
				break;
			case Constants.OPERATOR_CLEAR:
				targetOperator = new ClearOperator();
				break;				
			default:
				/** the defaut operator for numbers, push stack */
				targetOperator = new PutOperator();
		}
		return targetOperator;
	}
	
}