package com.example.kundalias.cardvalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Map all the locators to variable
        final EditText cardNumberEditText = (EditText) findViewById(R.id.inputNumbers);
        final TextView output =(TextView) findViewById(R.id.output);
        Button checkButton = (Button) findViewById(R.id.checkButton);


        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = cardNumberEditText.getText().toString();
                int sum = 0;
                // First step of algorithm to reverse the card number
                StringBuffer buffer = new StringBuffer(input);
                buffer.reverse();
                String reverse = buffer.toString();

                // We double every other number and add both digits if its more than 9
                // we start with the 2nd digit
                for(int i = 0; i < reverse.length(); i++)
                {
                    // Add directly every odd positioned number
                    if(i % 2 == 0)
                    {
                        // To get the numeric value of Character placed at position i
                        sum = sum + Character.getNumericValue(reverse.charAt(i));
                    }
                    else
                    {
                        int odd = Character.getNumericValue(reverse.charAt(i));
                        int temp = 0;
                        Log.v("odd:",""+String.valueOf(odd));
                        odd = odd * 2;
                        Log.v("odd * 2:",""+String.valueOf(odd));
                        // add both the digits of multiplied number to add finally to sum
                        if(odd > 9)
                        {
                            Log.v("temp:",""+String.valueOf(temp));
                            temp = odd / 10;
                            Log.v("temp = odd / 10:",""+String.valueOf(temp));

                            temp = temp + (odd % 10);
                            Log.v("temp = temp+ (odd % 10)",""+String.valueOf(temp));
                            odd = temp;
                            Log.v("odd:",""+String.valueOf(odd));

                        }
                        sum = sum + odd;
                    }
                }


                //display the output
                output.setText(String.valueOf(sum));

            }
        });

    }
}