package ak.gradients;

import processing.core.PApplet;

public class GradientNoise extends Gradient {
	float stepX, stepY;
	
	public GradientNoise(PApplet theParent) {
		super(theParent);
	}

	public float getGradientProgress(int i) {
		return getGradientNoiseValue(i);
	}

	private float getGradientNoiseValue(int i) {
		float x = getPixelX(i) * stepX;
		float y = getPixelY(i) * stepY;
		return parent.noise(x, y);
	}
	  
	public void setGradientNoiseDetails(float _stepX, float _stepY, int lod, float falloff) {
		stepX = _stepX;
		stepY = _stepY;
		parent.noiseDetail(lod, falloff);
	}
}
