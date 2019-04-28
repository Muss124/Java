import java.util.List;

public class Polynomial {
    public final FractionSet poly;
    Polynomial(RationalFraction...rationalFractions){
        poly = new FractionSet(rationalFractions);
    }
    Polynomial(FractionSet set){
        poly = set;
    }

    public static Polynomial summirize(Polynomial first, Polynomial second){
        List<RationalFraction> firstSet = first.poly.getFractions();
        List<RationalFraction> secondSet = second.poly.getFractions();
        if (firstSet.size() > secondSet.size()) {
            for(int i = 0; i < secondSet.size(); i++){
                firstSet.add(i, RationalFraction.summirize(firstSet.get(i), secondSet.get(i)));
            }
            return new Polynomial(new FractionSet(firstSet));
        } else {
            for(int i = 0; i < firstSet.size(); i++){
                secondSet.add(i, RationalFraction.summirize(firstSet.get(i), secondSet.get(i)));
            }
            return new Polynomial(new FractionSet(secondSet));
        }
    }

    public void print(){
        poly.print();
    }
}
