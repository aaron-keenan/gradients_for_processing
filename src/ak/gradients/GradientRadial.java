package ak.gradients;

import processing.core.PApplet;
import processing.core.PVector;

public class GradientRadial extends GradientAbstract {
	PVector centre = new PVector(0, 0);
	
	float size = 100.0f;
	
	public GradientRadial(PApplet theParent) {
		super(theParent);
	}
	
	public void setCentre(PVector theCentre) {
		this.centre = theCentre;
	}
	
	public void setSize(float theSize) {
		this.size = theSize;
	}

	public float getGradientProgress(int i) {
		PVector position = this.getPixelVector(i);
		float distanceFromCentre = this.centre.copy().sub(position).mag();
		distanceFromCentre = PApplet.constrain(distanceFromCentre, 0, this.size);
		return PApplet.map(distanceFromCentre, 0, this.size, 0, 1);
	}
}
