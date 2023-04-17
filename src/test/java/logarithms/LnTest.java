package logarithms;


import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {

    private static final Double ACCURACY = 0.1D;

    @Test
    void shouldNotCalculateForZero() {
        final Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calc(0d, ACCURACY));
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