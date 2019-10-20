import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
//doubles work in Java in a different way than ints
    // using breakpoints errors accumulate
    //in this program, it keeps adding decimals, therefore d is and will never be 1.0, so it can't print

    public static void main(String [] args) {
        BigDecimal a = new BigDecimal(0.0);
        BigDecimal b = new BigDecimal(1.0);
        BigDecimal c = new BigDecimal(0.1);

        while (a.compareTo(b) != 0) {
            BigDecimal sum = a.add(c);
            a = sum.setScale(2, RoundingMode.FLOOR);

        }

        System.out.println("a is 1");
    }
}