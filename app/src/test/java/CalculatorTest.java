import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CalculatorTest {
    static Calculator calc;

    @BeforeAll
    static void createCalcInstance() {
        calc = new Calculator();
    }
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testPlus(Integer argument) {
        int answer = calc.plus.apply(argument, argument);
        assertThat(answer, equalTo(argument + argument));
    }
    @ParameterizedTest
    @ValueSource(ints = { -1, 2, 3 })
    void testMinus(Integer argument) {
        int answer = calc.minus.apply(argument, argument);
        assertThat(answer, is(0));
    }
    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 1 })
    void testDivideByZero(int argument) {
        Assertions.assertThrowsExactly(
                ArithmeticException.class,
                () -> calc.devide.apply(argument, 0)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = { -10, 0 })
    void testIsPositiveFalse(int argument) {
        boolean result = calc.isPositive.test(argument);

        assertThat(result, is(not(true)));
    }


}
