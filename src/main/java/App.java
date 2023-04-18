import logarithms.Ln;
import logarithms.LogBaseN;
import trigonometry.Cos;
import trigonometry.Csc;
import trigonometry.Sin;
import trigonometry.Tan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String... args) throws IOException {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        Double step = reader.nextDouble();
        Double accuracy = reader.nextDouble();
        reader.close();

        CsvWriter csvWriter = new CsvWriter();

        List<Double> xs = new ArrayList<>();
        for (Double i = 1d; i < 2d; i += step){
            xs.add(i);
        }

        Ln ln = new Ln();
        LogBaseN logBaseN = new LogBaseN(ln);

        List<Double> rln = new ArrayList<>();
        List<Double> rlogn = new ArrayList<>();
        for (int i = 0; i < xs.size(); i++){
            rln.add(ln.calc(xs.get(i), accuracy));
            rlogn.add(logBaseN.calc(xs.get(i), 10d, accuracy));
        }
        csvWriter.writeResultToCsv("csv/ln.csv", xs, rln);
        csvWriter.writeResultToCsv("csv/logBaseN.csv", xs, rlogn);


        xs = new ArrayList<>();
        for (Double i = -1d; i < 1d; i += step){
            xs.add(i);
        }

        Cos cos = new Cos();
        Sin sin = new Sin();
        Tan tan = new Tan();
        Csc csc = new Csc();
        List<Double> rcos = new ArrayList<>();
        List<Double> rsin = new ArrayList<>();
        List<Double> rtan = new ArrayList<>();
        List<Double> rcsc = new ArrayList<>();
        for (int i = 0; i < xs.size(); i++){
            rcos.add(cos.cos(xs.get(i), accuracy));
            rsin.add(sin.sin(xs.get(i), accuracy));
            rtan.add(tan.tan(xs.get(i), accuracy));
            rcsc.add(csc.csc(xs.get(i), accuracy));
        }
        csvWriter.writeResultToCsv("csv/cos.csv", xs, rcos);
        csvWriter.writeResultToCsv("csv/sin.csv", xs, rsin);
        csvWriter.writeResultToCsv("csv/tan.csv", xs, rtan);
        csvWriter.writeResultToCsv("csv/csc.csv", xs, rcsc);
    }
}
