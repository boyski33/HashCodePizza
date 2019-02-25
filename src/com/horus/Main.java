package com.horus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static final String PATH_TO_INPUT = "C:/work/HashCodePizza/src/c_medium.in";
  private static final Pizza pizza = new MediumPizza();

  public static void main(String[] args) throws IOException {

    run();

  }

  private static int run() throws IOException {
    PizzaField field = readInput();
    List<Slice> slices = new ArrayList<>();
    int points = 0;

    for (int i = 0; i < 300_000_000; i++) {

      Point point = field.pickRandomPoint();
      Slice slice = pizza.chooseRandomSlice(point);
      //      System.out.println(slice);
      if (field.isValid(slice)) {
        slices.add(slice);
        field.removeSlice(slice);
        points += slice.size();
//        System.out.println("Found a valid slice: " + slice);
      }
    }

    System.out.println(slices);
    System.out.println("score = " + points);

    return points;
  }

  private static PizzaField readInput() throws IOException {
    Path path = Paths.get(PATH_TO_INPUT);
    final File file = new File(path.toUri());
    return PizzaField.initFromFile(file);
  }
}
