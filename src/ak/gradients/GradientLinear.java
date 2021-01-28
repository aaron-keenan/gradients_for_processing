package ak.gradients;

import processing.core.PApplet;
import processing.core.PVector;

public class GradientLinear extends GradientAbstract {
	PVector start, end;
	
	public GradientLinear(PApplet theParent) {
		super(theParent);
	}
	
	public void setStart(PVector theStart) {
		start = theStart;
	}
	
	public void setEnd(PVector theEnd) {
		end = theEnd;
	}

	public float getGradientProgress(int i) {
		return PApplet.map(this.getPixelY(i), 0, this.gradientHeight, 0, 1);
	}
}
