import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    public void writeResultToCsv(String filename,
                                  List<Double> xs,
                                  List<Double> results
    )
            throws IOException {
        FileWriter writer = new FileWriter(filename, true);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < xs.size(); i++){
            sb.append(xs.get(i)).append(",");
            sb.append(results.get(i)).append("\n");
        }
        writer.write(sb.toString());
        writer.close();
    }
}
