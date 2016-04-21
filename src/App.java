
public class App {
	public static void main(String[] args) {
		/// Length[] lengths = Length.values();
		// for (Length x : lengths) {
		// System.out.println(x.toString() + " " + x.getValue());
		// }
		UnitConverter uc = new UnitConverter();

		
		System.out.println(uc.convert(3.0, Length.MILE, Length.KILOMETER));
	}
}
