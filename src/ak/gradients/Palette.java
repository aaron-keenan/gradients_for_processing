package ak.gradients;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class Palette {

	// Reference to the parent sketch
	PApplet parent;

	JSONObject palettes, selectedPalette;

	public Palette(PApplet theParent) {
		parent = theParent;
	}

	public void setPalette(String paletteName) {
		this.setPalette(paletteName, "palettes.json");
	}

	public void setPalette(String paletteName, String filename) {
		palettes = parent.loadJSONObject(filename).getJSONObject("palettes");
		selectedPalette = this.getSelectedPalette(paletteName);
	}

	public float[][] getColours() {
		JSONArray jsonColours = this.getPaletteColours();
		JSONArray jsonStops = selectedPalette.getJSONArray("stops");
		float[][] colours = new float[jsonColours.size()][2];
		for (int i = 0; i < jsonColours.size(); i++) {
			colours[i] = new float[] { jsonStops.getFloat(i), this.convertHexColour(jsonColours.getString(i)) };
		}

		return colours;
	}

	public int getColour(float progress) {
		float[][] colours = this.getColours();
		float[] start = colours[0];
		float[] end = colours[colours.length - 1];
		for (float[] checkpoint : colours) {
			if (progress >= checkpoint[0]) {
				start = checkpoint;
			}
			if (progress < checkpoint[0]) {
				end = checkpoint;
				break;
			}
		}
		float sectionProgress = this.getSectionProgress(progress, start, end);
		return this.smootherLerpColor(Math.round(start[1]), Math.round(end[1]), sectionProgress);
	}
	
	private float getSectionProgress(float progress, float[] start, float[] end) {
		if (start[0] == 1.0) {
			return 1.0f;
		}
		return PApplet.map(PApplet.constrain(progress, start[0], end[0]), start[0], end[0], 0, 1);
	}

	private JSONObject getSelectedPalette(String paletteName) {
		String[] paletteId = PApplet.split(paletteName, ".");
		selectedPalette = palettes;
		for (String id : paletteId) {
			selectedPalette = selectedPalette.getJSONObject(id);
		}
		return selectedPalette;
	}

	public JSONArray getPaletteColours() {
		JSONArray jsonColours = selectedPalette.getJSONArray("colours");
		if (jsonColours == null) {
			jsonColours = selectedPalette.getJSONArray("colors");
		}
		return jsonColours;
	}

	private float convertHexColour(String hex) {
		if (hex.charAt(0) == '#') {
			hex = hex.substring(1);
		}
		return PApplet.unhex(hex);
	}

	private int smootherLerpColor(int a, int b, float progress) {
		float huea = parent.hue(a);
		float hueb = parent.hue(b);
		float delta = hueb - huea;

		if (delta < -180) {
			hueb += 360;
		} else if (delta > 180) {
			huea += 360;
		}

		float hue = (huea + progress * (hueb - huea)) % 360;
		float saturation = PApplet.lerp(parent.saturation(a), parent.saturation(b), progress);
		float brightness = PApplet.lerp(parent.brightness(a), parent.brightness(b), progress);

		return parent.color(hue, saturation, brightness);
	}
}
