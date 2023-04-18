package system;

import logarithms.Ln;
import logarithms.LogBaseN;

public class System {

    private LogBaseN logBaseN;
    private Ln ln;

    public System(LogBaseN logBaseN, Ln ln){
        this.ln = ln;
        this.logBaseN = logBaseN;
    }

    public Double calc(Double x, Double accuracy) throws IllegalArgumentException{
        if (x == null){
            throw new IllegalArgumentException("x must not be null.");
        }
        if (accuracy == null || accuracy >= 1 || accuracy <= 0){
            throw new IllegalArgumentException("accuracy must be bigger than 0 and less than 1.");
        }
        if (x > 0) {
            Double firstPar = this.logBaseN.calc(x,5d, accuracy) / this.ln.calc(x, accuracy);
            Double secPar = this.ln.calc(x, accuracy) - this.ln.calc(x, accuracy);
            Double thirdPar = firstPar + secPar;
            Double fourthPar =  thirdPar + this.logBaseN.calc(x, 10d, accuracy);
            Double fifthPar = Math.pow(this.logBaseN.calc(x, 2d, accuracy) + this.logBaseN.calc(x, 10d, accuracy), 3);
            Double sixthPar = fourthPar + fifthPar;
            return sixthPar;
        } else {
            //TODO for Artyom Brudar
            return 0d;
        }
    }

}
