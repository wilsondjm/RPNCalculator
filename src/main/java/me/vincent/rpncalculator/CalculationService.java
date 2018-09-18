package me.vincent.rpncalculator;

/**
 * Created by Vincent
 *
 * @author Vincent.Huang
 */
public interface CalculationService {

    /**
     * Run the string command with {@link CalculationService}
     * @param commandInputString
     */
    void execute(String commandInputString);

    String getStackAsString();
}
