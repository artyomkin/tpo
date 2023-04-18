package logarithms;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;

public class LogBaseNTest {

    private final Double ACC = 0.01;

    @Test
    public void positiveBigArg(){
        Ln mockLn = Mockito.mock(Ln.class);
        Double arg = 44d;
        Double base = 10d;

        Mockito.when(mockLn.calc(Mockito.eq(arg), Mockito.any(Double.class)))
                .thenReturn(3.7842);
        Mockito.when(mockLn.calc(Mockito.eq(base), Mockito.any(Double.class)))
                .thenReturn(2.3026);

        LogBaseN logBaseN = new LogBaseN(mockLn);
        Double expected = 1.64;
        assertTrue(Math.abs(expected - logBaseN.calc(arg, base, ACC)) < ACC);

    }

    @Test
    public void positiveLittleArg(){
        Ln mockLn = Mockito.mock(Ln.class);
        Double arg = 0.15;
        Double base = 5d;

        Mockito.when(mockLn.calc(Mockito.eq(arg), Mockito.any(Double.class)))
                .thenReturn(-1.8971);
        Mockito.when(mockLn.calc(Mockito.eq(base), Mockito.any(Double.class)))
                .thenReturn(1.6094);

        LogBaseN logBaseN = new LogBaseN(mockLn);
        Double expected = -1.18;
        assertTrue(Math.abs(expected - logBaseN.calc(arg, base, ACC)) < ACC);

    }


    @Test
    public void positiveBigBase(){
        Ln mockLn = Mockito.mock(Ln.class);
        Double arg = 14d;
        Double base = 56d;

        Mockito.when(mockLn.calc(Mockito.eq(arg), Mockito.any(Double.class)))
                .thenReturn(2.6390);
        Mockito.when(mockLn.calc(Mockito.eq(base), Mockito.any(Double.class)))
                .thenReturn(4.0253);

        LogBaseN logBaseN = new LogBaseN(mockLn);
        Double expected = 0.65;
        assertTrue(Math.abs(expected - logBaseN.calc(arg, base, ACC)) < ACC);

    }


    @Test
    public void positiveLittleBase(){
        Ln mockLn = Mockito.mock(Ln.class);
        Double arg = 10d;
        Double base = 0.26d;

        Mockito.when(mockLn.calc(Mockito.eq(arg), Mockito.any(Double.class)))
                .thenReturn(2.3026);
        Mockito.when(mockLn.calc(Mockito.eq(base), Mockito.any(Double.class)))
                .thenReturn(-1.3471);

        LogBaseN logBaseN = new LogBaseN(mockLn);
        Double expected = -1.71;
        assertTrue(Math.abs(expected - logBaseN.calc(arg, base, ACC)) < ACC);

    }
    @Test
    public void zeroAccException(){
        LogBaseN logBaseN = new LogBaseN(new Ln());
        assertThrows(IllegalArgumentException.class, () -> logBaseN.calc(10d, 10d, 0d));
    }
    @Test
    public void negAccException(){
        LogBaseN logBaseN = new LogBaseN(new Ln());
        assertThrows(IllegalArgumentException.class, () -> logBaseN.calc(10d, 10d, -0.2d));
    }
    @Test
    public void moreThanOneAccException(){
        LogBaseN logBaseN = new LogBaseN(new Ln());
        assertThrows(IllegalArgumentException.class, () -> logBaseN.calc(10d, 10d, 1.03d));
    }

    @Test
    public void zeroArgException(){
        LogBaseN logBaseN = new LogBaseN(new Ln());
        assertThrows(IllegalArgumentException.class, () -> logBaseN.calc(0d, 10d, ACC));
    }

    @Test
    public void zeroBaseException(){
        LogBaseN logBaseN = new LogBaseN(new Ln());
        assertThrows(IllegalArgumentException.class, () -> logBaseN.calc(2d, 0d, ACC));
    }

    @Test
    public void negativeArgException(){
        LogBaseN logBaseN = new LogBaseN(new Ln());
        assertThrows(IllegalArgumentException.class, () -> logBaseN.calc(-5.42d, 2d, ACC));
    }


    @Test
    public void negativeBaseException(){
        LogBaseN logBaseN = new LogBaseN(new Ln());
        assertThrows(IllegalArgumentException.class, () -> logBaseN.calc(12.24d, -12d, ACC));
    }

}
