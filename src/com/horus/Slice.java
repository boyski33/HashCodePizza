package com.horus;

public class Slice {

  Point start;
  Point end;

  public Slice(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  public int size() {
    return Math.abs(start.row - end.row) * Math.abs(start.col - end.col);
  }

  @Override
  public String toString() {
    return "Slice{" +
        "start=" + start +
        ", end=" + end +
        '}';
  }
}
