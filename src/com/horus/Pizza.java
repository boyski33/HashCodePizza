package com.horus;

import java.util.List;
import java.util.Random;

public abstract class Pizza {

  abstract List<Point> getShapes();

  public Slice chooseRandomSlice(Point point) {
    Random random = new Random();
    int rnd = random.nextInt(getShapes().size());

    return new Slice(point, point.add(getShapes().get(rnd)));
  }

}
