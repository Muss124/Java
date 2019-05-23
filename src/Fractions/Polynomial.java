package Fractions;
import java.util.List;


public class Polynomial {
    public final FractionSet coefficients;
    Polynomial(RationalFraction...rationalFractions){
        coefficients = new FractionSet(rationalFractions);
    }
    Polynomial(FractionSet set){
        coefficients = set;
    }

    public Polynomial summarize(Polynomial target) throws Throwable{
        int sizeFirst = this.coefficients.getSize();
        int sizeSecond = target.coefficients.getSize();
        FractionSet res = new FractionSet();
        if (sizeFirst > sizeSecond) {
            for (int i = 0; i < sizeSecond; i++){
                res.add(this.coefficients.getFraction(i).summarize(target.coefficients.getFraction(i)));
            }
            for (int i = sizeSecond; i < sizeFirst; i++){
                res.add(this.coefficients.getFraction(i));
            }
        } else {
            for (int i = 0; i < sizeFirst; i++){
                res.add(this.coefficients.getFraction(i).summarize(target.coefficients.getFraction(i)));
            }
            for (int i = sizeFirst; i < sizeSecond; i++){
                res.add(target.coefficients.getFraction(i));
            }
        }
        return new Polynomial(res);
    }

    public void print(){
        coefficients.print();
    }
}
