package system;

import logarithms.Ln;
import logarithms.LogBaseN;

public class System {

    public Double calc(Double x, Double accuracy) throws IllegalArgumentException{
        if (x == null){
            throw new IllegalArgumentException("x must not be null.");
        }
        if (accuracy == null || accuracy >= 1 || accuracy <= 0){
            throw new IllegalArgumentException("accuracy must be bigger than 0 and less than 1.");
        }
        if (x > 0) {
            Double firstPar = LogBaseN.calc(x,5d, accuracy) / Ln.calc(x, accuracy);
            Double secPar = Ln.calc(x, accuracy) - Ln.calc(x, accuracy);
            Double thirdPar = firstPar + secPar;
            Double fourthPar =  thirdPar + LogBaseN.calc(x, 10d, accuracy);
            Double fifthPar = Math.pow(LogBaseN.calc(x, 2d, accuracy) + LogBaseN.calc(x, 10d, accuracy), 3);
            Double sixthPar = fourthPar + fifthPar;
            return sixthPar;
        } else {
            //TODO for Artyom Brudar
            return 0d;
        }
    }

}
