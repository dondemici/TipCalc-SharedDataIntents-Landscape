package com.example.android_finals_practice1;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private Button submitBtn, buttonDec, buttonInc;
    private EditText editTotalBill, editTextName;
    private float tipPercent = .15f;
    private TextView percentAmount, tipPercentage, totalBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitBtn = findViewById(R.id.submitBtn);
        buttonDec = findViewById(R.id.buttonDec);
        buttonInc = findViewById(R.id.buttonInc);
        editTotalBill = findViewById(R.id.editTotalBill);
        tipPercentage = findViewById(R.id.tipPercentage);
        percentAmount = findViewById(R.id.percentAmount);
        editTextName = findViewById(R.id.editTextName);
        totalBill = findViewById(R.id.Total_Bill);

        // Display the initial tip percentage
        updateTipDisplay();

        // Button click listeners
        buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Decrease tip percentage
                tipPercent = tipPercent - .01f;
                updateTipDisplay();
            }
        });

        buttonInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Increase tip percentage
                tipPercent = tipPercent + .01f;
                updateTipDisplay();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                    try {
                        // Get text from EditTexts and convert to float
                        String name = editTextName.getText().toString();
                        float totalBill = Float.parseFloat(editTotalBill.getText().toString());
                        // Perform calculation
                        float monthlyPayment = totalBill + (totalBill * tipPercent);
                        // Pass result to second activity
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("mPayment", String.format("%.2f", monthlyPayment)); // Optional: format to 2 decimals
                        intent.putExtra("name", name);
                        startActivity(intent);
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Please enter valid numbers.", Toast.LENGTH_SHORT).show();
                    }
                }

        });
    }
    // Method to update tip percentage and amount
    private void updateTipDisplay() {
        // Format the percentage and amount
        NumberFormat percent = NumberFormat.getPercentInstance();
        tipPercentage.setText(percent.format(tipPercent));

        // Calculate the tip amount and update the percentAmount TextView
        String billText = editTotalBill.getText().toString();
        if (!billText.isEmpty()) {
            float totalBillValue = Float.parseFloat(billText);
            float tipAmount = totalBillValue * tipPercent;
            percentAmount.setText(String.format("%.2f", tipAmount)); // Show tip amount with 2 decimal places
            // Also display the total bill value
            totalBill.setText("Total Bill: " + String.format("%.2f", totalBillValue+(totalBillValue * tipPercent))); // Set the total bill in the TextView
        }
    }
}



