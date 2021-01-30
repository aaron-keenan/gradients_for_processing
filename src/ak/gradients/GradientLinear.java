package ak.gradients;

import processing.core.PApplet;
import processing.core.PVector;

public class GradientLinear extends GradientAbstract {
	PVector start, end;
	
	public GradientLinear(PApplet theParent) {
		super(theParent);
	}
	
	public void setStart(PVector theStart) {
		this.start = theStart;
	}
	
	public void setEnd(PVector theEnd) {
		this.end = theEnd;
	}

	public float getGradientProgress(int i) {
		PVector position = this.getPixelVector(i);
		PVector fromStart = PVector.sub(position, start);
		PVector gradientDirection = PVector.sub(end, start);
		float gradientLength = gradientDirection.mag();
		gradientDirection.normalize();
		PVector progress = gradientDirection.mult(fromStart.dot(gradientDirection));
		return PApplet.constrain(progress.mag() / gradientLength, 0, 1);
	}
}
