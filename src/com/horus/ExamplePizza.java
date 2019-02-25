package com.horus;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ExamplePizza extends Pizza {

  private static final List<Point> shapes = Arrays.asList(
      new Point(1, 2),
      new Point(2, 1),
      new Point(2, 2),
      new Point(2, 3),
      new Point(3, 2)
  );

  @Override
  List<Point> getShapes() {
    return shapes;
  }
}
