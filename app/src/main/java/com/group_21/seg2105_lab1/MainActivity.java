package com.group_21.seg2105_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // Front End:
    // Define all buttons that correspond to digits
    Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_0, button_decimal;
    // Define all buttons that correspond to mathematical operations
    Button button_add, button_subtract, button_multiply, button_divide, button_radix, button_left_bracket, button_right_bracket, button_equal;
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
        button_1 = findViewById(R.id.btn1);
        button_2 = findViewById(R.id.btn2);
        button_3 = findViewById(R.id.btn3);
        button_4 = findViewById(R.id.btn4);
        button_5 = findViewById(R.id.btn5);
        button_6 = findViewById(R.id.btn6);
        button_7 = findViewById(R.id.btn7);
        button_8 = findViewById(R.id.btn8);
        button_9 = findViewById(R.id.btn9);
        button_0 = findViewById(R.id.btn0);

        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_0.setOnClickListener(this);

        // Initialize all buttons that correspond to mathematical operations
        button_add = findViewById(R.id.btnAdd);
        button_subtract = findViewById(R.id.btnSubstract);
        button_multiply = findViewById(R.id.btnMultiply);
        button_divide = findViewById(R.id.btnDivide);
        button_radix = findViewById(R.id.btnRadix);
        button_left_bracket = findViewById(R.id.btnBracketsOpen);
        button_right_bracket = findViewById(R.id.btnBracketsClosed);
        button_equal = findViewById(R.id.btnEquals);

        button_add.setOnClickListener(this);
        button_subtract.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_radix.setOnClickListener(this);
        button_left_bracket.setOnClickListener(this);
        button_right_bracket.setOnClickListener(this);
        button_equal.setOnClickListener(this);

        // Initialize all buttons that correspond to miscellaneous activities
        button_clear = findViewById(R.id.btnClear);
        button_backspace = findViewById(R.id.btnBackspace);

        button_clear.setOnClickListener(this);
        button_backspace.setOnClickListener(this);

        // Initialize calculator display
        display = (TextView) findViewById(R.id.textbox);
        setPlaceholder();
    }

    // Button on-click logic
    @Override
    public void onClick(View v) {
        // TODO: Add edge when display.getText().equals(R.id.View_textbox_text) to set the string instead of concat
        switch (v.getId()) {
            // Digits:
            case R.id.btn1:
                values = values + "1";
                break;
            case R.id.btn2:
                values = values + "2";
                break;
            case R.id.btn3:
                values = values + "3";
                //Toast.makeText(this, values, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn4:
                values = values + "4";
                break;
            case R.id.btn5:
                values = values + "5";
                break;
            case R.id.btn6:
                values = values + "6";
                break;
            case R.id.btn7:
                values = values + "7";
                break;
            case R.id.btn8:
                values = values + "8";
                break;
            case R.id.btn9:
                values = values + "9";
                break;
            case R.id.btn0:
                values = values + "0";
                break;
            case R.id.btnRadix:
                values = values + ".";
                break;
            // Operations:
            case R.id.btnAdd:
                values = values + "+";
                break;
            case R.id.btnSubstract:
                values = values + "-";
                break;
            case R.id.btnMultiply:
                values = values + "*";
                break;
            case R.id.btnDivide:
                values = values + "/";
                break;
            case R.id.btnEquals:
                state = State.EVALUATE;
                process_expression(values);
                break;
            // Miscellaneous activities:
            case R.id.btnClear:
                reset_calculator();
                break;
            case R.id.btnBackspace:
                remove_last_character();
                break;
        }
        display.setText(values);
    }
    

    private void process_expression(String expr) {
        double result;
        result = Evaluator.evaluate_expression(expr);
        values = Double.toString(result);
    }

    private void setPlaceholder() { display.setText(R.string.View_textbox_text); }


    private void reset_calculator() {
        values = "";
    }

    private void remove_last_character() {
        if (values.length() > 0) {
            values = values.substring(0, values.length() - 1);
        }
    }

    public static State get_state() {
        return state;
    }
}