import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
    static Calculator calc;

    @BeforeAll
    static void createCalcInstance() {
        calc = new Calculator();
    }
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testPlus(Integer argument) {
        Assertions.assertEquals(calc.plus.apply(argument, argument),
                argument + argument);
    }
    @ParameterizedTest
    @ValueSource(ints = { -1, 2, 3 })
    void testMinus(Integer argument) {
        Assertions.assertEquals(calc.minus.apply(argument, argument),
                argument - argument);
    }
    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 1 })
    void testDivideByZero(int argument) {
        Assertions.assertThrowsExactly(
                ArithmeticException.class,
                () -> calc.devide.apply(argument, 0)
        );
    }

}
