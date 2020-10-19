package com.zybooks.pizzaparty;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //  Dakota J. Erdos
    //  ISYS 221 - 001
    //  Assignmnet #1 - Pizza Party Application
    //  Due: 9/10/2020

    public final int SLICES_PER_PIZZA = 8;

    private EditText mNumAttendEditText;
    private TextView mNumPizzasTextView;
    private RadioGroup mHowHungryRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumAttendEditText = findViewById(R.id.attendEditText);
        mNumPizzasTextView = findViewById(R.id.answerTextView);
        mHowHungryRadioGroup = findViewById(R.id.hungryRadioGroup);
    }

    public void calculateClick(View view) {
        String numAttendStr = mNumAttendEditText.getText().toString();
        int numAttend = 0;
        try {
            numAttend = Integer.parseInt(numAttendStr);
        } catch (NumberFormatException ex)
        {
            numAttend = 0;
        }

        // Determine how many slices on average each person will eat
        int slicesPerPerson = 0;
        int checkedId = mHowHungryRadioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.lightRadioButton) {
            slicesPerPerson = 4;
        }
        else if (checkedId == R.id.mediumRadioButton) {
            slicesPerPerson = 6;
        }
        else if (checkedId == R.id.ravenousRadioButton) {
            slicesPerPerson = 8;
        }

        int totalPizzas = (int) Math.ceil(numAttend * slicesPerPerson / (double) SLICES_PER_PIZZA);
        mNumPizzasTextView.setText("Total pizzas: " + totalPizzas);

    }
}