/**
 * Enum that storing the length unit including its name and value.
 * @author Nuttapong Rojanavanich
 */
public enum Length implements Unit{
	METER("Meter", 1.0),
	CENTIMETER("Centimeter", 0.01),
	KILOMETER("Kilometer", 1000),
	MILE("Mile", 1609.344),
	INCH("Inch", 0.0254),
	FOOT("Foot", 0.30480),
	YARD("Yard", 0.9144),
	MICRON("Micron", 1.0E-6),
	WA("Wa", 2.0);
	
	public final String name;
	public final double value;
	/**
	 * Constructor with name and value as arguments.
	 * @param name is the name of length unit.
	 * @param value is the value of length unit.
	 */
	private Length(String name, double value) {
		this.name = name;
		this.value = value;
	}
	/**
	 * Return the value of length unit.
	 */
	public double getValue()  {
		return value;
	}
	/**
	 * Return the name of length unit.
	 */
	public String getName() {
		return name;
	}
}
