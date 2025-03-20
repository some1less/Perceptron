import java.util.Arrays;
import java.util.Scanner;

public class PUI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Perceptron p = new Perceptron(5, 0.01);

        System.out.println("Enter 5 feature values separated by commas:");
        String input = sc.nextLine();
        String[] parts = input.split(",");
        double features[] = Arrays.stream(parts)
                .mapToDouble(Double::parseDouble)
                .toArray();

        int prediction = p.predict(features);
        System.out.println("Predicted class: " + (prediction == 0 ? "Iris-versicolor" : "Iris-virginica"));

    }

}
