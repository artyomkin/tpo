package logarithms;

public class Ln {

    private static Double INF = -1d;
    private static Integer MAXITERATIONS = 100000;

    public static Double calc(Double num, Double accuracy) throws IllegalArgumentException{
        if (num == null || num <= 0){
            throw new IllegalArgumentException("Logarithm argument must be bigger than 0.");
        }
        if (accuracy == null || accuracy >= 1 || accuracy <= 0){
            throw new IllegalArgumentException("Logarithm accuracy must be bigger than 0 and less than 1.");
        }
        Double x = num - 1;
        Double n = 0d;
        Double prevSum = INF;
        Double sum = 0d;
        while (Math.abs(sum - prevSum) > accuracy && n < MAXITERATIONS){

            Double numerator = Math.pow(-1, n) * Math.pow(x, n+1);
            Double denominator = n + 1;
            sum += numerator / denominator;
            n++;

        }
        if (n > MAXITERATIONS && Math.abs(sum - prevSum) > accuracy){
            throw new IllegalArgumentException("Desired accuracy " + accuracy + " is unreachable.");
        }
        return sum;
    }

}
