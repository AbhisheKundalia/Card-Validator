package com.example.kundalias.cardvalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


        //Listen for the button click
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = cardNumberEditText.getText().toString();
                Verification verification = new Verification();
                boolean isValidCard = verification.VerifyCard(input);

                //display the output
                if(isValidCard)
                {
                    output.setText(R.string.valid_card);
                }
                else
                {
                    output.setText(R.string.invalid_card);
                }
            }
        });

    }
}