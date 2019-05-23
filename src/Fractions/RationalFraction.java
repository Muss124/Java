package Fractions;

public class RationalFraction implements Comparable <RationalFraction>{
    private final double m;
    private final double n;
    RationalFraction(double m, double n){
        this.m = m;
        this.n = n;
    }

    public void print(){
        System.out.println(this.m + "/" + this.n);
    }
    public RationalFraction summarize(RationalFraction target){
        RationalFraction result = new RationalFraction(this.m*target.n + target.m*this.n, this.n*target.n);
        return result;
    }

    @Override
    public int compareTo(RationalFraction o) {
        double result = (o.n * this.m - this.n * o.m) / (this.n * o.n);
        if (result < 0){
            return -1;
        } else if (result == 0){
            return 0;
        } else {
            return 1;
        }
    }
}
