package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */

    //DONE
    public Integer countYZ(String input) {
        //Initialize a counter variable
        Integer counter = 0;
        //Split string into an array to access individual index easier
        String[] inputArr = input.split(" ");
        //run through each array index and check if last char = y or z
        for (String index : inputArr) {
            if (index.charAt(index.length() - 1) == 'y' || index.charAt(index.length() - 1) == 'z') {
                //if true, adds 1 to counter
                counter++;
            }
        }

        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */


    public String removeString(String base, String remove) {
        //Initialize a String to assign the new string
        //Uses replace method to replace String Remove with empty spaces

        String replacedStr = base.replace(remove, "");

        return replacedStr;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        //Initialize count variables to compare # of "is" and "not"
        int counterIs = countOccurances(input, "is");
        int counterNot = countOccurances(input, "not");
        //Find index of both "is" and "not" using String.indexOf()


        return counterIs == counterNot;
    }

    private int countOccurances(String input, String stringToCount) {
        //Initialize variable
        int counter = 0;
        int index = 0;

        while (true) {
            index = input.indexOf(stringToCount, index);

            if (index == -1) {
                break;
            } else {
                counter++;
                index += stringToCount.length();
            }


        }
        return counter;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        boolean happy = false;
        int counter = countOccurances(input, "g");

        if (counter >= 2) {
            happy = true;
        }
        return happy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        //Initialize variables
        int counter = 0;
        //convert string to char array
        char[] inputCharArray = input.toCharArray();
        //for loop running through char array
        for (int i = 0; i < inputCharArray.length - 1; i++) {

            //if statement to check if i[0] == i[1] etc.
            if(inputCharArray[i] == inputCharArray[i + 1]) {
                //if true = add 1 to i
                i++;
                //if statement to check if i[1] == i[2] if yes add 1 to counter
                if(inputCharArray[i] == inputCharArray[i + 1]) {
                    counter++;
                }
                //Integer actual = stringsAndThings.countTriple("xxxabyyyycd");
                //need to subtract 1 from i to normalize and continue loop
                i--;

            }

        }
        return counter;
    }
}
