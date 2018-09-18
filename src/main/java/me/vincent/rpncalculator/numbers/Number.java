package me.vincent.rpncalculator.numbers;

public class Number {
    private String value;
    private String displayValue;

    public Number(String value) {
        this.value = value;
        formatPrecision();
        formatDisplay();
    }

    public static boolean isValidNumber(String command) {
        try {
            Double.parseDouble(command);
            return true;
        } catch (NumberFormatException e) {
            //log
            return false;
        }
    }

    private void formatPrecision() {
        value = String.format("%.15f", Double.parseDouble(value));
    }

    private void formatDisplay() {
        int dotIndex = value.indexOf(".");
        if (dotIndex == -1) {
            return;
        }
        /**
         * Instead of simply cutting of the string....
         */
        String value10Decimal = String.format("%.10f", Double.parseDouble(value));

        int zeroAfterDotIndex = dotIndex;
        for (int i = zeroAfterDotIndex + 1; i < value10Decimal.length(); i++) {
            if (value10Decimal.charAt(i) != '0') {
                zeroAfterDotIndex = i + 1;
            }
        }
        displayValue = value10Decimal.substring(0, zeroAfterDotIndex);
    }

    public String getValue() {
        return value;
    }

    public double doubleValue() {
        return Double.parseDouble(value);
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
