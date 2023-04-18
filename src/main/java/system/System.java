package system;

import logarithms.Ln;
import logarithms.LogBaseN;
import trigonometry.Cos;
import trigonometry.Csc;
import trigonometry.Tan;

public class System {
    private Csc csc;
    private Tan tan;
    private Cos cos;
    private LogBaseN logBaseN;
    private Ln ln;

    public System(LogBaseN logBaseN, Ln ln, Csc csc, Tan tan, Cos cos){
        this.ln = ln;
        this.logBaseN = logBaseN;
        this.csc = csc;
        this.cos = cos;
        this.tan = tan;
    }

    public Double calc(Double x, Double accuracy) throws IllegalArgumentException{
        if (x == null){
            throw new IllegalArgumentException("x must not be null.");
        }
        if (accuracy == null || accuracy >= 1 || accuracy <= 0) {
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
            Double firstPar = Math.pow(csc.csc(Math.pow(x,3d),accuracy)* tan.tan(x,accuracy),3d);
            Double secPar = csc.csc(x,accuracy) * tan.tan(x,accuracy);
            Double thirdPar = firstPar - secPar;
            Double fourthPar = csc.csc(Math.pow(x,2d),accuracy)-cos.cos(Math.pow(x,2d),accuracy);
            return thirdPar * fourthPar;
        }
    }

}
