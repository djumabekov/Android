package com.example.hw1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout phoneInputLayout;
    private TextInputEditText phoneEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phoneInputLayout = findViewById(R.id.phoneInputLayout);
        phoneEditText = findViewById(R.id.phoneEditText);
        registerButton = findViewById(R.id.registerButton);
    }

    public void registerButtonClicked(View view) {
        String phoneNumber = phoneEditText.getText().toString().trim();

        if (validatePhoneNumber(phoneNumber)) {
            Toast.makeText(this, "Телефонный номер корректный", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 8) {
            phoneInputLayout.setError("Телефонный номер должен содержать не менее 8 цифр");
            return false;
        } else {
            phoneInputLayout.setError(null);
            return true;
        }
    }
}
