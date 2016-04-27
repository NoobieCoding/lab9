/**
 * Class for unit converter object.
 * @author Nuttapong Rojanavanich
 */
public class UnitConverter {
	
	/**
	 * Convert the unit of the input amount.
	 * @param amount is initial amount that is going to be converted.
	 * @param fromUnit is the current unit.
	 * @param toUnit is the unit that we are going to convert to.
	 * @return the converted amount (new Unit).
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		double returnValue = amount * fromUnit.getValue();
		return returnValue / toUnit.getValue();
	}
	
	/**
	 * Return all of the units available.
	 * @return the array of units.
	 */
	public Unit[] getUnits() {
		return Length.values();
	}
}
