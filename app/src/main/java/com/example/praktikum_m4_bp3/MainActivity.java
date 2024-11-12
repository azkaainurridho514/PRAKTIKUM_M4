package com.example.praktikum_m4_bp3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button hitung;
    private EditText tinggi;
    private EditText panjang;
    private EditText lebar;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         hitung = findViewById(R.id.hitung);
         tinggi = findViewById(R.id.tinggi);
         panjang = findViewById(R.id.panjang);
         lebar = findViewById(R.id.lebar);
         result = findViewById(R.id.hasil);
        hitung.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onClick(View v) {
     if(v.getId() == R.id.hitung){
         String inputPanjang = panjang.getText().toString().trim();
         String inputLebar = lebar.getText().toString().trim();
         String inputTinggi = tinggi.getText().toString().trim();
         boolean isEmptyFields = false;
         if(TextUtils.isEmpty(inputPanjang)){
             isEmptyFields = true;
             panjang.setError("Field panjang harus di isi");
         }
         if(TextUtils.isEmpty(inputLebar)){
             isEmptyFields = true;
             lebar.setError("Field lebar harus di isi");
         }
         if(TextUtils.isEmpty(inputTinggi)){
             isEmptyFields = true;
             tinggi.setError("Field panjang tinggi di isi");
         }
         if(!isEmptyFields){
             double volume = Double.valueOf(inputPanjang) * Double.valueOf(inputLebar) * Double.valueOf(inputTinggi);
             result.setText(String.valueOf(volume));
         }
     }
    }
}