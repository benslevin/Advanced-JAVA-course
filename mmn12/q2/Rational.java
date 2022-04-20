// Rational class with the following functions: greaterThan, equals, plus, minus, multiply, divide, toString, reduce
public class Rational {

    private int numerator;
    private int denominator;

    // Empty constructor for temp rational
    public Rational (){
        this.numerator = 0;
        this.denominator = 1;
    }

    // Constructor with input values from the user
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
        this.numerator = numerator;
        if (denominator <= 0){ // Throws exception if denominator is 0 or less
            throw new IllegalArgumentException();
        } else{
            this.denominator = denominator;
        }
    }

    // Gets & sets
    public void setDenominator(int denominator) {
        if(denominator > 0){
            this.denominator = denominator;
        }
        else {
            System.out.println("Denominator should be greater than 0");
        }
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // This function checks if this Rational number is greater than the Rational number passed as a parameter
    public boolean greaterThan(Rational other){
        if((this.numerator * other.denominator) > (this.denominator * other.numerator)){
            System.out.println(this.printRational() + " is greater than " + other.printRational());
        } else if((this.numerator * other.denominator) < (this.denominator * other.numerator)){
            System.out.println(other.printRational() + " is greater than " + this.printRational());
        } else {
            this.equals(other);
        }
        return (this.numerator * other.denominator) > (this.denominator * other.numerator); // if (ad > bc) => (a/b > c/d)
    }

    // This function checks if this Rational number is equal to the Rational number passed as a parameter
    public boolean equals (Rational other){
        if((this.numerator * other.denominator) == (this.denominator * other.numerator)) {
            System.out.println(this.printRational() + " is equal to " + other.printRational());
        }
        else{
            System.out.println(this.printRational() + " is not equal to " + other.printRational());
        }
        return (this.numerator * other.denominator) == (this.denominator * other.numerator); // if (ad = bc) => (a/b = c/d)
    }

    // Adds the Rational and the parameter
    public Rational plus(Rational other){ // a/b + c/d = (ad + bc)/bd
        int firstNumerator = (this.numerator * other.denominator);
        int secondNumerator = (this.denominator * other.numerator);
        int denominator = (this.denominator * other.denominator);
        return calc(firstNumerator, secondNumerator, denominator);
    }

    // Subs the Rational and the parameter
    public Rational minus(Rational other){ // a/b - c/d = (ad - bc)/bd
        int firstNumerator = (this.numerator * other.denominator);
        int secondNumerator = -(this.denominator * other.numerator); // The difference with the plus method is the minus operand
        int denominator = (this.denominator * other.denominator);
        return calc(firstNumerator, secondNumerator, denominator);
    }

    // This function does the calculation for the plus and minus functions
    private Rational calc (int firstNumerator, int secondNumerator, int denominator){
        this.setNumerator(firstNumerator + secondNumerator);
        this.setDenominator(denominator);
        return this;
    }

    // Multiplies the Rational and the parameter
    public Rational multiply(Rational other){ // a/b * c/d = ac/bd
        this.setNumerator(this.numerator * other.numerator);
        this.setDenominator(this.denominator * other.denominator);
        return this;
    }

    // Divides the Rational with the parameter
    public Rational divide (Rational other) throws ArithmeticException{ // ((a/b) / (c/d)) = (a/b * d/c)
        if(other.numerator == 0){ // Trying to divide by 0, throws exception
            throw new ArithmeticException();
        } else {
            int temp = other.getDenominator(); // temp = d
            other.setDenominator(other.numerator); // denominator = c
            other.setNumerator(temp); // numerator = d -> d/c
            return this.multiply(other); // Using the function multiply for less code duplication
        }
    }

    // This function uses the GCD to reduce the rational number to it's smallest display
    public Rational reduce(){
        int gcd = gcd(this.getNumerator(), this.getDenominator());
        Rational temp = new Rational();
        System.out.println("The GCD for " + this.printRational() + " is: " + gcd);
        temp.setNumerator(this.getNumerator() / gcd);
        temp.setDenominator(this.getDenominator() / gcd);
        System.out.println(this.printRational() + " After reduction is: " + temp.printRational());
        return temp;
    }

    // Finding the GCD using the Euclid's algorithm, Private function only in use for the reduce function
    private int gcd(int numerator, int denominator){
        if(denominator == 0 ){
            return numerator;
        }
        return gcd(denominator, (numerator % denominator));
    }

    // Overriding toString function from Object class to show thw output (numerator/denominator)
    @Override
    public String toString() {
        return "The Rational number is: " + numerator + "/" + denominator;
    }

    // Prints the number only - for better output
    public String printRational (){
        return numerator + "/" + denominator;
    }
}
