package br.ulbra.appconversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText metros, pes, celsius, fahrenheit, quilograma, libra;
    Button btnComprimento, btnTemperatura, btnPeso;
    TextView ed1, ed2, ed3, ed4, ed5, ed6;
    double m, p, c, f, q, l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        metros = (EditText) findViewById(R.id.editMetro);
        pes = (EditText) findViewById(R.id.editPes);
        celsius = (EditText) findViewById(R.id.editCelsius);
        fahrenheit = (EditText) findViewById(R.id.editFahrenheit);
        quilograma = (EditText) findViewById(R.id.editQuilograma);
        libra = (EditText) findViewById(R.id.editLibra);
        btnComprimento = (Button) findViewById(R.id.btnConverterComprimento);
        btnComprimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((pes.getText().toString().equals("")) && (metros.getText().toString().equals(""))) {
                    Toast toast = Toast.makeText(getApplicationContext(),"Preencha um dos valores",Toast.LENGTH_LONG);
                    toast.show();
                }else  if (pes.getText().toString().equals("") && !(metros.getText().toString().equals(""))) {
                    m = Double.parseDouble(metros.getText().toString());
                    p = m * 3.28084;
                    pes.setText(Double.toString(p));
                } else {
                    p = Double.parseDouble(pes.getText().toString());
                    m = p / 3.28084;
                    metros.setText(Double.toString(m));
                }
            }
        });

        btnTemperatura = (Button) findViewById(R.id.btnConverterTemperatura);
        btnTemperatura.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if ((celsius.getText().toString().equals("")) && (fahrenheit.getText().toString().equals(""))){
                    Toast toast = Toast.makeText(getApplicationContext(),"Preencha um dos valores", Toast.LENGTH_LONG);
                    toast.show();
                }else if (!(celsius.getText().toString().equals("")) && (fahrenheit.getText().toString().equals(""))){
                    c = Double.parseDouble(celsius.getText().toString());
                    f = (c*9/5)+32;
                    fahrenheit.setText(Double.toString(f));
                }else {
                    f = Double.parseDouble(fahrenheit.getText().toString());
                    c = (f-32)*5/9;
                    celsius.setText(Double.toString(c));
                }
            }
        });

        btnPeso = (Button) findViewById(R.id.btnPeso);
        btnPeso.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if ((quilograma.getText().toString().equals("")) && (libra.getText().toString().equals(""))){
                    Toast toast = Toast.makeText(getApplicationContext(),"Preencha um dos valores", Toast.LENGTH_LONG);
                    toast.show();
                }else if (!(quilograma.getText().toString().equals("")) && (libra.getText().toString().equals(""))){
                    q = Double.parseDouble(quilograma.getText().toString());
                    l = q*2.20462;
                    libra.setText(Double.toString(l));
                }else {
                    l = Double.parseDouble(libra.getText().toString());
                    q = l/2.20462;
                    quilograma.setText(Double.toString(q));
                }
            }
        });
    }
}