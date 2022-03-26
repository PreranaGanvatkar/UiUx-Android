package com.prerana.uiux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    private ConstraintLayout clWelcome;
    private TextView txtLogin,txtSignup,txtPasswordForgot;
    private Button btnSubmit;
    private TextInputLayout edt_Confirm;
    private boolean isSignUp=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_UiUx);
        setContentView(R.layout.activity_main);

        clWelcome = findViewById(R.id.cl_Welcome);
        txtLogin = findViewById(R.id.txtLogin);
        txtSignup = findViewById(R.id.txtSignup);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtPasswordForgot = findViewById(R.id.txtForgot);
        edt_Confirm = findViewById(R.id.edt_Confirm);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtLogin.setBackground(getResources().getDrawable(R.drawable.text_selected));
                txtLogin.setTextColor(getResources().getColor(R.color.white));
                txtLogin.setElevation(4);
                txtSignup.setElevation(0);

                txtSignup.setBackground(getResources().getDrawable(R.drawable.text_unselected));
                txtSignup.setTextColor(getResources().getColor(R.color.Red));

                btnSubmit.setText("Log in");
                txtPasswordForgot.setVisibility(View.VISIBLE);
                edt_Confirm.setVisibility(View.GONE);

            }
        });

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtLogin.setBackground(getResources().getDrawable(R.drawable.text_unselected));
                txtLogin.setTextColor(getResources().getColor(R.color.Red));
                txtLogin.setElevation(0);
                txtSignup.setElevation(4);

                txtSignup.setBackground(getResources().getDrawable(R.drawable.text_selected));
                txtSignup.setTextColor(getResources().getColor(R.color.white));

                btnSubmit.setText("SignUp");
                txtPasswordForgot.setVisibility(View.GONE);
                edt_Confirm.setVisibility(View.VISIBLE);

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSignUp){
                    Toast.makeText(MainActivity.this, "Signing Up!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        clWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clWelcome.setVisibility(View.GONE);
            }
        });



    }
}