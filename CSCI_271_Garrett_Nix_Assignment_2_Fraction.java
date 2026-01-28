class Fraction{
    private long a_;
    private long b_;
    private long gcf_;
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
    // My guess going based on what bits of the slides we have, we override toString which is what println calls. 
    // This outputs the result of everything.
    @Override
    public String toString(){
        String a = a_+""; // found you can coerce long to string
        String b = b_+"";
        String resultString = a + "/" + b;
        return resultString;
    }
    public Fraction(long a, long b){
        a_ = a;
        b_ = b;
        gcf_ = euclidGCD(a_, b_);
        System.out.println("gcf is " + gcf_);
        System.out.println("a is " + a_);
        System.out.println("b is " + b_);
        a_ /= gcf_;
        b_ /= gcf_;
        System.out.println("a is " + a_);
        System.out.println("b is " + b_);
    }
}
