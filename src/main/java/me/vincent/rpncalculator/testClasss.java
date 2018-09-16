package me.vincent.rpncalculator;

public class testClasss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "32";
		String b = "2";
		
//		double aa = Double.parseDouble(a);
//		double bb = Double.parseDouble(b);
//		
//		System.out.println("" + aa);
//		
//		System.out.println(aa/ Integer.parseInt(b));
//		
//		System.out.println(aa + bb);
//		
//		System.out.println(aa / bb);
		
		System.out.println("12.0".indexOf("."));
		
		System.out.println(formatDisplay(String.format("%.10f", Double.parseDouble("12"))));

	}
	
	private static String formatDisplay(String value) {
		String displayValue = "";
		
		int dotIndex = value.indexOf(".");

		if (dotIndex == -1) {
			return value;
		}
		
		String value10Decimal = String.format("%.10f", Double.parseDouble(value));

		int zeroAfterDotIndex = dotIndex;
		for (int i = zeroAfterDotIndex + 1; i < value10Decimal.length(); i++) {
			if (value10Decimal.charAt(i) != '0') {
				zeroAfterDotIndex = i + 1;
			}
		}

		displayValue = value10Decimal.substring(0, zeroAfterDotIndex);
		
		return displayValue;
	}

}
