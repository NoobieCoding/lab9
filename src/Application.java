
public class Application {
	public static void main(String[] args) {
		UnitConverter uc = new UnitConverter();
		ConverterUI converterUserInteface = new ConverterUI(uc);
		converterUserInteface.run();
	}
}
