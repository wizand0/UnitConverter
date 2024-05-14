package ru.wizand0.unitconverter;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView textView;
    Button btnclear;

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

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        btnclear = findViewById(R.id.btnclear);
        textView = findViewById(R.id.textview);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();

                //Converting a string into double
                double kilos = 0;
                try
                {
                    kilos = Double.parseDouble(inputText);
                    editText.setText("");
                    //Converting kilos into pounds
                    double pounds = makeConversion(kilos);
                    //Display result
                    textView.setText("" + pounds + "pounds");
                }
                catch(NumberFormatException e)
                {
                    editText.setText("");
                    textView.setText("Not valid number");
                }



            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Clear result

                textView.setText("0");
                editText.setText("");


            }
        });



    }

    public double makeConversion(double kilos){
        // 1 kilo = 2.20462 pounds
        return Math.round(kilos * 2.20462 * 100.0) / 100.0;
    }


}