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
    // My guess going based on what bits of the slides we have ( and errors given by implementation), we override toString which is what println calls. 
    // This outputs the result of everything.
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
    public Fraction(long a, long b){
        a_ = a;
        b_ = b;
        gcf_ = euclidGCD(a_, b_);
    }
    public Fraction(long a){
        a_ = a;
        b_ = 1; // can eventually change just get rid of b_ = 1, but if need to call later keeping as placeholder.
        gcf_ = euclidGCD(a_,b_);
    }
    //public Fraction divide(Fraction fraction){
        
    //}
}
