package  system;
import logarithms.Ln;
import logarithms.LogBaseN;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import trigonometry.Cos;
import trigonometry.Csc;
import trigonometry.Tan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SystemTest {

    private System system;

    @Mock
    private Csc csc;
    @Mock
    private Tan tan;
    @Mock
    private Cos cos;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        system = new System(csc, tan, cos);
    }

    @Test
    public void testCalcWithPositiveX() throws IOException {
        // Define input parameters
        Double x = 2.0;
        Double accuracy = 0.01;

        // Define expected result
        Double expectedResult = 0.0; // Replace with expected result

        // Define expected mock interactions
        String[] expectedMockInteractions = { "LogBaseN=calc=1", "Ln=calc=2", "Ln=calc=2", "LogBaseN=calc=1",
                "LogBaseN=calc=1", "LogBaseN=calc=1", "Ln=calc=1", "Csc=csc=1", "Tan=tan=1", "Csc=csc=1",
                "Tan=tan=1", "Csc=csc=1", "Cos=cos=1" };

        // Mock the necessary methods
        Mockito.when(csc.csc(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(1.0);
        Mockito.when(tan.tan(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(1.0);
        Mockito.when(cos.cos(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(1.0);
//        Mockito.when(LogBaseN.calc(Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(1.0);
//        Mockito.when(Ln.calc(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(2.0);

        // Call the method under test
        Double result = system.calc(x, accuracy);

        // Verify the mock interactions
//        Mockito.verify(csc).csc(Mockito.anyDouble(), Mockito.anyDouble());
//        Mockito.verify(tan).tan(Mockito.anyDouble(), Mockito.anyDouble());
//        Mockito.verify(cos).cos(Mockito.anyDouble(), Mockito.anyDouble());

        // Assert the result
//        assertEquals(expectedResult, result);

        // Write result of test to CSV
        writeResultToCsv("testCalcWithPositiveX", x, accuracy, expectedMockInteractions, expectedResult, result);
    }

    // Helper method to write test results to CSV
    private void writeResultToCsv(String testCaseName, Double x, Double accuracy, String[] expectedMockInteractions,
                                  Double expectedResult, Double actualResult) throws IOException {
        FileWriter writer = new FileWriter("test_results.csv", true);
        StringBuilder sb = new StringBuilder();
        sb.append(testCaseName).append(",");
        sb.append(x).append(",");
        sb.append(accuracy).append(",");
        sb.append(String.join(";", expectedMockInteractions)).append(",");
        sb.append(expectedResult).append(",");
        sb.append(actualResult).append("\n");
        writer.write(sb.toString());
        writer.close();
    }
}