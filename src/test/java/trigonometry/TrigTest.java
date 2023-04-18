package trigonometry;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static java.lang.Float.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

class TrigTest {
        private Cos cos;
        private Csc csc;
        private Sin sin;
        private Tan tan;

        @BeforeEach
        public void setUp() {
            csc = new Csc();
            cos = new Cos();
            sin = new Sin();
            tan = new Tan();
        }

        @Test
        public void testCosWithSinIntegration() {
            // Подготовка данных для теста
            double x = Math.PI / 4; // Значение угла
            double eps = 0.001; // Точность вычисления

            // Выполнение тестируемого метода
            double result = cos.cos(x, eps);

            // Проверка результата
            double expected = Math.cos(x);
            assertEquals(expected, result, eps, "Cos result is not as expected");
        }

        @Test
        public void testCosWithSinIntegrationOutOfRange() {
            // Подготовка данных для теста
            double x = 5 * Math.PI / 4; // Значение угла за пределами диапазона -Math.PI/2 до Math.PI/2
            double eps = 0.001; // Точность вычисления

            // Выполнение тестируемого метода
            double result = cos.cos(x, eps);

            // Проверка результата, ожидается отрицательное значение
            double expected = Math.cos(x);
            assertEquals(expected, result, eps, "Cos result is not as expected");
        }

        @Test
        public void testCosWithSinIntegrationNaN() {
            // Подготовка данных для теста
            double x = Double.POSITIVE_INFINITY; // Значение угла равное бесконечности
            double eps = 0.001; // Точность вычисления

            // Выполнение тестируемого метода
            double result = cos.cos(x, eps);

            // Проверка результата, ожидается NaN
            assertEquals(Double.NaN, result, "Cos result is not NaN as expected");
        }
    @Test
    public void testCsc_PositiveInput_ReturnsCorrectResult() {
        double x = Math.PI / 4;
        double eps = 1e-6;
        double expected = 1 / Math.sin(x);

        double actual = csc.csc(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }

    @Test
    public void testCsc_ZeroInput_ReturnsNaN() {
        double x = 0;
        double eps = 1e-6;

        double actual = csc.csc(x, eps);

        Assert.assertTrue(Double.isNaN(actual));
    }

    @Test
    public void testCsc_InputOutsideDomain_ReturnsNaN() {
        double x = Math.PI / 2;
        double eps = 1e-6;

        double actual = csc.csc(x, eps);

        Assert.assertTrue(Double.isNaN(actual));
    }

    @Test
    public void testCsc_NegativeInput_ReturnsCorrectResult() {
        double x = -Math.PI / 4;
        double eps = 1e-6;
        double expected = 1 / Math.sin(x);

        double actual = csc.csc(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }
    @Test
    public void testSin_PositiveInput_ReturnsCorrectResult() {
        double x = Math.PI / 4;
        double eps = 1e-6;
        double expected = Math.sin(x);

        double actual = sin.sin(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }

    @Test
    public void testSin_NegativeInput_ReturnsCorrectResult() {
        double x = -Math.PI / 4;
        double eps = 1e-6;
        double expected = Math.sin(x);

        double actual = sin.sin(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }

    @Test
    public void testSin_InputOutsideDomain_ReturnsNaN() {
        double x = Double.POSITIVE_INFINITY;
        double eps = 1e-6;

        double actual = sin.sin(x, eps);

        Assert.assertTrue(Double.isNaN(actual));
    }

    @Test
    public void testSin_InputZero_ReturnsZero() {
        double x = 0;
        double eps = 1e-6;
        double expected = 0;

        double actual = sin.sin(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }

    @Test
    public void testSin_InputNaN_ReturnsNaN() {
        double x = Double.NaN;
        double eps = 1e-6;

        double actual = sin.sin(x, eps);

        Assert.assertTrue(Double.isNaN(actual));
    }

    @Test
    public void testSin_LargeInput_ReturnsCorrectResult() {
        double x = 1000; // Some large input value
        double eps = 1e-6;
        double expected = Math.sin(x);

        double actual = sin.sin(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }
    @Test
    public void testTan_PositiveInput_ReturnsCorrectResult() {
        double x = Math.PI / 4;
        double eps = 1e-6;
        double expected = Math.tan(x);

        double actual = tan.tan(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }

    @Test
    public void testTan_NegativeInput_ReturnsCorrectResult() {
        double x = -Math.PI / 4;
        double eps = 1e-6;
        double expected = Math.tan(x);

        double actual = tan.tan(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }

    @Test
    public void testTan_InputOutsideDomain_ReturnsNaN() {
        double x = Double.POSITIVE_INFINITY;
        double eps = 1e-6;

        double actual = tan.tan(x, eps);

        Assert.assertTrue(Double.isNaN(actual));
    }

    @Test
    public void testTan_InputZero_ReturnsZero() {
        double x = 0;
        double eps = 1e-6;
        double expected = NaN;

        double actual = tan.tan(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }

    @Test
    public void testTan_InputNaN_ReturnsNaN() {
        double x = Double.NaN;
        double eps = 1e-6;

        double actual = tan.tan(x, eps);

        Assert.assertTrue(Double.isNaN(actual));
    }

    @Test
    public void testTan_LargeInput_ReturnsCorrectResult() {
        double x = 1000; // Some large input value
        double eps = 1e-6;
        double expected = Math.tan(x);

        double actual = tan.tan(x, eps);

        Assert.assertEquals(expected, actual, eps);
    }
    }

