package me.vincent.rpncalculator.operators;

import me.vincent.rpncalculator.operators.allparam.ClearOperator;
import me.vincent.rpncalculator.operators.binary.AddOperator;
import me.vincent.rpncalculator.operators.binary.DiviOperator;
import me.vincent.rpncalculator.operators.binary.MultipOperator;
import me.vincent.rpncalculator.operators.binary.SubOperator;
import me.vincent.rpncalculator.operators.noparam.PutOperator;
import me.vincent.rpncalculator.operators.noparam.UndoOperator;
import me.vincent.rpncalculator.operators.unary.SqrtOperator;

import java.util.HashMap;


/**
 * Operators defines the static common functions for Calculator
 *
 * @Author Vincent.Huang
 */
public class Operators {


    public static HashMap<String, Class<? extends Operator>> operatorsMapping = new HashMap<>();

    /**
     * in case of production env, shoud support external configurations like property files, system properties and cmd configurations.
     * Here for simple, just init with java code
     */
    public static void initOperatorsRegistry() {
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
}