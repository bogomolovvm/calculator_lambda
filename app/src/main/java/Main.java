public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        // Деление на 0
        int c = calc.devide.apply(a, b);
        // ArithmeticException
        calc.println.accept(c);
    }
}