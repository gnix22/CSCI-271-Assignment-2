class Fraction{
    private int numerator;
    private int denominator;
    /******************************<euclidGCD>*****************************
    * Description: provides a reduced fraction based on Euclid's algorithm for 
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
    private int euclidGCD(int a, int b){
        numerator = a;
        denominator = b;
        if(numerator < 0){
            numerator = -numerator;
        }
        while(denominator != 0){
            int remainder = numerator % denominator;
            numerator = denominator;
            denominator = remainder;
        }
        if(numerator == 0){
            numerator = 1;
        }
        return numerator;
    }
}
