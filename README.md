# Hybrid Gradients Library for Processing

![Radial gradients with 5%, 20%, 35%, 50% noise](https://raw.githubusercontent.com/aaron-keenan/gradients_for_processing/master/examples/documentation/images/radial-with-noise.png)
*Radial gradients with 5%, 20%, 35%, 50% noise*

![Linear gradients with 5%, 20%, 35%, 50% noise](https://raw.githubusercontent.com/aaron-keenan/gradients_for_processing/master/examples/documentation/images/linear-with-noise.png)
*Linear gradients with 5%, 20%, 35%, 50% noise*

A Processing library for creating and combining gradients

* Create custom linear, radial, noise and hybrid gradients

* Customise the list of colours for each gradient

* Colours can be spaced equally along the gradient or set at specific points

### Example palletes.json colour list

```json
{
  "palettes": {
    "example": {
      "path": {
        "colours": ["#200140", "#B04178", "#CF799A", "#E2CE98"],
        "stops": [0.00, 0.30, 0.60, 1.00]
      }
    }
  }
}
```

The gradient will default to equal spacing where no "stops" list is defined.

### Example linear gradient

```
GradientLinear gradient = new GradientLinear(this);
gradient.setPalette("example.path");
gradient.setStart(new PVector(0, 0));
gradient.setEnd(new PVector(width, height));
gradient.setPosition(0, 0, width, height);
gradient.display();
```

### Example radial gradient

```
GradientRadial gradient = new GradientRadial(this);
gradient.setPalette("example.path");
gradient.setCentre(new PVector(100, 100));
gradient.setSize(100);
gradient.setPosition(0, 0, width, height);
gradient.display();
```

### Example noise gradient

```
GradientNoise gradient = new GradientNoise(this);
gradient.setPalette("example.path");
// stepX, stepY, lod, falloff
gradient.setNoiseDetails(0.01, 0.01, 8, 0.5);
gradient.setPosition(0, 0, width, height);
gradient.display();
```

### Example hybrid gradient
```
gradientHybrid = new GradientHybrid(this);
gradientHybrid.setPalette("example.path");
gradientHybrid.addGradient(gradientNoise, 0.25);
gradientHybrid.addGradient(gradientRadial, 0.75);
```
