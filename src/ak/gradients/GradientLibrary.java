package ak.gradients;

public class GradientLibrary {
	
	public final static String VERSION = "##library.prettyVersion##";

	public GradientLibrary() {
		welcome();
	}
	
	private void welcome() {
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
	}

	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}
}
