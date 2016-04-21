
public class UnitConverter {
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		double returnValue = amount * fromUnit.getValue();
		return returnValue / toUnit.getValue();
	}
	
	public Unit[] getUnits() {
		return Length.values();
	}
}
