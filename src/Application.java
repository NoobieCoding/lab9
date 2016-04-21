
public class Application {
	public static void main(String[] args) {
		UnitConverter uc = new UnitConverter();
		ConverterUI converterUserInterface = new ConverterUI(uc);
		converterUserInterface.run();
	}
}
