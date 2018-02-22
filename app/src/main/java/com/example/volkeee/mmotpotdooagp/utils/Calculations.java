package com.example.volkeee.mmotpotdooagp.utils;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

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

    public static LineGraphSeries<DataPoint> calculateCoordinatesForGraph(Double startOfRange, Double endOfRange, Double step, IFunction function) {
        ArrayList<DataPoint> dataPoints = new ArrayList<>();
        for (Double iterator = startOfRange; iterator <= endOfRange; iterator += step) {
            Double y = function.calculate(iterator);
            if (!Double.isNaN(y) && !Double.isInfinite(y)) {
                DataPoint dataPoint = new DataPoint(iterator, y);
                dataPoints.add(dataPoint);
            }
        }
        return new LineGraphSeries<>(dataPoints.toArray(new DataPoint[dataPoints.size()]));
    }

    public interface IFunction {
        Double calculate(Double parameter);
    }
}
