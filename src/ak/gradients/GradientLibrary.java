package ak.gradients;

import processing.core.PApplet;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package
 * 'template' to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder
 * 'examples' will automatically include the example in the javadoc.)
 *
 * @example Hello
 */

public class GradientLibrary {

	// Reference to the parent sketch
	PApplet parent;

	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * @param theParent the parent PApplet
	 */
	public GradientLibrary(PApplet theParent) {
		parent = theParent;
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
