/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        String str2 = statement.trim();
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative? Be Positive!!";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (statement.indexOf("dog") >= 0
                || statement.indexOf("cat") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (statement.indexOf("Mr.") >= 0)
        {
            response = "He sounds like a good teacher.";
        }
        else if (statement.indexOf("Ms.") >= 0
                || statement.indexOf("Mrs.") >= 0)
        {
           response = "She sounds like a good teacher.";
        }
        else if (str2.equals("")){
            response = "Say something, please. ";
        }
        else if (statement.indexOf("tired") >= 0)
        {
            response = "Take a rest!";
        }
        else if (statement.indexOf("school") >= 0)
        {
            response = "Yeah school is tough, sorry for you...";
        }
        else if (statement.indexOf("math") >= 0)
        {
            response = "Oh do you like math? Wonderful!";
        }
        else if (statement.indexOf("I want to") >= 0)
        {
            System.out.println(transformIWantToStatement(statement));
        }
        else if (statement.indexOf("I want") >= 0)
        {
            System.out.println(transformIWantStatement(statement));
        }
        
        else if (statement.indexOf("I like you") >= 0)
        {
            System.out.println(transformIYouStatement(statement));
        }
        else if (statement.indexOf("Do you like me?") >= 0)
        {
            System.out.println(transformYouMeStatement(statement));
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "That's cool.";
        }
        else if (whichResponse == 5)
        {
            response = "Hm I see.";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
    str = " " + str.toLowerCase() + " ";
    word = " " + word.toLowerCase() + " ";

    return str.indexOf(word);
}

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        String str1 = "";
        if (statement.indexOf("I want") >= 0)
        {
            str1 = statement.substring(7);
        }
        return "Would you really be happy if you had "+ str1 + "?";
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        if (statement.indexOf("I like you") >= 0)
        {
           return "Why do you like me?";
        }
        else{
            return "";
        }
    }
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        String str1 = "";
        if (statement.indexOf("I want to") >= 0)
        {
            str1 = statement.substring(9);
        }
        return "What would it mean to"+ str1 + "?";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        if (statement.indexOf("Do you like me?") >= 0)
        {
           return "What makes you think that I like you?";
        }
        else{
            return "";
        }
    }
}
