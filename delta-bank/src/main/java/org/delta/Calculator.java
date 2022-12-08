package org.delta;

import java.util.Arrays;

public class Calculator {
    public double add(double... args) {
        return Arrays.stream(args).sum();
    }
    public double sub(double... args) {
        double result = args[0];
        for(int i = 1; i < args.length; i++) {
            result -= args[i];
        }
        return result;
    }
    public double mul(double... args) {
        double result = args[0];
        for(int i = 1; i < args.length; i++) {
            result *= args[i];
        }
        return result;
    }
    public double div(double... args) {
        double result = args[0];
        for(int i = 1; i < args.length; i++) {
            result /= args[i];
        }
        return result;
    }
    static double pow(double a) {
        return a * a;
    }
}
