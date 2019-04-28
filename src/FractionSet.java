import java.util.*;

public class FractionSet {
    private List<RationalFraction> fractions;
    private Map<RationalFraction, Integer> cachedGreater;
    private Map<RationalFraction, Integer> cachedLesser;
    private RationalFraction cachedMaximal;
    private RationalFraction cachedMininal;

    FractionSet(RationalFraction...rationalFractions){
        fractions = Arrays.asList(rationalFractions);
        cachedGreater = new HashMap<RationalFraction, Integer>();
        cachedLesser = new HashMap<RationalFraction, Integer>();
        cachedMaximal = null;
        cachedMininal = null;
    }
    FractionSet(List<RationalFraction> target){
        fractions = target;
        cachedGreater = new HashMap<RationalFraction, Integer>();
        cachedLesser = new HashMap<RationalFraction, Integer>();
        cachedMaximal = null;
        cachedMininal = null;
    }
    public void add(RationalFraction target){
        fractions.add(target);
        cachedMaximal = null;
        cachedMininal = null;
    }
    public void print(){
        fractions.forEach(fraction -> fraction.print());
    }
    public RationalFraction getCachedMaximal(){
        return cachedMaximal;
    }
    public RationalFraction getCachedMininal(){
        return cachedMininal;
    }
    public int getCachedGreater(RationalFraction target){
        if (cachedGreater.get(target) == null) {return -1;} else {return cachedGreater.get(target);}
    }
    public int getCachedLesser(RationalFraction target){
        if (cachedLesser.get(target) == null) {return -1;} else {return cachedLesser.get(target);}
    }
    public List<RationalFraction> getFractions(){
        return fractions;
    }
    public void setFractions(List<RationalFraction> target){
        fractions = target;
    }


    public RationalFraction maximal(){
        RationalFraction res = null;
        for (RationalFraction fraction: fractions){
            if (res == null) {res = fraction;}
            if (RationalFraction.isGreater(fraction, res)) { res = fraction;}
        }
        cachedMaximal = res;
        return res;
    }
    public RationalFraction minimal(){
        RationalFraction res = null;
        for (RationalFraction fraction: fractions){
            if (res == null) {res = fraction;}
            if (RationalFraction.isGreater(res, fraction)) { res = fraction;}
        }

        cachedMininal = res;
        return res;
    }
    public int greater(RationalFraction target){
        int res = 0;
        for (RationalFraction fraction: fractions){
            if (RationalFraction.isGreater(target, fraction)) { res++;}
        }
        cachedGreater.put(target, res);
        return res;
    }
    public int lesser(RationalFraction target){
        int res = 0;
        for (RationalFraction fraction: fractions){
            if (RationalFraction.isGreater(fraction, target)) { res++;}
        }
        cachedLesser.put(target, res);
        return res;
    }
}
