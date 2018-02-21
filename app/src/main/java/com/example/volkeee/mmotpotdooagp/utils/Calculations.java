package com.example.volkeee.mmotpotdooagp.utils;

/**
 * Created by volkeee on 2/21/18.
 */

public class Calculations {
    public static Double calculateLinearEquation(Double a, Double b, Double e, IFunction function) {
        Double c = (a + b) / 2;
        while (Math.abs(b - a) > e && function.calculate(c) != 0) {
            Double functionA = function.calculate(a);
            Double functionB = function.calculate(b);
            Double functionC = function.calculate(c);

            if (functionA * functionC < 0)
                b = c;
            else a = c;
            c = (a + b) / 2;
        }
        return c;
    }

    public interface IFunction {
        Double calculate(Double parameter);
    }
}
