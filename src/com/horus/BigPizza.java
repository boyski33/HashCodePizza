package com.horus;

import java.util.Arrays;
import java.util.List;

public class BigPizza extends Pizza {

  private List<Point> points = Arrays.asList(
      new Point(3, 4),
      new Point(4, 3),
      new Point(2, 7),
      new Point(7, 2),
      new Point(2, 6),
      new Point(6, 2),
      new Point(1, 12),
      new Point(12, 1),
      new Point(1, 13),
      new Point(13, 1),
      new Point(1, 14),
      new Point(14, 1)
  );

  @Override
  List<Point> getShapes() {
    return points;
  }
}
