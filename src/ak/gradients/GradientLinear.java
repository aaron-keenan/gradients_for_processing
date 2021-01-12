package ak.gradients;

import processing.core.PApplet;

public class GradientLinear extends Gradient {
	public GradientLinear(PApplet theParent) {
		super(theParent);
	}

	public float getGradientProgress(int i) {
		return PApplet.map(getPixelY(i), 0, parent.height, 0, 1);
	}
}
