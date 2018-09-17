package me.vincent.rpncalculator.operators;

import me.vincent.rpncalculator.operators.binary.AddOperator;
import me.vincent.rpncalculator.operators.binary.DiviOperator;
import me.vincent.rpncalculator.operators.binary.MultipOperator;
import me.vincent.rpncalculator.operators.binary.SubOperator;
import me.vincent.rpncalculator.operators.common.ClearOperator;
import me.vincent.rpncalculator.operators.common.PutOperator;
import me.vincent.rpncalculator.operators.common.UndoOperator;
import me.vincent.rpncalculator.operators.unary.SqrtOperator;

import me.vincent.rpncalculator.numbers.Number;

import java.util.HashMap;


/**
 * Operators defines the static common functions for Calculator
 * @Author Vincent.Huang
 */
public class Operators {


//	/** Strings of supported operators */
//	public static final String OPERATOR_ADDITION = "+";
//
//	public static final String OPERATOR_SUBSTRACTION = "-";
//
//	public static final String OPREATOR_MULTIPLICATION = "*";
//
//	public static final String OPERATOR_DIVISION = "/";
//
//	public static final String OPERATOR_SQRT = "sqrt";
//
//	public static final String OPERATOR_UNDO = "undo";
//
//	public static final String OPERATOR_CLEAR = "clear";
//
//
//	/** Collection of all support operators*/
//	private static Vector<String> operators;
//
//	static {
//		init();
//	}
//
//	private static void init() {
//		operators = new Vector<>();
//		operators.add(OPERATOR_ADDITION);
//		operators.add(OPERATOR_SUBSTRACTION);
//		operators.add(OPREATOR_MULTIPLICATION);
//		operators.add(OPERATOR_DIVISION);
//		operators.add(OPERATOR_SQRT);
//		operators.add(OPERATOR_UNDO);
//		operators.add(OPERATOR_CLEAR);
//	}

//	/**
//	 * Discared
//	 * @param operatorString
//	 * @return @{link Operator}
//	 */
//	public static Operator getOperator(String operatorString) {
//		Operator targetOperator = null;
//
//		switch(operatorString) {
//			case OPREATOR_MULTIPLICATION:
//				targetOperator = new MultipOperator();
//				break;
//			case OPERATOR_ADDITION:
//				targetOperator = new AddOperator();
//				break;
//			case OPERATOR_SUBSTRACTION:
//				targetOperator = new SubOperator();
//				break;
//			case OPERATOR_DIVISION:
//				targetOperator = new DiviOperator();
//				break;
//			case OPERATOR_SQRT:
//				targetOperator = new SqrtOperator();
//				break;
//			case OPERATOR_UNDO:
//				targetOperator = new UndoOperator();
//				break;
//			case OPERATOR_CLEAR:
//				targetOperator = new ClearOperator();
//				break;
//			default:
//				/** the defaut operator for numbers, push stack */
//				targetOperator = new PutOperator();
//		}
//		return targetOperator;
//	}

    private static HashMap<String, Class<? extends Operator>> operatorsMapping = new HashMap<>();

    /**
     * in case of production env, shoud support external configurations like property files, system properties and cmd configurations.
     * Here for simple, just init with java code
     */
    public static void initOperators() {
        registerOperator("+", AddOperator.class);
        registerOperator("/", DiviOperator.class);
        registerOperator("-", SubOperator.class);
        registerOperator("*", MultipOperator.class);
        registerOperator("clear", ClearOperator.class);
        registerOperator("undo", UndoOperator.class);
        registerOperator("sqrt", SqrtOperator.class);
        registerOperator("", PutOperator.class);
    }

    public static boolean isValidateOperator(String operatorString) {
        return operatorsMapping.containsKey(operatorString);
    }

    public static void registerOperator(String operatorString, Class<? extends Operator> clazz) {
        operatorsMapping.put(operatorString, clazz);
    }

    public static Operator getOperator(String operatorString) {
        if(operatorsMapping.size() == 0){
            return null;
        }

        Class<? extends Operator> clazz = operatorsMapping.get(operatorString);

        /**for unrecognized operators like numbers, return the {@link PutOperator}*/
        if (clazz == null) {
            /** Should check if the command is a valid {@link Number}2*/
            if(Number.isValidNumber(operatorString)){
                clazz = operatorsMapping.get("");
            }else{
                return null;
            }
        }

        try {
            Operator targetOperator = clazz.newInstance();
            return targetOperator;
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.printf("[%s]-[%s]-[%s] : %s\n",
                    Thread.currentThread().getName(),
                    "ERROR",
                    "Failed to create operator\"" + operatorString + "\" with ERROR ",
                    e.getMessage());
            return null;
        }
    }

}