package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Sort with Select sort.
 *
 * @author Mr. Riscalas
 * @version 1.0
 * @since 2023-05-15
 */
public final class SelectSort {
  /**
   * This is a private constructor used to satisfy the style checker.
   *
   * @exception IllegalStateException Utility class.
   * @see IllegalStateException
   */
  private SelectSort() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * This is the selectSort method.
   *
   * @param array // the numbers
   * @return nums
   */
  public static int[] selectSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // declaration of the index of the minimum number
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        // set the minimum index to be equal to the true minimum number ghjkghjkghjkgkj
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      // swap the variables in the array
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
    return array;
  }

  /**
   * This is the main method.
   *
   * @param args //unused
   */
  public static void main(final String[] args) {
    // Set the input and output file paths
    final String inputFilePath = "input.txt";
    final String outputFilePath = "output.txt";
    // Read input from file using Scanner
    try (Scanner inputFile = new Scanner(new File(inputFilePath));
        FileWriter writer = new FileWriter(outputFilePath)) {
      // sort each line using the select sort method
      while (inputFile.hasNextLine()) {
        // strip the string and convert to int
        final String numberStr = inputFile.nextLine().strip();
        // check if empty
        if (numberStr.equals("")) {
          writer.write("Invalid Input: Empty value\n");
          continue;
        }
        // split the values by spaces
        final String[] numbersSplit = numberStr.split(" ");
        // create the numbers integer array
        final int[] numbers = new int[numbersSplit.length];
        for (int i = 0; i < numbers.length; i++) {
          try {
            numbers[i] = Integer.parseInt(numbersSplit[i]);
          } catch (NumberFormatException error) {
            writer.write("Incorrect input: " + error.getMessage() + "\n");
          }
        }
        // sort the numbers then display
        final int[] sortedNums = selectSort(numbers);
        writer.write("Your array sorted is" + Arrays.toString(sortedNums) + "\n");
      }
    } catch (FileNotFoundException error) {
      System.err.println("File not found: " + error.getMessage());
    } catch (IOException error) {
      System.err.println("Error writing to file: " + error.getMessage());
    }
  }
}
