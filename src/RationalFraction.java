public class RationalFraction {
    private final double m;
    private final double n;
    RationalFraction(double m, double n){
        this.m = m;
        this.n = n;
    }

    public void print(){
        System.out.println(this.m + "/" + this.n);
    }
    public static boolean isGreater(RationalFraction first, RationalFraction second){
        double result = (second.n * first.m - first.n * second.m) / (first.n * second.n);
        if (result > 0) {return true;} else {return false;}
    }
    public static RationalFraction summirize(RationalFraction first, RationalFraction second){
        RationalFraction result = new RationalFraction(first.m*second.n + second.m*first.n, first.n*second.n);
        return result;
    }
}
