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
public class CSCI_271_Garrett_Nix_Assignment_2_Main {
    /******************************<main>*****************************
    * Description: Main function that tests fraction class 
    *
    * Parameters: args - cmd line arguments 
    *
    * Pre: successful compilation must happen before main runs 
    *
    * Post: tested results for fraction class will be obtained 
    *
    * Returns: none 
    *
    * Called by: none 
    * Calls: add, multiply, divide, pow, negate
    ************************************************************************/
    public static void main(String[] args) {
        Fraction a = new Fraction(16); // construct new fraction objects.
        Fraction d = new Fraction(0,0);
        Fraction b = new Fraction(3,5).add(new Fraction(7));
        Fraction c = new Fraction(6,7);
        Fraction results = c.multiply(a.divide(b));
        Fraction results2 = c.pow(3); // output should be 216/343.
        Fraction results3 = c.pow(2).multiply(a.divide(b).add(a)).negate(); // fun function that should output something.
        System.out.println(d);
        System.out.println(results);
        System.out.println(results2);
        System.out.println(results3);
    }
}
