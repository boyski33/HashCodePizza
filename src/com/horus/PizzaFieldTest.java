package com.horus;

import static java.nio.file.Files.createTempFile;
import static java.nio.file.Files.write;
import static java.util.Arrays.asList;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class PizzaFieldTest {

  @Test
  public void validate_valid_slice() {

    char[][] pizzaArray = new char[][] {
        {'T', 'T', 'T', 'T', 'T'},
        {'T', 'M', 'M', 'M', 'T'},
        {'T', 'T', 'T', 'T', 'T'}
    };

    PizzaField validField = new PizzaField(1, 6, pizzaArray);

    Slice slice = new Slice(
        new Point(0, 0),
        new Point(2, 1)
    );

    Slice slice2 = new Slice(
        new Point(2, 0),
        new Point(2, 2)
    );

    Slice slice3 = new Slice(
        new Point(3, 0),
        new Point(4, 2)
    );

    Slice slice4 = new Slice(
        new Point(0, 1),
        new Point(4, 1)
    );

    Slice slice5 = new Slice(
        new Point(3, 1),
        new Point(3, 2)
    );

    Assert.assertTrue(validField.isValid(slice));
    Assert.assertTrue(validField.isValid(slice2));
    Assert.assertTrue(validField.isValid(slice3));
    Assert.assertTrue(validField.isValid(slice4));
    Assert.assertTrue(validField.isValid(slice5));

  }

  @Test
  public void valid_file_input_creates_pizza_field() throws IOException {
    Path tmpPath = createTempFile("small", ".in");

    String[] lines = {
        "3 5 1 6",
        "TTTTT",
        "TMMMT",
        "TTTTT"
    };

    write(tmpPath, asList(lines));

    PizzaField actual = PizzaField.initFromFile(new File(tmpPath.toUri()));

    char[][] pizzaArray = new char[][] {
        {'T', 'T', 'T', 'T', 'T'},
        {'T', 'M', 'M', 'M', 'T'},
        {'T', 'T', 'T', 'T', 'T'}
    };

    PizzaField expected = new PizzaField(1, 6, pizzaArray);

    Assert.assertEquals(actual, expected);
  }

}