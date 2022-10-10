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
    Button button_add, button_subtract, button_multiply, button_divide, button_left_bracket, button_right_bracket, button_equal;
    // Define all buttons that correspond to miscellaneous activities
    Button button_clear, button_backspace;
    // Define calculator display
    TextView display;

    // Back End:
    // Define user-changeable values (for arithmetic operation)
    String values = "";

    // Define all possible mathematical operations/states (as enum variable)
    public enum State{
        INPUT, EVALUATE
    }

    // Initialize calculator state
    public static State state = State.INPUT;

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
        button_left_bracket = findViewById(R.id.button_left_bracket);
        button_right_bracket = findViewById(R.id.button_left_bracket);
        button_equal = findViewById(R.id.button_equal);

        // Initialize all buttons that correspond to miscellaneous activities
        button_clear = findViewById(R.id.button_clear);
        button_backspace = findViewById(R.id.button_backspace);

        // Initialize calculator display
        display = findViewById(R.id.display);

        }

    // Button on-click logic
    public void onClick(View v) {
        switch (v.getId()) {
            // Digits:
            case R.id.button_1:
                values = values + "1";
            case R.id.button_2:
                values = values + "2";
            case R.id.button_3:
                values = values + "3";
            case R.id.button_4:
                values = values + "4";
            case R.id.button_5:
                values = values + "5";
            case R.id.button_6:
                values = values + "6";
            case R.id.button_7:
                values = values + "7";
            case R.id.button_8:
                values = values + "8";
            case R.id.button_9:
                values = values + "9";
            case R.id.button_0:
                values = values + "0";
            case R.id.button_decimal:
                values = values + ".";
            // Operations:
            case R.id.button_add:
                values = values + "+";
            case R.id.button_subtract:
                values = values + "-";
            case R.id.button_multiply:
                values = values + "*";
            case R.id.button_divide:
                values = values + "/";
            case R.id.button_equal:
                state = State.EVALUATE;
                process_expression(values);
            // Miscellaneous activities:
            case R.id.button_clear:
                reset_calculator();
        }
        display.setText(values);
    }

    private boolean is_first_char_number(String values) {
        double test;
        try {
            test = (double)values.charAt(0);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void process_expression(String values) {
        double result;
        result = Evaluator.evaluate_expression(values);
        values = Double.toString(result);
        display.setText(Double.toString(result));
    }

    private void clear_display() {
        display.setText(R.string.View_textbox_text);
    }

    private void reset_calculator() {
        values = "";
        clear_display();
    }

    public static State get_state() {
        return state;
    }
}