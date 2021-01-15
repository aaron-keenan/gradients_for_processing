package ak.gradients;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import processing.data.JSONArray;

public class Gradient {
	PApplet parent;

	Palette palette;

	PImage image;

	float weight = 1.0f;

	int gradientX, gradientY, gradientWidth, gradientHeight;

	public Gradient(PApplet theParent) {
		parent = theParent;
		palette = new Palette(parent);
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

	public void setPosition(int _x, int _y, int _width, int _height) {
		this.gradientX = _x;
		this.gradientY = _y;
		this.gradientWidth = _width;
		this.gradientHeight = _height;
		this.image = parent.createImage(_width, _height, PApplet.RGB);
	}

	public void createLinear(PVector start, PVector end) {

	}

	public void updatePixels() {
		for (int i = 0; i < image.pixels.length; i++) {
			image.pixels[i] = getColour(i);
		}
	}

	public void display() {
		parent.image(this.image, gradientX, gradientY);
	}

	public int getColour(int i) {
		float gradientProgress = getGradientProgress(i);
		return this.palette.getColour(gradientProgress);
	}
}
