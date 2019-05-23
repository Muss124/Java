package Fractions;
import java.util.*;


public class FractionSet {
    private List<RationalFraction> fractions = new ArrayList<RationalFraction>();
    private Map<RationalFraction, Long> cachedGreater;
    private Map<RationalFraction, Long> cachedLesser;
    private RationalFraction cachedMaximal;
    private RationalFraction cachedMinimal;

    FractionSet(RationalFraction... rationalFractions) {
        fractions.addAll(Arrays.asList(rationalFractions));
        cachedGreater = new HashMap<RationalFraction, Long>();
        cachedLesser = new HashMap<RationalFraction, Long>();
        cachedMaximal = null;
        cachedMinimal = null;
    }

    FractionSet(List<RationalFraction> target) {
        fractions = target;
        cachedGreater = new HashMap<RationalFraction, Long>();
        cachedLesser = new HashMap<RationalFraction, Long>();
        cachedMaximal = null;
        cachedMinimal = null;
    }

    public void add(RationalFraction target) {
        fractions.add(target);
        cachedGreater = new HashMap<RationalFraction, Long>();
        cachedLesser = new HashMap<RationalFraction, Long>();
        cachedMaximal = null;
        cachedMinimal = null;
    }

    public RationalFraction getFraction(int fractionId) throws Throwable{
        if (fractionId >= fractions.size()){
            throw new RuntimeException("Fraction with such id doesn't exist");
        }
        return fractions.get(fractionId);
    }

    public int getSize(){
        return fractions.size();
    }

    public void print() {
        fractions.forEach(fraction -> fraction.print());
    }

    public RationalFraction maximal() {
        RationalFraction res = null;
        if (cachedMaximal == null){
            res = fractions.stream()
                    .max(RationalFraction::compareTo)
                    .get();
            cachedMaximal = res;
        } else {
            res = cachedMaximal;
        }
        return res;
    }

    public RationalFraction minimal() {
        RationalFraction res = null;
        if (cachedMinimal == null){
            res = fractions.stream()
                    .min(RationalFraction::compareTo)
                    .get();
            cachedMinimal = res;
        } else {
            res = cachedMinimal;
        }
        return res;
    }

    public long greater(RationalFraction target) {
        long res = 0;
        if (cachedGreater.get(target) == null){
            res = fractions.stream()
                    .filter(w -> w.compareTo(target) == 1)
                    .count();
            cachedGreater.put(target, res);
        } else {
            res = cachedGreater.get(target);
        }
        return res;
    }

    public long lesser(RationalFraction target) {
        long res = 0;
        if (cachedLesser.get(target) == null){
            res = fractions.stream()
                    .filter(w -> w.compareTo(target) == -1)
                    .count();
            cachedLesser.put(target, res);
        } else {
            res = cachedLesser.get(target);
        }
        return res;
    }
}
