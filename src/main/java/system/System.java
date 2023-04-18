package system;

import logarithms.Ln;
import logarithms.LogBaseN;
import trigonometry.Cos;
import trigonometry.Csc;
import trigonometry.Tan;

public class System {
    Csc csc;
    Tan tan;
    Cos cos;
    public System() {
        this.csc = new Csc();
        this.tan = new Tan();
        this.cos = new Cos();
    }

    public System(Csc csc, Tan tan, Cos cos) {
       this.csc = csc;
       this.tan = tan;
       this.cos = cos;
    }


    public Double calc(Double x, Double accuracy) throws IllegalArgumentException {
        if (x == null) {
            throw new IllegalArgumentException("x must not be null.");
        }
        if (accuracy == null || accuracy >= 1 || accuracy <= 0) {
            throw new IllegalArgumentException("accuracy must be bigger than 0 and less than 1.");
        }
        if (x > 0) {
            Double firstPar = LogBaseN.calc(x, 5d, accuracy) / Ln.calc(x, accuracy);
            Double secPar = Ln.calc(x, accuracy) - Ln.calc(x, accuracy);
            Double thirdPar = firstPar + secPar;
            Double fourthPar = thirdPar + LogBaseN.calc(x, 10d, accuracy);
            Double fifthPar = Math.pow(LogBaseN.calc(x, 2d, accuracy) + LogBaseN.calc(x, 10d, accuracy), 3);
            Double sixthPar = fourthPar + fifthPar;
            return sixthPar;
        } else {
            Double firstPar = Math.pow(csc.csc(Math.pow(x,3d),accuracy)* tan.tan(x,accuracy),3d);
            Double secPar = csc.csc(x,accuracy) * tan.tan(x,accuracy);
            Double thirdPar = firstPar - secPar;
            Double fourthPar = csc.csc(Math.pow(x,2d),accuracy)-cos.cos(Math.pow(x,2d),accuracy);
            return thirdPar* fourthPar;
        }
    }

}
