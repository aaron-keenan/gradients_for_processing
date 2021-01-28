package ak.gradients;

import java.util.ArrayList;
import processing.core.PApplet;

public class GradientHybrid extends GradientAbstract {
	ArrayList<GradientAbstract> gradients = new ArrayList<GradientAbstract>();

	public GradientHybrid(PApplet theParent) {
		super(theParent);
	}

	public void addGradient(GradientAbstract gradient, float weight) {
		gradient.setWeight(weight);
		gradients.add(gradient);
	}

	public float getGradientProgress(int i) {
		float progress = 0.0f;
		if (gradients == null) {
			return progress;
		}
		for (GradientAbstract gradient : gradients) {
			progress += gradient.getGradientProgress(i) * gradient.weight;
		}
		return progress;
	}
}