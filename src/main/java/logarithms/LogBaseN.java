package logarithms;

public class LogBaseN {

    public static Double calc(Double x, Double n, Double accuracy) throws IllegalArgumentException{
        if (x == null || x <= 0){
            throw new IllegalArgumentException("Logarithm argument must be bigger than 0.");
        }
        if (n == null || n <= 0 || n == 1){
            throw new IllegalArgumentException("Logarithm base must be bigger than 0 and must not be equal to 1.");
        }
        if (accuracy == null || accuracy >= 1 || accuracy <= 0){
            throw new IllegalArgumentException("Logarithm accuracy must be bigger than 0 and less than 1.");
        }
        return Ln.calc(x, accuracy) / Ln.calc(n, accuracy);
    }

}
