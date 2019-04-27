public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        } else if (denominator < 0) {
            this.numerator = numerator * -1;
            this.denominator = denominator * -1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        String result = "" + numerator + "/" + denominator;
        return result;
    }

    public double toDouble() {
        double result = numerator / denominator;
        return result;
    }

    public Fraction add(Fraction other) {
        int sumNumerator = this.numerator + other.numerator;
        int sumDenominator = this.denominator + other.denominator;
        return new Fraction(sumNumerator, sumDenominator);
    }

    public Fraction subtract(Fraction other) {
        int diffNumerator = this.numerator - other.numerator;
        int diffDenominator = this.denominator - other.denominator;
        return new Fraction(diffNumerator, diffDenominator);
    }

    public Fraction multiply(Fraction other) {
        int prodNumerator = this.numerator * other.numerator;
        int prodDenominator = this.denominator * other.denominator;
        return new Fraction(prodNumerator, prodDenominator);
    }

    public Fraction divide(Fraction other) {
        if (this.denominator == 0 || other.denominator == 0) {
            throw new IllegalArgumentException();
        } else {
            int divNumerator = this.numerator * other.denominator;
            int divDenominator = this.denominator * other.numerator;
            return new Fraction(divNumerator, divDenominator);
        }

    }

    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            if (((Fraction) other).denominator == this.denominator && ((Fraction) other).numerator == this.numerator)
                return true;
        }
        return false;
    }

    public void toLowestTerms() {
        int gcd = gcd(this.numerator, this.denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;

    }

    public static int gcd(int num, int den) {
        int remainder;
        while (num != 0 && den != 0) {
            remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
    }

}
