package ak.gradients;

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 * @example Hello 
 */

public class Gradient {
	
	// Reference to the parent sketch
	PApplet parent;
	
	Palette palette;
	
	PImage image;

	float weight = 1.0f;
	
	int gradientWidth, gradientHeight;
	
	public final static String VERSION = "##library.prettyVersion##";
	
	/**
	 * @param theParent the parent PApplet
	 */
	public Gradient(PApplet theParent) {
		parent = theParent;
		palette = new Palette(parent);
		welcome();
	}
	
	private void welcome() {
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
	}
	
	public void setPalette(String paletteName) {
		palette.setPalette(paletteName, "palettes.json");
	}
	
	public void setPalette(String paletteName, String filename) {
		palette.setPalette(paletteName, filename);
	}
	
	public JSONArray getColours() {
		return palette.getPaletteColours();
	}
	
	public float getGradientProgress(int i) {
		return 0.0f;
	}
	
	public void setWeight(float _weight) {
		this.weight = _weight;
	}
	
	public int getPixelX(int i) {
		return i % gradientWidth;
	}

	public int getPixelY(int i) {
		return PApplet.floor(i / gradientWidth);
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

