import java.util.ArrayList;

/**
 * This class contains the methods which determine the winner of the game
 * @author Mahima Anand
 * @version 1.2
 */


public class Winner {
    /**
     * This method counts the number of special cards that the player/dealer have.
     * @param array This method takes an ArrayList of Strings representing player/dealer cards as its parameter
     * @return this method returns the number of special cards the player/dealer has
     */

    public int specialCardCounter(ArrayList<String> array) {
        int counter = 0;
        int num;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).length()==3) {
                num = Integer.parseInt(array.get(i));
                num = num % 100;
                if (num >= 11) {
                    counter++;
                }
            }
        }
        return counter;
    }
    /**
     * This method sums up the values of the remaining cards and calculates the remainder obtained on dividing the sum by 10
     * @param array This method takes an ArrayList of Strings representing player/dealer cards as its parameter
     * @return this method returns an integer representing the remainder
     */
            public int remainderCalculator (ArrayList<String> array) {
                int sum = 0;
                int num=0;
                int remainder;
                for (int i = 0; i < array.size(); i++) {
                    num=Integer.parseInt(array.get(i));
                    num = num%100;
                    if(num<11){
                        sum+=num;
                    }

                }
                remainder = sum % 10;
                return remainder;
            }

        }

