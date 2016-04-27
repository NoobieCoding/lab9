/**
 * Application used to run the GUI.
 * @author Nuttapong Rojanavanich
 */
public class Application {
	public static void main(String[] args) {
		UnitConverter uc = new UnitConverter();
		ConverterUI converterUserInterface = new ConverterUI(uc);
		converterUserInterface.run();
	}
}
