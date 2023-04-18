package logarithms;


import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {

    private static final Double ACCURACY = 0.1D;

    @Test
    void shouldNotCalculateForZeroArg() {
        final Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calc(0d, ACCURACY));
    }

    @Test
    void shouldNotCalculateForZeroAcc() {
        final Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calc(1.023d, 0d));
    }

    @Test
    void shouldNotCalculateForOneAcc() {
        final Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calc(12.3d, 1d));
    }

    @Test
    void shouldNotCalculateForMoreThanOneAcc() {
        final Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calc(12.3d, 1.2d));
    }


    @Test
    void shouldNotCalculateForNegAcc() {
        final Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calc(2.3d, -0.3d));
    }

    @Test
    void shouldNotCalculateForNegArg() {
        final Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calc(-5.94d, 0.1d));
    }

    @Test
    void shouldNotCalculateForNegArgAndNegAcc() {
        final Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calc(-5.94d, -0.1d));
    }

    @Test
    void shouldCalculateForOne() {
        final Ln ln = new Ln();
        assertEquals(0d, ln.calc(1d, ACCURACY));
    }

    @Test
    void shouldCalculateForPositive() {
        final Ln ln = new Ln();
        final Double expected = 2d;
        assertTrue(Math.abs(expected - ln.calc(7.4, ACCURACY)) < ACCURACY);
    }
}