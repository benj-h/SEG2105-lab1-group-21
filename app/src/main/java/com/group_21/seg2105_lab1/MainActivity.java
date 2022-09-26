package com.example.seg2105_lab1_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // Front End:
    // Define all buttons that correspond to digits
    Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_0, button_decimal;
    // Define all buttons that correspond to mathematical operations
    Button button_add, button_subtract, button_multiply, button_divide, button_equal;
    // Define all buttons that correspond to miscellaneous activities
    Button button_clear;
    // Define calculator display
    TextView display;

    // Back End:
    // Define user-changeable values (for mathematic operation)
    double value_1, value_2;

    // Define all possible mathematical operations (as enum variable)
    enum Operator{
        none, add, subtract, multiply, divide
    }

    Operator operator = Operator.none;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize all buttons that correspond to digits
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_0 = findViewById(R.id.button_0);

        // Initialize all buttons that correspond to mathematical operations
        button_add = findViewById(R.id.button_add);
        button_subtract = findViewById(R.id.button_subtract);
        button_multiply = findViewById(R.id.button_multiply);
        button_divide = findViewById(R.id.button_divide);
        button_equal = findViewById(R.id.button_equal);

        // Initialize all buttons that correspond to miscellaneous activities
        button_clear = findViewById(R.id.button_clear);

        // Initialize calculator display
        display = findViewById(R.id.display);



    }
}