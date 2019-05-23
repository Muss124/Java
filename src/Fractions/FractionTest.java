package Fractions;

import java.util.stream.*;

/*
для дробей:
изменить название сета с поли на коэффициенты ✓
заменить функцию isGreater на перегрузку оператора ✓
так же перегрузить оператор для сложения или сделать не статический метод sum ✓
(?) возможно, имелось в виду написать просто метод equals возвращающий -1\0\1 ✓
сделать нормальное кеширование, т.е. пользователь не видет, что оно там вообще есть (добавить в метод проверку
убрать сетер\гетер для коэфов, добавить получение по индексу ✓
сделать поиск количества больше\меньше через stream api
 */
public class FractionTest {
    public static void main(String[] args) throws Throwable {
        RationalFraction fraction1 = new RationalFraction(15, 16);
        RationalFraction fraction2 = new RationalFraction(10, 16);
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
        Polynomial result = one.summarize(two);
        result.print();

        System.out.println(fraction2.compareTo(fraction1));
        long test = Stream.of(fraction1, fraction2, fraction3, fraction4, fraction5, fraction6)
                .filter(w -> w.compareTo(fraction1) == 1)
                .count();
        RationalFraction res = Stream.of(fraction1, fraction2, fraction3, fraction4, fraction5, fraction6).max(RationalFraction::compareTo).get();
        res.print();
    }
}
