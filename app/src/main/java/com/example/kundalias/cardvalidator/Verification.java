package com.example.kundalias.cardvalidator;

import android.util.Log;

/**
 * Created by Abhishek on 9/5/2016.
 * This class verifies whether the card number is valid or not
 */
public class Verification {

    private String input;
    /**
     * Constructor
     */
    public boolean VerifyCard(String inputText)
    {
        this.input = inputText;
        int sum = 0;
        // First step of algorithm to reverse the card number
        StringBuffer buffer = new StringBuffer(input);
        buffer.reverse();
        String reverse = buffer.toString();

        // We double every other number and add both digits if its more than 9
        // we start with the 2nd digit
        for(int i = 0; i < reverse.length(); i++)
        {
            int digit = Character.getNumericValue(reverse.charAt(i));
            int temp;

            // Add directly every odd positioned number
            if(i % 2 == 0)
            {
                // To get the numeric value of Character placed at position i
                sum = sum + digit;
            }
            else
            {
                temp = 0;
                // double the digit value
                digit = digit * 2;

                // add both the digits of multiplied number to add finally to sum
                if(digit > 9)
                {
                    // Store the first digit of the multiplied value
                    temp = digit / 10;

                    //Add the second digit with the first digit stored
                    digit = temp + (digit % 10);
                }

                //Add the value to the sum value
                sum = sum + digit;
            }
        }

        //Validate if the verification was successful or not
        if ((sum != 0) && (sum % 10 == 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
