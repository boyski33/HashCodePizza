package com.horus;

public class Point {

  int col;
  int row;

  public Point(int col, int row) {
    this.col = col;
    this.row = row;
  }

  public Point add(Point point) {
    return new Point(this.col + point.col, this.row + point.row);
  }

  @Override
  public String toString() {
    return String.format("[row=%s, col=%s]", row, col);
  }
}
