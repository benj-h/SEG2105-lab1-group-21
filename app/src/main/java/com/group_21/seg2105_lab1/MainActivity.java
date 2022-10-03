package com.group_21.seg2105_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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
    // Define user-changeable values (for arithmetic operation)
    ArrayList<String> values = new ArrayList<String>();

    // Define all possible mathematical operations/states (as enum variable)
    enum Operator{
        NONE, ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUALS
    }

    Operator operator = Operator.NONE;

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

    // Button on-click logic
    public void onClick(View v) {
        switch (v.getId()) {
            // Digits:
            case R.id.button_1:
                add_number("1");
            case R.id.button_2:
                add_number("2");
            case R.id.button_3:
                add_number("3");
            case R.id.button_4:
                add_number("4");
            case R.id.button_5:
                add_number("5");
            case R.id.button_6:
                add_number("6");
            case R.id.button_7:
                add_number("7");
            case R.id.button_8:
                add_number("8");
            case R.id.button_9:
                add_number("9");
            case R.id.button_0:
                add_number("0");
            case R.id.button_decimal:
                add_number(".");
            // Operations:
            case R.id.button_add:
                operator = Operator.ADD;
                values.add(display.getText().toString());
            case R.id.button_subtract:
                operator = Operator.SUBTRACT;
                values.add(display.getText().toString());
            case R.id.button_multiply:
                operator = Operator.MULTIPLY;
                values.add(display.getText().toString());
            case R.id.button_divide:
                operator = Operator.DIVIDE;
                values.add(display.getText().toString());
            case R.id.button_equal:
                operator = Operator.EQUALS;
                perform_operation(values);
            // Miscellaneous activities:
            case R.id.button_clear:
                reset_calculator();
        }

    }
    private void add_number(String num){
        display.setText(display.getText() + num);
    }

    private double perform_operation(ArrayList<String> values) {
        double result = 0; // = 0 is TEMPORARY?
        // figure out new method for arraylist of values instead of just two
        switch (operator) {
            case NONE:
                break;
            case ADD:
                break;
            case SUBTRACT:
                break;
            case DIVIDE:
                break;
            case EQUALS:
                break;
        }
        display.setText(Double.toString(result));
        return result;
    }

    private void reset_calculator() {
        //value_1 = Double.NaN;
        //value_2 = Double.NaN;
        values = new ArrayList<String>();
        operator = Operator.NONE;
        display.setText("");
    }
}