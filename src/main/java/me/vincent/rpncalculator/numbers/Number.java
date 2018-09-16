package me.vincent.rpncalculator.numbers;

public class Number {
	private String value;
	private String displayValue;

	public Number(String value) {
		this.value = value;
		formatPrecision();
		formatDisplay();
	}
	
	private void formatPrecision() {
		value = String.format("%.15f", Double.parseDouble(value));
	}

	private void formatDisplay() {
		int dotIndex = value.indexOf(".");


		if (dotIndex == -1) {
			return;
		}
		
		String value10Decimal = String.format("%.10f", Double.parseDouble(value));

		int zeroAfterDotIndex = dotIndex;
		for (int i = zeroAfterDotIndex + 1; i < value10Decimal.length(); i++) {
			if (value10Decimal.charAt(i) != '0') {
				zeroAfterDotIndex = i + 1;
			}
		}

		displayValue = value10Decimal.substring(0, zeroAfterDotIndex);
	}
	
	public Number add(Number parameter) {
		return new Number(String.valueOf(doubleValue() + parameter.doubleValue()));
	}
	
	public Number substract(Number parameter) {
		return new Number(String.valueOf(doubleValue() - parameter.doubleValue()));
	}
	
	public Number multiple(Number parameter) {
		return new Number(String.valueOf(doubleValue() * parameter.doubleValue()));
	}
	
	public Number divide(Number parameter) {
		return new Number(String.valueOf(doubleValue() / parameter.doubleValue()));
	}
	
	public Number sqrt() {
		return new Number(String.valueOf(Math.sqrt(Double.parseDouble(value))));
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
