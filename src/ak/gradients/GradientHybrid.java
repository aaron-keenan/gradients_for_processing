package ak.gradients;

import java.util.ArrayList;
import processing.core.PApplet;

public class GradientHybrid extends Gradient {
	ArrayList<Gradient> gradients = new ArrayList<Gradient>();

	public GradientHybrid(PApplet theParent) {
		super(theParent);
	}

	public void addGradient(Gradient gradient, float weight) {
		gradient.setWeight(weight);
		gradients.add(gradient);
	}

	public float getGradientProgress(int i) {
		float progress = 0.0f;
		if (gradients == null) {
			return progress;
		}
		for (Gradient gradient : gradients) {
			progress += gradient.getGradientProgress(i) * gradient.weight;
		}
		return progress;
	}
}