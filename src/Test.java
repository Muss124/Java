import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        RationalFraction fraction1 = new RationalFraction(15, 16);
        RationalFraction fraction2 = new RationalFraction(10, 16);
        if (RationalFraction.isGreater(fraction1, fraction2)) {System.out.println("Yes");} else {
            System.out.println("No");
        }
        fraction1.print();

        FractionSet myFractionSet = new FractionSet(fraction1, fraction2);
        myFractionSet.print();

        RationalFraction fraction3 = new RationalFraction(1, 2);
        RationalFraction fraction4 = new RationalFraction(3, 4);
        RationalFraction fraction5 = new RationalFraction(6, 5);
        RationalFraction fraction6 = new RationalFraction(8, 7);

        FractionSet second = new FractionSet(fraction1, fraction2, fraction3, fraction4, fraction5, fraction6);
        Polynomial one = new Polynomial(myFractionSet);
        Polynomial two = new Polynomial(second);
//        Polynomial result = Polynomial.summirize(one, two);
//        result.print();
        System.out.println();
        System.out.println();
        List<RationalFraction> fractions = Arrays.asList(fraction1, fraction2, fraction3, fraction4, fraction5, fraction6);
        fractions.add(5, fraction6);
        for(RationalFraction fraction : fractions){
            fraction.print();
        }
    }
}
