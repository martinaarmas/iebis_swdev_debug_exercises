import com.sun.tools.jdi.SocketAttachingConnector;

import java.sql.SQLOutput;

/**
 * A class that analyzes words.
 */
public class WordAnalyzer{

    /**
     * Constructs an analyzer for a given word.
     * @param aWord the word to be analyzed
     */
    public WordAnalyzer(String aWord)
    {
        word = aWord;
    }

    /**
     * Gets the first repeated character. A character is <i>repeated</i>
     * if it occurs at least twice in adjacent positions. For example,
     * 'l' is repeated in "hollow", but 'o' is not.
     * @return the first repeated character, or 0 if none found
     */
    public char firstRepeatedCharacter()
    {
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            /**
             * 2.
             * we need to add this line of code so when there are no repeated characters
             * the program knows what to do.
             * In this case print [] so the Exception is not sent.
             */

            if ((i+1) == word.length()){ // Si ningun character se repite pasa esto
                return 0;
            }else
            {

                if (ch == word.charAt(i + 1))
                    return ch;
            }
        }
        return 0;


    }
    /**
     * Gets the first multiply occuring character. A character is <i>multiple</i>
     * if it occurs at least twice in the word, not necessarily in adjacent positions.
     * For example, both 'o' and 'l' are multiple in "hollow", but 'h' is not.
     * @return the first repeated character, or 0 if none found
     */
    public char firstMultipleCharacter()
    {
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            if (find(ch, i) >= 0)
                return ch;
        }
        return 0;
    }

    private int find(char c, int pos)
    {
        //1.
        // We need to add 1 to pos because if not the first letter or the char that is written
        // in  if (find(ch, i) >= 0) first multiple character method is always going to be the value of pos.
        for (int i = pos + 1; i < word.length(); i++)
        {
            if (word.charAt(i) == c)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Counts the groups of repeated characters. For example, "mississippi!!!" has
     * four such groups: ss, ss, pp and !!!.
     * @return the number of repeated character groups
     */
    public int countGroupsRepeatedCharacters() {
        int c = 0;
        /** As the loop starts in int i=1 it does not check repeated characters in the first two chars
         * Therefore we have to change the condition to i=0 so it checks the first chars/
         */

        for (int i = 0; i < word.length() - 1; i++)
        /**
         * Now, the program shows a thread Exception so we need to add an if
         that tells the program what to do if the two first chars are not equal.
         */
            if (word.charAt(i) == word.charAt(i + 1)) // found a repetition
            {
                if (i != 0) {
                    if (word.charAt(i - 1) != word.charAt(i)) // it't the start
                        c++;
                } else
                {
                    c++;
                }
            }

        return c;
    }


    private String word;
}