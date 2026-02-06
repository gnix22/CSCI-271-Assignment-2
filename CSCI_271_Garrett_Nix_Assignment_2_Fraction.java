/**************************************************************************
* Project 2 for CSCI 271-001 Spring 2026
* Author: Garrett Nix 
* OS: NixOS 25.11 
* Compiler: javac 25.0.1 
* Date: Feb. 03, 2026 
* Purpose
* This program implements and tests a fraction class, creating ease of application
* in future works.
**************************************************************************/
/********************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Garrett Nix 
********************************************************************/
class Fraction{
    private long a_;
    private long b_;
    private long gcf_;
    /******************************<Fraction>*****************************
    * Description: Constructor methods for fractions 
    *
    * Parameters: 
    *   a: Long integer acts as numerator.
    *   b: Long integer acts as denominator.
    * Pre: A variable of type Fraction must be declared with either a numerator
    * and denominator.
    *
    * Post: A fraction will be created, allowing for methods to be called for 
    * arithmetic operations.
    *
    * Returns: None 
    *
    * Called by: list function(s) that call this one 
    * Calls: list function(s) that this one calls 
    ************************************************************************/
    public Fraction(long a, long b){
        a_ = a;
        b_ = b;
        gcf_ = euclidGCD(a_, b_);
    }
    public Fraction(long a){
        a_ = a;
        b_ = 1; // if b is not specified upon construction, default to 1.
        gcf_ = euclidGCD(a_,b_);
    }
    /******************************<euclidGCD>*****************************
    * Description: provides greatest common denominator based on Euclid's algorithm for 
    * finding the greatest common denominator.
    *
    * Parameters: 
    *   a: integer that acts as the numerator
    *   b: integer that acts as denominator
    * Pre: list the preconditions 
    *
    * Post: list the postconditions 
    *
    * Returns: describe what value the function returns 
    *
    * Called by: list function(s) that call this one 
    * Calls: list function(s) that this one calls 
    ************************************************************************/
    private long euclidGCD(long a, long b){
        if(a < 0){
            a = -a;
        }
        while(b != 0){
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        if(a == 0){
            a = 1;
        }
        return a;
    }
    // My guess going based on what bits of the slides we have ( and errors given by implementation), we override toString which is what println calls. 
    // This outputs the result of everything.
    /******************************<toString>*****************************
    * Description: Override of toString function that is typically called by println() 
    *
    * Parameters: none 
    *
    * Pre: system.out.println() needs to be called
    *
    * Post: this function will be called in place of the typical method String calls 
    *
    * Returns: string containing fraction string 
    *
    * Called by: main() 
    * Calls:  
    ************************************************************************/
    @Override
    public String toString(){
        a_ /= gcf_;
        b_ /= gcf_;
        String a = a_+""; // found you can coerce long to string
        String b = b_+"";
        String resultString;
        try{
            // checks whether or not b_ = 1 or 0 by throwing exception if not.
            long dividerCheck = a_/b_;
            if(dividerCheck == a_){
                resultString = a;
            } else{
                resultString = a + "/" + b;
            }
        } catch(ArithmeticException e){
            // if a is pos, oo, if -a, -oo, a==0, NaN
            if(a_ > 0){
                resultString = "Infinity";
            } else if(a_ < 0) {
                resultString = "-Infinity";
            } else {
                resultString = "NaN";
            }
        }
        return resultString;
    }
    /******************************<multiply>*****************************
    * Description: Multiplies two fractions together. 
    *
    * Parameters: 
    *   fraction: Fraction object consisting of fields within class.
    *
    * Pre: Two objects of type Fraction must be constructed in order to 
    * perform the operation.
    *
    * Post: A new fraction object will be created based on the multiplication
    *
    * Returns: Fraction object consisting of resulting numerator and denominator
    *
    * Called by: main() 
    * Calls: none 
    ************************************************************************/
    public Fraction multiply(Fraction fraction){
        // use convention of algebraic laws to show that 
        // (a/b)*(c/d) = ac / bd as new frac
        long c = fraction.a_; // numerator of arg fraction
        long d = fraction.b_; // denom of arg fraction
        long numerator = a_ * c; // resulting numerator after multiplication
        long denominator = b_ * d; // resulting denom after multiplication
        return new Fraction(numerator, denominator);
    }
    /******************************<divide>*****************************
    * Description: divides two fractions together. 
    *
    * Parameters: 
    *   fraction: Fraction object consisting of fields within class.
    *
    * Pre: Two objects of type Fraction must be constructed in order to 
    * perform the operation.
    *
    * Post: A new fraction object will be created based on the division
    *
    * Returns: Fraction object consisting of resulting numerator and denominator
    *
    * Called by: main() 
    * Calls: none 
    ************************************************************************/
    public Fraction divide(Fraction fraction){
        // use convention of algebraic laws to show that 
        // (a/b)/(c/d) = ad / bc as new frac
        long c = fraction.a_; // numerator of arg fraction
        long d = fraction.b_; // denom of arg fraction
        long numerator = a_ * d; // resulting numerator
        long denominator = b_ * c; // resulting denom
        return new Fraction(numerator, denominator);
    }
    /******************************<add>*****************************
    * Description: adds two fractions together 
    *
    * Parameters: 
    *   fraction: a fraction to be passed in
    *
    * Pre: two fractions need to be constructed, and the method need to be called 
    *
    * Post: a new fraction will be obtained with the result of adding two fractions 
    *
    * Returns: a fraction object with the resulting numerator and denominator
    *
    * Called by: main() 
    * Calls: none
    ************************************************************************/
    public Fraction add(Fraction fraction){
        long c = fraction.a_; // numerator of fraction being added
        long d = fraction.b_; // denom of fraction being added
        long denominator = b_; // if b and d are equal, either can be chosen as denom as it doesn't matter 
        long numerator = a_ + c; // simply add to find numerator if denom is same between frac
        // if denoms are diff, need to find gcd
        if(b_ != d){
            // for lcm, ensure pos vals
            if(b_ < 0){
                b_ *= -1;
            } else if(d < 0){
                d *= -1;
            }
            denominator = (b_ * d) / euclidGCD(b_,d); // lcm calculation
            numerator = d * a_ + b_ * c;
        }
        return new Fraction(numerator, denominator);
    }
    /******************************<subtract>*****************************
    * Description: subtracts two fractions  
    *
    * Parameters: 
    *   fraction: a fraction to be passed in
    *
    * Pre: two fractions need to be constructed, and the method need to be called 
    *
    * Post: a new fraction will be obtained with the result of subtracting two fractions 
    *
    * Returns: a fraction object with the resulting numerator and denominator
    *
    * Called by: main() 
    * Calls: none
    ************************************************************************/
    public Fraction subtract(Fraction fraction){
        long c = fraction.a_;
        long d = fraction.b_;
        long denominator = b_; // if b and d are equal, either can be chosen as denom as it doesn't matter 
        long numerator = a_ - c;
        // if denoms are diff, need to find gcd
        if(b_ != d){
            // for lcm, ensure pos vals
            if(b_ < 0){
                b_ *= -1;
            } else if(d < 0){
                d *= -1;
            }
            denominator = (b_ * d) / euclidGCD(b_,d); // lcm calculation
            numerator = d * a_ - b_ * c;
        }
        return new Fraction(numerator, denominator);
    }
    /******************************<pow>*****************************
    * Description: Exponentiates a fraction
    *
    * Parameters:
    *   int n - number of times to multiply fraction by itself
    *
    * Pre: a valid fraction object must be constructed in order to exponentiate it.
    *
    * Post: an exponentiated fraction will be obtained in the form of another fraction object.
    *
    * Returns: a new fraction object is returned with exponentiated values.
    *
    * Called by: main()
    * Calls: none
    ************************************************************************/
    public Fraction pow(int n){
        long a = a_; // temp values to exponentiate.
        long b = b_; // same as a.
        for(int i=0; i < n-1; i++){
            a *= a_;
            b *= b_;
        }
        return new Fraction(a, b);
    }
    /******************************<negate>*****************************
    * Description: negates the value of a fraction 
    *
    * Parameters: none 
    *
    * Pre: a positive or negative fraction must be created and the method 
    * negate must be called 
    *
    * Post: the negation of the fraction will be obtained
    *
    * Returns: the negation of the current fraction
    *
    * Called by: main()
    * Calls: multiply
    ************************************************************************/
    public Fraction negate(){
        return new Fraction(a_,b_).multiply(new Fraction(-1));
    }
}
