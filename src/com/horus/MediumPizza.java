package com.horus;

import java.util.Arrays;
import java.util.List;

public class MediumPizza extends Pizza {

  private List<Point> slices = Arrays.asList(
      new Point(1, 8),
      new Point(1, 9),
      new Point(1, 10),
      new Point(1, 11),
      new Point(1, 12),
      new Point(2, 4),
      new Point(2, 5),
      new Point(2, 6),
      new Point(3, 3),
      new Point(3, 4),
      new Point(4, 2),
      new Point(4, 3),
      new Point(5, 2),
      new Point(6, 2),
      new Point(8, 1),
      new Point(9, 1),
      new Point(10, 1),
      new Point(11, 1),
      new Point(12, 1)
  );

  @Override
  List<Point> getShapes() {
    return slices;
  }
}
