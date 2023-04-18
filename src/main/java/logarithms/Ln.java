package logarithms;

public class Ln {

    public double calc(double x, double eps) {
        if (Double.isNaN(x) || x <= (double) 0) {
            throw new IllegalArgumentException("X must not be 0 or 1 or NaN.");
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (Double.isNaN(eps) || eps <= 0.0 || eps >= 1) {
            throw new IllegalArgumentException("Accuracy must be more than 0 and less than 1.");
        }

        double constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));

        double sum = 0;
        double currentValue = (x - 1) / (x + 1);
        int step = 1;
        while (Math.abs(currentValue) > eps / 2) {
            sum += currentValue;
            currentValue = (2 * step - 1) * currentValue * constant / (2 * step + 1);
            step++;
        }
        sum *= 2;
        return sum;
    }


}
