package com.urangcoding.persegipanjang;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText input_panjang, input_lebar, input_tinggi;
    private TextView txt_hasil;
    private Button btn_volume;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_panjang = findViewById(R.id.input_panjang);
        input_lebar = findViewById(R.id.input_lebar);
        input_tinggi = findViewById(R.id.input_tinggi);
        btn_volume = findViewById(R.id.btn_volume);
        txt_hasil = findViewById(R.id.hasil);

        btn_volume.setOnClickListener(view -> {
            String panjang = input_panjang.getText().toString();
            String lebar = input_lebar.getText().toString();
            String tinggi = input_tinggi.getText().toString();

            if (panjang.isEmpty()) {
                input_panjang.setError(getResources().getString(R.string.error_message_panjang));
                input_panjang.requestFocus();
                return;
            }

            if (lebar.isEmpty()) {
                input_lebar.setError(getResources().getString(R.string.error_message_lebar));
                input_lebar.requestFocus();
                return;
            }

            if (tinggi.isEmpty()) {
                input_tinggi.setError(getResources().getString(R.string.error_messaage_tinggi));
                input_tinggi.requestFocus();
                return;
            }

            int volume = Integer.parseInt(panjang) * Integer.parseInt(lebar) * Integer.parseInt(tinggi);

            txt_hasil.setText(getResources().getString(R.string.txt_title) + " : " + volume + "cm3");
        });

    }
}