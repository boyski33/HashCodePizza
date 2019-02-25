package com.horus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PizzaField {

  private int minIngredientsPerSlice;
  private int maxSliceSize;
  private int rows;
  private int cols;
  private char[][] field;

  public PizzaField(int minIng, int maxSize, char[][] field) {
    this.minIngredientsPerSlice = minIng;
    this.maxSliceSize = maxSize;
    this.field = field;
    this.rows = field.length;
    this.cols = field[0].length;
  }

  public Point pickRandomPoint() {
    Random random = new Random();

    return new Point(random.nextInt(rows), random.nextInt(cols));
  }

  public static PizzaField initFromFile(File file) throws IOException {
    String[] firstLine = Files.lines(file.toPath())
        .findFirst()
        .map(s -> s.split(" ")).get();

    int rows = Integer.valueOf(firstLine[0]);
    int cols = Integer.valueOf(firstLine[1]);
    int minIng = Integer.valueOf(firstLine[2]);
    int maxSize = Integer.valueOf(firstLine[3]);

    char[][] field = new char[rows][cols];
    List<String> lines = Files.readAllLines(file.toPath());

    for (int i = 1; i < lines.size(); i++) {
      String line = lines.get(i);
      for (int j = 0; j < line.length(); j++) {
        field[i - 1][j] = line.charAt(j);
      }
    }

    return new PizzaField(minIng, maxSize, field);

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PizzaField that = (PizzaField) o;
    return minIngredientsPerSlice == that.minIngredientsPerSlice &&
        maxSliceSize == that.maxSliceSize &&
        Arrays.deepEquals(field, that.field);
  }

  @Override
  public int hashCode() {

    int result = Objects.hash(minIngredientsPerSlice, maxSliceSize);
    result = 31 * result + Arrays.hashCode(field);
    return result;
  }

  @Override
  public String toString() {
    return "PizzaField{" +
        "minIngredientsPerSlice=" + minIngredientsPerSlice +
        ", maxSliceSize=" + maxSliceSize +
        ", field=" + Arrays.toString(field) +
        '}';
  }

  public boolean isValid(Slice slice) {
    return checkWithinBoundaries(slice)
        && checkIngredients(slice);
  }

  private boolean checkIngredients(Slice slice) {
    int tomatoes = 0;
    int mushrooms = 0;
    for (int row = slice.start.row; row <= slice.end.row; row++) {
      for (int col = slice.start.col; col <= slice.end.col; col++) {
        if (field[row][col] == 'X') {
          return false;
        }
        if (field[row][col] == 'T') {
          tomatoes++;
        }
        if (field[row][col] == 'M') {
          mushrooms++;
        }
      }
    }

    return tomatoes >= minIngredientsPerSlice
        && mushrooms >= minIngredientsPerSlice;
  }

  private boolean checkWithinBoundaries(Slice slice) {
    return slice.end.col >= 0
        && slice.end.col < cols
        && slice.end.row >= 0
        && slice.end.row < rows;
  }

  public void removeSlice(Slice slice) {
    for (int row = slice.start.row; row <= slice.end.row; row++) {
      for (int col = slice.start.col; col <= slice.end.col; col++) {
        field[row][col] = 'X';
      }
    }
  }
}
