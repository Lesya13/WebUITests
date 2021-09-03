package org.example.lesson04.homeWork;

public class Triangle {

    public double squareOfTriangle() {
        int a = 5;
        int b = 4;
        int c = 3;
        int p = (a + b + c) / 2;

        double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return square;
    }
}
