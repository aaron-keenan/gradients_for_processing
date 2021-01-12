package ak.gradients;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class Palette {
	
	// Reference to the parent sketch
	PApplet parent;
		
	JSONObject palettes, selectedPalette;

	Palette(PApplet theParent) {
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
			colours[i] = new float[]{jsonStops.getFloat(i), this.convertHexColour(jsonColours.getString(i))};
		}
		
		return colours;
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
}
